package DAO;

import Conexion.ConexionSQL;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleConsolidadoDAO {

    public boolean registrarDetallesMasivos(int idConsolidado, List<Integer> idEncomiendas) {
        if (idEncomiendas == null || idEncomiendas.isEmpty()) {
            return false;
        }

        String sql = "INSERT INTO DetalleConsolidado (id_consolidado, id_encomienda) VALUES (?, ?)";
        boolean ok = false;
        try (Connection con = ConexionSQL.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            con.setAutoCommit(false);

            for (Integer id : idEncomiendas) {
                ps.setInt(1, idConsolidado);
                ps.setInt(2, id);
                ps.addBatch();
            }

            int[] results = ps.executeBatch();

            // comprobar resultados (si quieres)
            for (int r : results) {
                if (r == PreparedStatement.EXECUTE_FAILED) {
                    con.rollback();
                    return false;
                }
            }

            con.commit();
            ok = true;

        } catch (BatchUpdateException bue) {
            // obtiene updateCounts: bue.getUpdateCounts()
            JOptionPane.showMessageDialog(null, "Error en batch: " + bue.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar detalles: " + e.getMessage());
        }
        return ok;
    }

}
