package Clases;

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

    public void crearRondaOias() {
        for (int i = 1; i <= cantidadOias; i++) {
            listaOias.add(i);
        }
    }

    public int identificadorCebador(String output)
    {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(output));
            int position = 0;
            for (int i = 0; i < cantidadOias - 1; i++) {
                position = (position + pasadas[i]) % listaOias.size();
                int removed = listaOias.remove(position);
                //escribirOia(pw,removed)
                pw.print(removed);	//escribirOia
                pw.print(" ");		//escribirOia
            }
            int removed = listaOias.remove(0);
            //escribirCebador(pw,removed)
            pw.println();			//escribirCebador
            pw.println(removed);	//escribirCebador

            return removed;
        }catch(IOException e) {
            e.printStackTrace();
            return -1;
        }finally {
            if(pw != null){
                pw.close();
            }
        }
    }
}
