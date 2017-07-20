package Lab2;

/*****************************************
 * Aaron Monty
 * CS2401: Summer 2017
 * Date: June 22
 * Lab 2: due June 26
 *****************************************/
import java.io.*;
import java.util.Scanner;
import java.util.*;

//TODO javadoc comments. No need to allocate memory for dimensions of array

public class Monty2 {
    /**
     * An unsuccessful attempt at reading a 2d array from file
     * @return reaturn an integer 2d array
     * @throws FileNotFoundException the file is not at the destination user defined
     * @throws IOException general exception
     */
    public static int[][] filetoArray() throws FileNotFoundException, IOException  {
        Scanner scnr = new Scanner(System.in);

        //initialize an array to hold the file's data
        int [][] intArray= null;
        int rowCount = 0;
        FileReader fr;
        BufferedReader intRead;
        boolean successfulfileRead = false;

        while (!successfulfileRead) {
            try {
                System.out.println("File Path: ");
                fr = new FileReader(scnr.nextLine());

                intRead = new BufferedReader(fr);
                //the file has not been read so, the boolean must be false

                //String [] sArray = intRead.readLine().split(" ");
                //to get the amount of columns form an array and get length
                while(intRead.readLine() !=null) {
                    rowCount++;
                    //add one to rowCount to get row count
                }
                int realRow = rowCount +1;
                intRead.close();

                intArray = new int[4][4];
                Scanner in = new Scanner(fr);

                int rowCounter = 0;
                while (in.hasNext()) {
                    String[] curLine = in.nextLine().split(" ");
                    for (int i = 0; i < curLine.length; i++) {
                        intArray[rowCounter][i] = Integer.parseInt(curLine[i]);
                    }
                    rowCounter++;
                }

                successfulfileRead = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        return intArray;
    }
    /**
     * to define if the integer is correctly input
     * @return returns the integer the user defined
     * @throws NumberFormatException
     */
    public static int takeInteger ()throws NumberFormatException{
        int scanned =0;
        boolean numRight = false;
        while(!numRight){
            try{
                Scanner numScan = new Scanner(System.in);
                scanned = Integer.parseInt(numScan.nextLine());
                if (scanned >= 0) {
                    numRight = true;
                }
                else if(scanned <=0){
                    System.out.println("Input must be a positive integer.");
                }
            }catch(NumberFormatException e) {
                System.out.println("Input must be an integer.");
            }
        }
        return scanned;
    }

    /**
     * Prints a 2d array of integers
     * @param A 2d array of integers
     */
    public static void printArray(int[][] A){
        for (int i =0; i< A.length; i++) {
            for ( int j = 0; j< A[0].length; j++) { //iterate through the entire array
                System.out.print(A[i][j]+ " "); //print the pointer position
            }
            System.out.println();
        }
    }

    /**
     * Adds the two 2d arrays input and outputs the sum
     * @param A a 2d array of integers
     * @param B a 2d array of integers
     * @return returns a 2d array sum of A and B
     */
    public static int[][] sum (int[][] A, int [][] B)throws InputMismatchException{
        int[][] S =new int[A.length][A[0].length];
        try{
            for(int i= 0; i<A.length;i++){
                for(int j=0; j<A[0].length;j++){
                    S[i][j] = A[i][j] + B[i][j];
                    //add each of the index to the index of S
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Your input is incorrect");
        }
        return S;
    }

    /**
     * Takes the difference between two 2d arrays
     * @param A a 2d array of integers
     * @param B a 2d array of integers
     * @return the difference between A and B
     */
    public static int[][] difference (int[][]A, int[][]B)throws InputMismatchException{
        int[][] D = new int[A.length][A[0].length];
        try{
            for(int i=0;i<A.length;i++){
                for(int j=0; j<A[0].length;j++){
                    D[i][j] = A[i][j] - B[i][j];
                    //subtract each of the indexes and output them on D
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Your input is incorrect");
        }
        return D;
    }

    /**
     *
     * @param A 2d array of integers
     * @param b an integer defined by user
     * @return the product of multiplying b to the 2d array of A
     */
    public static int[][] intMultiplication (int[][] A, int b)throws InputMismatchException{
        int[][] scalProd =new int[A.length][A[0].length];
        try{
            for(int i= 0; i<A.length;i++){
                for(int j=0; j<A[0].length;j++){
                    scalProd[i][j] = A[i][j] * b;
                    //multiply the index by the input integer
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Your input is incorrect");
        }
        return scalProd;
    }

    /**
     *
     * @param A 2d array of integers
     * @param B 2d array of integers
     * @return a 2d array of integers that is the product two 2d arrays
     */
    public static int[][] matrixProduct(int[][] A,int[][] B)throws InputMismatchException{
        //make sure that the matrix can be multiplied
        boolean goMult=false;
        int rowA = A.length;
        int rowB = B.length;
        int colA = A[0].length;
        int colB = B[0].length;
        //for readabilty purposes the rows and col are labled
        int[][] multProd =null;
        while(!goMult){
            try{
                if(rowA==colB){
                    //this gives the go to multiply matrix A and B
                    multProd =new int[A.length][A[0].length];
                    for(int i= 0; i<A.length;i++){
                        for(int j=0; j<A[0].length;j++){
                            multProd[i][j] = A[i][j] * B[i][j];
                        }
                    }
                    goMult=true;
                    //multiplication in matrixes is only possible if the rowA == colB
                }
                else if(rowA!=colB){
                    System.out.println("The Matrix cannot be multiplied.");
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Your input is incorrect");
            }
        }
        return multProd;
    }

    /**
     *
     * @param A 2d array of integers
     * @return the result of transposing integer array
     * @InputMismatchException if the input array is not correct
     */
    public static int[][] transpose(int[][] A)throws InputMismatchException{
        int row = A.length;
        int col = A[0].length;
        int[][] transMatrix = new int[col][row];
        //initialize the transposed matrix by switching the col and row
        try{
            for(int i = 0; i< col; i++){
                for(int j = 0; j < row; j++) {
                    transMatrix[i][j] = A[j][i];
                    //now the transposed matrix has As columns as rows and rows as columns
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Your input is incorrect");
        }
        return transMatrix;
    }

    /**
     *
     * @param A 2d integer array
     * @return true or false if the input 2d array is symmetric
     * @throws InputMismatchException
     */
    public static Boolean isSymmetric(int[][] A)throws InputMismatchException{
        boolean isSymmetric = true;

        int row = A.length;
        int col = A[0].length;

        int[][] symArray=transpose(A);
        //use transpose A to compare to A
        while(!isSymmetric) {
            try {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if ( A[i][j] == symArray[j][i]){
                            isSymmetric=true;
                            //if its columns and rows line up it is symmetric
                            break;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is incorrect");
            }
        }
        if(isSymmetric){
            System.out.println("Your matrix is symmetric");
        }
        else if(!isSymmetric){
            System.out.println("Your matrix is not symmetric");
        }
        return null;
    }

    public static int[][] pow(int[][] A, int k){
        //only able to take powers of square matrices
        int row = A.length;
        int col = A[0].length;
        boolean powYes=false;
        //if the power is 1 the array doesn't change
        int [][] squaredA = matrixProduct(A,A);
        int [][] bigA= null;
        while(!powYes) {
            try {
                if (k == 1) {
                    powYes = true;
                }
                else if (k == 2) {
                    powYes = true;
                    return squaredA;
                }
                else if (k > 2) {
                    for (int j = 2; j < k; j++) {
                        //the powers will start at 2 in this iteration
                        bigA = matrixProduct(A, squaredA);
                    }
                    powYes = true;
                    return bigA;
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is incorrect");
            }
        }
        if (k == 1) {
            return A;
        }
        else if (k == 2) {
            return squaredA;
        }
        else if (k > 2) {
            return bigA;
        }
        System.out.println("A recomputation is necessary");
        return pow(A,takeInteger());

    }

    /**
     *
     * @param args args is a string array that contains the command-line arguments
     * @throws FileNotFoundException the file input was not fount in the directory
     * @throws IOException a general exception for all exceptions
     */
    public static void main(String args[]) throws FileNotFoundException, IOException{
        //example arrays
        int sdNum[][]={{5,6},{6,7}};
        int sdNumtwo[][]={{9,9},{7,7}};

        System.out.println("\n" + "//Compute Sum////////////////////////" + "\n");
        printArray(sum(sdNum,sdNumtwo));

        System.out.println("\n" + "//Compute difference/////////////////" + "\n");
        printArray(difference(sdNum,sdNumtwo));

        System.out.println("\n" + "Enter an integer for scalar multiplication: ");
        printArray(intMultiplication(sdNum,takeInteger()));

        System.out.println("\n" + "//Compute product////////////////////" + "\n");
        printArray(matrixProduct(sdNum,sdNumtwo));

        //example matrix
        int tMatrix[][]={{3,2,4},{2,4,2},{3,4,5}};

        System.out.println("\n" + "//Compute a transposed matrix////////" + "\n");
        printArray(transpose(tMatrix));

        System.out.println("\n" + "//Compute if your matrix is symmetric//" + "\n");
        isSymmetric(tMatrix);

        System.out.println("\n" + "//Compute a matrix to a power://" + "\n");
        printArray(pow(tMatrix,takeInteger()));





    }

}