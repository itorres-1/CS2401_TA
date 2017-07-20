package Lab1;

/**
 * Created by Imani on 6/20/2017.
 */
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

    /**
     Author: Imani Martin
     Date: June 20, 17
     Course: 2401
     Assignment: Lab 1
     Instructor: Urenda, Julio
     */


    public class Martin {


        //Method 1: reading the arrays from text file
        public static List<Integer> readFromFile(List<Integer> listOne, List<Integer> listTwo) throws IOException {
            Scanner scnr = new Scanner(System.in);
            Scanner input = null;

            //Prompt User for Info
            //first file

            System.out.println("What is the path of the first file?");
            String filePath = scnr.next();

            System.out.println("What is the name of the text file?");
            String fileName = scnr.next();

            filePath = filePath + "\\" + fileName;

            File usrFile = new File(filePath);

            //if file does not exist then error occurs
            try {
                input = new Scanner(usrFile);

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
                System.out.println("Program terminated.");
                System.exit(0);
            }
            System.out.println("File located.");

            //File reader if first file exists
            BufferedReader readFile = new BufferedReader(new FileReader(filePath));
            readFile.readLine();

            String line;

            for (line = readFile.readLine(); line != null; line = readFile.readLine()) {
                String[] numList = line.split(" "); //array for first list

                for (int i = 0; i < numList.length; i++) {
                    int par = Integer.parseInt(numList[i]);
                    listOne.add(par);
                }

            }

            readFile.close(); //closes reader

            //second file
            System.out.println("What is the path of the second file?");
            String filePath_2 = scnr.next();

            System.out.println("What is the name of the file?");
            String fileName_2 = scnr.next();

            filePath_2 = filePath_2 + "\\" + fileName_2;
            File usrFile_2 = new File(filePath_2);

            //if file does not exist then error occurs
            try {
                input = new Scanner(usrFile_2);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
                System.out.println("Program terminated");
                System.exit(0);
            }

            System.out.println("File Located.");

            //File reader if file exists
            BufferedReader readFile_2 = new BufferedReader(new FileReader(filePath_2));
            readFile_2.readLine();

            String lineTwo;

            for (lineTwo = readFile_2.readLine(); lineTwo != null; lineTwo = readFile_2.readLine()) {
                String[] numList_2 = lineTwo.split(" "); //array for first list

                for (String num_2 : numList_2) {
                    int parTwo = Integer.parseInt(num_2);
                    listTwo.add(parTwo);
                }
                return listTwo;
            }
            readFile_2.close(); //closes reader
            return listOne;
        }



        //Method 2: Are the arrays permutations
        public static boolean isPermutation(int[] arrOne, int[] arrTwo) { //boolean for determining if array is a permutation
            boolean isPer = false;
            //checks if arrays are equal in length
            if (arrOne.length != arrTwo.length) {
                System.out.println("Not a permutation. Not equal in length.");
                System.out.println("Program terminated");
                System.exit(0);
                return false;
            }

            //sort arrays in ascending order
            Arrays.sort(arrOne);
            Arrays.sort(arrTwo);

            //compares arrays to one another
            for (int i = 0; i < arrOne.length; i++) {
                if (arrOne[i] != arrTwo[i]) {
                    System.out.println("Not a permutation. Too many duplicates.");
                    System.out.println("Program terminated");
                    System.exit(0);
                    return false;
                }
            }
            System.out.println("Yes. Permutation found.");
            return true;
        }



        //Method 3: Inverse of the two arrays
        public static int [] inverse(int[] arrListOne, int[] arrListTwo){ //inverse of permutation array
            //first array inverse
            System.out.println("Computing Inverses");

            System.out.println("The inverse of the arrays are: ");

            ///first array inverse
            int[] inverseA = new int[arrListOne.length];
            for (int i = 0; i < arrListOne.length; i++){
                inverseA[i] = arrListOne[arrListOne.length - 1 - i];
                System.out.print(inverseA[i] + " ");
            }

            System.out.println(); //separates first array from second

            //second array inverse
            int[] inverseB = new int[arrListTwo.length];
            for (int j = 0; j < arrListTwo.length; j++){
                inverseB[j] = arrListTwo[arrListTwo.length - 1 - j];
                System.out.print(inverseB[j] + " ");
            }

            return inverseA;
        }


        //Method 4: The composition of the arrays
        public static int [] composition(int[] composeA, int[] composeB, int[] composeC){
            for (int i = 0; i < composeB.length; i++){
                composeC[i] = composeA[composeB[i]];
            }
            return composeC;
        }


        //Method 5: Take the composition and compute the power k times
        public static double [] power(double[] pow, int k) {

            if (k < 0) {
                System.out.println("This is a negative exponent. Not a valid answer.");
                System.exit(0);
            }

            if (k == 0) {
                System.out.println(pow);

            }

            System.out.println();
            double[] finalPower = new double[pow.length];
            for (double i = 0; i < pow.length; i++){
                finalPower[(int)i] = pow[(int)pow[(int)i]];
            }

            for (double num : finalPower){
                System.out.print((int)Math.pow(num,k) + " ");
            }
            return finalPower;
        }



        public static void main (String [] args) throws FileNotFoundException {
            Scanner scnr = new Scanner(System.in);


            //Method 1: Reading Arrays From Text File

            //first array
            List<Integer> firstList = new ArrayList<>();
            //second array
            List<Integer> secondList = new ArrayList<>();

            try {

                readFromFile(firstList, secondList);
            } catch (IOException e) {
                System.out.println("Try again.");
            }

            System.out.println("Checking permutations for: ");
            System.out.println(firstList); //array one
            System.out.println(secondList); //array two

            //convert Linked Lists to Arrays
            int[] permutationOne = new int[firstList.size()]; //array one
            for (int i = 0; i < firstList.size(); i++) {
                permutationOne[i] = firstList.get(i);
            }

            int[] permutationTwo = new int[secondList.size()]; //array two
            for (int j = 0; j < secondList.size(); j++) {
                permutationTwo[j] = secondList.get(j);
            }


            //Method 2: Determining if arrays are permutations of each other [boolean]

            isPermutation(permutationOne, permutationTwo); //Note: these objects are sorted


            //Method 3: Computing the inverse
            //convert original lists so that arrays are not sorted
            int[] inverseOne = new int[firstList.size()]; //array one
            for (int i = 0; i < firstList.size(); i++) {
                inverseOne[i] = firstList.get(i);
            }

            int[] inverseTwo = new int[secondList.size()]; //array two
            for (int j = 0; j < secondList.size(); j++) {
                inverseTwo[j] = secondList.get(j);
            }

            inverse(inverseOne, inverseTwo);

            System.out.println(" ");


            //Method 4: Compute Composition
            //convert linked lists so that they are not inverted
            System.out.println("The composition of the two arrays are: ");

            int[] compA = new int[firstList.size()]; //array one
            for (int i = 0; i < firstList.size(); i++) {
                compA[i] = firstList.get(i);
            }

            int[] compB = new int[secondList.size()]; //array two
            for (int j = 0; j < secondList.size(); j++) {
                compB[j] = secondList.get(j);
            }

            int[] compC = new int[compB.length];
            composition(compA, compB, compC);

            for (int i = 0; i < compC.length; i++) {
                System.out.print(compC[i] + " ");
            }


            //Method 5: Take the composition and compute its power k times
            System.out.println();

            int num; //integer that acts as the exponent of the base
            System.out.println("Please enter an integer: ");
            try {
                num = scnr.nextInt();
                System.out.println("You've entered " + num + " for the power of this composition.");


                //convert int[] composition to double[]
                double[] pow = new double[compC.length];
                for (int i = 0; i < compC.length; i++) {
                    pow[i] = compC[i];
                }

                System.out.println("The power of this composition is: ");

                power(pow, num);

            } catch (InputMismatchException e) {
                System.out.println("Not a valid character. Try again.");
                System.exit(0);
            }
        }
    }

