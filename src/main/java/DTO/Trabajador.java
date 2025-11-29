package DTO;

public class Trabajador extends Persona {

    private int IdTrabajador;
    private double Sueldo;
    private String Estado;
    private int IdCargo;

    public Trabajador() {

    }

    public Trabajador(int IdTrabajador, double Sueldo, String Estado, int IdCargo) {
        this.IdTrabajador = IdTrabajador;
        this.Sueldo = Sueldo;
        this.Estado = Estado;
        this.IdCargo = IdCargo;
    }

    public Trabajador(int IdPersona, String nombres, String apellido_paterno, String apellido_materno, String dni, String telefono, String email, String direccion, int IdTrabajador, double Sueldo, String Estado, int IdCargo) {
        super(IdPersona, nombres, apellido_paterno, apellido_materno, dni, telefono, email, direccion);
        this.IdTrabajador = IdTrabajador;
        this.Sueldo = Sueldo;
        this.Estado = Estado;
        this.IdCargo = IdCargo;
    }

    public int getIdTrabajador() {
        return IdTrabajador;
    }

    public void setIdTrabajador(int IdTrabajador) {
        this.IdTrabajador = IdTrabajador;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }
    
    

}
