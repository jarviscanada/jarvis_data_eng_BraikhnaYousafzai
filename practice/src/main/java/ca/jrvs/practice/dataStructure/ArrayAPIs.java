package ca.jrvs.practice.dataStructure;

import java.util.Arrays;
import java.util.List;

public class ArrayAPIs {

    public static void main(String[] args) {

        //create array of integers
        int[] intArray = new int[10];
        intArray[0] = 100;
        intArray[1] = 200;
        intArray[2] = 300;
        intArray[3] = 400;
        intArray[4] = 500;
        intArray[5] = 600;
        intArray[6] = 700;
        intArray[7] = 800;
        intArray[8] = 900;
        intArray[9] = 1000;

        //short cut syntax to create and initialize array
        int[] inlineArray = {
                100, 200, 300
        };

        //2D array
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };

        //copying an aray
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];
        //copying from second element in copyFrom to first element in copyTo. Copying only 7 elements.
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));

        //convert array to a list
        List<String> fruits = Arrays.asList(new String[]{"apple", "orange"});
        System.out.println(fruits.toString());

        //copy
        String[] fruitArray = new String[]{"mango", "banana"};
        String[] fruitArray1 = Arrays.copyOfRange(fruitArray, 0, 1);
        System.out.println(fruitArray1.toString());

        //sorting arrays
        Arrays.sort(fruitArray);
        System.out.println(Arrays.toString(fruitArray));

        //binarySearch
        int exact = Arrays.binarySearch(fruitArray, "banana");
        System.out.println(exact); //prints the element where key is located



    }

}
