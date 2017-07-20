package Lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

//Robert Noah Wiggs, Summer CS2401
//June 26th, 2017

public class Wiggs2 {

    //TODO Please follow naming convention! Wiggs2!!! IT's NOT HARD!!!!



    /**
     * This main simply calls all the methods and prints their outputs.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("4 two-dimensional matrices/arrays (A,B,C,D) will now be initialized");
       /* System.out.println();
        System.out.println("Matrices A an B must have equal rows and columns.");
        System.out.println("Matrix C must have the same amount of columns as matrix D has rows.");
        */
        int[][] A = {{1,2},{5,3}};
        int[][] B = {{6,3},{7,1}};
        int[][] C = {{2,6,3},{3,4,7},{1,2,3}};
        int[][] D = {{2,4,3},{4,2,1},{3,1,2}};

        System.out.println();

        System.out.println("Provide an integer k for matrix * integer  ");
        int k = scnr.nextInt();

        System.out.println("Sum of A and B");
        int[][] a1 =sum(A, B);
        print(a1);
        System.out.println();
        System.out.println();

        System.out.println("Difference of A and B");
        int[][] a2 = difference(A, B);
        print(a2);
        System.out.println();
        System.out.println();

        System.out.println("Transpose of C");
        int[][] a3 = transpose(C);
        print(a3);
        System.out.println();
        System.out.println();

        System.out.println("D multiplied by k");
        int[][] a4 = intMultiplication(D, k);
        print(a4);
        System.out.println();
        System.out.println();

        System.out.println("Is matrix D symmetric?");
        System.out.println(isSymmetric(D));
        System.out.println();
        System.out.println();

        System.out.println("Matrix product of C and D");
        int[][] a5 = matrixProduct(C,D);
        print(a5);
        System.out.println();

        System.out.println("Matrix B to the power of k");
        int[][] a6 = pow(B,k);
        print(a6);
        System.out.println();

    }




    /**
     * Method "sum" takes two matrices and adds together their i and j values respectively.
     * @param A
     * @param B
     * @return
     */
    public static int[][] sum(int[][] A, int[][] B) {

        try {
            int[][] C = new int[A.length][A[0].length];

            if ((A.length != B.length) && (A[0].length != B[0].length)) throw new RuntimeException("Illegal matrix dimensions");
            if ((A.length == B.length) && (A[0].length == B[0].length)) {

                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A.length; j++) {
                        C[i][j] = A[i][j] + B[i][j];
                    }
                }
                return C;
            }

        } catch (InputMismatchException e) {
        }
        return null;
    }

    /**
     * Method "difference" takes two integer arrays and subtracts their i and j entries respectively.
     * @param A
     * @param B
     * @return
     */
    public static int[][] difference(int[][] A, int[][] B) {

        int[][] C = new int[A.length][A[0].length];
        int i;
        int j;
        try {

            if ((A.length != B.length) && (A[0].length != B[0].length)) throw new RuntimeException("Illegal matrix dimensions");
            if ((A.length == B.length) && (A[0].length == B[0].length)){
                for (i = 0; i < A.length; i++) {
                    for (j = 0; j < A.length; j++) {
                        C[i][j] = A[i][j] - B[i][j];
                    }
                }
                return C;
            } else {
                return null;
            }
        } catch (InputMismatchException e) {

        }
        return null;
    }

    /**
     * Method "transpose"
     * @param A
     * @return
     */
    public static int[][] transpose(int[][] A) {

        int[][] B = new int[A[0].length][A.length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    B[i][j] = A[j][i];
                }
            }
            return B;
        }
        catch (InputMismatchException e){}
        catch(ArrayIndexOutOfBoundsException i){}
        return null;
    }

    public static int[][] intMultiplication(int[][] A, int k) {

        int[][] C = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] * k;
                }
            }
            return C;
        } catch (InputMismatchException e) {
        }
        return null;
    }

    public static Boolean isSymmetric(int[][] A) {
        Boolean t = new Boolean(false);
    try {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == A[j][i]) {
                    t = true;
                } else {
                    t = false;
                    return t;
                }
            }
        }
        return t;
    }
    catch(InputMismatchException e){}
    return null;
    }

    /**
     * "matrixProduct" takes two arrays and multiplies. The # of A's columns must be equal to the # of B's rows. 
     * @param A
     * @param B
     * @return
     */
    public static int[][] matrixProduct(int[][] A, int[][] B){
        int rowA = A.length;
        int colA = A[0].length;
        int rowB = B.length;
        int colB = B[0].length;
        int[][] C = new int[rowA][colB];

        try{
            if (colA != rowB) throw new RuntimeException("Illegal matrix dimensions");{}

            for(int i = 0; i < rowA; i++){
                for(int j = 0; j < colB; j++){
                    for(int k = 0; k < colA; k++){
                        C[i][j] += (A[i][k] * B[k][j]);
                    }
                }
            }
            return C;
        }
        catch(InputMismatchException e){}

        return null;
    }

    /**
     * "pow" array A and array B(which is a copy of A) calls "matrixProduct" k amount of times to multiply A by
     * itself k times.
     * @param A
     * @param k
     * @return
     */
    public static int[][] pow(int[][] A, int k){
        int colA = A[0].length;
        int rowB = A.length;
        int[][] B = A.clone();

    try {
        if(A.length != A[0].length) throw new RuntimeException("Illegal matrix dimensions");
        int i = 1;
        if(i < k) {
            for (i = 1; i < k; i++) {
                B = matrixProduct(A, B);
            }
            return B;
        }
        else{
            return null;
        }
    }
    catch(InputMismatchException e){}
        return null;
    }

    /**
     * "print" is simply used to print arrays in matrix form.
     * @param A
     */
    public static void print(int[][] A){
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    System.out.print(A[i][j] + " ");
                }
                System.out.println();
            }
        }
        catch(NullPointerException e){}
    }


    }







