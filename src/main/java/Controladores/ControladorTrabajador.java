
package Controladores;

import DAO.PersonaDAO;
import DTO.Trabajador;
import DAO.TrabajadorDAO;
import java.util.List;


public class ControladorTrabajador {
    private final PersonaDAO personaDAO;
    private final TrabajadorDAO trabajadorDAO;

    public ControladorTrabajador() {
        personaDAO = new PersonaDAO();
        trabajadorDAO = new TrabajadorDAO();
    }
    
    // REGISTRAR TRABAJADOR (persona + trabajador)
    public boolean registrarTrabajador(Trabajador t) {

        // 1. Registrar persona
        int idPersona = personaDAO.registrar(t);

        if (idPersona <= 0) {
            return false;
        }

        // 2. Registrar cliente
        t.setIdpersona(idPersona);

        return trabajadorDAO.registrar(t);
    }
    
    // LISTAR CLIENTES
    public List<Trabajador> listarTrabajadores() {
        return trabajadorDAO.listar();
    }
    
    public boolean eliminarTrabajador(int id){
        return trabajadorDAO.eliminar(id);
    }
    
    public Trabajador obtenerID(int id){
        return trabajadorDAO.obtenerPorId(id);
    }
    public boolean actualizarTrabajador(Trabajador t){
        return trabajadorDAO.actualizar(t);
    }
}
