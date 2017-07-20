package Lab1;

/**
 * Created by LoriPena on 6/19/17.
 * Lorianne Pena
 * CS 2401 Summer 2017
 * Lab 1
 */

import java.util.*;
import java.io.*;

public class Pena {


    public static int[] readFromFile() { //method to read file
        Scanner scnr = new Scanner (System.in);
        FileReader file;
        BufferedReader reader;

        while (true) {
            try {
                System.out.println ("Please enter a file path: ");
                file = new FileReader (scnr.nextLine ( ));
                reader = new BufferedReader (file);

                int k = Integer.parseInt (reader.readLine ( ));
                String[] intStrings = reader.readLine ( ).split (" ");
                int[] ints = new int[intStrings.length];
                for (int i = 0; i < intStrings.length; i++) {
                    ints[i] = Integer.parseInt (intStrings[i]);
                }
                if (k != ints.length) throw new InputMismatchException ("Data does not make sense!");
                return ints;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println ("Something went wrong!");
            } catch (IOException e) {
                System.out.println ("File Error!");
            } catch (InputMismatchException e) {
                System.out.println (e.getMessage ( ));
            }

        }
    }

    public static boolean isPermutation(int[] a) {//method to test if the file is a permutation

        for (int i = 0; i < a.length; i++) {
            //condition number 1
            if (a[i] < 0 || a[i] > a.length - 1) return false;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) return false;
            }
        }
        return true;

    }

    //Utility
    public static int[] composition(int[] f, int[] g) {//method to compose permutation
        //f and g are of different lengths
        if (f.length != g.length) return null;
        //f OR g could not be permutations
        if (!isPermutation (f) || !isPermutation (g)) {
            System.out.println ("This array is not a permutation. Please try again!");
            return null;
        }
        //f or g (because they're objects) could be null
        if (f == null || g == null) {
        }


        int[] composition = new int[f.length];
        for (int i = 0; i < composition.length; i++) {
            composition[i] = g[f[i]];
        }
        return composition;
    }

    public static int[] inverse(int[] composition) {//method for inverse of permutation

        return composition;
    }

    public static int[] pow(int[] m, int k) {//method for computes power a^k
        //getting the length of the array
        int[] power = new int[m.length];
        for (int i = 0; i < m.length; i++) {//iterating through the array to multiply the indices
            power[i] = m[i] * k;
        }
        return power;
    }


    public static void printArray(int[] A) {//print
        for (int i = 0; i < A.length; i++) {
            System.out.print (A[i] + " ");
        }
        System.out.println ( );
    }

//    public static void main(String[] args) throws FileNotFoundException {
//
//
//        int[] array1 = readFromFile ( );//reading first file
//        printArray (array1);//printing array
//        System.out.println ("Is this a permutation?:" + isPermutation (array1));//checking if the array is a permutation
//        int[] array2 = readFromFile ( );//reading second file
//        printArray (array2);//printing array 2
//        System.out.println ("Is this a permutation?:" + isPermutation (array2));//checking if the second array is a permutation
//        int[] array3 = readFromFile ( );//reading array 3
//        printArray (array3);//printing array 3
//        System.out.println ("Is this a permutation?:" + isPermutation (array3));//checking if the third array is a permutation
//        System.out.print ("Computation: ");
//        printArray (comp (array2, array3));//printing the comp method
//        System.out.print ("Inverse: ");
//        printArray (inverse (array2));//printing the inverse method
//        System.out.print ("Power:");
//        int[] a = comp (array2, array3);//making a new array to pass for pow method parameter
//        printArray (pow (a, +1));//printing pow method
//
//
//    }

}
