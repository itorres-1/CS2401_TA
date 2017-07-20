//package Lab3;
///**
// * @author Monique Deitrick
// * Lab3
// * Instructor: J.Urenda
// * T.A.: I. Torres
// * Last Modified : 07/05/2017
// */
//
///**
// * Each intNode element has two features, the data, and the reference to the next node.
// * the last node will have a reference to null.
// * head is a reference to the first node. if the list is empty head is null.
// */
//
//class intNode {
//
//    /*Constructors*/
//
//    int data;
//    intNode next;
//
//    public intNode() {
//
//        data = 0;
//        next = null;
//    }
//
//    public intNode(int newVictim) {
//
//        data = newVictim;
//        next = null;
//    }
//
//    public intNode(int newVictim, intNode nextV) {
//
//        data = newVictim;
//        next = nextV;
//    }
//
//    public String toString() {
//
//        return String.valueOf(data);
//    }
//}
//
//class CLL {
//
//    /*Constructors*/
//
//    intNode head = null;
//    int size = 0;
//
//    public CLL() {
//    }
//
//    public CLL(int n) {
//        if (n > 0) {
//            head = new intNode(++size, null);
//            intNode victim = head;
//            while (size < n) {
//                victim.next = (new intNode(++size, null)); //fill the list
//                victim = victim.next;
//            }
//            victim.next = head; //points the end of the list to the front of the list.
//        }
//    }
//
//
//    /**
//     * Not currently working the way it should.
//     * Should delete the node based on the steps.
//     *
//     * @param n
//     * @param steps
//     */
//    public int remove(int n, int steps) {
//        // First check if k is between 1 and n to guarantee we won't fall off
//        if (size == 0) {
//            head = new intNode(1, null);
//            head.next = head;
//            size = 1;
//        } else {
//            intNode tmp = head;
//            while (size > 1){
//                intNode t1, t2 = head;
//                for (int i = 1; i < steps; ++i){
//                    t1 = t1.next;
//                }
//            }
//        }
//        return head.data ;
//    }
//}
//
//
//public class Deitrick3 {
//
//    /**
//     *
//     * Method which if working would take in the size of the list n and
//     * the number of steps it would take to eliminate a person from a
//     * circular linked list.
//     *
//     * @param n
//     * @param steps
//     * @return
//     */
//    public static int survivalNumber(int n, int steps) { //int
//
//       CLL suicidalFools = new CLL(n);
//       return suicidalFools.remove(n, steps);
//
//    }
//}