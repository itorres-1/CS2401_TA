package Lab5;

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.Arrays;
import java.util.*;

/**
 * Created by Light on 7/12/2017.
 */
public class Vela5 implements Lab5Interface {
static int counter = 0;
static int counter2 = 0;
static int counter3 = 0;
static int counter4 = 0;
    /**
     * This method is a helper method, to use the notion of both high and low to help move through a given array
     * and then in turn sort it by 'bubbling' up the largest element and moving it to the highest position, consecutively
     * until the given array is sorted.
     *
     * @param A the array that's provided.
     * @param low a low parameter that keeps track of the lowest index point in an array, in this case 0.
     * @param high a high parameter that keeps track of the highest point in an array, in this case A.length.
     */
    public static void bubbleSortHelp(int[] A, int low, int high) {
        Util.print1Dint(A);

        if (low >= high) {
            return;
        }

        else{
            for(int i = low; i < high -1; i++) {
                if (A[i + 1] < A[i]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    counter++;
                    //bubbleSorthelp(A, low + 1, high);
                }
            }
           //else {
            bubbleSortHelp(A, low, high-1);

        }
    }

    /**
     * This method is a helper method, to also use the notion of both high and low parameters to move through
     * a given array. Then as it moves through it will 'select' the smallest element and switch it with the current
     * smallest element that it's being checked against. It will continually do so, until the array is sorted.
     *
     * @param A the array that's provided.
     * @param indexLow a low parameter that keeps track of the lowest index point in an array, in this case 0.
     * @param indexHigh a high parameter that keeps track of the highest point in an array, in this case A.length.
     */
    public static void selectSortHelp(int[] A, int indexLow, int indexHigh) {
        Util.print1Dint(A);
        ///for(int i = 0; i < A.length; i++){
        if (indexLow >= indexHigh) {
            return;
        } else if(indexLow < indexHigh-1){
            int curr = indexLow;
            for(int i = indexLow+1; i < A.length;i++){
                if(A[curr]>A[i]){
                    curr = i;
                }
            }
            int temp = A[indexLow];
            A[indexLow] = A[curr];
            A[curr]= temp;
            counter2++;

            selectSortHelp(A,indexLow+1,indexHigh);

        }

        else {
            selectSortHelp(A, indexLow, indexHigh-1);
        }
    }

    /**
     *This method is a helper method, to help with insertion sort using a the notion of a high index to help move
     * through a given array.
     *
     * @param A the array that's provided.
     * @param high a high parameter that keeps track of the highest point in an array, in this case A.length.
     */
    public static void insertionSortHelp(int[] A,int high) {
        Util.print1Dint(A);
        if (high == 1) {
            return;
        }

        else {
        if (high > 1){
            insertionSortHelp(A,high-1);
             if(high==A.length){
               high = 1;
                insertionSortHelp(A,high);
            }
            int curr = A[high];
            int i = high-1;
            while(i>= 0 && A[i] > curr){
                A[i+1] = A[i];
                counter3++;
                i--;

            }
            A[i+1] = curr;
        }

        }
    }


    /**
     * Method returns the given sorted array
     *
     * @param Array the array that's provided.
     * @param low the low index of the given array.
     * @param high the high index of the given array, set to A.length.
     */
    public static void quickSortHelp(int[] Array, int low, int high){
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while(!stack.isEmpty()){
            int h = stack.pop();
            int l = stack.pop();

            int partitionIdx = partitionQuickSortHelp(Array,l,h,Array[h]);
            if(partitionIdx - 1>1){
                stack.push(l);
                stack.push(partitionIdx-1);
                counter4++;
            }
            if(partitionIdx +1 < h){
                stack.push(partitionIdx+1);
                stack.push(h);
                counter4++;
            }
        }
        //int index = partitionQuickSortHelp(A,first,last);

        //if(first<index-1){
            //quickSortHelp(A,first,index-1);
        //}

        //if(last> index){
            //quickSortHelp(A,index,last);
        //}
    }

    /**
     * A method that helps separate elements into separate partitions of each other and in turn helps
     * the iterative quick sort method to execute its sorting. By shuffling elements.
     *
     * @param A the array that's provided.
     * @param low the low index of the array set to 0.
     * @param high the high index of the array set to A.length.
     * @param pivot A pivot integer that helps decided what elements get split to what side when using
     *              quick sort.
     * @return
     */
    public static int partitionQuickSortHelp(int[]A, int low, int high, int pivot) {
        int left = low - 1;
        int right = high;
        while (true) {
            while (A[++left] < pivot && left < right)
                ;
            while (A[--right] > pivot && right > 0)
                ;
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            } else
                break;
        }
        int temp = A[left];
        A[left] = A[high];
        A[high] = temp;



        //int pivot = A[right];// first element is pivot
        //int i = (left-1);
        //for(int j = left;j<=right-1;j++){


        //int temp = A[i+1];
        //A[i+1]=A[right];
        //A[right] = temp;

        return left;
    }

    /**
     * Generates a file of a random set of integers provided by the parameter of int A.
     * @param name a name that will be used for the file.
     * @param A a integer to set the length of the random array that will generated.
     */
    public static void fileGenerator(String name, int A) {
        int[] random = new int[A];
        for (int i = 0; i < random.length; i++) {
            random[i] = (int) (Math.random() * A);
        }


        try{
            File file = new File(name + name.length() + ".txt");

            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Arrays.toString(random));
            bw.close();


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void readFromFile(String name){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(name));
        }catch (FileNotFoundException e){
            System.out.println("Lul");
        }
    }

    /**
     * Prints a given array.
     * @param A takes an Array as the input to then print it.
     */
    public static void printSortedArray(int[]A){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    @Override
    public void rBubbleSort(int[] A) {
        int low = 0;
        int high = A.length;
        bubbleSortHelp(A, low, high);

    }

    @Override
    public void rSelectionSort(int[] A) {
        int indexLow = 0;
        int indexHigh = A.length;
        selectSortHelp(A,indexLow, indexHigh);
    }

    @Override
    public void rInsertionSort(int[] A) {
        int high = A.length;


        insertionSortHelp(A,high);
    }

    @Override
    public void iQuickSort(int[] A) {
        int low =0;
        int high = A.length-1;

        quickSortHelp(A,low,high);
    }

    @Override
    public void iMergeSort(int[] A) {

    }


    public static void main(String[] args) {
        Vela5 k = new Vela5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort",'-'));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort",'-'));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort",'-'));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("QuickSort",'-'));
        k.iQuickSort(unsortedArray.clone());

//        int [] kek = {1,8,7,-2,23,5,67,100,-1};
//
//        Vela5 rip = new Vela5();
//        //rip.rBubbleSort(kek);
//        //printSortedArray(kek);
//        //System.out.println(" ");
//
//        //rip.iQuickSort(kek);
//        //printSortedArray(kek);
//
//        //System.out.println(" ");
//        //rip.rSelectionSort(kek);
//        //printSortedArray(kek);
//
//        //rip.rInsertionSort(kek);
//        //System.out.println(" ");
//
//        //printSortedArray(kek);
//        //System.out.println(counter4);


    }
}