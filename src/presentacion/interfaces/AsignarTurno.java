package presentacion.interfaces;

import dominio.entidades.Medico;
import dominio.entidades.Turno;

import java.util.ArrayList;

public interface AsignarTurno {
    void cargarEspecialidades();

    void cargarMedicos(ArrayList<Medico> medicos);

    void cargarTurnos(ArrayList<Turno> turnos);

    void mostrarPaciente(int numeroTurno);
}
