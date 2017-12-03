package dominio.contratosRepositorios;

import dominio.entidades.*;

import java.util.ArrayList;

public interface RepositorioUsuario {
    ArrayList<Usuario> obtenerUsuarios();
    public Usuario buscarUsuario(int id);
    public Personal buscarPersonal(int dni);
}
