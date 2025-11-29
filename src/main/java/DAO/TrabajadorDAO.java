
package DAO;

import Conexion.ConexionSQL;
import DTO.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TrabajadorDAO {
    // REGISTRAR TRABAJADOR (requiere que ya exista Persona)
    public int registrar(Trabajador t) {
        String sql = "INSERT INTO Trabajador (idpersona, sueldo, estado, idcargo) "
                   + "VALUES (?, ?, ?, ?)";

        int idGenerado = -1;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            con.setAutoCommit(false);

            ps.setInt(1, t.getIdpersona());      // viene de Persona
            ps.setDouble(2, t.getSueldo());
            ps.setString(3, t.getEstado());
            ps.setInt(4, t.getIdCargo());

            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) idGenerado = rs.getInt(1);
                con.commit();
            } else con.rollback();

        } catch (Exception e) {
            System.err.println("Error registrando Trabajador: " + e.getMessage());
        }

        return idGenerado;
    }

    // OBTENER POR ID
    public Trabajador obtenerPorId(int id) {
        String sql = "SELECT t.*,  p.idpersona, p.nombres, p.apellido_paterno, p.apellido_materno, p.dni, "
                + "p.telefono, p.email, p.direccionFROM Trabajador tINNER JOIN Persona p ON p.idpersona = "
                + "t.idpersona WHERE t.idtrabajador = ?";

        Trabajador trab = null;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) trab = mapear(rs);

        } catch (Exception e) {
            System.err.println("Error obteniendo Trabajador: " + e.getMessage());
        }

        return trab;
    }

    // LISTAR
    public List<Trabajador> listar() {
        List<Trabajador> lista = new ArrayList<>();

        String sql = "SELECT t.*, p.idpersona, p.nombres, p.apellido_paterno, p.apellido_materno, "
                + "p.dni, p.telefono, p.email, p.direccionFROM Trabajador tINNER JOIN Persona p "
                + "ON p.idpersona = t.idpersonaORDER BY t.idtrabajador";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) lista.add(mapear(rs));

        } catch (Exception e) {
            System.err.println("Error listando trabajadores: " + e.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR
    public boolean actualizar(Trabajador t) {
        String sql = "UPDATE Trabajador SET sueldo=?, estado=?, idcargo=? "
                   + "WHERE idtrabajador=?";

        boolean ok = false;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            con.setAutoCommit(false);

            ps.setDouble(1, t.getSueldo());
            ps.setString(2, t.getEstado());
            ps.setInt(3, t.getIdCargo());
            ps.setInt(4, t.getIdTrabajador());

            if (ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else con.rollback();

        } catch (Exception e) {
            System.err.println("Error actualizando Trabajador: " + e.getMessage());
        }

        return ok;
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Trabajador WHERE idtrabajador=?";
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
            System.err.println("Error eliminando Trabajador: " + e.getMessage());
        }

        return ok;
    }

    // MAPEO COMPLETO (Persona + Trabajador)
    private Trabajador mapear(ResultSet rs) throws SQLException {
        return new Trabajador(
            rs.getInt("idpersona"),
            rs.getString("nombres"),
            rs.getString("apellido_paterno"),
            rs.getString("apellido_materno"),
            rs.getString("dni"),
            rs.getString("telefono"),
            rs.getString("email"),
            rs.getString("direccion"),
            rs.getInt("idtrabajador"),
            rs.getDouble("sueldo"),
            rs.getString("estado"),
            rs.getInt("idcargo")
        );
    }
}
