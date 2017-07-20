//package Lab3;
//
///**
// * Author: Ricardo Alvarez
// * Assignment: Lab 3
// * Instructor: Julio Urenda
// * T.A.: Isaac Torres
// * Date of Last Modification: July 5, 2017
// * Purpose: Creates a circular linked list that will remove a node every m spaces
// */
//
///**
// * Circular linked list of size N that removes a node every M space until
// * there is only one left
// */
//class CLL {
//    IntNode head = null;
//    int size = 0;
//    IntNode iter;
//
//    /**
//     * Creates a circular linked list of size N and removes a node every M space until
//     * there is only one left.
//     * @param n size of circular linked list
//     * @param m spaces between node to be removed
//     */
//    public CLL(int n, int m) {
//        if (n > 0 && m>0) {
//            head = new IntNode(++size, null);
//            iter = head;
//            while (size < n) {
//                iter.next = new IntNode(++size, null);
//                iter = iter.next;
//            }
//            iter.next = head;
//        }
//        while (iter.next!=iter) {
//            for (int i=1; i<m; i++) {
//                iter=iter.next;
//            }
//            iter.next = iter.next.next;
//        }
//        head = iter;
//    }
//}
//class IntNode {
//    int value;
//    IntNode next;
//
//    /**
//     * creates a new node containing an integer for a linked list
//     * @param a number of node
//     * @param c reference to next node
//     */
//    public IntNode(int a, IntNode c) {
//        value = a;
//        next = c;
//    }
//}
//
//public class Alvarez3 {
//    /**
//     * Creates a circular linked list that will remove a node every m spaces
//     * @param n size of linked list
//     * @param e spaces for node removal
//     * @return integer value of the surviving node
//     */
//    public static Integer survivalNumber(int n, int e) {
//        try {
//            if (n>0 && e>0) {
//                CLL a = new CLL(n, e);
//                return a.head.value;
//            }
//            else return null;
//        }
//        catch (NullPointerException exc) {
//            return null;
//        }
//    }
//    public static void main (String[] args) {
//        System.out.println("Result: " + survivalNumber (700,7));
//    }
//}
