package DAO;

import Conexion.ConexionSQL;
import DTO.Departamento;
import DTO.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaDAO {
    
    public List<Provincia> listarProvincias(Departamento d) {
        List<Provincia> lista = new ArrayList();
        String sql = "SELECT * FROM Provincia WHERE id_departamento =?";
        
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, d.getIdDepartamento());
            ps.executeQuery();
            
            ResultSet rs = ps.getResultSet();
            
            while(rs.next()) {
                Provincia p = new Provincia();
                p.setIdProvincia(rs.getInt("idProvincia"));
                p.setProvincia(rs.getString("nombre"));
                lista.add(p);
            }
            
        } catch (Exception e) {
            System.err.println("Error en ProvinciaDAO.listarProvincias(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar provincias de la base de datos.", e);
        }
        return lista;
    }
    
    public Provincia buscarProvinciaPorId(int idProvincia) {
        Provincia provincia = null;
        String sql = "SELECT * FROM Provincia WHERE idProvincia =?";
        
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idProvincia);
            ps.executeQuery();
            
            ResultSet rs = ps.getResultSet();
            
            if(rs.next()) {
                provincia = new Provincia();
                provincia.setIdProvincia(rs.getInt("idProvincia"));
                provincia.setProvincia(rs.getString("nombre"));
                provincia.setIdDepartamento(rs.getInt("id_departamento"));
            }
            
        } catch (Exception e) {
            System.err.println("Error en ProvinciaDAO.buscarProvinciaPorId(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar provincia por ID en la base de datos.", e);
        }
        
        return provincia;
    }
}
