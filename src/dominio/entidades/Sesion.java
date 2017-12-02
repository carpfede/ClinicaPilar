package dominio.entidades;

public class Sesion {
    private Usuario usuario;

    public Sesion(Usuario usuario) {
        this.usuario = usuario;
    }

    public ERol getRol() {
        return usuario.getRol();
    }

    public String getNombre() {
        return usuario.getNombre();
    }
}
