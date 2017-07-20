package Lab1;

/**
 * Name: Gabriel Vela
 * Class: CS2401/Summer 1
 * Assignment: Lab 1
 */
import java.util.*;
import java.io.*;



public class Vela {
    public static int[] readFromFile() {
        /**
         * This method works to read a file that is specifed from a file path,
         * and is then able to turn a string of integers into an array of integers.
         */

        Scanner input = new Scanner(System.in);



        String[] strings;
        int[] results = {-1};


        FileReader fr;
        BufferedReader reader;

        Boolean successfulFile = false;
        while (!successfulFile) {
            System.out.print("File Path: ");
            try {
                fr = new FileReader(input.nextLine());
                reader = new BufferedReader(fr);

                int k = Integer.parseInt(reader.readLine());

                strings = reader.readLine().split(" ");
                results = new int[strings.length];
                for(int i =0; i<strings.length;i++){
                    results[i]=Integer.parseInt(strings[i]);
                }
                successfulFile=true;

            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
                successfulFile=false;
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array out of bounds!");
                successfulFile=false;
            } catch (InputMismatchException e){
                System.out.print("Characters do not match.");
                successfulFile=false;
            }


            catch (IOException e) {
                System.out.println("Error!!");
                successfulFile=false;
            }


        }

        printArray(results);

        return results;
    }

    public static Boolean isPermutation(int[] f) {

        /**
         * This method will check the array of integers read from a file
         * and make sure it is indeed a possible permutation.
         */

        for (int i = 0; i < f.length; i++) {


            if(f[i] < 0 || f[i] > f.length-1)
                return false;
            for(int j= i+1; j < f.length; j++){
                if (f[i] == f[j])
                    return false;
            }

        }

        return true;
    }

    public static int[] composition(int[] f, int[] g) {
        /**
         * Composition method will compose one array with another after both file paths are specified.
         */

        int temp[] = new int[f.length];

        if(f.length != g.length){
            System.out.println("Not compatable arrays!");
            return null;
        }
        for (int i = 0; i < temp.length; i++) {
            temp[i] = f[g[i]];

        }
        return temp;
    }


    public static int[] inverse(int[] f) {
        /**
         * This method is supposed to return the inverse of the 'f' array..
         */

        int[] temp = new int[f.length];
        temp[0] = f[f.length-1];
        for (int i = 0; i < f.length-1; i++) {
            temp[i + 1] = f[i];
        }
        return temp;

    }

    public static int[] pow(int[] f, int k) {
        /**
         * Method takes an integer array and powers it with a 'k' integer that is decided by the user.
         */

        int[] temp = new int[f.length];
        if (k < 0) {
            System.out.println("The power selected is Negative!");
        } else
            for (int i = 0; i < f.length; i++) {

                temp[i] = f[f[i]];

            }
        return temp;
    }

    public static void printArray(int [] f){
        /**
         * Method created to print an array's contents. Making it easier to view for the user,
         * and thus know what they're doing.
         */

        for(int i =0; i<f.length;i++){
            System.out.print(f[i] + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
    }
//    public static void main(String[] args) throws IOException {
//        /**
//         * The main. Where all the magic happens.
//         */
//
//        Scanner input = new Scanner(System.in);
//        int answer = 0;
//
//        int k = 0;
//        int [] f = new int[0];
//        int [] A = new int[0];
//
//        while(answer <= 5){
//            System.out.println("Hello Isaac, what would you like to do?");
//            System.out.println("1. Read File");
//            System.out.println("2. Check Permutation");
//            System.out.println("3. Compose Permutation");
//            System.out.println("4. Inverse Permutation");
//            System.out.println("5. Power permutation");
//            System.out.println("6. Exit");
//            answer = input.nextInt();
//
//
//            if(answer == 1){
//                readFromFile();
//            }
//
//            if(answer ==2){
//                boolean answer2;
//                answer2 = isPermutation(readFromFile());
//                if(answer2 = true)
//                    System.out.println("It is a permutation");
//                System.out.println(" ");
//            }
//
//            if(answer == 3){
//
//                A = readFromFile();
//                f = readFromFile();
//                printArray(composition(A,f));
//            }
//
//            if(answer == 4){
//                A = readFromFile();
//                f = inverse(A);
//                printArray(f);
//            }
//
//            if(answer == 5){
//                System.out.println("What kind of power would you like to use for your permutation?");
//                k = input.nextInt();
//                A = readFromFile();
//                printArray(power(A,k));
//            }
//        }
//
//    }
}





