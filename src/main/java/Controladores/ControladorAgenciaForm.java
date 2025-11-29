package Controladores;

import DAO.AgenciaDAO;
import DAO.DepartamentoDAO;
import DAO.DistritoDAO;
import DAO.ProvinciaDAO;
import DTO.Agencia;
import DTO.Departamento;
import DTO.Distrito;
import DTO.Provincia;
import Vistas.AgenciaForm;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorAgenciaForm {
    private AgenciaForm vista;
    private AgenciaDAO dao;
    private Integer idEdicion = null;
    
    // COMENTARIO DE PRUEBA

    // Constructor para registrar
    public ControladorAgenciaForm(AgenciaForm vista) {
        this.vista = vista;
        this.dao = new AgenciaDAO();
    }

    // Constructor para editar
    public ControladorAgenciaForm(AgenciaForm vista, int idAgencia) {
        this.vista = vista;
        this.dao = new AgenciaDAO();
        this.idEdicion = idAgencia;
    }

    // --- MÉTODOS DE REGISTRO/MODIFICACIÓN ---
    
    public void guardar() {
        
        Distrito distritoSeleccionado = vista.getDistritoSeleccionado();
        if (distritoSeleccionado == null) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un Distrito para continuar.", "Validación Incompleta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nombre = vista.getNombre();
        String direccion = vista.getDireccion();
        String telefono = vista.getTelefono();
        String email = vista.getEmail();
        int idDistrito = distritoSeleccionado.getIdDistrito();

        Agencia agencia = new Agencia(nombre, direccion, telefono, email, idDistrito);
            
        try {
            if (idEdicion == null) { // Registrar
                
                // Intentar registrar
                if(dao.registrar(agencia)) {
                    JOptionPane.showMessageDialog(vista, "Agencia registrada con éxito");
                    vista.dispose();
                } else {
                    JOptionPane.showMessageDialog(vista, "Registro fallido. No se insertó ninguna fila.", "Error de Operación", JOptionPane.ERROR_MESSAGE);
                }
            } else { // Editar
                
                // Asignar el ID de edición
                agencia.setIdAgencia(this.idEdicion);
                
                if(dao.modificar(agencia)) {
                    JOptionPane.showMessageDialog(vista, "Agencia modificada con éxito");
                    vista.dispose();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al modificar: La agencia no fue encontrada o no hubo cambios.", "Error de Operación", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (RuntimeException e) {
      
            String mensajeOriginal = e.getMessage(); // Mensaje de la RuntimeException (genérico)
            Throwable causa = e.getCause(); // La SQLException original de la BD
            
            if (causa != null) {
                mensajeOriginal = causa.getMessage();
            }
            
            String mensajeError = mensajeOriginal.toLowerCase();

            // Identificar error de unicidad
            if (mensajeError.contains("duplicate entry")) {
                JOptionPane.showMessageDialog(vista, 
                    "Error de Validación: El nombre '" + nombre + "' ya se encuentra registrado.", 
                    "Dato Duplicado", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                // Error general de BD
                JOptionPane.showMessageDialog(vista, 
                    "Error grave en la Base de Datos: \n" + e.getMessage(), 
                    "Error de BD", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // --- MÉTODOS DE BÚSQUEDA (Operaciones con DAOs que devuelven DTOs) ---
    
    public Agencia obtenerAgenciaParaEdicion() {
        if (this.idEdicion != null) {
            try {
                return dao.buscar(this.idEdicion);
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(vista, 
                    "Error al cargar la agencia para edición: \n" + e.getMessage(), 
                    "Error de Carga", 
                    JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return null;
    }
    
    // Jala la lista de departamentos de la BD
    public List<Departamento> obtenerDepartamentos() {
        DepartamentoDAO depDAO = new DepartamentoDAO();
        try {
            return depDAO.listarDepartamentos();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(vista, 
                "Error al cargar la lista de Departamentos: \n" + e.getMessage(), 
                "Error de Carga", 
                JOptionPane.ERROR_MESSAGE);
            return Collections.emptyList(); // Devuelve lista vacía para evitar NPE en la vista
        }
    }
    
    public List<Provincia> obtenerProvinciasPorDepartamento(Departamento dep) {
        ProvinciaDAO pDAO = new ProvinciaDAO();
        try {
            if(dep != null) {
                return pDAO.listarProvincias(dep);
            } else if (vista.getDepartamentoSeleccionado() != null) {
                // Fallback si se llama desde el action listener
                return pDAO.listarProvincias(vista.getDepartamentoSeleccionado());
            } else {
                System.out.println("Error: Departamento no seleccionado al cargar provincias.");
                return Collections.emptyList();
            }
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(vista, 
                "Error al cargar la lista de Provincias: \n" + e.getMessage(), 
                "Error de Carga", 
                JOptionPane.ERROR_MESSAGE);
            return Collections.emptyList();
        }
    }
    
    // Jala los distritos con el idProvincia de la seleccionada
    public List<Distrito> obtenerDistritosPorProvincia(Provincia prov) {
        DistritoDAO disDAO = new DistritoDAO();
        try {
            if(prov != null) {
                return disDAO.listarDistritos(prov);
            } else if (vista.getProvinciaSeleccionada() != null) {
                // Fallback si se llama desde el action listener del cboProvincia
                return disDAO.listarDistritos(vista.getProvinciaSeleccionada());
            } else {
                System.out.println("Error: Provincia no seleccionada al cargar distritos.");
                return Collections.emptyList();
            }
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(vista, 
                "Error al cargar la lista de Distritos: \n" + e.getMessage(), 
                "Error de Carga", 
                JOptionPane.ERROR_MESSAGE);
            return Collections.emptyList();
        }
    }
    
    // Necesito obtener el Distrito para acceder a su atributo idProvincia
    public Distrito buscarDistrito(int idDistrito) {
        DistritoDAO disDAO = new DistritoDAO();
        try {
            return disDAO.buscarDistritoPorId(idDistrito);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(vista, 
                "Error al buscar Distrito por ID: \n" + e.getMessage(), 
                "Error de Carga", 
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Con el idProvincia obtengo la Provincia para acceder a su atributo idDepartamento
    public Provincia buscarProvincia(int idProvincia) {
        ProvinciaDAO pDAO = new ProvinciaDAO();
        try {
            return pDAO.buscarProvinciaPorId(idProvincia);
        } catch (RuntimeException e) {
             JOptionPane.showMessageDialog(vista, 
                "Error al buscar Provincia por ID: \n" + e.getMessage(), 
                "Error de Carga", 
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Departamento buscarDepartamento(int idDepartamento) {
        DepartamentoDAO depDAO = new DepartamentoDAO();
        try {
            return depDAO.buscarDepartamentoPorId(idDepartamento);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(vista, 
                "Error al buscar Departamento por ID: \n" + e.getMessage(), 
                "Error de Carga", 
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
