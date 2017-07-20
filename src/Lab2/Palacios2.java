package Lab2;

/**
 * Created by Mariel Palacios on 6/26/2017
 * CS2401
 * Dr. Julio Urenda
 * TA: Isaac Torres
 * Lab 2 - Matrices
 */

import java.io.IOException;
import java.lang.NullPointerException;
import java.lang.ArrayIndexOutOfBoundsException;

public class Palacios2 {

    //This is the main method I used to test my code.
 /*  public static void main(String[] args) throws IOException{
        //Define Arrays (Matrices)
        int[][] A = {{1,4}, {4,1}};
        int[][] B = {{1, 0}, {3, 4}};

        //1.SUM
        System.out.println("Sum of Matrices: ");
        printArray(sum(A, B));
        System.out.println();

        //2. Difference
        System.out.println("Difference of Matrices: ");
        printArray(difference(A, B));
        System.out.println();

        //3. Integer mult
        System.out.println("Integer multiplication: ");
        //set integer to multiply by
        int k = 2;
        printArray(intMultiplication(A, k));
        System.out.println();

        //4. Product A*B
        System.out.println("Product of Matrices: ");
        printArray(matrixProduct(A, B));
        System.out.println();

        //5.Transpose
        System.out.println("Transpose: ");
        printArray(transpose(B));
        System.out.println();

        //6.Symmetry
        System.out.println("Symmetric? ");
        System.out.println(isSymmetric(A));
        System.out.println();

        //7.Power
        System.out.println("Power: ");
        //set integer to multiply by
        int x =  2;
        printArray(pow(A,x));
        System.out.println();

    }
*/
    /**
     * sum is a method that adds two matrices of equal size.
     * @param A is a double array
     * @param B is also a double array
     * @return the sum of arrays A and B
     */
    //1.SUM A+B
    public static int[][] sum(int[][] A, int[][] B) {
        try {
                int[][] sumAB = new int[A.length][A[0].length];
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A[0].length; j++) {
                        sumAB[i][j] = A[i][j] + B[i][j];
                    }
                }
                return sumAB;
        }
        catch (NullPointerException e) {
            return null;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

    }

    /**
     * difference is a method that subtracts two matrices of equal size.
     * @param A is a double array
     * @param B is also a double array
     * @return the difference of arrays A and B
     */
    //2.DIFFERENCE A-B
    public static int[][] difference(int[][] A, int[][] B){
        try {
            int[][] difAB = new int[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    difAB[i][j] = A[i][j] - B[i][j];
                }
            }
            return difAB;
        }
        catch (NullPointerException e){
            return null;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * intMultiplication is a method that multiplies a matrix by a coefficient.
     * @param A is a double array
     * @param B is an integer by which A is multiplied
     * @return the array that represents the multiplication of A and B
     */

    //3.SCALAR (int) MULTIPLICATION r*A
    public static int[][] intMultiplication(int[][] A, int B) {
        int[][] mult = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                mult[i][j] = B * A[i][j];
            }
        }
        return mult;
    }

    /**
     * marixProduct is a method that multiplies two matrices of compatible sizes.
     * @param A is a double array
     * @param B is also a double array
     * @return the product of matrices A and B
     */

    //4.PRODUCT A*B
    public static int[][] matrixProduct(int[][] A, int[][] B) {
        if (A[0].length != B.length){
            return null;
        }
        int[][] productAB = new int[A.length][B[0].length];
        for (int i = 0; i < productAB.length; i++) {
            for (int j = 0; j < productAB[0].length; j++) {
                for (int x = 0; x< A[0].length; x++){
                    productAB[i][j] += (A[i][x] * B[x][j]);
                }
            }
        }
        return productAB;
    }

    /**
     * transpose is a method that transposes a given matrix
     * @param A is a double array
     * @return the transpose of A
     */

    //5.TRANSPOSE A^T
    public static int[][] transpose(int[][] A) {
        int[][] trans = new int[A[0].length][A.length]; //switch dimensions
        for (int i = 0; i <A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                trans[i][j] = A[j][i];
            }
        }
        return trans;
    }

    /**
     * isSymmetric is a method that tells whether a matrix is symmetric or not
     * @param A is a double array
     * @return true if A is symmetric, false otherwise.
     */

    //6.SYMMETRY
    public static Boolean isSymmetric(int[][] A){
        if (A.length != A[0].length) {  // must be a square matrix
            return false;
        }
        for (int i = 0; i <A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] != A[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * pow is a method that computes the power of a matrix
     * @param A is a double array
     * @param k is the value of the power to which A will be raised to.
     * @return A raised to the k power (A^k)
     */

    //7.POWER
    public static int[][] pow(int[][] A, int k) {
        try {
            //if (A.length != A[0].length){      //if matrix is not n x n (square matrix)
            //    return null;
            // }
            int[][] matrixProduct = A.clone();
            for (int i = 0; i < k - 1; i++) {
                matrixProduct = matrixProduct(A, matrixProduct); // call matrixProduct method
            }
            return matrixProduct;
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * print is a method used to print the arrays returned by the other methods
     * @param B is a double array
     */

    //PRINT
    public static void printArray(int[][] B){
       /* if (B == null) {
            System.out.println("Error");
        } */
       try{
           for (int i = 0; i < B.length; i++) {
               for (int j = 0; j < B[0].length; j++) {
                   System.out.print(B[i][j] + " ");
               }
               System.out.println();
           }
       }
       catch (NullPointerException e){
           System.out.println("Error");
       }
    }

    /*EXTRA CREDIT
    //8.COMPUTE e^N
    //9.DETERMINANT
    //10. Solve Ax=b using Cramer's Rule*/
}