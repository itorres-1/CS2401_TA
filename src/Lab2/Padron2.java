package Lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Author Cesar Arturo Padron
 * 6/23/2017
 * Professor: Julio Cesar Urenda
 */
public class Padron2 {

    public static int[][] sum(int[][] A,int[][]B) {
        int[][] c = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    c[i][j] = A[i][j] + B[i][j];
                }
            }
            return c;
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    public static int[][] difference(int[][] A, int[][] B){
        int[][] c = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    c[i][j] = A[i][j] - B[i][j];
                }
            }
            return c;
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    public static int[][] intMultiplication(int[][] A, int B){
        for(int i = 0; i< A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                A[i][j] = A[i][j] * B;
            }
        }
        return A;
    }
    public static int[][] matrixProduct(int[][] A, int[][] B){
        try {
            int aRows = A.length;
            int aColumns = A[0].length;
            int bColumns = B[0].length;
            int[][] C = new int[aRows][bColumns];
            for (int i = 0; i < aRows; i++) { // aRow
                for (int j = 0; j < bColumns; j++) { // bColumn
                    for (int k = 0; k < aColumns; k++) { // aColumn
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return C;
        } catch(IllegalArgumentException e){
            return null;
        }
    }
    public static int[][] transpose(int[][] A){
        int[][] c = new int[A[0].length][A.length];
        try {
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    c[i][j] = A[j][i];
                }
            }

            return c;
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    public static Boolean isSymmetric(int[][] A){
        try {
            int[][] b = transpose(A);
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    if (A[i][j] != b[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } catch(NullPointerException e){
            System.out.print(false);
            return null;
        }

    }
    public static int[][] pow(int[][] A, int k){

        int[][] result = A;
        try {
            for (int n = 1; n < k; ++n)
                result = intMultiplication(result, k);
            return result;
        } catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

}
