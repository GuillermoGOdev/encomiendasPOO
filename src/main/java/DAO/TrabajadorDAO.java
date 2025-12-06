package DAO;

import Conexion.ConexionSQL;
import DTO.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class TrabajadorDAO {

    // REGISTRAR TRABAJADOR (requiere que ya exista Persona)
    public boolean registrar(Trabajador t) {
        String sql = "INSERT INTO Trabajador (idpersona, sueldo, estado, idcargo) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionSQL.conectar()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getIdpersona());
            ps.setDouble(2, t.getSueldo());
            ps.setString(3, t.getEstado());
            ps.setInt(4, t.getIdCargo());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error registrando Cliente: " + e.getMessage());
            return false;
        }
    }

    // OBTENER POR ID
    public Trabajador obtenerPorId(int id) {
        String sql = """
                     SELECT t.*,  p.idpersona, p.nombres, p.apellido_paterno, p.apellido_materno, p.dni, 
                 p.telefono, p.email, p.direccion FROM Trabajador t INNER JOIN Persona p ON p.idpersona = 
                 t.idpersona WHERE t.idtrabajador = ?
                         """;

        Trabajador trab = null;

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                trab = mapear(rs);
            }

        } catch (Exception e) {
            System.err.println("Error obteniendo Trabajador: " + e.getMessage());
        }

        return trab;
    }

    // LISTAR
    public List<Trabajador> listar() {
        List<Trabajador> lista = new ArrayList<>();

        String sql = """
                     SELECT t.*, p.idpersona, p.nombres, p.apellido_paterno, p.apellido_materno, 
                 p.dni, p.telefono, p.email, p.direccion FROM Trabajador t INNER JOIN Persona p 
                 ON p.idpersona = t.idpersona ORDER BY t.idtrabajador
                         """;

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }

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

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            con.setAutoCommit(false);

            ps.setDouble(1, t.getSueldo());
            ps.setString(2, t.getEstado());
            ps.setInt(3, t.getIdCargo());
            ps.setInt(4, t.getIdTrabajador());

            if (ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }

        } catch (Exception e) {
            System.err.println("Error actualizando Trabajador: " + e.getMessage());
        }

        return ok;
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Trabajador WHERE idtrabajador=?";
        boolean ok = false;

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            con.setAutoCommit(false);
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }

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

    public List<Trabajador> listarConductor() {
        List<Trabajador> lista = new ArrayList<>();
        String sql = "SELECT T1.nombres, T1.apellido_paterno,T1.apellido_materno,\n"
                + "       T0.idtrabajador\n"
                + "FROM luisgonz_poo_guillermo.Trabajador T0 \n"
                + "INNER JOIN Persona T1\n"
                + "    ON T0.idpersona = T1.idpersona\n"
                + "WHERE T0.idcargo = 7;";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Trabajador v = new Trabajador();
                v.setNombres(rs.getString("nombres"));
                v.setApellido_paterno(rs.getString("apellido_paterno"));
                v.setApellido_materno(rs.getString("apellido_materno"));
                v.setIdTrabajador(rs.getInt("idtrabajador"));
                lista.add(v);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al cargar conductores en combo: " + e.getMessage());
        }

        return lista;
    }
}
