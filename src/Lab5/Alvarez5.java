package Lab5;



import Testers.Lab5Tester;
import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Author: Ricardo Alvarez
 * Assignment: Lab 5
 * Instructor: Julio Urenda
 * T.A.: Isaac Torres
 * Date of Last Modification: July 20th, 2017
 * Purpose: Multiple sorting methods
 */

//TODO why take array lists for file writing?

public class Alvarez5 implements Lab5Interface {
    /**
     * Helper for bubble sort
     * @param A array to be sorted
     * @param low low index to be compared
     * @param high high index to be compared
     * @param repeat boolean to avoid multiple repetitions
     */
    public static void bubbleHelper(int[] A, int high) {
        Util.print1Dint(A);
        if (high>=0) {
            int temp = 0;
            for (int i = 0; i < high; i++) {
                if (A[i] > A[i + 1]) {
                    temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
            bubbleHelper(A,high-1);
        }
    }

    /**
     * Helper for selection sort
     * @param A array to be sorted
     * @param select index of selection
     */
    public static void selectionHelper(int[] A, int select) {
        Util.print1Dint(A);
        if (select != A.length - 1) {
            int minIndex = select;
            for (int i = select; i < A.length; i++) {
                if (A[minIndex] > A[i]) {
                    minIndex = i;
                }
            }
            int temp = A[select];
            A[select] = A[minIndex];
            A[minIndex] = temp;
            selectionHelper(A, select + 1);
        }
    }

    /**
     * Helper for insertion sort
     * @param A array to be sorted
     * @param select index of selected integer
     */
    public static void insertionHelper(int[] A, int select) {
        Util.print1Dint(A);
        if (select<A.length) {
            int temp;
            int i = 0;
            boolean repeat = true;
            while (i < select && repeat) {
                if (A[select] < A[i]) {
                    temp = A[select];
                    for (int j = select-1; j >= i; j--) {
                        A[j + 1] = A[j];
                    }
                    A[i] = temp;
                    repeat = false;
                }
                i++;
            }
            insertionHelper(A,select+1);
        }
    }

    /**
     * Merges two integer arrays
     * @param a array 1 to be merged
     * @param b array 2 to be merged
     * @return merged array
     */
    public int[] mergeArr (int[] a, int[] b) {
        int[] out = new int[a.length+b.length];
        int a1 = 0;
        int b1 = 0;
        if (a[a.length-1]<b[0]) {
            for (int i=0; i<a.length; i++) {
                out[i] = a[i];
            }
            for (int j=0; j<b.length; j++){
                out[j+a.length] = b[j];
            }
        }
        else if (b[b.length-1]<a[0]) {
            for (int i=0; i<b.length; i++) {
                out[i] = b[i];
            }
            for (int j=0; j<a.length; j++){
                out[j+b.length] = a[j];
            }
        }
        else {
            for (int i = 0; i < out.length; i++) {
                if ((a1 >= a.length) && (b1 < b.length)) {
                    out[i] = b[b1];
                    b1++;
                }
                else if ((b1 >= b.length) && (a1 < a.length)) {
                    out[i] = a[a1];
                    a1++;
                }
                else {
                    if (a[a1] <= b[b1] && a1 < a.length) {
                        out[i] = a[a1];
                        a1++;
                    } else if (a[a1] > b[b1] && b1 < b.length) {
                        out[i] = b[b1];
                        b1++;
                    }
                }
            }
        }
        return out;
    }

    /**
     * Sorts an array using the bubble sort method
     * @param A array to be sorted
     */
    @Override
    public void rBubbleSort(int[] A) {
        bubbleHelper(A, A.length-1);
    }
    /**
     * Sorts an array using the selection sort method
     * @param A array to be sorted
     */
    @Override
    public void rSelectionSort(int[] A) {
        selectionHelper(A, 0);
    }
    /**
     * Sorts an array using the insertion sort method
     * @param A array to be sorted
     */
    @Override
    public void rInsertionSort(int[] A) {
        insertionHelper(A, 0);
    }
    /**
     * Sorts an array using the quick sort method
     * @param A array to be sorted
     */
    @Override
    public void iQuickSort(int[] A) {
    }
    /**
     * Sorts an array using the merge sort method
     * @param A array to be sorted
     */
    @Override
    public void iMergeSort(int[] A) {
        ArrayList<int[]> out = new ArrayList<>();
        for (int i=0; i<A.length; i++) {
            int[] n = new int[1];
            n[0] = A[i];
            out.add(n);
        }
        while (out.size() != 1) {
            for (int i=0; i<out.size()-1; i++) {
                //TODO IGT code
                for (int[] ints : out) {
                    System.out.print("|");
                    for (int k = 0; k < ints.length-1; k++) {
                        System.out.print(ints[k]+" ");
                    }
                    System.out.print(ints[ints.length-1]+"|");
                }
                int[] auxArr = mergeArr(out.get(i), out.get(i + 1));
                out.remove(i);
                out.remove(i);
                out.add(i, auxArr);
                System.out.println();
            }
        }
        for (int i=0; i<A.length;i++) {
            A[i] = out.get(0)[i];
        }
        //TODO IGT code
        for (int[] ints : out) {
            System.out.print("|");
            for (int k = 0; k < ints.length-1; k++) {
                System.out.print(ints[k]+" ");
            }
            System.out.print(ints[ints.length-1]+"|");
        }
    }

    /**
     * creates an integer array of random numbers
     * @param a number of integers
     * @return random integer array
     */
    public int[] randomGen (int a) {
        int[] out = new int [a];
        Random rAux = new Random();
        for (int i=0; i<a; i++) {
            out[i]= rAux.nextInt(a*2);
        }
        return out;
    }

    /**
     * writes a file with multiple arrays
     * @param fName name of file
     * @param A arraylist to be written on file
     * @throws IOException
     */
    public void fileWriter (String fName, ArrayList<int[]> A) throws IOException {
        fName = fName + ".txt";
        PrintWriter writer = new PrintWriter(fName);
        for (int i = 0 ; i < A.size() ; i++ ) {
            for (int j =0; j<A.get(i).length; j++) {
                writer.print(A.get(i)[j] + " ");
            }
        }
        writer.close();

    }

    /**
     * Reads a file of arrays
     * @param fName name of file
     * @return arraylist of integer arrays
     * @throws IOException
     */
    public ArrayList<int[]> fileReader (String fName)throws IOException{
        ArrayList<int[]> output = new ArrayList<>();
        FileReader fr = new FileReader(fName);
        BufferedReader textReader = new BufferedReader(fr);
        String aux;
        while (textReader.ready()) {
           aux = textReader.readLine();
           String[] auxArr = aux.split(" ");
           int[] intArr = new int[auxArr.length];
           for (int i=0; i<auxArr.length; i++) {
               intArr[i] = Integer.parseInt(auxArr[i]);
           }
           output.add(intArr);
        }
        return output;
    }

    public static void main (String[] str) {
        Alvarez5 k = new Alvarez5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort"));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort"));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort"));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("MergeSort"));
        k.iMergeSort(unsortedArray.clone());
    }
}