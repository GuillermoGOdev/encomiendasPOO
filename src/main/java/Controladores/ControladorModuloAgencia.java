package Controladores;

import DAO.AgenciaDAO;
import DTO.Agencia;
import Vistas.AgenciaForm;
import Vistas.ModuloAgencia;
import java.util.List;
import javax.swing.JOptionPane;
import DAO.DistritoDAO; // Asegúrate de tener este import
import DTO.Distrito;

public class ControladorModuloAgencia {
    
    private ModuloAgencia vista;
    private AgenciaDAO dao;
    private DistritoDAO distritoDAO;
    private AgenciaForm form;
    
    public ControladorModuloAgencia(ModuloAgencia vista) {
        this.vista = vista;
        this.dao = new AgenciaDAO();
        this.distritoDAO = new DistritoDAO();
    }
    
    // Permite que el formulario de edición acceda a la vista principal para actualizar la tabla.
   public ModuloAgencia getVista() {
       return vista;
   }
    
    public void registrarAgencia() {
        form = new AgenciaForm();
        form.setControladorModulo(this);
        form.setVisible(true);
    }
    
    public void editarAgencia() {
        int id = vista.getidAgenciaSeleccionada();
        if(id == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila para continuar.", "Validación Incompleta", JOptionPane.WARNING_MESSAGE);
        } else {
            // Abrir formulario cargando datos del ID
            form = new AgenciaForm(id);
            form.setControladorModulo(this);
            form.setVisible(true);
        }
    }
    
    public void eliminarAgencia() {
        int id = vista.getidAgenciaSeleccionada();

        // Si NO se ha seleccionado una fila
        if(id == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila para eliminar.", "Validación Incompleta", JOptionPane.WARNING_MESSAGE);
        } else {
            // Si SÍ se ha seleccionado una fila, pedimos confirmación
            int confirmacion = JOptionPane.showConfirmDialog(
                vista, 
                "¿Estás seguro de que quieres eliminar la agencia con ID " + id + "?", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
            );

            // Si el usuario presiona "Sí" (YES_OPTION)
            if (confirmacion == JOptionPane.YES_OPTION) {
                dao.eliminar(id);
                JOptionPane.showMessageDialog(vista, "Agencia eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public String obtenerNombreDistrito(int idDistrito) {
        if (idDistrito <= 0) {
            return "N/A";
        }
        try {
            Distrito d = distritoDAO.buscarDistritoPorId(idDistrito);
            if (d != null) {
                return d.getDistrito();
            }
        } catch (RuntimeException e) {
            System.err.println("Error al buscar el nombre del distrito ID " + idDistrito + ": " + e.getMessage());
        }
        return "Desconocido";
    }
    
    public List<Agencia> buscarAgencia() {
        return dao.buscarPorNombre(vista.getTextoABuscar());
    }
    
    public List<Agencia> obtenerAgencias() {
        return dao.listar();
    }
}