package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConsultasLavadora;
import modelo.ConsultasPantalon;
import modelo.ConsultasRefrigerador;
import modelo.Pantalon;
import vista.JFrmPrincipal;

/**
 *
 * @author MiguelAngel
 */
public class Ctrl_Pantalon implements ActionListener{
    private Pantalon panta;
    private JFrmPrincipal frm_producto;
    private ConsultasPantalon cPantalon;
    private ConsultasRefrigerador cRefrigerador;
    private ConsultasLavadora cLavadora;
    
    public Ctrl_Pantalon(JFrmPrincipal frm_producto) {
        this.frm_producto = frm_producto;
        this.cPantalon = new ConsultasPantalon();
        this.cRefrigerador = new ConsultasRefrigerador();
        this.cLavadora = new ConsultasLavadora();
        this.frm_producto.jbtnAgregar_Agregar.addActionListener(this);
        this.frm_producto.jbtnEliminar_Eliminar.addActionListener(this);
        this.frm_producto.jbtnListar_Listar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoDeProducto = frm_producto.jcbProducto.getSelectedItem().toString();
        try {
            if (e.getSource() == frm_producto.jbtnAgregar_Agregar && tipoDeProducto.equalsIgnoreCase("pantalon"))
            { 
                if (frm_producto.jcbTipo_Agregar.getSelectedIndex() != 0) {
                    String codigo = frm_producto.jtfCodigo_Agregar.getText();
                    if (cPantalon.buscar(codigo) || cRefrigerador.buscar(codigo) || cLavadora.buscar(codigo)) {
                        throw new IllegalArgumentException("El código ya existe!");
                    }
                    if (frm_producto.jtfCodigo_Agregar.getText().length() > 10) {
                        throw new IllegalArgumentException("El código debe contener máximo 10 carácteres");
                    }
                    
                    int precioBase = Integer.parseInt(frm_producto.jtfPrecio_Agregar.getText());
                    int stock = Integer.parseInt(frm_producto.jtfStock_Agregar.getText());
                    String tipo = frm_producto.jcbTipo_Agregar.getSelectedItem().toString();
                    char sexo = 'H';
                    if (frm_producto.jrbFemenino_Agregar.isSelected()) {
                        sexo = 'M';
                    }
                    panta = new Pantalon(codigo, precioBase, stock, tipo, sexo);
                    if (this.cPantalon.registrar(panta)) {
                        JOptionPane.showMessageDialog(null, "Producto registrado");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Seleccione un tipo de pantalon");
                }
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error : " +ex.getMessage());
        }

        
        if (e.getSource() == frm_producto.jbtnEliminar_Eliminar){
            String codigo = frm_producto.jtfBuscar_Eliminar.getText();
            if (cPantalon.buscar(codigo)) {
                frm_producto.jlblNoExiste_Eliminar.setText("Eliminando...");
                if(cPantalon.eliminar(codigo)){
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                frm_producto.jlblNoExiste_Eliminar.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar");
                }
            }
            else{
                frm_producto.jlblNoExiste_Eliminar.setText("Producto no encontrado");
                //JOptionPane.showMessageDialog(null, "Producto no existe");
            }
        }
        
        if (e.getSource() == frm_producto.jbtnListar_Listar) {
            ArrayList<Pantalon> lista = cPantalon.listar();
            frm_producto.jtaListar.append("\nPANTALONES\n");
            for (Pantalon pant : lista) {
                frm_producto.jtaListar.append(pant.imprimir() + "\n");
            }
            System.out.println(lista.toString());
        }
    }
}
