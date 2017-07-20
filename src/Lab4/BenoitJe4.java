package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;
/**
 * Author: Jean-Maxon Benoit
 * Assignment: Lab 4
 * Instructor: Julio Urenda
 * TA: Isaac Torres
 * Last Modified 7/12/2017.
 * Purpose: To print all partitions of a string
 */
public class BenoitJe4 implements Lab4Interface {
    /**
     * Given an doubly nested arraylist, returns a clone of it
     * @param a the doubly nested arraylist that is cloned
     * @return the clone of the original arraylist
     */
    public static ArrayList<ArrayList<String>> clone(ArrayList<ArrayList<String>> a) {
        ArrayList<ArrayList<String>> newClone = new ArrayList<>();

        for (ArrayList<String> set: a) {
            newClone.add((ArrayList<String>)set.clone());
        }

        return newClone;
    }
    /**
     * Given a string, returns all possible partitions of it
     * @param str the string that will be used to generate its partitions
     * @return returns a triple nested arraylist that contains all possible partitions of str
     */
    public static ArrayList<ArrayList<ArrayList<String>>> partitions(String str) {
        if(str.length()<=1) {
            ArrayList<String> set = new ArrayList<>();
            set.add(str);

            ArrayList<ArrayList<String>> partition = new ArrayList<>();
            partition.add(set);

            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
            allPartitions.add(partition);

            return allPartitions;
        }
        else {
            ArrayList<ArrayList<ArrayList<String>>> prevAllPart = partitions(str.substring(1));
            ArrayList<ArrayList<ArrayList<String>>> solution = new ArrayList<>();
            

            for (int i = 0; i <prevAllPart.size(); i++) { //traverses through previous solution's partitions
                ArrayList<String> newSet = new ArrayList<>();
                newSet.add(str.substring(0,1));
                ArrayList<ArrayList<String>> clone = clone(prevAllPart.get(i));
                solution.add(clone);
                solution.get(i).add(newSet); //adds a set that contains str.substring(0,1) to each partition of the last solution
            }
            for (int i = 0; i < prevAllPart.size(); i++) { //traverses through previous solution's partitions
                for (int j = 0; j <prevAllPart.get(i).size(); j++) {  //traverses through each set of the partition
                    ArrayList<ArrayList<String>> clone = clone(prevAllPart.get(i));
                    clone.get(j).add(str.substring(0,1));
                    solution.add(clone);
                }
            }

            return solution;
        }
    }
    /**
     * Given a string, prints out all its partitions
     * @param str the string representing a set of characters
     */
    public void printAllPartitions(String str){
        for (ArrayList<ArrayList<String>> partition: partitions(str) ) {
            System.out.println(partition);
        }
    }
}

