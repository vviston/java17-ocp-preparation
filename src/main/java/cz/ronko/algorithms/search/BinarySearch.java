package cz.ronko.algorithms.search;

import java.util.Arrays;

public class BinarySearch {

   /*
    it works only on sorted collection!
    we need to set pivot (middle element of the sorted collection)
    if the element is higher we choose the left part of the collection
    otherwise the right side. Again choose pivot for right or left part
    of the chosen collection and do the same until we find our value
    */


    public static void main(String[] args) {

        int[] ints = {1, 2, 4, 5, 7, 9, 11};

        System.out.println(binarySearch(ints, 9));
        System.out.println(binarySearch(ints, 20));
        System.out.println(binarySearch(ints, 1));
        System.out.println(binarySearch(ints, 11));

        //binary search already present in Arrays :)
        System.out.println(Arrays.binarySearch(ints, 9));

    }

    //returns the index of the number you search for
    private static int binarySearch(int[] numbers, int numberToFind) {
        //two pointers first and last index of element of the array
        //find the index of the element just between these two pointers
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int middlePosition = (low + high) / 2;
            int middleNumber = numbers[middlePosition];

            if (numberToFind == middleNumber) {
                return middlePosition;
            } else if (numberToFind < middleNumber) {
                high = middlePosition - 1;
            } else {
                low = middlePosition + 1;
            }
        }
        return -1;
    }

}
