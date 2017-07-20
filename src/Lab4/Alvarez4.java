package Lab4;

/**
 * Author: Ricardo Alvarez
 * Assignment: Lab 4
 * Instructor: Julio Urenda
 * T.A.: Isaac Torres
 * Date of Last Modification: July 12, 2017
 * Purpose: Prints all the possible partitions of a string
 */
import java.util.ArrayList;
import java.util.Arrays;
public class Alvarez4{
    /**
     * Creates all the partitions available out of a given string into 2D arrays
     * @param str string to be dissected
     * @return 3d arrayList containing all the possible partitions
     */
    public ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
        int length = str.length();
        ArrayList<String> set = new ArrayList<>();
        ArrayList<ArrayList<String>> clonedPartition = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();

        if (length == 1) {
            set.add(str);
            clonedPartition.add(set);
            allPartitions.add(clonedPartition);
            return allPartitions;
        }
        else {
            ArrayList<ArrayList<ArrayList<String>>> previousAllPartitions = partition (str.substring(1));
            for (int i=0; i<previousAllPartitions.size(); i++) {
                for (int j=0; j<previousAllPartitions.get(i).size(); j++) {
                    clonedPartition = clonePart(previousAllPartitions.get(i));
                    clonedPartition.get(j).add(str.substring(0,1));
                    allPartitions.add(clonePart(clonedPartition));
                }
                clonedPartition = clonePart(previousAllPartitions.get(i));
                set.clear();
                set.add(str.substring(0,1));
                clonedPartition.add(set);
                allPartitions.add(clonePart(clonedPartition));
            }
            return allPartitions;
        }
    }

    /**
     * Creates an exact copy of the partition
     * @param a partition to be cloned
     * @return cloned partition
     */
    public ArrayList<ArrayList<String>> clonePart (ArrayList<ArrayList<String>> a) {
        ArrayList<ArrayList<String>> out = new ArrayList<>();
        for (ArrayList<String> set: a) {
            out.add(((ArrayList<String>)set.clone()));
        }
        return out;
    }
    /**
     * Prints all the partitions from all the characters in a string
     * @param str string to be dissected
     */
    public void printAllPartitions (String str) {
        try {
            ArrayList<ArrayList<ArrayList<String>>> a = partition(str);
            System.out.println("out");
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < a.get(i).size(); j++) {
                    System.out.print("(");
                    for (int k = 0; k < a.get(i).get(j).size(); k++) {
                        System.out.print(a.get(i).get(j).get(k) + " ");
                    }
                    System.out.print(")");
                }
                System.out.print("\n");
            }
        }
        catch (NullPointerException a) {
            System.out.println("The string is null");
        }
    }
}

