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
public class ConsultasLavadora extends Conexion{
    public boolean registrar(Lavadora lav){
        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "INSERT INTO lavadora (codigo, precioBase, stock, marca, carga) VALUES (?,?,?,?,?)";
       
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lav.getCodigo());
            ps.setInt(2, lav.getPrecioBase());
            ps.setInt(3, lav.getStock());
            ps.setString(4, lav.getMarca());
            ps.setString(5, String.valueOf(lav.getCarga()));
            ps.execute();
            this.desconectar();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            throw new IllegalArgumentException(e.getMessage());
            //return false;
        }
    }
    
    public boolean buscar(String cod){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conectar();
        String sql = "SELECT * FROM lavadora WHERE codigo=?";

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
        String sql = "DELETE FROM lavadora WHERE codigo=?";
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
    
    public ArrayList<Lavadora> listar(){
        ArrayList<Lavadora> lista = new ArrayList();
        Statement st;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM lavadora";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Lavadora lav = new Lavadora(rs.getString("codigo"), rs.getInt("precioBase"), rs.getInt("stock"), rs.getString("marca"), rs.getString("carga").charAt(0));
                lista.add(lav);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        }
    }
    
}
