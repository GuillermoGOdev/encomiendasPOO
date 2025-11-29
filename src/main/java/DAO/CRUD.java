package DAO;

import java.util.List;

public interface CRUD<T> {
        public boolean registrar(T elemento);
        public boolean eliminar(int id);
        public boolean modificar(T elemento);
        public T buscar(int id);
        public List<T> listar();
}
