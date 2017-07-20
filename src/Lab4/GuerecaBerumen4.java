package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Class that holds requiered program for lab 4.
 * Author: Jesus Guereca Berumen
 * Lab: 4
 */
public class GuerecaBerumen4 implements Lab4Interface {
	/*
	public static void main(String[] args){
		GuerecaBerumen4 a = new GuerecaBerumen4();
		a.printAllPartitions("12345");
	}
	*/
	/**
	 * Prints all partitions containing str elements
	 * @param str all elements for partitions
	 * @see Lab4Interface#printAllPartitions(java.lang.String)
	 */
	public void printAllPartitions(String str) {
		int partitionSize = str.length();
		int index = 0;
		ArrayList<ArrayList<String>> allParts = genIndexOfAllPartitions(partitionSize);
		 for(ArrayList<String> part:allParts){
			 System.out.print("[");
			 index = 0;
			 for(String Set:part){
				 for(char collection:Set.toCharArray()){
					 System.out.print(str.charAt(Character.getNumericValue(collection)-1));
				 }
				 if(index < part.size()-1)
					 System.out.print(",");
				 else
					 System.out.print("" + "");
				 index++;
			 }
			 System.out.println("] ");
		 }
	}
	
	/**
	 * Generates index for s 
	 * of size partitionSize
	 * @param partitionSize is the size of all partitions
	 * @return the array list of all partitions
	 */
	public static ArrayList<ArrayList<String>> genIndexOfAllPartitions(int partitionSize){
		//partitions
		//>collections
		//>>elements
		ArrayList<ArrayList<String>> allParts = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> tempParts = new ArrayList<ArrayList<String>>();
		ArrayList<String> tempPart = new ArrayList<String>();
		 for(int currElem= 1;currElem<= partitionSize;currElem++){
			 if(currElem <= 1){
				 allParts.add(new ArrayList<>(Arrays.asList("1")));
			 } else {
				 tempParts = new ArrayList<ArrayList<String>>();
				 for(ArrayList<String> part:allParts){
					 for(String collection:part){
						 tempPart = new ArrayList<String>();
						 tempPart.add(collection + Integer.toString(currElem));
						 for(String collection2:part){
							 if(!collection.equals(collection2)){
								 tempPart.add(collection2);
							 }
						 }
						 tempParts.add(tempPart);
					 }
					 part.add(Integer.toString(currElem));
					 tempParts.add(part);
				 }
				 allParts= new ArrayList<ArrayList<String>>();
				 allParts.addAll(tempParts);
			 }
		 }
		 return allParts;
	}

}
