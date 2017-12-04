package datos;

import dominio.contratosRepositorios.RepositorioMedico;
import dominio.contratosRepositorios.RepositorioUsuario;
import dominio.entidades.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.FactoriaDeConfiguracion;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RepositorioUsuarioMySQL implements RepositorioUsuario {

    private RepositorioMedico repositorioMedico;
    private Connection conexion;
    private Statement statement;

    public RepositorioUsuarioMySQL() {
        this.repositorioMedico = FactoriaDeConfiguracion.getRepositorioMedico();
        conexion = DBConection.iniciarConexion();
    }


    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        throw new NotImplementedException();
    }

    @Override
    public Usuario buscarUsuario(int id) {
        String sql = "Select * from usuarios where id= " + id;
        ResultSet res;
        try {
            statement = conexion.createStatement();
            res = statement.executeQuery(sql);
            if (res.first()) {
                Personal personal = buscarPersonal(res.getInt("idPersonal"));
                int pw = res.getInt("contraseña");
                statement.close();
                return new Usuario(id, pw, personal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuarioMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Personal buscarPersonal(int id) {
        String sql = "Select * from personal where id= " + id;
        ResultSet res;
        try {
            statement = conexion.createStatement();
            res = statement.executeQuery(sql);
            if (res.first()) {
                int dni = res.getInt("dni");
                String nombre = res.getString("nombre");
                ERol rol = ERol.values()[res.getInt("rol")];
                switch(rol){
                    case ENFERMERA:
                        statement.close();
                        return new Enfermera(id, nombre, dni, rol);
                    case MEDICO:
                    Medico medico = repositorioMedico.obtenerMedico(id);
                    medico.parametros(id,nombre,dni,rol);
                    statement.close();
                        return medico;
                    case SECRETARIA:
                        statement.close();
                        return new Secretaria(id, nombre, dni, rol);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuarioMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
