package Lab5; /**
 * Created by LoriPena on 7/12/17.
 * Lorianne Pena with help from Isaac Torres and Jessica Dozal
 * CS 2401 Summer 2017
 * Lab 5
 */

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

//TODO Don't overkill with the exceptions! could've been more efficient with read

public class Pena5 implements Lab5Interface {
    static int counterBubble = 0;
    static int counterSelection = 0;
    static int counterInsertion = 0;

    /**
     * @param array For bubble sort we have a int array to take in the random numbers from file and sort them.
     * @param largestElement is used to find the largest number in the array and store it at the very end of the array.
     */
    public static void bubbleSortHelper(int[] array, int largestElement) {//bubble sort helper method
        Util.print1Dint(array);
        try {
            if (largestElement == 1) return;//base case
            for (int i = 0; i < largestElement - 1; i++) {//Traversing the array to make the necessary passes to sort
                counterBubble++;
                if (array[i] > array[i + 1]) {//Checking to see if the array at index i is greater then array at index plus 1
                    int temp = array[i];//if the if statement is satisfied a temp array is created to help swap the integers
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            bubbleSortHelper (array, largestElement - 1); //once the largest element is set at the end of the array
            // the recursive call finishes sorting the rest of the array and the method returns the sorted array and the
            // last element or largest number in the array.
        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
    }

    /**
     * @param array for selection sort is to take in a array of random integers from a file and sort them.
     * @param SmallestMinIn for this integer we have the smallest minimum index used to help us swap the rest of the array.
     */
    public static void selectionSortHelper(int[] array, int SmallestMinIn) { //selection sort helper method
        Util.print1Dint(array);
        try {
            if (SmallestMinIn <= array.length - 1) {//base case once the smallest minimum index reaches the second to the last
                //number/value we stop swapping because we have reached the base case.
                int currentMin = SmallestMinIn;// the first smallest minimum index in the array is equal to the current minimum index
                for (int i = SmallestMinIn + 1; i < array.length; i++) {//traversing the array to find the smallest value in each index
                    counterSelection++;
                    if (array[i] < array[currentMin]) { //if the element at index i is smaller then the array at the current minimum
                        // then update current minimum to the value at i
                        currentMin = i;
                    }
                }
                //Swapping elements from smallest minimum index to the current minimum index
                int temp = array[SmallestMinIn];
                array[SmallestMinIn] = array[currentMin];
                array[currentMin] = temp;
                selectionSortHelper (array, SmallestMinIn + 1);
            }
        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
    }

    /**
     * @param array to help us sort our insertion integer array that we take in form a file.
     * @param arraySize to keep track of the size/length of the array.
     */
    public static void insertionSortHelper(int[] array, int arraySize) {//insertion sort helper method
        Util.print1Dint(array);
        try {
            if (arraySize <= 1) return;//base case if the size of the array is smaller or equal to 1 return.
            insertionSortHelper (array, arraySize - 1);//we start sorting the elements recursively first.
            int lastElement = array[arraySize - 1];//place the last element in the correct index in the array.
            int i = arraySize - 2;
            //while there is still indices to check and that index is greater then last element
            while (i >= 0 && array[i] > lastElement) {
                counterInsertion++;
                //we swap the element and shift all the larger elements up to make room for the smaller elements correct location
                array[i + 1] = array[i];//i+1 is one position ahead of its current position
                i--;
            }
            array[i + 1] = lastElement;//we use i+1 so we can skip the first element in every iteration.
        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
    }

    /**
     * @param array A integer array to hold our random generated arrays from file. This method came from "Introduction
     *              to Java Programming" by Daniel Liang
     * @param first integer in the array
     * @param last  integer in the array
     * @return return the first variable in the integer.
     */

    public static int partition(int[] array, int first, int last) {//partition method from textbook
        int pivot = array[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && array[low] <= pivot)
                low++;
            while (low <= high && array[high] > pivot)
                high--;
            if (high > low) {
                int temp = array[high];
                array[high] = array[low];
                array[low] = temp;
            }
        }
        while (high > first && array[high] >= pivot)
            high--;
        if (pivot > array[high]) {
            array[first] = array[high];
            array[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    /**
     * @param array to take in integers
     * @param first integer in the array
     * @param last  integer in the array
     *              This method does not fully work
     */
    public static void quickSortHelper(int[] array, int first, int last) {//quick sort helper
        if (last > first) {
            partition (array, 0, array.length - 1);//calling the partition method to partition array
        }

    }

    /**
     * @param A taking in a array called A to call our helper method to sort the arrays passed
     */
    @Override
    public void rBubbleSort(int[] A) {
        try {
            bubbleSortHelper (A, A.length);
        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
    }

    /**
     * @param A taking in a array called A to call our helper method to sort the arrays passed
     */
    @Override
    public void rSelectionSort(int[] A) {
        try {
            selectionSortHelper (A, 0);
        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
    }

    /**
     * @param A taking in a array called A to call our helper method to sort the arrays passed
     */
    @Override
    public void rInsertionSort(int[] A) {
        try {
            insertionSortHelper (A, A.length);
        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
    }

    /**
     * @param A taking in a array called A to call our helper method to sort the arrays passed
     */
    @Override
    public void iQuickSort(int[] A) {
        try {
            quickSortHelper (A, 0, A.length - 1);
        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
    }

    /**
     * @param A taking in a array called A to call our helper method to sort the arrays passed
     */
    @Override
    public void iMergeSort(int[] A) {
    }

    /**
     * @param str takes in a string called str
     * @param n   to keep track of the size of the string
     *            This method helps to create the files needed to hold different lengths of random arrays to test
     */
    public static void generateFile(String str, int n) {
        Random rand = new Random ( );//create random array
        try {
            PrintWriter writer = new PrintWriter (str + ".txt");
            for (int i = 0; i < n; i++) {
                writer.println (rand.nextInt (100000));
            }
            writer.close ( );

        } catch (IOException a) {
            System.out.println ("ERROR");

        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
    }

    /**
     * @param str is a string parameter to help us take in a string needed to read from file
     * @return we return the array that is created from reading the file.
     */
    public static int[] readFile(String str) {
        int counter = 0;
        try {
            FileReader file = new FileReader (str);
            BufferedReader reader = new BufferedReader (file);
            String currLine;
            while ((currLine = reader.readLine ( )) != null) {//reading lines
                counter++;
            }
            int[] array = new int[counter];
            counter = 0;//resetting counter
            FileReader file2 = new FileReader (str);
            BufferedReader reader2 = new BufferedReader (file2);
            while ((currLine = reader2.readLine ( )) != null) {// create array
                array[counter] = Integer.parseInt (currLine);
                counter++;
            }
            file.close ( );
            return array;
        } catch (IOException a) {
            System.out.println (a);
        } catch (NumberFormatException a) {
            System.out.println ("Error Number format.");

        } catch (StackOverflowError a) {
            System.out.println ("Stack Overflow Error.");

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println ("Array out of bounds.");
        } catch (RuntimeException a) {
            System.out.println ("Error Runtime Exception.");
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        Pena5 k = new Pena5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort"));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort"));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort"));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("QuickSort"));
        k.iQuickSort(unsortedArray.clone());

//        try {
//            Pena5 test = new Pena5 ( );
//            for (int i = 100; i <= 3200; i = i * 2) {//for loop to generate files thanks to Isaac's suggestion
//                counterBubble = 0;//resetting counters
//                counterSelection = 0;
//                counterInsertion = 0;
//                generateFile ("" + i, i);//calling the method generate file also thanks to a suggestion from Isaac
//                int[] temp = readFile (i + ".txt");//temp array to test
//                System.out.println ("File name" + i + ".txt");//keeping track of what file I am in
//                System.out.println ("Before bubble sort: ");
//                System.out.println (Arrays.toString (temp));//look at the array before its sorted to make sure it works
//                test.rBubbleSort (temp);//calling the methods to help us sort the array
//                System.out.println ("After the bubble sort");
//                System.out.println (Arrays.toString (temp));//printing the sorted array
//                System.out.println ("Number of Comparisons:" + counterBubble);//getting the comparison totals
//
//                int[] temp2 = readFile (i + ".txt");
//                System.out.println ("File name" + i + ".txt");
//                System.out.println ("Before selection sort:");
//                System.out.println (Arrays.toString (temp2));
//                test.rSelectionSort (temp2);
//                System.out.println ("After the sort selection");
//                System.out.println (Arrays.toString (temp2));
//                System.out.println ("Number of Comparisons:" + counterSelection);
//
//
//                int[] temp3 = readFile (i + ".txt");
//                System.out.println ("File name" + i + ".txt");
//                System.out.println ("Before insertion sort:");
//                System.out.println (Arrays.toString (temp3));
//                test.rInsertionSort (temp3);
//                System.out.println ("After the sort insertion");
//                System.out.println (Arrays.toString (temp3));
//                System.out.println ("Number of Comparisons:" + counterInsertion);
//            }
//
//        } catch (NumberFormatException a) {
//            System.out.println ("Error Number format.");
//
//        } catch (StackOverflowError a) {
//            System.out.println ("Stack Overflow Error.");
//
//        } catch (ArrayIndexOutOfBoundsException a) {
//            System.out.println ("Array out of bounds.");
//        } catch (RuntimeException a) {
//            System.out.println ("Error Runtime Exception.");
//        }
    }
}
