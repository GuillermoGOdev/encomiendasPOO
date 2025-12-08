
package Controladores;

import DAO.UsuarioDAO;
import DTO.Usuario;
import Vistas.ModuloRegistro;


public class ControladorUsuario {
    private ModuloRegistro vista;
    private UsuarioDAO dao;

    //Constructor para registrar
    public ControladorUsuario() {
        this.dao = new UsuarioDAO();
    }

    public String registrarUsuario(String nombre, String correo, String contrasena) {
        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            return "Todos los campos son obligatorios.";
        }

        if (!correo.contains("@")) {
            return "El correo no es válido.";
        }

        if (dao.verificarCorreoExistente(correo)) {
            return "El correo ya está registrado.";
        }

        Usuario u = new Usuario(0, nombre, correo, contrasena);

        boolean registrado = dao.registrarUsuario(u);

        if (registrado) {
            return "OK";  // Indicador de éxito
        } else {
            return "Error al registrar el usuario.";
        }

         

    }
    // --- Iniciar sesión ---
    public Usuario iniciarSesion(String correo, String contrasena) {

        if (correo.isEmpty() || contrasena.isEmpty()) {
            return null;
        }
        return dao.iniciarSesion(correo, contrasena);
    }
    
    public Usuario buscarPorId(int id) {
        return dao.buscar(id);
    }
}
