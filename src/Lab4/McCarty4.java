//package Lab4;
//
//import Testers.LabInterfaces.Lab4Interface;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
///**
// * Created by Onyx on 7/6/2017.
// */
//
//public class McCarty4 implements Lab4Interface {
//    public ArrayList<ArrayList<ArrayList<String>>> partitian(String str) {
//        if (str.length() <= 1) {
//            ArrayList<String> set = new ArrayList<>();
//            set.add(str);
//            ArrayList<ArrayList<String>> partitian = new ArrayList<>();
//            partitian.add(set);
//            ArrayList<ArrayList<ArrayList<String>>> allPartitians = new ArrayList<>();
//            allPartitians.add(partitian);
//            return allPartitians;
//        } else {
//            ArrayList<ArrayList<ArrayList<String>>> restPartitians = partitian(str.substring(1));
//            ArrayList<ArrayList<ArrayList<String>>> tmp = new ArrayList<>();
//            ArrayList<ArrayList<String>> tmpaddelement  = new ArrayList<>();
//            ArrayList<ArrayList<String>> tmpaddset  = new ArrayList<>();
//            tmpaddelement=cloneP(restPartitians.get(0));
//            tmpaddset=cloneP(restPartitians.get(0));
//
//
//            for (int i = 0; i < tmpaddset.size() ; i++) {
//                tmpaddset.get(i).add(str.substring(0,1));
//                tmp.add(tmpaddset);
//
//            }
//
//            for (int i = 0; i <tmpaddelement.size(); i++) {
//
//                for (int j = 0; j < tmpaddelement.get(i).size(); j++) {
//                    tmpaddelement.get(i).get(j).add( str.substring(0,1));
//                }
//
//            }
//            tmp.add(tmpaddelement);
//            return tmp;
//        }
//    }
//
//
//    //TODO WAS NAMED PARTITIANS not PARTITIONS
//    public void printAllPartitions(String str) {
//        for (ArrayList<ArrayList<String>>) list : partitian(str) {
//            System.out.println(list);
//
//        }
//
//    }
//
//    public ArrayList<ArrayList<String>> cloneP(ArrayList<ArrayList<String>> clonepart) {
//        ArrayList<ArrayList<String>> C = new ArrayList<>();
//        for (ArrayList<String> set : clonepart) {
//            C.add((ArrayList<String>)set.clone());
//        }
//
//        return C;
//    }
//
//
//}