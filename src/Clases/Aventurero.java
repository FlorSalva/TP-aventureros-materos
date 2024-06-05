package Clases;
import java.io.IOException;
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

    //Para testing
    public List<Integer> getListaOias() {
        return listaOias;
    }

    public void identificadorCebador(Archivo arch) throws IOException{
            int position = 0,
                removed;
            for (int i = 0; i < cantidadOias - 1; i++) {
                position = (position + pasadas[i]) % listaOias.size();
                removed = listaOias.remove(position);
                arch.escribirOia(removed, false);
            }
            removed = listaOias.remove(0);
            arch.escribirOia(removed, true);
    }
}
