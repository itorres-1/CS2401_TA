/**
 * Author: Ricardo Alvarez
 * Assignment: Lab 1
 * Instructor: Julio Urenda
 * T.A.: Isaac Torres
 * Date of Last Modification: June 20, 2017
 * Purpose: Checks if files contain permutations and manipulates them processing new compositions and inversions
 */
import java.io.*;
import java.util.Scanner;

public class Alvarez {
    /**
     * Reads a file and checks if the length of the array will match the first given integer
     * @return an integer Array gathered from the second line of the file
     */
    public static int[] fileReader () {
        Scanner scnr = new Scanner (System.in);
        FileReader fr;
        BufferedReader br;
        Boolean repeat = true;
        String aux;
        while (repeat) {
            System.out.println("Please input the file path: ");
            try {
                aux = scnr.nextLine();
                fr = new FileReader(aux);
                br = new BufferedReader(fr);
                aux = br.readLine();
                int length = Integer.parseInt(aux);
                aux = br.readLine();
                String[] seqAux = aux.split(" ");
                int[] outArr = new int[seqAux.length];
                for (int i = 0; i <seqAux.length; i++) {
                    outArr[i] = Integer.parseInt(seqAux[i]);
                }
                if (length == outArr.length) {
                    return outArr;
                }
                else repeat = true;
            }
            catch (FileNotFoundException e1) {
                System.out.println("File path incorrect");
            }
            catch (IOException io1) {
                System.out.println("IO error, please try again.");
            }
        }
        int[]A = {0,0};
        return A;
    }
    /**
     * Checks if the integer array is a permutation
     * @param A integer array to be reviewed
     * @return a 'true' boolean if it's a permutation, 'false' if it isn't
     */
    public static boolean isPermutation (int[] A) {
        for (int i = 0; i<A.length; i++) {
            for (int j=0; j<i; j++) {
                if (A[i] == A[j]) return false;
            }
            for (int k=i+1; k<A.length; k++) {
                if (A[i] == A[k]) return false;
            }
            if (A[i] >= A.length) return false;
        }
        return true;
    }

    /**
     * Create a composition out of two arrays (A o B)
     * @param A integer Array 1
     * @param B integer Array 2
     * @return returns an integer array with the composition of the two input arrays
     */
    public static int[] compRet (int[] A, int[] B){
        boolean aPerm = isPermutation(A);
        boolean bPerm = isPermutation(B);
        boolean sameLength = true;
        int[] result = new int[A.length];
        if (!aPerm || !bPerm) System.out.println("The selected arrays are not permutations");
        if (A.length != B.length) {
            System.out.println("Both arrays don't have the same length");
            sameLength = false;
            return result;
        }
        if (aPerm && bPerm && sameLength) {
            for (int i = 0; i<result.length; i++) {
                result[i] = A[B[i]];
            }
        }
        return result;
    }

    /**
     * Computes the inverse permutation of a given array
     * @param A array to be processed
     * @return an array with the inverse permutation of array A
     */
    public static int[] inverse (int[] A) {
        int[] result = new int[A.length];
        int count = 0;
        boolean doneScan = false;
        boolean isP = isPermutation(A);
        if (isP) {
            for (int i=0; i< A.length; i++) {
                while (!doneScan) {
                    if (A[count] == i) doneScan = true;
                    else {
                        doneScan = false;
                        count++;
                    }
                }
                result[i] = count;
                count = 0;
                doneScan = false;
            }
            return result;
        }
        return result;
    }

    /**
     * Computes a new permutation by processing a permutation to a given power
     * @param A integer array containing the original permutation
     * @param k integer containing the power
     * @return integer array with the new permutation
     */
    public static int[] powArrange (int[] A, int k) {
        int[] result = new int[A.length];
        int holder = 0;
        boolean isP = isPermutation(A);
        if (isP) {
            for (int l = 0; l < A.length; l++) {
                result[l] = A[l];
            }
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < A.length; j++) {
                    holder = A[result[j]];
                    result[j] = holder;
                }
                for (int m = 0; m < A.length; m++) {
                    A[m] = result[m];
                }
            }
            return result;
        }
        return result;
    }

    /**
     * Prints each integer of an array separated by spaces
     * @param A integer array to be printed
     */
    public static void printArray (int[] A) {
        for (int i=0; i<A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("\n");
    }

    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean tryAgain = true;
        String userAns = "";
        while (tryAgain) {
            System.out.println("Please select an option \n" +
                    " - Check if a file contains a permutation (type A) \n" +
                    " - Create a composition out of two permutations (type B) \n" +
                    " - Compute the inverse of a permutation (type C) \n" +
                    " - Compute the product of a permutation to a given power (type D) \n" +
                    "Type the letter of your answer below:");
            userAns = scnr.nextLine();
            if (userAns.compareTo("A") == 0) {
                int[] A = fileReader();
                boolean isP = isPermutation(A);
                if (isP) System.out.println("It's a permutation! :)");
                else if (!isP) System.out.println("The selected file doesn't include a permutation :(");
            }
            else if (userAns.compareTo("B") == 0) {
                boolean repeat = true;
                while (repeat) {
                    int[] A = fileReader();
                    boolean isPA = isPermutation(A);
                    int[] B = fileReader();
                    boolean isPB = isPermutation(B);
                    if (isPA && isPB && (A.length == B.length)) {
                        int[] result = compRet(A, B);
                        printArray(result);
                        repeat = false;
                    } else
                        System.out.println("Your files aren't permutations or they don't match in size, please try again");
                }
            }
            else if (userAns.compareTo("C") == 0) {
                int[] A = fileReader();
                int[] result = inverse(A);
                printArray(result);
            }
            else if (userAns.compareTo("D") == 0) {
                int[] A = fileReader();
                System.out.println("Please input the power value:");
                userAns = scnr.nextLine();
                int k = Integer.parseInt(userAns);
                if (k>0) {
                    int[] result = powArrange(A, k);
                    printArray(result);
                }
                else System.out.println("Invalid power selection, please try again.");
            }
            else {
                System.out.println("Invalid selection, please try again.");
            }
            System.out.println("Type Y if you want to do another operation or try again, press any other key to exit");
            userAns = scnr.nextLine();
            if(userAns.compareTo("Y")==0) tryAgain = true;
            else tryAgain = false;
        }
    }
}
