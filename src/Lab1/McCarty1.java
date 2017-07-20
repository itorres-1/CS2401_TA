package Lab1;

import com.sun.corba.se.impl.io.TypeMismatchException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Felton McCarty on 6/28/2017.
 * CS2401summer2017
 * interactive to input 2 files then displays what you entered
 * if permutation
 * inverse array
 * to the power array
 * and composition
 */
public class McCarty1 {
//    public static void main(String[] args) {
//
//        int[] a = fileArray();
//        System.out.println("second file");
//        int[] b = fileArray();
//
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]);
//            if (i == a.length - 1) {
//                System.out.println(" = first array entered");
//            }
//        }
//
//        for (int i = 0; i < b.length; i++) {
//            System.out.print(b[i]);
//            if (i == b.length - 1) {
//                System.out.println(" = second array entered");
//            }
//        }
//        System.out.println();
//        System.out.println("is file a a permutation? " + isper(a));
//        System.out.println("is file a b permutation? " + isper(b));
//        // print out / test inverse array
//        int[] inverseArray = inverse(a);
//        for (int i = 0; i < inverseArray.length; i++) {
//            System.out.print(inverseArray[i]);
//            if (i == b.length - 1) {
//                System.out.println("(Inverse array)");
//            }
//        }
//        int[] toPowerArray = power(a,3);
//            for (int i = 0; i < toPowerArray.length; i++) {
//                System.out.print(toPowerArray[i]);
//                if (i == b.length - 1) {
//                    System.out.println("(power array at 3 )");
//                }
//            }
//
//        int[] compositionArray = composition(a,b);
//        for (int i = 0; i < compositionArray.length; i++) {
//            System.out.print(compositionArray[i]);
//            if (i == compositionArray.length - 1) {
//                        System.out.println("(composition of first file using second a(b))");
//                    }
//            }
//
//
//    }// ends main


    public static Boolean isPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 || A[i] > A.length)
                return false;

            for (int j = 0; j < A.length - 1; j++) {
                if (i == j)
                    j++;
                if (A[i] == A[j])
                    return false;

            }
        }
        return true;
    }

    public static int[] reverse(int[] a) {
        int[] revArray = new int[a.length];
        int place = 0;
        for (int i = a.length - 1; i < 0; i--) {
            revArray[place] = a[i];
            place++;

        }
        return revArray;
    }

    /**
     * This method computes A composed with itself k times and returns the result
     * @param a an array that describes a permutation
     * @param k an int that denotes the number of times to compute the composition
     * @return "a" composed with itself k timesTEST
     */
    public static int[] pow(int[] a, int k) {
        int[] powerarray = a.clone();
        int place = 1;
        while (place < k) {
            powerarray = composition(a, powerarray);
            place++;
        }
        return powerarray;

    }

    public static int[] composition(int[] a, int[] b) {
        if (a.length != b.length) {
            return null;
        }
        //create new array
        int[] comparray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            comparray[i] = a[i];
        }

        for (int i = 0; i < comparray.length; i++) {
            comparray[i] = a[b[i]];
        }
        return comparray;
    }


    public static int[] inverse(int[] a) {
        // create array not to change original
        int[] inversearray = new int[a.length];
        for (int i = 0; i < inversearray.length; i++) {
            inversearray[a[i]] = i;
        }
        return inversearray;
    }


    // reads file
    public static int[] fileArray() {
        int[] arr = new int[0];
        try {
            System.out.println("Input File path: ");
            Scanner type = new Scanner(System.in);
            File fileinput = new File(type.next());
            Scanner Scn = new Scanner(fileinput);
            if (Scn.hasNext(".*[a-z].*")) {
                System.out.println("there is characters with in this file , please check file");
            }


            arr = new int[Scn.nextInt()];
            while (Scn.hasNextLine()) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Scn.nextInt();

                }
                return arr;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Reselect file");
            fileArray();
        } catch (TypeMismatchException e) {
            System.out.println("file has letters select new file ");
        }
        return arr;

    }

}
