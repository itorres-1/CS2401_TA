package Lab5;

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * CS2401: Elementary Data Structures and Algorithms
 * Instructor: Julio Urenda
 * Teaching Assistant: Isaac Torres
 * Assignment: Lab 5
 * Modified and submitted by: Raul Reza
 * Last modification: 7/19/2017
 * Purpose: Implement Bubble Sort, Selection Sort, and Insertion Sort using recursion.
 */
public class Reza5 implements Lab5Interface {

    /**
     * Global integer variable used to count the number of operations in all the methods.
     */
    public int tally = 0;

    /**
     * Sorts an array using Recursive Bubble Sort.
     * @param A integer array A
     */
    public void rBubbleSort(int[] A) {
        int n = A.length;
        bubbleSortHelper(A, n);
        this.tally = 0;
    }

    /**
     * Sorts an array using Recursive Selection Sort.
     * @param A integer array A
     */
    public void rSelectionSort(int[] A) {
        int n = A.length;
        int index = 0;
        selectionSortHelper(A, n, index);
        this.tally = 0;
    }

    /**
     * Sorts an array using Recursive Insertion Sort.
     * @param A integer array A
     */
    public void rInsertionSort(int[] A) {
        int n = 1;
        insertionSortHelper(A, n);
        this.tally = 0;
    }

    public void iQuickSort(int[] A) {

    }

    public void iMergeSort(int[] A) {

    }

    /**
     * Generates a file with a name that comes from a string, and the number of integers n.
     * @param name String that is going to be used to name the array
     * @param n integer used to define the number of integers in the file
     */
    public static void generateFile(String name, int n) {
        try(PrintWriter out = new PrintWriter(name, "UTF-8")) {
            BufferedWriter bufferedout = new BufferedWriter(new FileWriter(name));
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                int number = ThreadLocalRandom.current().nextInt(0, 3200);//2147483647
                array[i] = number;
                bufferedout.write(array[i] + "");
                if (!(i == (n - 1))) {
                    bufferedout.newLine();
                }
            }
            bufferedout.flush();
            bufferedout.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads a file and generates an integer array.
     * @param name String which will be name of the file that is being read
     * @param n integer which will be the number of integers that are going to be placed in the array
     * @return integer array A
     */
    public static int[] readFile(String name, int n){
        int[] A = new int[n];
        try(Scanner input = new Scanner(new File(name))){
            int k = 0;
            while (input.hasNextInt()){
                A[k] = input.nextInt();
                k++;
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return A;
    }

    //Helper methods
    /**
     * Bubble Sort helper takes in an integer array and an integer which returns a sorted integer array.
     * @param A integer array A
     * @param n integer n
     * @return integer array A
     */
    public int[] bubbleSortHelper(int[] A, int n){
        Util.print1Dint(A);
        boolean nextInt = false;
        for(int i = 0; i < n - 1; i++){
            if (A[i] > A[i + 1]){
                int temp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = temp;
                nextInt = true;
            }
            this.tally++;
        }
        if(!nextInt){
            return A;
        }
        else {
            return bubbleSortHelper(A, n-1);
        }
    }

    /**
     * Helper for the Selection Sort Helper which determines the minimum index.
     * @param A integer array A
     * @param i integer i
     * @param j integer j
     * @return returns minimum integer
     */
    public int minIndex (int[] A, int i, int j){
        if(i == j){
            return i;
        }
        int k = minIndex(A, i + 1, j);
        this.tally++;
        if (A[i] < A[k]){
            return i;
        }
        else{
            return k;
        }
    }

    /**
     * Selection sort helper takes in an integer array, and two integers and returns a sorted integer array.
     * @param A integer array A
     * @param n integer n
     * @param index integer index
     * @return integer array A
     */
    public int[] selectionSortHelper(int[] A, int n, int index){
        Util.print1Dint(A);
        if(index == n){
            return A;
        }
        int k = minIndex(A, index, n - 1);
        if(k != index){
            int temp = A[k];
            A[k] = A[index];
            A[index] = temp;
        }
        return selectionSortHelper(A, n, index + 1);
    }

    /**
     * Insertion Sort Helper takes in an integer array and an integer and returns a sorted integer array.
     * @param A integer array A
     * @param n integer n
     * @return integer array A
     */
    public int[] insertionSortHelper(int[] A, int n){
        Util.print1Dint(A);
        if(n == A.length){
            return A;
        }
        else{
            int k = A[n];
            int j;
            for(j = n - 1; (j >= 0) && (A[j] > k); j--){
                A[j + 1] = A[j];
                this.tally++;
            }
            A[j + 1] = k;
            return insertionSortHelper(A, n + 1);
        }
    }

    /**
     * Main method is used for testing
     * @param args Arguments
     */
    public static void main(String[] args){
        Reza5 k = new Reza5();
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
