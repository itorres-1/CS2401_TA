package Testers.LabInterfaces;

/**
 * Author: Isaac Torres
 * Date: 7/13/17
 * Course: CS 2401 Elementary Data Structures
 */

/**
 * An interface to ensure that the everyone in the class
 * adheres to the exact same method signature(s) thus ensuring
 * code compatibility with the TA's code.
 */
public interface Lab5Interface {
    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of bubble sort.
     * @param A
     */
    public void rBubbleSort(int[] A);
    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of selection sort.
     * @param A
     */
    public void rSelectionSort(int[] A);
    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of insertion sort.
     * @param A
     */
    public void rInsertionSort(int[] A);
    /**
     * A method that given a reference to an int array, sorts that array
     * using an iterative implementation of quick sort.
     * @param A
     */
    public void iQuickSort(int[] A);
    /**
     * An extra credit method that given a reference to an int array, sorts that array
     * using an iterative implementation of merge sort.
     * @param A
     */
    public void iMergeSort(int[] A);
}
