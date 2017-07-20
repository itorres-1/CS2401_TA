package Lab2;

import java.util.*;
import java.io.*;

/**
 Author: Imani Martin
 Date: June 26, 17
 Course: 2401
 Assignment: Lab 2
 Instructor: Urenda, Julio
 */

public class Martin2 {

    //-5 correctness not naming signatures correctly as asked: multiplication/product
    //TODO these are not javadoc comments whatsoever

    //Method 1: two (m x n) matrices A and B that returns A + B
    public static int[][] sum(int[][] A, int[][] B) throws ArrayIndexOutOfBoundsException {
        int[][] add = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                add[i][j] = A[i][j] + B[i][j];
            }
        }

        return add;
    }


    //Method 2: return the difference of two arrays
    public static int[][] difference(int[][] A, int[][] B) throws ArrayIndexOutOfBoundsException {
        int[][] subtract = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                subtract[i][j] = A[i][j] - B[i][j];
            }
        }

        return subtract;
    }


    //Method 3: With matrix A, return the product of scalar (integer) rA
    public static int[][] intMultiplication(int[][] A, int r) throws ArrayIndexOutOfBoundsException {
        int[][] multi = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                multi[i][j] = r * A[i][j];
            }
        }

        return multi;
    }


    //Method 4: Given matrix (m x n) A and matrix (n x p) B, return the product of AB
    public static int[][] matrixProduct(int[][] A, int[][] B) throws ArrayIndexOutOfBoundsException{
        int[][] product = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                for (int num = 0; B[0].length < A[0].length; num++) {
                    product[i][j] = product[i][j] + product[i][num] * B[num][j];
                }
            }
        }

        return product;
    }


    //Method 5: Given matrix (m x n) A, return its transpose A^T
    public static int[][] transpose(int[][] A) throws ArrayIndexOutOfBoundsException{
        int[][] transpo = new int[A.length][A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                transpo[j][i] = A[i][j];
            }
        }

        return transpo;
    }


    //Method 6: Verify that (n x n) matrix A is symmetric
    public static Boolean isSymmetric(int[][] A) throws ArrayIndexOutOfBoundsException{
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][j] != A[j][i]) {
                    System.out.println("Not Symmetrical.");
                    return false;
                }
            }
        }

        return true;
    }


    //Method 7: Given (n x n) matrix A and a positive integer k computes A^k
    public static int[][] pow(int[][] A, int k) throws ArrayIndexOutOfBoundsException{
        int[][] power = new int[A.length][A[0].length];

        for (int i = 1; i < k; i++){
            power = matrixProduct(power, A);
        }

        return power;

    }
}
