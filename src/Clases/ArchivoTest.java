package Clases;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;

public class ArchivoTest {
    private static final String TEST_DIR = "./resources/test/";
    private static final String INPUT_FILE = TEST_DIR + "aventureros_test.in";
    private static final String OUTPUT_FILE = TEST_DIR + "aventureros_test.out";

    @Test
    public void testLeerEntero() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE);
        Aventurero aventurero = new Aventurero();
        assertEquals(5, archivo.leerEntero());
        archivo.cerrar();
    }

    @Test
    public void testLeerArreglo() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE);
        int[] esperado = {1, 2, 3, 4};
        int cantidadOias = archivo.leerEntero(); // Lee el primer entero para posicionar el cursor en la segunda línea
        assertArrayEquals(esperado, archivo.leerArreglo(cantidadOias - 1));
        archivo.cerrar();
    }

    @Test
    public void testLeerDatos() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE);
        Aventurero aventurero = new Aventurero();
        archivo.leerDatos(aventurero);
        archivo.cerrar();

        int[] pasadasEsperadas = {1, 2, 3, 4};
        int oiasEsperados = 5;

        // Verifico el contenido del archivo aventurero
        assertEquals(oiasEsperados, aventurero.getCantidadOias());
        assertArrayEquals(pasadasEsperadas, aventurero.getPasadas());
    }

    @Test
    public void testEscribirOia() throws IOException {
        Archivo archivo = new Archivo(OUTPUT_FILE, true);
        archivo.escribirOia(10, false);
        archivo.cerrar();

        // Verifico el contenido del archivo
        BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE));
        assertEquals("10 ", reader.readLine());
        reader.close();
    }

    @Test(expected = IOException.class)
    public void testEscribirSinAbrir() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE);
        archivo.escribirOia(10, false); // Esto debería lanzar IOException
        archivo.cerrar();
    }
}