package Lab2;

/**
 * Author: Cesar Valenzuela
 * Date: 6/25/2017
 * Course: CS 2401
 * Assignment:
 * Instructor: Julio C. Urenda
 * T.A: Isaac Torres
 */
public class Valenzuela2 {
    public static void main(String[] args) {

    }

    /**
     * returns the sum between two arrays of equal dimensions
     *
     * @param A corresponds to array which you want to sum
     * @param B corresponds to the other array which you want to sum with A
     * @return returns the sum of A and B
     */
    public static int[][] sum(int[][] A, int[][] B) {
        int[][] tmpSum = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    tmpSum[i][j] = A[i][j] + B[i][j];
                }
            }
            return tmpSum;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * takes two arrays and calculates the difference between their values
     *
     * @param A corresponds to the array to be subtracted from
     * @param B corresponds to the array you are subtracting with
     * @return returns the difference between two arrays
     */
    public static int[][] difference(int[][] A, int[][] B) {
        int[][] tmpDiff = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    tmpDiff[i][j] = A[i][j] - B[i][j];
                }
            }
            return tmpDiff;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * takes an array and an integer and multiplies each value within the array by that integer
     *
     * @param A corresponds to the array which will be multiplied
     * @param K corresponds to the integer that will multiply each value within the array
     * @return returns the product of an array by an integer
     */
    public static int[][] intMultiplication(int[][] A, int K) {
        int[][] intMultArr = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    intMultArr[i][j] = A[i][j] * K;
                }
            }
            return intMultArr;
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    /**
     * takes two arrays of differing dimensions and multiplies them to produce one array
     *
     * @param A corresponds to array to be multiplied
     * @param B corresponds to array to be multiplied
     * @return returns the product of two arrays
     */
    public static int[][] matrixProduct(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return C;
    }

    /**
     * takes one array and flips it over its diagonal
     *
     * @param A corresponds to the array to be flipped
     * @return returns the flipped array
     */
    public static int[][] transpose(int[][] A) {
        int[][] trArr = new int[A[0].length][A.length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    trArr[j][i] = A[i][j];
                }
            }
            return trArr;
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    /**
     * checks to see if an array is symmetric to its transpose array
     *
     * @param A corresponds to the array to be checked
     * @return returns true if it is symmetric and false if it is not
     */
    public static Boolean isSymmetric(int[][] A) {
        int[][] compTr = transpose(A);
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == compTr[i][j]) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return null;
    }

    /**
     * takes an array and raises it to the power of the integer
     *
     * @param A corresponds to array
     * @param p corresponds to integer by which the power of the array will be raised to
     * @return returns the product of the array raised to the integer power
     */
    public static int[][] pow(int[][] A, int p) {
        int[][] powArr = A.clone();
        try {
            for (int i = 0; i < p - 1; i++) {
                powArr = matrixProduct(powArr, A);
            }
            return powArr;
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }
}
