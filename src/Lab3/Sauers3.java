//package Lab3;
//
///**
//* 	Phillip Sauers
//*	CS2401 Lab Assignment 3
//*	7/3/17
//**/
//
////TODO -5 points in correctness for not naming lab correctly
////TODO -5 points in correctness for not using correct method signature
////TODO -5 points in robustness for not returning correct value for errors
//
//class intNode{
//    public int data;
//	public intNode next;
//
//	public intNode(int myData, intNode myNext) {
//		data = myData;
//		next = myNext;
//	}
//
//	public static void printList(intNode head) {
//		intNode curr = head;
//		while (curr.next != null) {
//			System.out.print(curr.data + ", ");
//			curr = curr.next;
//		}
//		System.out.println(curr.data);
//	}
//
//	public static int getLength (intNode head) {
//		int currLength = 0;
//		intNode curr = head;
//		while (curr != null) {
//			currLength++;
//			curr = curr.next;
//		} return currLength;
//	}
//
//	public static intNode append(intNode head, int newElem) {
//		if (head == null) {
//			return new intNode(newElem, null);
//		} else {
//			intNode curr = head;
//			while (curr.next != null) {
//				curr = curr.next;
//			} curr.next = new intNode(newElem, null);
//		} return head;
//	}
//
//	public static intNode delete(intNode head, int element) {
//		intNode curr = head;
//		if (head.data == element) {
//			intNode temp = curr;
//			head = curr.next;
//			temp = null;
//			return head;
//		} else {
//			while (curr.next.data != element) {
//				curr = curr.next;
//			}intNode temp = curr.next;
//			curr.next = curr.next.next;
//			temp.next = null;
//			return head;
//		}
//	}
//}
//public class Sauers3{
//
//	/**
//	* Given the total number of people, created a linked list of that length.
//	* @param numPeople 	the length of the created linked list.
//	* @return 			reference to head of created linked list.
//	*/
//	public static intNode createList(int numPeople) {
//		intNode n = new intNode(1, null);
//		for (int i = 1; i < numPeople; i++) {
//			try{
//				intNode.append(n, i+1);
//			}catch (Exception e) {
//				System.out.println("Error adding element to list." + e.getMessage());
//				System.out.println("Error stats: value of n: " + n.data + ", value of i: " + i);
//			}
//		} return n;
//	}
//
//	/**
//	* Removes the node representing the person eliminated.
//	* @param numPeople 	the length of the created linked list.
//	* @param counter 	the counter used in order to denote which node to delete.
//	* @param numElim	the elimination number.
//	* @return 			reference to head of modified linked list.
//	*/
//	public static intNode eliminate(intNode head, int counter, int numElim) {
//		intNode curr = head;
//		while(curr.next != null) {
//			if (counter == numElim) {
//				intNode temp = curr;
//				curr = curr.next;
//				try{
//					head = intNode.delete(head, temp.data);
//					counter = 1;
//				}catch (Exception a) {
//					System.out.println("ERROR!" + a.getMessage());
//					System.out.println(temp.data + " was not deleted!");
//				}
//			} else {
//				counter++;
//				curr = curr.next;
//			}
//		}if (intNode.getLength(head) > 1) {
//			if (counter == numElim) {
//				intNode temp = curr;
//				curr = head;
//				try{
//					intNode.delete(head, temp.data);
//					counter = 1;
//				}catch (Exception a){
//					System.out.println("ERROR!" + a.getMessage());
//					System.out.println(temp.data + " was not deleted!");
//				}
//				return eliminate(head, counter, numElim);
//			} else {
//				return eliminate(head, counter + 1, numElim);
//			}
//		} else {
//			return head;
//		}
//	}
//
//	/**
//	* Calls both of the above methods in order to create and populate the linked list and then send it through the elimination method.
//	* @param numPeople 	the number of people represented by nodes in the linked list.
//	* @param numElim	the elimination number.
//	* @return 			reference to head of created linked list, or -1 in case of an input error.
//	*/
//    public static Integer survivalNumber(int numPeople, int numElim){
//
//		try{
//			intNode newListHead = createList(numPeople);
//			intNode retNode = eliminate(newListHead, 1, numElim);
//			return retNode.data;
//		}catch (Exception NumberFormatException) {
//			System.out.println(numPeople + " is not a number value!");
//		}return -1;
//	}
//
//	public static void main(String[] args) {
//
//		System.out.println(survivalNumber(-1,2));
//		System.out.println(survivalNumber(5,-2));
////		System.out.println(survivalNumber(-2,-2));
//	}
//}