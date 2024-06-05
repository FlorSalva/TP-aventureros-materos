package Clases;

import Excepciones.AventureroExcepcion;

import java.io.*;
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
        try {
            if (TipoAperturaArchivo.LECTURA.equals(tipoAperturaArchivo)){
                this.reader = new BufferedReader(new FileReader(nombreArchivo));
                this.tokenizer = new StringTokenizer(reader.readLine());
            } else {
                this.writer = new BufferedWriter(new FileWriter(nombreArchivo));
            }
        } catch (Exception e) {
            throw new AventureroExcepcion("Error al arbrir el archivo. " + e.getMessage());
        }
    }

    /**
     * Método para leer el primer elemento del archivo (entero)
     * @return Entero que representa la cantidad de OIAs
     * @throws IOException
     */
    private int leerEntero() throws IOException {
        try {
            if(tokenizer != null) {
                if (!tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
            } else {
                throw new AventureroExcepcion("La cantidad de OIAs es requerida.") ;
            }

            Integer primerEntero = Integer.parseInt(tokenizer.nextToken());
            if (primerEntero < 1 || primerEntero > 400000) {
                throw new AventureroExcepcion("El primer entero del archivo está por fuera del rango permitido. (1 < n < 400.000).");
            }
            if (tokenizer.countTokens() > 1) {
                throw new AventureroExcepcion("La cantidad de OIAs debe ser unica.");
            }
            return primerEntero;
        } catch(Exception e) {
            throw new AventureroExcepcion(e.getMessage());
        }
    }

    /**
     * Método para leer arreglo de enteros
     * @param n Cantidad de elementos del arreglo
     * @return Arreglo leído
     * @throws IOException
     */
    private int[] leerArreglo(int n) throws IOException {
        int[] arreglo = new int[n];

        validarDatosDePasadas(n);

        for (int i = 0; i < n; i++) {
            int enteroLeido = Integer.parseInt(tokenizer.nextToken());
            if (enteroLeido < 0 || enteroLeido > 100000000){
                throw new AventureroExcepcion("Entero leido está por fuera del rango (0 < n < 100000000).");
            }
            arreglo[i] = enteroLeido;
        }
        return arreglo;
    }

    private void validarDatosDePasadas(int n) throws IOException {
        try {
            tokenizer = new StringTokenizer(reader.readLine());
        } catch (Exception e) {
            throw new AventureroExcepcion("La cantidad de pasadas es requerida, se interrumpe la ejecución.");
        }

        if(n != tokenizer.countTokens()) {
            throw new AventureroExcepcion("La cantidad de pasadas debe ser un elemento menos de la cantidad de OIAs, se interrumpe la ejecucion.");
        }
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
