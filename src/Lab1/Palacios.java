package Lab1;

/**
 * Created by Mariel Palacios  on 6/20/2017.
 * CS2401_Lab1
 * Dr. Julio Urenda
 * TA: Isaac Torres
 * Date of last modification: 6/21/17
 * Purpose of program:
 * Take array from file input and compute its permutation, composition with other arrays, inverse, and powers.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Palacios {
//    public static void main(String[] args) {
//        try{
//            System.out.println("Method - readFromFile: ");
//            int[] array1 = (readFromFile());
//            printArray(array1);
//            System.out.println();
//
//            System.out.println("Method - isPermutation: ");
//            int[] perm = (readFromFile());
//            System.out.print(isPermutation(perm));
//            System.out.println();
//
//
//            //COMPOSITION
//            System.out.println("Method - composition: ");
//            System.out.println("first array ");
//            int[] array1comp = (readFromFile());
//            printArray(array1comp);
//            System.out.println();
//            System.out.println("second array: ");
//            int[] array2comp = readFromFile();
//            printArray(array2comp);
//            System.out.println();
//            int[] composedArray= comp(array1comp,array2comp);
//            System.out.println("Composition of first and second array: ");
//            printArray(composedArray);
//            System.out.println();
//
//            //INVERSE
//            System.out.println("Method - inverse: ");
//            int[] inputArray = (readFromFile());
//            int[] invArray = inverse(inputArray);
//            printArray(invArray);
//            System.out.println();
//
//            //POWER
//            System.out.println("Method - power: ");
//            int[] pow = (readFromFile());
//            System.out.println("Input value for k: ");
//            Scanner scnr = new Scanner(System.in);
//            int k = scnr.nextInt();
//            int[] powerArray = power(pow,k);
//            printArray(powerArray);
//            System.out.println();
//
//            //EXTRA CREDIT (randomPerm)
//            System.out.println("Method - extra credit: ");
//            int[] extraArray = (readFromFile());
//            int[] random = randomPerm(extraArray);
//            printArray(random);
//            System.out.println();
//        }
//        catch (FileNotFoundException e) {
//            System.out.println("file not found");
//        }
//        catch (IOException e) {
//            System.out.println("Something went wrong.");
//        }
//    }
    /**
     * readFromFile is used to read and return the arrays from files provided by user.
     */

    public static int[] readFromFile() throws FileNotFoundException, IOException {
        Scanner scnr = new Scanner(System.in);
        FileReader fr;
        BufferedReader reader;

        Boolean successful = false;

        int[] A = new int[0];       //create a new array to fill with integers

        while (!successful) {
            System.out.print("File path: ");
            fr = new FileReader(scnr.nextLine());
            reader = new BufferedReader(fr);

            int k = Integer.parseInt(reader.readLine()); //wont work if first line is something like "a" or "1 2"

            String[] intString = reader.readLine().split(" ");
            // intString = {"1", "3",..};
            //convert this string ints into actual int[]
            A = new int[k];
            for (int i = 0; i < k; i++) {
                A[i] = Integer.parseInt(intString[i]); //convert {"1", "3"..} -> {1,3,...}

                successful = true;
            }
        }
        return A;
    }

    /**
     * isPermutation takes in an array of integers
     * returns true/false if the array is a permutation
     */
    public static boolean isPermutation(int[] A) {
        int n = A.length;
        int k = 1;
        int[] compareTo = new int[A.length]; //create new array of same size and fill it as a permutation
        compareTo[0] = 0;
        for (int i = 1; i < n; i++) {
            compareTo[i] = n - (n - k); // this fills the array using and modifying the value of the length
            k = k + 1;
        }

        int i;
        int hold;
        //sort the array given from greatest to least
        for (i = 0; i <A.length-i - 1; i++) {
            for (int j =0; j < A.length-i-1; j++) {
                if (A[i] > A[i + 1]) {
                    hold = A[i + 1];
                    A[i + 1] = A[i];
                    A[i] = hold;
                }
            }
        }


        for (i =0; i<n; i++) {
            for (int j = 0; i < n; i++) {
                if (compareTo[i] != A[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * comp method will return the composition of int arrays A and B
     * value at i in the new array is the value at the position of the B value in A.
     */

    public static int[] composition(int[] A, int[] B) {
        int[] composition = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            composition[i] = A[B[i]];      //value at new array is the value at the position of the B value in A
        }
        return composition;
    }

    /**
     * inverse method replaces the index of the new array with the value of old array in that index.
     * A is an int array
     * returns the inverse array of A
     */
    public static int[] inverse(int[] A) {
        int[] inverseArray = new int[A.length];
        for (int i = 0; i <A.length; i++) {
            inverseArray[A[i]] = i;        //the index of the new array is the value of old array in that index
        }
        return inverseArray;
    }

    /**
     * In this method the array is composed with itself k times.
     *  int k is determined by the user.
     *  returns the array to the k power
     */
    public static int[] pow(int[] A, int k) {
        int[] powerArray = new int[A.length];
        if (k == 1) return A;
        for (int i = 0; i<=A.length-1; i++) {
            powerArray[i] = A[A[i]];           // array composed with itself
        }
        return powerArray;
    }

    /**
     * this method is used to print the arrays that are returned by the methods.
     */
    public static void printArray(int[] B) {     //to print the arrays
        int i;
        for (i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }

    /**
     * EXTRA CREDIT
     * randomPerm uses a for loop to generate a random permutation
     * i increases by two
     */
    public static int[] randomPerm(int[] A) {
        int holder;
        for (int i =1; i < A.length; i=i+2) { // i increases by 2
            holder = A[i];
            A[i] = A[0];
            A[0] = holder;
        }
        return A;
    }
}