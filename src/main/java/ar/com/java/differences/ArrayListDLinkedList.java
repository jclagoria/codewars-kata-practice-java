package ar.com.java.differences;

import java.util.*;
import java.util.random.RandomGenerator;

public class ArrayListDLinkedList {

    public static void main(String[] args) {

        //getWorkWhitArrayList();
        getWorkWhitLinkedList();

    }

    private static void getWorkWhitArrayList(){

        List listOfElements = new ArrayList<>(Arrays.asList(UUID.randomUUID(), UUID.randomUUID(),
                UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()));

        /*

         */

        System.out.println(listOfElements);

        System.out.println("Add new Element");
        listOfElements.add(UUID.randomUUID());
        System.out.println(listOfElements);

        System.out.println("Sorted elements");
        Collections.sort(listOfElements, Collections.reverseOrder());
        System.out.println(listOfElements);

        System.out.println("ArrayList Iteratos");
        Iterator iteratorArrayList = listOfElements.iterator();

        while(iteratorArrayList.hasNext()) {
            System.out.print(iteratorArrayList.next() + " ");
        }
    }

    private static void getWorkWhitLinkedList(){
        List<Integer> elementList = new LinkedList();
        elementList.add(RandomGenerator.getDefault().nextInt());

        System.out.println("Print the hashCode");
        System.out.println("Print hashCode for de Firs List -> " + elementList.hashCode());

        System.out.println("Add new element");
        elementList.add(RandomGenerator.getDefault().nextInt());
        elementList.forEach( e -> System.out.println(e));

        System.out.println("Work with second List");
        List<Integer> secondList = elementList;
        System.out.println("Print the hashCode of the SecondList -> " + secondList.hashCode());

        System.out.println("Working with the second list");
        secondList.add(RandomGenerator.getDefault().nextInt());
        System.out.println("Pring of the elements the second List");
        secondList.forEach(e -> System.out.print(e.intValue()+ " ") );



        List thridElement = new LinkedList(Arrays.asList(UUID.randomUUID(), UUID.randomUUID()));

        System.out.println(thridElement.hashCode());

        ListIterator listIteratorElements = thridElement.listIterator();

        int index = listIteratorElements.previousIndex();

        System.out.println(index);



        Map map = new TreeMap();
        Map otroMap = new HashMap();

    }


}
