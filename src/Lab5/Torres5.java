package Lab5;

import Testers.LabInterfaces.Lab5Interface;
import Testers.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Andrea on 7/20/2017.
 */
/**
 * Created by Andrea on 7/13/2017.
 */

 public class Torres5 implements Lab5Interface {
        public static  int qickCounter=0;

        /**
         * This method implements bubble sort recusivley. becuase it is assumed that bubble sort will find the largest
         * "bubble" or the largest int in the array the recusive part of this method is sucssesful because the int n parameter
         * is shifted down until n==1 meaning either the array is of length one or everything before the first element has
         * been sorted.
         *
         * @param a this is the array that we choose to modify
         * @param n this is the pointer which starts at a.length and is a viable part in the recustion aspect.
         * @return this is a counter to see how many times two elements from the array are compared.
         */
        private static int bubbleSort(int[] a, int n) {//n should originally be n.length//done
            Util.print1Dint(a);
            if (n == 1) {
                return 0;
            } else {
                int counter = 0;
                int temp;
                for (int i = 0; i < n - 1; i++) {
                    counter++;
                    if (a[i + 1] < a[i]) {//counter should incremenet not in here but close to here.
                        temp = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = temp;
                    }
                }
                return counter += bubbleSort(a, n - 1);//recusive call is done at end becuse we need to push largest to the end.
            }

        }

        /**
         * This method calls on the bubble sort method and is used for grading puposes but can also be used to just send the array with out messing up on the
         * on the n portion of the method that is n should equal the the length of the array. It helps reduce the chanses for an error.
         *
         * @param A this is the array we wish to reararange from smallest to largest using bubble method.
         */
        public void rBubbleSort(int[] A) {
            bubbleSort(A, A.length);
        }

        /**
         * This method can be called on its own or is also called from rSelectionSort. The purpose of this method is to
         * sort an array a using selectionSort but recusivly. Selection sort is the siser method to bubble sort but it finds
         * the smallest element first. that is why n should start at 0 and the base case is when n is the same as the length
         * of the array. The recusibility depends on n starting at zero and ending at the length of the array. the base case
         * will return 0 because there is nothing to compare a[0] to assuming either everything else is sorted or a is of length 1.
         *
         * @param a
         * @param n
         * @return
         */
        private static int selectionSort(int[] a, int n) {// orignally n should be 0//done
            Util.print1Dint(a);
            if (n == a.length) {
                return 0;
            } else {
                int switchSpot = n;
                int indexOfsmaller = switchSpot;
                int temp;
                int counter = 0;
                for (int i = n + 1; i < a.length; i++) {
                    counter++;
                    if (a[i] < a[indexOfsmaller]) {
                        indexOfsmaller = i;
                    }
                }
                temp = a[indexOfsmaller];
                a[indexOfsmaller] = a[n];
                a[n] = temp;

                return counter += selectionSort(a, n + 1);
            }
        }

        /**
     * This method calls on selecton sort method an it is used for grading purposes but can also be  used to just send the array with out messing up on the
     * on the n portion of the method that is n should equal zero. It helps reduce the chanses for an error.
     * @param A this is the array that is modified by passing it through the selection Sort.
     */
        public void rSelectionSort(int[] A) {
            selectionSort(A, 0);

        }

        /**
     * This is the insertion recussive sort method. It will sort an array recursively from smallest to largest. The
     * parameters that are passed are the array A and an integer n. N is the current element we want to place in its spot.
     * N also assists  in the making of the recusion in that as one element is sorted it moves on to the next element to
     * find where it goes.
     * @param a the array  we wish to sort from smallest to larges
     * @param n is the current element we would like to sort. Should be 1 when first starting off because 0 will have nothing to compare.
     * @return this is the amount of comparisons  between two elements that were made .
     */
        private static int insertionSort(int[] a, int n) {//done
            Util.print1Dint(a);
            if ((n >= a.length)) {
                return 0;
            } else {
                int currentElement = a[n];
                int i;
                int counter = 0;
                for (i = n - 1; ((i >= 0) && (a[i] > currentElement)); i--) {
                    a[i + 1] = a[i];

                }
                counter = counter + n - 1;
                a[i + 1] = currentElement;

                return counter += insertionSort(a, n + 1);
            }
        }

        /**
     * This method calls on Insertion sort method an it is used for grading purposes but can also be  used to just send the array with out messing up on the
     * on the n portion of the method that is n should equal 1. It helps reduce the chanses for an error.
     * @param A this is the array that is modified by passing it through the insertionSort.
     */
        public void rInsertionSort(int[] A) {
            insertionSort(A, 1);
        }

        /**
     * This is the partion method that is used for quick Sort.
     * It takes in an array that we want to modify and a refrence to a lower element and a refrence to a higher element.
     * @param arr the array we would like to modify.
     * @param low refrence to the lower element.
     * @param high refrence to an upper element.
     * @return what will later be another pivot.
     */
        static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<=high-1; j++){
            if (arr[j] <= pivot){
            i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

         /**
     * This is the quick sort alogorithim. It does not work very well and was inspired by the code found in Geeks for
     * Geeks. This method will run the worst time senario because the pivot is originally the right most element and if
     * the array is sorted it will be bad. This method does not work because it will only run smaller arrays because it
     * calls other methods too deeply.
     * @param arr the array we wish to modify
     * @param low lower bound array orignially 0.
     * @param high last element of the array.
     * @return the amount of comparisons done between two elements in the array.
     */
        static int quickSort(int arr[], int low, int high){
        if (low < high)
        {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
        return-1;
    }

        /**
     * This is used to grade or to make sure that the right parameters are passed to the quick sort array.
     * It calls the quickSort method to manipulate the array.
     * @param A the array we wish to manipulate.
     */
        public void iQuickSort(int[] A) {
            quickSort(A,0,A.length-1);
        }

        /**
         * This method is used in the method mergeSort to check if either middleIndex or rightEnd go beyond the boundary.
         * it checks by passing what should be either the next middleINdex or the next rightEnd and the length of the array-1.
         * if it goes over then the method will return the index for the last
         *
         * @param x this is what should be the desired index
         * @param y this is the length of the original array-1.
         * @return returns the smallest of the two so that when mergeHelper method is called there is no negative Array size Exception.
         */
        static int min(int x, int y) {
            if (x <= y) {
                return x;
            } else
                return y;
        }

        /**
     * This method is the helper method for merge Sort and also comes from the Geeks for Geeks website.
     * This method takes in the array, the left bound for the sub array the center and the right bound part of the sub
     * array. This method sorts the sub array. This method uses leftRefIndex and centerIndex as one sub subArray and
     * centerIndex +1 and right RefIndex to create another sub subArray. This method also returns the amount of
     * comparisosns made between two elements in the array.
     * @param a array to modify
     * @param leftRefIndex left bound should be 0 at some point but moves
     * @param centerIndex center of the index
     * @param rightRefIndex right most of the subArray.
     * @return amount of comparisions.
     */
        private static int mergeHelper(int[] a, int leftRefIndex, int centerIndex, int rightRefIndex) {
        int i, j, k;
        int counter = 0;
        int lengthOfleftHalf = centerIndex - leftRefIndex + 1;
        int lengthofRightHalf = rightRefIndex - centerIndex;
        int[] left = new int[lengthOfleftHalf];
        int[] right = new int[lengthofRightHalf];

        for (i = 0; i < lengthOfleftHalf; i++) {
            left[i] = a[leftRefIndex + i];
        }
        for (j = 0; j < lengthofRightHalf; j++) {
            right[j] = a[centerIndex + 1 + j];
        }
        i = 0;
        j = 0;
        k = leftRefIndex;
        while (i < lengthOfleftHalf && j < lengthofRightHalf) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            counter++;
            k++;
        }
        while (i < lengthOfleftHalf) {
            a[k] = left[i];
            i++;
            k++;
        }
        while (j < lengthofRightHalf) {
            a[k] = right[j];
            j++;
            k++;
        }
        return counter;
    }

        /**
         * This method was inspired by the code found on the Geeks for Geeks website.
         * This method is the mergeSort method and its purpose is to take the given array and return a sorted array. This
         * method will take the given array and "cut" the array into sub Arrays that will be sent to the mergeHelper method.
         *
         * @param array this is an unsorted array
         * @return this is an integr value that dictaes how many comparisons were made.
         */
        private static int mergeSort(int[] array) {
            int lengthOfArray = array.length;
            int counter = 0;

            int subArraySize;
            int leftStart;

            for (subArraySize = 1; subArraySize <= lengthOfArray - 1; subArraySize = 2 * subArraySize) {

                for (leftStart = 0; leftStart < lengthOfArray - 1; leftStart += 2 * subArraySize) {
                    //int middleIndex = leftStart + subArraySize - 1;
                    int middleIndex = min(leftStart + subArraySize - 1, lengthOfArray - 1);
                    int rightEnd = min(leftStart + 2 * subArraySize - 1, lengthOfArray - 1);

                    counter = counter + mergeHelper(array, leftStart, middleIndex, rightEnd);
                }
            }
            return counter;
        }

        /**
     * This is used to grade calls on mergeSort which calls on mergeHelper which calls on min so that the program
     * doesnt point to an index that is not there.
     * @param A the array we wish to modify.
     */
        public void iMergeSort(int[] A) {
            mergeSort(A);
        }

        /**
     * This creates test files by passing the name for the file excluding the .txt and the amount of elements. It will
     * generate random numbers from 0-1000 for as many of numTest.
     * @param fileName name of the desired file
     * @param numTest number of elements desired in the text file.
     */
        public static void createTestFile(String fileName, int numTest){
            BufferedWriter bw;
            FileWriter fw;
            try{
                fw=new FileWriter(fileName+".txt");
                bw = new BufferedWriter(fw);
                Random random= new Random();
                int num;
                for(int i=0;i<numTest;i++){
                    num=random.nextInt(1000);
                    bw.write(num+" ");
                }
                bw.close();
                fw.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
     * gets the numers from the file and returns an array on thoes number.
     * @param fileName the name of the file where the numbers are located
     * @return the array with the unsorted array.
     */
        public static int[] getArrayFromFile(String fileName) {
            try {
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
                String text = br.readLine();
                String[] stringArrayOfInts = text.split(" ");
                int[] arrrayOfInts = new int[stringArrayOfInts.length];
                for (int i = 0; i < stringArrayOfInts.length; i++) {
                    arrrayOfInts[i] = Integer.valueOf(stringArrayOfInts[i]);

                }
                return arrrayOfInts;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
     * This prints the array that is given. It is used to check
     * @param a the array to see.
     */
        public static void printArray(int[] a) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        /**
     * This  tests all the methods and prints the counter. Also creates a file and filles with random numbers and gets
     * that array to compare to all the other sorting methods.
     * @param fileName name of the file to be created
     * @param lengthOfArray length of the array to pass to other methods.
     */
        public static void testAllmethods(String fileName, int lengthOfArray) {
            createTestFile(fileName, lengthOfArray);
            int bubCount, slecCount, insertCount, quickCount, mergeCount;
            int[] orignal, bubbleTest, selectionTest, insertionTest, quickTest, mergeTest;
            orignal = getArrayFromFile(fileName + ".txt");

            bubbleTest = orignal.clone();
            selectionTest = orignal.clone();
            insertionTest = orignal.clone();
            quickTest = orignal.clone();
            mergeTest = orignal.clone();

            System.out.print("Original Array: ");
            printArray(orignal);

           System.out.print("Bubble Sort:    ");
            bubCount = bubbleSort(bubbleTest, bubbleTest.length);
            printArray(bubbleTest);

            System.out.print("Selection Sort: ");
            slecCount = selectionSort(selectionTest, 0);
            printArray(selectionTest);

            System.out.print("insertion Sort: ");
            insertCount = insertionSort(insertionTest, 1);
            printArray(insertionTest);

            //System.out.print("Quick Sort:     ");
            quickCount = 0;//quickSort(quickTest,0, quickTest.length);
            //printArray(quickTest);

            System.out.print("Merge Sort:     ");
            mergeCount = mergeSort(mergeTest);
            printArray(mergeTest);

            System.out.println("Counters: Bubble, Selection, insert, Quick, Merge");
            System.out.println("          " + bubCount + "      " + slecCount + "          " + insertCount + "     " + qickCounter + "     " + mergeCount);


        }

        public static void main(String args[]) {
            Torres5 k = new Torres5();
            int[] unsortedArray = {9, 0, 8, 1, 7, 2, 6, 3, 5, 4};

            System.out.print(Util.titleString("BubbleSort",'-'));
            k.rBubbleSort(unsortedArray.clone());

            System.out.print(Util.titleString("InsertionSort",'-'));
            k.rInsertionSort(unsortedArray.clone());

            System.out.print(Util.titleString("SelectionSort",'-'));
            k.rSelectionSort(unsortedArray.clone());

            System.out.print(Util.titleString("QuickSort",'-'));
            k.iQuickSort(unsortedArray.clone());
//            testAllmethods("testingC", 5);
//            testAllmethods("testingA",10);
//            testAllmethods("testingB",50);
//            testAllmethods("testing1",100);
//            testAllmethods("testing2",200);
//            testAllmethods("testing3",400);
//            testAllmethods("testing5",800);
//            testAllmethods("testing6",1600);
//            testAllmethods("testing7",3200);
            //testAllmethods("testing8",6400);//#to big a number :(
        }
}
