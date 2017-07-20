package Lab1;

/*****************************************
 * Aaron Monty 
 * CS2401: Summer 2017
 * Date: June 19
 * Lab 1: due June 21
 *****************************************/
import java.io.*;                    
import java.util.Scanner;            
import java.util.*;                  

public class Monty {
    /**
     *
     * @return filetoArray will return a integer array, dimension to be determined from file data
     * @throws FileNotFoundException the file wasn't where the user defined it was
     * @throws IOException           an input or an output operation has failed
     */
    public static int[] filetoArray() throws FileNotFoundException, IOException {

        Scanner scnr = new Scanner(System.in);
        FileReader fr;
        BufferedReader reader;
        Boolean successfulfileRead = false;
        //the file has not been read so, the boolean must be false
        int[] intArray = null;
        //initialize an array to hold the file's data
        while (!successfulfileRead) {
            try {

                System.out.println("File Path: ");

                fr = new FileReader(scnr.nextLine());
                reader = new BufferedReader(fr);
                //generating a new instance of file and bufferedReader to get data from file
                int k = Integer.parseInt(reader.readLine());
                //int k is the first row in the document, the number of elements in the array
                String[] intStrings = reader.readLine().split(" ");
                //intStrings ={ "1" "2"...}
                intArray = new int[k];

                for (int i = 0; i < intStrings.length; i++) {
                    intArray[i] = Integer.parseInt(intStrings[i]);
                }//changed the strings to int through iteration

                if (isPermutation(intArray) == true) {
                    System.out.println("The array is a permutation");
                    successfulfileRead = true;
                    //if the array is a permutation the file is successfully read
                } else {
                    successfulfileRead = false;
                    //else the file will not be read and the process starts again
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }

        }
        return intArray;
    }

    /**
     * Input an array and outputs a boolean for Permutation question
     *
     * @param a is a one dimensional array of integers
     * @return returns a boolean isPerm to note if a is a permutation or not
     */
    public static boolean isPermutation(int[] a) {
        boolean isPerm = true;
        try {
            for (int i = 1; i < a.length; i++) {
                if (a[i] == a[i - 1] || a[i] > a.length || a[i - 1] > a.length) {
                    //checking if any elements are similar, or larger than the length of the array
                    System.out.println("The array is not a permutation");
                    isPerm = false;
                    //if isPerm is false the integer array does not pass for a permutation
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Your input is incorrect");
        }
        return isPerm;
    }


    /**
     * Take two arrays as input and form the composition as an output
     *
     * @param f a 1D integer array that has been proven to be a permutation array
     * @param g a 1D integer array that has been proven to be a permutation array
     * @return an integer array that is composed of f and g
     */
    public static int[] composition(int[] f, int[] g) {
        int[] compArray = new int[f.length];
        //initialize an array to hold the composition
        for (int i = 0; i < f.length; i++) {
            compArray[i] = f[g[i]];
        }
        //for the length of f iterate through setting compArray's index to f's element of g's index
        return compArray;
        //output the compArray as a composition (f o g)
    }

    /**
     * Input an array and switch the elements with that of its index
     *
     * @param f a 1D integer array that has been proven to be a permutation array
     * @return a 1D integer array that contains the inverse of the input
     */
    public static int[] inverse(int[] f) {
        int[] inverseArray = new int[f.length];
        //intitialize an array to hold the inverse of f
        for (int i = 0; i < f.length - 1; ++i) {
            inverseArray[f[i]] = f[i];
            //for the length of f set the inverseArray's element index to the index of f's set equal to f's index
        }
        return inverseArray;
        //return inverseArray once it has been set to the inverse of f
    }

    /**
     * Input a 1D array f and use the integer g to set f composed of itself g number of times
     *
     * @param f a 1D integer array that has been proven to be a permutation array
     * @param g an integer to set the number of times f is composed of itself
     * @return return the result of f composed of itself g number of times
     */
    public static int[] pow(int[] f, int g) {
        if (g == 1) {
            return f;
        }
        //if the power is set to 1 return the array unchanged
        int[] powArray = composition(f, f);
        //the array will be set to the composition of itself, or to the power of 2
        for (int j = 2; j < g; j++) {
            //the powers will start at 2 in this iteration
            for (int i = 0; i < f.length; i++) {
                powArray[i] = f[powArray[i]];
            }
            //powArray will be set to f array's index of powArray's index
        }
        return powArray;
        //return the powArray integet array
    }

    /**
     * Intput a 1D array to output the array displayed with spaces inbetween
     *
     * @param f a 1D integer array that has been proven to be a permutation array
     * @return returns the same array as input
     */
    public static int[] printArray(int[] f) {
        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i] + " ");
        }
        //iterate through each of the indexes and print with space inbetween
        System.out.println("");
        return f;
        //output the original array
    }

    /**
     *
     * execution of multiple methods for display and user interaction
     * @param args is a string array that contains the command-line arguments
     * @throws IOException this is thrown whenever the input or output operation has failed
     */
//    public static void main(String args[]) throws NumberFormatException, FileNotFoundException, IOException {
//        //question 1//////////////////////////////////////////////////////
//        printArray(filetoArray());
//        //prints the array that has been read
//        //question 2///////////////////////////////////////////////////////
//        System.out.println("");
//        System.out.println("Compute a composition");
//        System.out.println("");
//
//        int[] f1Array = null;
//        int[] f2Array = null;
//        // initialize 2 empty arrays named differently to fill required input for composition
//        f1Array = filetoArray();
//        System.out.println("Next file:");
//        f2Array = filetoArray();
//        //fill the two arrays with thier respective filetoArray
//        printArray(composition(f1Array, f2Array));
//        //execute the composition method then print the output for display
//        //question 3///////////////////////////////////////////////////////
//        System.out.println("");
//        System.out.println("Compute the inverse");
//        System.out.println("");
//
//        printArray(inverse(filetoArray()));
//        //execute the inverse method and print the output for display
//        //question 4///////////////////////////////////////////////////////
//        System.out.println("");
//        System.out.println("Compute an array to a power");
//        System.out.println("Choose a power to set the array to");
//
//        int power = 0;
//        Scanner scnr = new Scanner(System.in);
//        boolean goodInt = false;
//        while (!goodInt) {
//            //to varify that the power is an integer entered by user
//            try {
//                power = Integer.parseInt(scnr.nextLine());
//                if (power >= 0 || power <= 0) {
//                    goodInt = true;
//                }
//                //power has been varified as an int, continue to Pow method
//            }catch(NumberFormatException e){
//                System.out.println("Input must be an integer.");
//            }
//            //if the user inputs anything but an integer these catches will loop the request
//        }
//        try{
//            printArray(Pow(filetoArray(), power));
//            //execute the method Pow to set the array from filetoArray to a power from variable power
//        }catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }catch (IOException e) {
//            System.out.println("Something went wrong");
//        }
//
//    }
}
