package dominio.contratosRepositorios;

import dominio.entidades.pacientes.Paciente;

public interface RepositorioPaciente {
    Paciente buscarPaciente(int dni);

    void agregarPaciente(Paciente paciente);
}
