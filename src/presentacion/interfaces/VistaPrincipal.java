package presentacion.interfaces;

import aplicacion.coordinadorCU.BuscarPacienteManejador;

public interface VistaPrincipal {
    void añadirFuncionesMedico();

    void añadirFuncionesSecretaria();

    void añadirFuncionesEnfermera();

    void iniciarBusquedaPaciente(BuscarPacienteManejador manejador);
}
