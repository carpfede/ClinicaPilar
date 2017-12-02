package presentacion.interfaces;

import dominio.entidades.Sesion;

public interface InicioSesion {
    void mostrarMensaje(String mensaje);

    void accesoAlSistema(Sesion sesion);
}
