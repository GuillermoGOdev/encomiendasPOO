package DTO;

public class Agencia {

    private int idAgencia, idDistrito;
    private String nombre, direccion, telefono, email;

    public Agencia() {

    }

    public Agencia(int idAgencia, String nombre, String direccion, String telefono, String email, int idDistrito) {
        this.idAgencia = idAgencia;
        this.idDistrito = idDistrito;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // Sin ID
    public Agencia(String nombre, String direccion, String telefono, String email, int idDistrito) {
        this.idDistrito = idDistrito;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
