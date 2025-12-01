package DAO;

import Conexion.ConexionSQL;
import DTO.ParadaRuta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParadaRutaDAO{

    // Instancia del DAO que usaremos para buscar la Agencia
    private AgenciaDAO agenciaDAO = new AgenciaDAO();
    
    public boolean registrar(List<ParadaRuta> paradas) {
        String sql = "INSERT INTO ParadaRuta (idRuta, idAgencia, orden) VALUES (?, ?, ?)";
        boolean batchOk = true;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            for(ParadaRuta pr : paradas) {
                ps.setInt(1, pr.getIdRuta());
                ps.setInt(2, pr.getIdAgencia());
                ps.setInt(3, pr.getOrden());
                
                // Añadir a la cola de inserción masiva (BATCH)
                ps.addBatch();
            }
            
            // Ejecutar todas las inserciones con una sola llamada
            int[] resultadosBatch = ps.executeBatch();

            // Verificar si todas las inserciones en ParadaRuta fueron exitosas
            for (int res : resultadosBatch) {
                if (res <= 0) {
                    batchOk = false;
                    break;
                }
            }
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                batchOk = true;
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            System.err.println("Error en ParadaRutaDAO.registrar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al registrar la ParadaRuta en la base de datos.", e);
        }
        return batchOk;
    }

    public boolean eliminar(int indice) {
        String sql = "DELETE FROM ParadaRuta WHERE idParadaRuta = ?";
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setInt(1, indice);
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            System.err.println("Error en ParadaRutaDAO.eliminar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la ParadaRuta de la base de datos.", e);
        }
        return ok;
    }

    public boolean modificar(ParadaRuta pr) {
        String sql = "UPDATE ParadaRuta SET idRuta=?, idAgencia=?, orden=? WHERE idParadaRuta=?";
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            con.setAutoCommit(false);
            ps.setInt(1, pr.getIdRuta());
            ps.setInt(2, pr.getIdAgencia());
            ps.setInt(3, pr.getOrden());
            
            if(ps.executeUpdate()>0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            System.err.println("Error en ParadaRutaDAO.modificar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al modificar la ParadaRuta en la base de datos.", e);
        }
        return ok;
    }

    public ParadaRuta buscar(int indice) {
        String sql = """
                     SELECT
                     	PR.*, A.nombre
                     FROM 
                     	ParadaRuta PR INNER JOIN Agencia A ON A.idAgencia = PR.idAgencia
                     WHERE idParadaRuta = ?
                     """;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, indice);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return mapear(rs);
            }    
        } catch(Exception e) {
            System.err.println("Error en ParadaRutaDAO.buscar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la ParadaRuta por ID en la base de datos.", e);
        }
        return null;
    }

    public List<ParadaRuta> listar() {
        String sql = """
                     SELECT
                     	PR.*, A.nombre
                     FROM 
                     	ParadaRuta PR INNER JOIN Agencia A ON A.idAgencia = PR.idAgencia
                     ORDER BY PR.idRuta, PR.orden
                     """;
        List<ParadaRuta> lista = new ArrayList<>();
        
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                lista.add(mapear(rs));
            }    
        } catch(Exception e) {
            System.err.println("Error en ParadaRutaDAO.listar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar ParadaRutas de la base de datos.", e);
        }
        return lista;
    }
    
    // --- Método para mapear un ResultSet a un objeto ParadaRuta ---
    private ParadaRuta mapear(ResultSet rs) throws Exception {
        ParadaRuta parada = new ParadaRuta();
        
        parada.setIdParadaRuta(rs.getInt("idParadaRuta"));
        parada.setIdRuta(rs.getInt("idRuta"));
        parada.setIdAgencia(rs.getInt("idAgencia"));
        parada.setOrden(rs.getInt("orden"));
        parada.setNombreAgencia(rs.getString("nombre"));
        
        return parada;
    }
}
