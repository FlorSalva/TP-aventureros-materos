import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

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

        
        List<Integer> rondaOias = crearRondaOias(N);
        Integer cebador = identificadorCebador("aventureros.out", N, a, rondaOias);
    }

}
