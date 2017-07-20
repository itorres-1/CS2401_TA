package Testers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author: Isaac Benoit1
 * Date: 6/23/17.
 * Course:
 * Assignment:
 * Instructor:
 * T.A:
 */
public class Lab1Tester {


    //Solutions
    public static int[] readFromFile() {
        Scanner scnr = new Scanner(System.in);
        FileReader fr;
        BufferedReader reader;

        while (true) {
            System.out.print("File path: ");
            try {
                fr = new FileReader(scnr.nextLine());
                reader = new BufferedReader(fr);

                //Obtain data
                int arrayLength = Integer.parseInt(reader.readLine());
                String[] intString = reader.readLine().split(" ");
                reader.close();
                fr.close();

                //Parse data
                int[] ints = new int[intString.length];
                for (int i = 0; i < intString.length; i++) {
                    ints[i] = Integer.parseInt(intString[i]);
                }

                //Check if data makes sense
                if (arrayLength != ints.length) throw new InputMismatchException("Invalid data!");

                return ints;
            }
            //Catches
            catch (FileNotFoundException e) {
                System.out.println("File Not Found!");
            } catch (IOException e) {
                System.out.println("IOException!");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static Boolean isPermutation(int[] f) {
        int sum = 0;
        for (int i = 0; i < f.length; i++) {
            sum += (int) Math.pow(2, f[i]);
        }

        int permutation = 0;
        for (int i = 0; i < f.length; i++) {
            permutation += (int) Math.pow(2, i);
        }

        return sum == permutation;
    }
    public static int[] composition(int[] f, int[] g) {
        if (f == null || g == null || (f.length != g.length)||
                !isPermutation(f) || !isPermutation(g)) {
            return null;
        }
        int[] composition = new int[f.length];
        for (int i = 0; i < composition.length; i++) {
            composition[i] = g[f[i]];
        }
        return composition;
    }
    public static int[] inverse(int[] f) {
        if (f == null || !isPermutation(f)) return null;
        else {
            int[] inverse = new int[f.length];
            for (int i = 0; i < f.length; i++) {
                inverse[f[i]] = i;
            }
            return inverse;
        }
    }
    public static int[] pow(int[] f, int k) {
        if (f == null || !isPermutation(f) || k < 0) return null;
        int[] pow = f.clone();
        //k-1 so that k = 1 returns same array and k = 2 returns composition
        for (int i = 0; i < k - 1; i++) {
            pow = composition(pow, f);
        }
        return pow;
    }
    //Utility


    public static boolean arraysEqual(int[] student, int[] me){
        if (student == null && me == null) return true;
        if (student == null && me != null) return false;
        if (student != null && me == null) return false;
        if (student.length != me.length) return false;
        else {
            boolean equal = true;
            for (int i = 0; i < me.length; i++) {
                if (student[i] != me[i]) equal =  false;
            }
            return equal;
        }
    }
    public static void printArray(int[] A){
        if (A == null) System.out.println("null");
        else {
            for (int i = 0; i < A.length; i++) {
                System.out.print(A[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] notPermutation1 = {1, 0, 2, -1};
        int[] notPermutation2 = {2, 1, 0, 8};
        int[] permutation1 = {0, 3, 1, 2};
        boolean yourBoolResult = false;
        int[] yourArrayResult = null;
        int[] myResult = null;
        Double correctness = 0.0;
        Double robustness = 0.0;



        // isPermutation -
        Util.titleString("isPermutation");
        System.out.print("Test Input: ");
        printArray(notPermutation1.clone());
        try {
            System.out.print("Your Result: ");
            System.out.print(yourBoolResult = Lab1.Benoit1.isPermutation(notPermutation1.clone()));
            System.out.println();
            if (!yourBoolResult) {
                robustness += 12.5;
                correctness += 8.33;
            }
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        System.out.println(isPermutation(notPermutation1.clone()));
        Util.printGradeSoFar(correctness, robustness);
        // isPermutation -
        Util.titleString("isPermutation");
        System.out.print("Test Input: ");
        printArray(notPermutation2.clone());
        try {
            System.out.print("Your Result: ");
            System.out.print(yourBoolResult = Lab1.Benoit1.isPermutation(notPermutation2.clone()));
            System.out.println();
            if (!yourBoolResult) {
                robustness += 12.5;
                correctness += 8.33;
            }
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        System.out.println(isPermutation(notPermutation2.clone()));
        Util.printGradeSoFar(correctness, robustness);
        // isPermutation +
        Util.titleString("isPermutation");
        System.out.print("Test Input: ");
        printArray(permutation1.clone());
        try {
            System.out.print("Your Result: ");
            System.out.print(yourBoolResult = Lab1.Benoit1.isPermutation(permutation1.clone()));
            System.out.println();
            if (yourBoolResult) {
                correctness += 8.33;
            }
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        System.out.println(isPermutation(permutation1.clone()));
        Util.printGradeSoFar(correctness, robustness);
        //----------------------------
        // Composition -
        Util.titleString("Composition");
        System.out.print("Test Input 1: ");
        printArray(notPermutation1.clone());
        System.out.print("Test Input 2: ");
        printArray(notPermutation1.clone());
        try {
            myResult = composition(notPermutation1.clone(),notPermutation1.clone());
            System.out.print("Your Result: ");
            yourArrayResult = null;
            printArray(yourArrayResult = Lab1.Benoit1.composition(notPermutation1.clone(), notPermutation1.clone()));
            System.out.println();
            if (arraysEqual(myResult, yourArrayResult)) robustness += 12.5;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(composition(notPermutation1.clone(), notPermutation1.clone()));
        Util.printGradeSoFar(correctness, robustness);
        // Composition -
        Util.titleString("Composition");
        System.out.print("Test Input 1: ");
        printArray(notPermutation2.clone());
        System.out.print("Test Input 2: ");
        printArray(notPermutation2.clone());
        try {
            System.out.print("Your Result: ");
            myResult = composition(notPermutation2.clone(), notPermutation2.clone());
            yourArrayResult = null;
            printArray(yourArrayResult = Lab1.Benoit1.composition(notPermutation2.clone(), notPermutation2.clone()));
            System.out.println();
            if (arraysEqual(myResult, yourArrayResult)) robustness += 12.5;

        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        // Composition +
        Util.titleString("Composition");
        System.out.print("Test Input 1: ");
        printArray(permutation1.clone());
        System.out.print("Test Input 2: ");
        printArray(permutation1.clone());
        try {
            yourArrayResult = null;
            System.out.print("Your Result: ");
            myResult = composition(permutation1.clone(), permutation1.clone());
            printArray(yourArrayResult = Lab1.Benoit1.composition(permutation1.clone(), permutation1.clone()));
            System.out.println();
            if (arraysEqual(yourArrayResult, myResult)) {
                correctness += 25;
            }
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        //----------------------------
        // Inverse -
        Util.titleString("Inverse");
        System.out.print("Test Input: ");
        printArray(notPermutation1.clone());
        try {
            myResult = inverse(notPermutation1.clone());
            System.out.print("Your Result: ");
            yourArrayResult = null;
            printArray(yourArrayResult = Lab1.Benoit1.inverse(notPermutation1.clone()));
            System.out.println();
            if (arraysEqual(myResult, yourArrayResult)) robustness += 12.5;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        // Inverse -
        Util.titleString("Inverse");
        System.out.print("Test Input: ");
        printArray(notPermutation2.clone());
        try {
            myResult =  inverse(notPermutation2.clone());
            System.out.print("Your Result: ");
            yourArrayResult = null;
            printArray(yourArrayResult = Lab1.Benoit1.inverse(notPermutation2.clone()));
            System.out.println();
            if (arraysEqual(yourArrayResult, myResult)) robustness += 12.5;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        // Inverse +
        Util.titleString("Inverse");
        System.out.print("Test Input: ");
        printArray(permutation1.clone());
        try {
            myResult = inverse(permutation1.clone());
            System.out.print("Your Result: ");
            yourArrayResult = null;
            printArray(yourArrayResult = Lab1.Benoit1.inverse(permutation1.clone()));
            System.out.println();
            if (arraysEqual(myResult, yourArrayResult)) correctness += 25;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        //----------------------------
        // Pow -
        Util.titleString("Exponential Composition");
        System.out.print("Test Input: ");
        printArray(notPermutation1.clone());
        try {
            myResult = pow(notPermutation1.clone(),1);
            System.out.print("Your Result: ");
            yourArrayResult = null;
            printArray(yourArrayResult = Lab1.Benoit1.pow(notPermutation1.clone(),1));
            System.out.println();
            if (arraysEqual(yourArrayResult, myResult)) robustness += 12.5;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        // Pow -
        Util.titleString("Exponential Composition");
        System.out.print("Test Input: ");
        printArray(notPermutation2.clone());
        try {
            myResult = pow(notPermutation2.clone(),1);
            System.out.print("Your Result: ");
            yourArrayResult = null;
            printArray(yourArrayResult = Lab1.Benoit1.pow(notPermutation2.clone(),1));
            System.out.println();
            if (arraysEqual(yourArrayResult, myResult)) robustness += 12.5;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        // Pow +
        Util.titleString("Exponential Composition");
        System.out.println("K = 1");
        System.out.print("Test Input: ");
        printArray(permutation1.clone());
        try {
            System.out.print("Your Result: ");
            myResult = pow(permutation1.clone(), 1);
            printArray(yourArrayResult = Lab1.Benoit1.pow(permutation1.clone(),1));
            System.out.println();
            if (arraysEqual(myResult, yourArrayResult)) correctness += 8.33;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        // Pow +
        Util.titleString("Exponential Composition");
        System.out.println("K = 2");
        System.out.print("Test Input: ");
        printArray(permutation1.clone());
        try {
            System.out.print("Your Result: ");
            myResult = pow(permutation1.clone(), 11 );
            printArray(yourArrayResult = Lab1.Benoit1.pow(permutation1.clone(),2));
            System.out.println();
            if (arraysEqual(yourArrayResult, myResult)) correctness += 8.33;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.printGradeSoFar(correctness, robustness);
        // Pow +
        Util.titleString("Exponential Composition");
        System.out.println("K = 3");
        System.out.print("Test Input: ");
        printArray(permutation1.clone());
        try {
            System.out.print("Your Result: ");
            myResult = pow(permutation1.clone(), 9);
            printArray(yourArrayResult = Lab1.Benoit1.pow(permutation1.clone(),3));
            System.out.println();
            if (arraysEqual(myResult, yourArrayResult)) correctness += 8.33;
        } catch (Exception e) {
            System.out.println("Your code crashed.");
        }
        System.out.print("My result: ");
        printArray(myResult);
        Util.titleString("Total Points");
        Util.printGradeSoFar(correctness, robustness);
    }
}
