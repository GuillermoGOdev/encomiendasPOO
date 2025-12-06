package DAO;

import Conexion.ConexionSQL;
import DTO.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RutaDAO {

    public int registrar(Ruta r) {
        String sql = "INSERT INTO Ruta (descripcion, costo_base, tiempo_estimado_horas, distancia_km) VALUES (?, ?, ?, ?)";
        int idGenerado = -1;
        try(Connection con = ConexionSQL.conectar();
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            con.setAutoCommit(false);
            ps.setString(1, r.getDescripcion());
            ps.setDouble(2, r.getCostoBase());
            ps.setDouble(3, r.getTiempoEstimadoHoras());
            ps.setDouble(4, r.getDistanciaKm());
            
            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) idGenerado = rs.getInt(1);
                con.commit();
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            System.err.println("Error en RutaDAO.registrar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al registrar la Ruta en la base de datos.", e);
        }
        return idGenerado;
    }

    public boolean eliminar(int indice) {
        String sql = "DELETE FROM Ruta WHERE id_ruta = ?";
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
            System.err.println("Error en RutaDAO.eliminar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la Ruta de la base de datos.", e);
        }
        return ok;
    }

    public boolean modificar(Ruta r) {
        String sql = "UPDATE Ruta SET descripcion=?, costo_base=?, tiempo_estimado_horas=?, distancia_km=? WHERE id_ruta=?";
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            con.setAutoCommit(false);
            ps.setString(1, r.getDescripcion());
            ps.setDouble(2, r.getCostoBase());
            ps.setDouble(3, r.getTiempoEstimadoHoras());
            ps.setDouble(4, r.getDistanciaKm());
            ps.setInt(5, r.getIdRuta());
            
            if(ps.executeUpdate()>0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            System.err.println("Error en RutaDAO.modificar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al modificar la Ruta en la base de datos.", e);
        }
        return ok;
    }

    public Ruta buscar(int indice) {
        String sql = "SELECT * FROM Ruta WHERE id_ruta = ?";
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, indice);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return mapear(rs);
            }    
        } catch(Exception e) {
            System.err.println("Error en RutaDAO.buscar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la Ruta por ID en la base de datos.", e);
        }
        return null;
    }

    public List<Ruta> listar() {
        String sql = "SELECT * FROM Ruta";
        List<Ruta> lista = new ArrayList<>();
        
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                lista.add(mapear(rs));
            }    
        } catch(Exception e) {
            System.err.println("Error en RutaDAO.listar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar Rutas de la base de datos.", e);
        }
        return lista;
    }
    
    public Ruta obtenerRutaPorAgencias(int idAgenciaOrigen, int idAgenciaDestino) {
        String sql = """
                     SELECT R.id_ruta, R.descripcion, R.costo_base, R.tiempo_estimado_horas, R.distancia_km 
                     FROM Ruta AS R 
                     INNER JOIN ParadaRuta AS PR_Origen ON R.id_ruta = PR_Origen.idRuta 
                     INNER JOIN ParadaRuta AS PR_Destino ON R.id_ruta = PR_Destino.idRuta 
                     WHERE PR_Origen.idAgencia = ? AND PR_Destino.idAgencia = ? AND PR_Origen.orden < PR_Destino.orden
                     LIMIT 1
                     """;

        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAgenciaOrigen);
            ps.setInt(2, idAgenciaDestino);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return mapear(rs);
            }    
        } catch(Exception e) {
            System.err.println("Error en RutaDAO.obtenerRutaPorAgencias(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la Ruta por Agencias en la base de datos.", e);
        }
        return null;
    }
    
    // --- Método para mapear un ResultSet a un objeto Ruta ---
    private Ruta mapear(ResultSet rs) throws Exception {
        Ruta ruta = new Ruta();
        
        ruta.setIdRuta(rs.getInt("id_ruta"));
        ruta.setDescripcion(rs.getString("descripcion"));
        ruta.setCostoBase(rs.getDouble("costo_base"));
        ruta.setTiempoEstimadoHoras(rs.getDouble("tiempo_estimado_horas"));
        ruta.setDistanciaKm(rs.getDouble("distancia_km"));
        
        return ruta;
    }
}
