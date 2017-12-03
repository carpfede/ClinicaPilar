package dominio.contratosRepositorios;

import dominio.entidades.Sesion;
import dominio.entidades.Usuario;

import java.util.ArrayList;

public interface RepositorioUsuario {
    ArrayList<Usuario> obtenerUsuarios();
    public Usuario buscarUsuario(int id);
}
