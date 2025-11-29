package DAO;

import Conexion.ConexionSQL;
import DTO.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    
    public List<Departamento> listarDepartamentos() {
        List<Departamento> lista = new ArrayList();
        String sql = "SELECT * FROM Departamento";
        
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.executeQuery();
            
            ResultSet rs = ps.getResultSet();
            
            while(rs.next()) {
                Departamento d = new Departamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setDepartamento(rs.getString("nombre"));
                lista.add(d);
            }
            
        } catch (Exception e) {
            System.err.println("Error en DepartamentoDAO.listarDepartamentos(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar los departamentos de la base de datos.", e);
        }
        return lista;
    }
    
    public Departamento buscarDepartamentoPorId(int idDepartamento) {
        Departamento departamento = null;
        String sql = "SELECT * FROM Departamento WHERE idDepartamento =?";
        
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idDepartamento);
            ps.executeQuery();
            
            ResultSet rs = ps.getResultSet();
            
            if(rs.next()) {
                departamento = new Departamento();
                departamento.setIdDepartamento(rs.getInt("idDepartamento"));
                departamento.setDepartamento(rs.getString("nombre"));
            }
            
        } catch (Exception e) {
            System.err.println("Error en DepartamentoDAO.buscarDepartamentoPorId(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar departamento por ID en la base de datos.", e);
        }
        
        return departamento;
    }
}
