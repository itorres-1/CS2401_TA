package Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * CS2401: Elementary Data Structures and Algorithms
 * Instructor: Julio Urenda
 * Teaching Assistant: Isaac Torres
 * Assignment: Lab 1
 * Modified and submitted by: Raul Reza
 * Last modification: 6/21/2017
 * Purpose: Read a file and create an array which we are going to use to determine if it's a permutation, calculate a composition, calculate the inverse, and compose it to a power.
 */
public class Reza {
    /**
     * Main method is used to go into each of the methods, also prints everything.
     * @param args arguments
     */
//    public static void main(String[] args) {
//        int[] array = readFromFile();
//        boolean isPermutation = isPermutation(array);
//        System.out.print("[");
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i]);
//        }
//        System.out.print("] ");
//        if(isPermutation){
//            System.out.println("Is a permutation.");
//        }
//        else{
//            System.out.println("Is not a permutation.");
//        }
//        array = composition();
//        System.out.print("The composition of array 1 and array 2 is: [");
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i]);
//        }
//        System.out.print("]");
//        System.out.println();
//        System.out.print("The inverse of array [");
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i]);
//        }
//        System.out.print("] is: [");
//        array = inverse(array);
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i]);
//        }
//        System.out.print("]");
//        System.out.println();
//        array = power(array);
//        System.out.print("[");
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i]);
//        }
//        System.out.print("]");
//    }

    /**
     * readFromFile uses Scanner to read the file from where the arrays are being read.
     * @return permutation
     */
    public static int[] readFromFile() {
        String reader;
        int arrayLength = 0;
        int permutationLength = 1;
        int i = 0;
        int[] permutation = null;


            while ((permutationLength != arrayLength)) {
                try {
                    String readFile = "";
                    System.out.print("Enter file path: ");
                    Scanner scnr = new Scanner(System.in);
                    readFile = scnr.nextLine();
                    File read = new File(readFile);
                    Scanner input = new Scanner(read);
                    reader = input.nextLine();

                    try {
                        arrayLength = Integer.parseInt(reader);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Array is invalid. Try a different file.");
                    }
                    try {
                        permutation = new int[arrayLength];
                        permutationLength = 0;
                        i = 0;
                        while (input.hasNextLine()) {
                            permutationLength = permutationLength + 1;
                            permutation[i] = input.nextInt();
                            i = i + 1;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Array is invalid. Try a different file.");
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.print("Error.");
                    }
                    if ((permutationLength != arrayLength)) {
                        System.out.println("Array is invalid. Try a different file.");
                    }
                    else {
                    }
                }
                catch (FileNotFoundException e) {
                    System.out.println("File not found. Try a different file.");
                }
            }

        return permutation;
    }

    /**
     * isPermutation takes in the array permutation and determines if it's a permutation or not.
     * @param permutation array
     * @return boolean
     */
    public static boolean isPermutation(int[] permutation){
        for(int i = 0; i < permutation.length-1 ;i++){
            for(int j = i + 1; j < permutation.length; j++){
                if(permutation[i] == (permutation[j])){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * composition calculates the composition of 2 array that are read from 2 files.
     * @return composition
     */
    public static int[] composition(int[] arrayOne, int[] arrayTwo){

        int[] composition = new int[arrayOne.length];
        for(int i = 0; i < arrayOne.length; i++){
            composition[i] = arrayOne[arrayTwo[i]];
        }

        return composition;
    }

    /**
     * inverse takes in array permutation and calculates the inverse of that array.
     * @param permutation array
     * @return inverse
     */
    public static int[] inverse(int[] permutation){
        int[] inverse = new int[permutation.length];
        for(int i = 0; i < permutation.length; i++){
            inverse[i] = permutation[permutation[i]];
        }
        return inverse;
    }

    /**
     * power takes in array permutation and asks the user for an integer to calculate the composition of the array permutation that amount of times.
     * @param permutation array
     * @return powerPermutation
     */
    public static int[] pow(int[] permutation, int power){

        int[] powerPermutation = new int[permutation.length];
        for(int i = 1; i < power; i++){
            for(int j = 0; j < powerPermutation.length; j++){
                powerPermutation[j] = permutation[permutation[j]];
            }
        }
        return powerPermutation;
    }
}

