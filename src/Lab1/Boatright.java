//*Joshua Boatright* --- CS2401 --- Lab 1 --- Dr. Urenda --- TA: Isaac Torres --- Last modified: 6/20/17

// Purpose of program: Reads array of integers from file, decides if it is a permutation, computes composition of
// two permutations, computes inverse of a permutation, and computes a permutation composed to itself k # of times

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Boatright {

  //TODO explain design, why isPerm iterations starts at 1
  //TODO Inverse incorrect

  /**
   * This method reads numbers from a file, and assigns them to an array of integers.
   * The first item read is the amount of individual data elements in the rest of the file.
   * @param filename name of the file to be read
   * @return the array to be used as possible permutation
   */
  public static int[] readFromFile(String filename) throws FileNotFoundException {
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);

    // Reads # of elements from first line of file (Error reported if IOException occurs)
    int numElem = 0;
    try {
      numElem = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Create new array for permutation
    int[] A = new int[numElem];

    // Reads sequence from next line of file into String line (Error reported if IOException occurs)
    String line = null;
    try {
      line = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String[] newLine = line.split("\\s"); // Splits string into array of Strings at whitespace

    // Assigns integer values from  newLine to A
    for (int i=0; i<numElem; i++) {
      A[i] = Integer.parseInt(newLine[i]);
    }

    try {
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Returns possible permutation as integer array
    return A;
  }

  /**
   * This method checks if a given array is a permutation.
   *
   * @param A array of type <code>int</code> to be checked
   * @return true if array is a permutation, otherwise false
   */
  public static boolean isPermutation(int[] A) {
    int[] copyA = duplicateArray(A);
    Arrays.sort(copyA); // Sorts array in ascending order

    // Checks if values in A are sequential
    for (int i=1; i<copyA.length; i++) {
      if (copyA[i] != copyA[i-1] + 1) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method create a separate copy of an array of type <code>int</code>.
   * Method is used in order to modify duplicates rather than originals when manipulating arrays.
   * @param A array to be duplicated
   * @return copy of original array
   */
  public static int[] duplicateArray(int[] A) {
    int[] copy = new int[A.length];
    for (int i=0; i<A.length; i++) {
      copy[i] = A[i];
    }
    return copy;
  }

  /**
   * This method checks if both arrays have the same domain in order to get composite permutation.
   * In order to get the composite of a permutation, with another permutation, the arrays must have the same values,
   * regardless of order.
   * @param A first permutation to be checked
   * @param B second permutation to be checked
   * @return true if domains are equal, otherwise false
   */
  public static boolean domainCheckForComp(int[] A, int[] B) {
    int[] copyA = duplicateArray(A);
    int[] copyB = duplicateArray(B);

    // Sort arrays in ascending order
    Arrays.sort(copyA);
    Arrays.sort(copyB);

    // Returns true if domain of A and B are the same
    if (Arrays.equals(copyA, copyB)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method computes the composition of a permutation, with another permutation.
   * @param A first permutation (outer function)
   * @param B second permutation (inner function)
   * @return composite permutation as array of type <code>int</code>
   */
  public static int[] compPerm(int[] B, int[] A) {
    int[] comp = new int[A.length];
    for (int i=0; i<A.length; i++) {
      comp[i] = A[B[i]];
    }
    return comp;
  }

  /**
   * This method computes the inverse of a permutation.
   * @param A permutation to be used
   * @return inverse permutation as array of type <code>int</code>
   */
  public static int[] invPerm(int[] A) {
    int[] inverse = new int[A.length];
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      inverse[A[i]] = i;
    }
    return inverse;
  }

  /**
   * This method computes a permutation exponentially.
   * The permutation is composed to itself <i>k</i> times.
   * @param A permutation to be used
   * @param k value of exponent
   * @return exponential permutation as array of type <code>int</code>
   */
  public static int[] expPerm(int[] A, int k) {
    // Three duplicate arrays initialized
    int[] exp = duplicateArray(A); // The edited permutation we will return
    int[] exp2 = duplicateArray(A); // Boatright that will change depending on exponent
    int[] initialA = duplicateArray(A); // Constant original permutation to be used w/ above permutation

    for (int i=1; i<k; i++) { // Outer loop continues given value of exponent k
      for (int j=0; j<A.length; j++) { // Inner loop computes composition with itself
        exp[j] = exp2[initialA[j]];
      }
      exp2 = duplicateArray(exp);
    }

    return exp;
  }

  /**
   * (Extra Credit) This method creates a random permutation.
   * It uses a given permutation, and randomly shuffles it to create a new one.
   * @param A permutation used as basis to be shuffled
   * @return random permutation as array of type <code>int</code>
   */
  public static int[] randomPerm(int[] A) {
    int[] newPerm = duplicateArray(A); // New duplicate array to modify
    Random shuffle = ThreadLocalRandom.current(); // object to perform randomization
    // Initialize necessary variable for shuffle and swap
    int a = 0;
    int count = 0;

    for (int i=A.length-1; i>0; i--) {
      count = shuffle.nextInt(i + 1); // shuffles within set
      a = newPerm[count]; // swap
      newPerm[count] = newPerm[i];
      newPerm[i] = a;
    }

    return newPerm;
  }

  /**
   * This method prints a permutation.
   * Format&#58; 1, 2, 3, 4
   * @param A permutation to be printed
   */
  public static void printPerm(int[] A) {
    for (int i=0; i<A.length-1; i++) {
      System.out.print(A[i] + ", ");
    }
    System.out.println(A[A.length-1]);
  }

  //UTilitiy methods

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    // Get filename from user for first permutation
    System.out.println("What is the name of the file containing the first permutation?");
    String filename = scan.nextLine();

    boolean fileFound = false; // Allows user to input different filename if error occurs, given below while loop
    int[] perm1 = null;
    // Gets first file from array if file is found, otherwise asks user for new file
    while (!fileFound) {
      try {
        perm1 = readFromFile(filename);
        fileFound = true;
      } catch (FileNotFoundException e) {
        System.out.println("The file you entered was not found. Please enter another filename:");
        filename = scan.nextLine();
      }
    }

    // Get filename from user for second permutation
    System.out.println("What is the name of the file containing the second permutation?");
    filename = scan.nextLine();

    fileFound = false;
    int[] perm2 = null;
    while (!fileFound) {
      try {
        perm2 = readFromFile(filename);
        fileFound = true;
      } catch (FileNotFoundException e) {
        System.out.println("The file you entered was not found. Please enter another filename:");
        filename = scan.nextLine();
      }
    }

    // Calls isPermutation, displays to user whether or not the selected files held permutations
    if (isPermutation(perm1)) {
      System.out.println("Your first array is a permutation: ");
      printPerm(perm1);
    } else {
      System.out.println("Your first array is not a permutation: ");
      printPerm(perm1);
    }

    if (isPermutation(perm2)) {
      System.out.println("Your second array is a permutation: ");
      printPerm(perm2);
    } else {
      System.out.println("Your second array is not a permutation: ");
      printPerm(perm2);
    }

    int[] composite = null;
    boolean hasComposite = false; // Allows composite to be selected later if composite is computed below
    if(isPermutation(perm1) && (isPermutation(perm2)) && domainCheckForComp(perm1, perm2)) {
      hasComposite = true;
      composite = compPerm(perm1, perm2); // Gets composite given two permutations
      System.out.println("The composite of your selected permutations is: ");
      printPerm(composite); // Displays to user composite permutation
    } else { // Error message to user for invalid arrays
      System.out.println("Both arrays must be permutations of the same domain to compute the composite.");
    }

    // Asks user for choice of permutations to be used for inverse/exponential/random methods
    System.out.println("Which of your permutations would you like to see the inverse of,");
    System.out.println("compute its exponential permutation, and a random permutation? (Enter # of choice only)");
    System.out.println("1. First");
    System.out.println("2. Second");
    if (hasComposite) {
      System.out.println("3. Composite"); // Displays composite as choice only if calculated earlier
    }
    int userChoice = scan.nextInt();

    // Get exponent from user
    System.out.println("Please enter an integer to be used as an exponent:");
    int k = scan.nextInt();

    int[] inverse = null;
    int[] exponent = null;
    int[] rndP = null;
    // Computes inverse, exponential, and random permutations given above user input
    // (Uses 1st perm by default if invalid choice)
    switch (userChoice) {
      case 1:
        inverse = invPerm(perm1);
        exponent = expPerm(perm1, k);
        rndP = randomPerm(perm1);
        break;
      case 2:
        inverse = invPerm(perm2);
        exponent = expPerm(perm2, k);
        rndP = randomPerm(perm2);
        break;
      case 3:
        if (hasComposite) {
          inverse = invPerm(composite);
          exponent = expPerm(composite, k);
          rndP = randomPerm(composite);
        } else {
          System.out.println("Invalid selection. Your first permutation will be used by default.");
          inverse = invPerm(perm1);
          exponent = expPerm(perm1, k);
          rndP = randomPerm(perm1);
        }
        break;
      default:
        System.out.println("Invalid selection. Your first permutation will be used by default.");
        inverse = invPerm(perm1);
        exponent = expPerm(perm1, k);
        rndP = randomPerm(perm1);
        break;
    }

    // Displays to user inverse and exponential permutations, plus *EC* random permutation
    System.out.println("The inverse of your selected permutation is: ");
    printPerm(inverse);
    System.out.println("The exponential permutation of your selection is: ");
    printPerm(exponent);
    System.out.println("A random permutation of your selection is: ");
    printPerm(rndP);
  }
}
