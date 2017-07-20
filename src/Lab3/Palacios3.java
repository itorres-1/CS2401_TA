//package Lab3;
//
///**
// * Created by Mariel on 6/27/2017.
// * Julio Urenda
// * TA: Isaac Torres
// * LAB 3 - Josephus Problem
// */
//
//
///**
// * IntNode class has a constructor that creates a new node with an int data and reference to next node.
// */
//class IntNode {
//    //attributes
//    int data;
//    IntNode next;
//
//    //constructor
//    public IntNode(int data, IntNode next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    public IntNode() {
//    }
//
//    public void print() {
//        System.out.print(data + " ");
//    }
//}
//
///**
// * CLL class creates and modifies a circular linked list.
// */
//class CLL {
//    IntNode head = null;
//    int size = 0;
//
//    /**
//     * constructor creates circular linked list
//     * @param n is the length of the original list
//     */
//    public CLL(int n, int e) {
//        if (n > 0) { //if there are people
//            head = new IntNode(++size, null); //create a new node and name it head
//            IntNode iterator = head; //assign iterator to head
//            while (size < n) { // less than n because it creates the next node
//                iterator.next = new IntNode(++size, null);  //create  new node next to current node with data = size
//                iterator = iterator.next; //go to new node
//                //while runs again until list is complete
//            }
//            iterator.next = head; //links the last one to the head
//        }
//        //prints the list created
//        System.out.println("Circular linked list of size " + n + ":");
//        for (int i = 0; i < n; i++) {
//            head.print();
//            head = head.next;
//        }
//        System.out.println();
//        System.out.println();
//
//        //erasing
//        if (n >0) {
//            while (head.next != head && e != 1) { //so it runs until only one node left
//                for (int i = 0; i < n; i++) {
//                    IntNode current = head;
//                    for (int j = 0; j == i; j += e) {
//                        current.next = current.next.next;
//                        head = head.next;
//                        head.print();
//                    }
//                }
//            }
//            System.out.println();
//            System.out.print("The survior is: ");
//            head.print();
//            System.out.println();
//        }
//
//    }
//
//}
//
///**
// * this class is where the code is executed
// */
//
//public class Palacios3 {
//    /**
//     * this methos calls the objects from IntNode and CLL classes
//     * @param n is the total number of people
//     * @param e is the elimination number
//     * @return the number that survived (last one remaining)
//     */
//    public static int survivalNumber(int n, int e) {
//
//        CLL suicidalFools = new CLL(n, e); // new circular linked list of size n
//        IntNode newIntNode = new IntNode();
//        int head = (int) newIntNode.data;
//
//        //conditions to check for
//        if (n <= 0) { //if list is empty
//            System.out.println("List is empty or of invalid size.");
//        }
//        if (n == 1) { //if there's only one element
//            return 1;
//        }
//        if (e == 1) { //if each person dies
//            return 0;
//        }
//        return 0;
//
//        //how to convert types: IntNode to int ? casting
//        //return suicidalFools.head;
//    }
//
//    //main
//    public static void main(String[] args) {
//        System.out.print(survivalNumber(10,2 ));
//    }
//
//
//}