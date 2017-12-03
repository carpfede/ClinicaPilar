package datos;

import dominio.contratosRepositorios.RepositorioMedico;
import dominio.contratosRepositorios.RepositorioUsuario;
import dominio.entidades.*;
import main.FactoriaDeConfiguracion;

import java.util.ArrayList;

public class RepositorioUsuarioMySQL implements RepositorioUsuario {
    private RepositorioMedico repositorioMedico;

    private ArrayList<Usuario> usuarios;

    public RepositorioUsuarioMySQL() {
        this.repositorioMedico = FactoriaDeConfiguracion.getRepositorioMedico();
        inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        usuarios = new ArrayList<>();
        ArrayList<Medico> medicos = repositorioMedico.obtenerMedicos();
        usuarios.add(new Usuario(1, 1, medicos.get(0)));
        usuarios.add(new Usuario(2, 2, medicos.get(1)));
        Personal enfermera1 = new Enfermera(3, "Marta", 3, ERol.ENFERMERA);
        usuarios.add(new Usuario(3, 3, enfermera1));
        Personal secretaria1 = new Secretaria(4, "Lucila", 4, ERol.SECRETARIA);
        usuarios.add(new Usuario(4, 4, secretaria1));
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @Override
    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if ((usuario.getIdUsuario() == id))
                return usuario;
        }
        return null;
    }
}
