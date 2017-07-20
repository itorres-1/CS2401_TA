package Lab2;

/**
* Name: Hao T. Moy 
* Assignment: Lab2
* Instructor: Dr. Julio Cesar Urenda 
* T.A.: Isaac Torres
* Last Modification: 6/25/2017
* Purpose: Array manipulation
*/ 

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Scanner; 
import java.util.Arrays;
import java.util.InputMismatchException; 
import java.io.IOException;

public class Moy2 { 
	
	/**
	 * The method tries to read a file with a user-given path, if the path fails, it prints an error message. The method loops until input is correct. 
	 * @return The method returns the array that should be found in the file. If the file path is incorrect, the method returns null.
	 */
	public static int[][] read() {
		boolean z = true; 
		while (z) { 
			try { 
				Scanner scnr = new Scanner(System.in); 
				System.out.print("Enter file path: "); 
				String dire = scnr.nextLine(); 
				FileInputStream fis = new FileInputStream(dire);
				Scanner inFis = new Scanner(fis); 

				System.out.println("");
				System.out.print("Enter the number of lines of the matrix: ");
				int lines = scnr.nextInt(); 
				System.out.print("Enter the number of columns of the matrix: ");
				int columns = scnr.nextInt();

				int [][] A = new int[lines][columns]; 
				for (int i=0; i<lines; i++) { 
					for (int j=0; j<columns; j++) { 
						A[i][j] = inFis.nextInt();
						/*if (A[i][j] < 0)
							throw new IllegalArgumentException(); */
					}
				}
				z = false; 
				return A;
			}
				
			catch (IOException | IndexOutOfBoundsException | InputMismatchException | IllegalArgumentException e) { 
				System.out.println("Wrong input, please try again.");
				System.out.println(" ");
			}
		}
		return null;
	}
	
	/**
	 * This method adds two matrices. 
	 * @param A matrix to be added with the second.
	 * @param B secodn matrix.  
	 * @return Returns the sum of the first matrix with the second. If matrices are incompatible, returns null. 
	 */
	public static int[][] sum (int[][] A,  int[][] B) {
		if (A.length != B.length && A[0].length != B[0].length) {
			System.out.println("The provided matrices are not of compatible dimensions. ");
			return null;
		}
		else { 
			int [][] C = new int[A.length][A[0].length]; 
			for (int i=0; i<A.length; i++) { 
				for (int j=0; j<A[0].length; j++) {
					C[i][j] = A[i][j] + B[i][j]; 
				}
			}
		return C;
		}
	}
	
	/**
	 * This method subtracts a matrix to another. 
	 * @param A matrix to be subtracted from the second.
	 * @param B secodn matrix.  
	 * @return Returns the difference of the first matrix with the second. If matrices are incompatible, returns null. 
	 */
	public static int[][] difference (int[][] A,  int[][] B) {
		if (A.length != B.length && A[0].length != B[0].length) {
			System.out.println("The provided matrices are not of compatible dimensions. ");
			int[][] c = {{0},{0}};
			return c;
		}
		else { 
			int [][] C = new int[A.length][A[0].length]; 
			for (int i=0; i<A.length; i++) { 
				for (int j=0; j<A[0].length; j++) {
					C[i][j] = A[i][j] - B[i][j]; 
				}
			}
		return C;
		}
	}
	
	/**
	 * This method multiplies a matrix by an integer. 
	 * @param A matrix to be multiplied.
	 * @param B to multiply matrix with.
	 * @return Returns the multiplied matrix. If matrix or integer input are incompatible, returns null. 
	 */
	public static int[][] intMultiplication (int[][] A,  int B) {
		int [][] C = new int[A.length][A[0].length]; 
		for (int i=0; i<A.length; i++) { 
			for (int j=0; j<A[0].length; j++) {
				C[i][j] = A[i][j]*B; 
			}	
		}
		return C;
	}
	
	/**
	 * This method multiplies a matrix to another. 
	 * @param A matrix to be multiplied with the second.
	 * @param B secodn matrix.  
	 * @return Returns the multiplication of the first matrix with the second. If matrices are incompatible, returns null. 
	 */
	public static int[][] matrixProduct (int[][] A,  int[][] B) {
		if (A[0].length != B.length ) { 
			System.out.println("The provided matrices are not of compatible dimensions. ");
			int[][] c = {{0},{0}};
			return c;
		}
		else {
			int [][] C = new int[A.length][B[0].length];
			for (int k=0; k<A.length; k++) {
				for (int i=0; i<B[0].length; i++) {
					for (int j=0; j<B.length; j++) {
						C[k][i] = C[k][i] + A[k][j]*B[j][i];
					}
				}				
			}
			return C;
		}
	}
		
	/**
	 * This method transposes a matrix. 
	 * @param A matrix to be transposed.
	 * @return Returns the transposed matrix. If matrix is incompatible, returns null. 
	 */
	public static int[][] transpose(int[][] A) { 
		int[][] AT = new int[A[0].length][A.length]; 
		for (int i=0; i<AT.length; i++) { 
			for (int j=0; j<AT[0].length; j++) {
				AT[i][j] = A[j][i];
			}
		}
		return AT; 
	}
	
	/**
	 * This method deduces if a matrix is symetric. 
	 * @param A matrix to be tested for symetry.
	 * @return Returns the true if matrix is symetric, false if it is not, and null if matrix input is incompatible.  
	 */
	public static boolean isSymmetric(int[][] A)   {
		int[][] AT = new int[A[0].length][A.length]; 
		for (int i=0; i<AT.length; i++) { 
			for (int j=0; j<AT[0].length; j++) {
				AT[i][j] = A[j][i];
				if (AT[i][j] != A[i][j])
					return false; 
			}
		}
		return true;
	}
	
	/**
	 * This method elevates a matrix by an integer. 
	 * @param A matrix to be elevated.
	 * @param B matrix esponent.
	 * @return Returns the elevated matrix. If matrix or integer input are incompatible, returns null. 
	 */	
	public static int[][] pow(int[][] A, int B) { 
		if (A.length !=  A[0].length) {
			System.out.println("The provided matrices are not of compatible dimensions. ");
			int[][] c = {{0},{0}};
			return c;
		}
		int [][] C = new int[A.length][A[0].length];
		C = A.clone(); 
		for (int h=1; h<B; h++) {	
			C = matrixProduct (C, A);
		}
		return C; 
	}
	
	public static void main(String[]args) { 
		Scanner scan = new Scanner(System.in); 
		
		System.out.print("This program receives every matrix in a different file.");
		System.out.println("");

		System.out.println("Sum: ");
		System.out.println(Arrays.deepToString(sum(read(), read())));
		System.out.println(" ");
		
		System.out.println("Difference: ");
		System.out.println(Arrays.deepToString(difference(read(), read())));
		System.out.println(" ");
		
		boolean testInt = true; 
		while (testInt) { 
			try {
				scan = new Scanner(System.in); 
				System.out.println("intMultiplication: ");
				System.out.println("Enter integer: ");
				int b = scan.nextInt(); 
				System.out.println(Arrays.deepToString(intMultiplication(read(), b)));
				System.out.println(" ");
				testInt = false;
			}
			catch (InputMismatchException e) { 
				System.out.println("Wrong input, try again. ");
			}
		}
		
		
		System.out.println("matrixProduct: ");
		System.out.println(Arrays.deepToString(matrixProduct(read(), read())));
		System.out.println(" ");
		
		System.out.println("Transpose: ");
		System.out.println(Arrays.deepToString(transpose(read())));
		System.out.println(" ");
		
		System.out.println("isSymetric: ");
		if (isSymmetric(read())) 
			System.out.println("The matrix is symetric.");
		else 
			System.out.println("NOT symetric.");
		System.out.println(" ");
		
		
		System.out.println("Pow: ");
		System.out.print("Enter power: ");
		int c = scan.nextInt(); 
		System.out.println(Arrays.deepToString(pow(read(), c)));
		System.out.println(" ");
		
		testInt = true; 
		while (testInt) { 
			try {
				scan = new Scanner(System.in); 
				System.out.println("Pow: ");
				System.out.print("Enter power: ");
				int d = scan.nextInt(); 
				System.out.println(Arrays.deepToString(pow(read(), c)));
				System.out.println(" ");
				testInt = false;
			}
			catch (InputMismatchException e) { 
				System.out.println("Wrong input, try again. ");
			}
		}
		
	}
}
	

