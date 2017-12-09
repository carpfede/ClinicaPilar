package presentacion.presentador;

import aplicacion.coordinadorCU.AsignarTurnoManejador;
import aplicacion.coordinadorCU.BuscarPacienteManejador;
import aplicacion.coordinadorCU.RegistrarPacienteManejador;
import dominio.entidades.pacientes.AfiliacionObraSocial;
import dominio.entidades.pacientes.ObraSocial;
import dominio.entidades.pacientes.Paciente;
import presentacion.interfaces.RegistrarPaciente;
import presentacion.vista.RegistrarPacienteView;

import java.util.ArrayList;

public class RegistrarPacientePresentador {
    RegistrarPaciente view;
    RegistrarPacienteManejador registrarPacienteManejador;

    public RegistrarPacientePresentador(RegistrarPacienteView crearPacienteView, RegistrarPacienteManejador registrarPacienteManejador) {
        this.registrarPacienteManejador = registrarPacienteManejador;
        view = crearPacienteView;
    }

    public void cargarObrasSociales() {
        ArrayList<ObraSocial> obrasSociales = registrarPacienteManejador.obtenerObrasSociales();
        view.cargarObrasSociales(obrasSociales);
    }

    public void registrarPaciente(String nombre, String apellido, String domicilio, int dni, long telefono, int edad, AfiliacionObraSocial afiliacionObraSocial) {
        Paciente p = new Paciente(nombre, apellido, domicilio, dni, telefono, edad, afiliacionObraSocial);
        registrarPacienteManejador.registroPaciente(p);
        BuscarPacienteManejador pacienteManejador = new BuscarPacienteManejador();
        AsignarTurnoManejador turnoManejador = new AsignarTurnoManejador();
        view.nuevoTurno(p, turnoManejador, pacienteManejador);
    }
}
