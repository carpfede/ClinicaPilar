package transversal.seguridad;

import dominio.contratosRepositorios.RepositorioUsuario;
import dominio.entidades.Sesion;
import dominio.entidades.Usuario;
import main.FactoriaDeConfiguracion;

import java.util.ArrayList;

public class SesionManejador {

    private RepositorioUsuario repositorioUsuario;

    public SesionManejador() {
        repositorioUsuario = FactoriaDeConfiguracion.getRepositorioUsuario();
    }

    public Sesion validarUsuario(int id, int pw) {
        ArrayList<Usuario> usuarios = repositorioUsuario.obtenerUsuarios();
        for (Usuario usuario : usuarios) {
            if ((usuario.getContraseña() == pw) && (usuario.getIdUsuario() == id))
                return new Sesion(usuario);
        }
        return null;
    }
}
