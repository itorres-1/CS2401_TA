//package Testers;
//
//import Lab4.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Author: Isaac Torres
// * Date: 7/5/17.
// * Course:
// * Assignment:
// * Instructor:
// * T.A:
// */
//
//
//public class Lab4Tester implements Testers.LabInterfaces.Lab4Interface {
//
//    public static ArrayList<ArrayList<String>> clonePart(ArrayList<ArrayList<String >> clonee){
//        ArrayList<ArrayList<String>> partClone = new ArrayList<>();
//        for(ArrayList<String> set: clonee){
//            partClone.add((ArrayList<String>) set.clone());
//        }
//        return partClone;
//    }
//    public static ArrayList<ArrayList<ArrayList<String>>> partition(String str){
//        if (str.length() < 2){
//            ArrayList<String> baseCaseSet = new ArrayList<>();
//            baseCaseSet.add(str);
//            ArrayList<ArrayList<String>> partition = new ArrayList<>();
//            partition.add(baseCaseSet);
//            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
//            allPartitions.add(partition);
//            return allPartitions;
//        }
//        else {
//            ArrayList<ArrayList<ArrayList<String>>> previousPartitions = partition(str.substring(0,str.length()-1));
//            ArrayList<ArrayList<ArrayList<String>>> newPartitions = new ArrayList<>();
//            //For Each
//            for (ArrayList<ArrayList<String>> partition: previousPartitions){
//                //Clone partition
//                ArrayList<ArrayList<String>> partititionClone = clonePart(partition);
//                //Create new set
//                ArrayList<String> set = new ArrayList<>();
//                set.add(str.substring(str.length()-1));
//                //Append set to partition clone
//                partititionClone.add(set);
//                newPartitions.add(partititionClone);
//            }
//            //For each For each
//            for (int i = 0; i < previousPartitions.size(); i++){
//                for (int j = 0; j < previousPartitions.get(i).size(); j++){
//                    ArrayList<ArrayList<String>> partClone =  clonePart(previousPartitions.get(i));
//                    partClone.get(j).add(str.substring(str.length()-1));
//                    newPartitions.add(partClone);
//                }
//            }
//            return newPartitions;
//        }
//    }
//    public static void printPartitions(ArrayList<ArrayList<ArrayList<String>>> allPartitions){
//        for (ArrayList<ArrayList<String>> partition: allPartitions) System.out.println(partition);
//    }
//
//
//    private static List<List<List<String>>> partitions(List<String> inputSet) {
//        //Create container for all possible partitions
//        List<List<List<String>>> allPartitions = new ArrayList<>();
//
//        if (inputSet.isEmpty()) {
//            List<List<String>> empty = new ArrayList<>();
//            allPartitions.add(empty);
//            return allPartitions;
//        }
//        else {
//
//            int limit = 1 << (inputSet.size() - 1);
//            // Note the separate variable to avoid resetting
//            // the loop variable on each iteration.
//            for (int j = 0; j < limit; ++j) {
//                List<List<String>> parts = new ArrayList<>();
//                List<String> part1 = new ArrayList<>();
//                List<String> part2 = new ArrayList<>();
//                parts.add(part1);
//                parts.add(part2);
//                int i = j;
//                for (String item : inputSet) {
//                    parts.get(i & 1).add(item);
//                    i >>= 1;
//                }
//                for (List<List<String>> b : partitions(part2)) {
//                    List<List<String>> holder = new ArrayList<>();
//                    holder.add(part1);
//                    holder.addAll(b);
//                    allPartitions.add(holder);
//                }
//            }
//            return allPartitions;
//        }
//    }
//    public void printAllPartitions(String str) {
//        String[] stringArray = str.split("");
//        for (List<List<String>> partition : partitions(Arrays.asList(stringArray))){
//            System.out.println(partition);
//        }
//
//    }
//    public static void main(String[] args) {
//        McCarty4 student =  new McCarty4();
//        String str = "A";
//
//        for (int i = 1; i <= 4; i++){
//            str += i==2?"B":i;
//            Util.titleString(str);
//            student.printAllPartitions(str);
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
