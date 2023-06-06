
package myProject;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Modelado del luego

public class modelGame {
    private int nivel=0;
    private List<String> palabras;
    private List<String> palabrasAleatorias;
    private List<String> palabrasElegidas;
    private int aciertos=0;

        // lectura del txt de 1000 palabras
    public List<String> leerTxt(String direccion) {
        palabras = new ArrayList<>();

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

       //se obtienen palabras de manear aleatoria
    public List<String> obtenerPalabrasAleatorias(List<String> palabras, int cantidad, int limite) {
        palabrasAleatorias = new ArrayList<>();

        if (cantidad > palabras.size()) {
            System.err.println("No hay suficientes palabras en el archivo");
            return palabrasAleatorias;
        }

        Random random = new Random();
        int count = 0;
        while (palabrasAleatorias.size() < cantidad && count < limite) {
            int index = random.nextInt(palabras.size());
            String palabra = palabras.get(index);
            if (!palabrasAleatorias.contains(palabra)) {
                palabrasAleatorias.add(palabra);
            }
            count++;
        }
        return palabrasAleatorias;
    }

    //Getters para guardar las palabras que se eligen en una variable en la GUI
    public List<String> getPalabrasAleatorias() {
        return palabrasAleatorias;
    }

    public List<String> getPalabrasElegidas() {
        return palabrasElegidas;
    }

    public List<String> elegirPalabras(List<String> palabrasMostradas, int cantidad) {
        palabrasElegidas = new ArrayList<>();

        if (cantidad > palabrasMostradas.size()) {
            System.err.println("No hay suficientes palabras mostradas");
            return palabrasElegidas;
        }

        Random random = new Random();
        while (palabrasElegidas.size() < cantidad) {
            int index = random.nextInt(palabrasMostradas.size());
            String palabra = palabrasMostradas.get(index);

            if (!palabrasElegidas.contains(palabra)) {
                palabrasElegidas.add(palabra);
            }
        }
        return palabrasElegidas;
    }

        //se obtienen niveles
    public int setNivel(int nivel) {
        this.nivel = nivel;
        return nivel;
    }
    //se obtienen aciertos
    public int setAciertos(int aciertos) {
        this.aciertos = aciertos;
        return aciertos;
    }
        //metodo para escalar niveles
    public void niveles() {
        if (palabras == null) {
            System.err.println("La lista de palabras no ha sido inicializada. Llama al método leerTxt() primero.");
            return;
        }

        if (nivel == 0) {
            int cantidadPalabrasMostrar = 10;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
        if (nivel == 1 && aciertos==70) {
            int cantidadPalabrasMostrar = 40;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
            JOptionPane.showMessageDialog(null, "Pasaste de nivel");

        }
        if (nivel == 2 && aciertos<7) {
            int cantidadPalabrasMostrar = 50;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
        if (nivel == 3 && aciertos==8) {
            int cantidadPalabrasMostrar = 60;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
        if (nivel == 4 && aciertos==8) {
            int cantidadPalabrasMostrar = 70;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
        if (nivel == 5 && aciertos<8) {
            int cantidadPalabrasMostrar = 80;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
        if (nivel == 6 && aciertos==9) {
            int cantidadPalabrasMostrar = 100;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
        if (nivel == 7 && aciertos==9) {
            int cantidadPalabrasMostrar = 120;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
        if (nivel == 8 && aciertos<9) {
            int cantidadPalabrasMostrar = 140;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
        if (nivel == 9 && aciertos==10) {
            int cantidadPalabrasMostrar = 200;
            List<String> palabrasMostradas = obtenerPalabrasAleatorias(palabras, cantidadPalabrasMostrar, palabras.size());

            int cantidadPalabrasElegir = palabrasMostradas.size() / 2;
            List<String> palabrasElegidas = elegirPalabras(palabrasMostradas, cantidadPalabrasElegir);
            System.out.println("Palabras aleatorias:");
            System.out.println(palabrasMostradas);

            System.out.println("Palabras elegidas:");
            System.out.println(palabrasElegidas);
        }
    }

}

}

