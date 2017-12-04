package datos;

import dominio.contratosRepositorios.RepositorioMedico;
import dominio.contratosRepositorios.RepositorioUsuario;
import dominio.entidades.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RepositorioMedicoMySQL implements RepositorioMedico {
    private RepositorioUsuario repositorio;
    private Connection conexion;

    public RepositorioMedicoMySQL() {
        conexion = DBConection.iniciarConexion();
    }

    @Override
    public void agregarMedico(Medico medico) {
    }

    @Override
    public ArrayList<Medico> obtenerMedicos() {
        ArrayList<Medico> temp = new ArrayList<>();
        repositorio = new RepositorioUsuarioMySQL();
        String sql = "Select * from medicos ";
        try {
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Medico medico = (Medico) repositorio.buscarPersonal(res.getInt("idPersonal"));
                temp.add(medico);
                st.close();
                return temp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioMedicoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Medico> obtnerMedicosDe(EEspecialidades especialidad) {
        ArrayList<Medico> temp = new ArrayList<>();
        repositorio = new RepositorioUsuarioMySQL();
        String sql = "Select * from medicos where especialidad = " + especialidad.ordinal();
        try {
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Medico medico = (Medico) repositorio.buscarPersonal(res.getInt("idPersonal"));
                temp.add(medico);
                st.close();
                return temp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioMedicoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Medico obtenerMedico(int idMedico) {
        String sql = "Select * from medicos where idPersonal = " + idMedico;
        try {
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(sql);
            if(res.first()){
                EEspecialidades especialidad = EEspecialidades.values()[res.getInt("especialidad")];
                st.close();
                return new Medico(especialidad,planTurnoMabel());
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioMedicoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



    private PlanTurno planTurnoMabel() {
        PlanTurno planTurno = new PlanTurno();
        planTurno.agregarDiaDeTrabajo(EDias.LUNES,new FormatoHorario(19, 0),new FormatoHorario(21, 0));
        planTurno.agregarDiaDeTrabajo(EDias.MIERCOLES,new FormatoHorario(17, 0),new FormatoHorario(19, 0));
        planTurno.agregarDiaDeTrabajo(EDias.VIERNES, new FormatoHorario(11, 30),new FormatoHorario(14, 30));
        return planTurno;
    }

}
