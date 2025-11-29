
package Controladores;

import DAO.ClienteDAO;
import DAO.PersonaDAO;
import DTO.Cliente;
import DTO.Persona;
import java.util.*;


public class ControladorCliente {
    private final PersonaDAO personaDAO;
    private final ClienteDAO clienteDAO;

    public ControladorCliente() {
        personaDAO = new PersonaDAO();
        clienteDAO = new ClienteDAO();
    }

    // REGISTRAR CLIENTE (persona + cliente)
    public boolean registrarCliente(Cliente c) {

        // 1. Registrar persona
        int idPersona = personaDAO.registrar(c);

        if (idPersona <= 0) {
            return false;
        }

        // 2. Registrar cliente
        c.setIdpersona(idPersona);

        return clienteDAO.registrar(c);
    }

    // LISTAR CLIENTES
    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }
    
    public Cliente obtenerID(int id){
        return clienteDAO.obtenerPorId(id);
    }
    public boolean actualizarCliente(Cliente c){
        return clienteDAO.actualizar(c);
    }

    public boolean eliminarCliente(int id){
        return clienteDAO.eliminar(id);
    }
    
    // BUSCAR POR DNI
    public Cliente buscarPorDni(String dni) {
        return clienteDAO.obtenerPorDni(dni);
    }
}
