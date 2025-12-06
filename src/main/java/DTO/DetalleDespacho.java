package DTO;

public class DetalleDespacho {

    private int id_detalle_consolidado;
    private int id_consolidado;
    private int id_encomienda;

    public DetalleDespacho() {
    }

    public DetalleDespacho(int id_detalle_consolidado, int id_consolidado, int id_encomienda) {
        this.id_detalle_consolidado = id_detalle_consolidado;
        this.id_consolidado = id_consolidado;
        this.id_encomienda = id_encomienda;
    }

    public int getId_detalle_consolidado() {
        return id_detalle_consolidado;
    }

    public void setId_detalle_consolidado(int id_detalle_consolidado) {
        this.id_detalle_consolidado = id_detalle_consolidado;
    }

    public int getId_consolidado() {
        return id_consolidado;
    }

    public void setId_consolidado(int id_consolidado) {
        this.id_consolidado = id_consolidado;
    }

    public int getId_encomienda() {
        return id_encomienda;
    }

    public void setId_encomienda(int id_encomienda) {
        this.id_encomienda = id_encomienda;
    }

}
