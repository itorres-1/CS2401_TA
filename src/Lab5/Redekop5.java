package Lab5; /**
 * Project: Lab5
 * Name: Jessica Redekop
 * Due: Tuesday, July 18, 2018
 * Professor: Dr. Urenda
 * T.A.: Isaac Torres
 */

import Testers.Util;

import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Redekop5{ //implements Lab5Interface

    public static void main(String[] args) throws IOException{
        Redekop5 k = new Redekop5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort",'-'));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort",'-'));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort",'-'));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("MergeSort",'-'));
        //k.iMergeSort(unsortedArray.clone());
//        Redekop5 classInstance = new Redekop5();
//
//        //String[] filenames = {"100", "200", "400", "800", "1600", "3200"};
//        //int numOfIntegers = {100, 200, 400, 800, 1600, 3200};
//
//        for (int i = 100; i <= 3200; i=i*2){
//            classInstance.generateFile(i+ ".txt", i);
//        }
//        classInstance.rBubbleSort(classInstance.readFromFile("C:\\Users\\Jessica\\IdeaProjects\\CS2401\\100.txt"));
    }

    /**
     * A method that given a filename as type String, creates a file with the String as the file  name, which
     * adds an int n amount of integers to that file.
     * @param filename The String name of a file
     * @param n The int number of integers needed per file
     */
    public void generateFile(String filename, int n) throws IOException {

        BufferedWriter writer = new BufferedWriter(new PrintWriter(new File(filename)));

        Random generator = new Random();
        int randomNumber;

        for(int i = 0; i <= n; i++){
            randomNumber = generator.nextInt(100);
            writer.write(randomNumber + " ");
        }
        writer.close();
    }

    /**
     * A method that given a filename as a String, reads a file called "filename"
     * and returns an int array of the data in the file.
     * @param filePath The string path of a file
     */
    public int[] readFromFile(String filePath) throws FileNotFoundException, IOException{

        FileReader file = new FileReader(filePath);//imports file reader
        BufferedReader textReader = new BufferedReader(file); //imports the file reader
        Scanner scanner = new Scanner(file);

        String line = scanner.nextLine();
        String[] stringIntegers = line.split(" ");

        int[] integerArray = new int[stringIntegers.length];

        for(int i = 0; i < integerArray.length; i++){
            integerArray[i] = Integer.parseInt(stringIntegers[i]);
        }
        return integerArray;
    }

    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of bubble sort.
     * @param A
     */
    public void rBubbleSort(int[] A){

        int counter = 0;
        print(recursiveBubbleSort(A,counter));

    }

    /**
     * A method that given a reference to an int array, and a counter, sorts that array
     * using a recursive implementation of bubble sort while keeping track of how many comparisons are made.
     * @param A
     * @param counter
     * @return A
     * */
    public int[] recursiveBubbleSort(int[] A, int counter) {
        Util.print1Dint(A);
        int thisPassCounter = 0;
        boolean anyChanges = false;

        for(int i = 0; i < A.length-1; i++){
            if(A[i+1] < A[i]) {
                int temp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = temp;
                anyChanges = true;
            }
            thisPassCounter = thisPassCounter + 2;
        }

        if(anyChanges == true)
            return recursiveBubbleSort(A, counter+thisPassCounter);
        else {
            System.out.println("The bubble sort method count is: " + counter+thisPassCounter);
            return A;
        }
    }

    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of selection sort.
     * @param A
     */
    public void rSelectionSort(int[] A){

        int counter = 0;
        int index = 0;
        print(recursiveSelectionSort(A, counter, index));
    }
    /**
     * A method that given a reference to an int array, and a counter, sorts that array
     * using a recursive implementation of selection sort while keeping track of how many comparisons are made,
     * and an index to keep track of where the array is already sorted.
     * @param A
     * @param counter
     * @param index
     * @return A
     * */
    public int[] recursiveSelectionSort(int[] A, int counter, int index) {
        Util.print1Dint(A);
        int smallest = A[index];
        int smallestIndex = index;
        int temp;

        if (index == A.length - 1){
            counter++;
            System.out.println("The selection sort method count is: " + counter);
            return A;
        }
        counter++;

        for (int i = index; i < A.length; i++) {
            if (smallest > A[i]) {
                smallest = A[i];
                smallestIndex = i;
            }
            counter = counter + 2;
        }

        counter = counter + 2;
        temp = A[index];
        A[index] = smallest;
        A[smallestIndex] = temp;
        return recursiveSelectionSort(A, counter, ++index);
    }

    /**
     * A method that given a reference to an int array, sorts that array
     * using a recursive implementation of insertion sort.
     * @param A
     */
    public void rInsertionSort(int[] A){

        int counter = 0;
        int index = 0;
        print(recursiveInsertionSort(A, counter, index));

    }

    /**
     * A method that given a reference to an int array, and a counter, sorts that array
     * using a recursive implementation of insertion sort while keeping track of how many comparisons are made,
     * and an index to keep track of where the array is already sorted.
     * @param A
     * @param counter
     * @param index
     * @return A
     */
    public int[] recursiveInsertionSort(int[] A, int counter, int index){
        Util.print1Dint(A);
        int smallest = A[index];
        int indexOfSmallest = index;
        int temp = A[index];

        if (index == A.length-1){
            counter++;
            System.out.println("The insertion sort method count is: " + counter);
            return A;
        }
        counter++;

        for(int i = index; i < A.length; i++) {
            if (smallest > A[i]) {
                smallest = A[i];
                indexOfSmallest = i;
            }
        }

        for(int i = index; i > -1; i--){
            if (smallest < A[0]){
                for(int j = indexOfSmallest-1; j > 0; j--){
                    A[j+1]=A[j];
                }
                A[0]=smallest;
            }
            else{
                if(smallest < A[i]) {
                    for (int j = indexOfSmallest - 1; j > i; j--) {
                        A[j + 1] = A[j];
                    }
                    A[i] = smallest;
                    break;
                }
            }
        }

        return recursiveInsertionSort(A, counter, ++index);
    }

    /**
     * An extra credit method that given a reference to an int array, sorts that array
     * using an iterative implementation of merge sort.
     * @param A
     */
    public void iMergeSort(int[] A){

        int[] firstHalf = new int[A.length/2];
        int[] secondHalf = new int[A.length - A.length/2];

        for(int i = 0; i <A.length/2; i++)
            firstHalf[i] = A[i];

        for(int i = 0; i < A.length-A.length/2; i++)
            secondHalf[i] = A[i];

        print(merge(firstHalf, secondHalf));
    }

    public int[] merge(int[] list1, int[] list2) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        int[] temp = new int[list1.length + list2.length];

        for(int i = 0; i < temp.length; i++){
            if(list1 == null)
                iMergeSort(list1);
            if(list2 == null)
                iMergeSort(list2);
            if(list1[current1] > list2[current2]){
                temp[i] = list2[current2];
                current2++;
            }
            else{
                temp[i] = list1[current1];
                current1++;
            }
        }

        return temp;
    }

    public void print(int[] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public void iQuickSort(int[] A){}
}
