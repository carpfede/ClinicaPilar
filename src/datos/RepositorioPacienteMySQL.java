package datos;

import dominio.contratosRepositorios.RepositorioObraSocial;
import dominio.contratosRepositorios.RepositorioPaciente;
import dominio.entidades.AfiliacionObraSocial;
import dominio.entidades.Paciente;
import main.FactoriaDeConfiguracion;

import java.util.ArrayList;

public class RepositorioPacienteMySQL implements RepositorioPaciente {

    private ArrayList<Paciente> pacientes;

    public RepositorioPacienteMySQL() {
        RepositorioObraSocial repositorioObraSocial = FactoriaDeConfiguracion.getRepositorioObraSocial();
        inicializarPacientes(repositorioObraSocial);
    }

    private void inicializarPacientes(RepositorioObraSocial repositorioObraSocial) {

        pacientes = new ArrayList<>();
        agregarPaciente(nuevoPaciente("Federico", "Fia Sare", "Alderetes", 37754244, 3814785477L, 24, new AfiliacionObraSocial(repositorioObraSocial.obtenerObraSocial(0), 0)));
        agregarPaciente(nuevoPaciente("Emmanuel", "Gonzalez", "San Miguel", 38487359, 3815554789L, 23, new AfiliacionObraSocial(repositorioObraSocial.obtenerObraSocial(1), 2)));
        agregarPaciente(nuevoPaciente("Gerardo", "Mansilla", "San Miguel", 36838004, 3816875478L, 25, new AfiliacionObraSocial(repositorioObraSocial.obtenerObraSocial(2), 3)));
        agregarPaciente(nuevoPaciente("Rodrigo", "Sanchez", "San Miguel", 37315082, 3815879444L, 24, new AfiliacionObraSocial(repositorioObraSocial.obtenerObraSocial(0), 4)));
    }

    private Paciente nuevoPaciente(String nombre, String apellido, String domicilio, int dni, long telefono, int edad, AfiliacionObraSocial obraSocial) {
        return new Paciente(nombre, apellido, domicilio, dni, telefono, edad, obraSocial);
    }

    @Override
    public Paciente buscarPaciente(int dni) {
        for (Paciente p : pacientes) {
            if (p.getDni() == dni)
                return p;
        }
        return null;
    }

    @Override
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
}
