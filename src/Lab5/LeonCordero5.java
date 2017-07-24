package Lab5;
import Testers.Util;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LeonCordero5 {
    public int counter = 0;

    //TODO iQuickSort solution looks an aweful lot like geekforgeekssolution
    //TODO -10 points in correctness for not implementing iQuickSort(int[] A)
    //These are the recursive bubble sort methods. They work together.
    /**
     * The rBubbleSort method takes in the array and sends it to rBubbleSortHelper, which can use recursion to sort
     * the array. It also restores the global variable, counter, to 0.
     * @param A (integer array) This is the array as read from the file.
     */
    public void  rBubbleSort(int[] A) {
        rBubbleSortHelper(A, A.length);
        this.counter = 0;
    }
    /**
     * The rBubbleSortHelper is the recursive side of the bubble sort algorithm. It mimics the improved bubble sort,
     * which is a modified bubble sort which considers if the next pass on the array is needed or not, which ultimately
     * results in fewer calculations. It also counts how many comparisons it does, and sends them to a global variable.
     * @param A (int array) this is the array as read from the file.
     * @param n (this is the length of the array, needed to correctly apply the recursive aspect of sorting. As the
     *          elements are sorted, they "bubble" to the top and are therefore deemed as sorted, thus n decreases per
     *          call.
     * @return  (int array) this returns the sorted array.
     */
    private int[] rBubbleSortHelper(int[] A, int n) {
        Util.print1Dint(A);
        boolean needNextPass = false;
        for(int i = 0; i < n - 1; i++) {
            if(A[i] > A[i + 1]) {
                int temp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = temp;
                needNextPass = true;
            }
            this.counter++;
        }
        if(!needNextPass) {
            return A;
        } else {
            return rBubbleSortHelper(A, n-1);
        }
    }

    //These are the recursive selection sort methods. They work together.
    /**
     * The rSelectionSort method takes in an array and sends it to rSelectionSortHelper, as well as the lower index
     * and upper index, which are critical to starting the sorting at the correct locations. It also restores the
     * global variable, counter, to 0.
     * @param A (integer array) This is the array as read from the file.
     */
    public void rSelectionSort(int[] A) {
        rSelectionSortHelper(A, 0, A.length - 1);
        this.counter = 0;
    }
    /**
     * The selectionSortHelper method is the recursive side of the selection sort algorithm. This takes the upper loop
     * of the iterative version and turns it into a recursive function call. The rest of the program is exactly the
     * same as the iterative version, and it keeps track of the number of operations it performs and returns the
     * sorted array.
     * @param A (integer array) this is the array as read from the file.
     * @param low (int) this is the lower index of the unsorted part of the array.
     * @param high (int) this is the top index of the unsorted part of the array.
     * @return (int array) this returns the sorted array.
     */
    private int[] rSelectionSortHelper(int[] A, int low, int high) {
        Util.print1Dint(A);
        if(low == high) {
            return A;
        } else {
            int indexOfMin = low;
            int min = A[low];
            for(int i = low + 1; i <= high; i++) {
                if(A[i] < min) {
                    min = A[i];
                    indexOfMin = i;
                }
                this.counter++;
            }
            A[indexOfMin] = A[low];
            A[low] = min;
            return rSelectionSortHelper(A, low + 1, high);
        }
    }

    //These are the recursive insertion sort methods. They work together.
    /**
     *The rInsertionSort method takes in an array and sends it to rInsertionSortHelper, as well as the initial
     * condition of the first loop (first loop in the iterative version). It also restores the global variable, counter,
     * to 0.
     * @param A (integer array) This is the array as read from the file.
     */
    public void rInsertionSort(int[] A) {
        rInsertionSortHelper(A, 1);
        this.counter = 0;
    }
    /**
     * The rInsertionSortHelper method is the recursive function of the insertion sort algorithm. It eliminates the
     * outer loop of the iterative version by passing this method the beginning "i" of the aforementioned loop,
     * setting the final return condition to the cap of the aforementioned loop, and incrementing the counter in every
     * recursive call. It also keeps track of the number of comparisons it conducts.
     * @param A (int array) This is the array as read from the file.
     * @param n (int) this is the control variable that controls how many loops the array should do. (until A.length-1)
     * @return (int array) this returns the sorted array.
     */
    private int[] rInsertionSortHelper(int[] A, int n) {
        Util.print1Dint(A);
        if(n == A.length) {
            return A;
        } else {
            int currentElement = A[n];
            int k;
            for (k = n - 1; k >= 0 && A[k] > currentElement; k--) {
                A[k + 1] = A[k];
                this.counter++;
            }
            A[k + 1] = currentElement;
            return rInsertionSortHelper(A, n + 1);
        }
    }

    //These are the iterative quick sort methods. They work together.
    /**
     * iQuickSwap swaps the values passed on to it by iQuickPartition. This is the mechanism of the iterative quick sort
     * algorithm that actually changes the places of a value in the array, as dictated by the iQuickPartition method.
     * @param arr (int array) This is the array/sub-array that is sent to this method so that it swaps the values
     *            specified.
     * @param i (int) this is the index of the element in the lower array.
     * @param j (int) this is the index of the element in the upper array.
     */
    private void iQuickSwap(int arr[],int i,int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    /**
     * iQuickPartition is the mechanism in the quick sort algorithm that determines which values in the array are to be
     * swapped, sends them to iQuickSwap to swap them, and then returns the index of the new pivot which is sent to
     * iQuickSort which in turn decides whether that partition has smaller sub-arrays to be sorted. Since this is where
     * the comparisons of values in an array actually happen, this is the method that keeps track of the amount of
     * calculations the iterative quick sort algorithm does.
     * @param A (int array) This is the array/sub-array that is sent to this method so that the method determines if
     *          the values at certain indices should be swapped or not.
     * @param l (int) this is the lower index of the array/sub-array.
     * @param h (int) this is the higher index of the array/sub-array, which in turn becomes the pivot of the array.
     * @return (int) this returns the new pivot in the array, which iQuickSort uses to the determine if there are any
     *         sub-arrays to be sorted.
     */
    private int iQuickPartition (int A[], int l, int h) {
        int pivot = A[h];
        int i = (l - 1);

        for(int j = l; j <= h- 1; j++) {
            if(A[j] <= pivot) {
                i++;
                iQuickSwap(A,i,j);
            }
            this.counter++;
        }
        iQuickSwap(A,i+1,h);
        return (i + 1);
    }
    /**
     * iQuickSort is the method that does the logic behind the iterative version of quick sort. It creates a stack that
     * gets the lower and upper indices of the original array pushed to it, then the lower and upper indices of
     * sub-sequent sub-arrays until the stack is full (as dictated by dynamic pivots determined by iQuickPartition). It
     * then calls on the iQuickPartition method which actually compares the values in the array/sub-arrays of the
     * original array, until all the stacks have been popped, which means that the whole array and its sub-arrays have
     * been sorted. Since some comparison calculations do take place in here, this method also contributes to the
     * calculation counter.
     * @param A (int array) This is the original array as specified from the file.
     * @param l (int) this is the lower index of the array.
     * @param h (int) this is the higher index of the array
     * @return (int array) this is the sorted array.
     */
    private int[] iQuickSort(int A[], int l, int h) {
        int stack[] = new int[h - l + 1];
        int top = -1;
        stack[++top] = l;
        stack[++top] = h;

        while(top >= 0) {
            h = stack[top--];
            l = stack[top--];
            int pivot = iQuickPartition(A, l, h);

            if(pivot - 1 > l) {
                stack[++top] = l;
                stack[++top] = pivot - 1;
            }
            if(pivot + 1 < h) {
                stack[++top] = pivot + 1;
                stack[++top] = h;
            }
            this.counter++;
        }
        this.counter = 0;
        return A;
    }

    //These are the file manipulation methods.
    /**
     * generateFile creates a new file with a specified filename and also creates an array with a specified length.
     * Then, it opens a writer which writes randomly generated numbers, which are stored in the array, to the file.
     * @param filename (String) the desired filename of the file to create.
     * @param n (int) the desired length of the array.
     */
    private static void generateFile(String filename, int n) {
        File file = new File(filename);
        int[] array = new int[n];

        try(PrintWriter writer = new PrintWriter(file)){
            for(int i = 0; i < n; i++) {
                int number = ThreadLocalRandom.current().nextInt(0,1091232);
                array[i] = number;
                writer.println(array[i]);
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * readArrayFromFile creates an integer array in which to store the data from the file, opens up a new scanner,
     * and reads the data from the file with a loop for each index in the array.
     * @param filePath (String) this is the path of the file to be read
     * @param n (integer) this is the length of the array
     * @return (int array) this is the array created, which stores the data read from the file
     */
    public static int[] readArrayFromFile(String filePath, int n){
        int[] array = new int[n];

        try (Scanner input = new Scanner(new File(filePath))) {
            int k = 0;
            while(input.hasNextInt()) {
                array[k] = input.nextInt();
                k++;
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return array;
    }

    public static void main(String[] args) {
        LeonCordero5 k = new LeonCordero5();
        int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

        System.out.print(Util.titleString("BubbleSort"));
        k.rBubbleSort(unsortedArray.clone());

        System.out.print(Util.titleString("InsertionSort"));
        k.rInsertionSort(unsortedArray.clone());

        System.out.print(Util.titleString("SelectionSort"));
        k.rSelectionSort(unsortedArray.clone());

        System.out.print(Util.titleString("QuickSort"));
        //k.iQuickSort(unsortedArray.clone());

//        LeonCordero5 object = new LeonCordero5();
//        for(int i  = 100; i <= 3200; i = i*2){
//            generateFile(i + ".txt", i);
//            object.rBubbleSort(readArrayFromFile(i + ".txt", i));
//            object.rSelectionSort(readArrayFromFile(i + ".txt", i));
//            object.rInsertionSort(readArrayFromFile(i + ".txt", i));
//            int[] array = readArrayFromFile(i + ".txt", i);
//            object.iQuickSort(array, 0, array.length - 1);
//        }
    }
}
