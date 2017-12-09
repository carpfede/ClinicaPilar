package dominio.entidades.pacientes;

public class AfiliacionObraSocial {
    private ObraSocial obraSocial;
    private int numeroAsociado;


    public AfiliacionObraSocial(ObraSocial obraSocial, int numeroAsociado) {
        this.obraSocial = obraSocial;
        this.numeroAsociado = numeroAsociado;
    }

    public String getObraSocial() {
        return obraSocial.toString();
    }

    public int getNumeroAsociado() {
        return numeroAsociado;
    }
}
