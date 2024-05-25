package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Archivo {
    private BufferedReader reader;
    private BufferedWriter writer;
    private StringTokenizer tokenizer;

    // Constructor para leer desde un archivo de entrada
    public Archivo(String nombreArchivo) throws IOException {
        this.reader = new BufferedReader(new FileReader(nombreArchivo));
        this.tokenizer = new StringTokenizer(reader.readLine());
    }

    // Constructor para escribir en un archivo de salida
    public Archivo(String nombreArchivo, boolean escribir) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(nombreArchivo));
    }

    //Método para leer entero
    public int leerEntero() throws IOException {
        if (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return Integer.parseInt(tokenizer.nextToken());
    }

    //Método para leer arreglo de enteros
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

    //Método para setear los datos extraidos del archivo en aventureros
    public void leerDatos(Aventurero aventurero) throws IOException {
        int cantidadOias = leerEntero();
        aventurero.setCantidadOias(cantidadOias);
        aventurero.setPasadas(leerArreglo(cantidadOias - 1));
    }

    // Método para escribir un OIA en el archivo de salida
    public void escribirOia(int oia, boolean esCebador) throws IOException {
        if (writer == null) {
            throw new IOException("El archivo no está abierto para escritura.");
        }
        if (esCebador) {
            writer.newLine();
        }
        writer.write(oia + " ");
    }

    // Método para cerrar el archivo
    public void cerrar() throws IOException {
        if (reader != null)
            reader.close();
        if (writer != null)
            writer.close();
    }

}
