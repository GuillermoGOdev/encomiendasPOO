
package DAO;

import Conexion.ConexionSQL;
import DTO.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class PersonaDAO {
    // REGISTRAR PERSONA
    public int registrar(Persona p){
        String sql = "INSERT INTO Persona (nombres, apellido_paterno, apellido_materno, dni, telefono, email, direccion)"
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        int idGenerado = -1;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            con.setAutoCommit(false);

            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellido_paterno());
            ps.setString(3, p.getApellido_materno());
            ps.setString(4, p.getDni());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getEmail());
            ps.setString(7, p.getDireccion());

            System.out.println("Registrando: "+ p.getNombres()+ ", "+p.getApellido_paterno());
            
            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) idGenerado = rs.getInt(1);
                con.commit();
            } else {
                con.rollback();
            }

        } catch (Exception e) {
            System.err.println("Error registrando Persona: " + e.getMessage());
        }

        return idGenerado;
    }
    
    // OBTENER POR ID
    public Persona obtenerPorId(int id) {
        String sql = "SELECT * FROM Persona WHERE idpersona = ?";
        Persona p = null;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) p = mapear(rs);

        } catch (Exception e) {
            System.err.println("Error obteniendo Persona: " + e.getMessage());
        }

        return p;
    }

    // OBTENER POR DNI
    public Persona obtenerPorDni(String dni) {
        String sql = "SELECT * FROM Persona WHERE dni = ?";
        Persona p = null;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) p = mapear(rs);

        } catch (Exception e) {
            System.err.println("Error buscando por DNI: " + e.getMessage());
        }

        return p;
    }

    // LISTAR TODAS
    public List<Persona> listar() {
        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT * FROM Persona ORDER BY idpersona";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) lista.add(mapear(rs));

        } catch (Exception e) {
            System.err.println("Error listando Personas: " + e.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR
    public boolean actualizar(Persona p){
        String sql = "UPDATE Persona SET nombres=?, apellido_paterno=?, apellido_materno=?, dni=?, telefono=?, email=?, direccion=? "
                   + "WHERE idpersona=?";

        boolean ok = false;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            con.setAutoCommit(false);

            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellido_paterno());
            ps.setString(3, p.getApellido_materno());
            ps.setString(4, p.getDni());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getEmail());
            ps.setString(7, p.getDireccion());
            ps.setInt(8, p.getIdpersona());

            if (ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else con.rollback();

        } catch (Exception e) {
            System.err.println("Error actualizando Persona: " + e.getMessage());
        }

        return ok;
    }

    // ELIMINAR
    public boolean eliminar(int id){
        String sql = "DELETE FROM Persona WHERE idpersona=?";
        boolean ok = false;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            con.setAutoCommit(false);

            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else con.rollback();

        } catch (Exception e) {
            System.err.println("Error eliminando Persona: " + e.getMessage());
        }

        return ok;
    }

    // MAPEO
    private Persona mapear(ResultSet rs) throws SQLException {
        return new Persona(
                rs.getInt("idpersona"),
                rs.getString("nombres"),
                rs.getString("apellido_paterno"),
                rs.getString("apellido_materno"),
                rs.getString("dni"),
                rs.getString("telefono"),
                rs.getString("email"),
                rs.getString("direccion")
        );
    }
}
