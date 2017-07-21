package Lab5; /**
 * Author: Francisco Antunez
 * Date: 7-18-2017
 * Course: CS2401
 */
import Testers.LabInterfaces.Lab5Interface;

import java.io.*;
import java.util.Arrays;

public class Antunez5 implements Lab5Interface {


	static int count = 0;
//	public static void main(String[] args) {
//
//		for (int i = 100; i <= 3200; i=i*2) {
//			gen(i);
//		}
//		count = 0;
////		System.out.println("Bubble");
//		for (int i = 100; i <= 3200; i=i*2) {
//			rBubbleSort(readFile("ArraySize" + i));
////			System.out.println(count);
//		}
////		System.out.println();
//		count = 0;
////		System.out.println("Insertion");
//		for (int i = 100; i <= 3200; i=i*2) {
//			rInsertionSort(readFile("ArraySize" + i));
////			System.out.println(count);
//		}
////		System.out.println();
//		count = 0;
////		System.out.println("Selection");
//		for (int i = 100; i <= 3200; i=i*2) {
//			rSelectionSort(readFile("ArraySize" + i));
////			System.out.println(count);
//		}
////		System.out.println();
//		count = 0;
////		System.out.println("Quick");
//		for (int i = 100; i <= 3200; i=i*2) {
//			iQuickSort(readFile("ArraySize" + i));
////			System.out.println(count);
//		}
////		System.out.println();
//	}

/**
 * method that generates a list of random integers of a given size
 * @param n the number of integers in the list
 */
	public static void gen(int n) {
		int[] numbers = new int[n];       
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*26 + 1); //change this
		}
		writeToFile(numbers, "ArraySize" + numbers.length);
	}

/**
 * method for writing to an integer array to a file named with array length
 * @param a integer array to be written to a file
 */
	public static void writeToFile(int[] a, String name) {
		try {
			FileWriter fw = new FileWriter(name);
			for (int i = 0; i < a.length; i ++) {
				fw.write(a[i] + " ");
			}
			fw.flush();
      		fw.close();
		}
		catch (Exception e) {
			System.out.print("nope");
		}
	}
	
/**
 * method to read integers from a file split by spaces
 * @param name name of the file to be read
 * @return returns the numbers in the file in the form of an integer array
 */
	public static int[] readFile(String name) {
		String line = null;
		int[] intArray = null;
		try {
			FileReader fr = new FileReader(name);
			BufferedReader br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(name));
			
			while ((line = br.readLine()) != null) {
				//split file save in array
				String[] str = line.split(" ");
				intArray = new int[str.length];
				for (int i = 0; i < str.length; i++) {
					intArray[i] = Integer.parseInt(str[i]);
				}
			}
		}
		catch (Exception e) {
			;
		}
		return intArray;
	}
/**
 * method used for printing a one dimensional array of integers
 * @param a array to be printed out
 */
	//print array
	public static void print(int[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
/**
 * Recursive version of bubble sort
 * @param a the array to be sorted
 * @param subArrayLength the length of the subarray
 * @return the sorted array
 */
	//real bubble sort
	public static int[] actualBubbleSort(int[] a, int subArrayLength, boolean keepGoing) {
		if (subArrayLength >= a.length && !keepGoing){
			return a;
		}
		keepGoing = false;
		int tmp;
		for (int i = 0; i < a.length - subArrayLength; i++){
			count++;
			if (a[i] > a[i+1]){
				tmp = a[i];
				a[i] = a[i+1];
				a[i+1] = tmp;
				keepGoing = true;
			}
		}
		return actualBubbleSort(a, subArrayLength+1, keepGoing);
	}

	//recursive bubble
	public void rBubbleSort(int[] a) {
		actualBubbleSort(a, 1, true);
	}
/**
 * Recursive version of selection sort
 * @param a the array to be sorted
 * @param subArrayLength the length of the subarray
 * @return the sorted array
 */
	//real selection
	public static int[] actualSelectionSort(int[] a, int subArrayLength) {
			if (subArrayLength == 0){
				return a;
			}

			int tmp;
			int minIndex = a.length - subArrayLength;
			int firstIndex = a.length - subArrayLength;
			for (int i = firstIndex; i < a.length; i++) {
				if (a[minIndex] > a[i]) {
					//int min = a[i];
					minIndex = i;
				}
				count++;
			}
			if (minIndex != firstIndex) {
				tmp = a[firstIndex];
				a[firstIndex] = a[minIndex];
				a[minIndex] = tmp;
			}

			return actualSelectionSort(a, subArrayLength-1);
	}
/**
 * method to initiate selection sort
 * @param a array to be sorted
 */
	public void rSelectionSort(int[] a){
			actualSelectionSort(a, a.length);
		}

/**
 * Recursive version of Insertion sort
 * @param a the array to be sorted
 * @param subArrayLength the length of the subarray
 * @return the sorted array
 */
	public static int[] actualInsertionSort(int[] a, int subArrayLength) {
			if (subArrayLength == 0) {
			return a;
		}

		int small = a[a.length - subArrayLength];
		int tmpIndex, swap;
		int currentIndex = a.length - subArrayLength;
		int currentElement = a[currentIndex];
		int i;

		for (i = currentIndex -1; i >= 0 && a[i] > currentElement; i--) {
			a[i + 1] = a[i];
			count++;
		}
		a[i+1] = currentElement;
		return actualInsertionSort(a, subArrayLength - 1);
	}
/**
 * method to initiate insertion sort
 * @param a array to be sorted
 */
	//recursive insertion

	public void rInsertionSort(int[] a) {
		actualInsertionSort(a, a.length);
	}

/**
 * Iterative version of quick sort that crashes most of the time
 * @param list the array to be sorted
 */
	public void iQuickSort(int[] list) {
		int first = 0;
		int last = list.length - 1;
		partition(list, first, last);
	}

/**
 * similar to the recursive call of quick sort when the higher index becomes the pivot
 * @param list array that is being sorted
 * @param high larger index returned by the partition method
 */
	public static void high(int[] list, int high) {
		int first = 0;
		int pivotIndex = high;
		int last = pivotIndex - 1;
		partition(list, first, last);
	}

/**
 * similar to the recursive call of quick sort when the lower index is the pivot
 * @param list array that is being sorted
 * @param first index returned by the partition method
 */
	public static void low(int[] list, int first) {
		int last = list.length - 1;
		int pivotIndex = first;
		first = pivotIndex + 1;
		if (last > first) {
			partition(list, first, last);
		}
	}

/**
 * partition method almost the same as the original recursive quick sort
 * @param list array that is being sorted
 * @param first element to be set as pivot
 * @param last last element being compared
 */
	public static void partition(int[] list, int first, int last) {
		int pivot = list[first];
		int low = first + 1;
		int high = last;
		while (high > low) {
			while (low <= high && list[low] <= pivot)
			low++;
			while (low <= high && list[high] > pivot)
			high--;
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
			count++;
		}
		while (high > first && list[high] >= pivot)
			high--;
			count++;
		if (pivot > list[high]) {
			count++;
			list[first] = list[high];
			list[high] = pivot;
			high(list, high);
		}
		else {
			count++;
			low(list, first);

		}
	}
	//iterative merge sort
	public void iMergeSort(int[] a){
		
	}
}
//class count{
//	int count;
//}
