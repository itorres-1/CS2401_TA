package Lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Wiggs {

    //isPerm not correct half
    //comp is right
    //inverse is right
    //pow is right
    //R - is perm
    public static int[] fileReader() {
        Scanner scnr = new Scanner(System.in);
        System.out.print("File Path: ");
        FileReader fr;
        BufferedReader reader;

        Boolean successfulFileRead = false;
        int[] num;
        num = new int[0];
        while (!successfulFileRead) {
            System.out.print("File Path: ");
            try {
                fr = new FileReader(scnr.next());
                reader = new BufferedReader(fr);

                int k = Integer.parseInt(reader.readLine());
                String[] intStrings = reader.readLine().split("");
                num = new int[intStrings.length];

                for (int i = 0; i < intStrings.length; i++) {
                    num[i] = Integer.parseInt(intStrings[i]);
                }
                return num;
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } catch (java.io.IOException r) {
                System.out.println("Wrong");


            }

        }
        return num;
    }

    /**
     * @param A
     * @return
     */

    public static boolean isPermutation(int[] A) {
        boolean trueCheck = false;
        int i;
        int j;
        try {
            for (i = 0; i < A.length; i++) {
                for (j = i + 1; j < A.length; j++) {
                    if (A[i] == A[j]) {
                        trueCheck = false;
                        return trueCheck;
                    } else {
                        trueCheck = true;
                    }
                }
            }
        } catch (InputMismatchException n) {

        }

        return trueCheck;
    }

    /**
     * This method
     * @param A
     * @return
     */
    public static int[] inverse(int[] A) {
        boolean t = isPermutation(A);
        if (!isPermutation(A)) return null;
        int[] aInv = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            aInv[A[i]] = i;
        }
        return aInv;

    }


    /**
     * @param A
     * @param B
     * @return
     */

    public static int[] composition(int[] A, int[] B) {
        boolean t = isPermutation(A);
        boolean y = isPermutation(B);
        int size = A.length;
        if ((t != true) && (y != true)) return null;
        int i;
        int[] C = new int[A.length];

        for (i = 0; i < A.length; i++) {
            C[i] = B[A[i]];
        }
        return C;
    }

    /**
     * @param arr1
     * @param k
     * @return
     */
    public static int[] pow(int[] arr1, int k) {
        boolean t = isPermutation(arr1);
        int size = arr1.length;
        if (!isPermutation(arr1)) return null;
        int[] compositionToK = Arrays.copyOf(arr1, size);

        for (int i = 0; i < k - 1; i++) {
            compositionToK = composition(compositionToK, arr1);
        }

        return compositionToK;
    }

    /**
     * @param args
     * @throws IOException
     */
//    public static void main(String[] args) throws IOException {
//        int cont = 1;
//        while (cont != 2) {
//            System.out.println("Enter option :");
//            System.out.println("1 : To Test if an array is permutation array");
//            System.out.println("2 : To Compute composition of one array with another array");
//            System.out.println("3 : To Compute Inverse of an array");
//            System.out.println("4 : To Compute composition on an array to itself K times");
//
//            Scanner scanner = new Scanner(System.in);
//            int choice = scanner.nextInt();
//            String fileName;
//            switch (choice) {
//                case 1:
//
//                    try {
//                        System.out.println("Enter file name to read array data from");
//                        fileName = scanner.next();
//                        FileReader fr = new FileReader(fileName);
//                        BufferedReader bufferedReader = new BufferedReader(fr);
//
//                        int size = Integer.parseInt(bufferedReader.readLine());
//                        int[] arr1 = new int[size];
//                        String[] lineread = bufferedReader.readLine().split(" ");
//                        for (int i = 0; i < size; i++) {
//                            arr1[i] = Integer.parseInt(lineread[i]);
//                        }
//                        System.out.println("Is array a permutation array? : " + isPermutation(arr1));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        System.out.println("Error");
//                    }
//                    break;
//                case 2:
//                    System.out.println("Enter first file name to read first array data from");
//                    fileName = scanner.next();
//                    System.out.println("Enter second file name to read second array data from");
//                    String fileName2 = scanner.next();
//                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
//                         BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName2))) {
//                        int size1 = Integer.parseInt(bufferedReader.readLine());
//                        int size2 = Integer.parseInt(bufferedReader1.readLine());
//                        int[] arr1 = new int[size1];
//                        int[] arr2 = new int[size2];
//                        if (size1 != size2) {
//                            System.out.println("Arrays size not equal. Exiting...");
//                            System.exit(1);
//                        }
//                        String[] lineread1 = bufferedReader.readLine().split(" ");
//                        String[] lineread2 = bufferedReader1.readLine().split(" ");
//                        for (int i = 0; i < size1; i++) {
//                            arr1[i] = Integer.parseInt(lineread1[i]);
//                            arr2[i] = Integer.parseInt(lineread2[i]);
//                        }
//                        System.out.println("The composition of the first array with second array is : " +
//                                Arrays.toString(composition(arr1, arr2, size1)));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        System.out.println("Error");
//                    }
//                    break;
//                case 3:
//                    System.out.println("Enter file name to read array data from");
//                    fileName = scanner.next();
//                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
//                        int size = Integer.parseInt(bufferedReader.readLine());
//                        int[] arr1 = new int[size];
//                        String[] lineread = bufferedReader.readLine().split(" ");
//                        for (int i = 0; i < size; i++) {
//                            arr1[i] = Integer.parseInt(lineread[i]);
//                        }
//                        System.out.println("Inverse of the given array is : " + Arrays.toString(inverse(arr1)));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        System.out.println("Error");
//                    }
//                    break;
//                case 4:
//                    System.out.println("Enter file name to read array data from");
//                    fileName = scanner.next();
//                    System.out.println("Enter 'K'");
//                    int k = Integer.parseInt(scanner.next());
//                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
//                        int size = Integer.parseInt(bufferedReader.readLine());
//                        int[] arr1 = new int[size];
//                        String[] lineread = bufferedReader.readLine().split(" ");
//                        for (int i = 0; i < size; i++) {
//                            arr1[i] = Integer.parseInt(lineread[i]);
//                        }
//                        System.out.println("composition on an array to itself K times is : " + Arrays.toString(computeCompositionToK(arr1, size, k)));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        System.out.println("Error");
//                    }
//                    break;
//                default:
//                    System.out.println("Enter correct choice from 1 - 4");
//            }
//            System.out.println("1 to continue, 2 to exit.");
//            cont = scanner.nextInt();
//        }
//    }

}







