package Lab1;
/* Name: Eduardo A. Jimenez Todd        */
/* Assignment: Lab 1                    */
/* Instructor: Dr. Julio Cesar Urenda   */
/* T.A.: Isaac Torres                   */
/* Last Modification: 6/16/2017         */
/* Purpose: Manipulate arrays           */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.Math;

/**
 * This class is used to determine if a given array is a permutation, computes its composition with another array, computes its inverse, its power, and a random permutation of the same length
 * @author Eduardo Jimenez Todd
 */

public class JimenezTodd {
	//Explain readFromFile and isPerm and Random(just generates a random array or shuffles?)

	//readFromFile is incorrect,  parses 3\n1 0 2 3; explain this method; half cred
	//Composition crashes when input arrays are mismatched (!isPerm(A) || !isPerm(B)) not and!
	//Inverse doesn't check to make sure supplied array a permutation
	//Pow doesn't check if input is permutation and crashes when not
	//Pow is incorrect, has to do with k! 3/4 credit. also use array.clone()!






	public static int[] comp,inv,pow,ran;
	public static boolean per,correctFile;

	/**
	 * Reads a file and iven the array length, returns the array in the file
	 * @return Second line from .txt file as array
	 * @throws IOException
	 */
	public static int[] readFromFile()throws IOException {
		try{
			Scanner scnr=new Scanner(System.in);
			System.out.print("File directory: ");
			String fileDir=scnr.nextLine();
			FileInputStream fiS = new FileInputStream(fileDir);
			Scanner inFS = new Scanner(fiS);
			int[] ar= new int[inFS.nextInt()];
			for (int i=0;i<ar.length;i++)
				ar[i]=inFS.nextInt();
			correctFile=true;
			return ar;
		}
		catch(IOException e){
			System.out.println("Wrong input. Try again.");
			System.out.println();
			return readFromFile();
		}
	}

	/**
	 * Checks if a given array is a permutation
	 * @param a Array to check
	 * @return Boolean value indicating if the given array is a permutation or not
	 */
	public static boolean isPermutation(int[] a){
		//create boolean array from 0 to n-1 and set index to true if value exists in array
		boolean[] indexTest= new boolean[a.length];
		for (int i=0;i<a.length;i++){
			if (a[i]>=a.length) return false;
			indexTest[a[i]]=true;
		}
		//check if all values are true
		for(boolean i:indexTest)
			if(!i) return false;
		return true;
	}

	/**
	 * Computes the composition of arrays 'a' & 'b'
	 * @param a First array
	 * @param b Second array
	 * @return Composition of both
	 */
	public static int[] composition(int[]a,int[]b){
		if(!(isPermutation(a)&&(isPermutation(b)))){
			System.out.println("At least one array is not permutation.");
			correctFile=false;
			return a;
		}
		else{
			int[] c = new int[a.length];
			for (int i=0;i< a.length;i++)
				c[i]=a[b[i]];
			return c;
		}
	}

	/**
	 * Computes the inverse of the given array
	 * @param a Array to invert
	 * @return Inverse of array
	 */
	public static int[] inverse(int[] a){
		int[] b=new int[a.length];
		for (int i=0;i<b.length;i++)
			b[a[i]]=i;
		return a;
	}

	/**
	 * Computes the power of the given array to the k
	 * @param a Array to compute
	 * @param k Power
	 * @return Array a^k
	 */
	public static int[] power(int[] a,int k){
		int[] c=new int[a.length];
		for (int i=0;i<a.length;i++)
			c[i]=a[i];
		for (int i=0;i<k;i++)
			c=composition(c,a);
		return c;
	}

	/**
	 * Creates a random array with same length as given array
	 * @param a Array
	 * @return Random array
	 */
	public static int[] random(int[] a){
		int[] b=new int[a.length];
		boolean[] c =new boolean[a.length];
		for (int i=0;i<b.length;i++){
			while (c[b[i]]){
				int n = (int)(Math.random()*a.length);
				b[i]=n;
			}
			c[b[i]]=true;
		}
		return b;
	}

	public static void main (String[] args)throws IOException {
		while(!correctFile){
			System.out.println("isPermutation: ");
			per = isPermutation(readFromFile());
		}
		System.out.println(per);
		System.out.println();
		correctFile=false;
		
		while(!correctFile){
			System.out.println("Composition: ");
			comp=composition(readFromFile(),readFromFile());
		}
		for (int i=0;i<comp.length;i++)
			System.out.print(comp[i]+" ");
		System.out.println();
		System.out.println();
		correctFile=false;		
		
		while(!correctFile){
			System.out.println("Inverse: ");
			inv=inverse(readFromFile());
		}
		for (int i=0;i<inv.length;i++)
				System.out.print(inv[i]+" ");
		System.out.println();
		System.out.println();
		correctFile=false;
		
		while(!correctFile){
			System.out.println("Power: ");
			boolean isInt=false;
			int powNumber=0;
			while(!isInt){
				try{
					Scanner scnr=new Scanner(System.in);
					System.out.print("Enter power: ");
					powNumber=scnr.nextInt();
					isInt=true;
				}
				catch(Exception e){
					System.out.println("Wrong input. Try again.");
					System.out.println();
				}
			}
			pow=power(readFromFile(),powNumber);
		}
		for (int i=0;i<pow.length;i++)
				System.out.print(pow[i]+" ");
		System.out.println();
		System.out.println();
		correctFile=false;
		
		while(!correctFile){
			System.out.println("Random: ");
			ran=random(readFromFile());
		}
		for (int i=0;i<ran.length;i++)
				System.out.print(ran[i]+" ");
		
	}		
}