package presentacion.interfaces;

import aplicacion.coordinadorCU.AsignarTurnoManejador;
import aplicacion.coordinadorCU.BuscarPacienteManejador;
import dominio.entidades.ObraSocial;
import dominio.entidades.Paciente;

import java.util.ArrayList;

public interface RegistrarPaciente {
    void cargarObrasSociales(ArrayList<ObraSocial> obrasSociales);

    void cargarDniPaciente(String dni);

    void nuevoTurno(Paciente p, AsignarTurnoManejador turnoManejador,
                    BuscarPacienteManejador buscarPacienteManejador);
}
