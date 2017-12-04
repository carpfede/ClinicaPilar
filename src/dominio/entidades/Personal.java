package dominio.entidades;

public abstract class Personal {
    protected int idPersonal;
    protected String nombre;
    protected int dni;
    protected ERol rol;

    public Personal() {
    }

    public Personal(int idPersonal, String nombre, int dni, ERol rol) {
        this.idPersonal = idPersonal;
        this.nombre = nombre;
        this.dni = dni;
        this.rol = rol;
    }

    public abstract int idPersonal();

    public abstract String getNombre();
}
