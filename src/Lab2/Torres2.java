package Lab2;

//import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Andrea Fernanda Torres on 6/21/2017.
 * this is created for cs 2
 * there needs to be a method for:
 * A+B(Sum)
 * A-B(Diffrence)
 * k*A(integer product)
 * A*B(matrix product)
 * AT(matrix A transpose)
 * A=AT?(Symetry)
 * A^k (A matrix to a power) K
 */
public class Torres2 {



    //TODO NAMING! TorresAnd? Matrix.java? Entire source folder? Follow directions!
    //TODO -5 points for not following directions on EXACT method signatures! BBBBBBBBoolean not boolean!!



    public static void main(String[] args)throws NullPointerException {
        int op=3;
        int[][] array1={{1,2,3},{4,5,6},{7,8,9}};
        int[][] array2={{1,0,0},{0,1,0},{0,0,1}};
        boolean cont=true;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Pick a number 1-9");
            System.out.println("1:Add array 1");
            System.out.println("2:Add array 2");
            System.out.println("3:sum");
            System.out.println("4:difference");
            System.out.println("5:Product k*a[]");
            System.out.println("6:Product a[]*b[]");
            System.out.println("7:Transpose a[]");
            System.out.println("8:A to the power of k");
            System.out.println("9:Check symmetry");
            try{
                op=scan.nextInt();
            }catch( InputMismatchException e){
                System.out.println("not the right number try again.");
            }catch(NullPointerException np){
                System.out.println("Oops try again.");
                op=scan.nextInt();
            }
            switch (op) {
                case 1:
                    System.out.println("Add array1");
                    array1=createArray();
                    printMatrix(array1);
                    break;
                case 2:
                    System.out.println("Adda array 2");
                    break;
                case 3:
                    System.out.println("Find the sum of array 1 and array2");
                    int[][] sum1and2 = sum(array1, array2);
                    printMatrix(sum1and2);
                    break;
                case 4:
                    System.out.println("Find the diffrence of array 1 and array2");
                    int[][] diff1and2 = difference(array1, array2);
                    printMatrix(diff1and2);
                    break;
                case 5:
                    System.out.println("Fine the product of array 1 and a variable k. (ka[])");
                    System.out.println("To what  product would you like to multiply array 1?");
                    int pow = scan.nextInt();
                    int[][] prod = intMultiplication(array1, pow);
                    printMatrix(prod);
                    break;
                case 6:
                    System.out.println("Find the product of array1 and array 2. (1[]*2[])");
                    int[][] prod1and2 = matrixProduct(array1, array2);
                    printMatrix(prod1and2);
                    break;
                case 7:
                    System.out.println("Find the transpose of array 1(1^T[])");
                    int[][] trans = transpose(array1);
                    printMatrix(trans);
                    break;
                case 8:
                    System.out.println("Find array 1 to the power of K");
                    System.out.println("To what power would you like A?");
                    int k= scan.nextInt();
                    int[][]  pow1=pow(array1 ,k);
                    printMatrix(pow1);
                    break;
                case 9:
                    System.out.println("Array1 is symmetric: "+ isSymmetric(array1));
                    printMatrix(array1);
                    break;
                default:
                    System.out.println("Please choose a number from 1-10");

                    cont=false;
                    break;
            }
        }while(cont);
    }

    /**
     * this matrix takins in matrix a and prints it out no returns.
     * @param a
     */
    public static void printMatrix(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }

    /**
     *  this method will read a file and reate an array based on that file.
     * @return
     * @throws NumberFormatException
     */
    public static int[][] createArray() throws NumberFormatException {
        Scanner scnr = new Scanner(System.in);
        FileReader fr;
        BufferedReader br;
        int[][] matrix= null;
        boolean successfulFileRead = false;
        int numOfRows=0;

        while (!successfulFileRead) {
            System.out.println("File path");
            try {
                fr = new FileReader(scnr.nextLine());
                br = new BufferedReader(fr);
                while (br.ready()) {
                    numOfRows++;
                }
                br.close();
                //fr = new FileReader(scnr.nextLine());
                matrix=new int[numOfRows][];
                br = new BufferedReader(fr);
                int j=0;
                while (br.ready()) {
                    String[] intStrings = br.readLine().split(" ");
                    for(int i=0;i<intStrings.length;i++){
                        matrix[j][i] = Integer.valueOf(intStrings[i]);
                    }
                    j++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return matrix;
    }

    /**
     * The purpose of this method is to return a matrix that is the sum of
     * two given matricies A+B
     * @param A matrix A first given matrix
     * @param B matrix B second given matrix
     * @return returned matrix that gives a representation of matrix A+B.
     * @Nullable null is returned if a and b are not compatible.
     */
    public static int[][] sum(int[][] A, int[][] B){
        if((A.length==B.length)&&(A[0].length==B[0].length)) {
            int[][] summ = new int[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    summ[i][j] = A[i][j] + B[i][j];
                }
            }
            return summ;
        }else{
            System.out.println("The dimensions of A and B are not compatible");
            return null;
        }
    }

    /**
     * This method is used to find the diffrence of two matrices A-B
     * @param A first matrix
     * @param B second matrix
     * @return A-B matrix
     * @Nullable returned if a and b are not both mxn matrix with the same dimmensions.
     */
    public static int[][] difference(int[][] A, int[][] B){
        if((A.length==B.length)&&(A[0].length==B[0].length)) {
            int[][] diff = new int[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    diff[i][j] = A[i][j] - B[i][j];
                }
            }
            return diff;
        }else{
            System.out.println("The dimenisions of the matricies are not compatible.");
            return null;
        }
    }

    /**
     * This is integer multipication to a matrix. for an integer B
     * multiplied with a matrix A
     * @param A given matrix
     * @param B given integer
     * @return matrix B*A
     */
    public static int[][] intMultiplication( int[][] A,int B){
        int[][] prod=new int[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                prod[i][j]= B* A[i][j];
            }
        }
        return prod;
    }

    /**
     * a method that given an m×n matrix A and an n×p matrix B returns their product
     * AB.
     * @param A first given matrix
     * @param B second given matrix
     * @return product AB matrix
     */
    public static int[][] matrixProduct(int[][] A, int[][] B){
        int[][] prod =null;
        if(A[0].length!= B.length){
            //throw new IllegalArguentException("A:rows:"+a[0].length+"did not match B: Columns "+b.length);
            System.out.println("Matrix A B are not compatible to be multiplied. Please make sure that A columbs = B rows.");
        }else {
            prod = new int[A.length][B[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k = 0; k < A[i].length; k++) {
                        prod[i][j] += ( A[i][k] * B[k][j]);
                    }
                }
            }
        }

        return prod;
    }

    /**
     *  method that given an m × n matrix A returns its transpose AT
     * @param A an mxn matrix
     * @return matrix A transposed
     */
    public static int[][] transpose(int[][] A){
        int[][] trans= new int[A[0].length][A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                trans[j][i]=A[i][j];
            }
        }
        return trans;
    }

    /**
     * . a method that verifies wheather a given n × n matrix A is symmetric.
     * @param a a given nXn matrix
     * @return
     */
    public static Boolean isSymmetric(int[][] a){
       if(a.length!= a[0].length){
           System.out.println("This array is not an nxn matrix therefore never going to be symetric.");
           return false;
       } else{
           for (int i=0;i<a.length;i++){
               for(int j=i;j<a[0].length;j++ ){
                   if(j!=i) {
                       if (a[i][j] != a[j][i]) {
                           return false;
                       }
                   }

               }
           }
       }
       return true;
   }

    /**
     * a method that given an n × n matrix A and a positive integer k computes Ak
     * @param A an nxn matrix
     * @param k power to which matrix A will be muliplied by
     * @return A to the Kth power matrix.
     */
    public static int[][] pow(int[][] A, int k){
        int[][] pow=null;
        if(A.length!= A[0].length){
            System.out.println("Not an nxn matrix please try again.");
            return null;
        }else{
            pow=A.clone();
            for(int i=1;i<k;i++){
             pow=matrixProduct(pow,A);
             }
        }
        return pow;
    }
}

