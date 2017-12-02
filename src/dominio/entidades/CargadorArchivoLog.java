package dominio.entidades;

public class CargadorArchivoLog {
    public static final String PREFIJO_CLASE = "transversal.operaciones.";

    public static RegistroLog crearArchivoLogImpl(String nombreLog) throws Exception {
        String nombreClase = PREFIJO_CLASE + nombreLog;
        Class<RegistroLog> registroLogClass = getClase(nombreClase);
        return registroLogClass.newInstance();
    }

    private static <T> Class<T> getClase(String nombreClase) throws ClassNotFoundException {
        return (Class<T>) Class.forName(nombreClase);
    }
}
