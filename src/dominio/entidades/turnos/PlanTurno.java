package dominio.entidades.turnos;

import java.util.ArrayList;

public class PlanTurno {

    ArrayList<DiaDeTrabajo> diasDeTrabajo = new ArrayList<>();

    public void agregarDiaDeTrabajo(EDias dia, FormatoHorario inicio, FormatoHorario fin) {
        diasDeTrabajo.add(new DiaDeTrabajo(dia, inicio, fin));
    }

    public FormatoHorario getInicio(EDias dia) {
        for (DiaDeTrabajo trabajo : diasDeTrabajo) {
            if (trabajo.dia == dia) {
                return trabajo.inicio;
            }
        }
        return null;
    }

    public FormatoHorario getFin(EDias dia) {
        for (DiaDeTrabajo trabajo : diasDeTrabajo) {
            if (trabajo.dia == dia) {
                return trabajo.salida;
            }
        }
        return null;
    }

    public boolean trabajaElDia(EDias dia) {
        for (DiaDeTrabajo trabajo : diasDeTrabajo) {
            if (trabajo.dia == dia) {
                return true;
            }
        }
        return false;
    }

    private class DiaDeTrabajo {

        EDias dia;
        FormatoHorario inicio;
        FormatoHorario salida;

        public DiaDeTrabajo(EDias dia, FormatoHorario inicio, FormatoHorario salida) {
            this.dia = dia;
            this.inicio = inicio;
            this.salida = salida;
        }
    }
}
