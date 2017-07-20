package Lab1;

/**
 * Project: Lab 1
 * Name: Jessica Redekop
 * Due: Wednesday June 21, 2017
 * Professor: Dr. Urenda
 * T.A.: Isaac Torres
 */

import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Redekop {
    /**
    *This method is the main method where it will provide the user with:
    *Permutation checks, permutation composition, inverse, and computes a permutations power.
    *@param args regular main method parameter
    *@return void no return type per main method
    *@throws InputMismatchException Scanner will ask for an integer input.
    */
//    public static void main(String[] args){
//
//        Boolean flag = false; //flag to loop through each question if answered incorrectly
//
//        //Compute if permutation
//        System.out.println(); //readability
//        System.out.println("Welcome."); //welcome message
//        System.out.println(); //readability
//        System.out.println("Let's find out if the set is a permutation."); //Lets user know that program will check if permutation
//        int[] checkPermutation = readFromFile(); //sends to read from file whick will innately check permutation and return array
//        System.out.println(); //readability
//        System.out.println("Congratulations! This is a permutation."); //if this code is executed, user provided good info to readFromFile
//
//        System.out.println(); //readability
//
//        //Compute composition
//        while(flag == false){ //will loop until correct info is provided
//            try{
//                System.out.println("Now, let's find the composition of two permutation arrays."); //Advise user what program will do
//
//                System.out.println("First array:"); //Advises user that path will be for first array
//                int[] array1 = readFromFile(); //creates an array from read file
//                for(int i = 0; i < array1.length; i++){ //will go through each adddress of array
//                    if(0 > array1[i] || array1[i] >= array1.length) //check if array info is from 1 to length -1
//                        throw new Exception("Entries in first array should be from 0 to length-1."); //throws exception
//                }
//
//                System.out.println("Second array:"); //Advises user that path will be for second array
//                int[] array2 = readFromFile(); //creates a second array from read file
//                for(int i = 0; i < array2.length; i++){ //will go through each address of array
//                    if(0 > array2[i] || array2[i] >= array2.length)//check if array info is from 1 to length -1
//                        throw new Exception("Entries in second array should be from 0 to length-1."); //throws exception
//                }
//
//                if(array1.length != array2.length) //check is array lengths are equal
//                    throw new Exception("Arrays are not of same length. Cannot compute composition."); //throws exception
//
//                int[] compositionArray = composition(array1, array2); //makes new composition array with method
//
//                System.out.println(); //readability
//                System.out.println("The composition of both permutation arrays is:"); //Advises user what info will be provided
//                System.out.print("{"); //Array visualization
//                for(int i = 0; i < compositionArray.length; i++) //goes through each address of the array
//                    System.out.print(" " + compositionArray[i]); //prints each entry of the array
//                System.out.println(" }");//Array visualization
//
//                System.out.println(); //readability
//                flag = true; //set flag to true to exit out of loop
//            }
//                catch (Exception excpt){ //catch exeptions
//                    System.out.println(); //readability
//                    System.out.println(excpt.getMessage()); //retrieves message
//                    System.out.println("Try again."); //asks user to try again
//                }
//        }
//
//        flag = false; //sets flag back to false
//
//        //Compute inverse
//        while(flag == false){ //will loop until correct info is provided
//            try{
//                System.out.println("Okay! Let's find the inverse of a permutation array."); //Advise user what program will do
//                int[] inverseArray = readFromFile(); //sets an array to new checked file
//
//                for(int i = 0; i < inverseArray.length; i++){ //goes through each address of array
//                    if(0 > inverseArray[i] || inverseArray[i] >= inverseArray.length) //makes sure array is from 0 to length-1
//                        throw new Exception("Entries in array should be from 0 to length-1."); //throws exception
//                }
//
//                inverseArray = inverse(inverseArray); //sets array to its inverse
//
//                System.out.println(); //readability
//                System.out.println("The inverse of the array is:"); //Advises user what will be the output
//                System.out.print("{"); //Array visualization
//                for(int i = 0; i < inverseArray.length; i++) //goes through each address of the array
//                    System.out.print(" " + inverseArray[i]); //prints each entry of the array
//                System.out.println(" }"); //array visualization
//                System.out.println(); //readability
//
//                flag = true; //sets flag to true to exit out of loop
//            }
//            catch(Exception excpt){ //catch exception
//                System.out.println(excpt.getMessage()); //retrieves exception message
//                System.out.println("Try again."); //tells user to try again
//            }
//        }
//
//        flag = false; //sets flag back to false
//
//        while(flag == false){ //will loop until correct info is provided
//            try{
//                Scanner scnr = new Scanner(System.in); //new scanner
//                System.out.println("Now, let's find the power of an array k times."); ///Advise user what program will do
//                System.out.println("To what power would you like to raise the array to?"); //Asks user to input a power
//                int k = scnr.nextInt(); //retrives integer value for power
//
//                if(k == 0) //checks if power vale is 0
//                    throw new Exception("You cannot raise an array to the 0th power."); //throws exception
//
//                int[] powerArray = pow(readFromFile(), k);  //sets new array to power method readFromFile and power
//
//                System.out.println("The power of the array " + k + " times is:"); //lets user know what will be the output
//                System.out.print("{"); //array visualization
//                for(int i = 0; i < powerArray.length; i++) //goes through each address of the array
//                System.out.print(" " + powerArray[i]); //prints out each entry of the array
//                System.out.println(" }"); //array visualization
//
//                flag = true; //sets flag to true to exit out of loop
//            }
//            catch(InputMismatchException excpt){ //exception type
//                System.out.println(); //readability
//                System.out.println("Please insert an integer number."); //prints exception message
//                System.out.println("Try again."); //asks user to try again
//                System.out.println(); //readability
//            }
//            catch (Exception excpt){ //exception
//                System.out.println(excpt.getMessage()); //prints exception message
//                System.out.println(); //readability
//                System.out.println("Try again."); //asks user to try again
//
//            }
//        }
//    }
    
    /**
    *This method will ask user to input a file. Check to see if the file is valid.
    *It will call the isPermutation method, and only allow arrays that are Permutations to be returned.
    *This method takes no parameters
    *@return numArray This method will return a permutation array ready to be used
    *@throws FileNotFoundException Will ask for user file
    */
    public static int[] readFromFile(){
        
        Scanner scnr = new Scanner(System.in); //imports scanner
        
        while(true){ //will loop forever until conditions are met
            try{
                System.out.println("Please insert the path of the file:"); //asks user to input filename
        
                FileReader fr = new FileReader(scnr.next()); //import file reader
                BufferedReader textReader = new BufferedReader(fr); //import buffered reader
            
                int k = Integer.parseInt(textReader.readLine()); //reads the first integer of file
                
                String[] numbers = textReader.readLine().split(" "); //creates an array
                
                System.out.println(); //readability
                
                if(k != numbers.length) //checks if length integer and length are equal
                    throw new Exception("Length int does not match length of array."); //exception if unequal
                
                int[] numArray = new int[numbers.length]; //creates a new array of type int for length of numbers
        
                for(int i = 0; i < numbers.length; i++) //will go through each index
                    numArray[i] = Integer.parseInt(numbers[i]); //change the characters in the number array to ints and set in int array
        
                if(!isPermutation(numArray)) //will check if file provided is a permutation
                    throw new Exception("Sorry, this is not a permutation."); //exception if not permutation
                
                return numArray; //returns the number array that has be prechecked if permutation
                
            }
            catch (Exception excpt){ //catches exceptions
                System.out.println(excpt.getMessage()); //prints specific message
                System.out.println("Try again."); //Asks user to try again
            }
        }
        
    }
  
    /**
    *This method will use two for loops to calculate whether the input in an array is repetative.
    *@param A int[] This method will take an array of type int.
    *@return boolean The method will return whether the array is or is not a permutation.
    */
    public static boolean isPermutation(int[] A){
        
        for(int i = 0; i < A.length-1; i++){//Will go through each address in the array
            for(int j = i+1; j < A.length; j++){ //will check each adddress with only those in front
                if(A[i] == A[j]){ //if ever equal it is not a permutation
                    return false; //return false
                }
            }
        }
        
        return true; //return true
        
    } 
    
    /**
    *This method takes two arrays of type int as its parameters.
    *@param A This method takes an array of type int to be composed of another array
    *@param B This method takes an array of type int to be composed of another array
    *@return composition This method will return the composition of int array A of B.
    *throws Exception Arrays should be of same length (handled in the main method)
    *throws Exception Arrays can only include entries from 0 to length-1.
    */
    public static int[] composition(int[] A, int[] B){
        
        int[] composition = new int[A.length]; //creates a new array of composition 
        
        for(int i = 0; i < A.length; i++) //goes through the adresses of the arrays from 0 to length-1
            composition[i] = A[B[i]]; //sets composition to A(B(i));
            
        return composition; //returns array of composition

    }
    
    /**
    *This method will compute the inverse of an array.
    *@param A This method takes an array of type int the compute inverse.
    *@return inverse This method will return the inverse of int array A.
    *throws Exception Array can only include entries from 0 to length-1.
    */
    public static int[] inverse(int[] A){
        
        int[] inverse = new int[A.length]; //creates a new array to be returned
        
        for(int i = 0; i < A.length; i++){ //will find the address that points to 0 then 1 and so forth
            for(int j = 0; j < A.length; j++) //will go through the adresses
                if(A[j] == i) //if equal, the inverse was found
                    inverse[i] = j; //set inverse to address of according entry
        }     
        
        return inverse; //returns inverse array
            
    }
    
    /**
    *This method takes an array and an integer, k, as its parameters.
    *It makes a temporary array to help in composition which wil contain 
    *@param A This method takes an array of type int to compute itself to a power.
    *@param k This method takes an integer as the power for an array to be mulitplied to.
    *@return temp This method returns an array of tpe int that has been updated from the original array.
    */
    public static int[] pow(int[] A, int k) {
        
        if (k < 0) //if the power is negative, it will compute the inverse
            A = inverse(A); //set A to the inverse
        
        int[] temp = new int[A.length]; //creates a new temporary array to be updated
        temp = A; //sets the array to itself or its inverse if negative power
                          
        if (k == 1 || k == -1) return A; //if power is 1 or -1, it will return itself or its inverse accordingly
        else if(k < -1){ //if power is negative power loop will execute
            for(int i = k; i < -1; i++) //negative power loop
                 temp = composition(A, temp); //temporary array will be updated as necesary
        }
        else{ //else will be a positive power
            for(int i = 1; i < k; i++) //positive power loops
                 temp = composition(A, temp); //temporary array will be updated as necesary
        }
        return temp; //returns updated array
    }
            
}
    