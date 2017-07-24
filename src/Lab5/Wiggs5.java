package Lab5;

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Wiggs5 implements Lab5Interface {



    public void rBubbleSort(int[] A) {
        int size = (A.length - 1);
        rBubbleSortHelper(A,size);

    }


    public void rSelectionSort(int[] A) {
        rSelectionSortHelper(A, 0, A.length - 1);
    }


    public void rInsertionSort(int[] A) {
        int size = A.length - 1;
        rInsertionSortHelper(A,size);

    }


    public void iQuickSort(int[] A) {
        int tail = (A.length - 1)/2;
        int head = 0;
        A = iQuickSortHelper(A, head, tail);
        printArray(A);
    }


    public void iMergeSort(int[] A) {
     //HONORS ONLY
    }

    public static void main(String[] args) {

        Wiggs5 k = new Wiggs5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort"));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort"));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort"));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("QuickSort"));
        k.iQuickSort(unsortedArray.clone());
//        Scanner s = new Scanner(System.in);
//        try {
//            int x = s.nextInt();
//            if (x < 0) {
//                throw new IOException("Array of negative size");
//            }
//            int[] A = new int[x];
//            for (int i = 0; i < A.length; i++) {
//                A[i] = s.nextInt();
//                if(A[i] < 0){
//                    throw new IOException("Array with negative input");
//                }
//            }
//            rBubbleSort(A);
//            rSelectionSort(A);
//            rInsertionSort(A);
//            iQuickSort(A);
//
//
//        }  catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public int[] rBubbleSortHelper(int[] A, int size) {
        Util.print1Dint(A);
        int biggest;
        int temp;
        int runTime = A.length-1;
        if(size == 1){
            return A;
        }
        else {
        for (int i = 1; i < size; i++) {
            biggest = A[i+1];
            for (int j = 0; j < size - i; j++) {
                if (A[j] > biggest) {
                    // Swap A[j] with A[j + 1]
                    temp = A[j];
                    A[j] = biggest;
                    A[j + 1] = temp;

                }
            }
            }
            runTime = runTime*runTime;
            rBubbleSortHelper(A,size-1);
            System.out.println(runTime);
            }
            return A;
        }



    public int[] rSelectionSortHelper(int[] A, int low, int high) {
        Util.print1Dint(A);
        try {
            int runTime = high;
            if(low < 0) throw new IOException("Low cannot be negative");
            if(high < 0) throw new IOException("High cannot be negative");
            if (low < high) {
                // Find the smallest number and its index in A
                int indexOfMin = low;
                int min = A[low];
                for (int i = low + 1; i <= high; i++) {
                    if (A[i] < min) {
                        min = A[i];
                        indexOfMin = i;
                    }
                }
                // Swap the smallest in A[low .. high] with A[low]
                A[indexOfMin] = A[low];
                A[low] = min;
                // Sort the remaining list[low+1 .. high]
                runTime *= runTime;
                rSelectionSortHelper(A, low + 1, high);
                System.out.print(runTime);
            }
            return A;
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }



    public int[] rInsertionSortHelper(int[] A, int size) {
        Util.print1Dint(A);
        if(size <= 1){
            return A;
        }
        rInsertionSortHelper(A, size-1);

        int lastElem = A[size-1];
        int j = size - 2;

        while (j >= 0 && A[j] > lastElem){
            A[j+1] = A[j];
            j--;
        }
        A[j+1] = lastElem;

        return A;
    }

    public int[] iQuickSortHelper(int[] A, int head, int tail) {
        if(tail < head){
            int part = partitionQuick(A, head, tail);
            iQuickSortHelper(A, part + 1, tail);
            iQuickSortHelper(A, head, part - 1);
        }
        return A;
    }

    public int partitionQuick(int[] A, int head, int tail){
        int pivot = A[tail];
        int x = head - 1;

        for(int i = head; i <= tail - 1; i++){
            if (A[i] <= pivot){
                x = x + 1;
                //swap
               int temp = A[x];
                A[x] = A[i];
                A[i] = temp;
            }
        }
        int temp = A[x + 1];
        A[x - 1] = pivot;
        A[tail] = temp;

        return x + 1;
    }

    public void printArray(int[] A){
        for(int i = 0; i < A.length; i++){
            if(i == A.length-1){
                System.out.println(A[i]);
            }
            else{
                System.out.print(A[i] + " ");
            }
        }
    }

    public void generateFile(String fileName, int n){
        File bro = new File(fileName);
        FileWriter fw;
        int num = n;

        try{
            fw = new FileWriter(bro);
            BufferedWriter br = new BufferedWriter(fw);
            int intLine;
            Random r = new Random();

            while(num > 0){
                intLine = r.nextInt(30);
                br.write(intLine +  "/n");
                num--;
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] readFromFile(String fileName){
        Scanner scnr = new Scanner(System.in);
        System.out.print("File Path: "); //Why print this?
        FileReader fr;
        BufferedReader reader;

        Boolean successfulFileRead = false;
        int[] num;
        num = new int[0];
        while (!successfulFileRead) {
            System.out.print("File Path: "); //Why print it again? This is pointless.
            try {
                fr = new FileReader(fileName);
                reader = new BufferedReader(fr);

                int k = Integer.parseInt(reader.readLine());
                String[] intStrings = reader.readLine().split("");
                num = new int[intStrings.length];

                for (int i = 0; i < intStrings.length; i++) {
                    num[i] = Integer.parseInt(intStrings[i]);
                }
                return num;
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } catch (java.io.IOException r) {
                System.out.println("Wrong");


            }

        }
        return num;
    }



}