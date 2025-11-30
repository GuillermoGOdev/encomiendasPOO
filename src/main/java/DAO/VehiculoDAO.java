package DAO;

import Conexion.ConexionSQL;
import DTO.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VehiculoDAO {

    //// Conexiones
//    Connection con = ConexionSQL.conectar();
//    private String sql = "";
//    PreparedStatement ps;
//    int filasAfectadas = 0;
//    boolean ok = false;
    public boolean registrarVehiculo(Vehiculo V) {
        String sql = "INSERT INTO Vehiculo (placa, Anio, capacidad_kg, capacidad_volumen_m3, estado) VALUES (?, ?, ?, ?, ?)";
        boolean ok = false;
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            con.setAutoCommit(false);

            ps.setString(1, V.getPlaca());
            ps.setInt(2, V.getAnio());
            ps.setDouble(3, V.getCapacidad_kg());
            ps.setDouble(4, V.getCapacidad_m3());
            ps.setString(5, V.getEstado());

            if (ps.executeUpdate() > 0) {
                con.commit();  // <-- Commit para guardar la inserción
                ok = true;
            } else {
                con.rollback();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar vehículo: " + e);
        }

        return ok;
    }
    
    // LISTAR
    public List<Vehiculo> listarVehiculos() {
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculo";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vehiculo v = new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("placa"),
                        rs.getInt("anio"),
                        rs.getDouble("capacidad_kg"),
                        rs.getDouble("capacidad_volumen_m3"),
                        rs.getString("estado")
                );
                lista.add(v);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error listando vehículos: " + e.getMessage());
        }

        return lista;
    }
    
     // ACTUALIZAR
    public boolean actualizarVehiculo(Vehiculo v) {
        String sql = "UPDATE Vehiculo SET placa=?, anio=?, capacidad_kg=?, capacidad_volumen_m3=?, estado=? WHERE id_vehiculo=?";
        boolean ok = false;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getPlaca());
            ps.setInt(2, v.getAnio());
            ps.setDouble(3, v.getCapacidad_kg());
            ps.setDouble(4, v.getCapacidad_m3());
            ps.setString(5, v.getEstado());
            ps.setInt(6, v.getIdVehiculo());

            if (ps.executeUpdate() > 0) ok = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar vehículo: " + e.getMessage());
        }

        return ok;
    }

    
    // ELIMINAR
    public boolean eliminarVehiculo(int id) {
        String sql = "DELETE FROM Vehiculo WHERE id_vehiculo=?";
        boolean ok = false;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ok = ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar vehículo: " + e.getMessage());
        }
        return ok;
    }
}
