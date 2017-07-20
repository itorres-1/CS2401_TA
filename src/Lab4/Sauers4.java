package Lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Sauers4 {//implements Lab4Interface{
	
	/**
   * Given the userstring, this method creates an arraylist and then passes that through the recursive method which does all of the work.
   * @param userString the user string 
   * @return nothing
   */
	public static void printAllPartitions(String userString){
		//didn't know if input would be spaced or not - didn't want to accidentally add spaces.
		ArrayList<String> passedList = createList(userString.replaceAll("\\s",""));
		for (int i = 1; i <= passedList.size(); i++) {
			ArrayList<ArrayList<ArrayList<String>>> returned = partition(passedList, i);
			if (returned.size() > 1) {
				for (ArrayList<ArrayList<String>> k : returned) {
					System.out.println(k);
				} 
			} else {
					System.out.println(returned);
			}
		}
	}
	
	/**
   * This method uses recursion in order to calculate the different permutations of sets of elements
   * @param originalList the list being passed through the method 
   * @param n the number of elements being passed through the method
   * @return ArrayList<ArrayList<ArrayList<String>>> returnList, the result of the recursive method
   */
	public static ArrayList<ArrayList<ArrayList<String>>> partition(ArrayList<String> originalList, int n) {
		ArrayList<ArrayList<String>> baseList = new ArrayList<>();
		ArrayList<String> sublistArray = new ArrayList<>();
		ArrayList<ArrayList<ArrayList<String>>> returnList = new ArrayList<>();
		if ((originalList.size() < n ) || (n < 1)) {
			return returnList;
		} else if (n == 1) {
			baseList.add(new ArrayList<>(originalList));
			returnList.add(baseList);																	
			return returnList;																			
		} else {
			ArrayList<ArrayList<ArrayList<String>>> caseNList = partition(subList(originalList), n);
			ArrayList<ArrayList<ArrayList<String>>> caseMList = partition(subList(originalList), n - 1);
			for (int i = 0; i < caseNList.size(); i++) {
				for (int j = 0; j < caseNList.get(i).size(); j++) {
					ArrayList<ArrayList<String>> tempList = new ArrayList<>();
					for (ArrayList<String> k : caseNList.get(i)) {											//Don't you just love Python-esque object iteration?
						ArrayList<String> newList = new ArrayList<>(k);
						tempList.add(newList);
					} tempList.get(j).add(originalList.get(originalList.size()-1));
					returnList.add(tempList);
				}
			} for (int i = 0; i < caseMList.size(); i++) {
				ArrayList<ArrayList<String>> tempList = new ArrayList<>(caseMList.get(i));
				sublistArray.add(originalList.get(originalList.size() - 1));
				tempList.add(sublistArray);
				returnList.add(tempList);
			}
			return returnList;																			
		}
	}
	
	/**
   * Creates a sublist from the original arraylist by removing the last element
   * @param original the arraylist being used to create a sublist
   * @return ArrayList<String> sublist the resulting sublist
   */
	public static ArrayList<String> subList(ArrayList<String> original) {
		ArrayList<String> sublist = new ArrayList<>();
		sublist.addAll(0, original);
		sublist.remove(sublist.size() - 1);
		return sublist;
	}
	
	/**
   * Given a string generates a sublist
   * @param userStr the user string used to create the list
   * @return ArrayList<String> the newly created list
   */
   public static ArrayList<String> createList(String userStr){
		ArrayList<String> elementsList = new ArrayList<String>();
		for (int i = 0; i < userStr.length(); i++) {
			elementsList.add(userStr.valueOf(userStr.charAt(i)));
		} return elementsList;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a string to partition: ");
		System.out.println("NOTE: Any spaces will be ignored!");
		String userString = input.nextLine();
		printAllPartitions(userString);
	}
}