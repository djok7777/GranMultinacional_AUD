package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MiguelAngel
 */
public class Conexion {
    /*
    public String bd = "gran_multinacional";
    public String user = "root";
    public String pass = "";
    public String url = "jdbc:mysql://localhost:3306/" + bd;
    */
    
    public String bd = "sql10263349";
    public String user = "sql10263349";
    public String pass = "kHINelzMER";
    public String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/" + bd;
    
    public Connection conn;
    public Statement sentencia; //Camino a la bd
    
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                //System.out.println("Conexión establecida con la base de datos");
            }
        } catch (SQLException e){
            System.out.println("Hubo un problema al conectar");
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return conn;
    }
    
    public void desconectar() throws SQLException{
        conn.close();
    }
    
//==========================================================================================
}
