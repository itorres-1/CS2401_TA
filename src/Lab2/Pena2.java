package Lab2;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Created by LoriPena on 6/25/17.
 * Lorianne Pena
 * CS 2401 Summer 2017
 * Lab 2
 */
public class Pena2 {

    /**
     * The sum method is taking two 2d arrays and adding them together.
     * for example: A+B=C and we return C. By using two for loops to iterate through the matrices allowing us to
     * add them together and giving us one 2d array.
     **/
    // return c = a + b
    public static int[][] sum(int[][] A, int[][] B) {
        try {
            int m = A.length;//rows
            int n = A[0].length;//columns
            int[][] C = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    C[i][j] = A[i][j] + B[i][j];
            return C;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (ArithmeticException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        } catch (InputMismatchException e) {
            return null;
        }catch(NoSuchElementException e){
            return null;
        }catch (IllegalArgumentException e){
            return null;
        }catch (UnsupportedOperationException e){
            return null;
        }

    }

    /**
     * The difference method is taking two 2d arrays and subtracting them.
     * A-B= returns C. By using two for loops to iterate through the matrices allowing us to
     * subtract the 2 2d arrays and giving us a one 2d array result.
     **/
    // return c = a - b
    public static int[][] difference(int[][] A, int[][] B) {
        try {
            int m = A.length;//rows
            int n = A[0].length;//columns
            int[][] C = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    C[i][j] = A[i][j] - B[i][j];
            return C;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (ArithmeticException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        } catch (InputMismatchException e) {
            return null;
        }catch(NoSuchElementException e){
            return null;
        }catch (IllegalArgumentException e){
            return null;
        }catch (UnsupportedOperationException e){
            return null;
        }
    }

    // return c=a[][]*b
    public static int[][] intMultiplication(int[][] A, int B) {
        try {
            int m = A.length;//rows
            int n = A[0].length;//columns
            if (B != n) throw new RuntimeException ("Illegal matrix dimensions.");
            int[][] C = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    C[i][j] += A[i][j] * B;
            return C;

        } catch (InputMismatchException e) {
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (ArithmeticException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        }catch(NoSuchElementException e){
            return null;
        }catch (IllegalArgumentException e){
            return null;
        }catch (UnsupportedOperationException e){
            return null;
        }
    }

    /**
     * The matrixProduct takes two 2d arrays and multiplies them in a similar fashion as addition and subtraction
     * code wise. We take A * B and return C.By using two for loops to iterate through the matrices allowing us to
     * multiply them together and giving us one 2d array result.
     **/
    // return c = a * b
    public static int[][] matrixProduct(int[][] A, int[][] B) {
        try {
            int m = A.length;//rows
            int n = A[0].length;//columns
            int[][] C = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    C[i][j] = A[i][j] * B[i][j];
            return C;

        } catch (InputMismatchException e) {
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (ArithmeticException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        }catch(NoSuchElementException e){
            return null;
        }catch (IllegalArgumentException e){
            return null;
        }catch (UnsupportedOperationException e){
            return null;
        }

    }

    /**
     * In the transpose method we take one 2d array A and transpose itself or taking the matrix
     * and "interchanging" the rows and columns which returns B.
     **/
    //return B=A^T
    public static int[][] transpose(int[][] A) {
        try {
            int m = A.length;//rows
            int n = A[0].length;//columns
            int[][] B = new int[n][m];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    B[j][i] = A[i][j];
            return B;

        } catch (InputMismatchException e) {
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (ArithmeticException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        }catch(NoSuchElementException e){
            return null;
        }catch (IllegalArgumentException e){
            return null;
        }catch (UnsupportedOperationException e){
            return null;
        }
    }

    /**
     * The isSymmetric method just checks if a 2d array A is symmetric based on matrix standards and
     * returns true, false or null due to the Boolean data type. For fun we also check if the matrix/2d array is
     * a square matrix.
     **/
    public static Boolean isSymmetric(int[][] A) {
        try {
            int m = A.length;//rows
            int n = A[0].length;//columns
            if (m != n) {
                System.out.println ("This is not a square matrix!");
            } else {
                System.out.println ("This is a square matrix!");
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < i; j++) {
                    if (A[i][j] != A[j][i]) return false;
                }
            }
            return true;

        } catch (InputMismatchException e) {
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (ArithmeticException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        }catch(NoSuchElementException e){
            return null;
        }catch (IllegalArgumentException e){
            return null;
        }catch (UnsupportedOperationException e){
            return null;
        }
    }

    /**
     * The pow method takes one 2d array A and a int k and raises each number in the matrix by k.
     **/
    //return result=A^k
    public static int[][] pow(int[][] A, int k) {
        try {
            int[][] result = A;
            for (int n = 1; n < k; ++n)
                result = matrixProduct (result, A);
            return result;

        } catch (InputMismatchException e) {
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (ArithmeticException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        }catch(NoSuchElementException e){
            return null;
        }catch (IllegalArgumentException e){
            return null;
        }catch (UnsupportedOperationException e){
            return null;
        }
    }

    /**
     * This method is to just print the Array for testing purposes.
     **/
    public static void printArray(int[][] result) {//print
        try {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print (result[i][j] + "\t ");
                }
                System.out.println ( );
            }
        } catch (InputMismatchException e) {
            System.out.println (" Input issue!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println (" Array issue!");
        } catch (ArithmeticException e) {
            System.out.println (" Arithmetic issue!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println (" Index issue!");
        } catch (NegativeArraySizeException e) {
            System.out.println (" Negative array issue!");
        } catch (NumberFormatException e) {
            System.out.println (" Number format issue!");
        }catch(NoSuchElementException e){
            System.out.println ("No such element issue" );
        }catch (IllegalArgumentException e){
            System.out.println ("Illegal argument issue!" );
        }catch (UnsupportedOperationException e){
            System.out.println ("Unsupported Operation issue." );
        }
    }

    /**
     * main used to test all the methods to ensure all the methods work.
     **/
    public static void main(String[] args) {

        try {
            //test arrays
            int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
            int[][] array2 = {{-1, 4, 7}, {9, 8, 2}};
            int[][] array3 = {{2, 1}, {5, 3}, {4, 7}};
            int[][] array4 = {{1, 2}, {3, 4}};
            int[][] array5 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {10, 11, 12, 13}, {14, 15, 16, 17}};
            int[][] array6 = {{1, 2, 3}, {2, 4, 5}, {3, 5, 8}};
            int[][] array7 = {{5, 6, 7}, {6, 3, 2}, {7, 2, 1}};
            //checking sum of arrays
            System.out.println ("***********************");
            printArray (sum (array1, array2));
            //checking difference of arrays
            System.out.println ("***********************");
            printArray (difference (array1, array2));
            //checking multiply by int
            System.out.println ("***********************");
            printArray (intMultiplication (array1, 3));
            //checking multiplication of 2 2d arrays
            System.out.println ("***********************");
            printArray (matrixProduct (array1, array2));
            //checking transpose array
            System.out.println ("***********************");
            printArray (transpose (array1));
            //checking if the array is symmetric
            System.out.println ("***********************");
            System.out.println ("Is this matrix Symmetric?" + " " + isSymmetric (array2));
            //checking if the pow method works
            System.out.println ("***********************");
            printArray (pow (array4, 2));


        } catch (InputMismatchException e) {
            System.out.println (" Input issue!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println (" Array issue!");
        } catch (ArithmeticException e) {
            System.out.println (" Arithmetic issue!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println (" Index issue!");
        } catch (NegativeArraySizeException e) {
            System.out.println (" Negative array issue!");
        } catch (NumberFormatException e) {
            System.out.println (" Number format issue!");
        }catch(NoSuchElementException e){
            System.out.println ( "No such element issue.");
        }catch (IllegalArgumentException e){
            System.out.println ("Illegal argument issue!" );
        }catch (UnsupportedOperationException e){
            System.out.println ("Unsupported Operation issue." );
        }

    }
}

