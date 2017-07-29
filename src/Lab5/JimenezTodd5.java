package Lab5;/* Name: Eduardo A. Jimenez Todd        */
/* Assignment: Lab 5                    */
/* Instructor: Dr. Julio Cesar Urenda   */
/* T.A.: Isaac Torres                   */
/* Last Modification: 7/17/2017         */
/* Purpose: Learn sorting algorithms    */

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner; 
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;

//TODO file generate could be more efficient. Why use two separate for-loops?


/**
 * 
 * @author Eduardo Jimenez Todd
 * This class can sort using BubbleSort, SelectionSort, and InsertionSort recursively, and QuickSort iteratively
 *
 */
public class JimenezTodd5 {
	public static int comparisons;
	public static void main (String[] args)throws IOException{
		JimenezTodd5 k = new JimenezTodd5();
		int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

		System.out.print(Util.titleString("BubbleSort",'-'));
		k.rBubbleSort(unsortedArray.clone());

		System.out.print(Util.titleString("InsertionSort",'-'));
		k.rInsertionSort(unsortedArray.clone());

		System.out.print(Util.titleString("SelectionSort",'-'));
		k.rSelectionSort(unsortedArray.clone());

		System.out.print(Util.titleString("QuickSort",'-'));
		k.iQuickSort(unsortedArray.clone());

//		boolean x=true;
//		for (int i=100;i<=100;i*=2)
//			generateFile(""+i,i);
//		JimenezTodd5 jt = new JimenezTodd5();
//
//		Scanner scnr =new Scanner(System.in);
//		Scanner scn = new Scanner(System.in);
//		while (x){
//			System.out.println("1. Execute.");
//			System.out.println("2. Exit.");
//			System.out.print("Enter option: ");
//			int s= scnr.nextInt();
//			switch(s){
//				case 1:
//				try{
//					System.out.print("Enter file name: ");
//					String str = scn.next();
//						int[] Array=readFile(str);
//						for(int i:Array)
//							System.out.print(i+",");
//						jt.iQuickSort(Array);
//						System.out.println();
//						for(int i:Array)
//							System.out.print(i+",");
//						System.out.println();
//						System.out.println("comparisons "+comparisons);
//					}
//					catch (IOException e){
//						System.out.println("Wrong input.");
//					}
//					break;
//				case 2:
//					x=false;
//			}
//
//		}
//		scnr.close();
//		scn.close();
	}
	/**
	*This method generates files with random integers given its name and its size
	*@param fileName Name of file
	*@param n Total integers in file
	*@throws IOException Wrong input
	*/
	public static void generateFile(String fileName, int n)throws IOException{
		PrintWriter out = new PrintWriter(fileName+".txt");
		int[] list= new int[n];
		Random rand = new Random(); 
		for(int i=0;i<n;i++){
			int x = rand.nextInt(n+1); 
			list[i]=x;
		}
		for(int i=0;i<n;i++)
			out.println(list[i]);
		out.close();
	}
	/**
	*This method reads files with integers given its name
	*@param fileName Name of file
	*@throws IOException Wrong input
	*@return Array read from file
	*/
	public static int[] readFile(String fileName)throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(fileName+".txt"));
		int l = 0;
		while (reader.readLine() != null) 
			l++;
		reader.close();
		int[] A=new int[l];
		FileInputStream fiBS = new FileInputStream(fileName+".txt");;
		Scanner inFS = new Scanner(fiBS);
		for (int i=0;i<l;i++)
			A[i]= inFS.nextInt();
		inFS.close();
		return A;
	}
	
	/**
	*This method is used to order using Bubble Sort
	*@param A Array to order
	*@param n Index reference
	*
	*/
    public void BubbleSort(int[] A, int n){
    	Util.print1Dint(A);
    	if (n>1){
			JimenezTodd5 jt = new JimenezTodd5();
			boolean x = false;
			for(int i=0;i<n-1;i++){
				comparisons++;
				if (A[i]>A[i+1]){
					int temp=A[i];
					A[i]=A[i+1];
					A[i+1]=temp;
					x=true;
				}
			}
			if(x)jt.BubbleSort(A, n-1);
		}
	}
    
    /**
	*This method is used to order using Selection Sort
	*@param A Array to order
	*@param n Index reference
	*
	*/
    public void SelectionSort(int[] A, int n){
		Util.print1Dint(A);
    	if (n>1){
    		int temp=A[n-1];
    		int x=n-1;
    		for (int i=0;i<n;i++){
				comparisons++;
    			if (A[i]>temp){
    				temp=A[i];
    				x=i;
    			}
    		}
    		A[x]=A[n-1];
    		A[n-1]=temp;
			JimenezTodd5 jt = new JimenezTodd5();
			jt.SelectionSort(A, n-1);
		}
	}
    /**
	*This method is used to order using Insertion Sort
	*@param A Array to order
	*@param n Index reference
	*
	*/
    public void InsertionSort(int[] A, int n){
		Util.print1Dint(A);
    	if (n<A.length){
			comparisons++;
			for (int x=n;x>0&&A[x]<A[x-1];x--){
    			int temp=A[x];
    			A[x]=A[x-1];
				A[x-1]=temp;
				comparisons++;
			}
    		JimenezTodd5 jt = new JimenezTodd5();
    		jt.InsertionSort(A, n+1);    	
		}
    }
    
    
    
    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of bubble sort.
     * @param A Array
     */
    public void rBubbleSort(int[] A){
    	comparisons=0;
		JimenezTodd5 jt = new JimenezTodd5();
		jt.BubbleSort(A, A.length);
	}
    
    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of selection sort.
     * @param A Array
     */
    public void rSelectionSort(int[] A){
    	comparisons=0;
    	JimenezTodd5 jt = new JimenezTodd5();
		jt.SelectionSort(A, A.length);
	}
    
    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of insertion sort.
     * @param A Array
     */
    public void rInsertionSort(int[] A){
    	comparisons=0;
    	JimenezTodd5 jt = new JimenezTodd5();
		jt.InsertionSort(A, 1);
	}

	
    /**
     * A method that given a reference to an int array, sorts that array
     * using an iterative implementation of quick sort.
     * @param A Array
     */
    public void iQuickSort(int[] A){
    	comparisons=0;
        int low=0;
		int elemSorted=0;
		boolean[] pivotIndex = new boolean[A.length];
		while (elemSorted<A.length){
			int firstFalse=0;
			for(int i=0;firstFalse<2 && i<=A.length;i++){
				if(firstFalse==0 && pivotIndex[i]==false){
					low = i;
					firstFalse++;
				}
				else if(i==A.length || (firstFalse==1 && pivotIndex[i]==true)){
					int high=i-1;
					firstFalse++;
					if(low==high)
						pivotIndex[low]=true;
					else
						pivotIndex[pivotGroup(A, low, high)]=true;
					elemSorted++;
				}
			}
		}
	}
	
    /**
	*This method is used to send larger elements than pivor to the right, and lower elements to the left
	*@param A Array to order
	*@param low Lowest index of partition
	*@param high Highest index of partition
	*@return Pivot final index
	*/
    public int pivotGroup (int A[], int low, int high){
    	int x=high;
    	high--;
    	while (low<high){
    		comparisons+=3;
    		while(A[low]<A[x]&&low<high){
    			low++;
    			comparisons++;
    		}
    		while(A[high]>=A[x]&&high>low){
    			high--; 
				comparisons++;
			}
    		if(A[high]<A[low]){
    			int temp=A[high];
    			A[high]=A[low];
    			A[low]=temp;
    			low++;
    		}
    	}
    	comparisons++;
    	if(A[x]>A[high])
    		high=x;
    	int temp=A[x];
	    A[x]=A[high];
	    A[high]=temp;
    	return high;
    }
}