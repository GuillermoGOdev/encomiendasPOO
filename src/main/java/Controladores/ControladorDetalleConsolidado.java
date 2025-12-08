package Controladores;

import DTO.Encomienda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class ControladorDetalleConsolidado {

    public List<Integer> getEncomiendasSeleccionadas(JTable tabla) {
        List<Integer> seleccionadas = new ArrayList<>();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Object chk = tabla.getValueAt(i, 0);
            boolean marcado = Boolean.TRUE.equals(chk);
            if (marcado) {
                Object idObj = tabla.getValueAt(i, 2); // columna con id_encomienda
                if (idObj != null) {
                    try {
                        seleccionadas.add(Integer.parseInt(idObj.toString()));
                    } catch (NumberFormatException ex) {
                    }
                }
            }
        }
        return seleccionadas;

    }

}
