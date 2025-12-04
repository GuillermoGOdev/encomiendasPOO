
package DTO;


public class TipoPaquete {
    private String nombre;
    private double maxPeso;
    private double maxLargo;
    private double maxAncho;
    private double maxAlto;

    public TipoPaquete(String nombre, double maxPeso, double maxLargo, double maxAncho, double maxAlto) {
        this.nombre = nombre;
        this.maxPeso = maxPeso;
        this.maxLargo = maxLargo;
        this.maxAncho = maxAncho;
        this.maxAlto = maxAlto;
    }

    public String getNombre() { return nombre; }
    public double getMaxPeso() { return maxPeso; }
    public double getMaxLargo() { return maxLargo; }
    public double getMaxAncho() { return maxAncho; }
    public double getMaxAlto() { return maxAlto; }

    @Override
    public String toString() {
        return nombre;
    }
}
