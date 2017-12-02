package dominio.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Medico extends Personal {
    private EEspecialidades especialidad;
    private PlanTurno planTurno;

    public Medico(int idPersonal, String nombre, int dni, ERol rol, EEspecialidades especialidad, PlanTurno planTurno) {
        super(idPersonal, nombre, dni, rol);
        this.especialidad = especialidad;
        this.planTurno = planTurno;
    }

    public EEspecialidades getEspecialidad() {
        return especialidad;
    }

    @Override
    public int idPersonal() {
        return idPersonal;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre;
    }

    public int getHoraEntrada(EDias lunes) {
        return planTurno.getHoraEntrada(lunes);
    }

    public int getMinutoEntrada(EDias lunes) {
        return planTurno.getMinutoEntrada(lunes);
    }

    public int getHoraSalida(EDias lunes) {
        return planTurno.getHoraSalida(lunes);
    }

    public int getMinutoSalida(EDias dia) {
        return planTurno.getMinutoSalida(dia);
    }

    public boolean trabajaElDia(EDias dia) {
        return planTurno.trabajaElDia(dia);
    }

    public ArrayList<Turno> crearTurnosPara(Date fecha, ArrayList<Turno> turnosAsignados) {
        ArrayList<Turno> turnos = null;
        turnos = crearTurnosdelMedico(fecha, turnos, turnosAsignados);
        return turnos;
    }

    private ArrayList<Turno> crearTurnosdelMedico(Date fecha, ArrayList<Turno> turnos, ArrayList<Turno> turnosAsignados) {
        EDias dia = EDias.values()[fecha.getDay()];
        if (trabajaElDia(dia)) {
            turnos = crearTurnos(getHoraEntrada(dia), getMinutoEntrada(dia),
                    getHoraSalida(dia), getMinutoSalida(dia), fecha);
            eliminarTurnosRepetidos(turnosAsignados, turnos);
        }
        return turnos;
    }

    private void eliminarTurnosRepetidos(ArrayList<Turno> turnosAsignados, ArrayList<Turno> turnos) {
        ArrayList<Turno> temporal = new ArrayList<>();
        for (int i = 0; i < turnos.size(); i++) {
            Turno turno = turnos.get(i);
            for (int y = 0; y < turnosAsignados.size(); y++) {
                Turno t = turnosAsignados.get(y);
                if (turno.getFecha().equals(t.getFecha())
                        && turno.getHoraInicio() == t.getHoraInicio()
                        && turno.getMinutoInicio() == t.getMinutoInicio()) {
                    temporal.add(turno);
                }
            }
        }
        turnos.removeAll(temporal);
    }

    private ArrayList<Turno> crearTurnos(int horaEntrada, int minutoEntrada,
                                         int horaSalida, int minutoSalida, Date fecha) {
        ArrayList<Turno> temporal = new ArrayList<>();
        int horaInicio = horaEntrada;
        int minutoInicio = minutoEntrada;
        int minutoFinalizacion = aplicarReglaTurno(minutoInicio);
        int horaFinalizacion = horaInicio;
        if (seCumplioUnaHora(minutoFinalizacion)) {
            minutoFinalizacion = pasoUnaHora(minutoFinalizacion);
            horaFinalizacion = sumaUnaHora(horaFinalizacion);
        }
        while (condicion(horaSalida, minutoSalida, minutoFinalizacion, horaFinalizacion)) {
            Turno turno = new Turno();
            String formatFecha = formatoDeFecha(fecha);
            turno.agregarHorario(formatFecha, horaInicio, minutoInicio, horaFinalizacion, minutoFinalizacion, this);
            horaInicio = horaFinalizacion;
            minutoInicio = minutoFinalizacion;
            minutoFinalizacion = aplicarReglaTurno(minutoInicio);
            if (seCumplioUnaHora(minutoFinalizacion)) {
                minutoFinalizacion = pasoUnaHora(minutoFinalizacion);
                horaFinalizacion = sumaUnaHora(horaFinalizacion);
            }
            temporal.add(turno);
        }
        return temporal;
    }

    private int sumaUnaHora(int horaFinalizacion) {
        horaFinalizacion += 1;
        return horaFinalizacion;
    }

    private int pasoUnaHora(int minutoFinalizacion) {
        minutoFinalizacion -= 60;
        return minutoFinalizacion;
    }

    private int aplicarReglaTurno(int minutoInicio) {
        return minutoInicio + reglaDuracionDeTurno();
    }

    private boolean condicion(int horaSalida, int minutoSalida, int minutoFinalizacion, int horaFinalizacion) {
        boolean b = horaFinalizacion < horaSalida;
        boolean b1 = horaFinalizacion == horaSalida && minutoFinalizacion <= minutoSalida;
        return b || b1;
    }

    private String formatoDeFecha(Date fecha) {
        return new SimpleDateFormat("dd/MM/yyyy").format(fecha);
    }

    private boolean seCumplioUnaHora(long minutoFinalizacion) {
        if (minutoFinalizacion >= 60)
            return true;
        else
            return false;
    }

    private int reglaDuracionDeTurno() {
        return ArchivoConfiguracion.duracionDelTurno();
    }

}
