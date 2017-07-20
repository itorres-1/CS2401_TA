package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.*;
import java.util.ArrayList;

/**
 * Name: Gabriel Vela
 * Class: CS 2401
 * Date: July 12, 2017
 * Lab 4
 */
public class Vela4 implements Lab4Interface {


    /**
     * Takes as an argument a string and then returns all the possible partitions and sets within the partitions as a
     * array list of array list of array list.
     *
     * @param str just a string parameter that has to be passed through.
     * @return the ending result of a array list composed of array lists that has all the possible partitions for a given string.
     */
    public static ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
        if (str.length() <= 1) {
            //Create set
            ArrayList<String> set = new ArrayList<>();
            set.add(str);
            //Create partition
            ArrayList<ArrayList<String>> partition = new ArrayList<>();
            partition.add(set);
            //Create all Partitions
            ArrayList<ArrayList<ArrayList<String>>> simplerAllPartitions = new ArrayList<>();
            simplerAllPartitions.add(partition);
            return simplerAllPartitions;
        } else {
            ArrayList<ArrayList<ArrayList<String>>> allPartitions = partition(str.substring(1));
            //Creates a limit integer for all the possible partitions based on length of the string..
            int partitionLim = (int) (Math.pow(2, str.length() / 2));
            //First for loop iterates through the limit of partitions available and creates a new partition
            //for each.
            for (int i = 0; i < partitionLim; i++) {
                for (ArrayList<ArrayList<String>> set : allPartitions) {
                    ArrayList<ArrayList<String>> setcopy = clonePartition(set);
                    //Adds the nth element to a set
                    allPartitions.get(0).get(i).add(str.substring(0,1));
                    for(int j = i; j < allPartitions.get(0).get(j).size();j++){
                        allPartitions.get(0).get(j).add(setcopy.get(0).get(i));
                    }
                    //ArrayList<ArrayList<String>> partition = new ArrayList<>();
                    //Outer set denotes the actual set, that is basically added at the end of every previous
                    //set created.
                    //ArrayList<String> outerSet = new ArrayList<>();
                    //partition.add(outerSet);
                    //clonePartition(partition);
                }

            }
            return allPartitions;

        }
    }


        /**
         * The method is a cloning method used to help clone the array list that is passed through as an argument.
         *
         * @param clonee an array list of array list parameter composed of strings.
         * @return the resulting clone array list of array list.
         */
        public static ArrayList<ArrayList<String>> clonePartition (ArrayList < ArrayList < String >> clonee) {
            ArrayList<ArrayList<String>> clone = new ArrayList<>();
            for (ArrayList<String> set : clonee) {
                clone.add((ArrayList<String>) set.clone());
            }
            return clone;
        }

        /**
         * Prints all the partitions.
         *
         * @param str the string representing a set of characters
         */

    public void printAllPartitions(String str) {
        for (ArrayList<ArrayList<String>> part : partition(str)) {
            System.out.println(partition(str));
        }
    }

    public static void main(String[] args) {
        String str = "4,3,2,1";
        //printAllPartitions(str);
    }
}
