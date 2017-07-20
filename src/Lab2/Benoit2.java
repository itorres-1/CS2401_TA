package Lab2;
/**
 * Author: Jean-Maxon Benoit1
 * Assignment: Lab 2
 * Instructor: Julio Urenda
 * TA: Isaac Torres
 * Last Modified 6/26/2017.
 * Purpose: Matrix practice
 */
import java.util.*;

//comments are good but describe them in java langauge. i.e A method that takes a 2D int array ....
//also, no need to make: int rowAlenth = A[0].length, that in

public class Benoit2 {
    /**
     *  A method that given two 2D int arrays returns their matrix sum in the form of a 2D int array
     * @param A Matrix to be added
     * @param B Matrix to be added
     * @return sum matrix
     */
    public static int[][] sum(int[][] A, int[][] B) {
        int[][] C = new int[A.length][];
        int aRow = A.length;
        int aCol = A[0].length;
        int bRow = B.length;
        int bCol = B[0].length;

        if (aRow != bRow || aCol != bCol) {                       //Checks if dimensions for each matrix match
            System.out.println("Dimensions don't match");
            return null;
        }

        try {
            for (int i = 0; i < A.length; i++) {
                C[i] = new int[A[i].length];                      //Sets row equal to A's row length
                for (int j = 0; j < A[i].length; j++) {           //Iterates to populate each row
                    C[i][j] = A[i][j] + B[i][j];
                }
                System.out.println(Arrays.toString(C[i]));
            }
        }
        catch (Exception e) {
            return null;
        }
        return C;
    }
    /**
     * Returns the difference of two matrices
     * @param A Matrix to be subtracted
     * @param B Matrix to be subtracted
     * @return  difference matrix
     */
    public static int[][] difference(int[][] A, int[][] B) {
        int[][] C = new int[A.length][];
        int aRow = A.length;
        int aCol = A[0].length;
        int bRow = B.length;
        int bCol = B[0].length;

        if (aRow != bRow || aCol != bCol) {                       //Checks if dimensions for each matrix match
            System.out.println("Dimensions don't match");
            return null;
        }

        try {
            for (int i = 0; i < A.length; i++) {
                C[i] = new int[A[i].length];                      //Sets row equal to A's row length
                for (int j = 0; j < A[i].length; j++) {           //Iterates to populate each row
                    C[i][j] = A[i][j] - B[i][j];                  //Only difference between this and the sum method is the subtraction here
                }
                System.out.println(Arrays.toString(C[i]));
            }
        }
        catch (Exception e) {
            return null;
        }
        return C;
    }
    /**
     * Multiplies a matrix by a number
     * @param A Matrix to be multiplied
     * @param B integer that's going to multiply the matrix by
     * @return  Retruns the scalar multiplication matrix
     */
    public static int[][] intMultiplication(int[][] A, int B) {
        int[][] C = new int[A.length][];


        try {
            for (int i = 0; i < A.length; i++) {
                C[i] = new int[A[i].length];                      //Sets row equal to A's row length
                for (int j = 0; j < A[i].length; j++) {           //Iterates to populate each row
                    C[i][j] = A[i][j] * B;                        //Only difference between this and the sum method is the multiplication here
                }
                System.out.println(Arrays.toString(C[i]));
            }
        }
        catch (Exception e) {
            return null;
        }

        return C;
    }
    /**
     * Multiplies two matrices by each other
     * @param A Matrix
     * @param B Matrix
     * @return product of the two matrices
     */
    public static int[][] matrixProduct(int[][] A, int[][] B) {
        int[][] C = new int[A.length][];
        int aRow = A.length;
        int aCol = A[0].length;
        int bRow = B.length;
        int bCol = B[0].length;

        if (aRow != bCol || aCol != bRow) {                       //Checks if dimensions for each matrix match
            System.out.println("Dimensions don't match");
            return null;
        }

        try {
            for (int i = 0; i < A.length; i++) {                  //Iterates 2 times for A's rows
                C[i] = new int[B[i].length];
                for (int j = 0; j < B[i].length; j++) {           //Iterates 2 times for B's columns
                    for (int k = 0; k < A[i].length; k++) {       //Iterates 3 times A's columns
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
                System.out.println(Arrays.toString(C[i]));
            }
        }
        catch (Exception e) {
            return null;
        }

        return C;
    }
    /**
     * Computes the transpose of a matrix
     * @param A Matrix
     * @return the transpose of A
     */
    public static int[][] transpose(int[][] A) {
        int[][] C = new int[A[0].length][];                       //Number of rows are equal to the number of columns on A

        try {
            for (int i = 0; i < A[0].length; i++) {
                C[i] = new int[A.length];                         //Sets row equal to A's row length
                for (int j = 0; j < A.length; j++) {
                    C[i][j] = A[j][i];                            //Sets row equal to the elements in A's columns
                }
                System.out.println(Arrays.toString(C[i]));
            }
        }
        catch (Exception e) {
            return null;
        }

        return C;
    }
    /**
     * Checks if a matrix is symmetric
     * @param A Matrix
     * @return boolean
     */
    public static Boolean isSymmetric(int[][] A) {
        boolean sym = false;
        int[][] C = transpose(A);                                 //Sets C equal to A^T
        int aRow = A.length;
        int aCol = A[0].length;
        int cRow = C.length;
        int cCol = C[0].length;

        if (aRow != cRow && aCol != cCol) {                       //Checks if dimensions match the transpose's dimensions
            sym = false;
            System.out.println(sym);
            return null;
        }

        try {
            for (int i = 0; i < A[0].length; i++) {
                for (int j = 0; j < A.length; j++) {

                    if (A[i][j] != C[i][j]) {                     //Checks if any element in the matrices do not match
                        sym = false;
                        System.out.println(sym);
                        return null;
                    } else {
                        sym = true;
                    }
                }
            }
        }
        catch (Exception e) {
            return null;
        }

        System.out.println(sym);
        return sym;
    }
    /**
     * Multiplies a matrix by itself k amount of times
     * @param A Matrix
     * @param k integer that tells us how many times to multiply
     * @return product of matrix multiplied by itself
     */
    public static int[][] pow(int[][] A, int k) {
        int[][] power = A.clone();
        int n = 1;

        try {
            if (n == k) {                                         //returns the same matrix if k == 1
                System.out.println(Arrays.deepToString(A));
                return A;
            }
            for (int i = 1; i < k; i++) {
                power = matrixProduct(power, A);

            }
        }
        catch (Exception e) {
            return null;
        }

        return power;
    }
    /**
     * For testing purposes only
     * @param args
     */
    public static void main(String[] args) {
        int k = 2;
        int[][] A = new int[2][];
        int[][] B = new int[3][];

        A[0] = new int[]{1,2};
        A[1] = new int[]{3,4};
        //A[2] = new int[]{1,9,9};

        B[0] = new int[]{2,0};
        B[1] = new int[]{1,2};
        B[2] = new int[]{11,12};

        System.out.println("sum:");
        sum(A,B);
        System.out.println("difference:");
        difference(A,B);
        System.out.println("intMultiplication:");
        intMultiplication(A,k);
        System.out.println("matrixProduct:");
        matrixProduct(A,B);
        System.out.println("transpose:");
        transpose(B);
        System.out.println("isSymmetric:");
        isSymmetric(A);
        System.out.println("pow:");
        pow(B,k);
    }//For testing only
}
