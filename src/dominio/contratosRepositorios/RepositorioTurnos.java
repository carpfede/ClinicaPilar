package dominio.contratosRepositorios;

import dominio.entidades.Turno;

import java.util.ArrayList;

public interface RepositorioTurnos {
    int ultimoNumeroDeTurno();

    void agregarTurno(Turno t);

    Turno buscarTurno(int dni);

    void darDeBajaLosTurnosDelDia();

    ArrayList<Turno> buscarTurnosDelMedico(int idMedico);
}
