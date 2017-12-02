package presentacion.presentador;

import aplicacion.coordinadorCU.AsignarTurnoManejador;
import aplicacion.coordinadorCU.BuscarPacienteManejador;
import aplicacion.coordinadorCU.RegistrarPacienteManejador;
import dominio.entidades.Paciente;
import presentacion.interfaces.BuscarPaciente;
import presentacion.vista.BuscarPacienteView;

public class BuscarPacientePresentador {
    private BuscarPaciente view;
    private BuscarPacienteManejador manejador;

    public BuscarPacientePresentador(BuscarPacienteView view, BuscarPacienteManejador manejador) {
        this.view = view;
        this.manejador = manejador;
    }

    public void buscarPaciente(int dni) {
        Paciente paciente = manejador.buscarPaciente(dni);
        if (paciente == null) {
            RegistrarPacienteManejador registrarPacienteManejador = new RegistrarPacienteManejador();

            view.registrarNuevoPaciente("No se encontro el paciente", registrarPacienteManejador);
        } else {
            AsignarTurnoManejador turnoManejador = new AsignarTurnoManejador();
            BuscarPacienteManejador buscarPacienteManejador = new BuscarPacienteManejador();
            view.nuevaAsignacionDeTurno(paciente, turnoManejador, buscarPacienteManejador);
        }
    }
}
