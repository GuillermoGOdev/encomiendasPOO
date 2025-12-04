
package DTO;


public class MetodoPago {
    private int idMetodoPago;
    private String nombre;

    public MetodoPago(int idMetodoPago, String nombre) {
        this.idMetodoPago = idMetodoPago;
        this.nombre = nombre;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    @Override
    public String toString() {
        return nombre;
    }

    
    
    
    
}
