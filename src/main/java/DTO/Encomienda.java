package DTO;

import java.util.Date;

public class Encomienda {

    private int IdEncomienda, IdClienteRemitente, IdClienteDestinatario, IdRuta, IdTrabajador, idMetodoPago;
    private String Descripcion, Estado, Fecha_Envio;
    public double Peso_kg, Largo, Alto, Ancho, CostoEnvio;

    public Encomienda(int IdEncomienda, double Peso_kg, double Largo, double Alto, double Ancho) {
        this.IdEncomienda = IdEncomienda;
        this.Peso_kg = Peso_kg;
        this.Largo = Largo;
        this.Alto = Alto;
        this.Ancho = Ancho;
    }

    public Encomienda() {
    }

    public Encomienda(int IdClienteRemitente, int IdClienteDestinatario, int IdRuta, String Descripcion, double Peso_kg, double Largo, double Alto, double Ancho, double CostoEnvio, String Fecha_Envio, String Estado, int IdTrabajador, int idMetodoPago) {
        this.IdClienteRemitente = IdClienteRemitente;
        this.IdClienteDestinatario = IdClienteDestinatario;
        this.IdRuta = IdRuta;
        this.IdTrabajador = IdTrabajador;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Peso_kg = Peso_kg;
        this.Largo = Largo;
        this.Alto = Alto;
        this.Ancho = Ancho;
        this.CostoEnvio = CostoEnvio;
        this.Fecha_Envio = Fecha_Envio;
        this.idMetodoPago = idMetodoPago;
    }
    
    public Encomienda(int IdEncomienda, int IdClienteRemitente, int IdClienteDestinatario, int IdRuta, String Descripcion, double Peso_kg, double Largo, double Alto, double Ancho, double CostoEnvio, String Fecha_Envio, String Estado, int IdTrabajador, int idMetodoPago) {
        this.IdEncomienda = IdEncomienda;
        this.IdClienteRemitente = IdClienteRemitente;
        this.IdClienteDestinatario = IdClienteDestinatario;
        this.IdRuta = IdRuta;
        this.IdTrabajador = IdTrabajador;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Peso_kg = Peso_kg;
        this.Largo = Largo;
        this.Alto = Alto;
        this.Ancho = Ancho;
        this.CostoEnvio = CostoEnvio;
        this.Fecha_Envio = Fecha_Envio;
        this.idMetodoPago = idMetodoPago;
    }

    public void setIdEncomienda(int IdEncomienda) {
        this.IdEncomienda = IdEncomienda;
    }

    public void setIdClienteRemitente(int IdClienteRemitente) {
        this.IdClienteRemitente = IdClienteRemitente;
    }

    public void setIdClienteDestinatario(int IdClienteDestinatario) {
        this.IdClienteDestinatario = IdClienteDestinatario;
    }

    public void setIdRuta(int IdRuta) {
        this.IdRuta = IdRuta;
    }

    public void setIdTrabajador(int IdTrabajador) {
        this.IdTrabajador = IdTrabajador;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setPeso_kg(double Peso_kg) {
        this.Peso_kg = Peso_kg;
    }

    public void setLargo(double Largo) {
        this.Largo = Largo;
    }

    public void setAlto(double Alto) {
        this.Alto = Alto;
    }

    public void setAncho(double Ancho) {
        this.Ancho = Ancho;
    }

    public void setCostoEnvio(double CostoEnvio) {
        this.CostoEnvio = CostoEnvio;
    }

    public void setFecha_Envio(String Fecha_Envio) {
        this.Fecha_Envio = Fecha_Envio;
    }

    public int getIdEncomienda() {
        return IdEncomienda;
    }

    public int getIdClienteRemitente() {
        return IdClienteRemitente;
    }

    public int getIdClienteDestinatario() {
        return IdClienteDestinatario;
    }

    public int getIdRuta() {
        return IdRuta;
    }

    public int getIdTrabajador() {
        return IdTrabajador;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public double getPeso_kg() {
        return Peso_kg;
    }

    public double getLargo() {
        return Largo;
    }

    public double getAlto() {
        return Alto;
    }

    public double getAncho() {
        return Ancho;
    }

    public double getCostoEnvio() {
        return CostoEnvio;
    }

    public String getFecha_Envio() {
        return Fecha_Envio;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
}
