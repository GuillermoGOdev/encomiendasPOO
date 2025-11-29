package DTO;

public class Departamento {

    private int idDepartamento;
    private String departamento;

    public Departamento() {

    }

    public Departamento(int idDepartamento, String departamento) {
        this.idDepartamento = idDepartamento;
        this.departamento = departamento;
    }

    public Departamento(String nombre) {
        this.departamento = departamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    @Override
    public String toString() {
        return this.departamento;
    }
    
    @Override
    public boolean equals(Object o) {
        // 1. Verificar si es el mismo objeto
        if (this == o) return true;
        // 2. Verificar si es nulo o de una clase diferente
        if (o == null || getClass() != o.getClass()) return false;
        // 3. Castear y comparar por el ID
        Departamento that = (Departamento) o;
        return idDepartamento == that.getIdDepartamento();
    }
}
