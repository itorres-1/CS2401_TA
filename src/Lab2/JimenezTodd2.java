package Lab2;

/* Name: Eduardo A. Jimenez Todd        */
/* Assignment: Lab 1                    */
/* Instructor: Dr. Julio Cesar Urenda   */
/* T.A.: Isaac Torres                   */
/* Last Modification: 6/16/2017         */
/* Purpose: Manipulate arrays           */

import java.io.IOException;
//TODO Style (Does not throw IOException, caught by your catch!
//TODO -Design, some of your methods overwrite the original information!
//TODO Javadoc comments are good but could be better

/**
 * This class is used to determine if a given array is a permutation, computes its composition with another array, computes its inverse, its power, and a random permutation of the same length
 * @author Eduardo Jimenez Todd
 */
public class JimenezTodd2 {	
/**
*This method returns the sum of 2 given arrays
*@param a First array
*@param b Second array
*@return Array with the sum of a and b
*@throws IOException Input mistake
*/
	public static int[][] sum(int[][] a, int[][] b)throws IOException{
		try{
			for (int i=0;i<a.length;i++)
			for (int j=0;j<a[i].length;j++)
				a[i][j]+=b[i][j];
			return a;
		}
		catch(Exception e){return null;}
	}
/**
*This method returns the difference of 2 given arrays
*@param a First array
*@param b Second array
*@return Array with the difference of a and b
*@throws IOException Input mistake
*/
	public static int[][] difference(int[][] a, int[][] b)throws IOException{
		try{
			for (int i=0;i<a.length;i++)
				for (int j=0;j<a[i].length;j++)
					a[i][j]-=b[i][j];
			return a;
		}
		catch(Exception e){return null;}
	} 
/**
*This method returns an array with each value multiplies times a ginen integer.
*@param a Array
*@param k Factor of the array
*@return Array multiplied times a constant k
*@throws IOException Input mistake
*/
	public static int[][] intMultiplication(int[][] a, int k)throws IOException{
		try{
			for (int i=0;i<a.length;i++)
				for (int j=0;j<a[i].length;j++)
					a[i][j]*=k;
			return a;
		}
		catch(Exception e){return null;}
	} 
	
	public static int[][] matrixProduct(int[][] a, int[][] b)throws IOException{
		try{
			int[][] c=new int[a.length][a.length];
			for (int i=0;i<a.length;i++)
				for (int j=0;j<b[i].length;j++)
					for (int k=0;k<a[i].length;k++)
						c[i][j]+=a[i][k]*b[k][j];
			return c;
		}
		catch(Exception e){return null;}
	}
/**
*This method returns the transpose of a given array. The transpose of an array contains the same elements but changes the rows to the columns and viceversa.
*@param a Array to transpose
*@return Transposition of the array
*@throws IOException Input mistake
*/
	public static int[][] transpose(int[][] a)throws IOException{
		try{
			int[][] b = new int[a[0].length][a.length];
			for (int i=0;i<a.length;i++)
				for (int j=0;j<a[i].length;j++)
					b[j][i]=a[i][j];
			return b;
		}
		catch(Exception e){return null;}
	}
/**
*This method checks if a given array is symmetric
*@param a Array
*@return True if symmetric, false if not symmetric
*@throws IOException Input mistake
*/
	public static Boolean isSymmetric(int[][] a)throws IOException{
		try{
			int[][] b=new int[a[0].length][a.length];
			b=transpose(a);
			for (int i=0;i<a.length;i++)
				for (int j=0;j<a[i].length;j++)
					if (a[i][j]!=b[i][j])
					   return false;
			return true;
		}
		catch(Exception e){return null;}
	}
/**
*This method returns an array computed to a given power
*@param a Array
*@param k Power
*@return Array multiplied times itself k times
*@throws IOException Input mistake
*/
	public static int[][] pow(int[][] a, int k)throws IOException{
		try{
			int[][] b=a;
			for (int i=1;i<k;i++)
				b=matrixProduct(b,a);
			return b;
		}
		catch(Exception e){return null;}
	}
	
	public static void main (String[] args){}
}