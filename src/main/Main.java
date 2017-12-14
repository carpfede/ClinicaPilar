package main;

import aplicacion.coordinadoresCU.AutenticacionManejador;
import presentacion.vista.IniciarSesionView;
import transversal.seguridad.SesionManejador;

public class Main {
    public static void main(String[] args) {
        SesionManejador sesionManejador = new SesionManejador();
        AutenticacionManejador autenticacionManejador = new AutenticacionManejador(sesionManejador);
        IniciarSesionView inicioSesionView = new IniciarSesionView(autenticacionManejador);
        inicioSesionView.setVisible(true);
    }
}
