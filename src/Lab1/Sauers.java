package Lab1;

/**
* 	Phillip Sauers
*	CS2401 Lab Assignment 1
*	6/20/17
**/

import java.io.*;
import java.util.*;

public class Sauers
{
	
	public static Scanner input = new Scanner(System.in);
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
	
	public static int[] readFile(String userpath) {
		try{
			File arrays = new File(userpath);
			Scanner input = new Scanner(arrays);
			int k = input.nextInt();
			input.nextLine();
			try {
				int[] testArray = new int[k];
				for (int x = 0; x < testArray.length; x++) {
					testArray[x] = input.nextInt();
				}
				return testArray;
			} catch(Exception e) {
				System.out.println("ERROR: You have more than one array in the file! " + e.getMessage());
			} 
		}catch(FileNotFoundException a) {
			System.out.println("ERROR: " + a.getMessage());
		}return null;
	}
	
	public static Boolean isPermutation(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= array.length) {
				System.out.println("Array is not a valid permutation!");
			}
		}
		int sum = 0;
		for (int j = 0; j < array.length; j++) {
			sum = sum + array[j];
		}
		if (checkSum(array.length) == sum) {
			System.out.println("Array is a valid permutation.");
			return true;
		} else {
			System.out.println("Array is not a valid permutation!");
			return false;
		}
	}
	
	/**recursive sequence - the permutation check should always work here. As long as the above check is true (no elements j are >= k),
	*  the sum of the elements (assuming the array is a permutation) should always work out to a specific number (the sum of the last (k-1) numbers + (k-1))
	*/
	
	public static int checkSum(int k) {
		if (k == 0) {
			return 0;
		} else {
			return checkSum(k - 1) + (k - 1);
		}
	}
	
	public static int[] inverse(int[] array) {
		int[] inverse = new int[array.length];
		for (int i = 0; i < inverse.length; i++) {
			inverse[i] = i;																		//grab the identity permutation.
		}
		inverse = composition(array,inverse);													
		System.out.print("The inverse array is ");
		return inverse;
	}
	
	public static int[] composition(int[] array,int[] array2) {
		int[] compositeArray = new int[array.length];
		for (int i = 0; i < compositeArray.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i) {
					for (int k = 0; k < array2.length; k++) {
						if (array2[k] == j) {
							compositeArray[i] = k;
						}
					}
				}
			}
		}
		return compositeArray;
	}
	
	public static int[] pow(int[] array, int k) {
		if (k == 2) {
			return composition(array,array);
		} else if (k < 2) {
			return array;
		} else {
			return composition(pow(array,k-1),array);
		}
	}
	
	public static int[] randomArray(int length) {											//Generates a random array of length k from 0 to k-1.
		int[] rArray = new int[length];
		for (int i = 0; i < rArray.length; i++) {
			rArray[i] = i;															
		}
		Random rand = new Random();														
		for (int i = 0; i < rArray.length; i++) {											//This is like the third or fourth way I've written this method.
			int index = rand.nextInt(rArray.length);										//I'm a little surprised I even got it to work.
			int temp = rArray[i];
			rArray[i] = rArray[index];
			rArray[index] = temp;
		} 
		System.out.print("Your random array is: ");
		printArray(rArray);
		return rArray;
	}
		
//	public static void main(String[] args) {
//		boolean exit = false;
//		String userPath = "";
//		int userChoice = 0;
//
//		if(exit) {
//			System.exit(0);
//		}
//
//		System.out.print("Please enter the desired file path: ");
//		userPath = input.next();
//		if (userPath.toLowerCase() == "exit") {
//			exit = true;
//		}
//		int[] userArray = readFile(userPath);
//
//		while (!exit) {
//			System.out.println("\n\nWhat would you like to do today? (Enter a numerical value): \n1. Path (change file path) \n2. Print (prints current array(s))");
//			System.out.println("3. Permutation (calculate whether the current array is a permutation) \n4. Inverse (calculate the inverse of the current array)");
//			System.out.println("5. Composition (calculate the composition of two arrays) \n6. Exponent (calculates an array composed to itself k times)");
//			System.out.println("7. Random (Calculates a random array) \n8. Exit (quits) \nPlease enter your option: ");
//			userChoice = input.nextInt();
//			switch (userChoice) {
//				case 1:
//					System.out.print("Please enter the filepath you would like: ");
//					userPath = input.next();
//					userArray = readFile(userPath);
//					System.out.println("Success! Filepath changed to " + userPath);
//					break;
//				case 2:
//					System.out.print("The current array is ");
//					printArray(userArray);
//					break;
//				case 3:
//					permutation(userArray, userArray.length);
//					break;
//				case 4:
//					calculateInverse(userArray);
//					break;
//				case 5:
//					System.out.println("Would you like to specify a path to a second array or randomly generate a new one?");
//					System.out.print("Enter 'Path' to specify a path, or 'Random' to generate a new array. (Case sensitive): ");
//					String answer = input.next();
//					switch (answer) {
//						case "Path":
//							System.out.print("Please enter the filepath to the second array: ");
//							userPath = input.next();
//							int[] userArray2 = readFile(userPath);
//							System.out.print("\nYour composite array is: ");
//							printArray(composition(userArray2, userArray));
//							break;
//						case "Random":
//							userArray2 = randomArray(userArray.length);
//							System.out.print("\nYour composite array is: ");
//							printArray(composition(userArray2, userArray));
//							break;
//					} break;
//				case 6:
//					System.out.print("Please enter a positive integer value for k: ");
//					int power = input.nextInt();
//					printArray(pow(power, userArray));
//					break;
//				case 7:
//					System.out.print("Please enter the desired length for the random array: ");
//					int length = input.nextInt();
//					userArray = randomArray(length);
//					break;
//				case 8:
//					System.out.println("Thank you!");
//					exit = true;
//					break;
//				default:
//					System.out.println("Input not recognized!");
//					break;
//			}
//		}
//	}
}