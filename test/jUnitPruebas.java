import modelo.Lavadora;
import modelo.Pantalon;
import modelo.Refrigerador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MiguelAngel
 */
public class jUnitPruebas {
    public jUnitPruebas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void calcularTotalCompraPantalon(){
        double resultado_esperado = 47600;
        double resultado_obtenido = 0;
        Pantalon pant = new Pantalon("cod01", 20000, 30, "jeans", 'H');
        resultado_obtenido = pant.calcularTotal(2, "nocturno");
        
        assertEquals(resultado_esperado, resultado_obtenido, 0.0f);   
    }
    
    @Test
    public void calcularTotalCompraRefrigerador(){
        double resultado_esperado = 3570000;
        double resultado_obtenido = 0;
        Refrigerador ref = new Refrigerador("cod10", 300000, 10, "mademsa", 10);
        resultado_obtenido = ref.calcularTotal(10, "diurno");
        
        assertEquals(resultado_esperado, resultado_obtenido, 0.0f);
    }
    
    @Test
    public void calcularDescuentoRefrigerador(){
        double resultado_esperado = 39000;
        double resultado_obtenido = 0;
        
        Refrigerador ref = new Refrigerador("cod1", 300000, 10, "Acme", 15);
        resultado_obtenido = ref.calcularDescuento("nocturno");
        
        assertEquals(resultado_esperado, resultado_obtenido, 0.0f);
    }
    
    @Test
    public void calcularDescuentoLavadora(){
        double resultado_esperado = 22000;
        double resultado_obtenido = 0;
        
        Lavadora lav = new Lavadora("cod1", 200000, 10, "Zoni", 'A');
        resultado_obtenido = lav.calcularDescuento("nocturno");
        
        assertEquals(resultado_esperado, resultado_obtenido, 0.0f);
    }
    
    @Test
    public void pruebaMultipleValidarStock(){
        boolean resultado_esperado = true;
        boolean resultado_obtenido;
        
        Pantalon pant = new Pantalon("cod01", 19000, 20, "cotele", 'M');
        Lavadora lav = new Lavadora("cod1", 200000, 20, "Zoni", 'A');
        Refrigerador ref = new Refrigerador("cod1", 300000, 20, "Acme", 15);
        
        resultado_obtenido = pant.validarStock(1);
        assertEquals(resultado_esperado, resultado_obtenido);
        
        resultado_obtenido = lav.validarStock(15);
        assertEquals(resultado_esperado, resultado_obtenido);
        
        resultado_obtenido = ref.validarStock(20);
        assertEquals(resultado_esperado, resultado_obtenido);
    }
    
}
