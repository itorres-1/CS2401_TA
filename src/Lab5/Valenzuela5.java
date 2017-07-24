/**
 * Author: Cesar Valenzuela
 * Date: 7/18/2017
 * Course: CS 2401
 * Assignment: Lab5
 * Instructor: Julio C. Urenda
 * T.A: Isaac Torres
 */
package Lab5;

import Lab1.Valenzuela;
import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.Random;

public class Valenzuela5 implements Lab5Interface {

    @Override
    public void rBubbleSort(int[] A) {
         rBubbleSortHelper(A,0,A.length - 1);
    }

    @Override
    public void rSelectionSort(int[] A) {
        rSelectionSortHelper(A,0,A.length - 1);
    }

    @Override
    public void rInsertionSort(int[] A) {
        rInsertionSortHelper(A, 0, A.length - 1);
    }

    @Override
    public void iQuickSort(int[] A) {
        iQuickSortHelper(A, 0, A.length - 1);
    }

    @Override
    public void iMergeSort(int[] A) {
    }

    /**
     * Recursive implementation of Bubble Sort algorithm
     * takes an integer Array and the start and end indexes of the array.
     * iterates through the array with a for loop using i as the currently selected element in array
     * it compares the element to the next element and if the next element is smaller, it swaps the current element
     * with the next element.
     * @param A Integer array to be sorted
     * @param startIndex beginning index of array and used as the base case to recursive method
     * @param endIndex last index of array
     */
    public void rBubbleSortHelper(int[] A, int startIndex, int endIndex){
        Util.print1Dint(A);
        if(startIndex < endIndex){
            for(int i = 0; i < A.length - 1 - startIndex; i++){
                if(A[i] > A[i + 1]){
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
            rBubbleSortHelper(A, startIndex + 1, endIndex);
        }

    }

    /**
     * This method was obtained from Introduction To Java Programming, 10th ed., Y. Daniel Liang
     * Chapter 18 - Recursion , page: 715
     *
     * Recursive implementation of Selection Sort Algorithm
     * takes an integer Array and the beginning and ending index of the array
     * uses starting index to set element as the current minimum
     * Then iterates through the array and compares the minimum to the proceeding elements
     * if proceeding element is smaller than the minimum, it sets the element as the new minimum
     * and locks it in place
     * @param A integer array to be sorted
     * @param startIndex beginning index of array
     * @param endIndex last index of array
     */
    public void rSelectionSortHelper(int[] A, int startIndex, int endIndex){
        Util.print1Dint(A);
        if(startIndex < endIndex){
            int indexOfMin = startIndex;
            int min = A[startIndex];
            for (int i = startIndex + 1; i <= endIndex; i++){
                if(A[i] < min){
                    min = A[i];
                    indexOfMin = i;
                }
            }
            A[indexOfMin] = A[startIndex];
            A[startIndex] = min;
            rSelectionSortHelper(A, startIndex + 1, endIndex);
        }
    }

    /**
     * Recursive implementation of Insertion Sort.
     * Takes an integer array along with starting and ending index of array
     * Method uses starting index to point at the next element and compares in a backwards
     * manner whether the currently selected 'key' is smaller than the preceding elements
     * If the key is smaller it then shifts all previous elements to the right and the key to
     * the corresponding position
     * @param A integer array to be sorted
     * @param startIndex beginning index of array
     * @param endIndex last index of array
     */
    public void rInsertionSortHelper(int[] A, int startIndex, int endIndex){
        Util.print1Dint(A);
        if(startIndex < endIndex){
            int key = A[startIndex + 1];
            int j = startIndex;
            while(j >= 0 && key < A[j]){
                int temp = A[j];
                A[j] = A[j + 1];
                A[j + 1] = temp;
                j--;
            }
            rInsertionSortHelper(A, startIndex + 1, endIndex);
        }
    }
    public void iQuickSortHelper(int[] A, int startIndex, int endIndex){

    }
    public static int[] readFromFile(String fileName) {

        int[] txtNums = null;

        FileReader fr;
        BufferedReader reader;

        Boolean successfulFileRead = false;
        while (!successfulFileRead) {
            try {
                fr = new FileReader(fileName);
                reader = new BufferedReader(fr);

                String[] intStrings = reader.readLine().split(" ");

                txtNums = new int[intStrings.length];
                for (int i = 0; i < txtNums.length; i++) {
                    txtNums[i] = Integer.parseInt(intStrings[i]);

                }

                return txtNums;
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        return txtNums;
    }
    public static void generateFile(int n){
        try{
            Random rand = new Random();
            File file = new File(n + ".txt");
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < n ; i++) {
                writer.write(new Integer(rand.nextInt(n)).toString() + " ");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void generateAllFiles(){
        for (int i = 100; i <= 3200; i = i * 2){
            generateFile(i);
        }
    }

    public static void main(String[] args) {
        Valenzuela5 k = new Valenzuela5();
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
}
