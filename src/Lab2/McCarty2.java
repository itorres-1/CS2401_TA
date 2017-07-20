/**
 * Created by Felton McCarty on 6/23/2017.
 * CS 2401 summer 2017 Lab2
 */
package Lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class McCarty2 {

    public static void main(String[] args) {
        int[][] Matrix1 = {{1, 2}, {3, 2}, {2, 1}};
        int[][] Matrix2;
        //  Matrix1= matrix();
        // Matrix2= matrix();
        //sum(Matrix1,Matrix2);
        int[][] sumarray = sum(Matrix1, Matrix1);
        for (int i = 0; i < sumarray.length; i++) {
            System.out.println();
            for (int j = 0; j < sumarray[i].length; j++) {
                System.out.print(sumarray[i][j]);
            }
        }
    }


    //this method is meant to add to double arrays and return a new array composed of the two
    public static int[][] sum(int[][] A, int[][] B) {
        int[][] sumarray = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                sumarray[i][j] = A[i][j] + B[i][j];
            }
        }
        return sumarray;
    }

    // this method is meant to return an array that subtracts one from the other
    public static int[][] difference(int[][] A, int[][] B) {
        int[][] sumarray = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                sumarray[i][j] = A[i][j] - B[i][j];
            }
        }
        return sumarray;
    }

    // product of a input integer multiplying each element in an array//
    public static int[][] intMultiplication(int[][] A, int B) {
        int[][] sumarray = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                sumarray[i][j] = A[i][j] * B;
            }
        }
        return sumarray;
    }

    // this method only returns a product of  array 2-3
    public static int[][] matrixProduct(int[][] A, int[][] B) {
        int[][] productarray = new int[A.length][B[0].length];
        int k = 0;
        if (A.length != B[0].length)

            for (int i = 0; i < A.length; i++) {
                k = 0;
                for (int j = 0; j < B[0].length; j++) {
                    productarray[i][j] = A[j][i] * B[k][i];// i and j increments are reversed  only works for these small arrays , id have to change it for any kind of matrix
                    k++;
                }
            }
        return productarray;
    }

    public static int[][] transpose(int[][] A) {
        int[][] transArray = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                transArray[j][i] = A[i][j];
            }
        }


        return transArray;
    }

    public static boolean areEqual(int[][] A, int[][] B){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }

    public static Boolean isSymmetric(int[][] A) {
        return areEqual(A, transpose(A));
    }

    public static int[][] pow(int[][] A, int k) {
        if ((k == 0) || (k == 1))
            return A;
        else {
            int powerint = 2;
            int[][] sumarray = new int[A.length][A[0].length];


            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    Double grabDouble = Math.pow(A[i][j], k);
                    int turnInt = grabDouble.intValue();
                    sumarray[i][j] = turnInt;
                }
            }
            return sumarray;
        }
    }

   /* public static int[][] sum(int[][] A, int[][] B)
    public static int[][] difference(int[][] A, int[][] B)
    public static int[][] intMultiplication(int[][] A, int B)        (recall I said use an int instead of a float which more accurately represents a scalar)
    public static int[][] matrixProduct(int[][] A, int[][] B)
    public static int[][] transpose(int[][] A)
    public static Boolean isSymmetric(int[][] A)                      NOTE: use Boolean (capitalized) instead of boolean!
    public static int[][] pow(int[][] A, int k)
    // methods

    /*public static int[][] matrix() {
        boolean acceptfile = false;

        while (acceptfile == false) {//C:\Users\Onyx\IdeaProjects\CS200\src

            try {
                Scanner scar = new Scanner(System.in);
                System.out.println("Enter File name");
                FileReader red = new FileReader(scar.nextLine());
                BufferedReader r = new BufferedReader(red);
                int [][] mat= new int[r.readLine().length()][r.readLine().length()];
                if (r.readLine() != null) {
                    int lengthofline = r.readLine().length();
                    mat = new int[lengthofline][lengthofline];
                    for (int i = 0; i < lengthofline; i++) {
                        for (int j = 0; j < mat[i].length; j++) {
                            mat[i][j] = r.read();
                        }
                    }
                    acceptfile = true;
                }




            }


            catch (FileNotFoundException e) {
                System.out.println("Select a file:");
                matrix();
            }
            catch (IOException a) {
                System.out.println("check file for wrong input");
                matrix();
            }

        return mat;
    }*/
    //closes class
}
