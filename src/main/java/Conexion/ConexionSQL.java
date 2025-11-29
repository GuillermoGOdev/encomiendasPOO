package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionSQL {
    
    private static final String URL = "jdbc:mysql://luisgonzaganeiraayala.com:3306/luisgonz_poo_guillermo";
    private static final String USER = "luisgonz_poo_guillermo";
    private static final String PASSWORD = "(~a&8v{Y7UC_J?ai";
    
    public static Connection conectar(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Se conecto correctamente a la bd");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar: "+e.toString());
        }
        return conexion;
    }
    
}
