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

    /**
     * Constructor de archivo especificando tipo de apertura
     * @param nombreArchivo El nombre del archivo a abrir
     * @param tipoAperturaArchivo Tipo de apertura a realizar (LECTURA, ESCRITURA)
     * @throws IOException
     */
    public Archivo(String nombreArchivo, TipoAperturaArchivo tipoAperturaArchivo) throws IOException {
        if (TipoAperturaArchivo.LECTURA.equals(tipoAperturaArchivo)){
            this.reader = new BufferedReader(new FileReader(nombreArchivo));
            this.tokenizer = new StringTokenizer(reader.readLine());
        } else {
            this.writer = new BufferedWriter(new FileWriter(nombreArchivo));
        }

    }

    /**
     * Método para leer el primer elemento del archivo (entero)
     * @return Entero que representa la cantidad de OIAs
     * @throws IOException
     */
    private int leerEntero() throws IOException {
        if (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        Integer primerEntero = Integer.parseInt(tokenizer.nextToken());
        if (primerEntero < 1 || primerEntero > 400000){
            throw new RuntimeException("El primer entero del archivo está por fuera del rango permitido. (1 < n < 400.000).");
        }
        return primerEntero;
    }

    /**
     * Método para leer arreglo de enteros
     * @param n Cantidad de elementos del arreglo
     * @return Arreglo leído
     * @throws IOException
     */
    private int[] leerArreglo(int n) throws IOException {
        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            if (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            int enteroleido = Integer.parseInt(tokenizer.nextToken());
            if (enteroleido < 0 || enteroleido > 100000000){
                throw new RuntimeException("Entero leido está por fuera del rango (0 < n < 100000000).");
            }
            arreglo[i] = enteroleido;
        }
        return arreglo;
    }

    /**
     * Método para setear los datos extraidos del archivo en aventureros
     * @param aventurero Objeto Aventurero en el que se setearán los datos de la siguiente lectura
     * @throws IOException
     */
    public void leerDatos(Aventurero aventurero) throws IOException {
        int cantidadOias = leerEntero();
        aventurero.setCantidadOias(cantidadOias);
        aventurero.setPasadas(leerArreglo(cantidadOias - 1));
    }

    /**
     * Método para escribir un OIA en el archivo de salida
     * @param oia
     * @param esCebador
     * @throws IOException
     */
    public void escribirOia(int oia, boolean esCebador) throws IOException {
        if (writer == null) {
            throw new IOException("El archivo no está abierto para escritura.");
        }
        if (esCebador) {
            writer.newLine();
        }
        writer.write(oia + " ");
    }

    /**
     * Método para cerrar el archivo
     * @throws IOException
     */
    public void cerrar() throws IOException {
        if (reader != null)
            reader.close();
        if (writer != null)
            writer.close();
    }

    /**
     * Método para validar si el archivo de entrada existe y es legible
     * @param nombreArchivo
     * @return
     */
    public static boolean validarArchivoLectura(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            return reader.readLine() != null;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Método para validar si el archivo de salida puede ser creado y escrito
     * @param nombreArchivo
     * @return
     */
    public static boolean validarArchivoEscritura(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("");
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
