package dominio.contratosRepositorios;

import dominio.entidades.Paciente;

public interface RepositorioPaciente {
    Paciente buscarPaciente(int dni);

    void agregarPaciente(Paciente paciente);
}
