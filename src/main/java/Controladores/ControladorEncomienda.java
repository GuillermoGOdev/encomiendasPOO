
package Controladores;

import DAO.ClienteDAO;
import DAO.EncomiendaDAO;
import DAO.RutaDAO;
import DTO.Encomienda;


public class ControladorEncomienda {
    private EncomiendaDAO dao;
    private final ClienteDAO clienteDAO;
    private final RutaDAO rutaDAO;

    public ControladorEncomienda() {
        this.dao = new EncomiendaDAO();
        this.clienteDAO = new ClienteDAO();
        this.rutaDAO = new RutaDAO();
        
    }
    
    // MÉTODO PRINCIPAL: REGISTRAR ENCOMIENDA
    public String registrarEncomienda(
            int idRemitente,
            int idDestinatario,
            int idRuta,
            String descripcion,
            String peso,
            String largo,
            String alto,
            String ancho,
            String costo,
            int idTrabajador
    ) {

        // VALIDACIONES
        if (idRemitente <= 0) return "Debe seleccionar un cliente remitente.";
        if (idDestinatario <= 0) return "Debe seleccionar un cliente destinatario.";
        if (idRuta <= 0) return "Debe seleccionar una ruta.";
        if (descripcion == null || descripcion.trim().isEmpty()) return "La descripción es obligatoria.";

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

        
        // CREAR OBJETO ENCOMIENDA
        Encomienda en = new Encomienda();
        en.setIdClienteRemitente(idRemitente);
        en.setIdClienteDestinatario(idDestinatario);
        en.setIdRuta(idRuta);
        en.setDescripcion(descripcion);
        en.setPeso_kg(pesoD);
        en.setLargo(largoD);
        en.setAlto(altoD);
        en.setAncho(anchoD);
        en.setCostoEnvio(costoD);
        en.setFecha_Envio(new java.util.Date());
        en.setEstado("En tránsito");
        en.setIdTrabajador(idTrabajador);

        // GUARDAR
        boolean guardado = dao.registrar(en);

        if (guardado) {
            return "OK";
        } else {
            return "Error al registrar la encomienda.";
        }
    }

}
