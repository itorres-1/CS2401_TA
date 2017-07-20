//package Lab3;
//
///*
// * Francisco Antunez
// * lab3
// */
//
//public class Antunez3 {
////	/**
////	 * main method
////	 * @param args
////	 */
////	public static void main(String[] args) {
////		int people, elim;
////
////		people = 4;
////		elim = 3;
////
////		int survivor;
////
////		survivor = survivalNumber(people, elim);
////		System.out.println(survivor);
////	}
//
//	/**
//	 * method that calls for the creation of a circular linked list, and then eliminates the nth number
//	 * until only one is left
//	 * @param n the size of the circular linked list
//	 * @param e which nth to eliminate
//	 * @throws IllegalArgumentException numbers lower than 1
//	 */
//	public static Integer survivalNumber(int n, int e) {
//		if (n < 1 || e < 1){
//			return null;
//		}
//		CLL suicidalFools = new CLL(n);
//		return suicidalFools.elim(e);
//	}
//}
//
//class IntNode {
//	int data;
//	IntNode next;
//
//	/**
//	 * create a new node
//	 * @param val the data stored
//	 * @param place the next node
//	 */
//	IntNode(int val, IntNode place){
//		data = val;
//		next = place;
//	}
//
//	/**
//	 * returns the value of a node
//	 * @return data in the node
//	 */
//	public int getNode() {
//		return data;
//	}
//}
//
//class CLL{
//	IntNode head = null;
//	IntNode tail = null;
//	int size = 0;
//
//	//this is for making the circular list
//	/**
//	 * create a circular linked list
//	 * @param n the number of nodes in the list
//	 */
//	public CLL(int n) {
//		if (n > 0){
//			head = new IntNode(++size, null);
//			IntNode iterator = head;
//			while (size < n){
//				iterator.next = new IntNode(++size, null);
//				iterator = iterator.next;
//			}
//			tail = iterator;
//			iterator.next = head;
//		}
//	}
//
//	//eliminate every k th number in list
//	/**
//	 * eliminate the kth number of the list until one is left
//	 * @param k kth number to be removed
//	 * @return return the number of the node that remains at the end
//	 */
//	//this method does not update size
//	public int elim(int k) {
//		IntNode t = head;
//		if (k == 1){
//			return tail.getNode();
//		}
//		for(int j = 1; j < size; j++){
//			for(int i = 1; i < k-1; i++){
//				t = t.next;
//			}
//			t.next = t.next.next;
//			t = t.next;
//		}
//		return t.getNode();
//	}
//}
