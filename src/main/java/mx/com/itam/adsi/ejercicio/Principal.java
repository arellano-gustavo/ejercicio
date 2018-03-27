package mx.com.itam.adsi.ejercicio;

import org.apache.log4j.Logger;

public class Principal{
  private final static Logger LOG = Logger.getLogger(Principal.class);

  public static void main(String...argv) {
    LOG.info("Conversión de fff1: "+toArabic("fff1","0123456789abcdef"));
  }
  private static int toArabic(String source, String alphabet) {
    int res = 0;
    for(char c : source.toCharArray())
      res = res*(alphabet.length()) + alphabet.indexOf(c);
    return res;
  }
}
