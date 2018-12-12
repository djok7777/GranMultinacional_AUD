package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConsultasLavadora;
import modelo.ConsultasPantalon;
import modelo.ConsultasRefrigerador;
import modelo.Lavadora;
import vista.JFrmPrincipal;

/**
 *
 * @author MiguelAngel
 */
public class Ctrl_Lavadora implements ActionListener{
    private Lavadora lav;
    private JFrmPrincipal frm_producto;
    private ConsultasLavadora cLavadora;
    private ConsultasPantalon cPantalon;
    private ConsultasRefrigerador cRefrigerador;

    public Ctrl_Lavadora(JFrmPrincipal frm_producto) {
        this.frm_producto = frm_producto;
        this.cLavadora = new ConsultasLavadora();
        this.cPantalon = new ConsultasPantalon();
        this.cRefrigerador = new ConsultasRefrigerador();
        this.frm_producto.jbtnAgregar_Agregar.addActionListener(this);
        this.frm_producto.jbtnEliminar_Eliminar.addActionListener(this);
        this.frm_producto.jbtnListar_Listar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoDeProducto = frm_producto.jcbProducto.getSelectedItem().toString();
        try {
            if (e.getSource() == frm_producto.jbtnAgregar_Agregar && tipoDeProducto.equalsIgnoreCase("lavadora")) 
            {
                if (frm_producto.jcbCarga_Agregar.getSelectedIndex() != 0) {
                    String codigo = frm_producto.jtfCodigo_Agregar.getText();
                    if (cPantalon.buscar(codigo) || cLavadora.buscar(codigo) || cRefrigerador.buscar(codigo)) {
                        throw new IllegalArgumentException("El código ya existe");
                    }
                    int precioBase = Integer.parseInt(frm_producto.jtfPrecio_Agregar.getText());
                    int stock = Integer.parseInt(frm_producto.jtfStock_Agregar.getText());
                    String marca = frm_producto.jtfMarca_Agregar.getText();
                    char carga = 'A';
                    if (frm_producto.jcbCarga_Agregar.getSelectedItem().toString().equalsIgnoreCase("arriba")) {
                        carga = 'A';
                    }
                    else if(frm_producto.jcbCarga_Agregar.getSelectedItem().toString().equalsIgnoreCase("costado")){
                        carga = 'C';
                    }

                    lav = new Lavadora(codigo, precioBase, stock, marca, carga);
                    if (this.cLavadora.registrar(lav)) {
                        JOptionPane.showMessageDialog(null, "Producto registrado");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Seleccione tipo de carga");
                }
                
            }

            if (e.getSource() == frm_producto.jbtnEliminar_Eliminar){
                String codigo = frm_producto.jtfBuscar_Eliminar.getText();
                if (cLavadora.buscar(codigo) || cRefrigerador.buscar(codigo) || cPantalon.buscar(codigo)) {
                    frm_producto.jlblNoExiste_Eliminar.setText("Eliminando...");
                    if(cLavadora.eliminar(codigo)){
                    JOptionPane.showMessageDialog(null, "Producto eliminado");
                    frm_producto.jlblNoExiste_Eliminar.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar");
                    }
                }
                else{
                    frm_producto.jlblNoExiste_Eliminar.setText("Producto no encontrado");
                    //JOptionPane.showMessageDialog(null, "El producto no existe");
                }
            }

            if (e.getSource() == frm_producto.jbtnListar_Listar) {
                ArrayList<Lavadora> lista = cLavadora.listar();
                frm_producto.jtaListar.append("\nLAVADORAS\n");
            for (Lavadora lava : lista) {
                frm_producto.jtaListar.append(lava.imprimir()+ "\n");
            }
                System.out.println(lista.toString());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error : " +ex.getMessage());
        }
    
    }
}
