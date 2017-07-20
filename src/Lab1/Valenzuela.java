package Lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Cesar Valenzuela
 * Date: 6/19/2017
 * Course: CS 2401
 * Assignment:
 * Instructor: Julio C. Urenda
 * T.A: Isaac Torres
 */
public class Valenzuela {
//    public static void main(String[] args) {
//        int[] txtNums = readFromFile();
//        for (int i : txtNums) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("\nCheck if array is a valid permutation");
//        System.out.println(isPermutation(readFromFile()));
//
//        System.out.println("\nComposition of two text files: please enter two text files. ");
//        int[] c = composition(readFromFile(), readFromFile());
//        System.out.println("\nComposition");
//        for (int a : c) {
//            System.out.print(a + " ");
//        }
//
//        System.out.println("\n\nEnter text file to compute its inversion ");
//        int[] invertedArray = inversion(readFromFile());
//        for (int a: invertedArray) {
//            System.out.print(a + " ");
//        }
//
//        System.out.println("\nPlease enter a value for k:");
//        Scanner scnr = new Scanner(System.in);
//        int k = scnr.nextInt();
//        System.out.println("Array to the power of " + k + " is:");
//        int[] powerArray = power(readFromFile(),k);
//        for (int o: powerArray) {
//            System.out.print(o + " ");
//        }
//    }

    public static int[] readFromFile() {
        /**
         * This method will ask the user to input a .txt file in order to extract the integers
         * from the file and placing them within an array.
         * This method is the most called method because it creates a loop with try and catches
         * in order to keep prompting the user to input the correct format of file.
         */
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nFile path: ");

        int[] txtNums = null;

        FileReader fr;
        BufferedReader reader;

        Boolean successfulFileRead = false;
        while (!successfulFileRead) {
            try {
                fr = new FileReader(scnr.nextLine());
                reader = new BufferedReader(fr);

                int k = Integer.parseInt(reader.readLine());
                String[] intStrings = reader.readLine().split(" ");

                txtNums = new int[intStrings.length];
                for (int i = 0; i < txtNums.length; i++) {
                    txtNums[i] = Integer.parseInt(intStrings[i]);

                }

                return txtNums;
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        return txtNums;
    }

    public static boolean isPermutation(int[] txtNums) {
        /**
         * This method checks if the array extracted from the input file
         * is a valid permutation. It does this by checking that there are
         * no duplicate numbers within the array
         */
        for (int i = 0; i < txtNums.length; i++) {
            for (int j = 0; j < txtNums.length; j++) {
                if (i != j && txtNums[j] == txtNums[i])
                    return false;
            }
        }
        return true;
    }

    public static int[] composition(int[] a, int[] b) {
        /**
         * This method takes in two files which are converted into int arrays
         * and composes the values within into a new array named c.
         */
        int[] c = new int[4];
        for (int i = 0; i < 4; i++) {
            c[i] = a[b[i]];
        }
        return c;
    }

    public static int[] inverse(int[] a) {
        /**
         * This method inverts an array by reversing the original function
         * such that the original array checks the value of the integer at the index
         * and sets that value equal to the index
         * This effectively inverts the function.
         */
        int[] invertedArray = new int[4];

        for (int i = 0; i < 4 ; i++) {
            invertedArray[a[i]] = i;
        }
        return invertedArray;
    }
    public static int[] pow(int[] a, int k){
        /**
         * This method composes the array to itself a number of k times
         * k times is inputted by the user
         * since it composes itself then composition method can be called
         */
        int[] powA = new int[a.length];
        for(int i = 0; i < 4; i++){
            powA[i] = a[i];
        }
        for(int i = 0; i < k-1; i++){
            powA = composition(powA,a);
        }
        return powA;
    }
}
