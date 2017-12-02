package aplicacion.coordinadorCU;

import dominio.contratosRepositorios.RepositorioMedico;
import dominio.contratosRepositorios.RepositorioTurnos;
import dominio.entidades.EEspecialidades;
import dominio.entidades.Medico;
import dominio.entidades.Paciente;
import dominio.entidades.Turno;
import main.FactoriaDeConfiguracion;

import java.util.ArrayList;
import java.util.Date;

public class AsignarTurnoManejador {
    private RepositorioMedico repositorioMedico;
    private RepositorioTurnos repositorioTurnos;

    public AsignarTurnoManejador() {
        repositorioMedico = FactoriaDeConfiguracion.getRepositorioMedico();
        repositorioTurnos = FactoriaDeConfiguracion.getRepositorioTurnos();
    }

    public Medico obtenerMedico(int idMedico) {
        return repositorioMedico.obtenerMedico(idMedico);
    }

    public ArrayList<Medico> obtenerMedicos(EEspecialidades eEspecialidades) {
        return repositorioMedico.obtnerMedicosDe(eEspecialidades);
    }

    public int ultimoNumeroDeTurno() {
        return repositorioTurnos.ultimoNumeroDeTurno();
    }

    public ArrayList<Turno> obtenerTurnos(int idMedico, Date fecha) {
        Medico medico = obtenerMedico(idMedico);
        ArrayList<Turno> temp = repositorioTurnos.buscarTurnosDelMedico(medico.idPersonal());
        return medico.crearTurnosPara(fecha, temp);
    }

    public void agregarTurno(Paciente p, Turno turno) {
        turno.finalTurno(p, ultimoNumeroDeTurno());
        repositorioTurnos.agregarTurno(turno);
    }
}
