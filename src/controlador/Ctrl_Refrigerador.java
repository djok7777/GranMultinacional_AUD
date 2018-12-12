package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConsultasLavadora;
import modelo.ConsultasPantalon;
import modelo.ConsultasRefrigerador;
import modelo.Refrigerador;
import vista.JFrmPrincipal;

/**
 *
 * @author MiguelAngel
 */
public class Ctrl_Refrigerador implements ActionListener{
    private Refrigerador refri;
    private JFrmPrincipal frm_producto;
    private ConsultasRefrigerador cRefrigerador;
    private ConsultasPantalon cPantalon;
    private ConsultasLavadora cLavadora;
    
    public Ctrl_Refrigerador(JFrmPrincipal frm_producto) {
        this.frm_producto = frm_producto;
        this.cRefrigerador = new ConsultasRefrigerador();
        this.cPantalon = new ConsultasPantalon();
        this.cLavadora = new ConsultasLavadora();
        this.frm_producto.jbtnAgregar_Agregar.addActionListener(this);
        this.frm_producto.jbtnEliminar_Eliminar.addActionListener(this);
        this.frm_producto.jbtnListar_Listar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoDeProducto = frm_producto.jcbProducto.getSelectedItem().toString();
        
        try {
            if (e.getSource() == frm_producto.jbtnAgregar_Agregar && tipoDeProducto.equalsIgnoreCase("refrigerador")) 
            {
                String codigo = frm_producto.jtfCodigo_Agregar.getText();
                if (cPantalon.buscar(codigo) || cLavadora.buscar(codigo) || cRefrigerador.buscar(codigo)) {
                    throw new IllegalArgumentException("El código ya existe");
                }

                int precioBase = Integer.parseInt(frm_producto.jtfPrecio_Agregar.getText());
                int stock = Integer.parseInt(frm_producto.jtfStock_Agregar.getText());
                String marca = frm_producto.jtfMarca_Agregar.getText();
                int pies = Integer.parseInt(frm_producto.jtfPies_Agregar.getText());
                refri = new Refrigerador(codigo, precioBase, stock, marca, pies);
                if (this.cRefrigerador.registrar(refri)) {
                    JOptionPane.showMessageDialog(null, "Producto registrado");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }

        
        if (e.getSource() == frm_producto.jbtnEliminar_Eliminar){
            String codigo = frm_producto.jtfBuscar_Eliminar.getText();
            if (cRefrigerador.buscar(codigo)) {
                frm_producto.jlblNoExiste_Eliminar.setText("Eliminando...");
                if(cRefrigerador.eliminar(codigo)){
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                frm_producto.jlblNoExiste_Eliminar.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar");
                }
            }
            else{
                frm_producto.jlblNoExiste_Eliminar.setText("Producto no encontrado");
                //JOptionPane.showMessageDialog(null, "Producto no existe");
            }
        }
        
        if (e.getSource() == frm_producto.jbtnListar_Listar) {
            ArrayList<Refrigerador> lista = cRefrigerador.listar();
            frm_producto.jtaListar.append("\nREFRIGERADORES\n");
            for (Refrigerador refri : lista) {
                frm_producto.jtaListar.append(refri.imprimir() + "\n");
            }
            System.out.println(lista.toString());
        }
    }
    
}
