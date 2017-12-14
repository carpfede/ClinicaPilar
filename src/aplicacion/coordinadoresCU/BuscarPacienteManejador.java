package aplicacion.coordinadoresCU;

import dominio.contratosRepositorios.RepositorioPaciente;
import dominio.entidades.pacientes.Paciente;
import main.FactoriaDeConfiguracion;

public class BuscarPacienteManejador {
    private RepositorioPaciente repositorioPaciente;

    public BuscarPacienteManejador() {
        repositorioPaciente = FactoriaDeConfiguracion.getRepositorioPaciente();
    }

    public Paciente buscarPaciente(int dni) {
        return repositorioPaciente.buscarPaciente(dni);
    }
}
