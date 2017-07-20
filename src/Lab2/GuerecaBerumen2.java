package Lab2;

import java.util.InputMismatchException;

/**
 * The Class GuerecaBerumen2.
 * Containing all methods needed for lab 2.
 */
public class GuerecaBerumen2 {

	//TODO JAvadoc comments
	//Style (why store lengths?
	//TODO -5 points correctness for not following instructions on the exact names of methods.
	//TODO There's a reason for this!! matrixProduct NOT matrixMultiplication!
	//DESIGN -5 for overwriting original information! Never do this unless the method
	//is intentionally supposed to !

	/*
	static public void main(String[] args) {
	}
	*/
	
	/**
	 * sum adds two matricies together
	 *
	 * @param A the first matrix
	 * @param B the second matrix
	 * @return AB int[][] containing sum of A and B
	 */
	static public int[][]  sum(int[][] A, int[][] B){
		try{
			int m = (A.length > B.length)?A.length:B.length;
			int n;
			int AB[][] = A;
			for(int mIndex = 0;mIndex < m;mIndex++){
				 n =  (A[mIndex].length > B[mIndex].length)?A[mIndex].length:B[mIndex].length;
				for(int nIndex = 0;nIndex < n;nIndex++){
					AB[mIndex][nIndex]+= B[mIndex][nIndex];
				}
			} 
			return AB;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	/**
	 * Difference calculates the difference between the two given matricies
	 *
	 * @param A the first matrix
	 * @param B the second matrix
	 * @return AB int[][] containing difference of A and B
	 */
	static public int[][] difference(int[][] A, int[][] B){
		try{
			int m =  (A.length > B.length)?A.length:B.length;
			int n;
			int[][] AB = A;
			for(int mIndex = 0;mIndex < m;mIndex++){
				n =  (A[mIndex].length > B[mIndex].length)?A[mIndex].length:B[mIndex].length;
				for(int nIndex = 0;nIndex < n;nIndex++){
					AB[mIndex][nIndex]-= B[mIndex][nIndex];
				}
			}
			return AB;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * IntMultiplication multiplies all elements in matrix by a constant integer
	 *
	 * @param A the first integer
	 * @param r the constant integer
	 * @return Ar the int[][] containing the multiplied matrix
	 */
	static public int[][] intMultiplication(int[][] A, int r){
		try{
			int m = A.length;
			int n;
			int Ar[][] = A;
			for(int mIndex = 0;mIndex < m;mIndex++){
				n = A[mIndex].length;
				for(int nIndex = 0;nIndex < n;nIndex++){
					Ar[mIndex][nIndex] *= r;
				}
			}
			return Ar;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * matrixMultiplication multiplies two matricies together
	 *
	 * @param A the first matrix
	 * @param B the second matrix
	 * @return AB the int[][] with the product of the matricies
	 */
	static public int[][] matrixProduct(int[][] A, int[][] B){
		try{
			if (A[0].length != B.length) throw new InputMismatchException("Wrong Dimensions");
			int m = A.length;
			int n;
			int p = B[0].length;
			int AB[][] = new int[m][p];
			for(int mIndex = 0;mIndex < m;mIndex++){
				for(int pIndex = 0;pIndex < p;pIndex++){
					AB[mIndex][pIndex] = 0;
					 n =  (A[mIndex].length > B.length)?A[mIndex].length:B.length;
					for(int nIndex = 0;nIndex < n;nIndex++){
						AB[mIndex][pIndex] += (A[mIndex][nIndex]*B[nIndex][pIndex]);
					}
				}
			}
			return AB;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * Transposes a matrix
	 *
	 * @param A the given matrix
	 * @return At the transposed int[][]
	 */
	static public int[][] transpose(int[][] A){
		try{
			int m = A.length;
			int n = A[0].length;
			int At[][] = new int[n][m];
			for(int mIndex = 0;mIndex < m;mIndex++){
				for(int nIndex = 0;nIndex < n;nIndex++){
					At[nIndex][mIndex] = A[mIndex][nIndex];
				}
			}
			return At;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * Checks if matrix is symmetric.
	 *
	 * @param A the given matrix
	 * @return boolean for if it is
	 */
	static public Boolean isSymmetric(int A[][]){
		try{
			int m = A.length;
			for(int mIndex = 0;mIndex < m;mIndex++){
				for(int nIndex = 0;nIndex < mIndex;nIndex++){
					if(A[mIndex][nIndex] != A[nIndex][mIndex]){return false;}
				}
			}
			return true;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * Pow calculates the given matrix to the power of k
	 *
	 * @param A the given matrix
	 * @param k the exponent
	 * @return Ak the int[][] containing final matrix
	 */
	static public int[][] pow(int A[][], int k){
		try{
			int Ak[][] = A.clone();
			for(int counter = 0;counter < k - 1;counter++){
				Ak = matrixProduct(Ak,A);
			}
			return Ak;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/*
	private static void printArray(int[][] array){
		for(int[] m : array){
			System.out.print("[ ");
			for(int element : m){
				System.out.print(element + " ");
			}
			System.out.println("]");
		}
	}
	*/
}
