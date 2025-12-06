package DTO;

import java.util.List;

public class Ruta {

    private int idRuta;
    private String descripcion;
    private double costoBase, tiempoEstimadoHoras, distanciaKm;
    private List<ParadaRuta> paradas;

    public Ruta() {

    }

    // Sin idRuta
    public Ruta(String descripcion, double costoBase, double tiempoEstimadoHoras, double distanciaKm, List<ParadaRuta> paradas) {
        this.descripcion = descripcion;
        this.costoBase = costoBase;
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
        this.distanciaKm = distanciaKm;
        this.paradas = paradas;
    }

    public Ruta(int idRuta, String descripcion, double costoBase, double tiempoEstimadoHoras, double distanciaKm, List<ParadaRuta> paradas) {
        this.idRuta = idRuta;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
        this.distanciaKm = distanciaKm;
        this.paradas = paradas;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public double getTiempoEstimadoHoras() {
        return tiempoEstimadoHoras;
    }

    public void setTiempoEstimadoHoras(double tiempoEstimadoHoras) {
        this.tiempoEstimadoHoras = tiempoEstimadoHoras;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public List<ParadaRuta> getParadas() {
        return paradas;
    }

    public void setParadas(List<ParadaRuta> paradas) {
        this.paradas = paradas;
    }

    @Override
    public String toString() {
        return descripcion; // O el campo que quieras mostrar en tu combo
    }
}
