package Lab4;

import java.util.ArrayList;
import java.lang.String;

public class Serrano4{

    public static void main(String[] args){
        Serrano4 classInterface = new Serrano4();
        classInterface.printAllPartitions("321");
    }


    /**
     *
     * @param str
     * @return
     */
    public ArrayList<ArrayList<ArrayList<String>>> partition(String str){

        if(str.length() == 1){      //base case
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
        }
        else{
            //compute solution to simpler case
            ArrayList<ArrayList<ArrayList<String>>> previousAllPartitions = partition(str.substring(1));
            ArrayList<ArrayList<ArrayList<String>>> newAllPartitions = new ArrayList<>();
            //create a new set to add to the clone partition

            for(int i=0; i < previousAllPartitions.size(); i++){       //fix this loop
                for(int j=0; j < previousAllPartitions.get(i).size(); j++){
                    ArrayList<ArrayList<String>> partitionClone = clonePartition(previousAllPartitions.get(i));
                    partitionClone.get(j).add(str.substring(0,1));
                    newAllPartitions.add(partitionClone);
                }
                ArrayList<ArrayList<String>> partitionClone = clonePartition(previousAllPartitions.get(i));
                ArrayList<String> newSet = new ArrayList<>(); //creates ()
                newSet.add(str.substring(0,1)); //adds first character in str to ^ newSet
                partitionClone.add(newSet);
                newAllPartitions.add(partitionClone);
            }
            return newAllPartitions;
        }//else
    }//partition method

    /***************************************************************************************/
    /**Method to clone partitions, it returns a clone of ArrayList<ArrayList<String>> type**/
    /***************************************************************************************/
    public ArrayList<ArrayList<String>> clonePartition(ArrayList<ArrayList<String>> clonee){
        ArrayList<ArrayList<String>> clone = new ArrayList<>();
        for(ArrayList<String> set: clonee){
            clone.add(((ArrayList<String>) set.clone()));
        }//for loop
        return clone;
    }//clonePartition

    /**************************************************************************************/
    /**Method to print out the partitions**/
    /**************************************************************************************/
    public void printAllPartitions(String str){
        for(ArrayList<ArrayList<String>> partition: partition(str)){
            System.out.println(partition);
        }//for loop, prints all partitions on separate line
    }//printAllPartitions
}