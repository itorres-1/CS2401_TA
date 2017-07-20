//package Lab3;
//
///**
//* Tanabe, Maria
//* Lab 3
//* Dr. Julio Cesar Urenda
//* Isaac Torres
//* 7/6/2017
//* Manipulate circular linked lists
//*/
//import java.io.IOException;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//class intNode {
//	public int num;
//	public intNode next;
//	public intNode(int i, intNode n) {
//		this.num = i;
//		this.next = n;
//	}
//	}
//public class Tanabe3 {
//	public static void main (String[]args) {
//		Scanner scnr = new Scanner(System.in);
//		System.out.println("Please enter the number of people: ");
//		int numOfPeople = scnr.nextInt();
//		System.out.println("Enter an elimination number: ");
//		int eliminationNumber = scnr.nextInt();
//		System.out.println("In order to survive, you must be in this position : " + survivalNumber(numOfPeople, eliminationNumber));
//	}
//	/*
//	 * This first method ensure that the inputs are valid, if they are not exceptions are thrown.
//	 * The method then makes a circular linked list with the nodes being the number of people.
//	 * Then the method elimitates people with the elimination number until one number is left, the survival number.
//	 * @param numOfPeople is the number of nodes in the linked list.
//	 * @param eliminationNumner is how often a node will be deleted.
//	 * @return Returns the last number left standing.
//	 */
//	 public static Integer survivalNumber(int numOfPeople, int eliminationNumber){
// 		try {
// 			if (eliminationNumber == 1){
// 				return numOfPeople;
// 			}
// 			if (numOfPeople < 1 || eliminationNumber < 1  ){
// 				throw new IllegalArgumentException();
// 			}
// 			if (numOfPeople != (int)numOfPeople || eliminationNumber != (int)eliminationNumber){
// 				throw new InputMismatchException();
// 			}
// 			else {
// 				intNode head = null;
// 				for (int i = numOfPeople; i >= 1; i--){
// 					head = new intNode(i, head);
// 				}
// 				intNode temp = head;
// 				while (temp.next != null) {
// 					temp = temp.next;
// 				}
// 				temp.next = head;
// 				int kill = 0;
// 				int k = 1;
// 				temp = head;
// 				while (kill != k-1 ){
// 					if (k % (eliminationNumber-1) == 0) {
// 						temp.next = temp.next;
// 						kill ++;
// 					}
// 					k++;
// 					temp = temp.next;
// 				}
// 				return temp.num;
// 			}
// 		}
// 		catch (IllegalArgumentException | InputMismatchException e) {
// 			return null;
// 		}
// 	}
//}
