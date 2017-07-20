package Lab2;
/**
 * Created by Brian G on 6/25/2017.
 */
public class Garcia2 {


//TODO Don't space out methods so much
    //-2 points in correctness for not following rules on naming the methods that I made clear needed to be
    //followed exactly i.e. isSymmetric not isSymmertic
    // isSymmetric completely not working, infinite loop!
    //NO JAVADOC comments!

    // Method to add the matrix's
    public static int[][] sum(int[][] A, int[][] B){

        int x = A.length;
        int y = A[0].length;

        int[][] sum = new int[x][y];
        try {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    sum[i][j] = A[i][j] + B[i][j];
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("File is out of bounds");
			return null;
        }
        return sum;
    }
   /*
   this method simply uses the two matrix's index values to add them together going one by one and creating the added version in the sum interface
    */
    //Method to subtract the matrix's
    public static int[][] difference(int[][] A, int[][] B){
        int x = A.length;
        int y = A[0].length;

        int[][] difference = new int[x][y];
        try {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {

                    difference[i][j] = A[i][j] - B[i][j];
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("file is out of bounds");
			return null;
        }
        return difference;
    }
    /*
    the difference method uses the same features used in the sum method but this time the index values are subracted
     */
    //Method that uses tge scalar rules to multiply the matrix's
    public static int[][] intMultiplication(int[][]A, int b){
        int x = A.length;
        int y = A[0].length;

        int[][] scalar = new int[x][y];
        try {

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    scalar[i][j] = b * A[i][j];
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("File is out of bounds");
			return null;
        }
        return scalar;

    }
    /*
    This method uses a given number and multiplies all the matrix values by that given integer
     */








    //Actual matrix multiplication
    public static int[][] matrixProduct(int[][] A, int[][] B){
        int x = A.length;
        int y = A[0].length;
        int z = B[0].length;

        int[][] product = new int[x][z];
        try {

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; z < y; k++) {

                        product[i][j] = product[i][j] + A[i][k] * B[k][j];
                    }
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("File is out of bounds");
			return null;
        }
        return product;
    }
    /*
    The method multiplies the value of one of the given arrays by the secondary given array creating a new product array created by the combination of both
     */






    //Method to be used for the transpose function
    public static int[][] transpose(int[][] A) {
        int x = A.length;
        int y = A[0].length;

        int[][] transpose = new int[y][x];
        try {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    transpose[j][i] = A[i][j];
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("File out of bounds");
			return null;
        }
        return transpose;
    }
    /*
    This method in general creates a flipped or mirror reflection of the array basically switching the values one by one to create a new array
     */








    //Method that returns the symmetrical boolean value
    public static Boolean isSymmetric(int[][]A) {
        int x = A.length;
        int y = A[0].length;
        boolean symmetrical = true;

        return null;

//        try {
//
//            while (symmetrical == true) {
//                if (x != y) {
//
//                    symmetrical = false;
//                    //TODO FIXED HERE
//                    return null;
//                }
//                int[][] transpose = new int[y][x];
//                for (int i = 0; i < x; i++) {
//                    for (int j = 0; j < y; j++) {
//                        transpose[j][i] = A[i][j];
//                    }
//                }
//                for (int i = 0; i < x; i++) {
//                    for (int j = 0; j < y; j++) {
//                        if (transpose[j][i] != A[i][j]) {
//                            symmetrical = false;
//                        }
//                    }
//                }
//            }
//            if (symmetrical == true) {
//                System.out.println("Is symmetrical");
//            }
//            if (symmetrical == false) {
//                System.out.println("Is not symmetrical");
//            }

//        }catch(IndexOutOfBoundsException e){
//            System.out.println("File out of bounds");
//			return null;
//        }
//        //TODO ORIGINALLY HERE return symmetrical;
//        return symmetrical;
    }
    /*
    This method tests the symmetry of the array i did this by using the transpose method style to check if the numbers are symmetrical along the array
     */









    //Power function
    public static int[][] pow(int[][] A, int k){
        int[][]power = new int [A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int y = 0; y < A[0].length; y++) {
                    power[i][y] = A[i][y];
                }
            }
            for (int x = 1; x < k; x++) {
                for (int i = 0; i < A.length; i++) {
                    for (int y = 0; y < A[0].length; y++) {
                        power[i][y] = power[i][y] * A[i][y];
                    }
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("File out of bounds");
			return null;
        }
        return power;
    }
    /*
    This method multiplies a created array by the given array as many times as specified by the user
    SO if the user decides to square the function two times then the method will execute twice to create a power variant
     */

}
