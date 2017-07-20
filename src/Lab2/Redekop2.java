//package Lab2;
//
///**
// * Project: Lab 2
// * Name: Jessica Redekop
// * Due: Monday June 26, 2017
// * Professor: Dr. Urenda
// * T.A.: Isaac Torres
// */
//
//import java.io.*;
//import java.util.*;
//import java.lang.NullPointerException;
//
//public class Redekop2{
//
//    //TODO Javadoc comments
//
//    public static void main(String[] args){
//
//        int[][] A = {{1, 2, 3},{4, 5, 6}};
//        int[][] B = {{2, 1},{5, 3},{4, 7},{8, 2}};
//
//        print(pow(A,0));
//
//    }
//
//    /**
//    *This method computes the sum of two matricies.
//    *@param int[][] A This method takes an array of type int.
//    *@param int[][] B This method takes an array of type int.
//    *@return int[][] This method returns the sum of both matricies.
//    */
//    public static int[][] sum(int[][] A, int[][] B){
//
//        try{
//            if(A.length != B.length && A[0].length != B[0].length)
//                throw new Exception("Matricies aren't the same size.");
//
//            int[][] sumArray = new int[A.length][A[0].length];
//
//            for (int i = 0; i < A.length; i++){
//                for (int j = 0; j < A[i].length; j++)
//                    sumArray[i][j] = A[i][j]+B[i][j];
//            }
//            return sumArray;
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//    /**
//    *This method computes the difference of two matricies.
//    *@param int[][] A This method takes an array of type int.
//    *@param int[][] B This method takes an array of type int.
//    *@return int[][] This method returns the difference of both matricies.
//    */
//    public static int[][] difference(int[][] A, int[][] B){ //same size exception
//
//        try{
//            if(A.length != B.length && A[0].length != B[0].length)
//                throw new Exception("Matricies aren't the same size.");
//
//            int[][] differenceArray = new int[A.length][A[0].length];
//
//            for (int i = 0; i < A.length; i++){
//                for (int j = 0; j < A[i].length; j++)
//                    differenceArray[i][j] = A[i][j]-B[i][j];
//            }
//            return differenceArray;
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//
//    /**
//    *This method computes the scalar multiplication of a matrix.
//    *@param int[][] A This method takes an array of type int.
//    *@param int r This mathod takes a scalar.
//    *@return int[][] This method returns the scalar multiplication of a matrix.
//    */
//    public static int[][] intMultiplication(int[][] A, int r){
//
//        int[][] scalarArray = new int[A.length][A[0].length];
//
//        for (int i = 0; i < A.length; i++){
//            for (int j = 0; j < A[i].length; j++)
//                scalarArray[i][j] = A[i][j] * r;
//        }
//
//        return scalarArray;
//    }
//
//    /**
//    *This method computes the product of two matricies.
//    *@param int[][] A This method takes an array of type int.
//    *@param int[][] B This method takes an array of type int.
//    *@return int[][] This method returns the product of both matricies.
//    */
//    public static int[][] matrixProduct(int[][] A, int[][] B){ //A[0].length and B.length should be equal, or opposite.
//
//        try{
//            if(A[0].length != B.length || A.length != B[0].length)
//                throw new Exception("Matricies aren't the same size.");
//
//            int[][] productArray = new int[A.length][B[0].length];
//
//            for(int i = 0; i < A.length; i++){
//                for(int k = 0; k < A.length; k++){
//                    for(int j = 0; j < B.length; j++)
//                        productArray[i][k] = productArray[i][k] + (A[i][j] * B[j][k]);
//                }
//            }
//            return productArray;
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//        finally{
//            return null;
//        }
//    }
//
//    /**
//    *This method computes the transpose of a matrix
//    *@param int[][] A This method takes an array of type int.
//    *@return int[][] This method returns the transpose of a matrix.
//    */
//    public static int[][] transpose(int[][] A){
//
//        int[][] transposeArray = new int[A[0].length][A.length];
//
//        for(int i = 0; i < A[0].length; i++){
//            for(int j = 0; j < A.length; j++)
//                transposeArray[i][j] = A[j][i];
//        }
//
//        return transposeArray;
//    }
//
//    /**
//    *This method maes sure a matrix is symmetric
//    *@param int[][] A This method takes an array of type int.
//    *@return boolean This method returns true if the matrix is symmetric and false otherwise.
//    */
//    public static Boolean isSymmetric(int[][] A){
//
//        if(A == transpose(A))
//            return true;
//
//        return false;
//    }
//
//    /**
//    *This method takes an array and an integer, k, as its parameters.
//    *It makes a temporary array to help in composition which wil contain
//    *@param int[][] A This method takes an array of type int to compute itself to a power.
//    *@param k This method takes an integer as the power for an array to be mulitplied to.
//    *@return temp This method returns an array of tpe int that has been updated from the original array.
//    */
//    public static int[][] pow(int[][] A, int k) {
//
//        try{
//            if(k < 1)
//                return null;
//            if(A.length != A[0].length)
//                throw new Exception("Matrix must be n*n length");
//
//            int[][] temp = new int[A.length][A[0].length]; //creates a new temporary array to be updated
//            //temp = A; //sets the array to itself or its inverse if negative power
//
//            if (k == 1) return A; //if power is 1 or -1, it will return itself or its inverse accordingly
//
//            else{ //else will be a positive power
//                for(int i = 1; i < k; i++) //positive power loops
//                    temp = matrixProduct(A, temp); //temporary array will be updated as necesary
//            }
//            return temp; //returns updated array
//        }
//        catch(Exception e){
//            System.out.print(e.getMessage());
//            return null;
//        }
//
//    }
//
//    /**
//    *This maethod prints out the input array
//    *@param A This methos takes an integer array as its parameter
//    */
//    public static void print(int[][] A){ //arrays would have already gone through exceptions and should be correct
//
//        for(int i = 0; i < A.length; i++){ //will go through each row
//            System.out.println();//array visualization
//            for(int j = 0; j < A[i].length; j++) //prints each column on the row
//                System.out.print(" " + A[i][j]); //prints every entry of array
//        }
//        System.out.println();//array visualization
//    }
//
//
//}