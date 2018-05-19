package mx.com.itam.adsi.ejercicio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music extends Thread {
    //http://mobile63.com/loud-alarm-tones-download/
    private static final String alarm = "/Users/garellano/development/code/binance-core/src/main/resources/alarm2.mp3";

    public void run2() {
            try {
                    FileInputStream fileInputStream = new FileInputStream(alarm);
                    Player player = new Player(fileInputStream);
                    player.play();
            }catch(FileNotFoundException e) {
                e.printStackTrace();
            }catch(JavaLayerException e) {
                e.printStackTrace();
            }

    }   
    
    public void run() {
        for(int i=0; i<5; i++)
            try {
                tone(400,250,1);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
    }
    public static float SAMPLE_RATE = 8000f;
    
    public static void tone(int hz, int msecs, double vol) throws LineUnavailableException {
        byte[] buf = new byte[1];
        AudioFormat af = 
            new AudioFormat(
                SAMPLE_RATE, // sampleRate
                8,           // sampleSizeInBits
                1,           // channels
                true,        // signed
                false);      // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i=0; i < msecs*8; i++) {
          double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
          buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
          sdl.write(buf,0,1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
      }  
} 
