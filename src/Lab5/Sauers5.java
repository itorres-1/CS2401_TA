package Lab5;

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Sauers5 implements Lab5Interface {

	public int index = 0;
	private int bubbleCounter = 0;
	private int selectionCounter = 0;
	private int insertionCounter = 0;
	private int quickCounter = 0;

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}

	public void setSelectionCounter(int selectionCounter) {
		this.selectionCounter = selectionCounter;
	}

	public int getSelectionCounter() {
		return this.selectionCounter;
	}

	public void setInsertionCounter(int insertionCounter) {
		this.insertionCounter = insertionCounter;
	}

	public int getInsertionCounter() {
		return this.insertionCounter;
	}

	public void setQuickCounter(int quickCounter) {
		this.quickCounter = quickCounter;
	}

	public int getQuickCounter() {
		return this.quickCounter;
	}

	public void setBubbleCounter(int bubbleCounter) {
		this.bubbleCounter = bubbleCounter;
	}

	public int getBubbleCounter() {
		return this.bubbleCounter;
	}

	/**
	 * An instance of the class, designed to use the entire file from the main method without causing a static/non-static reference error
	 */
//	public Sauers5() {
//		Scanner input = new Scanner(System.in);
//		System.out.print("Enter desired array size: ");
//		int size = input.nextInt();
//		writeFile(size);
//		System.out.println("Please enter filename: ");
//		String fileName = input.next();
//		int[] array = readFile(fileName);
//		rBubbleSort(array);
//		array = readFile(fileName);
//		rSelectionSort(array);
//		array = readFile(fileName);
//		rInsertionSort(array);
//		array = readFile(fileName);
//		iQuickSort(array);
//	}

	/**
	 * A method that writes random numbers to a text file depending on the user requested size.
	 * @param a the total number of numbers to be input to the text file
	 */
	public void writeFile(int a) {
		Random rand = new Random();
		try {
			FileWriter fw = new FileWriter(a + ".txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 1; i <= a; i++) {
				int j = rand.nextInt(a);
				bw.write(String.valueOf(j));
				bw.write(" ");
			}
			bw.close();
		} catch(IOException ex) {
			System.out.println("Error writing to file!");
		}
	}

	/**
	 * A method that reads the requested file and places the contents into an array.
	 * @param fileName the name of the file (maybe should change to pathName?)
	 */
	public int[] readFile(String fileName) {
		int[] newList = new int[Integer.parseInt(fileName)];
		String[] tempList = new String[Integer.parseInt(fileName)];
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
			int i = 0;
			String line;
			while ((line = br.readLine()) != null) {
				String[] tempList2 = line.split(" ");
				for (int j = 0; j < newList.length; j++) {
					newList[j] = Integer.parseInt(tempList2[j]);
				}
			}
			System.out.print("Success! New array: ");
			printArray(newList);
			br.close();
			return newList;
		} catch (IOException ex) {
			System.out.println("Error reading file!");
			return null;
		}
	}

	/**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of bubble sort.
     * @param a the recieved array
     */
    public void rBubbleSort(int[] a) {
        Util.print1Dint(a);
		boolean swapped = false;
		for (int i = 0; i < a.length - 1; i++) {
			setBubbleCounter(getBubbleCounter() + 1);
			if (a[i] > a[i+1]) {
				setBubbleCounter(getBubbleCounter() + 1);
				swap(i, i+1, a);													//testing
				swapped = true;
			}
		} if(swapped) {
			rBubbleSort(a);
		} else {
			System.out.println("Bubblesort completed.");
			checkArray(a);
			printArray(a);
			System.out.println("Bubble counter: " + this.bubbleCounter);
		}
	}

    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of selection sort.
     * @param a the recieved array
     */
    public void rSelectionSort(int[] a){
        Util.print1Dint(a);
		if (checkArray(a)) {
			System.out.println("Selection sort completed.");
			printArray(a);
			System.out.println("Selection sort counter: " + getSelectionCounter());
		} else {
			try {
				setSelectionCounter(getSelectionCounter() + 1);
				for (int i = 0; i < a.length; i++) {
					setSelectionCounter(getSelectionCounter() + 1);
					for (int j = i+1; j < a.length; j++) {
						if (a[j] < a[i]) {
							setSelectionCounter(getSelectionCounter() + 1);
							rSelectionSort(swap(j, i, a));
						}
					}
				}
			}catch (StackOverflowError e) {
				System.out.println("Error!");
			}
		}
	}

    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of insertion sort.
     * @param a the recieved array
     */
    public void rInsertionSort(int[] a){
        Util.print1Dint(a);
		if (!checkArray(a)) {
			setIndex(a.length);
			int[] b = insertionSortWorkhorse(a);
		} else {
			System.out.println("Insertion sort completed.");
			//printArray(a);
			System.out.println("Insertion sort counter: " + getInsertionCounter());
		}
	}

	/**
     * Required in order to have an index of the current variable -
     * I couldn't throw it in the same method because it would constantly reset back to the original length!
     * @param a the recieved array
     */
	public int[] insertionSortWorkhorse(int[] a) {
		setInsertionCounter(getInsertionCounter() + 1);
		if (getIndex() <= 1) {
			rInsertionSort(a);
		} else {
			int j = a[getIndex() - 1];
			int k;
			setInsertionCounter(getInsertionCounter() + 1);
			for (k = getIndex() - 2;((k >= 0) && (a[k] > j));k--) {
				a[k+1] = a[k];
			} a[k+1] = j;
			setIndex(getIndex() - 1);
			try {
				return insertionSortWorkhorse(a);
			} catch(StackOverflowError e) {
				System.out.println("Error!");
			}
		} return null;
	}

    /**
     * A method that given a reference to an int array, sorts that array
     * using an iterative implementation of quick sort.
     * @param a the recieved array
     */
    public void iQuickSort(int[] a){
		int i = 0;
		int left = 0;
		int right = a.length - 1;
		while (!checkArray(a)) {
			i--;
			while (left < right) {
			    Util.print1Dint(a);
				setQuickCounter(getQuickCounter() + 1);
				int temp = part(left, right, a);
				right = temp - 1;
				++i;
			} if (i < 0) {
				break;
			}left++;
			for (int k = left; k < a.length; ++k) {
				setQuickCounter(getQuickCounter() + 1);
				if (a[k] < 0) {
					right = k;
				} else {
					right = a.length - 1;
				}
			}
		}System.out.println("Quick sort completed.");
		printArray(a);
		System.out.println("Quick sort counter: " + getQuickCounter());
	}

	/**
     * Given the left and right values, along with an array, this creates a pivot and does most of the work for iQuickSort.
     * @param left value of left
	 * @param right value of right
	 * @param a the array in question
     */
	public int part(int left, int right, int[] a) {
		Random rand = new Random();
		int pivot = a[rand.nextInt(a.length - 1)];
		while (left <= right) {
			while (a[left] < pivot) {
				left++;
			}while (a[right] > pivot) {
				right--;
			} if (left <= right) {
				swap(left, right, a);
				left++;
				right--;
			}
		}return left;
	}

    /**
     * An extra credit method that given a reference to an int array, sorts that array
     * using an iterative implementation of merge sort.
     * @param A the recieved array
     */
    public void iMergeSort(int[] A){

	}

	/**
	 * Given two element positions in an array, this swaps them
	 *@param posA the first position
	 *@param posB the second position
	 *@param array the array in question
	 */
	public int[] swap(int posA, int posB, int[] array) {
		int temp = array[posA];
		array[posA] = array[posB];
		array[posB] = temp;
		return array;
	}

	/**
	 * Prints the array
	 *@param a the array being passed
	 */
	public void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}System.out.println("");
	}

	/**
	 * Checks the array to make sure every i+1 element is greater/equal to the ith element.
	 *@param a the array being checked
	 */
	public boolean checkArray(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i+1]) {
				return false;
			}
		} return true;
	}

	public static void main(String[] args) {
        Sauers5 k = new Sauers5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort",'-'));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort",'-'));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort",'-'));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("QuickSort",'-'));
        k.iQuickSort(unsortedArray.clone());
//		Sauers5 instance = new Sauers5();
	}
}