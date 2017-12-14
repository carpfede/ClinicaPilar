package presentacion.interfaces;

import aplicacion.coordinadoresCU.*;
import dominio.entidades.pacientes.Paciente;

public interface BuscarPaciente {
    void nuevaAsignacionDeTurno(Paciente paciente, AsignarTurnoManejador turnoManejador, BuscarPacienteManejador buscarPacienteManejador);

    void registrarNuevoPaciente(String message, RegistrarPacienteManejador registrarPacienteManejador);
}
