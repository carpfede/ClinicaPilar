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
        Usuario usuario = repositorioUsuario.buscarUsuario(id);
        if(usuario != null)
            if ((usuario.getIdUsuario() == id))
                return new Sesion(usuario);
        return null;
    }
}
