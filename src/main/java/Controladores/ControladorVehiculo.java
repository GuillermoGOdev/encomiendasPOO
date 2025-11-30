
package Controladores;

import DAO.VehiculoDAO;
import DTO.Vehiculo;

import java.util.List;


public class ControladorVehiculo {
    VehiculoDAO dao = new VehiculoDAO();

    public boolean registrar(Vehiculo v) {
        return dao.registrarVehiculo(v); 
    }

    public List<Vehiculo> listar() { 
        return dao.listarVehiculos(); 
    }

    public boolean actualizar(Vehiculo v) { 
        return dao.actualizarVehiculo(v); 
    }

    public boolean eliminar(int id) {
        return dao.eliminarVehiculo(id);
    }

}
