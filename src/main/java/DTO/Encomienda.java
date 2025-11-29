package DTO;

import java.util.Date;

public class Encomienda {

    private int IdEncomienda, IdClienteRemitente, IdClienteDestinatario, IdRuta, IdTrabajador;
    private String Descripcion, Estado;
    public double Peso_kg, Largo, Alto, Ancho, CostoEnvio;
    private Date Fecha_Envio;

   

    public Encomienda() {
    }

    public Encomienda(int IdClienteRemitente, int IdClienteDestinatario, int IdRuta, int IdTrabajador, String Descripcion, String Estado, double Peso_kg, double Largo, double Alto, double Ancho, double CostoEnvio, Date Fecha_Envio) {
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
    }

    public Encomienda(int IdEncomienda, int IdClienteRemitente, int IdClienteDestinatario, int IdRuta, int IdTrabajador, String Descripcion, String Estado, double Peso_kg, double Largo, double Alto, double Ancho, double CostoEnvio, Date Fecha_Envio) {
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

    public void setFecha_Envio(Date Fecha_Envio) {
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

    public Date getFecha_Envio() {
        return Fecha_Envio;
    }

}
