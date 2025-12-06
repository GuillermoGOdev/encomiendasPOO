
package DAO;

import Conexion.ConexionSQL;
import DTO.Comprobante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ComprobanteDAO {

    // INSERTAR
    public boolean registrar(Comprobante c) {
        String sql = "INSERT INTO Comprobante (id_encomienda, tipo, serie, numero, fecha_emision, subtotal, igv, total, idMetodoPago) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, c.getIdEncomienda());
            ps.setString(2, c.getTipo());
            ps.setString(3, c.getSerie());
            ps.setInt(4, c.getNumero());
            ps.setDate(5, new java.sql.Date(c.getFechaEmision().getTime()));
            ps.setDouble(6, c.getSubtotal());
            ps.setDouble(7, c.getIgv());
            ps.setDouble(8, c.getTotal());
            ps.setInt(9, c.getIdMetodoPago());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en ComprobanteDAO.registrar(): " + e.getMessage());
            return false;
        }
    }

    // LISTAR
    public List<Comprobante> listar() {
        List<Comprobante> lista = new ArrayList<>();
        String sql = "SELECT * FROM Comprobante";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Comprobante c = new Comprobante();

                c.setIdComprobante(rs.getInt("idComprobante"));
                c.setIdEncomienda(rs.getInt("id_encomienda"));
                c.setTipo(rs.getString("tipo"));
                c.setSerie(rs.getString("serie"));
                c.setNumero(rs.getInt("numero"));
                c.setFechaEmision(rs.getDate("fecha_emision"));
                c.setSubtotal(rs.getDouble("subtotal"));
                c.setIgv(rs.getDouble("igv"));
                c.setTotal(rs.getDouble("total"));
                c.setIdMetodoPago(rs.getInt("idMetodoPago"));

                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error en ComprobanteDAO.listar(): " + e.getMessage());
        }

        return lista;
    }

    // BUSCAR POR ID
    public Comprobante buscar(int id) {
        String sql = "SELECT * FROM Comprobante WHERE idComprobante = ?";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Comprobante c = new Comprobante();

                c.setIdComprobante(rs.getInt("idComprobante"));
                c.setIdEncomienda(rs.getInt("id_encomienda"));
                c.setTipo(rs.getString("tipo"));
                c.setSerie(rs.getString("serie"));
                c.setNumero(rs.getInt("numero"));
                c.setFechaEmision(rs.getDate("fecha_emision"));
                c.setSubtotal(rs.getDouble("subtotal"));
                c.setIgv(rs.getDouble("igv"));
                c.setTotal(rs.getDouble("total"));
                c.setIdMetodoPago(rs.getInt("idMetodoPago"));

                return c;
            }

        } catch (SQLException e) {
            System.out.println("Error en ComprobanteDAO.buscar(): " + e.getMessage());
        }

        return null;
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Comprobante WHERE idComprobante = ?";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error en ComprobanteDAO.eliminar(): " + e.getMessage());
            return false;
        }
    }
}
