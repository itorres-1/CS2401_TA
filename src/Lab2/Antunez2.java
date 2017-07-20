package Lab2;

/**
 * Francisco Antunez
 * Lab2
 */

public class Antunez2{
	//Javadoc comments are properly formatted but desdcribe the method. I.e. not "multiply by an integer
	// instead: this method takes a 2d int array and an int and returns the two d array where
	//every element is multiplied by the int


//	public static void main(String[] args) {
//		int[][] A = {{1,2,3}, {4,5,6}};
//		int[][] C = {{2,1}, {5,3}, {4,7}};
//		int[][] B = {{-1,4,7},{9,8,2}};
//		int[][] D = {{1,2},{3,4}};
//		int[][] E = {{1,7,3},{7,4,-5},{3,-5,6}};
//
//		print(matrixProduct(A, B));
//		print(sum(A, B));
//		print(difference(A, C));
//		print(intMultiplication(C, 3));
//		print(transpose(A));
//		if (isSymmetric(E)){
//			System.out.println("it is symmetric");
//		}
//		print(pow(C,4));
//		System.out.println("end");
//	}
/**
 * add two matrices and return their sum
 * @param A
 * @param B
 * @return the sum of two matrices 
 */
	public static int[][] sum(int[][] A, int[][] B) {
		int[][] sum = new int[A.length][A[0].length];
		try{
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					sum[i][j] = A[i][j] + B[i][j];
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return sum;
	}
/**
 * subtracts two matrices and returns their difference (A - B)
 * @param A
 * @param B
 * @return the difference of two matrices
 */
	public static int[][] difference(int[][] A, int[][] B) {
		int[][] diff = new int[A.length][A[0].length];
		try {
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					diff[i][j] = A[i][j] - B[i][j];
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		
		return diff;
	}
/**
 * compute the product of a matrix with a number
 * @param A
 * @param B
 * @return the product of a matrix multiplied with a number
 */
	public static int[][] intMultiplication(int[][] A, int B) {
		int[][] product = new int[A.length][A[0].length];
		
		try {
			if(A.length == 0){
				throw new ArrayIndexOutOfBoundsException("empty array");
			}
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					product[i][j] = B * A[i][j];
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return product;
	}
	// m by n matrix A, n by p matrix B return product
	// AC = 1 2 3	2 1		1*2+2*5+3*4	1*1+2*3+3*7		24 27
	//      4 5 6	5 3		4*2+5*5+6*4 4*1+5*3+6*7		57 61
	//      		4 7
/**
 * compute the product of two matrices
 * @param A
 * @param B
 * @return returns null if the arrays are mismatched m by p / p by m, or returns the product of two matrices
 */
	public static int[][] matrixProduct(int[][] A, int[][] B) {
		int[][] product = new int[A.length][B[0].length]; 
		try{
			if (A.length != B[0].length || A[0].length != B.length){
				throw new ArrayIndexOutOfBoundsException("array mismatch");
			}
			for (int productRow = 0; productRow < product.length; productRow++) {
				for (int i = 0; i < A.length; i++) {
					for (int j = 0; j < A[0].length; j++) {
						product[productRow][i] = product[productRow][i] + A[productRow][j] * B[j][i];
					}
				}
			}	
		}
		catch (ArrayIndexOutOfBoundsException e){
			return null;
		}
		return product;
	}

	// given m by n matrix A return transpose A^t
/**
 * transposes a given matrix
 * @param A
 * @return transposed matrix
 */
	public static int[][] transpose(int[][] A) {
		int[][] B = new int[A[0].length][A.length];
		try{
			if (A.length == 0) {
				throw new ArrayIndexOutOfBoundsException("empty array");
			}

			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++){
					B[j][i] = A[i][j];
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return null;
		}
		return B;
	}

	// verifies if given n by n matrix is symetric
/**
 * checks if an array is symmetric
 * @param A
 * @return true if the matrix is symmetric, and false if it's not
 */
	public static Boolean isSymmetric(int[][] A){
		int[][] T = transpose(A);
		try {
			if(A.length == 0){
				throw new ArrayIndexOutOfBoundsException("empty array");
			}
			for(int i = 0; i < A.length; i++){
				for(int j = 0; j < A[0].length; j++){
					if (A[i][j] != T[i][j])
						return false;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e){
			return null;
		}
		return true;
	}
	//or [i][j] == [j][i]
	//
	
///**
// * method prints given 2D array
// * @param A
// * @return void
// */
//	public static void print(int[][] A) {
//		System.out.println("print: ");
//		if (A.length == 0){
//			System.out.println("null");
//			return;
//		}
//		for (int i = 0; i < A.length; i++) {
//			for (int j = 0; j < A[0].length; j++) {
//				System.out.print(A[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}


	// given n x n matrix compute its determinant
/**
 * multiplies a matrix by itself k times
 * @param A
 * @param k
 * @return matrix multiplied by itself k times
 */
	public static int[][] pow(int[][] A, int k) {
		int[][] B = A;
		try{
			if (A.length == 0){
				throw new ArrayIndexOutOfBoundsException("empty");
			}
			if (k == 1) {
				return A;
			}	

			for (int i = 1; i < k; i++) {
				B = matrixProduct(B, A);
			}
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return null;
		}
		return B;
	}


}
