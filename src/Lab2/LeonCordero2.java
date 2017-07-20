package Lab2;

import java.util.*;
import java.io.*;

public class LeonCordero2 {
/*  public static void main(String[] args) {
        try {
            int[][] A = {{1, 2, 3}, {4, 5, 6}};
            int[][] B = {{-1, 4, 7}, {9, 8, 2}};
            int[][] C = {{2, 1}, {5, 3}, {4, 7}};
            int[][] D = {{1, 2}, {3, 4}};
            int[][] E = {{1, 7, 3}, {7, 4, -5}, {3, -5, 6}};
            int z = 3;
            Boolean result;

            int[][] d = sum(A, B);
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d[i].length; j++) {
                    System.out.print(d[i][j] + " ");
                }
            }
            System.out.println();

            d = difference(A, B);
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d[i].length; j++) {
                    System.out.print(d[i][j] + " ");
                }
            }
            System.out.println();

            d = intMultiplication(A, z);
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d[i].length; j++) {
                    System.out.print(d[i][j] + " ");
                }
            }
            System.out.println();

            d = matrixProduct(A, C);
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d[i].length; j++) {
                    System.out.print(d[i][j] + " ");
                }
            }
            System.out.println();

            d = transpose(A);
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d[i].length; j++) {
                    System.out.print(d[i][j] + " ");
                }
            }
            System.out.println();

            result = isSymmetric(E);
            System.out.println(result);
        }
        catch(NullPointerException e) {
        }
    }
*/

    /**
     * sum receives two 2D matrices A and B, determines if they are compatible for addition, then calculates
     * the sum of the matrices and returns the sum. Returns null if an error occurs or if matrices are incompatible.
     * @param A (2D array)
     * @param B (2D array)
     * @return result (2D array)
     */
    public static int[][] sum(int[][] A, int[][] B) {
        try {
            if(A.length != B.length || A[0].length != B[0].length || A == null || B == null) {
                throw new ArrayIndexOutOfBoundsException("Input array dimensions do not match or an array is empty.");
            }
                int[][] sum = new int[A.length][];

                for(int i = 0; i < A.length; i++) {
                    sum[i] = new int[A[i].length];
                    for(int j = 0; j < A[i].length; j++) {
                        sum[i][j] = Math.addExact(A[i][j], B[i][j]);
                    }
                }
                return sum;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        catch(ArithmeticException n) {
            System.out.println(n.getMessage());
            return null;
        }
    }

    /**
     * difference receives two 2D matrices A and B, determines whether they are compatible for finding their difference,
     * then calculates the difference between them (A - B) and returns the difference. Returns null if an error occurs
     * or if the matrices are incompatible.
     * @param A (2D Array)
     * @param B (2D Array)
     * @return diff (2D Array)
     */
    public static int[][] difference(int[][]A, int[][] B) {
        try {
            if(A.length != B.length || A[0].length != B[0].length || A == null || B == null) {
                throw new ArrayIndexOutOfBoundsException("Input array dimensions do not match or an array is empty.");
            }
            int[][] diff = new int[A.length][];

            for(int i = 0; i < A.length; i++) {
                diff[i] = new int[A[i].length];
                for(int j = 0; j < A[i].length; j++) {
                    diff[i][j] = Math.subtractExact(A[i][j], B[i][j]);
                }
            }
            return diff;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        catch(ArithmeticException n) {
            System.out.println(n.getMessage());
            return null;
        }
    }

    /**
     * intMultiplication receives an integer k and a 2D matrix A, multiplies A by k, and returns the product. Returns
     * null if the matrix is empty or if an error occurs.
     * @param A (2D Array)
     * @param B (integer)
     * @return product (2D Array)
     */
    public static int[][] intMultiplication(int[][] A, int B) {
        try {
            if(A == null) {
                throw new ArrayIndexOutOfBoundsException("The array is empty.");
            }
            int[][] product = new int[A.length][];

            for(int i = 0; i < A.length; i++) {
                product[i] = new int[A[i].length];
                for(int j = 0; j < A[i].length; j++) {
                    product[i][j] = Math.multiplyExact(A[i][j], B);
                }
            }
            return product;
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
            return null;
        }
        catch(ArrayIndexOutOfBoundsException n) {
            System.out.println(n.getMessage());
            return null;
        }
    }

    /**
     * matrixProduct receives two 2D matrices A and B, checks if they are compatible for multiplication, multiplies
     * them, and returns their product. Returns null if the matrices are incompatible or if an error occurs.
     * @param A (2D Array)
     * @param B (2D Array)
     * @return mProduct (2D Array)
     */
    public static int[][] matrixProduct(int[][] A, int[][] B) {
        try {
            if(A[0].length != B.length || A == null || B == null) {
                throw new ArrayIndexOutOfBoundsException("The columns of A do not match the rows of B or an" +
                        " array is empty.");
            }
            int[][] mProduct = new int[A.length][B[0].length];

            for(int i = 0; i < A.length; i++) {
                for(int j = 0; j < B[0].length; j++) {
                    for(int z = 0; z < A[0].length; z++) {
                        mProduct[i][j] = Math.addExact(mProduct[i][j], Math.multiplyExact(A[i][z], B[z][j]));
                    }
                }
            }
            return mProduct;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        catch(ArithmeticException n) {
            System.out.println(n.getMessage());
            return null;
        }
    }

    /**
     * transpose receives a 2D matrix and computes and returns its transpose. Returns null if the matrix is empty or if
     * an error occurs.
     * @param A (2D Array)
     * @return transpose (2D Array)
     */
    public static int[][] transpose(int[][] A) {
        try {
            if(A == null) {
                throw new ArrayIndexOutOfBoundsException("Array is empty. ");
            }
            int[][] transpose = new int[A[0].length][A.length];

            for(int i = 0; i < A.length; i++) {
                for(int j = 0; j < A[i].length; j++) {
                    transpose[j][i] = A[i][j];
                }
            }
            return transpose;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * isSymmetric takes in a 2D array, determines whether it is [n x n], then calls on transpose and compares the
     * transpose to the original array, A, and returns whether A is symmetric or not. Returns null if the matrix is not
     * in [n x n] format, if it is empty, or if an error occurs.
     * @param A (2D Array)
     * @return Boolean
     */
    public static Boolean isSymmetric(int[][] A) {
        try {
            if(A.length != A[0].length || A == null) {
                throw new ArrayIndexOutOfBoundsException("Not an [n x n] matrix or array is empty.");
            }
            int[][] temp = transpose(A);

            for(int i = 0; i < A.length; i++) {
                for(int j = 0; j < A[0].length; j++) {
                    if(A[i][j] != temp[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * pow receives a 2D matrix A and an integer k, determines whether the integer k is greater than 1, determines if
     * A is an [n x n] matrix, then multiplies A by itself k times. Returns null if the matrix is not in [n x n] format,
     * is empty, integer k is lower than 1, or if an error occurs.
     * @param A (2D Array)
     * @param k (integer)
     * @return powerArray (2D Array)
     */
    public static int[][] pow(int[][] A, int k) {
        try {
            if(k < 1) {
                throw new NumberFormatException("Power is invalid.");
            }
            else if(A.length != A[0].length || A == null) {
                throw new ArrayIndexOutOfBoundsException("Not an [n x n] matrix or array is empty.");
            }

            int[][] powerArray = A;
            for (int i = 1; i < k; i++) {
                powerArray = matrixProduct(A, powerArray);
            }
            return powerArray;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        catch(NumberFormatException m) {
            System.out.println(m.getMessage());
            return null;
        }
    }
}
