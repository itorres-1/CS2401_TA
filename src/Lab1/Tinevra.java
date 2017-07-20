package Lab1;

/**
 * Created by tinevra17 on 6/18/17.
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Tinevra {
    /** readFromFile
     * this method does not take any parameters
     * @return it returns an array of integers provided by a file
     */
    public static int[] readFromFile() {
        Scanner scnr = new Scanner(System.in);
        FileReader fr;
        BufferedReader reader;

        Boolean successful = false;

        int[] A = new int[0];       //create a new array to fill with integers

        while (!successful) {
            System.out.print("File path: ");
            try {
                fr = new FileReader(scnr.nextLine());
                reader = new BufferedReader(fr);

                int k = Integer.parseInt(reader.readLine()); //wont work if first line is something like "a" or "1 2"

                String[] intString = reader.readLine().split(" ");
                // intString = {"1", "3",..};
                //convert this string ints into actual int[]

                A = new int[intString.length];
                for (int i = 0; i < intString.length; i++) {
                    A[i] = Integer.parseInt(intString[i]); //convert {"1", "3"..} -> {1,3,...}
                    successful = true;
                }
                if (k != A.length) {
                    throw new IOException();
                }

            } catch (FileNotFoundException e) {
                System.out.println("file not found");

            } catch (IOException e) {
                System.out.println("Something went wrong.");
                readFromFile();
            }
        }

        return A;
    }

    /**
     *permutation
     * @param k is the array of integers provided by ReadFromFile
     * @return it returns a boolean to se if the array is a permutation array
     */
    public static boolean isPermutation(int[] k) {
        int[] check = new int[k.length];

        //populating k array
        for (int i = 0; i < k.length; i++) {
            check[i] = i;
        }

        Arrays.sort(k);
        Arrays.sort(check);

        //checking for duplicates
        boolean checkB = true;
        for (int i = 0; i < k.length; i++) {
            for (int j = i + 1; j < k.length; j++) {
                if (j != i && k[j] == k[i]) {
                    checkB = false;
                }
            }
        }

        //checking for factorial k number
        for (int i = 0; i < k.length; i++) {
            if (k[i] != check[i]) {
                checkB = false;
            }
        }

        if (checkB == false) {
            for (int i = 0; i < k.length; i++) {
                System.out.print(k[i] + " ");

            }
            System.out.println(" is not a permutation");
        }
        if (checkB == true) {
            for (int i = 0; i < k.length; i++) {
                System.out.print(k[i] + " ");

            }
            System.out.println(" is a permutation");
        }
        return checkB;
    }

    /**
     * Composition
     * @param A is the array of integers provided by ReadFromFile
     * @return it returns an array based on the composition of K and a 2nd file
     * @throws IOException
     */
    public static int[] composition(int[] A, int[] B) throws IOException {

        int[] comp = new int[A.length];
        //composition maker
        for (int i = 0; i < A.length; i++) {
            comp[i] = A[B[i]];
        }
        System.out.print("The composition of file 1 and 2 is ");
        for (int i = 0; i < comp.length; i++) {
            System.out.print(comp[i] + " ");
        }
        System.out.println("");
        return comp;
    }

    /**
     * inverse
     * @return it returns the inverse of the array provided by the user
     */
    public static int[] inverse(int[] k) {
        System.out.println("Enter file for inverse ");
        int[] index = new int[k.length];
        int[] inverseA = new int[k.length];
        for (int i = 0; i < k.length; i++) {
            index[i] = i;
        }
        //inverse maker
        for (int i = 0; i < k.length; i++) {
            inverseA[k[i]] = index[i];
        }
        System.out.print("The inverse of the file is ");
        for (int i = 0; i < k.length; i++) {
            System.out.print(inverseA[i] + " ");
        }
        System.out.println("");
        return inverseA;
    }

    /**
     * power
     * @param k is the array of integers provided by the user
     * @param n is the integer which is the power desire by the user
     * @return it returns an array based on k to the n power
     * @throws IOException
     */
    public static int[] pow(int[] k, int n) throws IOException {
        int[] newA = new int[k.length];
        if (n > 1) {
            for (int i = 0; i < k.length; i++) {
                newA[i] = k[k[i]];
            }
            return pow(newA, n - 1);
        } else return k;
    }

    //main
//    public static void main(String[] args) throws IOException {
//        int[] info = readFromFile();
//
//        permutation(info);
//
//        composition(info);
//
//        inverse();
//
//        int powerInt = 0;
//        System.out.print("Enter a power ");
//        try {
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            if (n < 1) throw new IOException();
//            powerInt = n;
//        } catch (IOException e) {
//            System.out.println("Enter another power");
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//        }
//        int[] powerInfo = readFromFile();
//
//        int[] powArray = power(powerInfo, powerInt);
//
//        System.out.print("The power of ");
//        for (int i = 0; i < powArray.length; i++) {
//            System.out.print(info[i] + " ");
//
//        }
//        System.out.print("to the " + powerInt + " power is ");
//        for (int i = 0; i < powArray.length; i++) {
//            System.out.print(powArray[i] + " ");
//
//        }
//
//    }
}