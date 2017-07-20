//
//package Lab3;
//
///**
// * Created by LoriPena on 6/28/17.
// * Lorianne Pena
// * CS 2401 Summer 2017
// * Lab 3
// */
//
//import java.util.NoSuchElementException;
//
///**
// * This class IntNode is going to help us create the circular link list.Thank you to Isaac who gave us this code to
// * get us started. It was a huge help and I appreciate it.
// */
//class IntNode {
//    int data;
//    IntNode next;
//
//    IntNode(int n, IntNode e) {//default constructor
//        this.data = n;
//        this.next = e;
//    }
//}
//
//class CircularLinkList {
//    IntNode head = null;//initializing the head and setting it to null.
//    int size = 0;//initializing the size integer and setting it to 0.
//
//    /**
//     * This method helps to create the circular linked list. We factor in the issue that negative numbers may
//     * be passed so we have it start creating the list if n is greater then 0. Then we increment size and we
//     * populate the list. We keep track of the size as well. We don't return anything because we just need this
//     * method to create the circular linked list and not return anything.
//     *
//     * @param n integer name nodes.
//     */
//
//    public CircularLinkList(int n) {
//        try {
//            if (n > 0) { //if given negative integer.
//                head = new IntNode (++size, null);//++ means increment first then execute line of code
//                IntNode iterator = head;
//                while (size < n) {
//                    iterator.next = new IntNode (++size, null); //two nodes
//                    iterator = iterator.next;//update but still linear
//                }
//                iterator.next = head;//now we point it to the head making the linked list circular
//            }
//        } catch (NullPointerException a) {
//            System.out.println ("null");
//        } catch (ArithmeticException a) {
//            System.out.println ("null");
//        } catch (StackOverflowError a) {
//            System.out.println ("null");
//        } catch (NumberFormatException a) {
//            System.out.println ("null");
//        } catch (IllegalArgumentException a) {
//            System.out.println ("null");
//        } catch (NoSuchElementException a) {
//            System.out.println ("null");
//        } catch (UnsupportedOperationException a) {
//            System.out.println ("null");
//        } catch (RuntimeException a) {
//            System.out.println ("null");
//        }
//    }
//
//    /**
//     * This method is just to test if the linked list is working correctly.
//     */
//    void printList() {
//        IntNode temp = head;
//        for (int e = 0; e < size; e++) {
//            System.out.println (temp.data + " ");
//            temp = temp.next;
//        }
//
//    }
//}
//
//public class Pena3 {
//    /**
//     * This method is essentially creating a new list and having it populate with n and we then take three pointers and
//     * we use them to run through our circular link list. Curr starts by pointing at head then moves throughout the
//     * list as nodes are "killed". Pre is the node before the one that is deleted and post is the one next or after the
//     * one that will be deleted. Then curr at the time is pointed at the one that will be deleted and is moved to post
//     * since the node that curr is pointing to is "dead". It then continues on until only one node remains and is
//     * reassigned as the head. Then it returns the last node.
//     *
//     * @param n integer name number of "people" nodes.
//     * @param e integer name for number used to skip the designated number of nodes and land on the one to "kill".
//     * @return newList.head.data or the last/head node.
//     */
//    public static Integer survivalNumber(int n, int e) {
//        try {
//            if (n <= 0 || e <= 0) return null;//In case a negative integer is entered for n and e
//            CircularLinkList newList = new CircularLinkList (n);
//            IntNode curr = newList.head;//pointer 1 currently pointing to head
//            IntNode pre = newList.head;//pointer 2 to point to previous node from the one that will be removed
//            IntNode post = newList.head.next.next;//pointer 3 to point to the node that is after the one to be removed
//
//
//            while (newList.size > 1) {//while the list size is greater then 1 we start checking our circular link list
//                for (int i = 1; i < e; i++) {//iterating through the number of skips
//                    pre = curr;
//                    curr = pre.next;
//                    post = curr.next;
//                }
//                pre.next = post;
//                curr = post;
//                post = curr.next;
//                newList.head = curr;
//
//                newList.size--;
//
//                //System.out.println (" "); //testing to check if the list is correct
//                //newList.printList ( );
//
//            }
//            return newList.head.data;//At the end we are left with just one node so that becomes the new head
//        } catch (NullPointerException a) {
//            return null;
//        } catch (ArithmeticException a) {
//            return null;
//        } catch (StackOverflowError a) {
//            return null;
//        } catch (NumberFormatException a) {
//            return null;
//        } catch (IllegalArgumentException a) {
//            return null;
//        } catch (NoSuchElementException a) {
//            return null;
//        } catch (UnsupportedOperationException a) {
//            return null;
//        } catch (RuntimeException a) {
//            return null;
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//        System.out.println ("Survivor number:" + " "+ survivalNumber (10, 2));
//    }
//
//}
//
//
