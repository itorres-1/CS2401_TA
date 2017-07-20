package Lab1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author Cesar Arturo Padron
 * 6/19/2017
 * Professor: Julio Cesar Urenda
 */
public class Padron {
    /**
     * Within the main method it calls on the other methods to run the method.
     * @param args
     */
//    public static void main(String[] args){
//        isPermutation(readFromFile());
//        comp(readFromFile(),readFromFile());
//        inverse(readFromFile());
//        power(readFromFile(), getNumber());
//    }

    /**
     * The readFromFile reads the file given by the user. this then keeps looping until the file meets the requirements.
     * Finally it returns an array with the given permutation of type int.
     * @return
     */
    public static int[] readFromFile() {
        Scanner scnr = new Scanner(System.in);
        System.out.print("File path: ");
        FileReader fr;
        BufferedReader br;
        Boolean SuccessFileRead = false;
        String[] intStrings = new String[0];
        while (!SuccessFileRead) {
            try {
                fr = new FileReader(scnr.nextLine());
                br = new BufferedReader(fr);
                int k = Integer.parseInt(br.readLine());
                intStrings = new String[k];
                intStrings = br.readLine().split(" ");
                SuccessFileRead = true;
            } catch (FileNotFoundException e) {
                SuccessFileRead = false;
                System.out.println("File Not Found");
            } catch (IOException e) {
                SuccessFileRead = false;
                System.out.println("Something went wrong");
            }

        }
        int[] m = new int[intStrings.length];
        for (int i = 0; i < m.length; i++) {
            m[i] = Integer.parseInt(intStrings[i]);
        }

        return m;
    }

    /**
     * It takes in the an array of type integer and determines if it is a permutation
     * @param a
     * @return
     */
    public static boolean isPermutation(int [] a){
        boolean valid = false;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (i != j && a[i] == a[j]) {
                        System.out.println("It is not a Permutation");
                        return false;
                    }
                }
            }
        System.out.println("It is a Permutation");
        return true;
    }

    /**
     * This method takes in two different(or same) arrays and computes their composition.
     * @param a
     * @param b
     * @return
     */
    public static int[] composition(int[] a, int[] b){
        int[] c = new int[a.length];
        for(int i = 0; i<a.length; i++) {
             c[i] = a[b[i]];

        }
        System.out.print("The composition of the two arrays is:");
        for(int i = 0;i < c.length;i++){
            System.out.print(c[i] + " ");
        }
        System.out.println();
        return c;
    }

    /**
     * It takes an permutation array and reverses it.
     * @param a
     * @return
     */
    public static int[] inverse(int[] a){
        int[] c = new int[a.length];
        int n;
        for(int i = 0; i<a.length;i++){
            n = a[i];
            c[n] = a[i];
        }
        System.out.print("The inverse of the given permutation is :");
        for(int i = 0;i < a.length;i++){
            System.out.print(c[i] + " ");
        }
        System.out.println();
        return c;

    }

    /**
     * It takes in an permutation array and a user input integer and raises the array n times.
     * @param a
     * @param n
     * @return
     */
    public static int[] pow(int [] a, int n){
        int temporal = 1;
        int[] b = new int[a.length];
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
            b[i] = a[i];
        }
        if(n==1) {
            for(int i=0;i<a.length;i++){
                System.out.print(a[i]);
            }
            return a;
        }else {
            while (temporal != n) {
                for(int i =0;i<c.length;i++) {
                    c[i] = a[b[i]];
                }
                temporal++;
                for(int i =0;i<c.length;i++){
                    a[i]=c[i];
                }

            }
            System.out.print("The permutation array raised to the given power is :");
            for (int i = 0; i < a.length; i++) {
                System.out.print(c[i] + " ");
            }
            return c;
        }
    }

    /**
     * this method is simply used to get the number for the power method
     * @return
     */
    public static int getNumber(){

        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int num = 0;
        System.out.println("Please enter a digit :");
        while(!valid) {
            try {
                num = Integer.parseInt(scan.nextLine());
                if (num<=0) throw new InputMismatchException("No negative Numbers!");
                else valid = true;

            }
            catch(InputMismatchException e){
                System.out.print(e.getMessage());
                valid = false;

            }
            catch(NumberFormatException q){
                System.out.println("No letters or negative numbers");
                valid = false;
            }
        }
        return num;

    }
    

}
