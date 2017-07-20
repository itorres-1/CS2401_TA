package Lab1;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by Andrea on 6/19/2017.
 * Lab 1 permutaions
 * cs
 * summer 2017
 */
 public class Torres {
    public static void main (String[] args) {
        int swtch = 1;
        boolean stop=false;
        int[] array1 = readFromFile();
        //printArray(array1);
        int[] arrayA = createArray(array1);
        System.out.print("Array 1:");
        printArray(arrayA);
        int[] array2 = readFromFile();
        int[] arrayb = createArray(array2);
        //System.out.print("Array 2:");
        printArray(arrayb);
        Scanner scan = new Scanner(System.in);
        boolean validNumber=false;
        do{
            System.out.println("What option would you like?");
            System.out.println("1: Fill/change array 1");
            System.out.println("2: Fill/change array 2");
            System.out.println("3: Compostion of Array 1 and Array2");
            System.out.println("4: Power of array 1.");
            System.out.println("5: inverse of array 5");
            System.out.println("6: Create a new array");
            System.out.println("7: End");
            do {
                try {
                    swtch = scan.nextInt();
                    if((swtch<=7)||(swtch>0)){
                        validNumber=true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Pleas input a numbr from 1-7");
                    swtch = scan.nextInt();
                }
                scan.nextLine();
            }while(!validNumber);
            validNumber=false;

            switch (swtch) {
                case 1:
                    System.out.println("1: Fill/change array 1");
                    array1 = readFromFile();
                    //printArray(array1);
                    arrayA = createArray(array1);
                    System.out.print("Array 1:");
                    printArray(arrayA);
                    stop=false;
                    break;
                case 2:
                    System.out.println("2: Fill/change array 2");
                    array2 = readFromFile();
                    arrayb = createArray(array2);
                    //System.out.print("Array 2:");
                    printArray(arrayb);
                    System.out.println();
                    stop=false;
                    break;
                case 3:
                    System.out.println("3:Compostion of Array 1 and Aeeay2");
                    int[] compostionArray = composition(arrayA, arrayb);
                    printArray(compostionArray);
                    stop=false;
                    break;
                case 4:
                    System.out.println("4: Power of array 1.");
                    System.out.println("What power would you like?");
                    int k = scan.nextInt();
                    System.out.println("Power:" + k);
                    int[] powercomp = pow(arrayA, k);
                    printArray(powercomp);
                    stop=false;
                    break;
                case 5:
                    System.out.println("5: inverse of array 5");
                    int[] inverseArray = inverse(arrayA);
                    System.out.println("Inverse of the array.");
                    printArray(inverseArray);
                    stop=false;
                    break;
                case 6:
                    System.out.println("6: Create a permutaion");
                    System.out.println("What is the length of the permutation you would like?");
                    int length= scan.nextInt();
                    int[] array3=createPerm(length);
                    printArray(array3);
                    stop=false;
                    break;
                case 7:
                    System.out.println("7: End");
                    stop = true;
                default:
                    System.out.println("Please select a number from 1-7");
            }
        }while(!stop);
    }

    /** this method will create the true array, it will pass a "raw" array that has the length of the array in the last sell
              * this is used to ASUURE THAT no numbers are lost form the read file method.
              * @param a this is the raw array that was created from the readFile method
              * @return this will return an array  represtenting the second line in the file.
              */
    public static int[] createArray(int[] a){
                int[] perm=new int[a.length-1];
                boolean pass= isPermutation(a);
                if(pass){//will chick first if it is a permutaion.
                    for(int i = 0; i<perm.length;i++){
                        perm[i]=a[i];
                    }
                }else{
                    System.out.println("This is not a permutaion.");
                }
                return perm;
             }

    /** this method checks if a given array is a permutaion. it creates a copy of the array and sorts it to make sure all of the
             * umbers are there. this recives a "raw array"
             *
             * @param test raw array
             * @return retrurns a boolean statement to determine if an array is a permtuaion.
             */
    public static boolean isPermutation(int[] test) {
                int[] permTest = test.clone();
                Arrays.sort(permTest);
                boolean isPerm=true;
                int i=0;
                while(i<permTest.length-1){
                    if(permTest[i]!=i){
                        isPerm=false;
                    }
                    i++;
                }
                return isPerm;
            }

    /**
             * This method is used to compute the compostion this is used as a[b[i]] where be is inside a.
             * @param a is the first paramete that is recived
             * @param b is the second paramiter that is recived
             * @return
             */
    public static int[] composition(int[] a, int[] b) {
                int[] comppositon = new int[a.length];
                int hold= 0;
                if ( (a.length == b.length)) {
                    comppositon = new int[a.length];
                    for (int i = 0; i < a.length; i++) {
                        hold=b[i];
                        comppositon[i] = a[hold];
                    }
                }else{
                    System.out.println("not compatible");
                }
                return comppositon;
            }

    /**
     * this method recives two parameters an integer array and a single integer. The purpose of this array is to make
     * the array go to the kth power.
     * @param a array to be multiplied
     * @param k exponent of array.
     * @return returns the multiplied array.
     */
    public static int[] pow(int[] a, int k){
                int[] compPowFin= a.clone();
                for(int j=0; j<k-1;j++) {
                    for (int i = 0; i < a.length; i++){
                        compPowFin[i] = a[compPowFin[i]];
                        //System.out.println("");
                    }
                }
                return compPowFin;
            }

    /**
             * this method will compose the inverse of the array by starting i at the end of the medthod and
             * @param  a needs and arraya to return
             * @return return the inverse
             */
    public static int[] inverse(int[] a){
                int [] inverseCode=new int[a.length];
                for(int i=0;i<a.length;i++){
                    inverseCode[a[i]]=i;
                }
                return inverseCode;
            }

    /**
             * this method does not recive anything but it does return infromation from the file in the form of an array.
             * the array that is returned has the second line of numbers first and then the last number is the suposed size
             * of the array
             * @return this is the array that is returned
             * @throws NumberFormatException
             */
    public static int[] readFromFile() throws NumberFormatException {
                Scanner scnr = new Scanner(System.in);
                System.out.println("What is the file name");
                FileReader fr;
                BufferedReader reader;
                int[] arrayThing=null;
                boolean successfulFileRead=false;
                while(!successfulFileRead){
                    System.out.println("File path");
                   try{
                       fr=new FileReader(scnr.nextLine());
                       reader= new BufferedReader(fr);
                    int k=Integer.parseInt(reader.readLine());// this would nto work if the first like ni not a single number;
                    String[] intStrings = reader.readLine().split(" ");
                    //now string ints need to be converted by int array
                      arrayThing= new int[intStrings.length+1];
                     for(int i=0; i< intStrings.length;i++){
                         arrayThing[i]=Integer.valueOf(intStrings[i]);
                       }
                       arrayThing[intStrings.length]=k;
                       //System.out.println("Array filled.");
                       successfulFileRead=true;
                    }catch(FileNotFoundException e){
                        System.out.println("File not found!");
                    }catch(IOException e){
                        System.out.println("Something went worng");
                    }catch (NumberFormatException nfe){
                        System.out.println("theres a space in my boot.");
                    }
                }
                if(arrayThing==null){
                    arrayThing= new int[1];
                    arrayThing[0]=-9;
                }
                return arrayThing;

            }

    /**
             * this is used to print the array  nothing is returned
             * @param a this is the array that is brought in
             */
    public static void printArray(int[] a){
                for(int i =0 ; i<a.length;i++){
                    System.out.print(a[i]+" ");
                }
                System.out.println("");
            }

    /**
     * The purpose of this method is to remove the last int of the array and return a valid permutation.
     * @param l recives an array that the last indices is the length of the permutation.
     * @return returns a working array.
     */
    public static int[] createPerm(int l){
        int[] array= new int[l];
        Random rand= new Random();
        boolean isPerm=false;
        while(!isPerm) {
            for (int i = 0; i < (l-1); i++) {
                array[i] = rand.nextInt(l-1);
            }
            array[l-1]=l;

            isPerm=isPermutation(array);
            createArray(array);
        }
        return array;
    }
 }


