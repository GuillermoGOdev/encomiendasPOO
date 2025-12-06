
package Controladores;

import DAO.ComprobanteDAO;
import DTO.Comprobante;
import java.util.List;

public class ControladorComprobante {
    private ComprobanteDAO dao;

    public ControladorComprobante() {
        dao = new ComprobanteDAO();
    }

    // ---- Registrar comprobante ----
    public boolean registrarComprobante(Comprobante c) {
        validarComprobante(c);
        return dao.registrar(c);
    }

    // ---- Listar comprobantes ----
    public List<Comprobante> listarComprobantes() {
        return dao.listar();
    }

    // ---- Buscar comprobante por ID ----
    public Comprobante buscarPorId(int id) {
        return dao.buscar(id);
    }

//    // ---- Buscar por Encomienda ----
//    public Comprobante buscarPorEncomienda(int idEncomienda) {
//        return dao.buscar(idEncomienda);
//    }

    // ---- Cálculo de totales ----
    public double calcularSubtotal(double precioServicio) {
        return precioServicio;
    }

    public double calcularIGV(double subtotal) {
        return subtotal * 0.18;
    }

    public double calcularTotal(double subtotal, double igv) {
        return subtotal + igv;
    }

    // ---- Validaciones ----
    private void validarComprobante(Comprobante c) {
        if (c.getTipo() == null || c.getTipo().isEmpty())
            throw new IllegalArgumentException("El tipo de comprobante es obligatorio");

        if (c.getSubtotal() < 0)
            throw new IllegalArgumentException("El subtotal no puede ser negativo");

        if (c.getIdMetodoPago() <= 0)
            throw new IllegalArgumentException("Debe seleccionar un método de pago");
    }

}
