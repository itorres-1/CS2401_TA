package Lab1;

/**
* Tanabe, Maria
* Lab1
* Dr. Julio Cesar Urenda
* Isaac Torres
* 6/24/2017
* Manipulating Arrays
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class Tanabe {
	//Javadoc make sure param name matches actual param
//	public static void main(String [] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
//		if (isPermutation(read())){
//			System.out.println("This is a permutation.");
//		}
//		else{
//			System.out.println("This is not a permutation.");
//		}
//		System.out.println(Arrays.toString(composition(read(), read())));
//		System.out.println("The inverse is: ");
//		System.out.println(Arrays.toString(inverse(read())));
//		System.out.println("Please enter an integer for k:  ");
//		int k = scan.nextInt();
//		System.out.println(Arrays.toString(timesK(read(),k)));
//		System.out.println("Please enter the length of the random array: ");
//		int x = scan.nextInt();
//		System.out.println(Arrays.toString(randomComposition(x)));
//	}
	/**
	 * The method tries to read a file with a user-given path, if the path fails, it prints an error message.
	 * @return The method returns the array that should be found in the file. If the file path is incorrect, the method returns an array {0}, in order to satisfy the method's return requirements.
	 */
	public static int[] read () {
		boolean t = false;
		while (!t) {
			try {
				Scanner scnr = new Scanner(System.in);
				System.out.print("Please enter a file: ");
				String file = scnr.nextLine();
				FileInputStream fiBS = new FileInputStream(file);
				Scanner inFS = new Scanner(fiBS);
				int size = inFS.nextInt();
				int[] f = new int[size];
				for (int i=0; i<f.length; i++) {
					f[i] = inFS.nextInt();
				}
				t = true;
				return f;
			}
			catch (IOException e) {
				System.out.println("Invalid input");
			}
		}
	int [] f= {0};
	return f;
	}
	/**
	 * This method confirms if an array is a permutation by going through each element
	 * @param p is the array being looked through
	 * @return true if permutation, otherwise return flase
	 */
	public static boolean isPermutation (int[] p) {
		for (int i=0; i<p.length; i++){
			for (int j=1; j<p.length; j++){
				if((p[i] == p[j])){
					return false;
				}
				else{
					return true;
				}
			}
		}
		return true;
	}
	/**
	 * This method produces a new array composed of 2 arrays
	 * @param x
	 * @param y
	 * @return Returns the new array composition
	 */
	public static int[] composition (int[] x, int[] y) {
		if (!(isPermutation(x) && isPermutation(y))) {
			System.out.print("This is not a permutation.");
			int[] z = {0};
			return z;
		}
		else {
			int [] composed = new int[x.length];
			for (int i=0; i<x.length; i++) {
				composed[i] = x[y[i]];
			}
		return composed;
		}
	}
	/**
	 * This method produces the inverse of an array give an array read from file
	 * @param v array
	 * @return returns inverse of array
	 */
	public static int[] inverse (int[] v) {
		if (!isPermutation(v)) {
			System.out.print("This is not a permutation.");
			int[] x = {0};
			return x;
		}
		int [] n = new int[v.length];
		for (int i=0; i<v.length; i++) {
			n[v[i]] = i;
		}
		return n;
	}
	/**
	 * This method produces an array by k kimes.
	 * @param b array to be composed k times
	 * @param c integer
	 * @return Returns the newly composed array.
	 */
	public static int[] pow (int[] b, int c) {
		if (!isPermutation(b)) {
			System.out.print("This is not a permutation.");
			int[] x = {0};
			return x;
		}
		int[] composed = new int[b.length];
		for (int f=1; f<c; f++) {
			composed = composition(b,b);
		}
		return composed;
	}
	/**
	 * This method produces a random permutation given a length
	 * @param d is length of random permutaition
	 * @return returns random permutation
	 */
	public static int[] randomComposition (int d) {
		Random rnd = ThreadLocalRandom.current();
		int[] h = new int[d];
		for (int i=0; i<d; i++) {
			h[i] = i;
		}
		for (int k = h.length - 1; k > 0; k--) {
			int t = rnd.nextInt(k + 1);
			int s = h[t];
			h[t] = h[k];
			h[k] = s;
		}
		return h;
	}
}
