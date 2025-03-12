package ex1.main;

import ex1.classes.Month;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<>();
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June", "July",
                "September", "October", "November", "December"
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