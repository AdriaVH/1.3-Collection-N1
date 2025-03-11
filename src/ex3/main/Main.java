package ex3.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       /* Donat el fitxer countrties.txt (revisa l'apartat recursos) que conté països i capitals.
       El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>. El programa
       demana el nom de l’usuari/ària, i després ha de mostrar un país de forma aleatòria, guardat en el
       HashMap. Es tracta que l’usuari/ària ha d’escriure el nom de la capital del país en qüestió. Si
       l’encerta se li suma un punt. Aquesta acció es repeteix 10 vegades. Un cop demanades les capitals
       de 10 països de forma aleatòria, llavors s’ha de guardar en un fitxer anomenat classificacio.txt,
       el nom de l’usuari/ària i la seva puntuació. */

        String filePath = "C:\\Users\\formacio\\Desktop\\1.3-Java-Collection-N1\\rsc\\countries.txt";

        File file = new File(filePath);
        HashMap<String, String> countriesHashMap = new HashMap<>();

        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine().toLowerCase();
            String[] splittedLine = line.split("\\s");
            System.out.println(splittedLine[0]);
        }



    }
}
