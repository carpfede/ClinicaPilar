package dominio.entidades;

import dominio.entidades.pacientes.Paciente;

public interface RegistroLog {
    void grabarUnPaciente(Paciente paciente);
}
