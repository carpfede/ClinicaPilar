package dominio.entidades;

public class Turno {
    private int numero;
    private String fecha;
    private FormatoHorario inicio;
    private FormatoHorario fin;

    private Paciente paciente;
    private Medico medico;

    public Turno() {
    }

    public void finalTurno(Paciente p, int numero) {
        paciente = p;
        this.numero = numero;
    }

    public int getDni() {
        return paciente.getDni();
    }

    public void inicializarParametros(String fecha, FormatoHorario inicio,FormatoHorario fin, Medico medico) {
        this.fecha = fecha;
        this.inicio = inicio;
        this.fin = fin;
        this.medico = medico;
    }

    @Override
    public String toString() {
        return inicio.getHora() + ":" + minutoMayorADiez(inicio.getMinuto()) + " a " +
                fin.getHora() + ":" + minutoMayorADiez(fin.getMinuto());
    }

    public String minutoMayorADiez(long minutoEntrada) {
        if (minutoEntrada < 10)
            return "0" + minutoEntrada;
        else
            return String.valueOf(minutoEntrada);
    }

    public void agregarHorario(String formatFecha,FormatoHorario inicio,FormatoHorario fin,Medico medico){
        inicializarParametros(fecha, inicio, fin, medico);
    }
    public int getIdMedico() {
        return medico.idPersonal;
    }

    public String getFecha() {
        return fecha;
    }

    public int getHoraInicio() {
        return inicio.getHora();
    }

    public int getMinutoInicio() {
        return inicio.getMinuto();
    }

    boolean noSupera(FormatoHorario turnoTemporal, FormatoHorario turnoSalida) {
        boolean primero = turnoTemporal.getHora() < turnoSalida.getHora();//horaFinalizacion < horaSalida;
        boolean segundo = turnoTemporal.getHora() == turnoSalida.getHora() && 
                turnoTemporal.getMinuto() < turnoSalida.getMinuto();
        return primero || segundo;
    }

    FormatoHorario horaFin(FormatoHorario turnoEntrada,int reglaDuracion) {
        int minuto = turnoEntrada.getMinuto() + reglaDuracion;
        int hora = turnoEntrada.getHora();
        if(seCumpleLaHora(minuto)){
            minuto -=60;
            hora +=1;
        }
        return new FormatoHorario(hora, minuto);
    }

    private static boolean seCumpleLaHora(int minuto) {
        return minuto >= 60;
    }
}
