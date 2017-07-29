package Lab5;

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.Random;

/**
 * Created by tinevra17 on 7/14/17.
 */

public class Tinevra5 implements Lab5Interface {


    /**
     * bubble sort is a method that recreates the function of iterative
     * bubble sort  but in  a recursive way
     * @param A the array given to sort
     * @param n the size of the arrays
     * @return the A array sorted in decreasing or increasing order
     */
    public static void bubbleSort(int[]A,int n) {
        Util.print1Dint(A);
        if (n >= A.length) {
            return;
        }
        else {
            for (int i = 0; i < A.length - 1; i++) {

                if (A[i] > A[i + 1]) {
                    // swapping
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }

            bubbleSort(A, n + 1);
        }
    }

    /**
     * selectionSort is a method that recreates the function of iterative
     * selection sort but in a recursive way     * @param A the array given to sort

     * @param n the size of the array
     * @return the A array sorted in decreasing or increasing order
     */
    public static void selectionSort(int[]A, int n) {
        Util.print1Dint(A);
        if (n == A.length - 1) {
            return ;
        }

        int swap;
        int index = n;
        for (int i = n + 1; i < A.length; i++) {

            if (A[i] < A[index]) {
                index = i;
            }
        }
        //swapping
        swap = A[n];
        A[n] = A[index];
        A[index] = swap;
        selectionSort(A, n+1);

    }

    /**
     * insertion sort is a method that recreates the function of iterative
     * insertion sort but in a recursive way
     * @param A the array given to sort
     * @param n the size of the array
     * @return the A array sorted in decreasing or increasing order
     */
    public static void insertionSort(int[]A,int n) {
        //n = length of the array
        if (n <= 1) {
            return;
        }
        else {
            insertionSort(A, n - 1);
            int i;
            int temp = A[n - 1];

            for (i = n - 2; i >= 0 && A[i] > temp; i--) {
                A[i + 1] = A[i];
            }
            A[i + 1] = temp;

        }
        Util.print1Dint(A);
    }

    @Override
    public  void rBubbleSort(int[] A) {
        bubbleSort(A,0);
    }

    @Override
    public void rSelectionSort(int[] A) {
        selectionSort(A,0);
    }

    @Override
    public void rInsertionSort(int[] A) {
        insertionSort(A,A.length);
    }

    @Override
    public void iQuickSort(int[] A) {
    }

    @Override
    public void iMergeSort(int[] A) {
    }

    /**
     * A method that generates an array of random integers from 0-1000
     * @param size the amount of integers generated
     * @return an array of integers
     */
    public  int[] randomNumbers (int size) {

        int[] newArray = new int [size];
        Random numbers = new Random();
        for (int i=0; i<size; i++) {
            newArray[i]= numbers.nextInt(1000);
        }
        return newArray;
    }

    /**
     * A method that writes a file with integers from an array
     * @param A the array with numbers for which will be written in the file
     */
    public  void fileWriter(int[]A){
        try
        {
            PrintWriter print = new PrintWriter("file.txt");
            for (int i=0; i<A.length ; i++)
            {
                print.print(A[i]+",");
            }
            print.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("file not found");
        }
    }

    /**
     * a method that makes an array of integers based on a txt file
     * @param fName the name of the file
     * @param size the size of the array (it most be the same as the number of integers in the txt file
     * @throws IOException if file not found
     */
    public  int[] fileReader (String fName, int size)throws IOException{
       int[] output = new int[size];
        FileReader fr = new FileReader(fName);
        BufferedReader textReader = new BufferedReader(fr);
        String[] intString = textReader.readLine().split(",");

        for (int j = 0; j < intString.length; j++) {
            output[j] = Integer.parseInt(intString[j]);
        }

        return output;
    }


   public static void main(String[] args) throws IOException {
       Tinevra5 k = new Tinevra5();
       int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

       System.out.print(Util.titleString("BubbleSort",'-'));
       k.rBubbleSort(unsortedArray.clone());

       System.out.print(Util.titleString("InsertionSort",'-'));
       k.rInsertionSort(unsortedArray.clone());

       System.out.print(Util.titleString("SelectionSort",'-'));
       k.rSelectionSort(unsortedArray.clone());

       System.out.print(Util.titleString("QuickSort",'-'));
       k.iQuickSort(unsortedArray.clone());

//        String f = "file.txt";
//        int[]c= randomNumbers(3200);
//        fileWriter(c);
//        int[] array =fileReader(f,3200);
//         insertionSort(array,array.length);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]+",");
//
//        }
    }

}
