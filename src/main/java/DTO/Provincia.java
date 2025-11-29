package DTO;

public class Provincia extends Departamento{
    private int idProvincia;
    private String provincia;
    
    public Provincia () {
        
    }

    public Provincia(int idProvincia, String provincia, int idDepartamento, String departamento) {
        super(idDepartamento, departamento);
        this.idProvincia = idProvincia;
        this.provincia = provincia;
    }
    
    public Provincia(String nombre, int idDepartamento, String departamento) {
        super(idDepartamento, departamento);
        this.provincia = nombre;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public String getProvincia() {
        return provincia;
    }
    
    @Override
    public String toString() {
        return this.provincia;
    }
    
    @Override
    public boolean equals(Object o) {
        // 1. Verificar si es el mismo objeto
        if (this == o) return true;
        // 2. Verificar si es nulo o de una clase diferente
        if (o == null || getClass() != o.getClass()) return false;
        // 3. Castear y comparar por el ID
        Provincia that = (Provincia) o;
        return idProvincia == that.getIdProvincia();
    }
}
