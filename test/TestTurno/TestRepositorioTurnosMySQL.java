package TestTurno;

import dominio.contratosRepositorios.RepositorioTurnos;
import dominio.entidades.Turno;
import main.FactoriaDeConfiguracion;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TestRepositorioTurnosMySQL{

    @Test
    public void numeroPrimerTurno(){
        //Arrange
        RepositorioTurnos repositorioTurnos = FactoriaDeConfiguracion.getRepositorioTurnos();

        //Act
        int x = repositorioTurnos.ultimoNumeroDeTurno();

        //Assert
        assertEquals(1,x);
    }


    @Test
    public void numeroSiguienteTurno(){
        //Arrange
        RepositorioTurnos repositorioTurnos = FactoriaDeConfiguracion.getRepositorioTurnos();
        Turno turno = new Turno();

        //Act
        repositorioTurnos.agregarTurno(turno);
        int x = repositorioTurnos.ultimoNumeroDeTurno();

        //Assert
        assertEquals(2,x);
    }
}
