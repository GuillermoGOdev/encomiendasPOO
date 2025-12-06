
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
    
//    private void cargarTarifas() {
//        tarifas.put("Sobre", new TarifaPaquete("Sobre", 4, 0));
//        tarifas.put("Caja paquete XXS", new TarifaPaquete("Caja paquete XXS", 5, 0.3));
//        tarifas.put("Caja paquete XS", new TarifaPaquete("Caja paquete XS", 6, 0.5));
//        tarifas.put("Caja paquete S", new TarifaPaquete("Caja paquete S", 8, 1));
//        tarifas.put("Caja paquete M", new TarifaPaquete("Caja paquete M", 12, 1.2));
//        tarifas.put("Caja paquete L", new TarifaPaquete("Caja paquete L", 18, 1.5));
//    }
    
//    private double calcularCosto(){
//        TarifaPaquete tarifa = tarifas.get(TipoPaquete);
//        return tarifa.getCostoBase() + tarifa.getTarifaPorKilo() * pesoM
//    }
    
    
    // MÉTODO PRINCIPAL: REGISTRAR ENCOMIENDA
    public String registrarEncomienda(
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

        // VALIDACIONES
        if (idRemitente <= 0) return "Debe seleccionar un cliente remitente.";
        if (idDestinatario <= 0) return "Debe seleccionar un cliente destinatario.";
        if (idRuta <= 0) return "Debe seleccionar una ruta.";
        if (descripcion == null || descripcion.trim().isEmpty()) return "La descripción es obligatoria.";

        /*
        // Validar campos vacíos numéricos
        if (peso.isEmpty() || largo.isEmpty() || alto.isEmpty() || ancho.isEmpty() || costo.isEmpty())
            return "Todos los campos numéricos son obligatorios.";
        
        // Validar números
        double pesoD, largoD, altoD, anchoD, costoD;
        try {
            pesoD = Double.parseDouble(peso);
            largoD = Double.parseDouble(largo);
            altoD = Double.parseDouble(alto);
            anchoD = Double.parseDouble(ancho);
            costoD = Double.parseDouble(costo);

        } catch (NumberFormatException e) {
            return "Todos los campos numéricos deben ser válidos.";
        }
        
        if (pesoD <= 0) return "El peso debe ser mayor a 0.";
        if (largoD <= 0 || altoD <= 0 || anchoD <= 0)
            return "Las dimensiones deben ser mayores a 0.";
        if (costoD < 0) return "El costo no puede ser negativo.";
        */
        
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

        if (guardado) {
            return "OK";
        } else {
            return "Error al registrar la encomienda.";
        }
    }

    public Ruta obtenerRuta(int origen, int destino) {
        return rutaDAO.obtenerRutaPorAgencias(origen, destino);
    }
    
}
