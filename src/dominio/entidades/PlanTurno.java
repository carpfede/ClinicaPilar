package dominio.entidades;

import java.util.ArrayList;

public class PlanTurno {
    ArrayList<DiaDeTrabajo> diasDeTrabajo = new ArrayList<>();

    public void agregarDiaDeTrabajo(EDias dia, int horaDesde, int minutoDesde, int horaHasta, int minutoHasta) {
        diasDeTrabajo.add(new DiaDeTrabajo(dia, horaDesde, minutoDesde, horaHasta, minutoHasta));
    }

    public int getHoraEntrada(EDias dia) {
        for (DiaDeTrabajo trabajo : diasDeTrabajo) {
            if (trabajo.dia == dia) {
                return trabajo.horaDesde;
            }
        }
        return -1;
    }

    public int getMinutoEntrada(EDias dia) {
        for (DiaDeTrabajo trabajo : diasDeTrabajo) {
            if (trabajo.dia == dia) {
                return trabajo.minutoDesde;
            }
        }
        return -1;
    }

    public int getHoraSalida(EDias dia) {
        for (DiaDeTrabajo trabajo : diasDeTrabajo) {
            if (trabajo.dia == dia) {
                return trabajo.horaHasta;
            }
        }
        return -1;
    }

    public int getMinutoSalida(EDias dia) {
        for (DiaDeTrabajo trabajo : diasDeTrabajo) {
            if (trabajo.dia == dia) {
                return trabajo.minutoHasta;
            }
        }
        return -1;
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
        int horaDesde;
        int minutoDesde;
        int horaHasta;
        int minutoHasta;

        public DiaDeTrabajo(EDias dia, int horaDesde, int minutoDesde, int horaHasta, int minutoHasta) {
            this.dia = dia;
            this.horaDesde = horaDesde;
            this.minutoDesde = minutoDesde;
            this.horaHasta = horaHasta;
            this.minutoHasta = minutoHasta;
        }

    }
}
