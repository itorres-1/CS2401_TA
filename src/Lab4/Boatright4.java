package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;

// Lab 4
// CS2401 - Dr. Urenda - TA: Isaac Torres
// Date of last modification: 7/12/17
public class Boatright4 implements Lab4Interface {
  /**
   * This method takes a string, and returns an ArrayList of all possible partitions of that string.
   * @param str String to be partitioned
   * @return ArrayList of all partitions
   */
  public static ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
    if (str.length() <= 1) { // Base case when only one character
      ArrayList<String> set = new ArrayList<>(); // Creates set
      set.add(str); // Adds String to set
      ArrayList<ArrayList<String>> partition = new ArrayList<>(); // Creates partition
      partition.add(set); // Adds set to partition
      ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>(); // Creates list of all partitions
      allPartitions.add(partition); // Adds partition to list
      return allPartitions;
    } else {
      ArrayList<ArrayList<ArrayList<String>>> simplerAllPartitions = partition(str.substring(1)); // Recursion step
      ArrayList<String> newSet = new ArrayList<>();
      ArrayList<ArrayList<String>> newPartition = new ArrayList<>();
      ArrayList<ArrayList<ArrayList<String>>> newAllPartitions = new ArrayList<>();
      // Clone of simplerAllPartitions
      ArrayList<ArrayList<ArrayList<String>>> copyAP = new ArrayList<>(cloneAllPartitions(simplerAllPartitions));

      // Step 1: Adds newest number/character as a set to each partition of previous all partitions
      newSet.add(str.substring(0, 1)); // Initializes a set with new num/character
      for(int i=0; i<copyAP.size(); i++) {
        copyAP.get(i).add(newSet); // Adds new set to each partition in clone of previous All
      }

      // Step 2: Adds newest number/character to each individual set of previous all partitions
      for(int i=0; i<simplerAllPartitions.size(); ++i) {
        for (int j=0; j<simplerAllPartitions.get(i).size(); ++j) {
          newPartition.add(simplerAllPartitions.get(i).get(j)); // Copies sets to newPartition
          for (int k=0; k<newPartition.size(); ++k) {
            newPartition.get(k).add(str.substring(0, 1)); // Adds new value to one set in partition
            newAllPartitions.add(newPartition); // Adds partition to all
          }
          newPartition = new ArrayList<>(); // Resets newPartition
        }
      }

      // Merges to final ArrayList to be returned
      ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
      allPartitions.addAll(copyAP);
      allPartitions.addAll(newAllPartitions);

      return allPartitions;

    }
  }

  /**
   * This method deep copies a triple-nested ArrayList of type <code>String</code>
   * @param allP ArrayList to be copied
   * @return copy of allP
   */
  public static ArrayList<ArrayList<ArrayList<String>>> cloneAllPartitions(ArrayList<ArrayList<ArrayList<String>>> allP) {
    /*  FIXME */
    // Declare copy variables
    String copyStr;
    ArrayList<String> copyS = new ArrayList<>();
    ArrayList<ArrayList<String>> copyP = new ArrayList<>();
    ArrayList<ArrayList<ArrayList<String>>> copyAllP = new ArrayList<>();
    for (int i=0; i<allP.size(); i++) {
      for (int j=0; j<allP.get(i).size(); j++) {
        for (int k=0; k<allP.get(i).get(j).size(); k++) {
          copyStr = allP.get(i).get(j).get(k); // Copies string value in set
          copyS.add(copyStr); // Adds string to set
        }
        copyP.add(copyS); // Adds set to partition
      }
      copyAllP.add(copyP); // Adds partition to list
    }
    return copyAllP;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<ArrayList<String>>> AL = partition("21");

    for (ArrayList<ArrayList<String>> partition: AL) {
      System.out.println(partition);
    }
  }

  @Override
  public void printAllPartitions(String str) {
    ArrayList<ArrayList<ArrayList<String>>> AL = partition(str);

    for (ArrayList<ArrayList<String>> partition: AL) {
      System.out.println(partition);
    }
  }
}
