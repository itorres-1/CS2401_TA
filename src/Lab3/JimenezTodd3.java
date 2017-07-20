//package Lab3;
//
///* Name: Eduardo A. Jimenez Todd        */
///* Assignment: Lab 1                    */
///* Instructor: Dr. Julio Cesar Urenda   */
///* T.A.: Isaac Torres                   */
///* Last Modification: 6/16/2017         */
///* Purpose: Learn to implement          */
///* LinkedLists in problem solving       */
//
//import java.util.Scanner;
//import java.io.IOException;
//
////TODO was as easy as removing "public" keyword from intNode class, as I had explained
//
//class intNode{
//    public int item;
//    public intNode next;
//
//    public intNode(int i, intNode n){
//        this.item = i;
//        this.next = n;
//    }
//}
//
///**
//*This class creates a circular Linked List with 'people' elements and eliminates the 'n'th node to the right until 1 remains
//*@author Eduardo Jimenez Todd
//*
//*/
//public class JimenezTodd3 {
//	/**
//	*This method takes the number of people and te elimintion number. It deletes the nodes until one remains and returns the surviving node
//	*@param people Number of people in the circle
//	*@param elimination Elimination nmber
//	*@return Surviving position
//	*/
//	public static int survivalNumber(int people, int elimination) {
//		//checks if input is invalid
//		if (people < 0 || elimination < 0){
//			System.out.print("Wrong input. Enter 2 positive integers. ");
//			return -1;
//		}
//
//		//returns the last element if elements are eliminated 1 by 1
//		if (elimination==1) return people;
//
//		intNode head = null;
//
//		//gives the corresponding values to the positions in the list while prepending elements
//		for (int i=people; i>=1; i--)
//			head = new intNode(i, head);
//
//		//makes the LinkedList circular
//		intNode temp = head;
//
//		while (temp.next != null)
//			temp = temp.next;
//
//		temp.next = head;
//
//		//keep count of the eliminations needed while removing the node in the elimination number
//		int eliminatons = 0;
//		int count = 1;
//		temp = head;
//		while (eliminatons != people-1 ) {
//			//deletes the element if count mod elimiation is 0 since that gies the position
//			if (count % elimination == elimination-1) {
//				temp.next = temp.next.next;
//				eliminatons++;
//			}
//			count++;
//			temp = temp.next;
//		}
//		return temp.item;
//	}
//
//	public static void main (String[]args) throws IOException{
//		boolean x=false;
//		while (!x){
//			try{
//				Scanner scnr = new Scanner(System.in);
//				System.out.print("Enter number of people: ");
//				int p = scnr.nextInt();
//				System.out.print("Enter elimination number: ");
//				int e = scnr.nextInt();
//				System.out.println("Survival number: " + survivalNumber(p, e));
//				x=true;
//			}
//			catch(Exception e){
//				System.out.println("Wrong input. Input positive integers");
//			}
//		}
//	}
//}
