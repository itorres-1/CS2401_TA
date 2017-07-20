package Lab2;

/**
 * CS2401: Elementary Data Structures and Algorithms
 * Instructor: Julio Urenda
 * Teaching Assistant: Isaac Torres
 * Assignment: Lab 2
 * Modified and submitted by: Raul Reza
 * Last modification: 6/26/2017
 * Purpose: Calculates the sum, difference, scalar multiplication, multiplication, transposition, an array by itself k amount of times, and determines if an array is symmetrical.
 */
public class Reza2 {


	//TODO Not Reza2 just REZA!!!


	/**
	 * Main method was just used for testing.
	 * @param args arguments
	 */
	public static void main(String[] args){
		/*int[][] A = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] B = { { 8, 6, 4 }, { 7, 5, 3 } };
		int[][] C = { { 1, 7, 3 }, { 7, 4, -5 }, { 3, -5, 6 } };
		int a = 3;

		int[][]d = sum(A, B);

		if (d == null) {

		}
		else {
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d[i].length; j++) {
					System.out.print(d[i][j] + " ");
				}
			}
		}*/
	}
	/**
	 *sum takes in 2 integer arrays and computes the sum of the arrays A+B.
	 * @param A 2D Integer array A
	 * @param B 2D Integer array B
	 * @return 2D Integer array sum
	 */
	public static int[][] sum(int[][] A, int[][] B){
		try {
			if ((A.length < 0) || (A[0].length < 0)){
				return B;
			}
			if ((B.length < 0) || (B[0].length < 0)){
				return A;
			}
			int[][] sum = new int[A.length][A[0].length];
			for (int i = 0; i < A.length; i++){
				for (int j = 0; j < A[0].length; j++){
					sum[i][j] = A[i][j] + B[i][j];
				}
			}
			return sum;
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.print("Arrays dimensions don't match.");
			return null;
		}
	}
	/**
	 * difference takes in 2 integer arrays and computes the difference of the arrays A-B.
	 * @param A 2D Integer array A
	 * @param B 2D Integer array B
	 * @return 2D Integer array difference
	 */
	public static int[][] difference(int[][] A, int[][] B){
		try {
			if ((A.length < 0) || (A[0].length < 0)){
				return B;
			}
			if ((B.length < 0) || (B[0].length < 0)){
				return A;
			}
			int[][] difference = new int[A.length][A[0].length];
			for (int i = 0; i < A.length; i++){
				for (int j = 0; j < A[0].length; j++){
					difference[i][j] = A[i][j] - B[i][j];
				}
			}
			return difference;
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.print("Arrays dimensions don't match.");
			return null;
		}
	}

	/**
	 * intMultiplication takes in an integer array and an integer and calculates the scalar multiplication of the array rA, where r equals B.
	 * @param A 2D Integer array A
	 * @param B Integer B
	 * @return 2D Integer array scalarMultiplication
	 */
	public static int[][] intMultiplication(int[][] A, int B){
		try{
			if(A == null){
				return null;
			}
			int[][] scalarMultiplication = new int[A.length][];
			for(int i = 0; i < A.length; i++){
				scalarMultiplication[i] = new int[A[i].length];
				for(int j = 0; j < A[i].length; j++){
					scalarMultiplication[i][j] = A[i][j] * B;
				}
			}
			return scalarMultiplication;
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.print("Arrays dimensions don't match.");
			return null;
		}
	}
	/**
	 * matrixProduct takes in 2 integer arrays and computes the product of the arrays A*B.
	 * @param A 2D Integer array A
	 * @param B 2D Integer array B
	 * @return 2D Integer array product
	 */
	public static int[][] matrixProduct(int[][] A, int[][] B) {
		try {
			if ((A.length < 0) || (A[0].length < 0)) {
				return B;
			}
			if ((B.length < 0) || (B[0].length < 0)) {
				return A;
			}
			int[][] product = new int[A.length][A[0].length];
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					product[i][j] = A[i][j] * B[i][j];
				}
			}
			return product;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Arrays dimensions don't match.");
			return null;
		}
	}
	/**
	 * transpose takes in an integer array and computes it's transpose A^T.
	 * @param A 2D Integer array A
	 * @return 2D Integer array transpose
	 */
	public static int[][] transpose(int[][] A){
		try{
			if(A == null){
				return null;
			}
			int[][] transpose = new int[A[0].length][A.length];
			for(int i = 0; i < A.length; i++){
				for(int j = 0; j < A[i].length; j++){
					transpose[j][i] = A[i][j];
				}
			}
			return transpose;
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.print("Arrays dimensions don't match.");
			return null;
		}
	}
	/**
	 * isSymmetric takes in an integer array and from calling the transpose method determines if the integer array is symmetric or not.
	 * @param A 2D Integer array A
	 * @return Boolean
	 */
	public static Boolean isSymmetric(int[][] A){
		try{
			if(A == null){
				return null;
			}
			if(A.length != A[0].length){
				System.out.print("Not an n x n matrix.");
			}
			int[][] symmetric = transpose(A);
			for(int i = 0; i < A.length; i++){
				for(int j = 0; j < A[0].length; j++){
					if(A[i][j] != symmetric[i][j]){
						return false;
					}
				}
			}
			return true;
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.print("Arrays dimensions don't match.");
			return null;
		}
	}
	/**
	 * pow takes in an integer array and an integer and computes the array multiplying itself k times A^k.
	 * @param A 2D Integer array A
	 * @param k Integer k
	 * @return 2D Integer array pow
	 */
	public static int[][] pow(int[][] A, int k){
		try{
			if(A == null){
				return null;
			}
			if(A.length != A[0].length){
				System.out.print("Not an nxn matrix.");
			}
			if(k < 1){
				System.out.print("Can't use this power.");
			}
			int[][] pow = A;
			for(int i = 1; i < k; i++){
				pow = matrixProduct(A, pow);
			}
			return pow;
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.print("Arrays dimensions don't match.");
			return null;
		}
	}
}