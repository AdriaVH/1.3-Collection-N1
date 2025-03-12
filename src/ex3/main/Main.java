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
        Scanner sc = new Scanner(System.in);

        Scanner fileSc = new Scanner(file);
        while (fileSc.hasNext()) {
            String line = fileSc.nextLine();
            String[] splittedLine = line.split("\\s");
            countriesHashMap.put(splittedLine[0], splittedLine[1]);
        }
        System.out.println("Introduce your user name: ");
        String user = sc.next();
        List<String> keys = new ArrayList<>(countriesHashMap.keySet());
        List<Boolean> answers = new ArrayList<>();
        int points = 0;
       for (int i = 0; i < 3; i++){
           String randomCountry = keys.get(new Random().nextInt(keys.size()));
           System.out.println("What's the capital of "+randomCountry);
           String userCapital = sc.next();
           compareWithMap(randomCountry,userCapital,answers, countriesHashMap);
           points = getPoints(answers);

       }

        System.out.println(points);

    }
    public static void compareWithMap (String randomCountry,String userCapital, List<Boolean> answers,
                                       HashMap<String, String> countriesHashMap) {
    String value = countriesHashMap.get(randomCountry);
    Boolean answer = value.equalsIgnoreCase(userCapital);
        answers.add(answer);
    }
    public static int getPoints(List<Boolean> answers) {
        int points = 0;
        for (Boolean value : answers){
            if (value){
                points += points + 1;
            }
        }return (points);
    }
}
