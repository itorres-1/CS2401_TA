package Lab5;

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

/**
 * Created by Mariel on 7/16/2017.
 * CS 2401
 * Dr Julio Urenda
 * TA: Isaac Torres
 * Lab 5 - Sorting
 */
public class Palacios5 implements Lab5Interface {
    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of bubble sort.
     * @param A is an int array
     */
    public void rBubbleSort(int[] A) {
        bubbleSortHelper(A, A.length);
    }

    /**
     * A helper method that given a reference to an int array, sorts that array
     * using a recursive implementation of bubble sort.
     * @param A is an int array
     * @param highIndex the last index of the int array A
     */
    public static void bubbleSortHelper(int[] A, int highIndex) {
        printArray(A);
        if (highIndex > 0) {
            boolean needAnotherPass = false;
            //This is the code for ONE pass
            for (int i = 0; i < highIndex - 1; i++) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                    needAnotherPass = true;
                }
            }
            if (needAnotherPass) bubbleSortHelper(A, highIndex - 1);
        }
    }

    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of selection sort.
     *
     * @param A is an int array
     */
    public void rSelectionSort(int[] A){
        selectionSortHelper(A,0);
    }

    /**
     * A helper method that given a reference to an int array, sorts that array
     * using a recursive implementation of selection sort.
     * @param A is an int array
     * @param lowIndex is an index in the int array A
     */
    public static void selectionSortHelper(int[] A, int lowIndex){
        Util.print1Dint(A);
        if (lowIndex < A.length) {
            //find min
            int temp = lowIndex;
            for (int i = lowIndex + 1; i < A.length; i++) {
                if (A[temp] > A[i]) {
                    temp = i;
                }

                //A[temp] should be the min
            }
            swap(A, lowIndex, temp);
            selectionSortHelper(A, lowIndex + 1);
        }
    }

    /**
     * A helper method that given a reference to an int array, sorts that array
     * using a recursive implementation of insertion sort.
     * @param A is an int array
     */
    public void rInsertionSort(int[] A) {
        insertionHelper(A, 1);
    }

    @Override
    public void iQuickSort(int[] A) {

    }

    @Override
    public void iMergeSort(int[] A) {

    }

    /**
     * A helper method that given a reference to an int array, sorts that array
     * using a recursive implementation of insertion sort.
     * @param A is an int array
     * @param highIndex is an index on the int array A
     */
    public static void insertionHelper(int[] A, int highIndex) {
        printArray(A);
        if (highIndex < A.length) {
            int tmp = A[highIndex];
            int i;
            for (i = highIndex - 1; i >= 0 && tmp < A[i]; i--) {
                A[i + 1] = A[i];
            }
            A[i + 1] = tmp;
            insertionHelper(A, highIndex + 1);
        }
    }

    //PRINT
    /**
     * A method that prints all the elements of a given array.
     * @param B is an int array
     */
    public static void printArray(int[] B) {
        if (B != null) {
            for (int i = 0; i < B.length; i++) {
                System.out.print(B[i] + " ");
            }
            System.out.println();
        }
    }

    //SWAP
    /**
     * A method that swaps two elements of a given array.
     * @param A an int array
     * @param i is the index of one element
     * @param j is the index of the other element
     */
    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        Palacios5 k = new Palacios5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort",'-'));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort",'-'));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort",'-'));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("MergeSort",'-'));
        //k.iMergeSort(unsortedArray.clone());
    }

}