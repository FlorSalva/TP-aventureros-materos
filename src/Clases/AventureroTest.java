package Clases;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class AventureroTest {
    private static final String TEST_DIR = "./resources/test/";
    private static final String OUTPUT_FILE = TEST_DIR + "aventureros_test.out";

    @Test
    public void testSetAndGetCantidadOias() {
        Aventurero aventurero = new Aventurero();
        aventurero.setCantidadOias(5);
        assertEquals(5, aventurero.getCantidadOias());
    }

    @Test
    public void testSetAndGetPasadas() {
        Aventurero aventurero = new Aventurero();
        int[] pasadas = {1, 2, 3};
        aventurero.setPasadas(pasadas);
        assertArrayEquals(pasadas, aventurero.getPasadas());
    }

    @Test
    public void testCrearRondaOias() {
        Aventurero aventurero = new Aventurero();
        aventurero.setCantidadOias(3);
        aventurero.crearRondaOias();
        assertEquals(Arrays.asList(1, 2, 3), aventurero.getListaOias());
    }

    @Test
    public void testIdentificadorCebador() throws IOException {
        Aventurero aventurero = new Aventurero();
        aventurero.setCantidadOias(5);
        aventurero.setPasadas(new int[]{1, 2, 3, 4});
        aventurero.crearRondaOias();

        Archivo archivo = new Archivo(OUTPUT_FILE, TipoAperturaArchivo.ESCRITURA);
        aventurero.identificadorCebador(archivo);
        archivo.cerrar();

        // Verifico el contenido del archivo de salida
        BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE));

        String outputLine = reader.readLine();
        assertEquals("2 5 1 3 ", outputLine);
        outputLine = reader.readLine();

        assertEquals("4 ", outputLine);
        reader.close();
    }
}