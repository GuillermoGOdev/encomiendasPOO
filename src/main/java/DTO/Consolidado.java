package     DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consolidado {
    private int cantidadEncomiendas;
    private Date fechaCreacion;
    private double totalPeso;
    private List<Encomienda> encomiendas;

    public Consolidado() {
        this.encomiendas = new ArrayList<>();
        this.fechaCreacion = new Date();
        this.cantidadEncomiendas = 0;
         this.fechaCreacion = new Date();
        this.totalPeso = 0.0;
    }

    public Consolidado(Date fechaCreacion) {
        this(); // Llama al constructor sin parámetros
        this.fechaCreacion = fechaCreacion;
    }

    public void agregarEncomienda(Encomienda e) {
        if (e != null) {
            encomiendas.add(e);
            cantidadEncomiendas++;
            totalPeso += e.getPeso_kg();
        }
    }

    public void eliminarEncomienda(Encomienda e) {
        if (e != null && encomiendas.remove(e)) {
            cantidadEncomiendas--;
            totalPeso += e.getPeso_kg();
        }
    }

    
    public int getCantidadEncomiendas() {
        return cantidadEncomiendas;
    }

    public double getTotalPeso() {
        return totalPeso;
    }

    public List<Encomienda> getEncomiendas() {
        return encomiendas;
    }
}