
package Controladores;

import DAO.MetodoPagoDAO;
import DTO.MetodoPago;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ControladorMetodoPago {
    private MetodoPagoDAO metodoPagoDAO;
    private Map<String, Integer> mapMetodosPago = new HashMap<>();

    public ControladorMetodoPago() {
        metodoPagoDAO = new MetodoPagoDAO();
        cargarMetodosPago();
    }
    
    private void cargarMetodosPago(){
        List<MetodoPago> lista = metodoPagoDAO.listar();
        
        mapMetodosPago.clear();
        for (MetodoPago mp : lista) {
            mapMetodosPago.put(mp.getNombre(), mp.getIdMetodoPago());
        }
    }
    
    //La vista usa este metodo para obtener los nombres
    public List<MetodoPago> obtenerMetodosPago(){
        return metodoPagoDAO.listar();
    }
    
    //La vista usa este metodo para obtener el ID del nombre seleccionado
    public int obtenerIdMetodoPago(String nombre){
        return mapMetodosPago.getOrDefault(nombre, -1);
    }
    
    public MetodoPago buscarPorId(int id) {
        return metodoPagoDAO.buscar(id);
    }
}
