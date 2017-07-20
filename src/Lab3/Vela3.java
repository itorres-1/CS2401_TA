//package Lab3;
//
///**
// * Name: Gabriel Vela
// * Class: CS 2401
// * Assignment: Lab 3
// */
//
//import java.util.*;
//import java.io.*;
//
///**
// * Manually created default class for object type IntNode. Created for the sole purpose of being to create IntNode
// * objects and manipulate them to create Linked lists, and in this case circular linked lists.
// */
//class IntNode {
//
//    public int data;
//    public IntNode next;
//
//
//    public IntNode(int data, IntNode next) {
//        this.data = data;
//        this.next = next;
//    }
//}
//
///**
// * A circular linked list class that takes full advantage of the previous IntNode class and manipulates it
// * in order to create a circular linked list of any desired length that the user wishes to have.
// */
//class CircularList {
//
//
//    IntNode head = null;
//    int size = 0;
//
//
//    /**
//     * This is the true meat of the overall Circular List class, the method that follows take in a parameter of an integer type
//     * and then initially checks with an if statement if the given parameter is indeed positive. If it is, then it goes on to
//     * execute the following bits of code the in turn give birth to a new node, and then through the use of a while loop
//     * continue to extend and populate the list until it is the desired length. At the end of it all, it set the final node to
//     * point to the head, so it is a proper circular list.
//     *
//     * @param n a basic integer that is taken as an argument in order to set the desired length for a circular list.
//     */
//    public CircularList(int n) {
//        try {
//            if (n > 0) {
//                head = new IntNode(++size, null);
//                IntNode iterator = head;
//                while (size < n) {
//                    iterator.next = new IntNode(++size, null);
//                    iterator = iterator.next;
//                }
//                iterator.next = head;
//            }
//        } catch (NullPointerException e) {
//            System.out.println("Null pointer error");
//        } catch (IllegalArgumentException e) {
//            System.out.println("The argument parameter is not correct!");
//        } catch (InputMismatchException e) {
//            System.out.println("The input is not correct!");
//        } catch (NoSuchElementException e) {
//            System.out.println("Element issue.");
//        }
//    }
//}
//
//
//public class Vela3 {
//    /**
//     * Method that is culmination of all the previous classes as well as the circular linked list method. They all come
//     * together to make a new linked list of the user's choice and then play the "elimination" game using the desired skip
//     * pattern set by the user, and finally it returns the data in the final node that is left at the very end.
//     *
//     * @param numOfPeople    An integer that is taken as an argument for the method, to set the length of the Circular Linked
//     *                       list that will be created.
//     * @param eliminationNum An integer that is taken as an argument for the method, to set the pattern in which nodes will
//     *                       essentially be "killed off" until only one remains.
//     * @return the data found in the final node, as explicitly pointed out in the method signature it will return an Integer.
//     */
//    public static Integer survivalNumber(int numOfPeople, int eliminationNum) {
//        try {
//            CircularList suicidalGroup = new CircularList(numOfPeople);
//
//            IntNode current = suicidalGroup.head;
//            IntNode tail = suicidalGroup.head;
//            IntNode end = suicidalGroup.head.next.next;
//
//            while (suicidalGroup.size > 1) {
//                for (int i = 1; i < eliminationNum; i++) {
//                    tail = current;
//                    current = tail.next;
//                    end = current.next;
//
//                }
//                current = end;
//                tail.next = end;
//                end = current.next;
//                suicidalGroup.head = current;
//                suicidalGroup.size--;
//            }
//            return suicidalGroup.head.data;
//        } catch (NullPointerException e) {
//            System.out.println("Null pointer error");
//            return null;
//        } catch (IllegalArgumentException e) {
//            System.out.println("The argument parameter is not correct!");
//            return null;
//        } catch (InputMismatchException e) {
//            System.out.println("The input is not correct!");
//            return null;
//        } catch (NoSuchElementException e) {
//            System.out.println("Element issue.");
//            return null;
//        }
//
//
//    }
//
//
//    public static void main(String[] args) {
//
//        System.out.println("Survivor #: " + " " + survivalNumber(10, 3));
//    }
//}
