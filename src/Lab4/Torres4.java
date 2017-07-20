package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;

/**
 * Created by Andrea on 7/08/2017.
 * This lab creates all partritions for any given string.
 * lab 4 cs 2401
 */

//TODO Organize your methods better! Group relevant methods, don't have main just sandwiched between random methods
//TODO better javadoc comments as in, describe what the method does exactly i.e. This method will computes all
//TODO possible partitions of the characters of a string and returns the result as a triply nested structure where blah

public class Torres4 implements Lab4Interface {

    /**
     * THis method is used to create a deeper copy of the given arraylist of arraylist of string.
     * @param partition this is what we want copied
     * @return this is the copy.
     */
    public ArrayList<ArrayList<String>>  clonePartiion(ArrayList<ArrayList<String>> partition){
        ArrayList<ArrayList<String>> clone = new ArrayList<>();
        for(ArrayList<String> set: partition){
            clone.add((ArrayList<String>) set.clone());
        }
        return clone;
    }
    /**
     * This method is the main beef of the work. It is a recusive method that will take in a string and return an arraylist of arraylist of arraylist of strings.
     * This method is recusive and the base case was given by the Ta as well as the parameters.
     * @param str this is what we want to find the  partitions  of
     * @return this is all the partitions
     */
    ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
        if (str.length() <= 1) {
            //Create set
            ArrayList<String> set = new ArrayList<>();
            set.add(str);
            //Create partition
            ArrayList<ArrayList<String>> partition = new ArrayList<>();
            partition.add(set);
            //Create all partitions
            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
            allPartitions.add(partition);
            return allPartitions;
        } else {
            ArrayList<ArrayList<ArrayList<String>>> prevAllP = partition(str.substring(0,str.length()-1));//this should have some type of substring.//this is where we make the method recursive.
            ArrayList<ArrayList<ArrayList<String>>> newAllP = new ArrayList<>();
            ArrayList<String> lastElement = new ArrayList<String>();//this is element that is being added
            lastElement.add(str.substring(str.length()-1));
            for(int i=0;i<prevAllP.size();i++) {//fills newAllP with the previous partition and adds the set separtly // here the newAllP is adding the lastElemnt as a seprate set to the prevAllP partitions.
                newAllP.add(clonePartiion(prevAllP.get(i)));
                newAllP.get(i).add(lastElement);
            }
            for(int i=0;i<prevAllP.size();i++){//this is where the last element is added insde of the set
                for(int j=0;j<prevAllP.get(i).size();j++) {
                    ArrayList<ArrayList<String>> tempPartition = clonePartiion(prevAllP.get(i));
                    tempPartition.get(j).add(str.substring(str.length()-1));//this adds the last element into the set
                    //tempPartition.get(0)
                    newAllP.add(tempPartition);
                }
            }
            return newAllP;
        }
    }
    /**
     * This is what will be used to call for grading purposes it is expected that a string is inputed
     * and the partritions are printed from here. This method will call on the partition method.
     * @param str the string representing a set of characters
     */
    public void printAllPartitions(String str){
        //check that the string only contains posittive numbers.
        //here we should call the given partition method
        for (ArrayList<ArrayList<String>> partition: partition(str)){
            System.out.println(partition);
        }
    }

    public static void main(String args[]){
        System.out.println("HI");
        Torres4 instance = new Torres4();
        //instance.printAllPartitions("12");
        instance.printAllPartitions("12345");
    }




}
