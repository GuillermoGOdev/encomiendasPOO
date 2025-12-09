package Controladores;

import DAO.ClienteDAO;
import DAO.EncomiendaDAO;
import DTO.Encomienda;
import DTO.TipoPaquete;
import Vistas.ModuloRegistrarEncomienda;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorModuloEncomienda {
    private EncomiendaDAO dao;
    private TipoPaquete tipoPaquete;


    public ControladorModuloEncomienda() {
        this.dao = new EncomiendaDAO();
    }
    
    public boolean pagarEncomienda(int id) {
        return dao.pagar(id);
    }
    
    // MÉTODO PRINCIPAL: REGISTRAR ENCOMIENDA
    public boolean editarEncomienda(
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
            int idMetodoPago,
            String pago
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
        en.setPago(pago);

        // GUARDAR
        boolean guardado = dao.modificar(en);
        return guardado;
    }
    
    public DefaultTableModel obtenerEncomiendas(String dni, java.sql.Date fecha) {
        return dao.listarEncomiendas(dni, fecha);
    }
    
    public boolean eliminarEncomienda(int id) {
        return dao.eliminar(id);
    }
}
