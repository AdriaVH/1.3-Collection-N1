package ex1.main;

import ex1.classes.Month;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
      /* Crea una classe anomenada Month amb un atribut "name" (que emmagatzemarà el nom del mes de l'any).
      Afegeix 11 objectes Month (cadascun amb el seu atribut diferent) en un ArrayList, a excepció de l'objecte
      amb atribut "Agost". Després, efectua la inserció en el lloc que correspon a aquest mes i demostra que
      l’ArrayList manté l'ordre correcte.
   Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats
   Recorre la llista amb un for i amb un iterador.*/

        ArrayList<Month> months = new ArrayList<>();
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June", "July", "September", "October", "November", "December"
        };
        for (int i = 0; i < 11; i++) {
            months.add(new Month(monthNames[i]));
        }
        System.out.println("Before insertion: ");

        for (Month month : months) {
            System.out.print(month.getName() + " ");
        }
        months.add(7, new Month("August"));

        System.out.println("\n\nAfter \"August\" insertion: ");
        for (Month month : months) {
            System.out.print(month.getName() + " ");
        }

        months.add(new Month("January"));
        HashSet<Month> hashSetMonths = new HashSet<>(months);

        System.out.println("\n\nHashSet Months after a duplicate \"January\" by attribute: ");
        for (Month month : hashSetMonths) {
            System.out.print(month.getName() + " ");
        }
        Iterator<Month> it = months.iterator();
        Iterator<Month> itHash = hashSetMonths.iterator();

        System.out.println("\n\nIteration ArrayList: ");
        while (it.hasNext()){
            System.out.print(it.next().getName()+" ");
        }

        System.out.println("\n\nIteration HashSet: ");
        while (itHash.hasNext()){
            System.out.print(itHash.next().getName()+" ");
        }
        //Recorrer amb un FOR ja l'he recorregut abans, per això no le posat

    }

}