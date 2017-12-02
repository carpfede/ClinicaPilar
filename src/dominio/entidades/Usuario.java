package dominio.entidades;

public class Usuario {
    private int idUsuario;
    private int contraseña;
    private Personal personal;

    public Usuario(int id, int contraseña, Personal personal) {
        this.idUsuario = id;
        this.contraseña = contraseña;
        this.personal = personal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getContraseña() {
        return contraseña;
    }

    public ERol getRol() {
        return personal.rol;
    }

    public String getNombre() {
        return personal.getNombre();
    }
}