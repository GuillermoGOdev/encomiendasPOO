
package Controladores;

import DAO.ClienteDAO;
import DAO.EncomiendaDAO;
import DAO.RutaDAO;
import DTO.Encomienda;
import DTO.Ruta;
import DTO.TipoPaquete;
import java.util.HashMap;
import Vistas.ModuloRegistrarEncomienda;


public class ControladorEncomienda {
    private EncomiendaDAO dao;
    private final ClienteDAO clienteDAO;
    private final RutaDAO rutaDAO;
    private HashMap<String, Object> tarifas = new HashMap<>();
    private ModuloRegistrarEncomienda vista;
    private TipoPaquete tipoPaquete;


    public ControladorEncomienda() {
        this.dao = new EncomiendaDAO();
        this.clienteDAO = new ClienteDAO();
        this.rutaDAO = new RutaDAO();
        this.vista = new ModuloRegistrarEncomienda();
//        this.tipoPaquete = new TipoPaquete(nombre, 0, 0, 0, 0)
        
    }
    
    // MÉTODO PRINCIPAL: REGISTRAR ENCOMIENDA
    public boolean registrarEncomienda(
            int idRemitente,
            int idDestinatario,
            int idRuta,
            String descripcion,
            double peso,
            double largo,
            double alto,
            double ancho,
            double costo,
            String fecha_envio,
            String estado,
            int idTrabajador,
            int idMetodoPago
    ) {        
        // CREAR OBJETO ENCOMIENDA
        Encomienda en = new Encomienda();
        en.setIdClienteRemitente(idRemitente);
        en.setIdClienteDestinatario(idDestinatario);
        en.setIdRuta(idRuta);
        en.setDescripcion(descripcion);
        en.setPeso_kg(peso);
        en.setLargo(largo);
        en.setAlto(alto);
        en.setAncho(ancho);
        en.setCostoEnvio(costo);
        en.setFecha_Envio(fecha_envio);
        en.setEstado(estado);
        en.setIdTrabajador(idTrabajador);
        en.setIdMetodoPago(idMetodoPago);

        // GUARDAR
        boolean guardado = dao.registrar(en);
        return guardado;
    }

    public Ruta obtenerRuta(int origen, int destino) {
        return rutaDAO.obtenerRutaPorAgencias(origen, destino);
    }
    
    public Encomienda buscarPorId(int id) {
        return dao.buscar(id);
    }
    
}
