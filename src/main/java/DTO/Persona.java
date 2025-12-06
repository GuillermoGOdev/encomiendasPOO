package DTO;

public class Persona {

    private int idpersona;
    private String nombres, apellido_paterno, apellido_materno, dni, telefono, email, direccion;

    public Persona() {

    }

    //////// Sin IdPersona 
    public Persona(String nombres, String apellido_paterno, String apellido_materno, String dni, String telefono, String email, String direccion) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    /////// Con IdPersona
    public Persona(int idpersona, String nombres, String apellido_paterno, String apellido_materno, String dni, String telefono, String email, String direccion) {
        this.idpersona = idpersona;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getIdpersona() {
        return idpersona;
    }

    @Override
    public String toString() {
        return nombres + apellido_paterno + apellido_materno;  // Esto es lo que se mostrará en el combo
    }

}
