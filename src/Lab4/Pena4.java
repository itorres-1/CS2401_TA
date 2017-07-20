package Lab4; /**
 * Created by LoriPena on 7/05/17.
 * Lorianne Pena with help from Isaac Torres
 * CS 2401 Summer 2017
 * Lab 4
 */

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Pena4 implements Lab4Interface {
    /**
     * @param str takes in a String called str
     * @return at the very end of the method it returns a ArrayList of a ArrayList of a ArrayList of Strings called newAllPartitions
     * to print new all partitions.
     */
    public ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
        try {
            if (str.length ( ) <= 1) {
                //Create set
                ArrayList<String> set = new ArrayList<> ();
                set.add (str);
                //Create partition
                ArrayList<ArrayList<String>> partitions = new ArrayList<> ();
                partitions.add (set);
                //Create all partitions
                ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<> ();
                allPartitions.add (partitions);
                return allPartitions;//[[[1]]]

            } else {//else creates a new set, copy, add a number as a new set on its own. the rest you add in sets level in each partition of all partitions.
                //This next line is recursively computing all partitions of the immediately simpler case
                ArrayList<ArrayList<ArrayList<String>>> previousAllPartitions = partition (str.substring (0, str.length ( ) - 1));
                ArrayList<ArrayList<ArrayList<String>>> newAllPartitions = new ArrayList<> ();
                //New character to append is at str.substring(str.length()-1) (this is the last character in the string);

                //This is the work of the green arrows
                for (ArrayList<ArrayList<String>> partition : previousAllPartitions) {//partitions in all previous partitions
                    ArrayList<ArrayList<String>> clonedPartition = clonePartition (partition);//cloning partition array list
                    ArrayList<String> newSet = new ArrayList<> ();//creating a new array list or set
                    newSet.add (str.substring (str.length () - 1));//adding string
                    clonedPartition.add (newSet);
                    newAllPartitions.add (clonedPartition);
                }
                //This is the work for the blue arrows
                for (int i = 0; i < previousAllPartitions.size (); i++) {//each partition in all previous partitions
                    for (int j = 0; j < previousAllPartitions.get (i).size (); j++) {//each set in each partition in all previous partitions
                        ArrayList<ArrayList<String>> partitionClone = clonePartition (previousAllPartitions.get (i));//cloning each partition in all previous partitions
                        partitionClone.get (j).add (str.substring (str.length () - 1));//adding string
                        newAllPartitions.add (partitionClone);
                    }
                }
                return newAllPartitions;
            }

        } catch (StackOverflowError a) {
            return null;
        } catch (IllegalArgumentException a) {
            return null;
        } catch (NoSuchElementException a) {
            return null;
        } catch (UnsupportedOperationException a) {
            return null;
        } catch (RuntimeException a) {
            return null;
        }
    }

    /**
     * @param cloneePartition which is a ArrayList of a ArrayList of Strings to help us create a clone method called clonePartition
     *                        to help aid us in our cloning on a deeper level then .clone can, given that .clone only clones on a shallow level.
     *                        This method can handle cloning our 3 dimensional arrayList.
     * @return returns a ArrayList of ArrayList of Strings called clone.
     */
    public ArrayList<ArrayList<String>> clonePartition(ArrayList<ArrayList<String>> cloneePartition) {//copy partitions no .clone
        try {
            ArrayList<ArrayList<String>> clone = new ArrayList<> ();
            for (ArrayList<String> set : cloneePartition) {
                clone.add ((ArrayList<String>) set.clone ());
            }
            return clone;
        } catch (ArrayIndexOutOfBoundsException a) {
            return null;
        }
    }

    /**
     * @param str the string representing a set of characters. This method prints all of our partitions and takes in a String called str.
     */
    public void printAllPartitions(String str) {
        try {
            for (ArrayList<ArrayList<String>> partition : partition (str)) {
                System.out.println (partition);
            }
        } catch (StackOverflowError a) {
            System.out.println ("error stack overflow");
        } catch (IllegalArgumentException a) {
            System.out.println ("error illegal argument");
        } catch (NoSuchElementException a) {
            System.out.println ("error no such element");
        } catch (UnsupportedOperationException a) {
            System.out.println ("error unsupported operation");
        } catch (RuntimeException a) {
            System.out.println ("error runtime");
        }
    }

    /**
     * @param args is our main where we take in characters of a String.
     */
    public static void main(String[] args) {
        try {
            Pena4 test = new Pena4 ();
            test.printAllPartitions ("12");
        } catch (StackOverflowError a) {
            System.out.println ("error stack overflow");
        } catch (IllegalArgumentException a) {
            System.out.println ("error illegal argument");
        } catch (NoSuchElementException a) {
            System.out.println ("error no such element");
        } catch (UnsupportedOperationException a) {
            System.out.println ("error unsupported operation");
        } catch (RuntimeException a) {
            System.out.println ("error runtime");
        }

    }


}