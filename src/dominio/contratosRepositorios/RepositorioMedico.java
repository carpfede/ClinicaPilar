package dominio.contratosRepositorios;

import dominio.entidades.EEspecialidades;
import dominio.entidades.turnos.Medico;

import java.util.ArrayList;

public interface RepositorioMedico {
    void agregarMedico(Medico medico);

    ArrayList<Medico> obtenerMedicos();

    ArrayList<Medico> obtnerMedicosDe(EEspecialidades especialidad);

    Medico obtenerMedico(int idMedico);
}
