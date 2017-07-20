package Lab2;

import java.io.*;
import java.util.*;

public class Deitrick2 {

    /**
     * main()
     *
     * Executes all methods, checks for equal matrix sizes
     * before allowing execution of all methods.
     *
     *
     * @param args
     * @throws IOException
     * @throws NullPointerException
     */
    public static void main(String[] args) throws IOException, NullPointerException {

        int[][] A = null;
        int[][] B = null;


        Boolean equalMatrix = false;
        while (!equalMatrix) {
            try {
                A = readfromFile();
                System.out.println("Matrix A: ");
                printArray(A);

                B = readfromFile();
                System.out.println("Matrix B: ");
                printArray(B);

                if (A.length == B.length) {
                    equalMatrix = !equalMatrix;
                } else {
                    System.out.println("A and B are not the same size, try again.");
                }
            } catch (NullPointerException e) {
                System.out.println("The file is empty, try again.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array out of bounds, try again.");
            } catch (NumberFormatException e) {
                System.out.println("No Integers were found, try again.");
            }
        }

        int[][] sumC = sum(A, B);
        System.out.println("SUM: ");
        printArray(sumC);

        int[][] diffC = difference(A, B);
        System.out.println("DIFFERENCE: ");
        printArray(diffC);

        System.out.println("A number is needed for multiplication.");
        int[][] intMult = (intMultiplication(A, askInt()));
        System.out.println("INT MULTIPLICATION: ");
        printArray(intMult);

        int[][] prodC = (matrixProduct(A, B));
        System.out.println("MATRIX PRODUCT: ");
        printArray(prodC);

        int[][] transC = (transpose(A));
        System.out.println("TRANSPOSE A: ");
        printArray(transC);

        System.out.println("SYMMETRIC: ");
        System.out.println(isSymmetric(A));
        System.out.println(" ");

        Boolean kpositive = false;
        while (!kpositive) {
            try {
                System.out.println("A number is needed as an exponent.");
                int[][] pow = (pow(A, askInt()));
                System.out.println("POWER: ");
                printArray(pow);
                if (A != null) {
                    kpositive = !kpositive;
                } else {
                }
            } catch (NullPointerException e) {
                System.out.println("The number cannot be negative.");
            }
        }
    }

    /**
     * pow()
     *
     * This method checks that int[][] A can be raised to a
     * certain power k.
     *
     * If k is 0 pow() will return 1
     * if k is 1 the original array A will return.
     * if k is < 0 the array will return null and will prompt for input again.
     * After these conditions are checked matrixProduct() is called k times.
     * a new Matrix C is returned.
     *
     * @param A
     * @param k
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public static int[][] pow(int[][] A, int k)throws ArrayIndexOutOfBoundsException, NullPointerException {

        int[][] zeroPow = new int[A.length][A[0].length];
        if (k == 0) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    zeroPow[i][j] = 1;
                }
            }
            return zeroPow;
        }else if(k == 1){
            return A;
        } else if(k < 0) {
            return null;
        }else{
            int[][] C = A;
            for (int i = 0; i < k; i++) {
                C = matrixProduct(C,A)  ;
            }
            return C;
        }
    }
    /**
     * isSymmetric()
     *
     * This method returns a Boolean result. The method checks that there
     * is diagonal symmetry in the matrix and the matrix must be of size
     * nxn.
     *
     * @param A
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public static Boolean isSymmetric(int[][] A)throws ArrayIndexOutOfBoundsException, NullPointerException {

        Boolean isSymmetric = false;
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == A[j][i]) {
                        isSymmetric = !isSymmetric;
                    } else {
                        isSymmetric = false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return isSymmetric;
    }

    /**
     * transpose()
     *
     * In this method a new int[][] T is returned which is the
     * transpose of matrix A. the columns of A become the rows of T
     * and the rows of A the columns of T.
     *
     *
     * @param A
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public static int[][] transpose(int[][] A)throws ArrayIndexOutOfBoundsException, NullPointerException {

        int[][] T = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    T[i][j] = A[j][i];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return T;
    }

    /**
     * matrixProduct()
     *
     * This method multiplies the elements in matrix A and the elements in
     * Matrix B. A new int[][] is returned.
     *
     * @param A
     * @param B
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public static int[][] matrixProduct(int[][] A, int[][] B)throws ArrayIndexOutOfBoundsException, NullPointerException {

        int[][] C = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    C[i][j] = A[i][j] * B[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return C;
    }

    /**
     * intMultiplication()
     *
     * This method multiplies the elements in Matrix A with an integer.
     * A new int[][] is returned as the result.
     *
     * @param A
     * @param B
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public static int[][] intMultiplication(int[][] A, int B)throws InputMismatchException, NullPointerException {

        int[][] C = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    C[i][j] = (A[i][j]) * B;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return C;
    }

    /**
     * difference()
     *
     * This method returns an array which id the difference of
     * the elemets in matrix A and matrix B.
     *
     * @param A
     * @param B
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public static int[][] difference(int[][] A, int[][] B) throws ArrayIndexOutOfBoundsException, NullPointerException {

        int[][] C = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    C[i][j] = A[i][j] - B[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return C;
    }

    /**
     * sum()
     *
     * This method returns an array which is the sum of
     * the elements in matrix A and matrix B.
     *
     * @param A
     * @param B
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public static int[][] sum(int[][] A, int[][] B) throws ArrayIndexOutOfBoundsException, NullPointerException {

        int[][] C = new int[A.length][A[0].length];
        try {
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    C[i][j] = A[i][j] + B[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return C;
    }

    //Helper Methods
    /**
     * readfromFile()
     * <p>
     * Method requesting input for a file path. The file is read
     * and split into a String array, the values are then parsed as integers
     * in int[][] intNumbers. if intNumbers.length equals the length of the
     * String array that was originally read in the file is ready to use.
     * If there is an exception, the method will keep on prompting for input.
     * <p>
     * This Method works for a Matrix of size n x n. I attempted several times
     * to have count iterate only over the columns however I returned
     * Array out of bound exceptions.
     *
     * @return
     * @throws IOException
     */
    public static int[][] readfromFile() throws IOException {

        Scanner key = new Scanner(System.in);
        FileReader fr;
        BufferedReader br;
        int[][] intNumbers = null;

        Boolean goodFile = false;
        while (!goodFile) {
            System.out.println("File name: ");
            try {
                fr = new FileReader(key.nextLine());
                br = new BufferedReader(fr);
                String line = null;
                int i = 0;
                int count = 0;

                while ((line = br.readLine()) != null) {
                    String[] intStrings = line.split(" ");

                    if (intNumbers == null) {
                        count = intStrings.length;
                        intNumbers = new int[count][count]; //how to set the columns?
                    }
                    for (int j = 0; j < count; j++) {
                        intNumbers[i][j] = Integer.parseInt(intStrings[j]);
                    }
                    i++;
                }
                if (intNumbers.length == count) {
                    goodFile = !goodFile;
                } else {
                    System.out.println("Data is bad, use another file.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found, try again.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array out of bounds, try again.");
            } catch (NumberFormatException e) {
                System.out.println("No Integers were found, try again.");
            }
        }
        return intNumbers;
    }

    public static int askInt()throws NumberFormatException,InputMismatchException,NullPointerException {

        int returnInt = 0;
        try{
            Scanner key = new Scanner(System.in);
            System.out.println("What is the number: ");
            returnInt = key.nextInt();

        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return returnInt;
    }


    public static void printArray(int[][] A) {

        for (int[] Arr : A) {
            System.out.println(Arrays.toString(Arr));
        }
        System.out.println(" ");
    }
}
