package dominio.entidades;

public class ObraSocial {
    private int codigoObraSocial;
    private String nombre;

    public ObraSocial(int codigoObraSocial, String nombre) {
        this.codigoObraSocial = codigoObraSocial;
        this.nombre = nombre;
    }

    public int getCodigoObraSocial() {
        return codigoObraSocial;
    }

    public String toString() {
        return nombre;
    }

    public String getName() {
        return nombre;
    }
}
