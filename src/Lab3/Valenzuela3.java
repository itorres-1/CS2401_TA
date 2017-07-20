//
//package Lab3;
//
///**
// * Author: Cesar Valenzuela
// * Date: 6/28/2017
// * Course: CS 2401
// * Assignment: Lab 3
// * Instructor: Julio C. Urenda
// * T.A: Isaac Torres
// */
//
//
//class IntNode{
//    int data;
//    IntNode next;
//
//    public IntNode(int myData, IntNode myNext){
//        data = myData;
//        next = myNext;
//    }
//}
//class CLL{
//    IntNode head = null;
//    IntNode tail = head;
//    int size = 0;
//
//    public CLL(int n){
//        if(n > 0){
//            head = new IntNode(++size,null);
//            IntNode iterator = head;
//            while( size < n){
//                iterator.next = new IntNode(++size, null);
//                iterator = iterator.next;
//            }
//            iterator.next = head;
//        }
//    }
//
//    /**
//     * Method to display the data within nodes in circular Linked List
//     * printer reference cycles through each node and prints the data currently in the node
//     */
//    public void display(){
//        IntNode printer = head;
//        while(printer.next != head){
//            System.out.print(printer.data + " -> ");
//            printer = printer.next;
//        }
//        System.out.print(printer.data + " \n");
//
//    }
//}
//public class Valenzuela3 {
//    /**
//     * Method takes an int n to set a circular linked list the size of n,
//     * and uses int e to delete corresponding nodes within that circular linked list
//     *
//     * @param n The number of nodes to be within the linked list
//     * @param e The number that determines which nodes will be eliminated
//     * @return returns an int that represents the data of the node left
//     */
//    public static Integer survivalNumber(int n, int e){
//        if(n < 2){
//            System.err.print("Not enough soldiers");
//        }else{
//            CLL SG = new CLL(n);
//            SG.tail = SG.head;
//            if (e < 2 || e >= n) {
//                System.err.print("Soldiers want to avoid killing themselves.");
//                return null;
//            } else {
//                while (n != 1) {
//                    SG.display();
//                    for (int i = 1; i < e; i++) {
//                        SG.head = SG.head.next;
//                    }
//                    SG.tail.next = SG.head.next;
//                    SG.head = SG.tail.next;
//                    n--;
//                    SG.tail = SG.head;
//                }
//                return SG.head.data;
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//    }
//}
