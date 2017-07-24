package Lab5; /**
 * Maria Tanabe
 * 7/21/17
 * Dr. Julio Urenda
 * Isaac Torres
 * Sorting
 */

import Lab1.Tanabe;
import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.PrintWriter;
import java.util.Random;
import java.io.IOException;

public class Tanabe5 implements Lab5Interface {
    public static void main(String[] args) throws IOException{
        Tanabe5 k = new Tanabe5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort"));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort"));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort"));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("QuickSort"));
        k.iQuickSort(unsortedArray.clone());

    }
        /**
         * A method that given a reference to an int array, sorts that array
         * using a recursive implementation of bubble sort.
         *
         * @param A is the array of integers.
         * @param n is the length of the array.
         */
        public static void bubbleSort (int[] A, int n) {
            if (n == 1) //base case
                return;
            for (int i = 0; i < n - 1; i++) { //largest element is moved to the end
                if (A[i] > A[i + 1]){
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
                bubbleSort(A, n - 1);
            }
        }

        /**
         * A method that given a reference to an int array, sorts that array using a recursive implementation of selection sort.
         * @param A is the is the array of integers.
         * @param n is the length of the array.
         */
        public static void selectionSort(int[] A, int n){
            selectionHelp(A, 0);
        }
        /**
        * This method called selectionHelp computes the recursive part of selectionSort.
        * @param A is the array of integers that will be sorted.
        * @param n is the index that the method will use to start sorting.
        * @return array sorted by selection sort.
        */
    private static int[] selectionHelp(int[] A, int n){
        if (n == A.length - 1) {
            return A;
        }
        else {
            int smallestInd = getSmallestIndex(A, n); //finds the smallest element's index by method getSmallestIndex
            swap(A, n, smallestInd);
            selectionHelp(A, n + 1);
            return A;
        }
    }
        /**
        * This method called getSmallestIndex gets the index of the smallest integer in the array.
        * @param A is the array of integers.
        * @param n is the integer of which the index needs to be found.
        * @return the index of the smallest integer.
        */
    private static int getSmallestIndex(int[] A, int n) {
        int smallestInd = n;
        for (int i = n + 1; i < A.length; i++) {
            if (A[i] < A[smallestInd]) {
                smallestInd = i;
            }
        }
        return smallestInd;
    }
        /**
        * This method called Swap, switches desired indexes.
        * @param A is the array of integers.
        * @param index1 is the index of the first integer.
        * @param index2 is the index of the second integer.
        */
    private static void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
        /**
         * A method that given a reference to an int array, sorts that array
         * using a recursive implementation of insertion sort.
         *
         * @param A is an array of integers.
         * @param n is the length of the array.
         */
        public static void insertionSort(int[] A, int n){
            if (n <= 1)
                return;
            insertionSort(A, n-1 );
            int last = A[n-1]; //places last element is the right place
            int j = n-2; // j is second to last element
            while (j >= 0 && A[j] > last){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = last;
        }
    /**
     * A method that given a and integer array and a file, generates an array with random numbers.
     * @param A is the integer array.
     * @param file the the file in which the array will be stored.
     */
    public static void random (int [] A, String file) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        for(int i = 0; i < A.length; i++){
            A[i] = randomIntHelp();
            pw.println(A[i]);
        }
        pw.close();

    }
    /**
     * A helper method that generates random numbers with the range of your choice.
     * @returns the random integers.
     */
    public static int randomIntHelp(){
        Random ra = new Random();
        int raInt = ra.nextInt(100);
        return raInt;
    }
    /**
     * An interface to ensure that the everyone in the class
     * adheres to the exact same method signature(s) thus ensuring
     * code compatibility with the TA's code.
     */

    //TODO What is the point of implementing these methods if you're just
    //TODO gonna leave them empty?!

    @Override
    public void rBubbleSort(int[] A) {

    }
    @Override
    public void rSelectionSort(int[] A) {

    }

    @Override
    public void rInsertionSort(int[] A) {

    }

    @Override
    public void iQuickSort(int[] A){

    }

    @Override
    public void iMergeSort(int[] A){

    }
    }