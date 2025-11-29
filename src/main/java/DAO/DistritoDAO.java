package DAO;

import Conexion.ConexionSQL;
import DTO.Provincia;
import DTO.Distrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DistritoDAO {
    
    public List<Distrito> listarDistritos(Provincia p) {
        List<Distrito> lista = new ArrayList();
        String sql = "SELECT * FROM Distrito WHERE id_provincia =?";
        
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, p.getIdProvincia());
            ps.executeQuery();
            
            ResultSet rs = ps.getResultSet();
            
            while(rs.next()) {
                Distrito d = new Distrito();
                d.setIdDistrito(rs.getInt("idDistrito"));
                d.setDistrito(rs.getString("nombre"));
                lista.add(d);
            }
            
        } catch (Exception e) {
            System.err.println("Error en DistritoDAO.listarDistritos(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar distritos de la base de datos.", e);
        }
        return lista;
    }
    
    public Distrito buscarDistritoPorId(int idDistrito) {
        Distrito distrito = null;
        String sql = "SELECT * FROM Distrito WHERE idDistrito =?";
        
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idDistrito);
            ps.executeQuery();
            
            ResultSet rs = ps.getResultSet();
            
            if(rs.next()) {
                distrito = new Distrito();
                distrito.setIdDistrito(rs.getInt("idDistrito"));
                distrito.setDistrito(rs.getString("nombre"));
                distrito.setIdProvincia(rs.getInt("id_Provincia"));
            }
            
        } catch (Exception e) {
            System.err.println("Error en DistritoDAO.buscarDistritoPorId(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar distrito por ID en la base de datos.", e);
        }
        
        return distrito;
    }
}