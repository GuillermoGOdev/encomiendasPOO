package DTO;

// Una Ruta tiene varias ParadaRuta y cada una de estas apunta a una Agencia
public class ParadaRuta {
    private int idParadaRuta, idRuta, orden;
    private Agencia agencia;

    // Sin el idParadaRuta para inserciones a la BD
    public ParadaRuta(int idRuta, int orden, Agencia agencia) {
        this.idRuta = idRuta;
        this.orden = orden;
        this.agencia = agencia;
    }

    public ParadaRuta(int idParadaRuta, int idRuta, int orden, Agencia agencia) {
        this.idParadaRuta = idParadaRuta;
        this.idRuta = idRuta;
        this.orden = orden;
        this.agencia = agencia;
    }

    public int getIdParadaRuta() {
        return idParadaRuta;
    }

    public void setIdParadaRuta(int idParadaRuta) {
        this.idParadaRuta = idParadaRuta;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
}
