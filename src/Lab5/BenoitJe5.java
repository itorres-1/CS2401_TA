package Lab5; /**
 * Author: Jean-Maxon Benoit
 * Assignment: Lab 5
 * Instructor: Julio Urenda
 * TA: Isaac Torres
 * Last Modified 7/19/2017.
 * Purpose: Translate sorting algorithms into an iterative algorithm or recursive algorithm
 */
import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.*;

public class BenoitJe5 implements Lab5Interface {
    /**
     * Given an int array and a starting index of 0, recursively sorts
     * the array
     * @param A int array
     * @param currentIndex the starting index that will change with every method call
     * @return a sorted array
     */
    public int[] rBubbleSortHelper(int[] A, int currentIndex) {
        Util.print1Dint(A);

        int comparisons = 0;

        for (int i = currentIndex; i < A.length; i++) {

            if (A[currentIndex] > A[i]) { //swaps the elements
                int temp = A[i];
                A[i] = A[currentIndex];
                A[currentIndex] = temp;
            }
            comparisons++;
        }

        if (currentIndex + 1 != A.length) {
            rBubbleSortHelper(A, currentIndex + 1); //calls itself to compare the next pair of elements
        }

        comparisons++;
        return A;
    }
    /**
     * Given an int array, calls it's helper method to help sort it
     * @param A int array
     */
    public void rBubbleSort(int[] A) {
        if (A.length == 1) {
            System.out.println(Arrays.toString(A));
        }
        else {
            System.out.println(Arrays.toString(rBubbleSortHelper(A, 0)));
        }
    }
    /**
     * Given an int array and a starting index of 0, recursively sorts
     * the array
     * @param A int array
     * @param currentIndex the starting index that will change with every method call
     * @return a sorted int array
     */
    public int[] rSelectionSortHelper(int[] A, int currentIndex) {
        Util.print1Dint(A);

        int comparisons = 0;
        int minIndex = currentIndex;

        for (int i = currentIndex; i < A.length; i++) { //finds the index where the smallest element is at

            if (A[i] < A[minIndex]) {
                minIndex = i;
            }

            comparisons++;
        }

        int temp = A[currentIndex];
        A[currentIndex] = A[minIndex];  //swaps the current index with the index of the smallest element
        A[minIndex] = temp;

        if (currentIndex + 1 != A.length) {
            rSelectionSortHelper(A, currentIndex + 1);
        }

        comparisons++;
        return A;
    }
    /**
     * Given an int array, calls it's helper method to help sort it
     * @param A int array
     */
    public void rSelectionSort(int[] A) {
        System.out.println(Arrays.toString(rSelectionSortHelper(A, 0)));
    }
    /**
     * Given an int array and a starting index of 0, recursively sorts
     * the array
     * @param A int array
     * @param currentIndex the starting index that will change with every method call
     * @return a sorted int array
     */
    public int[] rInsertionSortHelper(int[] A, int currentIndex) {
        Util.print1Dint(A);

        int comparisons = 0;
        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j <= currentIndex; j++) {
                //compares every element in the subarray
                if (A[i] < A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
                comparisons++;
            }
            comparisons++;
        }

        if (currentIndex + 1 != A.length) {
            rInsertionSortHelper(A, currentIndex + 1);
        }

        comparisons++;
        return A;
    }
    /**
     * Given an int array, calls it's helper method to help sort it
     * @param A int array
     */
    public void rInsertionSort(int[] A) {
        if (A.length == 1) {
            System.out.println(Arrays.toString(A));
        }
        else {
            System.out.println(Arrays.toString(rInsertionSortHelper(A, 0)));
        }
    }
    /**
     * Given an int array and a pivot index, returns a partition
     * @param A int array
     * @param pivotIndex index of the algorithm's pivot
     * @return partition
     */
    public int[] iQuickSortHelper(int[] A, int pivotIndex) {
        int comparisons = 0;
        int pivot = A[pivotIndex];
        int i  = -1; //when the method stops, the pivot should be right next to this index

        for (int j = 0; j <= pivotIndex - 1; j++) { //loops until it gets to the pivot

            if (A[j] <= pivot) {  //swaps A[i] and A[j]
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            comparisons++;
        }

        int temp = A[i+1];
        A[i+1] = pivot;         //places pivot where it needs to be
        A[pivotIndex] = temp;

        return A;
    }
    /**
     * Given an int array, iteratively sorts the array by
     * calling it's helper method with a new pivot
     * @param A int array
     */
    public void iQuickSort(int[] A) {
        int comparisons = 0;

        for (int j = 0; j < A.length; j++) {
            int pivotIndex = A.length - 1; //the pivot index is reset after the inner for loop stops
            for (int i = 0; i < A.length; i++) {
                iQuickSortHelper(A, pivotIndex); //sorts the array by getting every new pivot where it needs to be
                pivotIndex--; //this gives the method a new pivot when it's called again
                comparisons++;
            }
            comparisons++;
        }
        System.out.println(Arrays.toString(A));
    }
    public void iMergeSort(int[] A) {
        //HONORS
    }
    /**
     * Given an int and a string, generates a file that contains a random collection of integers
     * @param numToGenerate integer that tells this method how many numbers to write into the file
     * @param filename the name of the file
     */
    public void generateFile(int numToGenerate, String filename) {
        try {
            Random number = new Random();
            PrintWriter write = new PrintWriter(filename);

            for (int i = 1; i <= numToGenerate; i++) {
                int n = number.nextInt(numToGenerate + 1); //generates random integer
                write.println(n); //writes integer into file
            }
            write.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Calls the generateFile method in a for loop so it can generate new files
     * that contain random collections of integers. (100,200,400,800,1600,3200)
     */
    public void generateAllFiles() {
        int fileNumber = 1;

        for (int i = 100; i <= 3200; i = i *2) {
            generateFile(i, "File " + fileNumber + ".txt");
            fileNumber++;
        }
    }
    /**
     * Given a string that represents a file name, reads the file and returns an int array
     * @param filename name of the file
     * @return int array
     * @throws IOException since this method didn't handle this exception, it was thrown
     */
    public int[] readFile(String filename) throws IOException{
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        int[] intArray;
        String line;
        int numLines = 0;

        while ((line = br.readLine()) != null) {
            numLines++;
        }

        fr = new FileReader(filename);
        br = new BufferedReader(fr);
        intArray = new int[numLines];  //the length is set to how many lines there was in the file

        for (int i = 0; i < intArray.length; i++) { //puts each line in the int array
            int num = Integer.parseInt(br.readLine());
            intArray[i] = num;
        }

        br.close();

        return intArray;
    }
    /**
     * Given a string that represents a file name, calls the readFile method with this string and passes it inside
     * all of the sorting methods as a parameter so then all of them can run at the same time
     * @param filename a string that's the name of the file
     * @throws IOException since this method didn't handle this exception, it was thrown
     */
    public void runAllSortingMethods(String filename) throws IOException{
        BenoitJe5 test = new BenoitJe5();
        test.rBubbleSort(test.readFile(filename));
        test.rSelectionSort(test.readFile(filename));
        test.rInsertionSort(test.readFile(filename));
        test.iQuickSort(test.readFile(filename));
    }
    public static void main(String[] args) throws IOException{
        //BenoitJe5 test = new BenoitJe5();
        //test.generateAllFiles();
        //test.runAllSortingMethods("File 1.txt");

        BenoitJe5 k = new BenoitJe5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort",'-'));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort",'-'));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort",'-'));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("QuickSort",'-'));
        k.iQuickSort(unsortedArray.clone());
    }
}
