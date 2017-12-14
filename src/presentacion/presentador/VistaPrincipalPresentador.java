package presentacion.presentador;

import aplicacion.coordinadoresCU.BuscarPacienteManejador;
import dominio.entidades.Sesion;
import presentacion.vista.VistaPrincipalView;

public class VistaPrincipalPresentador {

    private VistaPrincipalView view;

    public VistaPrincipalPresentador(VistaPrincipalView vistaPrincipalView) {
        view = vistaPrincipalView;
    }

    public void nuevoTurno() {
        BuscarPacienteManejador buscarPacienteManejador = new BuscarPacienteManejador();
        view.iniciarBusquedaPaciente(buscarPacienteManejador);
    }

    public void inicializarFunciones(Sesion sesion) {
        switch (sesion.getRol()) {
            case ENFERMERA:
                view.añadirFuncionesEnfermera();
                break;
            case MEDICO:
                view.añadirFuncionesMedico();
                break;
            case SECRETARIA:
                view.añadirFuncionesSecretaria();
                break;
        }
    }
}
