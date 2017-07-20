/**
 * Author: Cesar Valenzuela
 * Date: 7/5/2017
 * Course: CS 2401
 * Assignment: Lab4
 * Instructor: Julio C. Urenda
 * T.A: Isaac Torres
 */
package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;

public class Valenzuela4 implements Lab4Interface {
    /**
     * Copies partitions passed to it and returns a copy of that partition
     * @param cloney Partition to be passed and used to clone
     * @return returns the cloned partition
     */
    public static ArrayList<ArrayList<String>> copyPartition(ArrayList<ArrayList<String>> cloney) {
        ArrayList<ArrayList<String>> clone = new ArrayList<>();
        for (ArrayList<String> set : cloney) {
            clone.add(((ArrayList<String>) set.clone()));
        }
        return clone;
    }

    /**
     * Copies double nested ArrayLists, visually represented by [ [ [] ] ] and returns the copy of entire ArrayList structure
     * @param a passed ArrayList to be copied
     * @return returns a copy of the original ArrayList passed
     */
    public static ArrayList<ArrayList<ArrayList<String>>> copyAll(ArrayList<ArrayList<ArrayList<String>>> a) {
        ArrayList<ArrayList<ArrayList<String>>> aCopy = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            aCopy.add(new ArrayList<>(a.get(i)));
        }
        return aCopy;
    }

    /**
     * Recursive method that returns all configurations of partitions of the String passed into it
     * @param str String to be turned into partitions
     * @return returns the individual strings in all configurations as partitions within an ArrayList
     */
    public static ArrayList<ArrayList<ArrayList<String>>> partition(String str) {
        if (str.length() <= 1) {
            //create set
            ArrayList<String> set = new ArrayList<>();
            set.add(str);
            //create partition
            ArrayList<ArrayList<String>> partition = new ArrayList<>();
            partition.add(set);
            //create all partitions
            ArrayList<ArrayList<ArrayList<String>>> allPartitions = new ArrayList<>();
            allPartitions.add(partition);
            return allPartitions;
        } else {
            ArrayList<ArrayList<ArrayList<String>>> simplerPartition = partition(str.substring(1));
            //onePart allows access to [[1]] by itself
            ArrayList<ArrayList<String>> onePart = simplerPartition.get(0);
            ArrayList<ArrayList<String>> twoPart = new ArrayList<>();
            ArrayList<ArrayList<String>> twoAndOne = copyPartition(onePart);

            //2 and later 3 as sets or elements
            ArrayList<String> element = new ArrayList<>();
            element.add(str.substring(0, 1));

            //Copy used to insert 3 as an element for a later set
            ArrayList<String> elementCopy = new ArrayList<>();
            elementCopy.add(element.get(0));
            twoPart.add(element);
            twoAndOne.add(elementCopy);

            //Precursor building block to a later set
            //first execution ((1,2)), 2nd execution ((1,3))
            ArrayList<ArrayList<String>> set = new ArrayList<>();
            set.add(twoPart.get(0));
            set.get(0).add(0, onePart.get(0).get(0));

            //AL<AL<AL<s>>> copy of simplerPartition
            //used to obtain [1][2][3]
            ArrayList<ArrayList<ArrayList<String>>> complete12 = new ArrayList<>();
            complete12.add(0, twoAndOne);

            //Copy of [1]
            ArrayList<String> oneCopy = onePart.get(0);
            //Copy of [2]
            ArrayList<String> twoCopy = twoAndOne.get(1);


            //(1,3) (2)
            ArrayList<ArrayList<String>> set1 = new ArrayList<>();
            set1.add(twoCopy);
            set1.add(0, set.get(0));


            //(2,3) (1)
            ArrayList<ArrayList<String>> set2 = new ArrayList<>();
            ArrayList<String> set2Element = new ArrayList<>();
            set2Element.add(elementCopy.get(0));
            set2Element.add(twoCopy.get(0));
            set2.add(set2Element);
            set2.add(onePart.get(0));


            //(1,2) (3)
            ArrayList<ArrayList<String>> set3 = new ArrayList<>();
            ArrayList<String> set3Element = new ArrayList<>();
            set3Element.add(oneCopy.get(0));
            set3Element.add(twoCopy.get(0));
            set3.add(set3Element);
            set3.add(elementCopy);


            //(1,2,3)
            ArrayList<ArrayList<String>> set4 = new ArrayList<>();
            ArrayList<String> set4Element = new ArrayList<>();
            set4Element.add(oneCopy.get(0));
            set4Element.add(twoCopy.get(0));
            set4Element.add(elementCopy.get(0));
            set4.add(set4Element);


            //Adding all partitions to the outermost [0] ArrayList
            //[1][2][3] already present due to recursive call
            ArrayList<ArrayList<ArrayList<String>>> completeCopy = copyAll(complete12);
            completeCopy.add(set3);
            completeCopy.add(set1);
            completeCopy.add(set2);
            completeCopy.add(set4);


            return completeCopy;
        }
    }

//    public static void main(String[] args) {
//        printAllPartitions("321");
//    }

    /**
     * Prints the partitions created in another method
     * @param str String to be used to create partitions
     */
    public void printAllPartitions(String str) {
        for (ArrayList<ArrayList<String>> partition : partition(str)) {
            System.out.println(partition);
        }
    }
}
