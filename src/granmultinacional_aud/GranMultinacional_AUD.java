package granmultinacional_aud;

import controlador.Ctrl_Lavadora;
import controlador.Ctrl_Pantalon;
import controlador.Ctrl_Producto;
import controlador.Ctrl_Refrigerador;
import vista.JFrmPrincipal;

/**
 *
 * @author MiguelAngel
 */
public class GranMultinacional_AUD {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {            
        
        //Cargar interfaz principal
        JFrmPrincipal jfrm = new JFrmPrincipal();
        
        //Cargar controladores
        Ctrl_Pantalon ctrl_pantalon = new Ctrl_Pantalon(jfrm);
        Ctrl_Refrigerador ctrl_refrigerador = new Ctrl_Refrigerador(jfrm);
        Ctrl_Lavadora ctrl_lavadora = new Ctrl_Lavadora(jfrm);
        
        //Desplegar ventana principal
        jfrm.setTitle("Gestión de productos");
        jfrm.setLocationRelativeTo(null);
        jfrm.setVisible(true);
    }  
}
