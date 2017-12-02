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
        planTurno.agregarDiaDeTrabajo(EDias.LUNES, 19, 0, 21, 0);
        planTurno.agregarDiaDeTrabajo(EDias.MIERCOLES, 17, 0, 19, 0);
        planTurno.agregarDiaDeTrabajo(EDias.VIERNES, 11, 30, 14, 30);
        return planTurno;
    }

    private PlanTurno planTurnoAdolfo() {
        PlanTurno planTurno = new PlanTurno();
        planTurno.agregarDiaDeTrabajo(EDias.MARTES, 11, 0, 14, 0);
        planTurno.agregarDiaDeTrabajo(EDias.JUEVES, 17, 0, 19, 0);
        planTurno.agregarDiaDeTrabajo(EDias.SABADO, 19, 30, 21, 30);
        return planTurno;
    }
}
