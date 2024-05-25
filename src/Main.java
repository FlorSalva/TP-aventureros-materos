import Clases.Archivo;
import Clases.Aventurero;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Archivo arch = new Archivo("./resources/aventureros.in");
        Aventurero aventurero = new Aventurero();
        arch.leerDatos(aventurero);
        arch.cerrar();

        // Lista para mantener el orden de eliminación
        List<Integer> eliminated = new LinkedList<>();

        aventurero.crearRondaOias();

        Archivo arch_out = new Archivo("./resources/aventureros.out",true);

        aventurero.identificadorCebador(arch_out);

        arch_out.cerrar();

        /*
        // Escribo los resultados en el archivo aventureros.out
        PrintWriter pw = new PrintWriter(new FileWriter("aventureros.out"));
        for (int i = 0; i < eliminated.size(); i++) {
            if (i > 0) pw.print(" ");
            pw.print(eliminated.get(i));
        }
        */
    }
}
