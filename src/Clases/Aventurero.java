package Clases;
import Clases.Archivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Aventurero {
    private List<Integer> listaOias;
    private int[] pasadas;
    private int cantidadOias;

    public Aventurero() {
        listaOias = new LinkedList<>();
    }

    public void setCantidadOias(int cantidadOias) {
        this.cantidadOias = cantidadOias;
    }

    public void setPasadas(int[] pasadas) {
        this.pasadas = pasadas;
    }

    public int[] getPasadas() {
        return this.pasadas;
    }

    public int getCantidadOias() {
        return this.cantidadOias;
    }

    public void crearRondaOias(){
        for (int i = 1; i <= cantidadOias; i++) {
            listaOias.add(i);
        }
    }

    public void identificadorCebador(Archivo arch) throws IOException{
            int position = 0;
            int removed;
            for (int i = 0; i < cantidadOias - 1; i++) {
                position = (position + pasadas[i]) % listaOias.size();
                removed = listaOias.remove(position);
                arch.escribirOia(removed, false);
            }
            removed = listaOias.remove(0);
            arch.escribirOia(removed, true);
    }
}
