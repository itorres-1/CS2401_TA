package Testers;

import Lab5.Padron5;
import Testers.LabInterfaces.Lab5Interface;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Author: Isaac Torres
 * Date: 7/14/17.
 * Course:
 * Assignment:
 * Instructor:
 * T.A:
 */
public class Lab5Tester implements Lab5Interface {

    //Utility
    public static void swapElements(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void bubbleSortHelper(int[] A, int low, int high){
        if (low >= high) return;
        else {
            for (int i = 1; i < high; i++) {
                if (A[i-1] > A[i]) swapElements(A, i, i-1);
            }
            bubbleSortHelper(A,low,high-1);
        }
    }
    @Override
    public void rBubbleSort(int[] A) {
        bubbleSortHelper(A,0,A.length);
    }

    public static void selectionSortHelper(int[] A, int low, int high){
        if (low >= high) return;
        else {
            int lowestIndex = low;
            for (int i = low+1; i < high;++i){
                if (A[i] < A[lowestIndex]) {
                 lowestIndex = i;
                }
            }
            swapElements(A,low,lowestIndex);
            selectionSortHelper(A,low+1,high);
        }
    }
    @Override
    public void rSelectionSort(int[] A) {
        selectionSortHelper(A,0,A.length);
    }

    @Override
    public void rInsertionSort(int[] A) {

    }

    @Override
    public void iQuickSort(int[] A) {

    }

    @Override
    public void iMergeSort(int[] A) {

    }

    public static int[] unsortedArrayOfSize(int n){
        int[] unsortedArray = new int[n];
        Random random = new Random();
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i]=random.nextInt(n);
        }
        return unsortedArray;
    }
    public static ArrayList<Integer> makeArrayList(int[] A){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            arrayList.add(A[i]);
        }
        return arrayList;
    }
    public static Boolean isSorted(int[] A){
        if (A != null) {
            for (int i = 1; i < A.length; i++) {
                if (A[i-1] > A[i]) return false;
            }
            return true;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] unsortedArray = {9,0,8,1,7,2,6,3,5,4};
        int[] studentResult;
        int correctness = 0;
        Boolean isSorted;
        Padron5 student = new Padron5();
        String fileName = student.getClass().toString().split(" ")[1]+".txt";

        File studentOutputFile = new File(fileName);
        try(PrintWriter w = new PrintWriter(studentOutputFile)) {

            //Heading and Input
            Util.printAndWrite(Util.headerString(student.getClass()),w );
            String s = "Input: " + makeArrayList(unsortedArray);
            Util.printAndWrite(s, w);
            
            //BubbleSort
            Util.printAndWrite(Util.titleString("rBubbleSort"), w);
            studentResult = unsortedArray.clone();
            student.rBubbleSort(studentResult);
            Util.printAndWrite("Output:" + makeArrayList(studentResult) + " ", w);
            isSorted = isSorted(studentResult);
            Util.printAndWrite("Sorted: "+isSorted,w );
            if (isSorted) {
                Util.printAndWrite("+25 in correctness", w);
                correctness += 25;
            }

            //SelectionSort
            Util.printAndWrite(Util.titleString("rSelectionSort"), w);
            studentResult = unsortedArray.clone();
            student.rSelectionSort(studentResult);
            Util.printAndWrite("Output:" + makeArrayList(studentResult) + " ", w);
            isSorted = isSorted(studentResult);
            Util.printAndWrite("Sorted: "+isSorted,w );
            if (isSorted) {
                Util.printAndWrite("+25 in correctness", w);
                correctness += 25;
            }
            //Commit me!
        }
        catch (Exception e){
            System.out.println("Something went wrong :(");
        }


    }
}
