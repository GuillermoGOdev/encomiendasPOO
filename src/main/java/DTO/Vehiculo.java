package DTO;

public class Vehiculo {

    private int IdVehiculo, Anio;
    private double Capacidad_kg, Capacidad_m3;
    private String Estado, Placa;

    public Vehiculo() {
    }

    public Vehiculo(int IdVehiculo, String Placa, int Anio, double Capacidad_kg, double Capacidad_m3, String Estado) {
        this.IdVehiculo = IdVehiculo;
        this.Placa = Placa;
        this.Anio = Anio;
        this.Capacidad_kg = Capacidad_kg;
        this.Capacidad_m3 = Capacidad_m3;
        this.Estado = Estado;

    }

    // Sin id
    public Vehiculo(String Placa, int Anio, double Capacidad_kg, double Capacidad_m3, String Estado) {
        this.Placa = Placa;
        this.Anio = Anio;
        this.Capacidad_kg = Capacidad_kg;
        this.Capacidad_m3 = Capacidad_m3;
        this.Estado = Estado;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getIdVehiculo() {
        return IdVehiculo;
    }

    public int getAnio() {
        return Anio;
    }

    public double getCapacidad_kg() {
        return Capacidad_kg;
    }

    public double getCapacidad_m3() {
        return Capacidad_m3;
    }

    public String getEstado() {
        return Estado;
    }

    public void setIdVehiculo(int IdVehiculo) {
        this.IdVehiculo = IdVehiculo;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public void setCapacidad_kg(double Capacidad_kg) {
        this.Capacidad_kg = Capacidad_kg;
    }

    public void setCapacidad_m3(double Capacidad_m3) {
        this.Capacidad_m3 = Capacidad_m3;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
