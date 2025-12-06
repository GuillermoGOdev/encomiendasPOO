package DTO;

import java.util.Date;

public class Despacho {

    private int id_consolidado;
    private int idruta;
    private int id_vehiculo;
    private int id_trabajador_conductor;
    private Date fecha_salida;
    private String estado;

    public Despacho() {
    }

    public Despacho(int id_consolidado, int idruta, int id_vehiculo, int id_trabajador_conductor, Date fecha_salida, String estado) {
        this.id_consolidado = id_consolidado;
        this.idruta = idruta;
        this.id_vehiculo = id_vehiculo;
        this.id_trabajador_conductor = id_trabajador_conductor;
        this.fecha_salida = fecha_salida;
        this.estado = estado;
    }

    public int getId_consolidado() {
        return id_consolidado;
    }

    public void setId_consolidado(int id_consolidado) {
        this.id_consolidado = id_consolidado;
    }

    public Despacho(int idruta, int id_vehiculo, int id_trabajador_conductor, Date fecha_salida, String estado) {
        this.idruta = idruta;
        this.id_vehiculo = id_vehiculo;
        this.id_trabajador_conductor = id_trabajador_conductor;
        this.fecha_salida = fecha_salida;
        this.estado = estado;
    }

    public int getIdruta() {
        return idruta;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public int getId_trabajador_conductor() {
        return id_trabajador_conductor;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public void setId_trabajador_conductor(int id_trabajador_conductor) {
        this.id_trabajador_conductor = id_trabajador_conductor;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
