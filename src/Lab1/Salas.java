package Lab1;

/*
Author: Jaime, Salas
Professor: Urenda, Julio
Subject: CS 2
Date: 6/19/17


 */

import java.util.*;
import java.io.*;

class Salas
{
//    public static void main(String[] args) {
//
//
//        Scanner scnr = new Scanner(System.in);
//
//        //The menu of the proram
//        for (int i = 0; i <= 0; i++) {
//            System.out.println("Welcome to the menu");
//            System.out.println("Here are all the options listed below");
//        }
//        System.out.println("Option 1: Decide if the array is a permutation array");
//        System.out.println("Option 2: Choose from 2 arrays and comuter the composition");
//        System.out.println("Option 3: Compute the inverse of the array");
//        System.out.println("Option 4: Given a permutation array, compute the array by the power of K");
//
//        //scanner object
//        Scanner input = new Scanner(System.in);
//        int userInput = input.nextInt();
//        String permutationAFile;
//
//        //switch to deal user inputs
//        switch (userInput) {
//            case 1:
//                System.out.println("Input the file name");
//                permutationAFile = input.next();
//                try (BufferedReader fileRead = new BufferedReader(new FileReader(permutationAFile))) {
//                    // read the array size
//                    int sizeOfArray = Integer.parseInt(fileRead.readLine());
//
//                    //read the array
//                    int[] perArray1 = new int[sizeOfArray];
//                    String[] lineinFile = fileRead.readLine().split(" ");
//                    for (int i = 0; i < sizeOfArray; i++) {
//                        perArray1[i] = Integer.parseInt(lineinFile[i]);
//                    }
//                    System.out.println("Permutation array Check result : " + chkPermutation(perArray1, sizeOfArray));
//                } catch (IOException e) {
//                    System.out.println("File Error");
//                }
//                break;
//            case 2:
//                System.out.println("Enter the first file name: ");
//                permutationAFile = input.next();
//                System.out.println("Enter the second file name: ");
//                String secFile = input.next();
//                try (BufferedReader fileRead = new BufferedReader(new FileReader(permutationAFile));
//                     BufferedReader bufferedReader1 = new BufferedReader(new FileReader(secFile))) {
//                    int length1 = Integer.parseInt(fileRead.readLine());
//                    int length2 = Integer.parseInt(bufferedReader1.readLine());
//                    int[] perArray1 = new int[length1];
//                    int[] perArray2 = new int[length2];
//                    if (length1 != length2) {
//                        System.out.println("length mismatch. Exiting...!!");
//                        System.exit(1);
//                    }
//                    String[] num1 = fileRead.readLine().split(" ");
//                    String[] num2 = bufferedReader1.readLine().split(" ");
//                    for (int i = 0; i < length1; i++) {
//                        perArray1[i] = Integer.parseInt(num1[i]);
//                        perArray2[i] = Integer.parseInt(num2[i]);
//                    }
//                    System.out.println("The resultCompo result array: " +
//                            Arrays.toString(findCompositionOfTwo(perArray1, perArray2, length1)));
//                } catch (IOException e) {
//                    System.out.println("File Error");
//                }
//                break;
//            case 3:
//                System.out.println("Enter the file name");
//                permutationAFile = input.next();
//                try (BufferedReader fileRead = new BufferedReader(new FileReader(permutationAFile))) {
//                    int sizeOfArray = Integer.parseInt(fileRead.readLine());
//                    int[] perArray1 = new int[sizeOfArray];
//                    String[] lineinFile = fileRead.readLine().split(" ");
//                    for (int i = 0; i < sizeOfArray; i++) {
//                        perArray1[i] = Integer.parseInt(lineinFile[i]);
//                    }
//                    System.out.println("Inverse of the given array is : " + Arrays.toString(computeInverse(perArray1)));
//                } catch (IOException e) {
//                    System.out.println("Error");
//                }
//                break;
//            case 4:
//                System.out.println("Enter the file name.");
//                permutationAFile = input.next();
//                System.out.println("Enter 'K'");
//                int k = Integer.parseInt(input.next());
//                try (BufferedReader fileRead = new BufferedReader(new FileReader(permutationAFile))) {
//                    int sizeOfArray = Integer.parseInt(fileRead.readLine());
//                    int[] perArray1 = new int[sizeOfArray];
//                    String[] lineinFile = fileRead.readLine().split(" ");
//                    for (int i = 0; i < sizeOfArray; i++) {
//                        perArray1[i] = Integer.parseInt(lineinFile[i]);
//                    }
//                    System.out.println("resultCompo power k : " + Arrays.toString(computeCompositionToK(perArray1, sizeOfArray, k)));
//                } catch (IOException e) {
//                    System.out.println("File Error!!!");
//                }
//                break;
//            default:
//                System.out.println("Invalid user input");
//        }
//
//    }

    //method to check for composition
    public static boolean isPermutation(int[] inArray) {
        Arrays.sort(inArray);
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] != i) {
                return false;
            }
        }
        return true;
    }

    //method to find the composition
    public static int[] composition(int[] perArray1, int[] perArray2) {
        int[] resultCompo = new int[perArray1.length];
        for (int i = 0; i < perArray1.length; i++) {
            resultCompo[i] = perArray1[perArray2[i]];
        }
        return resultCompo;
    }

    //method to find the inverse
    public static int[] inverse(int[] perArray1) {
        //Inverse is same is perArray1 so return it
        return perArray1;
    }

    //method to find the power
    public static int[] pow(int[] perArray1, int k) {
        int[] raisedByK = Arrays.copyOf(perArray1, perArray1.length);

        for (int i = 0; i < k - 1; i++) {
            raisedByK = composition(raisedByK, perArray1);
        }

        return raisedByK;
    }
}
