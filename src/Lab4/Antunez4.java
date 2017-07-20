package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;

public class Antunez4 implements Lab4Interface {

///**
// * 
// */
//	public static void main(String[] args){
//		ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
//		//System.out.println(partition("abc", allPartitions));
//		for (ArrayList<ArrayList<String>> partition : partition("abc", allPartitions)) {
//			System.out.println(partition);
//		}
//		//printAllPartitions("abc"); //this should also work, but I can't call a non static method from a static method
//	}

/**
 * method that prints all partitions possible from the string passed to it
 * @param str string to be partitioned
 */

	public void printAllPartitions(String str) {
		ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
		for (ArrayList<ArrayList<String>> partition : partition(str, allPartitions)) {
			System.out.println(partition);
		}
	}

/**
 * partitions a string in every way possible and stores it in a nested ArrayList
 * @param str string to be partitioned
 * @param allPartitions holds all partitions
 * @return recursively builds up partitions
 */

	public static ArrayList<ArrayList<ArrayList<String>>> partition(String str, ArrayList<ArrayList<ArrayList<String>>> allPartitions) {
		if (str.length() == 0){
			return allPartitions;
		}

		if (allPartitions.size() == 0) { //for an empty arraylist create the nested parts
			ArrayList<String> set = new ArrayList<>();
			set.add(str.substring(0, 1));
			ArrayList<ArrayList<String>> partition = new ArrayList<>();
			partition.add(set);
			allPartitions.add(partition);
			return partition(str.substring(1), allPartitions);
		}
		else {
			ArrayList<ArrayList<String>> partition = new ArrayList<>();
			int partitionIndex = allPartitions.size();			//used for each partition clone and modify
			int setIndex;										//for each set in each partition modify clone
			int i = 0;	//partition index
			int j = 0;	//set index

			for (i = 0; i < partitionIndex; i++){
				ArrayList<ArrayList<String>> temp = clonePartition(allPartitions.get(i));
				ArrayList<ArrayList<String>> temp2 = clonePartition(allPartitions.get(i));
				ArrayList<String> element = new ArrayList<>();
				element.add(str.substring(0,1));
				allPartitions.get(i).add(element);		//add character to new element for each partition already there
				setIndex = temp.size();

				for (j = 0; j < setIndex; j++) {
					temp2 = clonePartition(temp); 		//this has to be here or one of the temp variables gets modified
					temp2.get(j).add(str.substring(0, 1));		//add character to a set of a clone
					allPartitions.add(temp2);					//merge with all partitions
				}
			}
		}
		return partition(str.substring(1), allPartitions);
	}

/**
 * clones individual partitions
 * @param orig partition to be cloned
 * @return returns a clone of the partition pased
 */

	public static ArrayList<ArrayList<String>> clonePartition(ArrayList<ArrayList<String>> orig) {
		ArrayList<ArrayList<String>> clone = new ArrayList<>();
		for (ArrayList<String> set : orig) {
			clone.add((ArrayList<String>) set.clone());
		}
		return clone;
	}
}
