package DAO;

import Conexion.ConexionSQL;
import DTO.Despacho;
import DTO.Vehiculo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DespachoDAO {

    public boolean registrarVehiculo(Despacho D) {

        String sql = "INSERT INTO Consolidado (id_ruta, id_vehiculo, id_trabajador_conductor, fecha_salida, estado)\n"
                + "VALUES (?,?,?,?,?)";
        boolean ok = false;
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            con.setAutoCommit(false);
            ps.setInt(1, D.getIdruta());
            ps.setInt(2, D.getId_vehiculo());
            ps.setInt(3, D.getId_trabajador_conductor());
            ps.setDate(4, (Date) D.getFecha_salida());
            ps.setString(5, D.getEstado());

            if (ps.executeUpdate() > 0) {
                con.commit();  // <-- Commit para guardar la inserción
                ok = true;
            } else {
                con.rollback();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar Despacho: " + e);
        }

        return ok;
    }

    public DefaultTableModel listarDespacho(String placa, java.sql.Date fecha) {

        String[] titulos = {
            "ID","IdRuta", "Ruta", "Vehículo", "Conductor", "Fecha salida", "Estado"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String sql = "SELECT "
                + "c.id_consolidado,"
                + "c.id_ruta, "
                + "r.descripcion, "
                + "v.placa, "
                + "CONCAT(p.nombres, ' ', p.apellido_paterno) AS conductor, "
                + "c.fecha_salida, "
                + "c.estado "
                + "FROM Consolidado c "
                + "INNER JOIN Ruta r ON c.id_ruta = r.id_ruta "
                + "INNER JOIN Vehiculo v ON c.id_vehiculo = v.id_vehiculo "
                + "INNER JOIN Trabajador t ON c.id_trabajador_conductor = t.idtrabajador "
                + "INNER JOIN Persona p ON t.idpersona = p.idpersona "
                + "WHERE 1 = 1 "; 

        // FILTROS
        if (placa != null && !placa.equals("Seleccionar")) {
            sql += " AND v.placa = ? ";
        }
        if (fecha != null) {
            sql += " AND c.fecha_salida = ? ";
        }

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            int index = 1;

            if (placa != null && !placa.equals("Seleccionar")) {
                ps.setString(index++, placa);
            }

            if (fecha != null) {
                ps.setDate(index++, fecha);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_consolidado"),
                    rs.getInt("id_ruta"),
                    rs.getString("descripcion"),
                    rs.getString("placa"),
                    rs.getString("conductor"),
                    rs.getDate("fecha_salida"),
                    rs.getString("estado")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar despacho: " + e.getMessage());
        }

        return modelo;
    }

    public DefaultTableModel listarEncomiendasPorRuta(int idRuta) {
    // Ahora la primera columna será el checkbox
    String[] titulos = {
        "Seleccionar", "ID Encomienda", "Fecha Envio", "ID Ruta", "Ruta", "Descripcion",
        "Peso (kg)", "Largo", "Alto", "Ancho", "Costo"
    };

    // Sobrescribimos el DefaultTableModel para que la primera columna sea editable y tipo Boolean
    DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Solo la primera columna (checkbox) será editable
            return column == 0;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return Boolean.class; // checkbox
            }
            return super.getColumnClass(columnIndex);
        }
    };

    String sql = "SELECT T0.id_encomienda, T0.fecha_envio, T0.id_ruta, "
               + "T1.descripcion AS Ruta, T0.descripcion AS Encomienda, "
               + "T0.peso_kg, T0.largo, T0.alto, T0.ancho, T0.costo_envio "
               + "FROM luisgonz_poo_guillermo.Encomienda T0 "
               + "INNER JOIN Ruta T1 ON T0.id_ruta = T1.id_ruta "
               + "WHERE T0.id_ruta = ? "
               + "ORDER BY T0.fecha_envio DESC";

    try (Connection con = ConexionSQL.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idRuta);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            // La primera columna será false por defecto (checkbox no seleccionado)
            modelo.addRow(new Object[]{
                false, // checkbox
                rs.getInt("id_encomienda"),
                rs.getDate("fecha_envio"),
                rs.getInt("id_ruta"),
                rs.getString("Ruta"),
                rs.getString("Encomienda"),
                rs.getDouble("peso_kg"),
                rs.getDouble("largo"),
                rs.getDouble("alto"),
                rs.getDouble("ancho"),
                rs.getDouble("costo_envio")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar encomiendas: " + e.getMessage());
    }

    return modelo;
}


}
