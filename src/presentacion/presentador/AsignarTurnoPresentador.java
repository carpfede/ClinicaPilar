package presentacion.presentador;

import aplicacion.coordinadorCU.AsignarTurnoManejador;
import aplicacion.coordinadorCU.BuscarPacienteManejador;
import dominio.entidades.*;
import presentacion.vista.NuevaAsignacionDeTurnoView;

import java.util.ArrayList;
import java.util.Date;

public class AsignarTurnoPresentador {
    private NuevaAsignacionDeTurnoView view;
    private AsignarTurnoManejador turnoManejador;

    public AsignarTurnoPresentador(NuevaAsignacionDeTurnoView nuevaAsignacionDeTurnoView, AsignarTurnoManejador turnoManejador, BuscarPacienteManejador buscarPacienteManejador) {
        this.turnoManejador = turnoManejador;
        view = nuevaAsignacionDeTurnoView;
    }

    public ArrayList<Medico> buscarMedicosCon(EEspecialidades eEspecialidades) {
        return turnoManejador.obtenerMedicos(eEspecialidades);
    }

    public void seleccionDeFecha(int idPersonal, Date fecha) {
        cargarHorariosDisponibles(idPersonal, fecha);
    }

    public void guardarTurno(Paciente paciente, Turno turno) {
        turnoManejador.agregarTurno(paciente, turno);
    }

    public void especialidadSeleccionada(EEspecialidades item) {
        ArrayList<Medico> medicos = buscarMedicosCon(item);
        if (hayMedicos(medicos)) {
            view.cargarMedicos(medicos);
        } else {
            view.mostrarMensaje("No hay medicos disponibles, Seleccione otra especialidad");
        }
    }

    private boolean hayMedicos(ArrayList<Medico> medicos) {
        return medicos.size() != 0;
    }

    public void cargarHorariosDisponibles(int idMedico, Date fecha) {
        ArrayList<Turno> items = turnoManejador.obtenerTurnos(idMedico, fecha);
        if (items != null)
            view.cargarTurnos(items);
        else {
            EDias dia = EDias.values()[fecha.getDay()];
            view.mostrarMensaje("Dia " + dia + " no disponible en el plan de turno");
        }
    }

    public void cargarVista() {
        int numeroTurno = turnoManejador.ultimoNumeroDeTurno();
        view.mostrarPaciente(numeroTurno);
        view.cargarEspecialidades();
    }
}
