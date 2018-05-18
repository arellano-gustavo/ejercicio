package mx.com.itam.adsi.ejercicio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;

import javazoom.jl.player.Player;

public class Alarm {
    private static final String alarm = "/Users/garellano/development/code/binance-core/src/main/resources/alarm.mp3";
    
    public static void main(String...argv) {
        detect();
    }
    static double  counter = 0;
    public static void detect() {
        final double minor = 8103.00;
        final double mayor = 8106.00;    
        
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
        BinanceApiWebSocketClient client = factory.newWebSocketClient();
        client.onAggTradeEvent("btcusdt", response -> {
            String price = response.getPrice();
            String quantity = response.getQuantity();
            boolean ev = response.isBuyerMaker();
            String evento = ev?"compra":"venta";
            
            double priceUSD = Double.parseDouble(price);
            double quantityUSD = Double.parseDouble(quantity);
            double valor = priceUSD * quantityUSD;
            counter = ev?counter-valor:counter+valor;
            //System.out.println("precio:"+ priceUSD + "  cantidad:"+ quantity + "  direccion: " + evento + " acumulado: " + counter);
            
            /**/
            Music music = new Music();
            if(priceUSD<minor || priceUSD>mayor) {
                System.out.println("------->"+priceUSD + "  [" + evento + "]");
                if(!music.isAlive()) {
                    music.start();
                }
            } else {
                if(music.isAlive()) {
                    music.interrupt();
                    music = null;
                    System.gc();
                } 
                System.out.println(priceUSD + "  [" + evento + "]");
            }
            /**/
        });
    }

    
    
    
    
    
    
    private static Thread createHilo() {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                go();
            }
        });
        return hilo;
    }
    
    public static void go() {
        try {
            playMusic(alarm);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void playMusic(String filename) throws Exception {
        FileInputStream fis     = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);
        Player player = new Player(bis);
        player.play();
    }
   
}
