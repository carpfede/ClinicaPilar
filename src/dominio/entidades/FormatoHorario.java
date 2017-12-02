package dominio.entidades;

public class FormatoHorario {
    private int minuto;
    private int hora;

    public FormatoHorario(int hora, int minuto) {
        this.minuto = minuto;
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
}
