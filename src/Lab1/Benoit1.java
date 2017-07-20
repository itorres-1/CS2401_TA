package Lab1;
/**
 * Author: Jean-Maxon Benoit1
 * Assignment: Lab 1
 * Instructor: Julio Urenda
 * TA: Isaac Torres
 * Last Modified 6/21/2017.
 * Purpose: Boatright array practice
 */
import java.util.*;
import java.io.*;

public class Benoit1 {

    /**
     *
     * @param a
     * @return
     */
    public static boolean isPermutation(int[] a) {
        boolean permutation = true;

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                if (j!=i && a[j] == a[i]) {
                    permutation = false;
                }
            }
        }

        return permutation;
    }
    /**Given two arrays, returns their composition*/
    public static int[] composition(int[] a, int[] b)
    {
        int[] composition = new int[a.length];

        for(int i = 0; i < a.length; i++) {
            composition[i] = a[b[i]];       //sets each element in the array to the composition of a;b
        }

        System.out.println(Arrays.toString(composition));
        return composition;
    }

    /**
     * This method given an int array a representing a permutation, computes and returns the inverse.
     * @param a
     * @return
     */
    public static int[] inverse(int[] a) {
        int[] inv = new int[a.length];
        int temp;

        for(int i = 0; i < a.length; i++) {
            try {
                inv[a[i]] = i;
            }
            catch (Exception e) {
                System.out.println("Out of bounds array");
            }
        }

        System.out.println(Arrays.toString(inv));
        return inv;
    }
    /**Takes an array and composes it with itself k times*/
    public static int[] pow(int[] a, int k) {
        int[] power = a.clone();
        int n = 1;

        if (n == k){                //returns the same array if k == 1
            System.out.println(Arrays.toString(a));
            return a;
        }
        for (int i = 0; i < a.length; i++) {
            power[i] = a[i];        //sets power equal to a
        }
        for (int i = 1; i < k; i++) {
            power = composition(power,a); //

        }
        return power;
    }
    /** Reads a file and returns an integer array*/
    public static int[] readFromFile() throws IOException {
        Scanner scan = new Scanner(System.in);
        FileReader fr;
        BufferedReader br;
        boolean valid = false;
        int[] intArray = new int[0];

        while (!valid) {        //loops until the file path is right
            System.out.println("File Path: ");
            boolean whileSuccess;

            try {
                fr = new FileReader(scan.nextLine());
                br = new BufferedReader(fr);

                int k = Integer.parseInt(br.readLine());
                String[] intString = br.readLine().split(" ");

                boolean trySuccess = true;
                if (k != intString.length){
                    System.out.println("First Integer in file does not match the length of the array.");
                    System.out.println("Please use a different file.");
                    trySuccess = false;
                }

                intArray = new int[k];
                for (int i = 0; i < k; i++) {
                    int n = Integer.parseInt(intString[i]);
                    intArray[i] = n;
                }
                whileSuccess = trySuccess;
            }
            catch (Exception e) {
                System.out.println("Try Again");
                whileSuccess = false;
            }

            valid = whileSuccess;
        }
        return intArray;
    }
    /**Contains all of the method calls*/
//    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        boolean exit = false;
//        int k = 0;
//
//        while (!exit) {                         //while loop for method calls
//            System.out.println("Boatright:");
//            isPermutation(readFromFile());
//            System.out.println("Composition:");
//            comp(readFromFile(), readFromFile());
//            System.out.println("Inverse:");
//            inverse(readFromFile());
//            System.out.println("Power:");
//            System.out.println("Integer k:");
//
//            while (!scan.hasNextInt()) {        //while loop for non integer values
//                System.out.println("Try Again");
//                scan.next();
//            }
//            k = scan.nextInt();
//            while (k < 1) {                     //while loop for when k is less than 1
//                System.out.println("Try Again");
//                try {
//                    k = scan.nextInt();
//                }
//                catch (Exception e) {
//                    scan.next();
//                    k = 0;
//                }
//            }
//            pow(readFromFile(), k);
//
//            boolean menu = false;
//            while(!menu) {                      //while loop for menu
//                int choice;
//                System.out.println("Do you want to try again?");
//                System.out.println("1. Yes");
//                System.out.println("2. No");
//
//                try {
//                    choice = scan.nextInt();
//
//                    if(choice == 2) {
//                        menu = true;
//                        exit = true;
//                    }
//                    else if (choice == 1) {
//                        menu = true;
//                        exit = false;
//                    }
//                }
//                catch (Exception e) {
//                    scan.next();
//                    menu = false;
//                }
//            }
//        }
//    }
}

