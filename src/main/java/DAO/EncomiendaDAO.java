
package DAO;

import Conexion.ConexionSQL;
import DTO.Encomienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EncomiendaDAO implements CRUD<Encomienda>{
    @Override
    public boolean registrar(Encomienda e) {
        String sql = """
            INSERT INTO Encomienda
            (id_cliente_remitente, id_cliente_destinatario, id_ruta, descripcion, peso_kg,
             largo, alto, ancho, costo_envio, fecha_envio, estado, idtrabajador, idMetodoPago)
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)
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
            peso_kg=?, largo=?, alto=?, ancho=?, costo_envio=?, fecha_envio=?, estado=?, idtrabajador=?, idMetodoPago=?
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
            ps.setInt(14, e.getIdEncomienda());

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
        List<Encomienda> lista = new ArrayList<>();
        String sql = "SELECT * FROM Encomienda";

        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(mapear(rs));
            }

        } catch (Exception ex) {
            System.out.println("Error listar encomiendas: " + ex.getMessage());
        }
        return lista;

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
                rs.getInt("idMetodoPago")
        );
    }
}
