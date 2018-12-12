package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Producto;
import vista.JFrmPrincipal;

/**
 *
 * @author MiguelAngel
 */
public class Ctrl_Producto implements ActionListener{

    public Ctrl_Producto(JFrmPrincipal frm_producto, Ctrl_Pantalon ctPant, Ctrl_Refrigerador ctRefri, Ctrl_Lavadora ctLav) {
        Ctrl_Lavadora ctrl_lav = new Ctrl_Lavadora(frm_producto);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void resetCamposAgregar(){
        
    }
    
    public ArrayList<Producto> listarProductos(){
        ArrayList<Producto> lista = new ArrayList<>();
        for (Producto producto : lista) {
            
        }
        return lista;
    }
    
}
