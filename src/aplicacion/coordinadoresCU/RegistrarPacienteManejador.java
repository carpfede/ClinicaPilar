package aplicacion.coordinadoresCU;

import dominio.contratosRepositorios.RepositorioObraSocial;
import dominio.contratosRepositorios.RepositorioPaciente;
import dominio.entidades.pacientes.ObraSocial;
import dominio.entidades.pacientes.Paciente;
import dominio.entidades.RegistroLog;
import main.FactoriaDeConfiguracion;

import java.util.ArrayList;

public class RegistrarPacienteManejador {
    private RepositorioPaciente repositorioPaciente;
    private RepositorioObraSocial repositorioObraSocial;
    private RegistroLog registroLog;

    public RegistrarPacienteManejador() {
        repositorioPaciente = FactoriaDeConfiguracion.getRepositorioPaciente();
        repositorioObraSocial = FactoriaDeConfiguracion.getRepositorioObraSocial();
        try {
            registroLog = FactoriaDeConfiguracion.getInstanciaRegistroLog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ObraSocial> obtenerObrasSociales() {
        return repositorioObraSocial.obtenerObrasSociales();
    }

    public void registroPaciente(Paciente p) {
        repositorioPaciente.agregarPaciente(p);
        registroLog.grabarUnPaciente(p);
    }
}
