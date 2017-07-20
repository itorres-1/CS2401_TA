package Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import Lab1.*;

/**
 * The Class GuerecaBerumen
 * @author Jesus Guereca Berumen
 * @version 1.3
 * @since 6/20/2017
 */

public class GuerecaBerumen {
	
	//ReadFromFile doesn't work
	//Explain isPermutation graphically
	//Inverse doesn't check if input array is permutation or not
	//Inverse isn't correct
	//Power doesn't work
	//Explain Randomshuffle (i.e. what's a list? Arraylist? Where did you learn of collections?
	
	/**
	   * This is the main method which makes 
	   * use of all created methods which
	   * where needed for the lab
	   * @param args Unused.
	   */
//	static public void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		//String //file"";
//		int[] array1;
//		int[] array2;
//		int power = -1;
//		//Permutation Checker
//		System.out.println("Permutation Checker");
//		//fileuserInput(in,"File Location:");
//		array1 = Lab1.readFromFile();
//		System.out.println(isPermutation(array1));
//
//		//Composition
//		System.out.println("Composition");
//		while(true){
//
//			while(true){
//				//fileuserInput(in,"Array 1 - File Location:");
//				array1 = Lab1.readFromFile();
//				if(isPermutation(array1))
//					break;
//			}
//
//			while(true){
//				//fileuserInput(in,"Array 2 - File Location:");
//				array2 = Lab1.readFromFile();
//				if(isPermutation(array2))
//					break;
//			}
//
//			if(array1.length == array2.length)
//				break;
//		}
//		printArray(composition(array1,array2));
//
//		//inverse
//		System.out.println("\nInverse");
//		//fileuserInput(in,"File Location:");
//		array1 = Lab1.readFromFile();
//		printArray(inverse(array1));
//
//		//power
//		System.out.println("\nPower");
//		//fileuserInput(in,"File Location:");
//		array1 = Lab1.readFromFile();
//		while(true){
//			power = in.nextInt();
//			if(power > 0)
//				break;
//			System.out.println("Integer must be positive");
//		}
//		printArray(power(array1,power));
//
//		//Random Permutation
//		System.out.println("Random Permutation");
//		//fileuserInput(in,"File Location:");
//		array1 = Lab1.readFromFile();
//		printArray(randomPermutation(array1));
//
//		in.close();
//	}
	
	/**
	 * Reads from file and continues asking if
	 * file contains non integer character or
	 * first value does not match length of second line
	 * also handles all exception with reading data
	 * from file
	 * @param in Scanner that takes user inputs
	 * @param fileLocation the file location
	 * @return the int[] array containing the files second line
	 */
	static public int[] readFromFile(Scanner in,String fileLocation){
		File FILENAME = new File(fileLocation);
        Scanner b = null;
        int[] array = null;
        int arrayLength;
		try {
			b = new Scanner(FILENAME);
			arrayLength = Integer.parseInt(b.next());
			array = new int[arrayLength];
			String secondLine = b.nextLine();
	        for(int index = 0; index < array.length; index++){
	            array[index] = b.nextInt();
	        }
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			return readFromFile(in,userInput(in,"File Location:"));
		} catch(NoSuchElementException e){
			System.out.println("Elements do not match");
			return readFromFile(in,userInput(in,"File Location:"));
		} catch(NumberFormatException e){
			System.out.println("Data in file are not integers");
			return readFromFile(in,userInput(in,"File Location:"));
		}
		//if more elements in file than arrayLength
		if(b.hasNext()){
			System.out.println("Elements do not match");
			return readFromFile(in,userInput(in,"File Location:"));
		}
        b.close();
		return array;
	}
	
	/**
	 * Checks given array for all values from 0
	 * to one less than the length of the array
	 * @param array the array
	 * @return true, if is permutation
	 */
	static public boolean isPermutation(int[] array){
		int check;
		for(int a = 0; a< array.length;a++){
			check = 0;
			for(int index = 0;index < array.length;index++){
				if(a == array[index])
					check++;
				if(check > 1)
					return false;
			}
			if(check <= 0)
				return false;
		}
		return true;
	}
	
	/**
	 * takes the composition f of g
	 * @param f the first given array
	 * @param g the second given array
	 * @return fog which is the composition f of g
	 */
	static public int[] composition(int[] f, int[] g){
		int[] fog = new int[f.length];
		for(int index = 0;index < f.length;index++){
			fog[index] = f[g[index]];
		}
		return fog;
	}
	
	/**
	 * reverses the order of the values
	 * int he given array
	 * @param array is the given array
	 * @return array2 the reversed array
	 */
	static public int[] inverse(int[] array){
		int[] array2 = new int[array.length];
		for(int index = 0;index < array.length;index++){
			array2[index] = array[array.length - index - 1];
		}
		return array2;
		
	}
	
	/**
	 * calculates the power of the given 
	 * array k times
	 * @param array the given array
	 * @param k the power to calculate the array to
	 * @return the int[]
	 */
	static public int[] power(int[] array,int k){
		int f2[] = new int[array.length];
		for(int index = 0;index < array.length;index++){
			f2[index] = index;
			for(int i = 0; i < k;i++){
				f2[index] = array[f2[index]];
			}
		}
		return f2;
	}
	
	/**
	 * Randomly rearranges the values in
	 * the given array to create a possiblly
	 * new array
	 * @param array the given array
	 * @return array2 the new permutation
	 */
	//Extra Credit
	static public int[] randomPermutation(int[] array){
		int[] array2 = new int[array.length];
		List<Integer>list = new ArrayList<Integer>();
		for(int index = 0; index < array.length;index++){
			list.add(array[index]);
			array2[index] = array[index];
		}
		Collections.shuffle(list);
		for(int index = 0; index < array.length;index++){
			array2[index] = list.get(index);
		}
		return array2;
	}
	
	//Extra Methods
	/**
	 * Handles User input.
	 * @param text shown on console next to where you type
	 * @return string containing the user input
	 */
	private static String userInput(Scanner in, String text){
		System.out.print(text);
		String string = in.next();
		return string;
	}
	
	/**
	 * Prints the given array.
	 *
	 * @param array is given permutation
	 * @return nothing
	 */
	private static void printArray(int[] array){
		System.out.print("[ ");
		for(int element : array){
			System.out.print(element + " ");
		}
		System.out.print("]");
	}
}
