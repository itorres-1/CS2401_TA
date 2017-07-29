package Lab5;

import Testers.Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Stack;

/**
	 * Author: Hao Moy
	 * Date: 7/17/17
	 * Course: CS 2401 Elementary Data Structures
	 * Purpose: Familiarization with sorting algorithms and recursion practice.
	 */

//TODO FORMAT CODE! readFromFile?

	public class Moy5 {
	public static int counter;

		/**
	     * A method that given a reference to an int array, sorts that array
	     * using a recursive implementation of bubble sort.
	     * @param A Array containing integers to be sorted.
	     */

	    public void rBubbleSort(int[] A) {
	    	//counter = 0;
	    	Moy5 instance = new Moy5();
	    	instance.bubble(A, A.length);
	    	//System.out.println("comparisons: " + counter);
			}

		public void bubble(int[] A, int size) {
			Util.print1Dint(A);
			if (size>1) {
	    	for (int i=0; i<A.length-1; i++) {
	    		//counter++;
				if (A[i] > A[i+1]) {
					int y=A[i];
					A[i]=A[i+1];
					A[i+1]=y;
				}
	    	}
			Moy5 instance = new Moy5();
			instance.bubble(A, size-1);
			}
		}

		/**
	     * A method that given a reference to an int array, sorts that array
	     * using a recursive implementation of selection sort.
	     * @param A Array containing integers to be sorted.
	     */
	    public void rSelectionSort(int[] A) {
	    	//counter = 0;
	    	Moy5 instance = new Moy5();
	    	instance.selection(A, 0);
	    	//System.out.println("comparisons: " + counter);
	    }

	    public void selection(int[] A, int rec){
	    	Util.print1Dint(A);
	    	//counter++;
	    	if (rec < A.length) {
	    		 int index = rec;
		            for (int j = rec + 1; j < A.length; j++){
		            	//counter++;
		                if (A[j] < A[index]){
		                    index = j;
		                }
		            }
		            int smallerNumber = A[index];
		            A[index] = A[rec];
		            A[rec] = smallerNumber;
		          //Moy5 instance = new Moy5();
					selection(A, rec+1);
	        }

		}
	     public void selectionSort(int[] A, int rec) {
	    	 int index = rec;
	            for (int j = rec + 1; j < A.length; j++){
	            	//counter++;
	                if (A[j] < A[index]){
	                    index = j;
	                }
	            }
	            int smallerNumber = A[index];
	            A[index] = A[rec];
	            A[rec] = smallerNumber;
	     }





	    /**
	     * A method that given a reference to an int array, sorts that array
	     * using a recursive implementation of insertion sort.
	     * @param A Array containing integers to be sorted.
	     */
	    public void rInsertionSort(int[] A) {
	    	//counter = 0;
	    	Moy5 instance = new Moy5();
			instance.insertion(A, 0);
			//System.out.println("comparisons: " + counter);
	    }

	    public void insertion(int[] A, int n) {
	    	Util.print1Dint(A);
	    	if (n < A.length) {
	    		//counter++;
	    		for (int j=n; j>0 && A[j]<A[j-1]; j--) {
	    			int key = A[j];
	    			A[j] = A[j-1];
	    			A[j-1] = key;
	    			//counter++;
	    		}
	    		Moy5 instance = new Moy5();
				instance.insertion(A, n+1);
	    	}
	    }
	    /**
	     * A method that given a reference to an int array, sorts that array
	     * using an iterative implementation of quick sort.
	     * @param A Array containing integers to be sorted.
	     */

	    public void iQuickSort(int[] A) {
	    	//counter = 0;
		    Stack<Integer> s = new Stack<Integer>();
		    s.push(0);
		    s.push(A.length);
		   // counter++;
		    while (!s.isEmpty()) {
		        int bottom = s.pop();
		        int top = s.pop();
		       // counter++;
		        if (bottom - top < 2)
		        	continue;

		        Moy5 instance = new Moy5();
		        int p = top + ((bottom-top)/2);
		        p = instance.division(A,p,top,bottom);

		        s.push(p+1);
		        s.push(bottom);
		        s.push(top);
		        s.push(p);
		    }
		   // System.out.println("comparisons: " + counter);
		}

		public int division(int[] A, int p, int top, int bottom) {
		    int l = top;
		    int h = bottom - 2;

		    int piv = A[p];
		    int temp = A[p];
		    A[p] = A[bottom-1];
		    A[bottom-1] = temp;
		    //counter++;
		    while (l < h) {
		    	//counter++;
		        if (A[l] < piv) {
		            l++;
		        } else if (A[h] >= piv) {
		            h--;
		        } else {
		        	int temp2 = A[l];
		    	    A[l] = A[h];
		    	    A[h] = temp2;
		        }
		    }
		    int key = h;
		    //counter++;
		    if (A[h] < piv) key++;
		    int temp3 = A[bottom-1];
		    A[bottom-1] = A[key];
		    A[key] = temp3;
		    return key;
		}



		/**
	     * A method that returns a random number.
	     */
	    public static int randomFill(){
	        Random rand = new Random();
	        int randomNum = rand.nextInt(10000);
	        return randomNum;
	        }
	    /**
	     * A method that returns an array of random integers.
	     * @param Array Array containing integers to be sorted.
	     */
	    public int[] randomArray(int [] Array)  {
	    	for(int i=0;i<Array.length;i++)
	    	        Array[i] = randomFill();
	    	return Array;
	    }
	    /**
	     * A method that generates a file filled with an array of random integers.
	     * @param A Empty array to be filled with random integers and printed into a document.
	     * @param file String that will be the name of the generated file.
	     */
	    public void randomFile(int[] A, String file) throws IOException {
	    	PrintWriter fw = new PrintWriter(file);
	    	for(int i=0;i<A.length;i++) {
    	        A[i] = randomFill();
    	        fw.println(A[i]);
	    	}
	    	fw.close();
	    }
	    /**
	     * A method that prints the elements of an array.
	     * @param Array Array containing integers to be sorted.
	     */
	    public void printArray(int[] a) {
	    	for (int i=0; i<a.length; i++) {
				System.out.println(a[i]);
			}
	    }

	public static void main(String[] args) {
		Moy5 k = new Moy5();
		int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

		System.out.print(Util.titleString("BubbleSort",'-'));
		k.rBubbleSort(unsortedArray.clone());

		System.out.print(Util.titleString("InsertionSort",'-'));
		k.rInsertionSort(unsortedArray.clone());

		System.out.print(Util.titleString("SelectionSort",'-'));
		k.rSelectionSort(unsortedArray.clone());

		System.out.print(Util.titleString("MergeSort",'-'));
		k.iQuickSort(unsortedArray.clone());
	}

	}

