package myProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelGame {
    public List<String> leerTxt(String direccion) {
        List<String> palabras = new ArrayList<>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                palabras.add(bfRead); // Agregar cada línea leída a la lista de palabras
            }

            bf.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo");
            e.printStackTrace();
        }

        return palabras;
    }

    public void imprimirPalabrasAleatorias(List<String> palabras, int cantidad) {
        if (cantidad > palabras.size()) {
            System.err.println("No hay suficientes palabras en el archivo");
            return;
        }

        Random random = new Random();
        System.out.println("Palabras aleatorias:");
        for (int i = 0; i < cantidad; i++) {
            int index = random.nextInt(palabras.size());
            String palabra = palabras.get(index);
            System.out.println(palabra);
        }
    }

    public static void main(String[] args) {
        ModelGame modelGame = new ModelGame();
        List<String> palabras = modelGame.leerTxt("C:\\Users\\tylum\\Desktop\\palabras.txt");
        modelGame.imprimirPalabrasAleatorias(palabras, 10);
    }
}
