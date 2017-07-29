package Lab5; /**
 * @author Monique Deitrick
 * Lab5
 * Instructor: J.Urenda
 * T.A.: I. Torres
 * Last Modified : 07/25/2017
 */
import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.*;

public class Deitrick5 implements Lab5Interface {

    //Counting and printing methods
    public void storeCounts(long counter) {

        System.out.print(counter + " ");
        System.out.print(",");

    }
    public void printArray(int[] A) {

        for (int nums : A) {
            System.out.print(Arrays.toString(new int[]{nums}));
        }
        System.out.println(" ");
    }

    //Generate and read from file methods.
    public void nameAndSize() {

        int size = 50;
        int maxSize = 3200;

        for (int i = size; size < maxSize; ++i) {
            size = size * 2;
            String stringValueOfSize = String.valueOf(size);
            generateFile(stringValueOfSize, size);
        }
    }

    /**
     * Generates files automatically with random numbers separated
     * by spacees.
     *
     * @param fileName
     * @param size
     */
    public void generateFile(String fileName, int size) {

        File file = new File(fileName);
        Random rand = new Random();

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter out = null;
            try {
                out = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <= size; i++) {
                int nums = rand.nextInt(99) + 1;
                out.print(nums + " ");
            }
            out.close();
        } else {
            readFromFile(fileName, size);
        }
    }

    /**
     * Reads the files which were automatically generated in the previous method
     * and parses the string data into integer arrays for each file.
     *
     * @param fileName
     * @param size
     * @return
     */
    public int[] readFromFile(String fileName, int size) {

        System.out.println("");
        int[] A = new int[size];
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(fr);
        String line = null;
        int i = 0;

        try {
            while ((line = br.readLine()) != null) {
                String[] intStrings = line.split(" ");
                for (i = 0; i < size; i++) {
                    A[i] = Integer.parseInt(intStrings[i]);
                }
            }
            System.out.println("rBubbleSort : " + fileName);
            rBubbleSort(A);
            System.out.println("rSelectionSort : " + fileName);
            rSelectionSort(A);
            System.out.println("rInsertionSort : " + fileName);
            rInsertionSort(A);
            System.out.println("iQuickSort : " + fileName);
            iQuickSort(A);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return A;
    }

//Here are my methods to be tested
// All helper methods occur beforehand.

    /**
     * Helper method for recursive bubble sort takes an array, an int representing the lowest
     * index of the array, and an int representing the highest index of the array.
     *
     * The basecase excecutes when high equals one.
     *
     * Otherwise adjacent elements will be comapared. If the element in the index to the right
     * of low is found to be larger, it is set to a temporary index and its adjacent element
     * becomes the new lowest. the int stored in temp is moved to the right. This continues as
     * low increases and high decreases until it becomes equal to 1.
     *
     * @param A
     * @param low
     * @param high
     * @return
     */
    public long rBubbleSortHelper(int[] A, int low, int high) {
        Util.print1Dint(A);
        long counter = 0;
        if (high == 1) { //basecase
            printArray(A);
            return 1;
        } else {
            for (low = 0; low < high - 1; low++) {
                counter++;
                if (A[low] > A[low + 1]) {      //compare adjacent elements.
                    int temp = A[low];          //set temporary index to lowest index.
                    A[low] = A[low + 1];        //swap adjacent elements.
                    A[low + 1] = temp;
                }
                counter++;
            }
            counter++;
        }
        counter += rBubbleSortHelper(A, low + 1, high - 1);
        //storeCounts(counter);
        return counter;
    }

    /**
     * Helper method for my recursive selection sort method taking in an array
     * a starting index and the length of the array.
     *
     * The base case to be reached is the starting index equals the length of the array.
     *
     * Otherwise the the minimum index is set to the starting index, and is checked against
     * the indexes as they increment. If the indexes of the array are found to be less then
     * the minimum starting index they become the new min index to be checked against.
     *
     * @param A
     * @param index
     * @param Alength
     * @return
     */
    public long rSSortHelper(int[] A, int index, int Alength) {
        Util.print1Dint(A);
        long counter = 0;
        if (index == Alength) { //basecase
            printArray(A);
            return 1;
        } else {
            int min = index;
            for (int i = index + 1; i < A.length; i++) {
                counter++;
                if (A[i] < A[min]) {
                    min = i;
                }
                counter++;
            }
            int temp = A[index];
            A[index] = A[min];
            A[min] = temp;
        }
        counter++;
        counter += rSSortHelper(A, index + 1, Alength);
        //storeCounts(counter);
        return counter;
    }

    /**
     * Helper method for insertion sort, takes an array and the length of the array.
     *
     * The base case excecutes when the list has reached the end of the sorted list after
     * positioning each of the values.
     *
     * Otherwise the least value is inserted into the list by checking the previous value
     * against it. If it is found to be the least value, the array is shifted to the right
     * until the least value is in the correct position.
     *
     * @param A
     * @param high
     * @return
     */
    public long rISortHelper(int[] A, int high) {
        Util.print1Dint(A);
        long counter = 0;

        if (high == 1) {
            counter += rISortHelper(A, high - 1);
        } else {
            for (int n = 0; n < high; n++) {
                counter++;
                int k = A[n];
                int j = n - 1;
                while (j >= 0 && A[j] > k) { // index of n-1 > key.
                    counter++;
                    A[j + 1] = A[j]; //shifts the elements into position.
                    j--;
                }
                counter++;
                A[j + 1] = k;
            }
            printArray(A);
            storeCounts(counter);
        }
        return counter;
    }

    /**
     *
     * @param A
     * @param low
     * @param high
     * @return
     */
    public long iQSortHelper(int[] A, int low, int high) {

        long counter = 0;

       // makePartition(A, low, high);
        return counter;
    }

    /**
     *
     * @param A
     */
    //Interface compatible methods.
    @Override
    public void rBubbleSort(int[] A) {
        rBubbleSortHelper(A, 0, A.length);
    }

    /**
     *
     * @param A
     */
    @Override
    public void rSelectionSort(int[] A) {
        rSSortHelper(A, 0, A.length);
    }

    /**
     *
     * @param A
     */
    @Override
    public void rInsertionSort(int[] A) {
        rISortHelper(A, A.length);
    }

    /**
     *
     * @param A
     */
    @Override
    public void iQuickSort(int[] A) {

        int low = 0;
        int high = A.length;
        int[] iQReturnA = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            iQReturnA[i] = A[i];
        }
        iQSortHelper(iQReturnA, low, high);
    }

    @Override
    public void iMergeSort(int[] A) {

    }

    public static void main(String[] args) {
        Deitrick5 k = new Deitrick5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort",'-'));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort",'-'));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort",'-'));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("MergeSort",'-'));
       // k.iMergeSort(unsortedArray.clone());
    }
}
