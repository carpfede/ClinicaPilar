package datos;

import dominio.contratosRepositorios.RepositorioObraSocial;
import dominio.contratosRepositorios.RepositorioPaciente;
import dominio.entidades.pacientes.AfiliacionObraSocial;
import main.DBConection;
import dominio.entidades.pacientes.Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.FactoriaDeConfiguracion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioPacienteMySQL implements RepositorioPaciente {

    private Connection conexion;
    private final RepositorioObraSocial repositorioObraSocial;

    public RepositorioPacienteMySQL() {
        repositorioObraSocial = FactoriaDeConfiguracion.getRepositorioObraSocial();
        conexion = DBConection.iniciarConexion();
    }

    private Paciente nuevoPaciente(String nombre, String apellido, String domicilio, int dni, long telefono, int edad, AfiliacionObraSocial obraSocial) {
        return new Paciente(nombre, apellido, domicilio, dni, telefono, edad, obraSocial);
    }

    @Override
    public Paciente buscarPaciente(int dni) {
        String sql = "Select * from pacientes where dni = " + dni;
        try {
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.first()) {
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String domicilio = res.getString("direccion");
                Long telefono = res.getLong("telefono");
                int edad = res.getInt("edad");
                Paciente paciente = nuevoPaciente(nombre, apellido, domicilio, dni, telefono, edad, new AfiliacionObraSocial(repositorioObraSocial.obtenerObraSocial(0), 0));
                st.close();
                return paciente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioPacienteMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void agregarPaciente(Paciente paciente) {
        String sql = "INSERT INTO `pacientes`(`dni`, `nombre`, `apellido`, `direccion`, `telefono`, `edad`) VALUES ("+
                paciente.getDni() + ",'" + paciente.getNombre() + "','" +
                paciente.getApellido() + "','" + paciente.getDomicilio() + "'," +
                paciente.getTelefono() + "," + paciente.getEdad() + ")";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioPacienteMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
