package Lab5;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

// Joshua Boatright - Lab 5
// CS2401 - Dr. Urenda - TA: Isaac Torres
// Date of last modification: 7/20/2017
public class Boatright5 {

  //TODO -20 in correctness for not following standard and only
  //TODO 6 points credit for iQuickSort as majority not thought up

  /**
   * This method sorts an array of integers by "bubbling" larger values to the top, using recursion.
   * ***NOTE*** I came up with a way to do this fully recursive without a loop, but given any large data set,
   * it would freeze the program. Not certain on a more efficient alternative given the requirements for our test files.
   * @param a The array to be sorted
   * @param n The last index of the array
   * @return The # of comparisons made in the sort
   */
  public static int bubbleSortR(int[] a, int n) {
    int comp = 0; // Tracks comparisons
    int temp; // temporary variable for swap
    if (n == 0) { // Conditional accounts for invalid input, and as base case when met
      return 1;
    }
    // Loop compares values and bubbles higher element to top (using swap)
    for(int i=0; i<n-1; i++) {
      comp++; // Counts each comparison
      if (a[i] > a[i+1]) {
        temp = a[i+1];
        a[i+1] = a[i];
        a[i] = temp;
      }
    }
    bubbleSortR(a, n - 1); // Recursive call to sort unsorted portion of array and return comparisons

    return comp;
  }

  /**
   * This method sorts an array by passing through the entire array, and placing the lowest value at the beginning. It
   * then repeats this process for the entirety of the array after the value placed until sorted.
   * @param a The array to be sorted
   * @param i The starting index of the array
   * @param n The last index of the array
   * @return The # of comparisons made in the sort
   */
  public static int selectionSortR(int[] a, int i, int n) {
    int comp = 0; // Tracks comparisons
    int min; // minimum value in array
    int minIndex; // index of the above element

    if (n > 0 && i < n) { // Conditional accounts for invalid input, and as base case when met
      min = a[i]; // Sets initial minimum to first element of array
      minIndex = i; // Tracks index of above element

      // *** This could be replaced with recursion to find the minimum index, but I could not seem to get it to work
      // *** without an entirely separate recursive method specifically for that. Given that neither is a perfect
      // *** solution for a fully recursive method, I went this route so as to be able to keep track of the
      // *** comparisons (The auxiliary recursive method would require returning an int for the index of the minimum
      // *** value, and therefore would be unable to return the comparison count)
      for (int j=i+1; j<=n; j++) { // Finds the minimum value in array
        comp++;
        if (a[j] < min) { // Checks current element in array against minimum
          min = a[j]; // Assigns new minimum
          minIndex = j; // Assigns new index
        }
      }
      // Places minimum at first location in array
      a[minIndex] = a[i];
      a[i] = min;
      // Recursive call starting again at the index after the most recent minimum
      selectionSortR(a, i + 1, n);
    }
    return comp;
  }

  /**
   * This method sorts an array by "insertion". It continuously takes the first unsorted element and removes it,
   * then shifts each sorted element to the right until the proper place for the unsorted element is found. This
   * particular method uses recursion, continuously placing the last element in the correct position.
   * @param a Array to be sorted
   * @param i The starting index of the array
   * @param n The last index of the array
   * @return The # of comparisons made in the sort
   */
  public static int insertionSortR(int[] a, int i, int n) {
    int comp = 0; // Tracks comparisons

    if (i < n) { // Conditional checks if array length is greater than 0 (base case/invalid input)
      comp += insertionSortR(a, i, n-1); // Recursive call to sort the first through second-to-last elements
      comp += insert(a, i, n-1, a[n]); // Recursive call to sort last element
    }

    return comp;
  }

  /**
   * This method is an auxiliary recursive method used by the above recursive insertion sort method. It sorts the last
   * element into its correct position.
   * @param a Array to be sorted with insertionSortR
   * @param i Starting index
   * @param n Last index
   * @param lastE Last element (element to be placed in correct position)
   * @return # of comparisons made
   */
  public static int insert(int[] a, int i, int n, int lastE) {
    int comp = 0; // Tracks comparisons
    if (lastE >= a[n]) { // Checks if last element is >= previous one
      comp++;
      a[n+1] = lastE; // Places last element to end if so
    } else if (i < n) { // Base case
      comp++;
      a[n+1] = a[n]; // Shifts current element to the right
      insert(a, i, n - 1, lastE); // Recursive call to find correct placement for last element
    } else {
      comp++;
      a[n+1] = a[n]; // Shifts element to the right
      a[n] = lastE; // Places last element in correct position
    }
    return comp;
  }

  /**
   * This method sorts an array by choosing a "pivot" element, then moving values less than the pivot below,
   * and greater than the pivot above (in this iterative version using an auxiliary stack rather than recursive arrays.
   * ****NOTE**** I attempted multiple ways of using nested loops to perform the equivalent of the standard recursive
   * calls to no avail. I referenced code on the internet to find a way to solve that issue, which was by using
   * the auxiliary stack. This code is formatted very similarly to some of the code I referenced due to its function.
   * If this loses points for not coming up with an entirely original solution, I completely understand, but I wanted to
   * clarify and state my use of the algorithm so no claims of cheating or plagiarism can be made. The code can be found
   * at <hyperlink>www.geeksforgeeks.org/iterative-quick-sort</hyperlink>. I have included detailed comments as to each
   * operation so as to show my understanding of how the method is functioning using the stack (mostly to clarify that
   * I did not just reformat code I found without learning and understanding the way it works).
   * @param a The array to be sorted
   * @param i The starting index
   * @param n The last index
   * @return # of comparisons in sort
   */
  public static int quickSortI(int[] a, int i, int n) {

    int comp = 0; // Tracks comparisons
    int stack[] = new int[n-i+1]; // Creates new auxiliary stack to handle elements before and after pivot
    int top = -1; // initializes the top of the stack to -1

    // Pushes the initial values into the stack (first index and last index
    stack[++top] = i;
    stack[++top] = n;

    while (top >= 0) { // Loop continues to pop (remove) elements until the stack is not empty
      comp++;
      n = stack[top--]; // removes last index
      i = stack[top--]; // removes first index

      // Conditional checks if first index < last index to avoid out of bounds exception
      // ***This is a correction of the algorithm referenced at the above url***
      // ***Their code, without this condition, will throw an exception by trying to access a -1 index***
      if (i < n) {
        comp++;
        int pivot = partition(a, i, n); // Uses the auxiliary method to obtain and place pivot (explained in method)

        // This conditional pushes (adds) the left side to the stack if there are elements to the left of the pivot
        if (pivot - 1 > 1) {
          stack[++top] = i;
          stack[++top] = pivot - 1;
        }

        // This conditional pushes (adds) the right side to the stack if there are elements to the right of the pivot
        if (pivot + 1 < n) {
          stack[++top] = pivot + 1;
          stack[++top] = n;
        }
      }
    }
    return comp;
  }

  /**
   * This auxiliary method is used by quickSortI to partition segments of the array and form/place the pivot.
   * @param a The array to be sorted
   * @param i The starting index
   * @param n The last index
   * @return The pivot
   */
  public static int partition(int[] a, int i, int n)  {
    int pivot = a[n]; // Initial value for pivot set to value of last element
    int index = i - 1; // Starting index
    int temp; // Temporary variable for swaps

    for (int j=i; j<n; j++) { // Loop iterates through passed array n-i times
      if (a[j] <= pivot) { // Checks if element is <= pivot
        index++; // Increments index if elements is less than pivot
        // Swaps index element with j element
        temp = a[index];
        a[index] = a[j];
        a[j] = temp;
      }
    }
    // Final swap of last element, last element with the index+1 element
    temp = a[index+1];
    a[index+1] = a[n];
    a[n] = temp;

    return index + 1; // Returns the pivot in its correct location
  }

  // ********* Utility Methods ***********

  /**
   * This utility method prints an array of integers on a single line, separated by spaces.
   * @param a The array to be printed
   */
  public static void print(int[] a, int comp) {
    // Prints array (same line, separated by spaces)
    for (int A : a) {
      System.out.print(A + " ");
    }

    // Prints # of comparisons
    System.out.println();
    System.out.println("Comparisons: " + comp);
    System.out.println();
  }

  /**
   * This utility method creates a test file of random integers.
   * @param n Number of random integers to be written to file
   * @param filename Name of file
   */
  public static void createTestFile(int n, String filename) {
    try{
      PrintWriter pw = new PrintWriter(new File(filename));
      Random rand = new Random();
      int num;

      while (n > 0) {
        num = rand.nextInt(1000); // Assigns random integer to num
        pw.print(num); // Writes num to file
        n--;
        pw.println(); // Moves to next line
      }
      pw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This utility method reads integers from a file, and assigns them to an array.
   * @param n Number of integers in file
   * @param filename Name of file
   * @return Array of integers
   */
  public static int[] readArrayFromFile(int n, String filename) {
    int[] a = new int[n]; // Array to be filled
    try {
      Scanner scan = new Scanner(new File(filename));
      int i = 0;
      while (scan.hasNextInt()) { // Loop continues til no data left
        a[i++] = scan.nextInt(); // Adds each integer to next element of array
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return a;
  }

  public static void main(String[] args) {
//    createTestFile(100, "Test100.txt");
//    createTestFile(200, "Test200.txt");
//    createTestFile(400, "Test400.txt");
//    createTestFile(800, "Test800.txt");
//    createTestFile(1600, "Test1600.txt");
//    createTestFile(3200, "Test3200.txt");
//
//    // **TEST** Bubble Sort (Recursive)
//    int[] A1 = readArrayFromFile(100, "Test100.txt");
//    int bubbleComp = bubbleSortR(A1, A1.length-1);
//    System.out.println("Bubble Sort (100):");
//    print(A1, bubbleComp);
//
//    int[] A2 = readArrayFromFile(200, "Test200.txt");
//    bubbleComp = bubbleSortR(A2, A2.length-1);
//    System.out.println("Bubble Sort (200):");
//    print(A2, bubbleComp);
//
//    int[] A3 = readArrayFromFile(400, "Test400.txt");
//    bubbleComp = bubbleSortR(A3, A3.length-1);
//    System.out.println("Bubble Sort (400):");
//    print(A3, bubbleComp);
//
//    int[] A4 = readArrayFromFile(800, "Test800.txt");
//    bubbleComp = bubbleSortR(A4, A4.length-1);
//    System.out.println("Bubble Sort (800):");
//    print(A4, bubbleComp);
//
//    int[] A5 = readArrayFromFile(1600, "Test1600.txt");
//    bubbleComp = bubbleSortR(A5, A5.length-1);
//    System.out.println("Bubble Sort (1600):");
//    print(A5, bubbleComp);
//
//    int[] A6 = readArrayFromFile(3200, "Test3200.txt");
//    bubbleComp = bubbleSortR(A6, A6.length-1);
//    System.out.println("Bubble Sort (3200):");
//    print(A6, bubbleComp);
//
//    // **TEST**  Selection Sort (Recursive)
//    int[] B1 = readArrayFromFile(100, "Test100.txt");
//    int selectionComp = selectionSortR(B1, 0, B1.length-1);
//    System.out.println("Selection Sort (100):");
//    print(B1, selectionComp);
//
//    int[] B2 = readArrayFromFile(200, "Test200.txt");
//    selectionComp = selectionSortR(B2, 0, B2.length-1);
//    System.out.println("Selection Sort (200):");
//    print(B2, selectionComp);
//
//    int[] B3 = readArrayFromFile(400, "Test400.txt");
//    selectionComp = selectionSortR(B3, 0, B3.length-1);
//    System.out.println("Selection Sort (400):");
//    print(B3, selectionComp);
//
//    int[] B4 = readArrayFromFile(800, "Test800.txt");
//    selectionComp = selectionSortR(B4, 0, B4.length-1);
//    System.out.println("Selection Sort (800):");
//    print(B4, selectionComp);
//
//    int[] B5 = readArrayFromFile(1600, "Test1600.txt");
//    selectionComp = selectionSortR(B5, 0, B5.length-1);
//    System.out.println("Selection Sort (1600):");
//    print(B5, selectionComp);
//
//    int[] B6 = readArrayFromFile(3200, "Test3200.txt");
//    selectionComp = selectionSortR(B6, 0, B6.length-1);
//    System.out.println("Selection Sort (3200):");
//    print(B6, selectionComp);
//
//    // **TEST** Insertion Sort (Recursive)
//    int[] C1 = readArrayFromFile(100, "Test100.txt");
//    int insertionComp = insertionSortR(C1, 0, C1.length-1);
//    System.out.println("Insertion Sort (100):");
//    print(C1, insertionComp);
//
//    int[] C2 = readArrayFromFile(200, "Test200.txt");
//    insertionComp = insertionSortR(C2, 0, C2.length-1);
//    System.out.println("Insertion Sort (200):");
//    print(C2, insertionComp);
//
//    int[] C3 = readArrayFromFile(400, "Test400.txt");
//    insertionComp = insertionSortR(C3, 0, C3.length-1);
//    System.out.println("Insertion Sort (400):");
//    print(C3, insertionComp);
//
//    int[] C4 = readArrayFromFile(800, "Test800.txt");
//    insertionComp = insertionSortR(C4, 0, C4.length-1);
//    System.out.println("Insertion Sort (800):");
//    print(C4, insertionComp);
//
//    int[] C5 = readArrayFromFile(1600, "Test1600.txt");
//    insertionComp = insertionSortR(C5, 0, C5.length-1);
//    System.out.println("Insertion Sort (1600):");
//    print(C5, insertionComp);
//
//    int[] C6 = readArrayFromFile(3200, "Test3200.txt");
//    insertionComp = insertionSortR(C6, 0, C6.length-1);
//    System.out.println("Insertion Sort (3200):");
//    print(C6, insertionComp);
//
//    // Quick Sort (Iterative)
//    int[] D1 = readArrayFromFile(100, "Test100.txt");
//    int quickComp = quickSortI(D1, 0, D1.length-1);
//    System.out.println("Quick Sort (100):");
//    print(D1, quickComp);
//
//    int[] D2 = readArrayFromFile(200, "Test200.txt");
//    quickComp = quickSortI(D2, 0, D2.length-1);
//    System.out.println("Quick Sort (200):");
//    print(D2, quickComp);
//
//    int[] D3 = readArrayFromFile(400, "Test400.txt");
//    quickComp = quickSortI(D3, 0, D3.length-1);
//    System.out.println("Quick Sort (400):");
//    print(D3, quickComp);
//
//    int[] D4 = readArrayFromFile(800, "Test800.txt");
//    quickComp = quickSortI(D4, 0, D4.length-1);
//    System.out.println("Quick Sort (800):");
//    print(D4, quickComp);
//
//    int[] D5 = readArrayFromFile(1600, "Test1600.txt");
//    quickComp = quickSortI(D5, 0, D5.length-1);
//    System.out.println("Quick Sort (1600):");
//    print(D5, quickComp);
//
//    int[] D6 = readArrayFromFile(3200, "Test3200.txt");
//    quickComp = quickSortI(D6, 0, D6.length-1);
//    System.out.println("Quick Sort (3200):");
//    print(D6, quickComp);
  }
}
