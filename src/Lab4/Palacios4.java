package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;
 /**
 * Created by Mariel on 7/6/2017
  * Dr. Julio Urenda
  * TA Isaac Torres
  * Lab 4 - Partitions
 * */
public class Palacios4 implements Lab4Interface {
    /**
     *partiton method creates all possible partitions of a given string
     * @param str any given string
     * @return an ArrayList<ArrayList<ArrayList<String>>> object that contains all possible partitions
     */
    public ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
        //base case
        if (str.length() <= 1) {
            ArrayList<String> set = new ArrayList<>();
            set.add(str);
            ArrayList<ArrayList<String>> partition = new ArrayList<>();
            partition.add(set);
            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
            allPartitions.add(partition);// [{(1)}]
            return allPartitions;
        } else {
            // trace with str example: "1 2"
            ArrayList<ArrayList<ArrayList<String>>> simplerPartition = partition(str.substring(0, str.length() - 1)); //partition("1") = [{(1)}]
            ArrayList<ArrayList<ArrayList<String>>> newAllPartitions = new ArrayList<>(); // [ ]
            try {
                for (ArrayList<ArrayList<String>> partition : simplerPartition) {
                    ArrayList<ArrayList<String>> newPartition = clonePartition(partition); //clone the partition {(1)}

                    //to add string object in a new set of clone partition:  [{(1)(2)}]
                    ArrayList<String> newSet = new ArrayList<>();
                    newSet.add(str.substring(str.length() - 1));
                    newPartition.add(newSet);
                    newAllPartitions.add(newPartition); // [{(...)(2)}] add partition to all partitions

                    //now iterate through the sets of the original partition to add inside the set: [{(13)(2)}]
                    //save the size of partition first to prevent the growth affect the for loop
                    int partitionSize = partition.size();

                    for (int i = 0; i < partitionSize; i++) {
                        ArrayList<ArrayList<String>> partClone = clonePartition(partition);
                        partClone.get(i).add(str.substring(str.length() - 1));
                        newAllPartitions.add(partClone);
                    }
                }
                return newAllPartitions;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Out Of Bounds");
            }
            catch (NullPointerException e) {
                System.out.println("Null Pointer");
            }
        }
        return  null;
    }

    /**
     * A method that given a string, returns all possible partitions of that string as a triply nested
     * ArrayList
     * @param partition type ArrayList<ArrayList<String>>
     * @return an ArrayList<ArrayList<String>> object that contains the cloned sets of the given partition
     */
    public ArrayList<ArrayList<String>> clonePartition(ArrayList<ArrayList<String>> partition) {
        ArrayList<ArrayList<String>> cloned = new ArrayList<>();

        for (int i = 0; i < partition.size(); i++) {
            cloned.add((ArrayList<String>) partition.get(i).clone());
        }
        return cloned;
        /* for reference: alternate code:
        //for each loop clones each set in each partition
            for (ArrayList<String> set : partition) {
                cloned.add((ArrayList<String>) set.clone());
            }
            return cloned;
          }*/
    }

    /**
     * printAllPartitions method simply prints the partitions returned by the partition method
     * @param str input is a string that will be used to call partition method
     */
    public void printAllPartitions(String str) {
        //call the partition method in here instead of in the main (otherwise the data types don's match)
        ArrayList<ArrayList<ArrayList<String>>> print = partition(str);
        try {
             for (ArrayList<ArrayList<String>> partition : print) {
                System.out.println(partition);
             }
        }
        catch (NullPointerException e){
            System.out.println("Print Method: Null Pointer");
        }
    }
}

