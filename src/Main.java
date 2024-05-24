import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Abro el archivo de entrada
        BufferedReader reader = new BufferedReader(new FileReader("aventureros.in"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        // Leer el número N
        int N = Integer.parseInt(tokenizer.nextToken());

        // Leer el array 'a'
        int[] a = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            if (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }
        reader.close();

        // Crear la lista de miembros
        List<Integer> members = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            members.add(i);
        }

        // Lista para mantener el orden de eliminación
        List<Integer> eliminated = new LinkedList<>();

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
    }
}
