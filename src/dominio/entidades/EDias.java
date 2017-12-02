package dominio.entidades;

public enum EDias {
    DOMINGO(0),
    LUNES(1),
    MARTES(2),
    MIERCOLES(3),
    JUEVES(4),
    VIERNES(5),
    SABADO(6);

    private int value;

    EDias(int i) {
        value = i;
    }

    public int getDia() {
        return value;
    }
}
