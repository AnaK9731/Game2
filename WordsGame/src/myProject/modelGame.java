package myProject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class modelGame {
    public List<String> leerTxt(String direccion) {
        List<String> palabras = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(direccion))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] palabrasLinea = linea.split("\\s+"); // Divide la línea en palabras
                for (String palabra : palabrasLinea) {
                    palabras.add(palabra);
                    System.out.println(palabra);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo");
            e.printStackTrace();
        }

        return palabras;
    }

    public static void main(String[] args) {
        modelGame modelGame = new modelGame();
        List<String> palabras = modelGame.leerTxt("C:\\Users\\jose1\\OneDrive\\Escritorio\\Game2\\WordsGame\\src\\recursos\\palabras.txt");
    }
}
