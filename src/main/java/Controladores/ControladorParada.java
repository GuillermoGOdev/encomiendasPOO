
package Controladores;

import DAO.ParadaRutaDAO;
import DTO.ParadaRuta;
import java.util.List;

public class ControladorParada {
    ParadaRutaDAO paradaDAO = new ParadaRutaDAO();
    
    public List<ParadaRuta> listarParada() { 
        return paradaDAO.listar();
    }
    
    public List<ParadaRuta> listarParadaPorRuta(int idRuta) { 
        return paradaDAO.listarPorRuta(idRuta);
    }
    
    public boolean eliminarParadasPorRuta(int idRuta) {
        return paradaDAO.eliminarParadasPorRuta(idRuta);
    }
}
