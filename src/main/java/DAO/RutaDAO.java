package DAO;

import Conexion.ConexionSQL;
import DTO.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class RutaDAO {

/*    
    public boolean registrarRuta(Ruta r) {
        String sql = "INSERT INTO Ruta (descripcion, id_agencia_origen, id_agencia_destino, distancia_km, tiempo_estimado_horas, costo_base) VALUES (?, ?, ?, ?, ?, ?)";
        boolean ok = false;

        try (Connection con = ConexionSQL.conectar(); PreparedStatement psRuta = con.prepareStatement(sql)) {
            con.setAutoCommit(false); // Desactivar el guardar cambios automaticamente
            
            psRuta.setString(1, r.getDescripcion());
            psRuta.setInt(2, r.getIdAgenciaOrigen());
            psRuta.setInt(3, r.getIdAgenciaDestino());
            psRuta.setDouble(4, r.getDistanciaKm());
            psRuta.setDouble(5, r.getTiempoEstimadoHoras());
            psRuta.setDouble(6, r.getCostoBase());
            
            if(psRuta.executeUpdate() > 0) {
                con.commit(); // commit para guardar los cambios tras la insercion
                ok = true;
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la ruta: "+e);
        }
        
        return ok;
    }
*/
}
