
package DAO;

import Conexion.ConexionSQL;
import DTO.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class CargoDAO {
    // LISTAR TODOS LOS CARGOS
    public List<Cargo> listar() {
        List<Cargo> lista = new ArrayList<>();
        String sql = "SELECT * FROM cargo";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Cargo(
                        rs.getInt("idcargo"),
                        rs.getString("descripcion"),
                        rs.getString("estado")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // BUSCAR POR ID
    public Cargo buscarPorId(int id) {
        String sql = "SELECT * FROM cargo WHERE idcargo = ?";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cargo(
                        rs.getInt("idcargo"),
                        rs.getString("descripcion"),
                        rs.getString("estado")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // INSERTAR
    public boolean insertar(Cargo c) {
        String sql = "INSERT INTO cargo (descripcion, estado) VALUES (?, ?)";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getDescripcion());
            ps.setString(2, c.getEstado());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ACTUALIZAR
    public boolean actualizar(Cargo c) {
        String sql = "UPDATE cargo SET descripcion=?, estado=? WHERE idcargo=?";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getDescripcion());
            ps.setString(2, c.getEstado());
            ps.setInt(3, c.getIdCargo());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM cargo WHERE idcargo=?";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
