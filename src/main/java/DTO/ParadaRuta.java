package DTO;

// Una Ruta tiene varias ParadaRuta y cada una de estas apunta a una Agencia
public class ParadaRuta {
    private int idParadaRuta, idRuta, idAgencia, orden;
    private String nombreAgencia;

    public ParadaRuta() {};
    
    // Sin el idParadaRuta para inserciones a la BD// Sin el idParadaRuta para inserciones a la BD
    public ParadaRuta(int idRuta, int idAgencia, int orden, String nombreAgencia) {
        this.idRuta = idRuta;
        this.idAgencia = idAgencia;
        this.orden = orden;
        this.nombreAgencia = nombreAgencia;
    }

    public ParadaRuta(int idParadaRuta, int idRuta, int idAgencia, int orden, String nombreAgencia) {
        this.idParadaRuta = idParadaRuta;
        this.idRuta = idRuta;
        this.idAgencia = idAgencia;
        this.orden = orden;
        this.nombreAgencia = nombreAgencia;
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

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }
}
