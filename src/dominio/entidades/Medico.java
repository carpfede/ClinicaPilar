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
    
    public Medico(EEspecialidades especialidad, PlanTurno planTurnoMabel) {
        this.especialidad = especialidad;
        this.planTurno = planTurnoMabel;
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

    public FormatoHorario getInicio(EDias dia) {
        return planTurno.getInicio(dia);
    }

    public FormatoHorario getFin(EDias dia) {
        return planTurno.getFin(dia);
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
            turnos = crearTurnos(getInicio(dia), getFin(dia), fecha);
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

    private ArrayList<Turno> crearTurnos(FormatoHorario turnoEntrada,FormatoHorario turnoSalida, Date fecha) {
        ArrayList<Turno> temporal = new ArrayList<>();
        Turno turno = new Turno();
        FormatoHorario horaInicio = turnoEntrada;
        while(turno.noSupera(horaInicio,turnoSalida)){
            FormatoHorario horaFin = turno.horaFin(horaInicio,reglaDuracionDeTurno());
            String formatFecha = formatoDeFecha(fecha);
            turno.agregarHorario(formatFecha, horaInicio, horaFin, this);            
            temporal.add(turno);
            horaInicio = horaFin;
            turno = new Turno();
        }
        return temporal;
    }
    
    private String formatoDeFecha(Date fecha) {
        return new SimpleDateFormat("dd/MM/yyyy").format(fecha);
    }

    private int reglaDuracionDeTurno() {
        return ArchivoConfiguracion.duracionDelTurno();
    }

    public void parametros(int id, String nombre, int dni, ERol rol) {
        this.idPersonal = id;
        this.nombre = nombre;
        this.dni = dni;
        this.rol = rol;
    }
}
