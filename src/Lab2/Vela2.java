package Lab2;

/**
 * Name: Gabriel Vela
 * Class: CS2401
 * Assignment: Lab 2
 **/

import java.util.*;
import java.io.*;

public class Vela2 {

    //TODO Javadoc - method description goes above the parameters

    /**
     * @param A - A 2-D integer array.
     * @param B - A 2-D integer array.
     * @return sumArray - a sum array of the two arrays.
     * <p>
     * Method takes the sum of two integer arrays,
     * and returns the corresponding output in an integer array format.
     */
    public static int[][] sum(int[][] A, int[][] B) {


        int sumArray[][] = new int[A.length][A[0].length];
        try {

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    sumArray[i][j] = A[i][j] + B[i][j];
                }
            }
            return sumArray;
        } catch (IllegalArgumentException e) {
            System.out.println("The arguments required od not match!");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("The requested input doesn't match!");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given array is out of bounds.");
            return null;
        }

    }

    /**
     * @param A - A 2-D integer array.
     * @param B - A 2-D integer array.
     * @return diffArray - a difference array of the two arrays.
     * <p>
     * Takes the difference of two integer arrays,
     * and returns corresponding output in an integer array.
     */
    public static int[][] difference(int[][] A, int[][] B) {


        int diffArray[][] = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    diffArray[i][j] = A[i][j] - B[i][j];
                }
            }
            return diffArray;
        } catch (IllegalArgumentException e) {
            System.out.println("The arguments required od not match!");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("The requested input doesn't match!");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given array is out of bounds.");
            return null;
        }
    }

    /**
     * @param A - a 2-D array.
     * @param B - a integer variable that is used to multiply.
     * @return multiArray - a resulting integer array that contains the product matrix.
     * <p>
     * <p>
     * Takes the product of two integer arrays,
     * and returns corresponding output in an integer array.
     */
    public static int[][] intMultiplication(int[][] A, int B) {


        int multiArray[][] = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    multiArray[i][j] = A[i][j] * B;
                }
            }
            return multiArray;
        } catch (IllegalArgumentException e) {
            System.out.println("The arguments required od not match!");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("The requested input doesn't match!");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given array is out of bounds.");
            return null;
        }
    }

    /**
     * @param A - a 2-D integer array.
     * @param B - a 2-D integer array.
     * @return prodArray - returns the product result of both arrays in an array.
     * <p>
     * Takes the product of two integer arrays,
     * and returns corresponding output in an integer array.
     */
    public static int[][] matrixProduct(int[][] A, int[][] B) {


        int prodArray[][] = new int[A.length][B[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k  = 0; k < A.length; k++){
                        prodArray[i][j] = A[i][k] * B[k][j];
                    }
                }
            }
            return prodArray;
        } catch (IllegalArgumentException e) {
            System.out.println("The arguments required od not match!");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("The requested input doesn't match!");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given array is out of bounds.");
            return null;
        }
    }

    /**
     * @param A - A 2-D integer array.
     * @return new transposition transposeArray that return the transposition of an array.
     * <p>
     * Takes the integer array,
     * and returns corresponding transposed output in an integer array.
     */
    public static int[][] transpose(int[][] A) {


        int transposeArray[][] = new int[A[0].length][A.length];
        try {
            for (int i = 0; i < A[0].length; i++) {
                for (int j = 0; j < A.length; j++) {
                    transposeArray[i][j] = A[j][i];
                }
            }
            return transposeArray;
        } catch (IllegalArgumentException e) {
            System.out.println("The arguments required od not match!");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("The requested input doesn't match!");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given array is out of bounds.");
            return null;
        }
    }

    /**
     * @param A - A 2-D integer array.
     * @return boolean result, either true or false depending on symmetry.
     * <p>
     * Takes the integer array,
     * and returns a boolean result depending on whether or not it is symmetric.
     */
    public static Boolean isSymmetric(int[][] A) {


        boolean symmetry = true;
        try {
            for (int i = 0; i < A[0].length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (A[i][j] != A[j][i]) {
                        symmetry = false;
                    }
                }
            }
            return symmetry;
        } catch (IllegalArgumentException e) {
            System.out.println("The arguments required od not match!");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("The requested input doesn't match!");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given array is out of bounds.");
            return null;
        }
    }

    /**
     * @param A - A 2-D integer array.
     * @param k - A integer array.
     * @return powArray - a resulting array.
     * <p>
     * Takes the power of an integer array,
     * and returns corresponding output in an integer array
     * after it has completed the product method the specified number of times via 'k' argument.
     */
    public static int[][] pow(int[][] A, int k) {


        int[][] powArray = A;
        try {
            for (int i = 1; i < k; i++) {
                powArray = matrixProduct(powArray, A);
            }
            return powArray;
        } catch (IllegalArgumentException e) {
            System.out.println("The arguments required od not match!");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("The requested input doesn't match!");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given array is out of bounds.");
            return null;
        }
    }

    /**
     * @param A - A 2-D array that is passed through.
     *          <p>
     *          Method created to print an array's contents. Making it easier to view for the user,
     *          and thus know what they're doing.
     */
    public static void printArray(int[][] A) {


        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {


                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println(" ");

    }


}