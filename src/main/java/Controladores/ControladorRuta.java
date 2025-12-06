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
    public List<Ruta> listarRutas() {
        return rutaDAO.listar();
    }
//    public boolean eliminarRuta(int id){
//        return rutaDAO.eliminar(id);
//    }
     public boolean actualizarRuta(Ruta r){
        return rutaDAO.modificar(r);
    }
    
    
    // Jala la lista de departamentos de la BD
    public List<Agencia> obtenerAgencias() {
        try {
            return agenciaDAO.listar();
        } catch (RuntimeException e) {
            System.out.println("Error al cargar la lista de Agencias: \n" + e.getMessage());
            return Collections.emptyList(); // Devuelve lista vacía para evitar NPE en la vista
        }
    }
    
    public List<ParadaRuta> listarParadaRutas (int idRuta){
        return paradaDAO.listarPorRuta(idRuta);
    }
    
    public boolean eliminarRuta(int idRuta) {
    try {
        // 1. Eliminar paradas primero
        ControladorParada ctrl = new ControladorParada();
        ctrl.eliminarParadasPorRuta(idRuta);

        // 2. Ahora sí eliminar la ruta
        return rutaDAO.eliminar(idRuta);

    } catch (Exception e) {
        System.out.println("Error al eliminar ruta: " + e.getMessage());
        return false;
    }
}
}
