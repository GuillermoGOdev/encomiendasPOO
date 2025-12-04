
package DAO;

import Conexion.ConexionSQL;
import DTO.MetodoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class MetodoPagoDAO {
     public List<MetodoPago> listar() {
        List<MetodoPago> lista = new ArrayList<>();

        String sql = "SELECT idMetodoPago, nombre FROM MetodoPago";

        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new MetodoPago(
                    rs.getInt("idMetodoPago"),
                    rs.getString("nombre")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error al listar métodos de pago: " + e.getMessage());
        }

        return lista;
    }


}
