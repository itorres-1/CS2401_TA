package Lab1;

/**Crystal Serrano**
***Assignment: Lab 1
***Instructor: Dr. Urenda
***TA: Isaac Torres
***Date last Modified: 6/21/2017
***Purpose of program: 
***The purpose of this program is to ask the user to input the path to a desired file
***and within that file, gather and store the information for further use. The program
**will check if the array of integers gahtered from the file is a permutation. It will
***also calculate the composition between two integer arrays, the inverse of a given
***array and the outcome of the array a^k.**/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Serrano
{

//    public static void main(String[] args) {
//		Scanner scnr = new Scanner(System.in);
//		System.out.println("Enter file path: ");
//		String filename = scnr.nextLine();
//		int[] a = ReadFromFile(filename);
//		/**didnt finish**/
//
//    }
    /**method ReadFromFile will read in the file inputed by the user and
		will then scan the file and read in the information and store it
		into appropriate data tyoes.**/
    public static int[] ReadFromFile(String filename){
        Scanner scnr = new Scanner(System.in);

        while(true){
            System.out.print("Enter File Path: ");
            try{
                FileReader fr = new FileReader(filename);
                BufferedReader textReader = new BufferedReader(fr);

                int k = Integer.parseInt(textReader.readLine());  /**first line**/
                String[] intString = textReader.readLine().split(" ");  /**second line**/

                /**convert intString into an int[]**/
                int[] a = new int[intString.length];
                for(int i=0; i < a.length; i++){
                    a[i]= Integer.parseInt(intString[i]);
                    System.out.print(" " + a[i]);
                  }
                  return a;
            }
            catch(FileNotFoundException e){
                  System.out.println("File not found.");
            }
            catch(IOException e){
                System.out.println("IO Exception.");

            }
        }/**break the while loop**/
    }

    /**method isPermutation will check if the array from the given file is a
	   permutation array, will return a boolean value**/
    //figure out how this method can be more generic!!
    public static boolean isPermutation(int[] a){
        while(true) {
            System.out.println("Permutation? ");
            try {
                boolean no = false;
                boolean yes = true;
                for (int i = 0; i < a.length; i++) {
                    if (a[i] >= 0 && a[i] <= 9) {
                        if (a[i] == a[i + 1]) {
                            return no; //FIX
                        }
                    }
                }
                return yes;
            } catch (ArrayStoreException e) {
                System.out.println("Wrong data type for array inputs.");
            }
        }
    }
    
    /**method Composition will calculate the composition of two given arrays
	   and will return the composition of f;g**/
    public static int[] composition(int[] f, int[] g){
        while(true) {
            System.out.println("The composition is: ");
            try {
                int[] compfg = new int[f.length];
                for (int i = 0; i < compfg.length; i++) {
                    compfg[i] = f[g[i]];
                }
                return compfg;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index out of bounds.");
            }
        }
     }

    /**method Inverse calculates the inverse of the given permutation array**/
    public static int[] inverse(int[] a){
        while(true) {
            try {
                System.out.println("The inverse is: ");
                int[] invs = new int[a.length];
                for (int i = 0; i < invs.length; i++) {
                    invs[a[i]] = i;
                }
                return invs;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index out of bounds.");
            }
        }
    }

    /**method Pow will compute the permutation array a to the k power**/
    public static int[] pow(int[] a, int k){
        while (true) {
            System.out.println("Pow(a^k) is: ");
            try {
                int[] arrayK = new int[a.length];
                if (k < 0) {
                    System.out.println("Input is invalid.");
                } else if (k == 1 || k == 0) {
                    return a;
                } else {
                    for (int j = 1; j < k; j++) {          /**this for loop loops one less than k, ex: k=2, a*a. but since**/
                        arrayK = composition(a, a);    /**there is already a multi operation in Composition method, we do k-1**/
                    }

                    return arrayK;
                }
            } catch (IndexOutOfBoundsException i) {
                System.out.println("Index is out of bounds.");
            }
        }
    }
}
