package presentacion.interfaces;

import aplicacion.coordinadorCU.AsignarTurnoManejador;
import aplicacion.coordinadorCU.BuscarPacienteManejador;
import aplicacion.coordinadorCU.RegistrarPacienteManejador;
import dominio.entidades.pacientes.Paciente;

public interface BuscarPaciente {
    void nuevaAsignacionDeTurno(Paciente paciente, AsignarTurnoManejador turnoManejador, BuscarPacienteManejador buscarPacienteManejador);

    void registrarNuevoPaciente(String message, RegistrarPacienteManejador registrarPacienteManejador);
}
