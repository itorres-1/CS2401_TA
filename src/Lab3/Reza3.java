//package Lab3;
//
//import java.util.*;
///**
// * CS2401: Elementary Data Structures and Algorithms
// * Instructor: Julio Urenda
// * Teaching Assistant: Isaac Torres
// * Assignment: Lab 3
// * Modified and submitted by: Raul Reza
// * Last modification: 7/5/2017
// * Purpose: Calculates who is going to survive when you input the number of people in a circle and the number that is going to be the factor of elimination.
// */
//
///**
// *IntNode class
// */
//class IntNode{
//    public int data;
//    public int position;
//    public IntNode next;
//
//    /**
//     *Defining the IntNode class
//     * @param data returns this.data
//     * @param next returns this.next
//     */
//    public IntNode(int data, IntNode next){
//        this.data = data;
//        this.next = next;
//    }
//
//    /**
//     *Getter for Next
//     * @return next
//     */
//    public IntNode getNext(){
//        return next;
//    }
//
//    /**
//     *Getter for Data
//     * @return data
//     */
//    public int getData(){
//        return data;
//    }
//
//    /**
//     * Setter for Next
//     * @param next returns this.next
//     */
//    public void setNext(IntNode next){
//        this.next = next;
//    }
//
//    /**
//     * Setter for Data
//     * @param data returns this.data
//     */
//    public void setData(int data){
//    	this.data = data;
//    }
//}
//
///**
// * Circular Linked List class
// */
//class CLL{
//	public IntNode head ;
//    public IntNode tail ;
//    public int  length;
//
//    /**
//     * Defining the Circular Linked List class
//     */
//    public CLL(){
//    	head = null;
//    	tail = null;
//    	length = 0;
//    }
//
//    /**
//     * isListEmpty determines if head is null
//     * @return boolean true if head is null
//     */
//    public boolean isListEmpty(){
//        return head == null;
//    }
//
//    /**
//     * Getter for Length
//     * @return length
//     */
//    public int getLength(){
//        return length;
//    }
//
//    /**
//     * insertAsHead inserts a node at the head of the linked list
//     * @param val integer
//     */
//    public void insertAsHead(int val){
//        IntNode pointer = new IntNode(val,null);
//        pointer.setNext(head);
//        if(head == null){
//            head = pointer;
//            pointer.setNext(head);
//            tail = head;
//        }
//        else{
//            tail.setNext(pointer);
//            head = pointer;
//        }
//        length++ ;
//    }
//
//    /**
//     * insertAsTail inserts a node at the end of the list
//     * @param val integer
//     */
//    public void insertAsTail(int val){
//        IntNode pointer = new IntNode(val,null);
//        pointer.setNext(head);
//        if(head == null){
//            head = pointer;
//            pointer.setNext(head);
//            tail = head;
//        }
//        else{
//            tail.setNext(pointer);
//            tail = pointer;
//        }
//        length++ ;
//    }
//
//    /**
//     * delete deletes a node from the list
//     * @param place integer
//     */
//    public void delete(int place){
//        if (length == 1 && place == 1){
//            head = null;
//            tail = null;
//            length = 0;
//            return ;
//        }
//        if (place == 1){
//            head = head.getNext();
//            tail.setNext(head);
//            length--;
//            return ;
//        }
//        if (place == length){
//            IntNode h = head;
//            IntNode t = head;
//            while (h != tail){
//                t = h;
//                h = h.getNext();
//            }
//            tail = t;
//            tail.setNext(head);
//            length --;
//            return;
//        }
//        IntNode pointer = head;
//        place-- ;
//        for (int i = 1; i < (length - 1); i++){
//            if (i == place){
//                IntNode temp = pointer.getNext();
//                temp = temp.getNext();
//                pointer.setNext(temp);
//                break;
//            }
//            pointer = pointer.getNext();
//        }
//        length-- ;
//    }
//
//    public Integer initiateSuicideSequence(int e){
//
//    }
//}
//
//
//public class Reza3 {
//    /**
//     * Main method was just used for testing
//     * @param args arguments
//     */
//   /* public static void main (String [] args){
//        System.out.print("Please enter the number of people: ");
//        Scanner scnr = new Scanner(System.in);
//        int people = scnr.nextInt();
//        System.out.print("Please enter the number to be skipped: ");
//        int skip = scnr.nextInt();
//        int survivor = survivalNumber(people,skip);
//        if(survivor != 0)
//            System.out.println("The survivor is "+survivor);
//        scnr.close();
//    }*/
//
//    /**
//     * survivalNumber asks for the number of people in the circle, and the number of people is going to skip during the elimination process
//     * @param n integer number of people in the circle
//     * @param e integer number of skips during the elimination process
//     * @return value of the survivor
//     */
//    public static Integer survivalNumber(int n, int e){
//        if (n <= 0 || e <= 0){
//            System.out.print("ERROR:No people in list.");
//            return null;
//        }
//        else if (e > n){
//            System.out.print("ERROR:Number of skips is greater than people.");
//            return null;
//        }
//        else{
//            CLL circle = new CLL();
//            for(int i = 0; i < n; i++){
//            	circle.insertAsTail(i+1);
//            }
//            while(circle.length != 1){
//            	for(int j = 1; j < e; j++){
//                		IntNode holder = circle.head;
//                		circle.delete(1);
//                		circle.insertAsTail(holder.getData());
//                	}
//            	System.out.println("Deleted:" + circle.head.getData()+"\n");
//            	circle.delete(1);
//            }
//            return circle.head.getData();
//        }
//    }
//}
