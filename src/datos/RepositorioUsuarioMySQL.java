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

public class RepositorioUsuarioMySQL implements RepositorioUsuario {

    private RepositorioMedico repositorioMedico;
    private Connection conexion;
    private Statement statement;
    private ArrayList<Usuario> usuarios;

    public RepositorioUsuarioMySQL() {
        this.repositorioMedico = FactoriaDeConfiguracion.getRepositorioMedico();
        conexion = DBConection.iniciarConexion();
        inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        usuarios = new ArrayList<>();
        ArrayList<Medico> medicos = repositorioMedico.obtenerMedicos();
        usuarios.add(new Usuario(1, 1, medicos.get(0)));
        usuarios.add(new Usuario(2, 2, medicos.get(1)));
        Personal enfermera1 = new Enfermera(3, "Marta", 3, ERol.ENFERMERA);
        usuarios.add(new Usuario(3, 3, enfermera1));
        Personal secretaria1 = new Secretaria(4, "Lucila", 4, ERol.SECRETARIA);
        usuarios.add(new Usuario(4, 4, secretaria1));
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @Override
    public Usuario buscarUsuario(int id) {
//        for (Usuario usuario : usuarios) {
//            if ((usuario.getIdUsuario() == id))
//                return usuario;
//        }
//        return null;
        String sql = "Select * from usuarios where id= " + id;
        ResultSet res;
        try {
            statement = conexion.createStatement();
            res = statement.executeQuery(sql);
            if (res.first()) {
                Personal personal = buscarPersonal(res.getInt("idPersonal"));
                int pw = res.getInt("contraseña");
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
                        return new Enfermera(id, nombre, dni, rol);
                    case MEDICO:
                        return repositorioMedico.obtenerMedico(id);
                    case SECRETARIA:
                        return new Secretaria(id, nombre, dni, rol);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuarioMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
