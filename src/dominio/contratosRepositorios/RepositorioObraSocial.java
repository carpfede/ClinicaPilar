package dominio.contratosRepositorios;

import dominio.entidades.ObraSocial;

import java.util.ArrayList;

public interface RepositorioObraSocial {
    ArrayList<ObraSocial> obtenerObrasSociales();

    ObraSocial obtenerObraSocial(int codigo);

    void cargarObraSocial(ObraSocial obraSocial);
}
