package datos;

import dominio.contratosRepositorios.RepositorioTurnos;
import dominio.entidades.Turno;

import java.util.ArrayList;

public class RepositorioTurnosMySQL implements RepositorioTurnos {
    private ArrayList<Turno> turnos;

    public RepositorioTurnosMySQL() {
        turnos = new ArrayList<>();
    }

    @Override
    public int ultimoNumeroDeTurno() {
        return turnos.size() + 1;
    }

    @Override
    public void agregarTurno(Turno t) {
        turnos.add(t);
    }

    @Override
    public Turno buscarTurno(int dni) {
        Turno t = null;
        for (Turno turno : turnos) {
            if (turno.getDni() == dni)
                t = turno;
        }
        return t;
    }

    @Override
    public void darDeBajaLosTurnosDelDia() {

    }

    @Override
    public ArrayList<Turno> buscarTurnosDelMedico(int idMedico) {
        ArrayList<Turno> turnosDeMedico = new ArrayList<>();
        for (Turno t : turnos) {
            if (t.getIdMedico() == idMedico) {
                turnosDeMedico.add(t);
            }
        }
        return turnosDeMedico;
    }
}
