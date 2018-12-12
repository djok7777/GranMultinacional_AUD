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
public class ConsultasRefrigerador extends Conexion{
    public boolean registrar(Refrigerador refri){
        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "INSERT INTO refrigerador (codigo, precioBase, stock, marca, cantidadPies) VALUES (?,?,?,?,?)";
       
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, refri.getCodigo());
            ps.setInt(2, refri.getPrecioBase());
            ps.setInt(3, refri.getStock());
            ps.setString(4, refri.getMarca());
            ps.setInt(5, refri.getCantidadPies());    
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
        String sql = "SELECT * FROM refrigerador WHERE codigo=?";
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
        String sql = "DELETE FROM refrigerador WHERE codigo=?";
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
    
    public ArrayList<Refrigerador> listar(){
        ArrayList<Refrigerador> lista = new ArrayList();
        Statement st;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM refrigerador";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Refrigerador refri = new Refrigerador(rs.getString("codigo"), rs.getInt("precioBase"), rs.getInt("stock"), rs.getString("marca"), rs.getString("cantidadPies").charAt(0));
                lista.add(refri);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
}
