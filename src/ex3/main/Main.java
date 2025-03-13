package ex3.main;

import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String filePath = "src/rsc/countries.txt";
        File file = new File(filePath);
        HashMap<String, String> countriesHashMap = new HashMap<>();
        int numberOfQuestions = 10; // change to 3 for testing

        fileToHashMap(file, countriesHashMap);
        System.out.println("Introduce your user name: ");
        String user = sc.nextLine();
        int points = guessTheCapitals(countriesHashMap, numberOfQuestions);
        saveToFile(user, points, numberOfQuestions);
    }
    public static void fileToHashMap(File file, HashMap<String, String> countriesHashMap) {
        try {
            Scanner fileSc = new Scanner(file);
            while (fileSc.hasNext()) {
                String line = fileSc.nextLine();
                String[] splittedLine = line.split("\\s");
                splittedLine[0] = splittedLine[0].replace("_", " ");
                splittedLine[1] = splittedLine[1].replace("_", " ");

                countriesHashMap.put(splittedLine[0], splittedLine[1]);
            }
            fileSc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath()
                    + "\nCheck that the path is correct and the file exists");
            System.exit(1);
        }
    }
    public static int guessTheCapitals(HashMap<String, String> countriesHashMap, int times) {
        int result = 0;
        String randomCountry;
        String userCapital;
        List<String> keys = new ArrayList<>(countriesHashMap.keySet());
        Collections.shuffle(keys);

        for (int i = 0; i < times; i++) {
            randomCountry = keys.get(i);
            System.out.println("What's the capital of " + randomCountry + "?");
            userCapital = sc.nextLine();
            if(compareWithMap(randomCountry, userCapital, countriesHashMap)){
                result++;
            }
        }
        return result;
    }
    public static boolean compareWithMap(String randomCountry, String userCapital,
                                      HashMap<String, String> countriesHashMap) {
        String value = countriesHashMap.get(randomCountry);
        return value.equalsIgnoreCase(userCapital);
    }
    public static void saveToFile(String user, int points, int times) {
        String fileName = "classificacio.txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(user + " -> " + points + "/" + times + " points\n");
            writer.close();
            System.out.println("Score successfully saved to \"" + fileName + "\"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}