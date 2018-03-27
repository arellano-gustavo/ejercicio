package mx.com.itam.adsi.ejercicio;

import org.apache.log4j.Logger;

public class Principal{
  private final static Logger LOG = Logger.getLogger(Principal.class);

  public static void main(String...argv) {
    Principal p = new Principal();
    LOG.info("Conversión de fff1: " + p.toArabic("fff1","0123456789abcdef"));
  }
  public int toArabic(String source, String alphabet) {
    int res = 0;
    for(char c : source.toCharArray())
      res = res*(alphabet.length()) + alphabet.indexOf(c);
    return res;
  }
}
