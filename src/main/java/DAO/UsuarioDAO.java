
package DAO;

import Conexion.ConexionSQL;
import DTO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
   public boolean registrarUsuario(Usuario u){
       String sql = "INSERT INTO Usuario (nombre, correo, contraseña) VALUES (?, ?, ?)";
       boolean ok = false;
       try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
           con.setAutoCommit(false);
           ps.setString(1, u.getNombre());
           ps.setString(2, u.getCorreo());
           ps.setString(3, u.getContraseña());
           
           if (ps.executeUpdate() > 0) {
                con.commit();  // <-- Commit para guardar la inserción
                ok = true;
            } else {
                con.rollback();
            }
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al registrar un Usuario: " + e);
       }
       return ok;
   }
   
   public boolean verificarCorreoExistente(String correo){
       String sql = "SELECT COUNT(*) FROM Usuario WHERE correo = ?";
       boolean ok = false;
       try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
               return rs.getInt(1) >0; //Si COUNT(*) > 0, significa que el correo existe
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al verificar el Correo: " + e.getMessage());
       }
       return false;
   }
   
   public Usuario iniciarSesion(String usuarioOCorreo, String contraseña) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE (nombre = ? OR correo = ?) AND contraseña = ?";

        try (Connection con = ConexionSQL.conectar();PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuarioOCorreo);
            ps.setString(2, usuarioOCorreo);
            ps.setString(3, contraseña);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contraseña")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error en iniciar sesión");
            System.err.println(e.getMessage());
        }
        return usuario;
    }
}
