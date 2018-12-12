package modelo;

import java.util.ArrayList;

/**
 *
 * @author MiguelAngel
 */
public class DatosApp {
    public static ArrayList <Producto> productos = new ArrayList<>();

    public DatosApp() {
    }

    public static void rellenar(){
        Pantalon p1 = new Pantalon("cod01", 23990, 35, "Dockers", 'M');
        Pantalon p2 = new Pantalon("cod02", 16990, 27, "Basement", 'F');   
        Pantalon p3 = new Pantalon("cod03", 12990, 40, "Basement", 'M');
        DatosApp.productos.add(p1);
        DatosApp.productos.add(p2);
        DatosApp.productos.add(p3);
        
        Refrigerador r1 = new Refrigerador("cod04", 220000, 17, "Mademsa", 12);
        Refrigerador r2 = new Refrigerador("cod05", 349000, 21, "Daewoo", 15);
        DatosApp.productos.add(r1);
        DatosApp.productos.add(r2);
        System.out.println("Datos cargados");
    }
    
    public static boolean buscarProducto(String codigo){
        for (Producto prod : productos) {
            if (prod.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
}
