package dominio.entidades;

public class Turno {
    private int numero;
    private String fecha;
    private int horaInicio;
    private int minutoInicio;
    private int horaFinalizacion;
    private int minutoFinalizacion;

    private Paciente paciente;
    private Medico medico;

    public Turno(Paciente paciente, int numeroDeTurno) {
        numero = numeroDeTurno;
        this.paciente = paciente;
    }

    public Turno() {

    }

    public void finalTurno(Paciente p, int numero) {
        paciente = p;
        this.numero = numero;
    }

    public int getDni() {
        return paciente.getDni();
    }

    public void inicializarParametros(String fecha, int horaInicio, int minutoInicio, int horaFinal, int minutoFinal, Medico medico) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.minutoInicio = minutoInicio;
        this.horaFinalizacion = horaFinal;
        this.minutoFinalizacion = minutoFinal;
        this.medico = medico;
    }

    @Override
    public String toString() {
        return horaInicio + ":" + minutoMayorADiez(minutoInicio) + " a " +
                horaFinalizacion + ":" + minutoMayorADiez(minutoFinalizacion);
    }

    public String minutoMayorADiez(long minutoEntrada) {
        if (minutoEntrada < 10)
            return "0" + minutoEntrada;
        else
            return String.valueOf(minutoEntrada);
    }

    public void agregarHorario(String formatFecha, int horaEntrada, int minutoEntrada, int horaFinalizacion, int minutoFinalizacion, Medico medico) {
        inicializarParametros(formatFecha, horaEntrada, minutoEntrada, horaFinalizacion, minutoFinalizacion, medico);
    }

    public int getIdMedico() {
        return medico.idPersonal;
    }

    public String getFecha() {
        return fecha;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getMinutoInicio() {
        return minutoInicio;
    }
}
