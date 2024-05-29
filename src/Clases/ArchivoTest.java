package Clases;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ArchivoTest {
    private static final String TEST_DIR = "./resources/test/";
    private static final String INPUT_FILE = TEST_DIR + "aventureros_test.in";
    private static final String OUTPUT_FILE = TEST_DIR + "aventureros_test.out";

    @Test
    public void testLeerEntero() throws Exception {
       // Hago publico el metodo privado a testear
        Method metodo = Archivo.class.getDeclaredMethod("leerEntero");
        metodo.setAccessible(true);

        Archivo archivo = new Archivo(INPUT_FILE, TipoAperturaArchivo.LECTURA);
        int result = (int) metodo.invoke(archivo);
        assertEquals(5, result);
    }

    @Test
    public void testLeerArreglo() throws Exception {
        Archivo archivo = new Archivo(INPUT_FILE, TipoAperturaArchivo.LECTURA);
        Method leerEnteroMetodo = Archivo.class.getDeclaredMethod("leerEntero");
        leerEnteroMetodo.setAccessible(true);
        int cantidadOias = (int) leerEnteroMetodo.invoke(archivo);

        Method leerArregloMetodo = Archivo.class.getDeclaredMethod("leerArreglo", int.class);
        leerArregloMetodo.setAccessible(true);

        int[] result = (int[]) leerArregloMetodo.invoke(archivo, cantidadOias - 1);
        int[] esperado = {1, 2, 3, 4};
        assertArrayEquals(esperado, result);
    }

    @Test
    public void testLeerDatos() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE, TipoAperturaArchivo.LECTURA);
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
        Archivo archivo = new Archivo(OUTPUT_FILE, TipoAperturaArchivo.ESCRITURA);
        archivo.escribirOia(10, false);
        archivo.cerrar();

        // Verifico el contenido del archivo
        BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE));
        assertEquals("10 ", reader.readLine());
        reader.close();
    }

    @Test(expected = IOException.class)
    public void testEscribirSinAbrir() throws IOException {
        Archivo archivo = new Archivo("error.txt", TipoAperturaArchivo.LECTURA);
        archivo.escribirOia(10, false); // Esto debería lanzar IOException
        archivo.cerrar();
    }
}