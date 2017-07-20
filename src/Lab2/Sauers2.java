package Lab2;
import java.io.*;
import java.util.*;

public class Sauers2 {

	//TODO transpose(a) == a will not work
	//TODO Where are you javadoc comments?
	
	public static Scanner input = new Scanner(System.in);

	public static int[][] readFile (String pathname) {
		String line;
		int rows = 0;
		int columns = 0;
		int k = 0;
		String[] temp = new String[10];
		
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(pathname));
			try {
				while ((line = buffRead.readLine()) != null) {
					if (rows == 1) {
						String lineLength = line.replaceAll(" ","");
						columns = lineLength.length();
					}
					temp[rows] = line.replaceAll(" ","");
					rows++;
				}
			} catch (Exception a) {
				System.out.println("Errors?! In MY code?! " + a);
			}
			int[][] userMatrix = new int[rows][columns];
			
			for (int i = 0; i < userMatrix.length; i++) {
				for (int j = 0; j < userMatrix[i].length; j++) {
					if (temp[i].charAt(j) == '-') {
						userMatrix[i][j] = Integer.parseInt(String.valueOf(temp[i].charAt(j+1))) * -1;
						k = j + 1;
					} else {
						userMatrix[i][j] = Integer.parseInt(String.valueOf(temp[i].charAt(j)));
					}
				}
			}		
			for (int i = 0; i < userMatrix.length; i++) {
				for (int j = 0; j < userMatrix[i].length; j++) {
					System.out.print(userMatrix[i][j] + " ");
				} System.out.println(" ");
			}
			return userMatrix;
		}
		catch(Exception c) {
			System.out.println("Error message: " + c);
		}
		return null;
	}
	
	public static int[][] sum (int[][] a, int[][] b) {
		int[][] c = new int[a.length][a[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		} return c;
	}
	
	public static int[][] difference (int[][] a, int[][] b) {
		int[][] c = new int[a.length][a[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		} return c;
	}
	
	public static int[][] intMultiplication (int[][] matrix, int scalar) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[i][j] * scalar;
			}
		} return matrix;
	}
	
	public static int[][] matrixProduct (int[][] a, int[][] b) {
		if (a[0].length != b.length) {
			System.out.println("Matrix 1 has " + a[0].length + " rows and Matrix 2 has " + b.length + " columns!");
			System.out.println("M1's rows must match M2's columns in order to multiply!");
			return null;
		} else {
			int[][] product = new int[a.length][b[0].length];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[i].length; j++) {
					for (int k = 0; k < a.length; k++) {
						product[i][j] += a[i][k] * b[k][j];
					}
				}
			} return product;
		}
	}
	
	public static int[][] transpose (int[][] a) {
		int[][] transpose = new int[a[0].length][a.length];
		for (int i = 0; i < transpose.length; i++) {
			for (int j = 0; j < transpose[0].length; j++) {
				transpose[i][j] = a[j][i];
			}
		}
		return transpose;
	}
	
	public static boolean isSymmetric (int[][] a) {
		return false;
	}
	
	public static int[][] pow (int[][] a, int power) {
		if (power == 1) {
			return a;
		} else if (power == 2) {
			return matrixProduct(a,a);
		} else {
			return matrixProduct(a,pow(a,power-1));
		}
	}
	
	public static void printMatrix (int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
//	public static void main(String[] args) {
//		boolean exit = false;
//		String userPath = "";
//		int userChoice = 0;
//
//		if(exit) {
//			System.exit(0);
//		}
//
//		System.out.print("Please enter the desired file path: ");
//		userPath = input.next();
//		int[][] userMatrix = readFile(userPath);
//
//		while (!exit) {
//			System.out.println("\n\nWhat would you like to do today? (Enter a numerical value): \n1. Path (change file path) \n2. Print (prints current matrix)");
//			System.out.println("3. Sum (adds together two matricies) \n4. Difference (calculates the difference between two matricies)");
//			System.out.println("5. Scalar product (Multiplies the current matrix by a scalar k) \n6. Product (calculates the product of two matricies)");
//			System.out.println("7. Transpose (Transposes the current matrix) \n8. Symmetry (checks the current matrix for symmetry)");
//			System.out.println("9. Power (Calculates the current matrix to a power k) \n10. Exit (quits the current program) \nPlease enter your option: ");
//			try {
//				userChoice = input.nextInt();
//				switch (userChoice) {
//					case 1:
//						System.out.print("Please enter the filepath you would like: ");
//						userPath = input.next();
//						userMatrix = readFile(userPath);
//						System.out.println("Success! Filepath changed to " + userPath);
//						break;
//					case 2:
//						System.out.print("The current matrix is ");
//						printMatrix(userMatrix);
//						break;
//					case 3:
//						System.out.print("Please enter the filepath to a second matrix: ");
//						userPath = input.next();
//						int[][] userMatrix2 = readFile(userPath);
//						if ((userMatrix.length != userMatrix2.length) || (userMatrix[0].length != userMatrix2[0].length)) {
//							System.out.println("Error! The matricies are not of equal dimensions, and cannot be added.");
//							break;
//						} else {
//							System.out.println("The sum of the two matricies is:");
//							printMatrix(sum(userMatrix,userMatrix2));
//							break;
//						}
//					case 4:
//						System.out.print("Please enter the filepath to a second matrix: ");
//						userPath = input.next();
//						userMatrix2 = readFile(userPath);
//						if ((userMatrix.length != userMatrix2.length) || (userMatrix[0].length != userMatrix2[0].length)) {
//							System.out.println("Error! The matricies are not of equal dimensions, and cannot be subtracted.");
//							break;
//						} else {
//							System.out.println("The difference of the two matricies is:");
//							printMatrix(dif(userMatrix,userMatrix2));
//							break;
//						}
//					case 5:
//						System.out.print("Please enter a scalar (integer value): ");
//						int scalar = input.nextInt();
//						System.out.println("\nThe current matrix multiplied by " + scalar + " is:");
//						printMatrix(intMultiplication(userMatrix,scalar));
//						break;
//					case 6:
//						System.out.print("Please enter the filepath to a second matrix: ");
//						userPath = input.next();
//						userMatrix2 = readFile(userPath);
//						System.out.println("The product of the two matricies is:");
//						printMatrix(matrixProduct(userMatrix,userMatrix2));
//						break;
//					case 7:
//						System.out.println("The transpose of the current matrix is:");
//						printMatrix(transpose(userMatrix));
//						break;
//					case 8:
//						if(isSymmetric(userMatrix)) {
//							System.out.println("The current matrix is symmetric!");
//						} else {
//							System.out.println("The current matrix is not symmetric!");
//						}
//						break;
//					case 9:
//						System.out.print("Please enter a power (integer value): ");
//						int power = input.nextInt();
//						printMatrix(pow(userMatrix,power));
//						break;
//					case 10:
//						System.out.println("Thank you!");
//						exit = true;
//						break;
//					default:
//						System.out.println("Input not recognized!");
//						break;
//				}
//			}catch (Exception n) {
//				System.out.println("Exception " + n);
//				input.next();
//			}
//		}
//	}
}