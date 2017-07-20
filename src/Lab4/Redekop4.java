package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;

public class Redekop4 implements Lab4Interface {

    public static void main(String[] args) {
        Redekop4 classInstance = new Redekop4();
        classInstance.printAllPartitions("4321");
    }

    /**
     * This method, given a string, returns all possible partitions of that
     * string and returns them as a triply ne
     * @param str
     * @return ArrayList<ArrayList<ArrayList<String>>>
     */
    public ArrayList<ArrayList<ArrayList<String>>> partition(String str) {

        if (str.length() == 1) {
            ArrayList<String> element = new ArrayList<>(); //picture creates a container ( )
            element.add(str); //add string to container Ex:("1")
            ArrayList<ArrayList<String>> partition = new ArrayList<>(); //picture here is { } 
            partition.add(element); //Now it looks like {(1)}
            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>(); //creates [{ }]
            allPartitions.add(partition); // [{(1)}]
            return allPartitions;
        } else {
            ArrayList<ArrayList<ArrayList<String>>> prevAllPartitions = partition(str.substring(1));
            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>(); //creates space for solutions [{()}]
            //for each partition in simpler solution, create an array list that creates a string

            //creates a set: (n)
            String newChar = str.substring(0, 1);

            for (int i = 0; i < prevAllPartitions.size(); i++) {
                for (int j = 0; j < prevAllPartitions.get(i).size(); j++) {
                    ArrayList<ArrayList<String>> partitionClone = clonePartition(prevAllPartitions.get(i));
                    partitionClone.get(j).add(newChar);
                    allPartitions.add(partitionClone);
                }
                ArrayList<ArrayList<String>> partitionClone = clonePartition(prevAllPartitions.get(i));
                ArrayList<String> newSet = new ArrayList<>();
                newSet.add(newChar);
                partitionClone.add(newSet);
                allPartitions.add(partitionClone);
            }
            return allPartitions;
        }
    }

    /**
     * This method creates and returns a clone of a doubly nested ArrayList of a string
     * @param clonee
     * @return
     */
    public ArrayList<ArrayList<String>> clonePartition(ArrayList<ArrayList<String>> clonee) {
        ArrayList<ArrayList<String>> clone = new ArrayList<>();
        for (ArrayList<String> set : clonee) {
            clone.add((ArrayList<String>) set.clone());
        }
        return clone;
    }

    /**
     * This method prints out each partition of all partitions of a string
     * @param str the string representing a set of characters
     */
    public void printAllPartitions(String str) {
        for (ArrayList<ArrayList<String>> partition : partition(str)) {
            System.out.println(partition);
        }
    }
}

