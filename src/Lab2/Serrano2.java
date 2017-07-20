package Lab2;

/************************************************************************
 *Name: Crystal Serrano
 *Assignment: Lab2
 *Instructor: Dr. Urenda
 *TA: Isaac Torres
 *Due: 6/26/2017
 *Last Modified:
 *Purpose of Program: The purpose of this program is to create seven methods
 *that will compute several different matrix computations such as adding two 
 *matrices, finding the difference between two matrices, multiplying a matrix
 *by an integer scalar, compute the product of two matrices, finding the transpose
 *of a matrix, check wheather a matrix is symmetric, and finally to compute 
 *a matrix to the given power (A^k)
*************************************************************************/ 
import java.util.*;
import java.util.Scanner;
import java.io.IOException;

public class Serrano2{

	//TODO Javadoc COMMENTS
	
	public static void main(String[] args){
	
	}
/************************************************************************/
	/**Method 1: Given two m*n matrices A and B, returns their sum A+B**/
	public static int[][] sum(int[][] A, int[][] B){
		try{
			int[][] sum = new int[A.length][A[0].length];
			if(A==null || B==null){
				return null;
			}
			else{
				for(int i=0; i< A.length; i++){
					for(int j=0; j< A[0].length; j++){
						sum[i][j] = A[i][j] + B[i][j];
					}
				}
				return sum;
			}//else
		}//try
		catch(ArrayIndexOutOfBoundsException e){
			return null;	
		}//catch
	}//sum method
/************************************************************************/	
	/**Method 2: Given two m*n matrices A and B, returns their difference A-B**/
	public static int[][] difference(int[][] A, int[][] B){
		try{
			int[][] diff = new int[A.length][A[0].length];
			if(A==null || B==null){
				return null;
			}
			else{
				for(int i=0; i< A.length; i++){
					for(int j=0; j< A[0].length; j++){
						diff[i][j] = A[i][j] - B[i][j];
					}
				}
				return diff;
			}//else			
		}//try
		catch(ArrayIndexOutOfBoundsException e){
			return null;
		}//catch	
	}//difference method
/************************************************************************/	
	/**Method 3: Given m*n matrix A and scalar r, returns their product rA**/
	public static int[][] intMultiplication(int[][] A, int B){
		try{
			int[][] scalar = new int[A.length][A[0].length];
			if(A==null || B==0){
				return null;
			}
			else{
				for(int i=0; i< A.length; i++){
					for(int j=0; j< A[0].length; j++){
						scalar[i][j]= A[i][j] * B;
					}
				}
				return scalar;	
			}
		} catch(ArrayIndexOutOfBoundsException e){
			return null;
		}//catch
	}//intMultiplication method
/************************************************************************/	
	/**Method 4: Given an m*n matrix A and an n*p matrix B, returns their product AB**/
	public static int[][] matrixProduct(int[][] A, int[][] B){
		try{
			int[][] product = new int[A.length][B[0].length];
			if(A.length == B[0].length){
				for(int i=0; i<A.length; i++){
					for(int j=0; j<B[0].length; j++){
						for(int k=0; k< A[0].length; k++){
							product[i][j] += + A[i][k] * B[k][j];
						}
					}
				}
				return product;	
			}
			else{
				System.out.println("Incompatible dimensions.");
				return null;
			}
		}//try
		catch(ArrayIndexOutOfBoundsException e){
			return null;
		}//catch
	}//matrixProduct method
/************************************************************************/
	/**Method 5: Given an m*n matrix A, returns its transpose A^T**/
	public static int[][] transpose(int[][] A){
		try{
			int[][] transp = new int[A[0].length][A.length];
			if(A==null){
				return null;
			}
			else{
				for(int i=0; i< A[0].length; i++){
					for(int j=0; j< A.length; i++){
						transp[i][j]= A[j][i];
					}
				}
				return transp;
			}//else
		}//try
		catch(ArrayIndexOutOfBoundsException e){
			return null;
		}//catch
	}//transpose method
/************************************************************************/
	/**Method 6: verifies wheather a given n*n matrix A is symmetric**/
	public static Boolean isSymmetric(int[][] A){
		Boolean symmetric = true;
		while(true){
			try{
				if(A==null){
					return null;
				}
				else if(A.length != A[0].length){
					System.out.println("Not a squared matrix.");
					return false;
				}
				else{
					for(int i=0; i< A.length; i++){
						for(int j=0; j< A[0].length; j++){
							if(A[i][j] != A[j][i]){
								symmetric = false;
								break;
							}
						}
					}
					return symmetric;
				}//else
			}//try
			catch(ArrayIndexOutOfBoundsException e){
				return null;
			}//catch
		}//while 
	}//isSymmetric method
/************************************************************************/
	/**Method 7: given an n*n matrix A and a positive integer k computes A^k**/
	public static int[][] pow(int[][] A, int k){
		try{
			int[][] matrix = A;
			if(k>=0){
				for(int n=0; n< k; n++){
					matrix = matrixProduct(matrix, A);
				}
				return matrix;
			}
			else{
				System.out.println("Invalid input for k.");
				return null;
			}//else	
							
		} catch(ArrayIndexOutOfBoundsException e){
			return null;
		}//catch
	}//pow method
	
}//class