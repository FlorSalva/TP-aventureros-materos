package Tests;

import static org.junit.Assert.*;

import Classes.Archivo;
import Classes.Aventurero;
import Classes.TipoAperturaArchivo;
import Exceptions.AventureroExcepcion;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;

public class ArchivoTest {
    private static final String TEST_DIR = "./resources/test/";
    private static final String INPUT_FILE_1 = TEST_DIR + "aventureros_test_1.in";
    private static final String INPUT_FILE_2 = TEST_DIR + "aventureros_test_2.in";
    private static final String INPUT_FILE_3 = TEST_DIR + "aventureros_test_3.in";
    private static final String INPUT_FILE_4 = TEST_DIR + "aventureros_test_4.in";
    private static final String INPUT_FILE_5 = TEST_DIR + "aventureros_test_5.in";
    private static final String OUTPUT_FILE_1 = TEST_DIR + "aventureros_test_1.out";

    @Test
    public void testLeerEntero() throws Exception {
       // Hago publico el metodo privado a testear
        Method metodo = Archivo.class.getDeclaredMethod("leerEntero");
        metodo.setAccessible(true);

        Archivo archivo = new Archivo(INPUT_FILE_1, TipoAperturaArchivo.LECTURA);
        int result = (int) metodo.invoke(archivo);
        assertEquals(5, result);
    }

    @Test
    public void testLeerArreglo() throws Exception {
        Archivo archivo = new Archivo(INPUT_FILE_1, TipoAperturaArchivo.LECTURA);
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
        Archivo archivo = new Archivo(INPUT_FILE_1, TipoAperturaArchivo.LECTURA);
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
        Archivo archivo = new Archivo(OUTPUT_FILE_1, TipoAperturaArchivo.ESCRITURA);
        archivo.escribirOia(10, false);
        archivo.cerrar();

        // Verifico el contenido del archivo
        BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE_1));
        assertEquals("10 ", reader.readLine());
        reader.close();
    }

    @Test(expected = IOException.class)
    public void testEscribirSinAbrir() throws IOException {
        Archivo archivo = new Archivo("error.txt", TipoAperturaArchivo.LECTURA);
        archivo.escribirOia(10, false); // Esto debería lanzar IOException
        archivo.cerrar();
    }

    @Test(expected = AventureroExcepcion.class)
    public void testValidarDatosException() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE_2, TipoAperturaArchivo.LECTURA);
        Aventurero aventurero = new Aventurero();
        archivo.leerDatos(aventurero);
        archivo.cerrar();
    }

    @Test(expected = AventureroExcepcion.class)
    public void testValidarDatosPasadaCantOiasIncorrectaException() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE_3, TipoAperturaArchivo.LECTURA);
        Aventurero aventurero = new Aventurero();
        archivo.leerDatos(aventurero);
        archivo.cerrar();
    }

    @Test(expected = AventureroExcepcion.class)
    public void testLeerDatosSinCantOiasException() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE_4, TipoAperturaArchivo.LECTURA);
        Aventurero aventurero = new Aventurero();
        archivo.leerDatos(aventurero);
        archivo.cerrar();
    }

    @Test(expected = AventureroExcepcion.class)
    public void testLeerDatosPrimerEnteroGiganteException() throws IOException {
        Archivo archivo = new Archivo(INPUT_FILE_5, TipoAperturaArchivo.LECTURA);
        Aventurero aventurero = new Aventurero();
        archivo.leerDatos(aventurero);
        archivo.cerrar();
    }
}