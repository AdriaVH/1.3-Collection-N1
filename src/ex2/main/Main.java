package ex2.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*Crea i emplena un List<Integer>.
        Crea un segon List<Integer> i insereix a la segona llista els elements de la primera en ordre invers.
       Empra els objectes ListIterator per a llegir els elements de la primera llista i inserir-los en la segona.*/

        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < 4 ; i++) {
            intList.add(i);
        }
        List<Integer> intList2 = new ArrayList<>();

        ListIterator<Integer> listIt = intList.listIterator(intList.size());

        while (listIt.hasPrevious()){
            intList2.add(listIt.previous());
        }
        System.out.println("1st List: ");
        for ( Integer i : intList) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n2nd List: ");
        for ( Integer i : intList2) {
            System.out.print(i + " ");
        }
    }
}
