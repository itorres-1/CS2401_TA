//package Lab4;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
///**
// * Created by samur_000 on 7/11/2017.
// */
//public class Bennett4 {
//
//    public ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
//        if (str.length() <= 1) {
//            //Create set
//            ArrayList<String> set = new ArrayList<>();// ( )
//            set.add(str);// ("1") of course, assuming str = "1"
//            //Create partition
//            ArrayList<ArrayList<String>> partition = new ArrayList<>(); // { }
//            partition.add(set);// { ( "1" ) }
//            //Create all partitions
//            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
//            allPartitions.add(partition);
//            return allPartitions;
//        }
//        else{
//          ArrayList<ArrayList<ArrayList<String>>> previousAllPartitions = partition(str.substring(1));
//          ArrayList<ArrayList<ArrayList<String>>> newAllPartitions = new ArrayList<>();
//          for(int i = 0; i < previousAllPartitions.size();++i){
//              ArrayList<ArrayList<String>> newPartition = clonePartition(previousAllPartitions.get(i));
//              ArrayList<String> newSet = new ArrayList();
//              newSet.add(str.substring(0,1));
//              newPartition.add(newSet);
//              newAllPartitions.add(newPartition);
//             // previousAllPartitions.get(0).add(newSet);
//          }
//        }
//
//
//    }
//    public ArrayList<ArrayList<String>> clonePartition(ArrayList<ArrayList<String>> cloneePartition){
//        ArrayList<ArrayList<String>> clone = new ArrayList<>();
//        for (ArrayList<String> set: cloneePartition){
//            clone.add((ArrayList<String>) set.clone());
//        }
//        return clone;
//    }
//
//}
//    {
////your code goes here
//
//        public void printAllPartitions (String str);
//            for (int i=1; i<=max && i <= str; i++){
//                printAllPartitions(str -i,i,i + " ");
//        }
//
//    }
