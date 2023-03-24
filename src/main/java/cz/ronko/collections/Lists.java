package cz.ronko.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        //fixed size - cannot change it after creation (in this case 4)
        String[] friendsArray = new String[4];
        String[] friendArray2 = {"John", "Chris", "Eric", "Luke"};

        // ArrayList doesn't have a fixed size
        List<String> friendsArrayList = new ArrayList<>();

        // this is mutable list
        List<String> friendsArrayList2 = new ArrayList<>(Arrays.asList("John", "Chris", "Eric", "Luke"));

        // if I use only Arrays.asList("example"); it creates immutable list (no add, remove or change)
        List arrayAsList = Arrays.asList("example1", "example2");

        //removing from List either by Object or index
        friendsArrayList2.remove("John");
        friendsArrayList2.remove(0);

        /*
        it's actually doubly linked list so each node has a reference
        to next and also previous node and the tail (last element)

        in 1000 elements list is more complicated to access 400th element
        of the LinkedList because you need to go through all nodes till the 400th

        adding the element or removing existing one is on the other hand much faster on linked list
        just add new node and "rewire" next, prev pointers on this new node and that's it
        */
        List<String> namesLinkedList = new LinkedList<>();
        namesLinkedList.add("John");
        namesLinkedList.add("Paul");
        namesLinkedList.add("George");
        namesLinkedList.add("Ringo");
        System.out.println(namesLinkedList.get(2));
        namesLinkedList.add(1, "Jerry");

        /*
        actually uses an Array as underlying structure
        it resizes dynamically - if there is lack of space
        new array is created and elements are copied from the
        original array but it takes quite a bit of time and resources

        it also has fast random access using the index (constant time for all elements)

        but it's much slower when adding new element and removing element because it has to create
        new array bigger than the original one and copy all elements into it with the newly
        added element
        */
        List<String> namesArrayList = new ArrayList<>();
        namesArrayList.add("John");
        namesArrayList.add("Paul");
        namesArrayList.add("George");
        namesArrayList.add("Ringo");
        System.out.println(namesArrayList.get(2));
        namesArrayList.add(1, "Jerry");


    }
}
