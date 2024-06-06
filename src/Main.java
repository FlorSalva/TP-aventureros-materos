import Classes.Archivo;
import Classes.Aventurero;
import Classes.TipoAperturaArchivo;
import java.io.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(Main.class.getName());

        if (Archivo.validarArchivoLectura("./resources/aventurerosGIGACHAD.in")){
            logger.fine("Archivo de Lectura abierto satisfactoriamente.");
        }

        Archivo arch = new Archivo("./resources/aventurerosGIGACHAD.in", TipoAperturaArchivo.LECTURA);
        Aventurero aventurero = new Aventurero();
        arch.leerDatos(aventurero);
        aventurero.crearRondaOias();

        if (Archivo.validarArchivoEscritura("./resources/aventurerosGIGACHAD.out")){
            logger.fine("Archivo de Escritura abierto satisfactoriamente.");
        }

        Archivo arch_out = new Archivo("./resources/aventureros.out", TipoAperturaArchivo.ESCRITURA);

        aventurero.identificarCebador(arch_out);
        arch_out.cerrar();
    }
}
