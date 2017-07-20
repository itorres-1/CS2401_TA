package Lab1;

/**
 * @author Monique Deitrick
 * Lab1
 * Instructor: J.Urenda
 * T.A.: I. Torres
 * Last Modified : 06/21/2011
 *
 * This program reads files and sets the data as arrays which can be
 * evaluated for permutation, can be composed with one another, and can be
 * inverted.
 *
 * The program was also intended to give the array raised to a power of k
 * however this was not accomplished at the last modification of the file.
 */
import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Deitrick {

    //isPerm incorrect. doesn't check last one!
    //inverse symmetrically flips not inverts
    //JavaDocs! No method except for main rendered

    public static void main(String[] args) throws IOException {


        System.out.println("What is file a : ");
        int [] a = readfromFile();
        System.out.println("Permutation: " + isPermutation(a) + "." );
        System.out.println(" ");

        System.out.println("What is file b : ");
        int [] b = readfromFile();
        System.out.println("Permutation: " + isPermutation(b) + "." );
        System.out.println(" ");

        System.out.println("The composition of a;b is: " + Arrays.toString(compose(a, b)) + ".");
        System.out.println(" ");

        System.out.println("The inverse of file a is: " + Arrays.toString(inverse(a)) + "."); //Why is this not correct?
        System.out.println("The inverse of file b is: " + Arrays.toString(inverse(b)) + ".");
        System.out.println(" ");

        int k =  readInt();
        System.out.println("The array raised to the power of " + k + " is : " + (Arrays.toString(pow(a, k))) + ".");


    }

    /**
     * readInt()
     *
     * Method that reads in an integer.
     *
     * @return
     */
    public static int readInt() {

        System.out.println("raise an array to what power : ");

        Scanner key = new Scanner(System.in);
        int k = 0;
        if(key.hasNextInt()) {
            k = key.nextInt();
        }
        else {
            System.out.println("Not a valid integer.");
        }
        return k;
    }

    /**
     * pow()
     *
     * Method which raises each element in the given array
     * to the kth power.
     *
     * Method does not run correctly as of time of submission.
     *
     *
     * @param intNumbers
     * @param k
     */
    public static int[] pow(int[] intNumbers, int k) {

        int temp = 0;
        int [] power = new int[intNumbers.length];
        for (int i = 0; i < intNumbers.length ; i++) {

        // ran out of time could not complete this method.

        }
        return power;
    }

    /**
     * inverse()
     *
     * Method which produces the inverse of the given array.
     * i is set to max or the last element in intNumbers, and is
     * decremented as min in inverse[] is incremented, thereby changing
     * the first and last values of both arrays in the for loop.
     *
     * @param intNumbers
     * @return
     */
    public static int[] inverse(int [] intNumbers) {

        int [] inverse = new int[intNumbers.length];
        int max = intNumbers.length - 1;
        int min = 0;

        for (int i = max; i >= 0 ; i--, min++) {
            inverse[min] = intNumbers[i];

        }
        return inverse;
    }

    /**
     * compose()
     *
     * Method takes in two integer arrays a, and b after
     * both have been checked for permutation. temp holds
     * the original index of b. ab's index becomes a[temp].
     * ab is returned.
     *
     *
     * @param a
     * @param b
     */
    public static int[] compose(int [] a, int [] b) { //Composition: (f ; g), z = f(y), y = g(x). First compute y=g(x)

        int temp = 0;
        int [] ab = new int[a.length];
        for (int i = 0; i < a.length ; i++) {

            temp = b[i];
            ab[i]= a[temp];

        }
        return ab;

    }

    /**
     * isPermutation()
     *
     * Method takes in an array of integers, returns
     * a boolean result if the array is a permutation.
     *
     * In order to determine if the given array is a
     * permutation, first the array is ordered via
     * Arrays.sort(), then checked against the index.
     *
     * @param intNumbers
     *
     */

    public static boolean isPermutation(int[] intNumbers) {
        boolean isPerm = false;

        int [] newArr = new int[intNumbers.length];
        for (int i = 0; i < intNumbers.length ; i++) {
            newArr[i] = intNumbers[i];
        }
        Arrays.sort(newArr);
        for (int i = 0; i < newArr.length - 1 ; i++) {
            if(newArr[i] == i){
                isPerm = true;
            }
            else{
                isPerm = false;
            }
        }
        return isPerm;
    }

    /**
     * readfromFile()
     *
     * Method requesting keyed entry of a file name
     * Returns int[] intNumbers.
     *
     * This method will keep requesting input from the user until
     * they provide a file that is usable. A while loop will keep
     * checking for correct data input in the file until k, the
     * first integer in the file, is equal to the length of the array.
     *
     */
    public static int[] readfromFile() throws IOException {  //will return int[]

        Scanner key = new Scanner(System.in);
        FileReader fr;
        BufferedReader br;
        int [] intNumbers = new int[0];

        Boolean goodFile = false;
        while (!goodFile) {
            System.out.println("File name: ");
            try {
                fr = new FileReader(key.nextLine());
                br = new BufferedReader(fr);

                int k = Integer.parseInt(br.readLine());
                String[] intStrings = br.readLine().split(" ");
                intNumbers = new int[k];

                for (int i = 0; i < intNumbers.length; i++) {
                    intNumbers[i] = Integer.parseInt(intStrings[i]);
                }

                if (k == intStrings.length) {
                    goodFile = !goodFile;
                } else {
                    System.out.println("Data is bad, use another file.");
                }
            }catch (FileNotFoundException e) {
                System.out.println("File not found, try again.");
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array out of bounds, try again.");
            }
        }return intNumbers;
    }
}
