package Lab4;
import Testers.LabInterfaces.Lab4Interface;

import java.util.*;
import java.lang.*;

//TODO Did not correctly implement interface!

public class LeonCordero4 implements Lab4Interface {

    /**
     * This method computes the partitions and classes of a string and puts them into respective data types to show
     * their relationship.
     *
     * @param str (String) This is the string that will be partitioned into all possible subsets.
     * @return allPartitions (ArrayList<ArrayList<ArrayList<String>>>) This is an array list which simulates the
     * collection of all partitions of a set. The partitions themselves are also array lists which simulate the
     * collection of classes of a subset. The classes are array lists of strings, which house the individual characters
     * of the original string parameter.
     */
    public static ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
        if(str.length() <= 1) {
            ArrayList<String> set = new ArrayList<>();
            set.add(str);

            ArrayList<ArrayList<String>> partition = new ArrayList<>();
            partition.add(set);

            ArrayList<ArrayList<ArrayList<String>>> basePartition = new ArrayList<>();
            basePartition.add(partition);
            return basePartition;
        }
        else {
            ArrayList<ArrayList<ArrayList<String>>> baseCol = partition(str.substring(1));
            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();

            for(ArrayList<ArrayList<String>> partition: baseCol) {
                ArrayList<ArrayList<String>> clonePartition = clonePartition(partition);
                ArrayList<String> newSet = new ArrayList<>();
                newSet.add(str.substring(0, 1));
                clonePartition.add(newSet);
                allPartitions.add(clonePartition);
            }

            for(ArrayList<ArrayList<String>> partition: baseCol) {
                for(int i = 0; i < partition.size(); i++) {
                    ArrayList<ArrayList<String>> clonePartition = clonePartition(partition);
                    clonePartition.get(i).add(str.substring(0,1));
                    allPartitions.add(clonePartition);
                }
            }
            return allPartitions;
        }

    }

    /**
     * Given a string, this method calls the partition method, which then returns a collection of partitions that are
     * then printed by this method.
     * @param str (String) This is the string to be partitioned.
     */
    public void printAllPartitions(String str) {
        ArrayList<ArrayList<ArrayList<String>>> allPartitions = partition(str);
        for(ArrayList<ArrayList<String>> partition: allPartitions) {
            System.out.println(partition);
        }
    }

    /**
     * This method clones a given partition by creating a new ArrayList<ArrayList<String>> element, cloning every
     * ArrayList<String> element in the partition to be cloned, and then storing them in the new partition.
     * @param basePartition (ArrayList<ArrayList<String>>) This is the partition to be cloned.
     * @return clonedPartition (ArrayList<ArrayList<String>>) This is the cloned partition.
     */
    public static ArrayList<ArrayList<String>> clonePartition(ArrayList<ArrayList<String>> basePartition){
        ArrayList<ArrayList<String>> clonedPartition = new ArrayList<>();
        for(ArrayList<String> set: basePartition) {
                clonedPartition.add((ArrayList<String>) set.clone());
        }
        return clonedPartition;
    }
}
