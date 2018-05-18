package mx.com.itam.adsi.ejercicio;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPrincipal {
    private final static Logger LOG = Logger.getLogger(TestPrincipal.class);
    
    private static final String HEXA = "0123456789abcdef";
    private static final String BINARIO = "01";
    
    private Alarm p = new Alarm();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void before() {
        System.out.println("Before Test Case");
    }

    @Test
    public void isCorrectCalcTest() {
        String val="";
        LOG.info("Ejecutando la prueba");
        
        val="fff1";
        assertTrue("Calculo para '"+val+"':", calc(HEXA, val, 65521));
        val="100110";
        assertTrue("Calculo para '"+val+"':", calc(BINARIO, val, 38));
    }
    
    private boolean calc(String alphabet, String value, int res) {
        return true;
    }

    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
}
