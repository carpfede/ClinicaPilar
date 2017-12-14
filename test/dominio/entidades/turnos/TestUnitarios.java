/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.entidades.turnos;

import dominio.entidades.Sesion;
import java.util.ArrayList;
import java.util.Date;
import main.ArchivoConfiguracion;
import main.FactoriaDeConfiguracion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transversal.seguridad.SesionManejador;

/**
 *
 * @author millo
 */
public class TestUnitarios {
    
    public TestUnitarios() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public void testComprobarReglaDuracionDelTurno(){
        //Dado
        int duracionDelTurno = ArchivoConfiguracion.duracionDelTurno();
        Date fecha = new Date(2017, 12,11);
        ArrayList<Turno> temp = new ArrayList<>();
        Medico medico = FactoriaDeConfiguracion.getRepositorioMedico().obtenerMedico(1);
        ArrayList<Turno> turnos = medico.crearTurnosPara(fecha, temp);
        Turno turno = turnos.get(0);
        
        //Cuando  
        int duracionReal = turno.duracionReal();
        
        // Entonces
        assertEquals(duracionDelTurno,duracionReal);
    }
    
    @Test
    public void testComprobarDiaDeTrabajoDeUnMedico(){
        //Dado
        Date fecha = new Date(2017,12,12);
        ArrayList<Turno> turnosAsignados = new ArrayList<>();
        Medico medico = FactoriaDeConfiguracion.getRepositorioMedico().obtenerMedico(1);
        
        //Cuando
        ArrayList<Turno> turnos = medico.crearTurnosPara(fecha, turnosAsignados);
        
        //Entonces
        assertNull(turnos);
    }
    
    @Test
    public void testComprobarTurnoANoSuperaTurnoB() {
        //Dado
        FormatoHorario turnoA = new FormatoHorario(19, 20);
        FormatoHorario turnoB = new FormatoHorario(19, 0);
        Turno instance = new Turno();
        
        //Cuando
        boolean result = instance.noSupera(turnoA, turnoB);
        
        //Entonces
        assertEquals(false, result);
    }
    
    @Test
    public void testComprobarSiSeCumplioLaHora() {
        //Dado
        FormatoHorario turnoEntrada = new FormatoHorario(19, 45);
        int reglaDuracion = 15;
        Turno instance = new Turno();
        
        //Cuando
        FormatoHorario result = instance.seCumplioLaHora(turnoEntrada, reglaDuracion);
        
        //Entonces
        assertEquals(20, result.getHora());
    }
    
    @Test
    public void testComprobarSesionDeUsuario(){
        //Dado
        int id = 178;
        int pw = 200;
        SesionManejador manejador = new SesionManejador();
        
        //Cuando
        Sesion sesion = manejador.validarUsuario(id, pw);
        
        //Entonces
        assertNull(sesion);
    }
}
