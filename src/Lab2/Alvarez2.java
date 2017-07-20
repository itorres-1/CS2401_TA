package Lab2;

/**
 * Author: Ricardo Alvarez
 * Assignment: Lab 2
 * Instructor: Julio Urenda
 * T.A.: Isaac Torres
 * Date of Last Modification:
 * Purpose: Find modify 2D arrays by subtraction, addition, multiplication, transposition, etc
 */

import java.io.*;
import java.util.Scanner;
public class Alvarez2 {

    //Javadoc comments are properly formatted but desdcribe the method. I.e. not "multiply by an integer
    // instead: this method takes a 2d int array and an int and returns the two d array where
    //every element is multiplied by the int

    /**
     * Read 2d array from file
     * @return a 2d integer array
     */
    public static int[][] fileReader () {
        Scanner scnr = new Scanner (System.in);
        FileReader fr;
        BufferedReader br;
        FileReader fr2;
        BufferedReader br2;
        Boolean repeat = true;
        String aux;
        int countRows = 0;
        int countColumns = 0;
        while (repeat) {
            System.out.println("Please input the file path: ");
            try {
                aux = scnr.nextLine();
                fr = new FileReader(aux);
                br = new BufferedReader(fr);
                while (br.ready()) {
                    aux = br.readLine();
                    countRows++;
                }
                String[] auxStArray = aux.split(" ");
                countColumns = auxStArray.length;
                int[][] A = new int [countRows][countColumns];
                fr2 = new FileReader(aux);
                br2 = new BufferedReader(fr);
                for (int i=0; i<A.length; i++) {
                    aux = br2.readLine();
                    auxStArray = aux.split(" ");
                    for (int j = 0; j < A[i].length; j++) {
                        A[i][j] = Integer.parseInt(auxStArray[j]);
                    }
                }
                return A;
            }
            catch (FileNotFoundException e1) {
                System.out.println("File path incorrect");
            }
            catch (IOException io1) {
                System.out.println("IO error, please try again.");
            }
        }
        int[][]A = {{0,0},{0,0}};
        return A;
    }

    /**
     * Print 2d arrrays
     * @param A array to be printed
     */
    public static void print2D (int[][] A) {
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A[i].length; j++) {
                    System.out.print(A[i][j] + " ");
            }
        }
        System.out.print("\n");
    }

    /**
     * Sum two integer arrays creating a new one with the result
     * @param A first array to be added
     * @param B second array to be added
     * @return integer array result of the addition
     */
    public static int[][] sum (int[][] A, int[][] B) {
        try {
            if ((A.length == B.length) && (A[0].length == B[0].length)) {
                int[][] outArr = new int[A.length][A[0].length];
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A[i].length; j++) {
                        outArr[i][j] = A[i][j] + B[i][j];
                    }
                }
                return outArr;
            }
            else {
                System.out.println("Your files size don't match. Please try again");
                return null;
            }
        }
        catch (IndexOutOfBoundsException a1) {
            System.out.println("Your arrays don't match in size through the whole 2D.");
        }
        catch (NullPointerException a2) {
            System.out.println("your array contains a null case");
        }
        int[][] outNull = null;
        return outNull;
    }

    /**
     * Subtrac two array B from array A
     * @param A array from which will be subtracted
     * @param B array to be subtracted
     * @return integer array result of the subtraction
     */
    public static int[][] difference (int[][] A, int[][] B) {
          try {
             if ((A.length == B.length) && (A[0].length == B[0].length)) {
                 int[][] outArr = new int[A.length][A[0].length];
                 for (int i = 0; i < A.length; i++) {
                     for (int j = 0; j < A[i].length; j++) {
                         outArr[i][j] = A[i][j] - B[i][j];
                     }
                 }
                 return outArr;
             }
             else {
                 System.out.println("Your files size don't match. Please try again");
                 return null;
             }
          }
          catch (IndexOutOfBoundsException a1) {
              System.out.println("Your arrays don't match in size through the whole 2D.");
          }
          catch (NullPointerException a2) {
              System.out.println("your array contains a null case");
          }
          return null;
    }

    /**
     * Multiply an array by an integer
     * @param A Integer array to be multiplied
     * @param k Integer that will multiply the array
     * @return Integer array product of A*k
     */
    public static int[][] intMultiplication (int[][]A, int k ) {
        try {
            int[][] outArr = new int[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                     outArr[i][j] = k * A[i][j];
                }
            }
        return outArr;
        }
        catch (IndexOutOfBoundsException a1) {
            System.out.println("Your arrays don't match in size through the whole 2D.");
        }
        catch (NullPointerException a2) {
            System.out.println("your array contains a null case");
        }

        int[][] outNull = null;
        return outNull;
    }

    /**
     * Multiply two 2d integer arrays
     * @param A Integer array to be multiplied
     * @param B Integer array to be multiplied
     * @return new integer array AB
     */
    public static int[][] matrixProduct (int[][] A, int[][] B) {
        try {
            if (A[0].length == B.length) {
                int[][] outArray = new int[A.length][B[0].length];
                for (int i = 0; i < outArray.length; i++) {
                    for (int j = 0; j < outArray[i].length; j++) {
                        for (int k = 0; k < A[0].length; k++) {
                            outArray[i][j] = outArray[i][j] + (A[i][k] * B[k][j]);
                        }
                    }
                }
                return outArray;
            }
            else {
                System.out.println("Your arryas don't match in size for multiplication");
                return null;
            }
        }
        catch (IndexOutOfBoundsException a1) {
            System.out.println("Your arrays don't match in size through the whole 2D.");
        }
        catch (NullPointerException a2) {
            System.out.println("your array contains a null case");
        }
        return null;
    }

    /**
     * Transposes an array to At form
     * @param A Integer array to be transposed
     * @return new integer array product of the transposition
     */
    public static int[][] transpose (int[][] A) {
        try {
            int[][] output = new int[A[0].length][A.length];
            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < output[i].length; j++) {
                    output[i][j] = A[j][i];
                }
            }
            return output;
        }
        catch (IndexOutOfBoundsException a1) {
            System.out.println("Your arrays don't match in size through the whole 2D.");
        }
        catch (NullPointerException a2) {
            System.out.println("your array contains a null case");
        }
        return null;
    }

    /**
     * Checks if the array is symmetric
     * @param A Integer array to be reviewed for symmetry
     * @return boolean where true means A is symmetric or false if it isn't
     */
    public static Boolean isSymmetric (int[][] A) {
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    if (A[i][j] != A[A.length - i - 1][A[i].length - i - 1]) return false;
                }
            }
            return true;
        }
        catch (IndexOutOfBoundsException a1) {
            System.out.println("Your arrays don't match in size through the whole 2D.");
        }
        catch (NullPointerException a2) {
            System.out.println("your array contains a null case");
        }
        return null;
    }

    /**
     * Multiply an integer array to a given power
     * @param A array to be multiplied
     * @param k value of the power
     * @return new integer array product of A^k
     */
    public static int[][] pow (int[][]A, int k) {
        try {
            int[][] output = new int[A.length][A[0].length];
            if (k < 0) {
                if (A.length==A[0].length) {
                    for (int i = 0; i < A.length; i++) {
                        for (int j = 0; j < A[i].length; i++) {
                            output[i][j] = A[i][j];
                        }
                    }
                    for (int i = 0; i < k; i++) {
                        output = matrixProduct(output, output);
                    }
                    return output;
                }
                else {
                    System.out.println("Your array should be 'squared' for this operation to work");
                }
            } else {
                System.out.println("Your value of k should be bigger than 0");
                return null;
            }
        }
        catch (IndexOutOfBoundsException a1) {
            System.out.println("Your array doesn't match in size through the whole 2D.");
        }
        catch (NullPointerException a2) {
            System.out.println("your array contains a null case");
        }
        return null;
    }
    public static void main (String[] args) {
    }
}
