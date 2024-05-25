import Clases.Archivo;
import Clases.Aventurero;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
/*
    public static List<Integer> crearRondaOias(int oias) {
        List<Integer> rondaOias = new LinkedList<>();
        for (int i = 1; i <= oias; i++) {
            rondaOias.add(i);
        }
        return rondaOias;
    }

    public static int identificadorCebador(String output,int oias,int[] pass,List<Integer> rondaOias)
    {
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new FileWriter(output));
            int position = 0;
            for (int i = 0; i < oias - 1; i++) {
                position = (position + pass[i]) % rondaOias.size();
                int removed = rondaOias.remove(position);
                //escribirOia(pw,removed)
                pw.print(removed);	//escribirOia
                pw.print(" ");		//escribirOia
            }
            int removed = rondaOias.remove(0);
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
*/

    public static void main(String[] args) throws IOException {
        Archivo arch = new Archivo("aventureros.in");
        Aventurero aventurero = new Aventurero();
        arch.leerDatos(aventurero);
        arch.cerrar();

        // Lista para mantener el orden de eliminación
        List<Integer> eliminated = new LinkedList<>();

        /*
        // Proceso de eliminación
        int position = 0;
        for (int i = 0; i < N - 1; i++) { //Esto es N
            position = (position + a[i]) % members.size();
            int removed = members.remove(position); // Es N
            eliminated.add(removed);
        }

        // Escribo los resultados en el archivo aventureros.out
        PrintWriter pw = new PrintWriter(new FileWriter("aventureros.out"));
        for (int i = 0; i < eliminated.size(); i++) {
            if (i > 0) pw.print(" ");
            pw.print(eliminated.get(i));
        }

        pw.println();
        pw.println(members.get(0));
        pw.close();

        // Leer el array 'a'
        int[] a = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            if (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }
        reader.close();

        
        List<Integer> rondaOias = crearRondaOias(N);
        Integer cebador = identificadorCebador("aventureros.out", N, a, rondaOias);
        */
    }


}
