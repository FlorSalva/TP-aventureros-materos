package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Archivo {
    // Abro el archivo de entrada
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public Archivo(String nombreArchivo) throws IOException {
        this.reader = new BufferedReader(new FileReader(nombreArchivo));
        this.tokenizer = new StringTokenizer(reader.readLine());
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public StringTokenizer getTokenizer() {
        return tokenizer;
    }

    public void setTokenizer(StringTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }
}
