package Lab2;

// Joshua Boatright
// Lab2
// CS 2401 - Dr. Urenda - TA: Isaac Torres
// Date of last modification: 06/28/2017

// Purpose of program: This program gives the user access to multiple methods to manipulate matrices

public class Boatright2 {

  /**
   * This method takes two m × n matrices, A and B, and returns their sum.
   * @param A First matrix
   * @param B Second matrix
   * @return Matrix of sum
   */
  public static int[][] sum(int[][] A, int[][] B) {
    int[][] C;
    try {
      C = new int[A.length][A[0].length];
      // Loop to add elements of each array
      for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[0].length; j++) {
          C[i][j] = A[i][j] + B[i][j];
        }
      }
    } catch (NullPointerException e) { // Catches e if null array is passed as parameter
      return null;
    } catch (ArrayIndexOutOfBoundsException e) { // Catches e if both matrices are not m x n
      return null;
    }
    return C;
  }

  /**
   * This method takes two m x n matrices, and returns their difference.
   * @param A First matrix
   * @param B Second matrix
   * @return Matrix of difference
   */
  public static int[][] difference(int[][] A, int[][] B) {
    int[][] C;
    try {
      C = new int[A.length][A[0].length];
      // Loop to calculate difference of elements in each array
      for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[0].length; j++) {
          C[i][j] = A[i][j] - B[i][j];
        }
      }
    } catch (NullPointerException e) { // Catches e if null array is passed as parameter
      return null;
    } catch (ArrayIndexOutOfBoundsException e) { // Catches e if both matrices are not m x n
      return null;
    }
    return C;
  }

  /**
   * This method takes an m × n matrix and scalar, and returns their product.
   * @param A m x n matrix
   * @param B Scalar value
   * @return Matrix of product
   */
  public static int[][] intMultiplication(int[][] A, int B) {
    int[][] C;
    try {
      C = new int[A.length][A[0].length];
      // Loop to multiply elements of array
      for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[0].length; j++) {
          C[i][j] = A[i][j] * B;
        }
      }
    } catch (NullPointerException e) { // Catches e if null array or int is passed as parameter
      return null;
    }
    return C;
  }

  /**
   * This method takes an m×n matrix, and an n×p matrix, then returns their product.
   * @param A m x n matrix
   * @param B n x p matrix
   * @return Matrix of product
   */
  public static int[][] matrixProduct(int[][] A, int[][] B) {
    int[][] C;
    try {
      C = new int[A.length][B[0].length];
      // Loop to multiply elements of each array
      for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < B[0].length; j++) {
          for (int k = 0; k < A[0].length; k++) {
            C[i][j] += A[i][k] * B[k][j]; // Adds products of elements from row A * column B, assigns to elements of C
          }
        }
      }
    } catch (NullPointerException e) { // Catches e if null array is passed as parameter
      return null;
    } catch (ArrayIndexOutOfBoundsException e) { // Catches e if jagged matrix is passed
      return null;
    }
    return C;
  }

  /**
   * This method takes an m x n matrix, and returns its transpose.
   * @param A Given matrix
   * @return Transpose of matrix
   */
  public static int[][] transpose(int[][] A) {
    int[][] B;
    try {
      B = new int[A[0].length][A.length];
      // Loop to transpose matrix
      for (int i = 0; i < A[0].length; i++) {
        for (int j = 0; j < A.length; j++) {
          B[i][j] = A[j][i];
        }
      }
    } catch (NullPointerException e) { // Catches e if null array is passed as parameter
      return null;
    }
    return B;
  }

  /**
   * This method checks whether or not a matrix, and its transpose, are symmetric.
   * @param A Given matrix
   * @return True if matrices are symmetric, otherwise false
   */
  public static Boolean isSymmetric(int[][] A) {
    try {
      int[][] B = transpose(A);
      for (int i = 0; i < A.length; i++) { // Loop checks if all elements are the same
        for (int j = 0; j < A[0].length; j++) { // Returns false if any are not
          if (A[i][j] != B[i][j]) {
            return false;
          }
        }
      }
    } catch (NullPointerException e) { // Catches e if null array is passed as parameter
      return null;
      // Returns false if transpose has different dimensions,
      // and therefore is not symmetric
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
    return true;
  }

  /**
   * This method takes an n x n matrix, and an exponent, computes the exponential matrix.
   * @param A n x n matrix
   * @param k exponent
   * @return exponential matrix
   */
  public static int[][] pow(int[][] A, int k) {
    int[][] B;
    try {
      // Throws e if exponent is negative
      if (k < 0) {
        throw new IllegalArgumentException("K must be a positive integer."); // If exponent is negative
      }

      // Declare new array to store exponential matrix
      B = new int[A.length][A[0].length];

      // Returns array of zero values if exponent is 0
      if (k == 0) {
        return B;
      }

      // Duplicate original array, so as to not modify when calling matrixProduct method with k>2
      for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[0].length; j++) {
          B[i][j] = A[i][j];
        }
      }

      // Loop to multiply matrix exponentially (calls matrixProduct)
      for (int i = 0; i < k; i++) {
        B = matrixProduct(B, A);
      }

    } catch (NullPointerException e) { // Catches e if null parameter passed
      return null;
    } catch (IllegalArgumentException e) { // Catches above e if exponent is negative
      return null;
    }
    return B;
  }

}
