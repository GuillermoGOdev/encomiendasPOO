package DTO;

public class Cliente extends Persona {

    private int Idcliente;
    private String Fecha_registro;
    private String Estado;

    public int getIdcliente() {
        return Idcliente;
    }

    public void setIdcliente(int Idcliente) {
        this.Idcliente = Idcliente;
    }

    public String getFecha_registro() {
        return Fecha_registro;
    }

    public void setFecha_registro(String Fecha_registro) {
        this.Fecha_registro = Fecha_registro;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Cliente() {

    }

    public Cliente(int Idcliente, String Fecha_registro, String Estado) {
        this.Idcliente = Idcliente;
        this.Fecha_registro = Fecha_registro;
        this.Estado = Estado;
    }

    public Cliente(String nombres, String apellido_paterno, String apellido_materno, String dni,
            String telefono, String email, String direccion, String Fecha_registro) {
        super(nombres, apellido_paterno, apellido_materno, dni, telefono, email, direccion);

        this.Fecha_registro = Fecha_registro;

    }

    public Cliente(int IdPersona, String nombres, String apellido_paterno, String apellido_materno, String dni,
            String telefono, String email, String direccion, int Idcliente, String Fecha_registro, String Estado) {
        super(IdPersona, nombres, apellido_paterno, apellido_materno, dni, telefono, email, direccion);
        this.Idcliente = Idcliente;
        this.Fecha_registro = Fecha_registro;
        this.Estado = Estado;
    }

    
}
