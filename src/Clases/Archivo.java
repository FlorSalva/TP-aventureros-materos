package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Archivo {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public Archivo(String nombreArchivo) throws IOException {
        this.reader = new BufferedReader(new FileReader(nombreArchivo));
        this.tokenizer = new StringTokenizer(reader.readLine());
    }

    //TO-DO: Abrir archivo de escritura (o agregar otro constructor)
    //To-DO2: Escribir en archivo

    public int leerEntero() throws IOException {
        if (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return Integer.parseInt(tokenizer.nextToken());
    }

    public int[] leerArreglo(int n) throws IOException {
        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            if (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            arreglo[i] = Integer.parseInt(tokenizer.nextToken());
        }
        return arreglo;
    }

    public void leerDatos(Aventurero aventurero) throws IOException {
        int cantidadOias = leerEntero();
        aventurero.setCantidadOias(cantidadOias);
        aventurero.setPasadas(leerArreglo(cantidadOias - 1));
    }

    public void cerrar() throws IOException {
        reader.close();
    }
}
