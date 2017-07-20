package Lab4;

import Testers.LabInterfaces.Lab4Interface;
import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;

/**
 * Author Cesar Arturo Padron
 * 7/6/2017
 * Professor: Julio Cesar Urenda
 */
public class Padron4 implements Lab4Interface {
//    public static void main(String[] Args){
//        ArrayList<ArrayList<ArrayList<String>>>a = partition("123");
//        for (ArrayList<ArrayList<String>> partitionss: a) {
//            System.out.println(partitionss); //note that "partition" is just a place holder variable which I could have named "thing" if I wanted.
//        }
//
//    }
    public  static ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
            if (str.length() <= 1) {
                ArrayList<String> set = new ArrayList<>();//Create set
                set.add(str);
                ArrayList<ArrayList<String>> partition = new ArrayList<>();//Create partition
                partition.add(set);
                ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();//Create all partitions
                allPartitions.add(partition);
                return allPartitions;
            }
            else {
                //AL<AL<AL<S>>> prevallp = partition(str.substring(1)
                //for(int i = 0;i<p.size();i++){p.get(i)}
                //your code goes here

                ArrayList<ArrayList<ArrayList<String>>> simplerAllPartitions= partition(str.substring(1));
                ArrayList<ArrayList<ArrayList<String>>> newAllPartitions = new ArrayList<>();

                for(int i = 0; i< simplerAllPartitions.size();i++){

                    ArrayList<ArrayList<String>> currentPartitionClone = clonePart(simplerAllPartitions.get(i));

                    ArrayList<String> newSet = new ArrayList<>();

                    newSet.add(str.substring(0,1));

                    currentPartitionClone.add(newSet);

                    newAllPartitions.add(currentPartitionClone);
                    for (ArrayList<ArrayList<String>> m : simplerAllPartitions){
                        for (ArrayList<String> n : m){
                            n.add(str.substring(0,1));
                        }
                    }
                    newAllPartitions.addAll(simplerAllPartitions);


                }



                return newAllPartitions;

            }
        }
    public static ArrayList<ArrayList<String>> clonePart(ArrayList<ArrayList<String>> a){
        ArrayList<ArrayList<String>> clone = new ArrayList<>();
        for (ArrayList<String> set: a){
            clone.add(((ArrayList<String>)set.clone()));
        }
        return clone;
        }
    public void printAllPartitions(String str) {
        for (ArrayList<ArrayList<String>> partition: partition(str))
        {
            System.out.println(partition);
        }
    }
}
