package Lab5;

import Testers.LabInterfaces.Lab5Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class GuerecaBerumen5.
 */
public class GuerecaBerumen5 implements Lab5Interface {
	
	/** The counter auxiliary variable*/
	private int CAV = 0;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		GuerecaBerumen5 a = new GuerecaBerumen5();
		int b = 20;
		a.generateFile("1",b);
		int[] x = a.openArr("1");
		a.CAVrBubbleSort(x);
		System.out.println("BubbleSort:" + a.CAV);
		a.printArr(x);
		a.generateFile("1",b);
		x = a.openArr("1");
		a.CAVrSelectionSort(x);
		System.out.println("Selection Sort:" + a.CAV);
		a.printArr(x);
		a.generateFile("1",b);
		x = a.openArr("1");
		a.CAVrInsertionSort(x);
		System.out.println("Insertion Sort:" + a.CAV);
		a.printArr(x);
		a.generateFile("1",b);
		x = a.openArr("1");
		a.CAViQuickSort(x);
		System.out.println("QuickSort:" + a.CAV);
		a.printArr(x);
	}

	/**
	 * @see Lab5Interface#rBubbleSort(int[])
	 *  @param A
	 */
	public void rBubbleSort(int[] A){
		BubbleSort(A,A.length-1);
	}
	
	/**
	 * recursive BubbleSort 
	 *
	 * @param A given array
	 * @param curr current index
	 */
	private void BubbleSort(int[] A, int curr){
		if(curr < 1){return;}
		for(int index = 0;index<curr;index++)
			if(A[index+1] < A[index]){arrSwap(A,index,index+1);} 
		BubbleSort(A,curr-1);
	}
	
	/**
	 * BubbleSort but counts comparisons
	 * @see Lab5Interface#rBubbleSort(int[])
	 */
	private void CAVrBubbleSort(int[] A){
		CAV = 0;
		CAVBubbleSort(A,A.length-1);
	}
	
	/**
	 * recursive BubbleSort 
	 * also counting comparisons
	 *
	 * @param A given array
	 * @param curr current index
	 */
	private void CAVBubbleSort(int[] A,int curr) {
		CAV++;
		if(curr < 1){return;}
		for(int index = 0;index<curr;index++) {
			CAV = CAV + 2;
			if(A[index+1] < A[index]) {arrSwap(A,index,index+1);
			}
		}
		CAV++;
		CAVBubbleSort(A,curr-1);
	}
	
	/**
	 * @see Lab5Interface#rSelectionSort(int[])
	 */
	public void rSelectionSort(int[] A){
		SelectionSort(A,0);
	}

	/**
	 * recursive selection sort
	 *
	 * @param A the given array
	 * @param curr cuurent index
	 */
	public void SelectionSort(int[] A,int curr){
		int min = curr,index = 0;
		if(A.length <= curr+1){return;}
		for(index = curr;index < A.length;index++)
			if(A[index] < A[min]){min = index;}
		arrSwap(A,curr,min);
		SelectionSort(A,curr+1);
	}
	
	/**
	 * rSelectionSort but also count condiitons
	 *
	 * @param A
	 * @see Lab5Interface#rSelectionSort(int[])
	 */
	private void CAVrSelectionSort(int[] A){
		CAV = 0;
		CAVSelectionSort(A,0);
	}
	
	/**
	 * recursive selection sort also adds 
	 * comparisons
	 * @param A the given array
	 * @param curr cuurent index
	 */
	private void CAVSelectionSort(int[] A,int curr) {
		int min = curr,index = 0;
		CAV++;
		if(A.length <= curr+1){return;}
		for(index = curr;index < A.length;index++) {
			CAV = CAV + 2;
			if(A[index] < A[min]){min = index;}
		}
		CAV++;
		arrSwap(A,curr,min);
		CAVSelectionSort(A,curr+1);
	}
	
	/**
	 * @see Lab5Interface#rInsertionSort(int[])
	 * @param A
	 */
	public void rInsertionSort(int[] A) {
		if(A.length <= 1){return;}
		InsertionSort(A,0);
	}

	/**
	 * recursive insertion sort
	 *
	 * @param A the given array
	 * @param curr cuurent index
	 */
	public void InsertionSort(int[] A,int curr){
		curr++;
		if(curr >= A.length){return;}
		int temp = curr;
		for(int index = temp;index > -1;index--)
			if(A[temp] < A[index]){arrSwap(A,temp,temp = index);}
		InsertionSort(A,curr);
	}
	
	/**
	 * rInsertionSort
	 * but also count comparisons
	 *
	 * @see Lab5Interface#rInsertionSort(int[])
	 * @param A
	 */
	private void CAVrInsertionSort(int[] A) {
		CAV = 1;  
		CAVInsertionSort(A,0);
	}
	
	/**
	 * recursive insertion sort
	 * but also counts comaprisions
	 * @param A the given array
	 * @param curr cuurent index
	 */
	private void CAVInsertionSort(int[] A,int curr){
		curr++;
		CAV++;
		if(curr >= A.length){return;}
		int temp = curr;
		for(int index = temp;index > -1;index--) {
			CAV = CAV + 2;
			if(A[temp] < A[index]){arrSwap(A,temp,temp = index);}
		}
		CAV++;
		CAVInsertionSort(A,curr);
	}

	/**
	 * @see Lab5Interface#iQuickSort(int[])
	 * @param A
	 */
	public void iQuickSort(int[] A) {
		if(A.length <= 1) {return;}
		boolean[] alreadySorted = new boolean[A.length];
		int sorted = 0,tLeft = 0,tRight = 0,left,right;
		while(sorted < A.length) {
			for(left = 0;left < A.length && alreadySorted[left];left++){}
			for(right = left;right < A.length - 1 && !alreadySorted[right+1];right++){}
			if((tRight = right)!=(tLeft=left))
		        while (tRight > tLeft) {
		        	for(;A[tLeft] < A[tRight];tLeft++){}
		        	for(right--;A[tRight] < A[right];right--) {}
		            if (tLeft >= right) break;
		            arrSwap(A, tLeft, right);
		        }
			arrSwap(A, tLeft, tRight);
			alreadySorted[tLeft] = true;
			sorted++;
		}
	}
	
	/**
	 * Iterative quick sort
	 * but also keeps track of comparisions
	 *
	 * @param A the a
	 */
	private void CAViQuickSort(int[] A) {
		CAV = 1;
		if(A.length <= 1) {return;}
		boolean[] alreadySorted = new boolean[A.length];
		int sorted = 0,tLeft = 0,tRight = 0,left,right;
		while(sorted < A.length) {
			CAV++;
			for(left = 0;left < A.length;left++){
				CAV = CAV + 2;
				if(!alreadySorted[left]){break;}
			}
			CAV++;
			for(right = left;right < A.length - 1;right++){
				CAV = CAV + 2;
				if(alreadySorted[right+1]) {break;}
			}
			CAV=CAV+2;
			if((tRight = right)!=(tLeft=left))
		        while (tRight > tLeft) {
		        	CAV++;
		        	for(;A[tLeft] < A[tRight];tLeft++){CAV++;}
		        	CAV++;
		        	for(right--;A[tRight] < A[right];right--) {CAV++;}
		        	CAV= CAV + 2;
		            if (tLeft >= right) break;
		            arrSwap(A, tLeft, right);
		        }
			CAV++;
			arrSwap(A, tLeft, tRight);
			alreadySorted[tLeft] = true;
			sorted++;
		}
		CAV++;
	}
	
	/**
	 * swap position of two elements
	 * in an array
	 *
	 * @param A array
	 * @param a element a
	 * @param b element b
	 */
	private void arrSwap(int[] A,int a,int b){
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	
	/**
	 * Prints the array
	 *
	 * @param A the array
	 */
	private void printArr(int[] A) {
		for(int a:A)
			System.out.print(a + " ");
		System.out.println("");
	}
	
	/**
	 * Generate file specified order of random
	 * collection of integers
	 */
	private void generateFile(String str,int length) {
		try {
			File FILE = new File(str + ".txt");
			BufferedWriter out;
			ArrayList<Integer> arr = null;
			while(arr == null) {arr = genArr(length);}
			out = new BufferedWriter(new FileWriter(FILE));
			for(int a:arr) {
				out.write(Integer.toString(a) + " ");
			}
			out.close();
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * Generate specified random collection of
	 * integers stops at specified max length
	 * or max integer
	 *
	 * @param max 
	 * @return the array list
	 */
	private ArrayList<Integer> genArr(int max){
		Random gen = new Random();
		int num = gen.nextInt(30)+1;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		max = (max < 0)?gen.nextInt(30)+1:max;
		for(int i = 0;i < max;i++) {
			if(num*2 < 0) {break;}
			arr.add(num = num * 2);
		}
		
		Collections.shuffle(arr);
		return arr;
	}
	
	/**
	 * Reads ArrayList of integers
	 * from given file name
	 *
	 * @param str file name
	 * @return the array list
	 */
	private int[] openArr(String str){
		int[] arr = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(str + ".txt"));
			String line = null; int i = 0;
			if((line = br.readLine()) != null) {
				String []strNumbers = line.split(" ");
				arr = new int[strNumbers.length];
				for(String strNumber : strNumbers)
					arr[i++] = Integer.parseInt(strNumber);
		     }  
		} catch (Exception e) {
		}
		return arr;
	}
	
	/**
	 * @see Lab5Interface#iMergeSort(int[])
	 * @param A
	 */
	@Override
	public void iMergeSort(int[] A) {
		// TODO Auto-generated method stub
		
	}
}
