package transversal.operaciones;

import main.ArchivoConfiguracion;
import dominio.entidades.pacientes.Paciente;
import dominio.entidades.RegistroLog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroLogArchivoTxt implements RegistroLog {

    private String ruta = ArchivoConfiguracion.rutaArchivoLog();
    ;
    private File archivo;
    private BufferedWriter writer;

    public void abrirArchivoLog() {
        archivo = new File(ruta);
        try {
            writer = new BufferedWriter(new FileWriter(archivo, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivoLog(Paciente paciente) {
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String mensaje = fecha + ": Dni " + paciente.getDni() + " , " + paciente.getApellido() + " , " + paciente.getNombre() + "\n";
        try {
            writer.write(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrarArchivoLog() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void grabarUnPaciente(Paciente paciente) {
        abrirArchivoLog();
        escribirArchivoLog(paciente);
        cerrarArchivoLog();
    }
}
