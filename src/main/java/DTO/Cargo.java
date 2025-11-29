package DTO;

public class Cargo {

    private int IdCargo;
    private String Descripcion, Estado;

    public Cargo() {
    }

    public Cargo(String Descripcion, String Estado) {
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public Cargo(int IdCargo, String Descripcion, String Estado) {
        this.IdCargo = IdCargo;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdCargo() {
        return IdCargo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

}
