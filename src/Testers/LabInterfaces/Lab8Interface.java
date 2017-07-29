package Testers.LabInterfaces;
/**
 * Author: Isaac Torres
 * Date: 7/26/17.
 * Course: CS 2401
 * Assignment: Lab 8
 * Instructor: Julio Urenda
 */

/**
 * An interface to ensure the student's code is compatible with the TA's code.
 * As stated several times, "implementing" this interface in your class is not
 * strictly necessary, so long as your methods have the EXACT SAME SIGNATURE
 * (this is strictly necessary). If you do not implement this interface, you
 * run the risk of having a different signature than the TA's and therefore
 * are risking your grade.
 */
public interface Lab8Interface {
    /**
     * A method that given an array of unsorted ints, sorts
     * the ORIGINAL array using a balanced BST.
     * @param A the array of unsorted ints to be sorted
     */
    public void balancedBST(int[] A);
    /**
     * A method that given an array of unsorted ints, sorts
     * the ORIGINAL array using heapsort.
     * @param A the array of unsorted ints to be sorted
     */
    public void heapSort(int[] A);
}
