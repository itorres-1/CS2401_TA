package Lab2;
/**
 Author: Salas Jaime
 Date: June 26, 2017
 Course: 2401
 Assignment: Lab 2
 Instructor: Urenda, Julio
 */

import java.util.*;
import java.io.*;

    public class Salas2 {

    //First method (addition)
    public static int[][] sum(int[][] A, int[][] B) {

        int m = A.length;
        int n = A[0].length;

        int[][] sum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = A[i][j] + B[i][j];
            }
        }
        return sum;
    }

    //second method (Subtraction)
    public static int[][] difference(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;

        int[][] difference = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                difference[i][j] = A[i][j] - B[i][j];
            }
        }
        return difference;
    }

    //Third method multiplication
    public static int[][] intMultiplication(int[][] A, int r) {
        int m = A.length;
        int n = A[0].length;

        int[][] matrixResult = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixResult[i][j] = r * A[i][j];
            }
        }
        return matrixResult;

    }

    // Fourth method matrix Product
    public static int[][] matrixProduct(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] AB = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; p < n; k++) {

                    AB[i][j] = AB[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        return AB;
    }

    // Fifth method transpose
    public static int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] trans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                trans[j][i] = A[i][j];
            }
        }
        return trans;
    }

    //Sixth method Symmetric
    public static Boolean isSymmetric(int[][] A) {
        int m = A.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][j]!= A[j][i]) {
                    System.out.println("It is not symmetrical");
                    return false;
                }
            }
        }
        return true;
    }

    //seventh method Pow
    public static int[][] pow(int[][] A, int k) {
        int m = A.length;
        int n = A[0].length;

        int f[][] = new int [m][n];

        for (int i =0;i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = (int)Math.pow(A[i][j],k);
            }
        }
        return f;
    }
    }
