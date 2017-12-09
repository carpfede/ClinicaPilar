package datos;

import dominio.contratosRepositorios.RepositorioObraSocial;
import dominio.entidades.pacientes.ObraSocial;

import java.util.ArrayList;

public class RepositorioObraSocialMySQL implements RepositorioObraSocial {
    private ArrayList<ObraSocial> obraSocials;

    public RepositorioObraSocialMySQL() {
        inicializarObrasSociales();
    }

    private void inicializarObrasSociales() {
        obraSocials = new ArrayList<>();
        obraSocials.add(new ObraSocial(0, "Sin Obra Social"));
        obraSocials.add(new ObraSocial(1, "OSECAC"));
        obraSocials.add(new ObraSocial(2, "Subsidio"));
        obraSocials.add(new ObraSocial(3, "OSDE"));
    }

    @Override
    public ArrayList<ObraSocial> obtenerObrasSociales() {
        return obraSocials;
    }

    @Override
    public ObraSocial obtenerObraSocial(int codigo) {
        for (ObraSocial o : obraSocials) {
            if (o.getCodigoObraSocial() == codigo) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void cargarObraSocial(ObraSocial obraSocial) {
        obraSocials.add(obraSocial);
    }
}
