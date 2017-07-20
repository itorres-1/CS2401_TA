package Lab4;/* Name: Eduardo A. Jimenez Todd        */
/* Assignment: Lab 4                    */
/* Instructor: Dr. Julio Cesar Urenda   */
/* T.A.: Isaac Torres                   */
/* Last Modification: 7/12/2017         */
/* Purpose: ArrayLists                  */

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;
/**This class creates all partitions with all characters from a given string
*@author Eduardo Jimenez Todd
*
*/
public class JimenezTodd4 {
	public static ArrayList<ArrayList<ArrayList<Character>>> allPartitions = new ArrayList<ArrayList<ArrayList<Character>>>();
	public static ArrayList<ArrayList<Character>> partition = new ArrayList<ArrayList<Character>>();
    public static ArrayList<Character> element = new ArrayList<Character>();
	public static String partString, str="";
	public static String[] a1 = new String[]{"1","2","3","4","5","6","7","8","9"};
	public static String[] eachPartString;
//	/**
//	*This class calls all necessary methods in order to create the partitions
//	*@param partString The string you want to partition
//	*/
	public static void main (String[] args){
		partString="A1B3";
		int n = partString.length();
		nPr(str,0,n,n);
		for (int i=1;i<allPartitions.size()-2;i++)
			for (int j=i+1;j<allPartitions.size()-1;j++)
				if (allPartitions.get(i).size() > allPartitions.get(j).size()){
					ArrayList<ArrayList<Character>> temp = allPartitions.get(j);
					allPartitions.set(j,allPartitions.get(i));
					allPartitions.set(i,temp);
				}
		String[] strArray=new String[allPartitions.size()];
		for (int i=0;i<allPartitions.size();i++){
			String strPart="";
			StringBuilder sb = new StringBuilder();
			for (int j=0;j<allPartitions.get(i).size();j++){
				for (int k=0;k<allPartitions.get(i).get(j).size();k++){
					sb.append(allPartitions.get(i).get(j).get(k));
					strPart=strPart+sb.toString();

				}
				strPart=strPart+" ";
			}
			strArray[i]=strPart;
		}
		for(int i=1;i<strArray.length-2;i++)
			for (int j=i+1;j<strArray.length-1;j++)
				if (strArray[i].equals(strArray[j]))
					strArray[j]="";

		for(int i=0;i<allPartitions.size();i++){
			if (!strArray[i].equals(""))
				System.out.println(allPartitions.get(i));
		}
	}
	/**
	*This method is used to create all permutations with the characters in the given string
	*@param str Recieves the string to do its permutation
	*@param n1 Sends an integer to know when to stop the permutation
	*@param n2 Recieves the items to order
	*@param r Recieves the spaces to order
	*/
	public static void nPr(String str,int n1,int n2,int r) {
		if (r==0)permutation("",str);
		else
			for (int i = n1;i<n2;i++)
				nPr(str.concat(a1[i]),i+1,n2,r-1);
	}
	/**
	*This method is an extension of nPr
	*@param pre Recieves the previously permutated string
	*@param str Recieves the remaining string
	*/
	private static void permutation(String pre, String str) {
		int n = str.length();
		if (n==0){

			//START

			ArrayList<ArrayList<Character>> partition = new ArrayList<ArrayList<Character>>();
			int[] intArray = new int[pre.length()];
			for(int i=0;i<pre.length();i++)
				intArray[i] = Character.getNumericValue(pre.charAt(i));
			int x=0;
			int y=0;
			while (x<pre.length()){
				ArrayList<Character> element = new ArrayList<Character>();
				while (x<pre.length()-1&&intArray[x]<intArray[x+1]){
					element.add(partString.charAt(intArray[x]-1));
					x++;
				}
				element.add(partString.charAt(intArray[x]-1));
				partition.add(element);
				x++;
				y++;
			}
			//sort partitions
			for(int i=0;i<y;i++)
				for(int j=0;j<y-1;j++)
					if (partition.get(j).get(0)>partition.get(j+1).get(0)){
						ArrayList<Character> temp = partition.get(j);
						partition.set(j,partition.get(j+1));
						partition.set(j+1,temp);
					}
			allPartitions.add(partition);

			//END

		}
		else
			for (int i=0;i<n;i++)
				permutation(pre+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
	}
}

