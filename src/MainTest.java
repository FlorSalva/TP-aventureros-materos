import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class MainTest {
    private static final String TEST_DIR = "./resources/";
    private static final String INPUT_FILE = TEST_DIR + "aventureros.in";
    private static final String OUTPUT_FILE = TEST_DIR + "aventureros.out";

    @Before
    public void setUp() throws IOException {
        // Creo el archivo de entrada de pruebas, para no fallar el test en caso de cambios de inputs
        BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE));
        writer.write("5\n1 2 3 4\n"); // ejemplo de datos de entrada
        writer.close();
    }

    @Test
    public void testMain() throws IOException {
        // Ejecuto el método main
        Main.main(new String[]{});

        // Verifico los resultados de salida
        BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE));
        String outputLine = reader.readLine();
        assertEquals("2 5 1 3 ", outputLine);
        outputLine = reader.readLine();
        assertEquals("4 ", outputLine);
        reader.close();
    }
}

