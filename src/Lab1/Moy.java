package Lab1;

/**
* Name: Hao T. Moy 
* Assignment: Lab1 
* Instructor: Dr. Julio Cesar Urenda 
* T.A.: Isaac Torres
* Last Modification: 6/21/2017
* Purpose: Array manipulation
*/ 

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner; 
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Moy {

	/**
	 * The method tries to read a file with a user-given path, if the path fails, it prints an error message.
	 * @return The method returns the array that should be found in the file. If the file path is incorrect, the method returns an array {0}, in order to satisfy the method's return requirements. 
	 */
	public static int[] read () {
		boolean tr = false; 
		while (!tr) { 
			try {
				Scanner scnr = new Scanner(System.in);
				System.out.print("Enter file path: ");
				String dire = scnr.nextLine();
				FileInputStream fiBS = new FileInputStream(dire);
				Scanner inFS = new Scanner(fiBS); 
		
				int size = inFS.nextInt();
				int[] b = new int[size]; 
				for (int i=0; i<b.length; i++) { 
					b[i] = inFS.nextInt(); 
				}
				System.out.println(" "); 
				tr = true;
				return b; 
			}
			catch (IOException e) {
				System.out.println("Wrong input please try again."); 
			}
	}
		
	int [] b = {0};
	return b;
	}	
		
	/**
	 * This method checks if an array is a permutation by browsing through each element looking for repetitions. 
	 * @param a array to browse through. 
	 * @return Boolean true if the array is a permutation, and false if it is not. 
	 */
	public static boolean isPermutation (int[] a) { 
		
		for (int i=0; i<a.length; i++) { 
			for (int j=1; j<a.length; j++) { 
			   return (a[i] == a[j]) ? false :  true; 
			}
		}
		return false;
	}
	/**
	 * This method creates a new array composed of two user given arrays. 
	 * @param f array
	 * @param g array
	 * @return This method returns the newly composed array.
	 */
	public static int[] composition (int[] f, int[] g) {
		if (!(isPermutation(f) && isPermutation(g))) {
			System.out.print("The array is NOT a permutation!");
			int[] x = {0};
			return x; 
		}
		else {
			int [] com = new int[f.length];
			for (int k=0; k<f.length; k++) { 
				com[k] = f[g[k]]; 
			}
		return com;
		}
	}
	/**
	 * This method constructs an array inverse to the user given array by asigning the new array's 
	 * @param a array. 
	 * @return Returns a new int array inverse to the received int array. 
	 */
	public static int[] inverse (int[] a) { 
		if (!isPermutation(a)) {
			System.out.print("The array is NOT a permutation!");
			int[] x = {0};
			return x;
		}
		int [] b = new int[a.length];
		for (int i=0; i<a.length; i++) {  
			b[a[i]] = i; 
		}
		return b; 
	}
	/**
	 * This method computes the composition of a user given array k times. K being a user given integer.
	 * @param a array to be composed k times 
	 * @param k integer
	 * @return Returns the newly composed array. 
	 */
	public static int[]  pow(int[] a, int k) {
		if (!isPermutation(a)) {
			System.out.print("The array is NOT a permutation!");
			int[] x = {0};
			return x; 
		}
		int[] com = new int[a.length]; 
		for (int m=1; m<k; m++) { 
			com = composition(a,a); 
		}
		return com; 
	} 
	/**
	 * This method creates a random permutation of user specified length. 
	 * @param a integer specifying the length of the permutation. 
	 * @return Returns a random permutation array. 
	 */
	public static int[] randomComposition (int a) {
		Random rnd = ThreadLocalRandom.current();
		int[] b = new int[a];
		for (int i=0; i<a; i++) {
			b[i] = i;
		}
		for (int j = b.length - 1; j > 0; j--) {
			int r = rnd.nextInt(j + 1);
			int k = b[r];
			b[r] = b[j];
			b[j] = k;
		}
		return b;
	}
	
//	public static void main(String [] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
//
//		System.out.println("isPermutation:");
//		if (isPermutation(read()))
//			System.out.println("The given array is a permutation!");
//		else
//			System.out.println("The given array is NOT a permutation!");
//
//		System.out.println(" ");
//		System.out.println("Composition: ");
//		System.out.println(Arrays.toString(composition(read(), read())));
//
//		System.out.println(" ");
//		System.out.println("Inverse: ");
//		System.out.println(Arrays.toString(inverse(read())));
//
//		System.out.println(" ");
//		System.out.println("kTimes: ");
//		System.out.println("Enter the number of timer you would like to compose the array in the file: ");
//		int k = scan.nextInt();
//		System.out.println(Arrays.toString(kTimes(read(), k)));
//
//		System.out.println(" ");
//		System.out.println("randomComposition: ");
//		System.out.println("Enter the length of the random composition array: ");
//		int l = scan.nextInt();
//		System.out.println(Arrays.toString(randomComposition(l)));
//	}
}