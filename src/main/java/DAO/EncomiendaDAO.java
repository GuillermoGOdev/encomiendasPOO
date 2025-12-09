
package DAO;

import Conexion.ConexionSQL;
import DTO.Encomienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class EncomiendaDAO implements CRUD<Encomienda>{
    @Override
    public boolean registrar(Encomienda e) {
        String sql = """
            INSERT INTO Encomienda
            (id_cliente_remitente, id_cliente_destinatario, id_ruta, descripcion, peso_kg,
             largo, alto, ancho, costo_envio, fecha_envio, estado, idtrabajador, idMetodoPago, pago)
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)
        """;

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, e.getIdClienteRemitente());
            ps.setInt(2, e.getIdClienteDestinatario());
            ps.setInt(3, e.getIdRuta());
            ps.setString(4, e.getDescripcion());
            ps.setDouble(5, e.getPeso_kg());
            ps.setDouble(6, e.getLargo());
            ps.setDouble(7, e.getAlto());
            ps.setDouble(8, e.getAncho());
            ps.setDouble(9, e.getCostoEnvio());
            ps.setString(10, e.getFecha_Envio());
            ps.setString(11, e.getEstado());
            ps.setInt(12, e.getIdTrabajador());
            ps.setInt(13, e.getIdMetodoPago());
            ps.setString(14, e.getPago());

            return ps.executeUpdate() > 0;
            
        } catch (Exception ex) {
            System.out.println("Error al registrar encomienda: " + ex.getMessage());
        }
        return false;
    } 

    @Override
    public boolean eliminar(int id) {
        // No se elimina físicamente, solo se anula
        String sql = "UPDATE Encomienda SET estado='Anulado' WHERE id_encomienda=?";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Error anulando encomienda: " + ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean modificar(Encomienda e) {
        String sql = """
            UPDATE Encomienda SET
            id_cliente_remitente=?, id_cliente_destinatario=?, id_ruta=?, descripcion=?,
            peso_kg=?, largo=?, alto=?, ancho=?, costo_envio=?, fecha_envio=?, estado=?, idtrabajador=?, idMetodoPago=?, pago=?
            WHERE id_encomienda=?
        """;

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, e.getIdClienteRemitente());
            ps.setInt(2, e.getIdClienteDestinatario());
            ps.setInt(3, e.getIdRuta());
            ps.setString(4, e.getDescripcion());
            ps.setDouble(5, e.getPeso_kg());
            ps.setDouble(6, e.getLargo());
            ps.setDouble(7, e.getAlto());
            ps.setDouble(8, e.getAncho());
            ps.setDouble(9, e.getCostoEnvio());
            ps.setString(10, e.getFecha_Envio());
            ps.setString(11, e.getEstado());
            ps.setInt(12, e.getIdTrabajador());
            ps.setInt(13, e.getIdMetodoPago());
            ps.setString(14, e.getPago());
            ps.setInt(15, e.getIdEncomienda());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Error modificar encomienda: " + ex.getMessage());
            return false;
        }

    }

    @Override
    public Encomienda buscar(int id) {
         String sql = "SELECT * FROM Encomienda WHERE id_encomienda=?";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapear(rs);
            }

        } catch (Exception ex) {
            System.out.println("Error al buscar encomienda: " + ex.getMessage());
        }
        return null;

    }
    
    @Override
    public List<Encomienda> listar() {
        return null;
    };
    
    public DefaultTableModel listarEncomiendas(String dni, java.sql.Date fecha) {
        String[] titulos = {
            "idEncomienda", "fechaEnvío", "Remitente", "Destinatario", "Flete", "Estado", "Pago"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String sql = """
                     SELECT 
                     	e.id_encomienda,
                         e.fecha_envio,
                         CONCAT(p1.nombres, ' ', p1.apellido_paterno, ' ', p1.apellido_materno) AS Remitente,
                         CONCAT(p2.nombres, ' ', p2.apellido_paterno, ' ', p2.apellido_materno) AS Destinatario,
                         e.costo_envio,
                         e.estado,
                         e.pago
                     FROM Encomienda e
                     INNER JOIN Cliente c1 ON e.id_cliente_remitente = c1.idcliente
                     INNER JOIN Persona p1 ON c1.idpersona = p1.idpersona
                     INNER JOIN Cliente c2 ON e.id_cliente_destinatario = c2.idcliente
                     INNER JOIN Persona p2 ON c2.idpersona = p2.idpersona
                     WHERE 1 = 1
                     AND e.estado != 'Anulado'
                     """;
        
        // FILTROS
        if (dni != null && !dni.trim().isEmpty()) {
            // 1. Usar AND y encerrar la condición en paréntesis
            sql += " AND (p1.dni = ? OR p2.dni = ?)";
        }
        if (fecha != null) {
            // 2. Usar el alias correcto 'e' de Encomienda
            sql += " AND e.fecha_envio = ? ";
        }

        sql += "ORDER BY 1";
        
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            
            int index = 1;

            if (dni != null && !dni.trim().isEmpty()) { 
                ps.setString(index++, dni);
                ps.setString(index++, dni);
            }

            if (fecha != null) {
                ps.setDate(index++, fecha);
            }

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_encomienda"),
                    rs.getString("fecha_envio"),
                    rs.getString("Remitente"),
                    rs.getString("Destinatario"),
                    rs.getDouble("costo_envio"),
                    rs.getString("estado"),
                    rs.getString("pago")
                });
            }

        } catch (Exception ex) {
            System.out.println("Error listar encomiendas: " + ex.getMessage());
        }
        return modelo;

    }
    
    public boolean pagar (int id) {
        String sql = "UPDATE Encomienda SET pago='Pagado' WHERE id_encomienda=?";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Error pagando encomienda: " + ex.getMessage());
            return false;
        }

    }

    // --- Método para mapear un ResultSet a un objeto Encomienda ---
    private Encomienda mapear(ResultSet rs) throws Exception {
        return new Encomienda(
                rs.getInt("id_encomienda"),
                rs.getInt("id_cliente_remitente"),
                rs.getInt("id_cliente_destinatario"),
                rs.getInt("id_ruta"),
                rs.getString("descripcion"),
                rs.getDouble("peso_kg"),
                rs.getDouble("largo"),
                rs.getDouble("alto"),
                rs.getDouble("ancho"),
                rs.getDouble("costo_envio"),
                rs.getString("fecha_envio"),
                rs.getString("estado"),
                rs.getInt("idtrabajador"),
                rs.getInt("idMetodoPago"),
                rs.getString("pago")
        );
    }
}
