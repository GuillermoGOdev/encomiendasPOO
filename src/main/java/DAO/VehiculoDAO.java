package DAO;

import Conexion.ConexionSQL;
import DTO.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
