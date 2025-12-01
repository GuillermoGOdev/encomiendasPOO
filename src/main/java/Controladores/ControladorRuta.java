package Controladores;

import DAO.AgenciaDAO;
import DAO.ParadaRutaDAO;
import DAO.RutaDAO;
import DTO.Agencia;
import DTO.ParadaRuta;
import DTO.Ruta;
import java.util.Collections;
import java.util.List;

public class ControladorRuta {
    private final RutaDAO rutaDAO;
    private final ParadaRutaDAO paradaDAO;
    private final AgenciaDAO agenciaDAO;

    public ControladorRuta() {
        this.rutaDAO = new RutaDAO();
        this.paradaDAO = new ParadaRutaDAO();
        this.agenciaDAO = new AgenciaDAO();
    }
    
    // REGISTRAR RUTA (ruta + paradas)
    public boolean registrarRuta(Ruta r, List<ParadaRuta> paradas) {

        // 1. Registrar ruta
        int idRuta = rutaDAO.registrar(r);
        
        if (idRuta <= 0) {
            return false;
        }

        // 2. Registrar paradas
        for(ParadaRuta pr : paradas) {
            pr.setIdRuta(idRuta);
        }
        return paradaDAO.registrar(paradas);
    }
    /*
    // LISTAR RUTAS
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
*/
    
    // Jala la lista de departamentos de la BD
    public List<Agencia> obtenerAgencias() {
        try {
            return agenciaDAO.listar();
        } catch (RuntimeException e) {
            System.out.println("Error al cargar la lista de Agencias: \n" + e.getMessage());
            return Collections.emptyList(); // Devuelve lista vacía para evitar NPE en la vista
        }
    }
}
