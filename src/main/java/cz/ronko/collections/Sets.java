package cz.ronko.collections;

import java.util.*;

public class Sets {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();

        names.add("Walter");
        names.add("Jesse");
        names.add("Skyler");
        names.add("Mike");
        names.add("Saul");

        System.out.println(names);

        //add already present element (obviously there are no duplicities)
        names.add("Walter");
        names.remove("Walter");

        //print after add and remove method calls
        System.out.println(names);

        System.out.println(names.size());
        System.out.println(names.contains("Walter"));
        System.out.println(names.contains("Jesse"));
        System.out.println(names.isEmpty());

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println();

        names.forEach(System.out::println);

        System.out.println();

        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }

        System.out.println("Removing duplicates...");

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);
        numberList.add(1);
        numberList.add(3);
        numberList.add(2);
        System.out.println(numberList);

        Set<Integer> numberSet = new HashSet<>(numberList);
        System.out.println(numberSet);

        /*
        * Set has constant time for all operations (add, remove, lookups)
        * On the other hand List's operations are more expensive with it's growing size
        * */

        // TreeSet - elements are ordered (natural ordering - it means e.g. alphabetically)
        // HashSet is way faster than TreeSet !!
        Set<String> numberTreeSet = new TreeSet<>(names);
        System.out.println(numberTreeSet);

        // LinkedHashSet - elements are not ordered naturally but preserve the insertion order!
        // HashSet is still faster than LinkedHashSet but not so dramatically
        Set<String> numberLinkedHashSet = new LinkedHashSet<>(names);
        System.out.println(numberLinkedHashSet);

    }

}
