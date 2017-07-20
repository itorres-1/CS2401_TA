/**
 * Name:	Francisco Antunez
 * Date:	06-20-2017
 * Lab1
 */
import java.util.Scanner;
import java.io.*;

/* 
 * 5 methods
 * error handling
 * readFromFile().int[]
 * isPermutation(int[]) return(true/false)
 * comp(f[], g[])
 * inverse(int[]) returns(inverse int[])
 * pow(int[], k) return(k comp of int[])		f;f;f...f^k
 * Extra (5pt)	randomPermutation()
 *
 */
public class Atunez {
/**
 * Gets the k value used in the pow method by reading user input, and changing it to an integer
 * @return int[]
 * @throws NumberFormatException
 */
	public static int userKInput(){
		int k = 0;
		Boolean input = false;
		do{
			System.out.print("Input k value. (v^k): ");
			try{
			Scanner scnr = new Scanner(System.in);
			k = Integer.parseInt(scnr.nextLine());
			if (k <= 0){
				throw new NumberFormatException();
			}
			input = true;
			}
			catch (NumberFormatException e) {
				System.out.println("please use an integer greater than zero.");
			}
		}
		while (!input);
		return k;
	}
/**
 * Called when an array from type int is needed to be read from a file, and saved into an array, but only if the element is less than the size of the index.
 * @return int[]
 * @throws FileNotFoundException
 * @throws IOException
 * @throws NumberFormatException
 */
	public static int[] readFromFile() {
		
	Scanner scnr = new Scanner(System.in);
	FileReader fr;
	BufferedReader reader;
	int[] set = null;

	Boolean successfulFileRead = false;
	while (!successfulFileRead){
		System.out.print("File Path: ");
		try{
			fr = new FileReader(scnr.nextLine());
			reader = new BufferedReader(fr);

			int k = Integer.parseInt(reader.readLine()); //This wouldn't wark with first line not int
			String[] intString = reader.readLine().split(" ");
			if ( k != intString.length){
				throw new IOException();
			}

			set = new int[intString.length];

			//now convert strings to int array
			for(int i = 0; i < intString.length; i++){
				set[i] = Integer.parseInt(intString[i]);
			}

			//then return
			successfulFileRead = isPermutation(set);

		}
		catch (FileNotFoundException e){
			System.out.println("File not found!");
		}
		catch (IOException e) {
			System.out.println("Something is wrong");
		}
		catch (NumberFormatException e) {
			System.out.println("please use numbers");
		}
	}
return set;	
}
/**
 * This method compares each element to every other element except for itself
 * returns false if elements match and prints out that it is not a permutation.
 * @param  set a set of numbers saved in an array of integers
 * @return Boolean
 */
	public static Boolean isPermutation(int[] set){
		for(int i = 0; i < set.length; i++){
			for(int j = 0; j < set.length; j++){
				if (j == i) {				// this is where it stops it from checking itself with itself
					if(i == set.length-1 && j == set.length-1)
						break;
					j++;
				}
				if ((set[i] == set[j]) || (set[i] > set.length-1) || (set[i] < 0)){
					System.out.println("this is not a permutation");
					
					return false;
				}
			}
		}
		return true;
	}
/**
 * Returns the composition of the two input arrays when g is computed, and f is composed of the result of g.
 * @param f The second parameter f is computed after g is computed
 * @param g The first parameter g is computed first
 * @return int[]
 */
	public static int[] comp(int[] g, int[] f){
		while(g.length == f.length) {
			int[] compArr = new int[f.length];
			for(int i = 0; i < f.length; i++){
				compArr[i] = f[g[i]];
			}
			return compArr;
		}
		System.out.println("lengths do not match please try entering files again");
		return comp(readFromFile(), readFromFile());
	}
/**
 * This method gets the inverse of a given array, and returns it
 * set the value of the new array at the index of the value of the given array to the index
 * @param set a set of numbers saved in an array of integers
 * @return int[]
 */
	public static int[] inverse(int[] set){
		int[] setNew = new int[set.length];

		for(int i = 0; i < set.length; i++){
			setNew[set[i]] = i; // 
		}
		return setNew;
	}
/**
 * This method takes the composition of a set with itself k times, and returns it.
 * @param k k is what the set is raised to
 * @param set a set of numbers saved in an array of integers
 * @return int[]
 */
	public static int[] pow(int k, int[] set){
		int [] setNew = new int[set.length];
		for(int j = 0; j < set.length; j++) {
			setNew[j] = set[j];
		}
		if (k == 1){
			return set;
		}
		if (k > 1){
			for(int i = 1; i < k; i++){
				setNew = comp(set, setNew);
			}

		}
		return setNew;
	}
/**
 * Prints out the contents of arrays returned from other methods
 * @param set a set of numbers saved in an array of integers
 */
	public static void print(int[] set){
		for(int i = 0; i < set.length; i++){
			System.out.print(set[i] + " ");
		}
		System.out.println();
	}

/**
 * runs through all other methods
 */
	public static void main(String[] args) {
		int k;
		Scanner scnr = new Scanner(System.in);


		if(isPermutation(readFromFile())) {
			System.out.println("This is a permutation");
		}

		System.out.println();

		System.out.println("Composition of two arrays");
		print(comp(readFromFile(), readFromFile()));
		System.out.println();

		System.out.println("Inverse");
		print(inverse(readFromFile()));
		System.out.println();
		
		System.out.println("Power");

		do {
			print(pow(userKInput(), readFromFile()));
			System.out.println();
			System.out.println("continue? (enter no to quit)");
		}
		while (!scnr.next().equals("no"));
		System.out.println("bye");

	}
}
