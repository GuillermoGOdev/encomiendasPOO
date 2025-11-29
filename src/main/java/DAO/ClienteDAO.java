package DAO;

import Conexion.ConexionSQL;
import DTO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.*;

public class ClienteDAO {
    // REGISTRAR CLIENTE
    public boolean registrar(Cliente c) {
        String sqlCliente = "INSERT INTO Cliente (fecha_registro, estado, idpersona) VALUES (?, ?, ?)";

        try (Connection con = ConexionSQL.conectar()) {

            PreparedStatement ps = con.prepareStatement(sqlCliente);
            ps.setString(1, c.getFecha_registro());
            ps.setString(2, c.getEstado());
            ps.setInt(3, c.getIdpersona());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error registrando Cliente: " + e.getMessage());
            return false;
        }
    }

    // BUSCAR POR IDCLIENTE
    public Cliente obtenerPorId(int idCliente) {

        String sql = """
            SELECT c.idcliente, c.fecha_registro, c.estado,
                   p.idpersona, p.nombres, p.apellido_paterno, p.apellido_materno,
                   p.dni, p.telefono, p.email, p.direccion
            FROM Cliente c
            INNER JOIN Persona p ON c.idpersona = p.idpersona
            WHERE c.idcliente = ?
            """;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return mapear(rs);

        } catch (Exception e) {
            System.err.println("Error obteniendo Cliente: " + e.getMessage());
        }

        return null;
    }

    // BUSCAR POR DNI
    public Cliente obtenerPorDni(String dni) {

        String sql = """
            SELECT c.idcliente, c.fecha_registro, c.estado,
                   p.idpersona, p.nombres, p.apellido_paterno, p.apellido_materno,
                   p.dni, p.telefono, p.email, p.direccion
            FROM Cliente c
            INNER JOIN Persona p ON c.idpersona = p.idpersona
            WHERE p.dni = ?
            """;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return mapear(rs);

        } catch (Exception e) {
            System.err.println("Error buscando Cliente por DNI: " + e.getMessage());
        }

        return null;
    }

    // LISTAR CLIENTES
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();

        String sql = """
            SELECT c.idcliente, c.fecha_registro, c.estado,
                   p.idpersona, p.nombres, p.apellido_paterno, p.apellido_materno,
                   p.dni, p.telefono, p.email, p.direccion
            FROM Cliente c
            INNER JOIN Persona p ON c.idpersona = p.idpersona
            """;

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) lista.add(mapear(rs));

        } catch (Exception e) {
            System.err.println("Error listando clientes: " + e.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR CLIENTE + PERSONA
    public boolean actualizar(Cliente c) {
        String sql = "UPDATE Cliente SET fecha_registro=?, estado=? WHERE idcliente=?";

        try (Connection con = ConexionSQL.conectar()) {
            con.setAutoCommit(false);

            // 1. Actualizar persona
            PersonaDAO personaDAO = new PersonaDAO();
            if (!personaDAO.actualizar(c)) {
                con.rollback();
                return false;
            }

            // 2. Actualizar cliente
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getFecha_registro());
            ps.setString(2, c.getEstado());
            ps.setInt(3, c.getIdcliente());

            if (ps.executeUpdate() == 0) {
                con.rollback();
                return false;
            }

            con.commit();
            return true;

        } catch (Exception e) {
            System.err.println("Error actualizando cliente: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int idCliente) {
        String sql = "DELETE FROM Cliente WHERE idcliente=?";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error eliminando Cliente: " + e.getMessage());
            return false;
        }
    }

    // MAPEO
    private Cliente mapear(ResultSet rs) throws Exception {
        Cliente c = new Cliente();

        c.setIdcliente(rs.getInt("idcliente"));
        c.setFecha_registro(rs.getString("fecha_registro"));
        c.setEstado(rs.getString("estado"));

        // Datos de persona
        c.setIdpersona(rs.getInt("idpersona"));
        c.setNombres(rs.getString("nombres"));
        c.setApellido_paterno(rs.getString("apellido_paterno"));
        c.setApellido_materno(rs.getString("apellido_materno"));
        c.setDni(rs.getString("dni"));
        c.setTelefono(rs.getString("telefono"));
        c.setEmail(rs.getString("email"));
        c.setDireccion(rs.getString("direccion"));
        
        return c;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*public boolean registrarCliente(Cliente c) {
        String sqlpersona = "INSERT INTO Persona (nombres, apellido_paterno, apellido_materno, dni, telefono, email, direccion) values (?,?,?,?,?,?,?)";
        String sqlcliente = "INSERT INTO Cliente(fecha_registro, idpersona) values (?,?)";
        boolean ok = false;
        try (Connection con = ConexionSQL.conectar(); PreparedStatement psPersona = con.prepareStatement(sqlpersona, new String[]{"id_persona"}); PreparedStatement psCliente = con.prepareStatement(sqlcliente)) {

            con.setAutoCommit(false); //Inicia

            psPersona.setString(1, c.getNombres());
            psPersona.setString(2, c.getApellido_paterno());
            psPersona.setString(3, c.getApellido_materno());
            psPersona.setString(4, c.getDni());
            psPersona.setString(5, c.getTelefono());
            psPersona.setString(6, c.getEmail());
            psPersona.setString(7, c.getDireccion());

            if (psPersona.executeUpdate()==0) {
                con.rollback();
                return false;
            }
            // ID
            ResultSet rs = psPersona.getGeneratedKeys();
            int idPersona = 0;
            if (rs.next()) {
                idPersona = rs.getInt(1);
            } else {
                con.rollback();
                return false;
            }

            // CLIENTE
            java.sql.Date fechaSQL = java.sql.Date.valueOf(c.getFecha_registro());
            psCliente.setDate(1, fechaSQL);
            psCliente.setInt(2, idPersona);

            if (psCliente.executeUpdate() > 0) {
                con.commit(); // commit de toda la transacción
                ok = true;
            } else {
                con.rollback();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar cliente: " + e);
        }
        return ok;
    }*/
}
