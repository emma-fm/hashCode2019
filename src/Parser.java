import java.io.*;

public class Parser {
    public static String[] parseFile(String s){
        BufferedReader br = null;
        int size = 0;
        String[] res = null;

        try {
            br = new BufferedReader(new FileReader(s));

            String texto = br.readLine();
            size = Integer.parseInt(texto);
            res = new String[size];
            int cont = 0;
            while (cont < size){
                texto = br.readLine();
                res[cont] = texto;
                cont++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }

        return res;
    }
}
