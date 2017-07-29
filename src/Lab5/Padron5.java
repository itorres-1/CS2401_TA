package Lab5;

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Author Cesar Arturo Padron
 * 7/16/2017
 * Professor: Julio Cesar Urenda
 */
public class Padron5 implements Lab5Interface {
    public static void main(String[] Args){

        //k.iQuickSort(unsortedArray.clone());

//        Scanner scan = new Scanner(System.in);
//        System.out.print("Number length");
//        int numberLength = scan.nextInt();
//        createFile(numberLength);
//        int[] a = readFile(numberLength);
//        int n= quickSortHelp(a,0);
//
//        for (int i = 0;i<a.length;i++){
//            System.out.print(a[i] + " ");
//        }

    }


    public static int selectionSortHelp(int[] a,int i,int counter){
        Util.print1Dint(a);
        if (i!=a.length){
            counter++;
            int min = i;
            int temp;
            for(int j = i+1;j<a.length;j++){
                if(a[j] < a[min]){
                    counter++;
                    min = j;
                }
                counter++;
            }
            if(min != i){
                counter++;
                temp = a[i];
                a[i] = a[min];
                a[min]=temp;
            }
            selectionSortHelp(a,i+1,counter);
        }

        return counter;
    }
    public static int bubbleSortHelp(int[] a, int i,int counter){
        Util.print1Dint(a);
        boolean needNextPass = true;
        if (i!=a.length && needNextPass){
            counter++;
            for (int j = 0;j<a.length-i;j++){
                counter++;
                if (a[j]>a[j+1]){
                    counter++;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=temp;
                    needNextPass = true;
                }
            }
            bubbleSortHelp(a,i+1,counter);
        }
        else{
            needNextPass = false;
        }
        return counter;
    }
    public static int insertionSortHelp(int[] a, int i,int counter){
        Util.print1Dint(a);
        if (i != a.length){
            counter++;
            int current = a[i];
            int j;
            for (j = i-1; j>=0 && a[j]>current;j--){
                counter++;
                a[j+1] = a[j];
            }
            a[j+1] = current;

            insertionSortHelp(a,i+1,counter);
        }
        return counter;

    }
    public static int quickSortHelp(int[] A,int counter) {
        int c = 0;
        while (c < A.length-1){
            counter++;
            int pivot = partition(A, 0, A.length - 1);
            for (int i = 0; i < A.length / 2; i++) {
                counter++;
                int pivot3 = partition(A, 0, pivot);
                partition(A, i, pivot);
            }
            for (int j = A.length / 2; j < A.length; j++) {
                counter++;
                int pivot2 = partition(A, pivot + 1, A.length - 1);
                partition(A, j, A.length - 1);
            }
            c++;
        }
        return counter;
    }
    //This method i got it from Introduction to Java Programing Comprehenseve Version, 10th edition, Author: Y.Daniel Liang
    public static int partition(int[] list, int first, int last){
        int pivot = list[first];
        int low = first+1;
        int high = last;
        while (high >low){
            while (low <= high && list[low]<=pivot){
                low++;
            }
            while (low <= high && list[high] > pivot){
                high--;
            }
            if (high>low){
                int tmp = list[high];
                list[high] = list[low];
                list[low] = tmp;
            }
        }
        while(high > first && list[high] >= pivot) {
            high--;
        }
        if (pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }

    public void rBubbleSort(int[] A) {
        bubbleSortHelp(A,1,0);
    }
    public void rSelectionSort(int[] A) {
        selectionSortHelp(A,0,0);
    }
    public void rInsertionSort(int[] A) {
        insertionSortHelp(A,1,0);
    }
    public void iQuickSort(int[] A) {
        quickSortHelp(A,0);
    }
    public void iMergeSort(int[] A) {

    }

    public static void createFile(int n) {

        File file = new File("C:\\Users\\Jose Padron\\Documents\\CS2401\\CS2401Summer2017Lab5\\"+String.valueOf(n)+".txt");

        try {
            if (file.createNewFile()){
                System.out.println("File is created!");
            }else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            for (int i =0;i<n;i++) {
                Random rand = new Random();

                int  num = rand.nextInt(1000);
                writer.write(String.valueOf(num) + " ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int[] readFile(int n){

        int[] A = new int[n];

        FileReader fr = null;
        BufferedReader br=null;
        String[] intStrings = new String[0];

        try{
            fr = new FileReader(String.valueOf(n)+".txt");
            br = new BufferedReader(fr);


                intStrings = new String[n];
                intStrings = br.readLine().split(" ");

            for (int i =0;i<A.length;i++){
                A[i] = Integer.parseInt(intStrings[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }


        return A;

    }

}
