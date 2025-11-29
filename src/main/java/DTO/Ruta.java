package DTO;

public class Ruta {

    private int idRuta, idAgenciaOrigen, idAgenciaDestino;
    private String descripcion;
    private double distanciaKm, tiempoEstimadoHoras, costoBase;
    
    public Ruta(){
        
    }
    
    public Ruta(int idRuta, String descripcion, int idAgenciaOrigen,
            int idAgenciaDestino, double distanciaKm, double tiempoEstimadoHoras, double costoBase) {
        this.idRuta = idRuta;
        this.descripcion = descripcion;
        this.idAgenciaOrigen = idAgenciaOrigen;
        this.idAgenciaDestino = idAgenciaDestino;
        this.distanciaKm = distanciaKm;
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
        this.costoBase = costoBase;
    }
    
    // Sin id
    public Ruta(String descripcion, int idAgenciaOrigen,
            int idAgenciaDestino, double distanciaKm, double tiempoEstimadoHoras, double costoBase) {
        this.descripcion = descripcion;
        this.idAgenciaOrigen = idAgenciaOrigen;
        this.idAgenciaDestino = idAgenciaDestino;
        this.distanciaKm = distanciaKm;
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
        this.costoBase = costoBase;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setIdAgenciaOrigen(int idAgenciaOrigen) {
        this.idAgenciaOrigen = idAgenciaOrigen;
    }

    public void setIdAgenciaDestino(int idAgenciaDestino) {
        this.idAgenciaDestino = idAgenciaDestino;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public void setTiempoEstimadoHoras(double tiempoEstimadoHoras) {
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public int getIdAgenciaOrigen() {
        return idAgenciaOrigen;
    }

    public int getIdAgenciaDestino() {
        return idAgenciaDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public double getDistanciaKm() {
        return distanciaKm;
    }

    public double getTiempoEstimadoHoras() {
        return tiempoEstimadoHoras;
    }

    public double getCostoBase() {
        return costoBase;
    }
}
