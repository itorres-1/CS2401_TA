//package Lab3;
//
//import java.util.Scanner;
//
///**
// * Author Cesar Arturo Padron
// * 6/30/2017
// * Professor: Julio Cesar Urenda
// */
//
///**
// * intNode is the class in which we build the new nodes
// */
//class intNode {
//    public int data;
//    public intNode next;
//    public intNode(int myData, intNode myNext){
//        data = myData;
//        next = myNext;
//    }
//}
//
///**
// * The CLL class is used to build a circular linked list
// */
//class CLL {
//    intNode head = null; // head = first
//    intNode next = null; // next = last
//    intNode current = null;
//    int size = 0; // size = count
//
//    /**
//     * This is just the constructor that builds the circular linked list
//     * @param n
//     */
//    public CLL(int n) {
//        head = new intNode(++size, null);
//        intNode iterator = head;
//        while (size < n) {
//            iterator.next = new intNode(++size, null);
//            iterator = iterator.next;
//        }
//        iterator.next = head;
//    }
//
//    /**
//     * this is just a method that i created to facilitate the deletion of a desired node.
//     * @param x
//     */
//    public void delete(int x) {
//        intNode prev = head;
//        intNode curr = head.next;
//
//        while (curr.data != x) {
//            prev = curr;
//            curr = curr.next;
//
//        }
//
//        if (size == 1) {
//            head = null;
//            size--;
//        } else if (curr == head) {
//            prev.next = curr.next;
//            head = curr.next;
//            size--;
//        } else {
//            prev.next = curr.next;
//            size--;
//        }
//
//    }
//
//}
//
///**
// * This is the main class used to process josephus problem
// */
//public class Padron3 {
//
//    //TODO returned int instead of Integer
//
//    /**
//     * This method takes two non negative numbers.
//     * The first determines what is the length of the cricular linked list.
//     * The second is the elemination number. It then creates a circular linked list
//     * and determines which integer is the survivor.
//     * @param n
//     * @param e
//     * @return
//     */
//    public static Integer survivalNumber(int n, int e){
//        if(n<=0 || e<=0){
//            System.out.print("-1");
//            return -1;
//        }else {
//            try {
//                CLL suicidalfools = new CLL(n);
//                intNode h = suicidalfools.head;
//                intNode next1 = h.next;
//
//                int temp = n;
//                while (temp != 0) {
//                    for (int i = 1; i < e; i++) {
//                        h = h.next;
//                        next1 = h.next;
//                    }
//                    suicidalfools.delete(h.data);
//                    h = h.next;
//                    next1 = next1.next;
//                    temp--;
//
//                }
//                return h.data;
//            }
//            catch (Exception a){
//                return -1;
//            }
//        }
//
//    }
//}
//
