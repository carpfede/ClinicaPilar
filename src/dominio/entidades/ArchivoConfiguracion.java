package dominio.entidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArchivoConfiguracion {
    private static final String nombreArchivo = "C:\\Users\\millo\\Dropbox\\FEDE\\Diseno de Sistemas 2017\\Trabajo Final Integrador - Diseno\\"
            + "Proyecto Clinica del Pilar\\Clinica del Pilar\\Archivos\\ArchivoConfiguracion.txt";

    public static String claseImplArchivoLog() {
        String nombre = null;
        try {
            Properties prop = new Properties();
            InputStream inputStream = new FileInputStream(nombreArchivo);
            prop.load(inputStream);
            nombre = prop.getProperty("nomClaseRegistroLog");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    public static String rutaArchivoLog() {
        String rutaArchivoLog = null;
        try {
            Properties prop = new Properties();
            InputStream inputStream = new FileInputStream(nombreArchivo);
            prop.load(inputStream);
            rutaArchivoLog = prop.getProperty("rutaArchivoLog");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rutaArchivoLog;
    }

    public static int duracionDelTurno(){
        int duracion = 0;
        try{
            Properties prop = new Properties();
            InputStream inputStream = new FileInputStream(nombreArchivo);
            prop.load(inputStream);
            duracion = Integer.parseInt(prop.getProperty("duracionDelTurno"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return duracion;
    }
}
