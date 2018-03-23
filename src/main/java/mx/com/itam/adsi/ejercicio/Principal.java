package mx.com.itam.adsi.ejercicio;

public class Principal{
  public static void main(String...argv) {
    System.out.println(toArabic("fff1","0123456789abcdef"));
  }
  private static int toArabic(String source, String alphabet) {
    int res = 0;
    for(char c : source.toCharArray())
      res = res*(alphabet.length()) + alphabet.indexOf(c);
    return res;
  }
}
