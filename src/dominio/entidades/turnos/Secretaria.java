package dominio.entidades.turnos;

import dominio.entidades.ERol;
import dominio.entidades.Personal;

public class Secretaria extends Personal {
    public Secretaria(int idPersonal, String nombre, int dni, ERol rol) {
        super(idPersonal, nombre, dni, rol);
    }

    @Override
    public int idPersonal() {
        return idPersonal;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
