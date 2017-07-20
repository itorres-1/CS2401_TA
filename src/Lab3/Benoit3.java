//package Lab3;
///**
// * Author: Jean-Maxon Benoit
// * Assignment: Lab 3
// * Instructor: Julio Urenda
// * TA: Isaac Torres
// * Last Modified 7/2/2017.
// * Purpose: Linked lists practice
// */
//
////TODO Do not print in methods which should not print
//
//class IntNode {
//    public int data;
//    public IntNode next;
//
//    /**
//     * Constructor that creates a node to be used in a linked list
//     * @param dataIn Integer value that is stored in node
//     * @param nextIn Determines what node in the linked list is after the current node
//     */
//    public IntNode(int dataIn, IntNode nextIn) {
//        this.data = dataIn;
//        this.next = nextIn;
//    }
//}
//class CLL {
//    public IntNode head;
//    public int size;
//    public int length;
//
//    /**
//     * Constructor that creates a linked list that has the last node point back to the head of the list
//     * @param n Determines the amount of nodes in the list
//     */
//    public CLL(int n) {
//        if(n > 0) {
//            head = new IntNode(++size, null);
//            IntNode current = head;
//
//            while(size < n) {
//                current.next = new IntNode(++size, null);
//                current = current.next;
//                length++;
//            }
//            current.next = head;
//        }
//    }
//    /**
//     * Deletes a node from a list given it's position and a reference to the head of the list
//     * @param head Node that is used as a reference
//     * @param pos position of node that is to be deleted
//     * @return returns the deleted node's data
//     */
//    public Integer deleteAt(IntNode head, int pos) {
//        try {
//            if (pos == 1) {             //Deletes head if position is 1
//                IntNode temp = head;
//
//                head = head.next;
//                temp.next = null;
//
//                return temp.data;
//
//            }
//
//            else {
//                IntNode previous = head; //Creates a reference to the head of the list
//
//                for (int i = 1; i < pos - 1; i++) {
//                    previous = previous.next;
//                }
//
//                IntNode current = previous.next;    //A new node is created so it can be used as a reference
//                previous.next = current.next;       //to the node that will be deleted
//                current.next = null;
//
//                return current.data;
//            }
//        }
//        catch (Exception e) {
//            return null;
//        }
//    }
//}
//public class Benoit3 {
//    /**
//     * Given a linked list of n length, deletes nodes inside of the list until one remains
//     * @param n Determines how many nodes will be in the linked list
//     * @param e Deletes every eth node
//     * @return
//     */
//    public static Integer survivalNumber(int n, int e) {
//        CLL circle = new CLL(n);
//        IntNode current = circle.head;
//
//        try {
//            if(e == 1) {                                    //returns n when e equals 1
//                System.out.println(n + " is the survivor");
//                return n;
//            }
//
//            while (circle.length > 1) {                     //loops until there is one node in the list
//                System.out.println(circle.deleteAt(current, e) + " is eliminated");
//
//                for (int i = 1; i < e; i++) {               //Once a node is deleted, moves the head(reference) up by e
//                    current = current.next;
//                }
//                circle.length = circle.length - 1;
//            }
//
//            System.out.println(current.data + " is the survivor");
//        }
//        catch (Exception ex) {
//            return null;
//        }
//
//        return current.data;
//    }
//    public static void main(String[] args) {
//        survivalNumber(15,2);
//    } //for debugging purposes only
//}
