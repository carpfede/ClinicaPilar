package aplicacion.coordinadoresCU;

import dominio.entidades.Sesion;
import transversal.seguridad.SesionManejador;

public class AutenticacionManejador {
    private SesionManejador sesionManejador;


    public AutenticacionManejador(SesionManejador sesionManejador) {
        this.sesionManejador = sesionManejador;
    }

    public Sesion iniciarSesion(int id, int pass) {
        return sesionManejador.validarUsuario(id, pass);
    }
}