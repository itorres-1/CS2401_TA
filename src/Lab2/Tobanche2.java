package Lab2;

/*
Author: Oscar Tobanche
Date: 6/26/2017
Course: CS 2401 Elementary data structures
Professor: Julio Cesar Urenda
TA: Isaac Torres

*/

import java.io.IOException;

public class Tobanche2 {
    /*
    This is the sum method,  basically I implemented a nested loop to add the coordinates i and j up of A and B
    Created a new array that stores the sum of both A and B. used and array store exception in case there is a float number or a mismatch

    */
    public static int[][] sum(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    C[i][j] = A[i][j] + B[i][j];
                }
            }
        } catch (ArrayStoreException e) {
            System.out.println("Data Type Mismatch" + e);
        }

        return C;


    }

    /*
    This method substract the matrices A and B, and I used a nested
    loop because it is a 2d array and I need 2 counters for the coordinates.
    implemented an extra array named c to copy the return value of the matrix
    used and array store exception in case there is a float number or a mismatch


    */
    public static int[][] difference(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] - B[i][j];
                }
            }
        } catch (ArrayStoreException e) {
            System.out.println("Data Type Mismatch" + e);
        }

        return C;

    }


    public static int[][] intMultiplication(int[][] A, int k) {
        int[][] B = {{0}};
        return B;
    }

    /*
    Implemented a nested loop and a triple loop, the first loop mission is to populate the new array to create necessary
    space, and the triple loop is to make the arithmnetic operations involved in the multiplication. I used a index out
    of bounds exception in case the 2 matrices are not compatible, because we cant multiply a 3x2 and a 10x45 array,
    Implemented a new 2d array that copy the product of A and B and 3 counters i,j,k.
    */


    public static int[][] matrixProduct(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        int i, j, k;
        try {

            for (i = 0; i < A.length; i++) {
                for (j = 0; j < A[0].length; j++) {
                    C[i][j] = 0;
                }
            }
            for (i = 0; i < A.length; i++) {
                for (j = 0; j < A.length; j++) {
                    for (k = 0; k < A[0].length; k++) {
                        C[i][j] += (A[i][k] * B[k][j]);

                    }

                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Out Of Bounds" + e);
        }
        return C;
    }

    /*
    In this method I implemented a nested loop that swap the indexes or counters of the 2d array, so I can get the transpose of the matrix,
    I implemented a index out of bounds in case the matrix is not n x m
    */
    public static int[][] transpose(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    B[i][j] = B[j][i];
                }
            }


        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Out Of Bounds" + e);
        }
        return B;
    }

    /*
    this method returns whether a matrix is symmetric or not, I used a nested loop and a n
    if statement in the body to check if the counters swapped are the same a s the counter in their spot
    */
    public static boolean isSymmetric(int[][] A) {
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (A[i][j] != A[j][i]) {
                        return false;
                    }
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("matrix dimensions have to be the same" + e);
        }
        return true;
    }

    /*
    this method is the same as the multiplication , but I added an extra loop for the k number that says how many times does the matrix has to multiply itself
    */
    public static int[][] pow(int[][] A, int k) {
        int[][] C = new int[A.length][A[0].length];
        int i, j;
        try {
            for (i = 0; i < k; i++) {

                for (i = 0; i < A.length; i++) {
                    for (j = 0; j < A[0].length; j++) {
                        C[i][j] = 0;
                    }
                }
            }
            for (i = 0; i < A.length; i++) {
                for (j = 0; j < A.length; j++) {
                    for (k = 0; k < A[0].length; k++) {
                        C[i][j] += (A[i][k] * A[k][j]);

                    }

                }
            }


        } catch (ArrayStoreException e) {
            System.out.println("Data Type Mismatch" + e);
        }

        return C;
    }
}