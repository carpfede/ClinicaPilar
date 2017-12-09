package datos;

import dominio.contratosRepositorios.RepositorioPaciente;
import dominio.contratosRepositorios.RepositorioTurnos;
import dominio.contratosRepositorios.RepositorioUsuario;
import main.DBConection;
import dominio.entidades.turnos.FormatoHorario;
import dominio.entidades.turnos.Medico;
import dominio.entidades.pacientes.Paciente;
import dominio.entidades.turnos.Turno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioTurnosMySQL implements RepositorioTurnos {
    private ArrayList<Turno> turnos;
    private Connection conexion;
    private RepositorioUsuario repositorioPersonal;
    private RepositorioPaciente repositorioPacientes;
    
    public RepositorioTurnosMySQL() {
        conexion = DBConection.iniciarConexion();
        repositorioPersonal = new RepositorioUsuarioMySQL();
        repositorioPacientes = new RepositorioPacienteMySQL();
        turnos = new ArrayList<>();
    }

    @Override
    public int ultimoNumeroDeTurno() {
        String sql = "Select * from turnos";
        ResultSet res;
        try {
            Statement st = conexion.createStatement();
            res = st.executeQuery(sql);
            if(res.last())
                return res.getInt("numero") + 1;
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioTurnosMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    @Override
    public void agregarTurno(Turno t) {
        turnos.add(t);
        String sql = "INSERT INTO `turnos`"
                + "(`numero`, `idPaciente`, `idPersonal`, `fecha`, `horaInicio`, `minutoInicio`, `horaFin`, `minutoFin`) VALUES ( " 
                +t.getNumero()+","+t.getDni()+","+t.getIdMedico()+",'"+t.getFecha()+"',"+
                t.getHoraInicio()+","+t.getMinutoInicio()+","+t.getHoraFin()+","+t.getMinutoFin()+")";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioTurnosMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Turno buscarTurno(int dni) {
        return null;
    }

    @Override
    public void darDeBajaLosTurnosDelDia() {

    }

    @Override
    public ArrayList<Turno> buscarTurnosDelMedico(int idMedico) {
        ArrayList<Turno> turnosDeMedico = new ArrayList<>();
        String sql = "Select * from turnos where idPersonal = " + idMedico;
        ResultSet res;
        try {
            Statement st = conexion.createStatement();
            res = st.executeQuery(sql);
            while(res.next()){
                FormatoHorario inicio = new FormatoHorario(res.getInt("horaInicio"),res.getInt("minutoInicio"));
                FormatoHorario fin = new FormatoHorario(res.getInt("horaFin"),res.getInt("minutoFin"));
                Medico medico = (Medico) repositorioPersonal.buscarPersonal(idMedico);
                Paciente paciente = repositorioPacientes.buscarPaciente(res.getInt("idPaciente"));
                Turno turno = new Turno(res.getInt("numero"),res.getString("fecha"),inicio, fin, paciente, medico);
                turnosDeMedico.add(turno);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioTurnosMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return turnosDeMedico;
    }
}
