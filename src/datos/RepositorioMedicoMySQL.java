package datos;

import dominio.contratosRepositorios.RepositorioMedico;
import dominio.entidades.*;

import java.util.ArrayList;


public class RepositorioMedicoMySQL implements RepositorioMedico {

    private ArrayList<Medico> medicos;

    public RepositorioMedicoMySQL() {
        inicializarMedicos();
    }

    @Override
    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    @Override
    public ArrayList<Medico> obtenerMedicos() {
        return medicos;
    }

    @Override
    public ArrayList<Medico> obtnerMedicosDe(EEspecialidades especialidad) {
        ArrayList<Medico> temp = new ArrayList<>();
        for (Medico m : medicos) {
            if (m.getEspecialidad() == especialidad) {
                temp.add(m);
            }
        }
        return temp;
    }

    @Override
    public Medico obtenerMedico(int idMedico) {
        for (Medico m : medicos) {
            if (m.idPersonal() == idMedico) {
                return m;
            }
        }
        return null;
    }


    private void inicializarMedicos() {
        medicos = new ArrayList<>();
        ERol rol = ERol.MEDICO;
        agregarMedico(new Medico(1, "Adolfo", 1, rol, EEspecialidades.CIRUJANO_PLASTICO, planTurnoAdolfo()));
        agregarMedico(new Medico(2, "Berta", 2, rol, EEspecialidades.NEUROLOGO, planTurnoBerta()));
    }

    private PlanTurno planTurnoBerta() {
        PlanTurno planTurno = new PlanTurno();
        planTurno.agregarDiaDeTrabajo(EDias.LUNES,new FormatoHorario(19, 0),new FormatoHorario(21, 0));
        planTurno.agregarDiaDeTrabajo(EDias.MIERCOLES,new FormatoHorario(17, 0),new FormatoHorario(19, 0));
        planTurno.agregarDiaDeTrabajo(EDias.VIERNES, new FormatoHorario(11, 30),new FormatoHorario(14, 30));
        return planTurno;
    }

    private PlanTurno planTurnoAdolfo() {
        PlanTurno planTurno = new PlanTurno();
        planTurno.agregarDiaDeTrabajo(EDias.MARTES,new FormatoHorario(11, 0),new FormatoHorario(14, 0));
        planTurno.agregarDiaDeTrabajo(EDias.JUEVES,new FormatoHorario(17, 0),new FormatoHorario(19, 0));
        planTurno.agregarDiaDeTrabajo(EDias.SABADO,new FormatoHorario(19, 30),new FormatoHorario(21, 30));
        return planTurno;
    }
}
