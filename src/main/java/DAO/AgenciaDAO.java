package DAO;

import Conexion.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DTO.Agencia;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO implements CRUD<Agencia>{
    
    @Override
    public boolean registrar(Agencia a) {
        String sql = "INSERT INTO Agencia (nombre, direccion, telefono, email, iddistrito) VALUES (?, ?, ?, ?, ?)";
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)){
            con.setAutoCommit(false);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getDireccion());
            ps.setString(3, a.getTelefono());
            ps.setString(4, a.getEmail());
            ps.setInt(5, a.getIdDistrito());
            
            if(ps.executeUpdate() > 0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            System.err.println("Error en AgenciaDAO.registrar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al registrar la agencia en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean eliminar(int indice) {
        String sql = "DELETE FROM Agencia WHERE idAgencia = ?";
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
            System.err.println("Error en AgenciaDAO.eliminar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la agencia de la base de datos.", e);
        }
        return ok;
    }

    @Override
    public boolean modificar(Agencia a) {
        String sql = "UPDATE Agencia SET nombre=?, direccion=?, telefono=?, email=?, iddistrito=? WHERE idAgencia=?";
        boolean ok = false;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            con.setAutoCommit(false);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getDireccion());
            ps.setString(3, a.getTelefono());
            ps.setString(4, a.getEmail());
            ps.setInt(5, a.getIdDistrito());
            ps.setInt(6, a.getIdAgencia());
            
            if(ps.executeUpdate()>0) {
                con.commit();
                ok = true;
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            System.err.println("Error en AgenciaDAO.modificar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al modificar la agencia en la base de datos.", e);
        }
        return ok;
    }

    @Override
    public Agencia buscar(int indice) {
        String sql = "SELECT * FROM Agencia WHERE idAgencia = ?";
        Agencia agencia = null;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, indice);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                agencia = new Agencia();
                agencia.setIdAgencia(rs.getInt("idAgencia"));
                agencia.setNombre(rs.getString("nombre"));
                agencia.setDireccion(rs.getString("direccion"));
                agencia.setTelefono(rs.getString("telefono"));
                agencia.setEmail(rs.getString("email"));
                agencia.setIdDistrito(rs.getInt("iddistrito"));
            }    
        } catch(Exception e) {
            System.err.println("Error en AgenciaDAO.buscar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la agencia por ID en la base de datos.", e);
        }
        return agencia;
    }

    @Override
    public List<Agencia> listar() {
        String sql = "SELECT * FROM Agencia";
        List<Agencia> lista = new ArrayList<>();
        
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();    
            while(rs.next()) {
                Agencia a = new Agencia();
                a.setIdAgencia(rs.getInt("idAgencia"));
                a.setNombre(rs.getString("nombre"));
                a.setDireccion(rs.getString("direccion"));
                a.setTelefono(rs.getString("telefono"));
                a.setEmail(rs.getString("email"));
                a.setIdDistrito(rs.getInt("iddistrito"));
                lista.add(a);
            }    
        } catch(Exception e) {
            System.err.println("Error en AgenciaDAO.listar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al listar agencias de la base de datos.", e);
        }
        return lista;
    }
    
    
    // EXTRA
    
    public Agencia buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM Agencia WHERE nombre = ?";
        Agencia agencia = null;
        try(Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                agencia = new Agencia();
                agencia.setIdAgencia(rs.getInt("idAgencia"));
                agencia.setNombre(rs.getString("nombre"));
                agencia.setDireccion(rs.getString("direccion"));
                agencia.setTelefono(rs.getString("telefono"));
                agencia.setEmail(rs.getString("email"));
                agencia.setIdDistrito(rs.getInt("iddistrito"));
            }    
        } catch(Exception e) {
            System.err.println("Error en AgenciaDAO.buscarPorNombre(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la agencia por nombre en la base de datos.", e);
        }
        return agencia;
    }
}