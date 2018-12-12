package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MiguelAngel
 */
public class ConsultasPantalon extends Conexion{
    
    public boolean registrar(Pantalon pant){
        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "INSERT INTO pantalon (codigo, precioBase, stock, tipo, sexo) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pant.getCodigo());
            ps.setInt(2, pant.getPrecioBase());
            ps.setInt(3, pant.getStock());
            ps.setString(4, pant.getTipo());
            //Conversión debido Bdd solicita parametro String
            ps.setString(5, String.valueOf(pant.getSexo()));    
            ps.execute();
            this.desconectar();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    
    public boolean buscar(String cod){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conectar();
        String sql = "SELECT * FROM pantalon WHERE codigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean eliminar(String cod){
        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "DELETE FROM pantalon WHERE codigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public ArrayList<Pantalon> listar(){
        ArrayList<Pantalon> lista = new ArrayList();
        Statement st;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM pantalon";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Pantalon pant = new Pantalon(rs.getString("codigo"), rs.getInt("precioBase"), rs.getInt("stock"), rs.getString("tipo"), rs.getString("sexo").charAt(0));
                lista.add(pant);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
}
