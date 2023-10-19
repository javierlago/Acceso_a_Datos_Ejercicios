import java.io.*;
import java.util.ArrayList;

public class Leercsv {
    public static void main(String[] args) throws IOException {
        File archivo = new File("src\\alumnos.csv");
        // System.out.println(csvToString(archivo));
        String[] elementos = (csvToString(archivo)).split(",");
        for (int i = 0; i < elementos.length; i++) {
            for (int z = 0; z < 6; z++)
                if (z == 0) {
                    String nombre = elementos[z];
                } else if (z == 1) {
                    String apellido = elementos[z];
                }


        }

    }

    public static String csvToString(File archivo) throws FileNotFoundException, IOException {
        String datosAlumnos = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                datosAlumnos += linea + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datosAlumnos;
    }
}
