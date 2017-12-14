package presentacion.presentador;

import aplicacion.coordinadoresCU.AutenticacionManejador;
import dominio.entidades.Sesion;
import presentacion.interfaces.InicioSesion;

public class InicioSesionPresentador {
    private InicioSesion view;
    private AutenticacionManejador autenticacionManejador;

    public InicioSesionPresentador(InicioSesion view, AutenticacionManejador autenticacionManejador) {
        this.view = view;
        this.autenticacionManejador = autenticacionManejador;
    }

    public void iniciarSesion(String id, String pw) {
        Sesion sesion = autenticacionManejador.iniciarSesion(Integer.parseInt(id), Integer.parseInt(pw));
        if (sesion != null) {
            view.accesoAlSistema(sesion);
        } else {
            view.mostrarMensaje("Usuario o contraseña incorrecto");
        }
    }
}
