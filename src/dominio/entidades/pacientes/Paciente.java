package dominio.entidades.pacientes;

public class Paciente {
    private String nombre;
    private int dni;
    private long telefono;
    private String apellido;
    private int edad;
    private AfiliacionObraSocial obraSocial;
    private String domicilio;

    public Paciente(String nombre, String apellido, String domicilio, int dni, long telefono, int edad, AfiliacionObraSocial obraSocial) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.apellido = apellido;
        this.edad = edad;
        this.obraSocial = obraSocial;
        this.domicilio = domicilio;
    }

    public int getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObraSocial() {
        return obraSocial.getObraSocial();
    }

    public int getNumeroAfiliado() {
        return obraSocial.getNumeroAsociado();
    }

    public String getDomicilio() {
        return domicilio;
    }
}
