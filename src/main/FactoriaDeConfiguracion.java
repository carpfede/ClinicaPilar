package main;

import datos.*;
import dominio.contratosRepositorios.*;
import dominio.entidades.RegistroLog;

public class FactoriaDeConfiguracion {

    private static ArchivoConfiguracion instanciaRutaRegistroLog;
    private static RegistroLog instanciaRegistroLog;
    private static RepositorioObraSocial repositorioObraSocial;
    private static RepositorioMedico repositorioMedico;
    private static RepositorioPaciente repositorioPaciente;
    private static RepositorioTurnos repositorioTurnos;
    private static RepositorioUsuario repositorioUsuario;

    public static synchronized ArchivoConfiguracion getInstanceRutasRegistroLog() {
        if (instanciaRutaRegistroLog == null) {
            instanciaRutaRegistroLog = new ArchivoConfiguracion();
        }
        return instanciaRutaRegistroLog;
    }

    public static synchronized RegistroLog getInstanciaRegistroLog() throws Exception {
        if (instanciaRegistroLog == null) {
            String claseImpl = ArchivoConfiguracion.claseImplArchivoLog();
            instanciaRegistroLog = CargadorArchivoLog.crearArchivoLogImpl(claseImpl);
        }
        return instanciaRegistroLog;
    }

    public static synchronized RepositorioObraSocial getRepositorioObraSocial() {
        if (repositorioObraSocial == null) {
            repositorioObraSocial = new RepositorioObraSocialMySQL();
        }
        return repositorioObraSocial;
    }

    public static synchronized RepositorioMedico getRepositorioMedico() {
        if (repositorioMedico == null) {
            repositorioMedico = new RepositorioMedicoMySQL();
        }
        return repositorioMedico;
    }

    public static synchronized RepositorioPaciente getRepositorioPaciente() {
        if (repositorioPaciente == null) {
            repositorioPaciente = new RepositorioPacienteMySQL();
        }
        return repositorioPaciente;
    }

    public static synchronized RepositorioTurnos getRepositorioTurnos() {
        if (repositorioTurnos == null) {
            repositorioTurnos = new RepositorioTurnosMySQL();
        }
        return repositorioTurnos;
    }

    public static synchronized RepositorioUsuario getRepositorioUsuario() {
        if (repositorioUsuario == null) {
            repositorioUsuario = new RepositorioUsuarioMySQL();
        }
        return repositorioUsuario;
    }
}
