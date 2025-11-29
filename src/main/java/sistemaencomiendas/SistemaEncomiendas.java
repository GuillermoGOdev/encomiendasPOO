package sistemaencomiendas;

import Conexion.ConexionSQL;
import Vistas.*;

public class SistemaEncomiendas {

    public static void main(String[] args) {
        ConexionSQL.conectar();
        ModuloLogin lg = new ModuloLogin();
        lg.setVisible(true);
        //HolaMundo
    }
}
