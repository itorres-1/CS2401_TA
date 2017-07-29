package Lab5; /*****************************************
 * Aaron Monty
 * CS2401: Summer 2017
 * Date: June 17
 * Lab 5: due July 19
 *****************************************/

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Monty5 implements Lab5Interface {
    @Override
    public void rBubbleSort(int[] A){
        bubbleSort(A,A.length);
    }
    @Override
    public void rSelectionSort(int[] A){
        selectionSort(A, A.length);
    }

    @Override
    public void rInsertionSort(int[] A) {
        insertionSort(A, A.length);
    }
    @Override
    public void iMergeSort(int[] A){

    }
    @Override
    public void iQuickSort(int[] A){}


    public static int bubbleSort(int[] list, int count) {
        Util.print1Dint(list);
        int comparisons =0;
        //base case
        if (count == 1) {
            //no sorting is needed
            return comparisons;
        }
        for (int i = 0; i < list.length - 1; i++) {
            comparisons++;
            if (list[i] > list[i + 1]) {
                //swap list[i] with list[i+1]
                int temp = list[i];
                list[i] = list[i + 1];
                list[i + 1] = temp;
            }
        }
        bubbleSort(list, count - 1);
        return comparisons;
    }

    public static int insertionSort(int[] arr, int n) {
        Util.print1Dint(arr);
        int comparisons=0;
        //base case

        if (n <= 1) {
            comparisons++;
            return comparisons;
        }
        insertionSort(arr, n - 1);
        //insert last element at its correct position in sorted array
        int last = arr[n - 1];
        int j = n - 2;
        /*move elements of arr, that are greater than last,
        to one position ahead of their current position
         */
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
            comparisons= comparisons +3;
        }
        arr[j + 1] = last;
        return comparisons;
    }

    public static int selectionSort(int arr[],int n){
        Util.print1Dint(arr);
        //find the smallest element and swap it for 1st position
        int comparisons= 0;
        if(n==arr.length -1){
            comparisons++;
            return comparisons;
        }
        int temp,lowestIndex =n;
        for(int i= n+1; i<arr.length;i++){
            comparisons++;
            if(arr[i]<arr[lowestIndex]){
                lowestIndex=i;
                comparisons=comparisons+2;
            }
        }
        //swap arr[min] with arr[i]
        temp=arr[n];
        arr[n]=arr[lowestIndex];
        arr[lowestIndex]=temp;

        selectionSort(arr, n+1);
        return comparisons;
    }

    public static void printArray(int [] a){
        for(int i= 0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static int[] makeArray(int s, int e){
        int[] newArr = IntStream.rangeClosed(s,e).toArray();
        return newArr;
    }

    public static void writeFile(File n, int [] a,int s)throws IOException{
        // s determines the name of file assigned to n
        if(s==1){
            n = new File("oneHundred.txt");
        }
        if(s==2){
            n = new File("twoHundred.txt");
        }
        if(s==4) {
            n = new File("fourHundred.txt");
        }
        if(s==8) {
            n = new File("eightHundred.txt");
        }
        if(s==16) {
            n = new File("sixteenHundred.txt");
        }
        if(s==32) {
            n = new File("thirtytwoHundred.txt");
        }

        BufferedWriter fileWriter = null;
        fileWriter = new BufferedWriter(new FileWriter(n));
        try {
           for (int i = 0; i < a.length; i++) {
              fileWriter.write(Integer.toString(a[i]));
              fileWriter.newLine();
              }
        }catch (IOException e) {
           System.out.println("file already exist");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public static int [] fileRead(File name,int size)throws IOException{
        int [] fileArr=new int[size];
        FileReader fr = new FileReader(name);
        BufferedReader intReader = new BufferedReader(fr);
        try {
            for (int i = 0; i < size; i++) {
                fileArr[i] = Integer.parseInt(intReader.readLine());
            }
        }catch(IOException e){
            System.out.println("file not found");
        }
        return fileArr;
    }

    public static void shuffleArray(int [] array){
        // Fisher–Yates shuffle
        int index;
        int temp;
        Random rnd = ThreadLocalRandom.current();
        for(int i = array.length-1; i>0; i--){
            index = rnd.nextInt(i+1);
            int a = array[index];
            array[index]= array[i];
            array[i]=a;
        }
    }
    //public static void readFile(int [] )

    public static void main(String[] args) throws IOException{
        Monty5 k = new Monty5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort",'-'));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort",'-'));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort",'-'));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("MergeSort",'-'));
        //k.iMergeSort(unsortedArray.clone());

//        //make array of specific numbers in range
//        int [] hundred= makeArray(1,100);
//        shuffleArray(hundred);
//
//        //write to specified file, marking with range
//        File File1= null;
//        try {
//            writeFile(File1,hundred,1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //use methods to sort arrays
//        File oneHundred= new File("oneHundred.txt");
//        try{
//            System.out.println("Bubble sort made " + bubbleSort(fileRead(oneHundred,100),hundred.length) + " comparisons for 100 integers");
//
//            System.out.println("Insertion sort made " + insertionSort(fileRead(oneHundred,100),hundred.length) + " comparisons for 100 integers");
//
//            System.out.println("Selection sort made " + selectionSort(fileRead(oneHundred,100),0) + " comparisons for 100 integers");
//        }catch(IOException e ){
//            System.out.println("file not found");
//        }
//
//
//        int [] twoHun= makeArray(1,200);
//        shuffleArray(twoHun);
//        File File2= null;
//        //change array to the 200 numbered array
//        try {
//            writeFile(File2,twoHun,2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //use methods to sort arrays
//        File twoHundred= new File("twoHundred.txt");
//        try{
//            System.out.println( "\n" + "Bubble sort made "  + bubbleSort(fileRead(twoHundred,200),twoHun.length) + " comparisons for 200 integers");
//
//            System.out.println("Insertion sort made " + insertionSort(fileRead(twoHundred,200),twoHun.length) + " comparisons for 200 integers");
//
//            System.out.println("Selection sort made " + selectionSort(fileRead(twoHundred,200),0) + " comparisons for 200 integers");
//        }catch(IOException e ){
//            System.out.println("file not found");
//        }
//
//        int [] fourHun= makeArray(1,400);
//        shuffleArray(fourHun);
//        File File3= null;
//        try {
//            writeFile(File3,fourHun,4);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //use methods to sort arrays
//        File fourHundred= new File("fourHundred.txt");
//        try{
//            System.out.println( "\n" + "Bubble sort made "  + bubbleSort(fileRead(fourHundred,400),fourHun.length) + " comparisons for 400 integers");
//
//            System.out.println("Insertion sort made " + insertionSort(fileRead(fourHundred,400),fourHun.length) + " comparisons for 400 integers");
//
//            System.out.println("Selection sort made " + selectionSort(fileRead(fourHundred,400),0) + " comparisons for 400 integers");
//        }catch(IOException e ){
//            System.out.println("file not found");
//        }
//
//        int [] eightHun=makeArray(1,800);
//        shuffleArray(eightHun);
//        File File4= null;
//        try {
//            writeFile(File4,eightHun,8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File eightHundred= new File("eightHundred.txt");
//        try{
//            System.out.println( "\n" + "Bubble sort made "  + bubbleSort(fileRead(eightHundred,800),fourHun.length) + " comparisons for 800 integers");
//
//            System.out.println("Insertion sort made " + insertionSort(fileRead(eightHundred,800),fourHun.length) + " comparisons for 800 integers");
//
//            System.out.println("Selection sort made " + selectionSort(fileRead(eightHundred,800),0) + " comparisons for 800 integers");
//        }catch(IOException e ){
//            System.out.println("file not found");
//        }
//
//        int [] sixteenHun=makeArray(1,1600);
//        shuffleArray(sixteenHun);
//        File File5= null;
//        try {
//            writeFile(File5,sixteenHun,16);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //use methods to sort arrays
//        File sixteenHundred= new File("sixteenHundred.txt");
//        try{
//            System.out.println( "\n" + "Bubble sort made "  + bubbleSort(fileRead(sixteenHundred,1600),sixteenHun.length) + " comparisons for 1600 integers");
//
//            System.out.println("Insertion sort made " + insertionSort(fileRead(sixteenHundred,1600),sixteenHun.length) + " comparisons for 1600 integers");
//
//            System.out.println("Selection sort made " + selectionSort(fileRead(sixteenHundred,1600),0) + " comparisons for 1600 integers");
//        }catch(IOException e ){
//            System.out.println("file not found");
//        }
//
//        int [] thirtytwoHun=makeArray(1,3200);
//        shuffleArray(thirtytwoHun);
//        File File6= null;
//        try {
//            writeFile(File6,thirtytwoHun,32);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //use methods to sort arrays
//        File thirtytwoHundred= new File("thirtytwoHundred.txt");
//        try{
//            System.out.println( "\n" + "Bubble sort made "  + bubbleSort(fileRead(thirtytwoHundred,3200),thirtytwoHun.length) + " comparisons for 3200 integers");
//
//            System.out.println("Insertion sort made " + insertionSort(fileRead(thirtytwoHundred,3200),thirtytwoHun.length) + " comparisons for 3200 integers");
//
//            System.out.println("Selection sort made " + selectionSort(fileRead(thirtytwoHundred,3200),0) + " comparisons for 3200 integers");
//        }catch(IOException e ){
//            System.out.println("file not found");
//        }

    }
}