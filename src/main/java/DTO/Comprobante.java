
package DTO;

import java.sql.Date;

public class Comprobante {
    private int idComprobante, idEncomienda;
    private String tipo, serie;
    private int numero;
    private java.sql.Date fechaEmision;
    private double subtotal, igv, total;
    private int idMetodoPago;

    
    public Comprobante(){}
    
    public Comprobante(int idComprobante, int idEncomienda, String tipo, String serie, int numero, Date fechaEmision, double subtotal, double igv, double total, int idMetodoPago) {
        this.idComprobante = idComprobante;
        this.idEncomienda = idEncomienda;
        this.tipo = tipo;
        this.serie = serie;
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.idMetodoPago = idMetodoPago;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getIdEncomienda() {
        return idEncomienda;
    }

    public void setIdEncomienda(int idEncomienda) {
        this.idEncomienda = idEncomienda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
    
    
    
}
