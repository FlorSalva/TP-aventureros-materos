import Clases.Archivo;
import Clases.Aventurero;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Archivo arch = new Archivo("./resources/aventureros.in");
        Aventurero aventurero = new Aventurero();
        arch.leerDatos(aventurero);
        aventurero.crearRondaOias();

        Archivo arch_out = new Archivo("./resources/aventureros.out", true);

        aventurero.identificadorCebador(arch_out);
        arch_out.cerrar();
    }
}
