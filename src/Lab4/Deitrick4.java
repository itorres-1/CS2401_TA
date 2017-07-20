package Lab4;
/**
 * @author Monique Deitrick
 * Lab4
 * Instructor: J.Urenda
 * T.A.: I. Torres
 * Last Modified : 07/15/2017
 */

import java.util.ArrayList;

public class Deitrick4 {

    public static void main(String[] args) {

        String myString = "321";
        printAllPartitions(myString);

    }

    /**
     * Method for printing all partitions.
     *
     * @param str
     */
    public static void printAllPartitions(String str) {
        for (ArrayList<ArrayList<String>> partition : partition(str)) {
            System.out.println(partition);
        }
    }

    /**
     * Method which will return a clone of a partition.
     *
     * @param clonee
     * @return
     */
    public static ArrayList<ArrayList<String>> clonePartition(ArrayList<ArrayList<String>> clonee) {

        ArrayList<ArrayList<String>> clone = new ArrayList<>();
        for (ArrayList<String> set : clonee) {
            clone.add((ArrayList<String>) set.clone());
        }
        return clone;
    }

    /**
     * Recursive base case Method which returns all partitions when String length is greater than or
     * equal to 1.
     *
     * @param str
     * @return
     */
    public static ArrayList<ArrayList<ArrayList<String>>> partition(String str) {

        if (str.length() <= 1) {
//Create set
            ArrayList<String> set = new ArrayList<>();
            set.add(str);
//Create partition
            ArrayList<ArrayList<String>> partition = new ArrayList<>();
            partition.add(set);
//Create all partitions
            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
            allPartitions.add(partition);
            return allPartitions;
        } else {
/**
 * Non base case code that runs when the String is greater than 1.
 */

            ArrayList<ArrayList<ArrayList<String>>> allPrevPartitions = partition(str.substring(1));
            ArrayList<ArrayList<ArrayList<String>>> newPartitions = new ArrayList<>();


            for (ArrayList<ArrayList<String>> partition : allPrevPartitions) {
                ArrayList<ArrayList<String>> partitionClone = clonePartition(partition);
                ArrayList<String> newSet = new ArrayList<>();
                newSet.add(str.substring(0, 1));
                partitionClone.add(newSet);
                newPartitions.add(partitionClone);
            }
            for (ArrayList<ArrayList<String>> partition : allPrevPartitions) {
                for (int i = 0; i < partition.size(); ++i) {
                    ArrayList<ArrayList<String>> partitionClone = clonePartition(partition);
                    partitionClone.get(i).add(str.substring(0, 1));
                    newPartitions.add(partitionClone);
                }
            }
            return newPartitions;
        }
    }
}

