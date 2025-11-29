package DTO;

public class Distrito extends Provincia {

    private int idDistrito;
    private String distrito;

    public Distrito() {

    }

    public Distrito(int idDistrito, String distrito, int idProvincia, String provincia, int idDepartamento, String departamento) {
        super(idProvincia, provincia, idDepartamento, departamento);
        this.idDistrito = idDistrito;
        this.distrito = distrito;
    }
    
    public Distrito(String distrito, int idProvincia, String provincia, int idDepartamento, String departamento) {
        super(idProvincia, provincia, idDepartamento, departamento);
        this.distrito = distrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public String getDistrito() {
        return distrito;
    }
    
    @Override
    public String toString() {
        return this.distrito;
    }
    
    @Override
    public boolean equals(Object o) {
        // 1. Verificar si es el mismo objeto
        if (this == o) return true;
        // 2. Verificar si es nulo o de una clase diferente
        if (o == null || getClass() != o.getClass()) return false;
        // 3. Castear y comparar por el ID
        Distrito that = (Distrito) o;
        return idDistrito == that.getIdDistrito();
    }
}