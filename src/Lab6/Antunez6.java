package Lab6;

import Testers.LabInterfaces.Lab6Interface;

import java.util.Arrays;

public class Antunez6 implements Lab6Interface {
/**
 * node class of a generic type containing the data and pointer to the next node
 */
	static class Node<T> {
		T data;
		Node<T> next;
/**
 * create a new node 
 * @param val value to  be stored
 * @param node the node the current node is pointing to
 */
		public Node(T val, Node<T> node){
			data = val;
			next = node;
		}
/**
 * gets the data stored in current node
 * @return the data stored in the node
 */
		public T data() {
			return data;
		}
	}
/**
 * class containing stack information and methods
 */
	static class Stack<T> {
		Node<T> top;
		int size;

/**
 * creates a new empty stack
 */
		public Stack() {
			top = null;
			size = 0;
		}
/**
 * checks stack to see if it's empty
 * @return if the stack is empty
 */
		public boolean isEmpty() {
			return top == null;
		}
/**
 * pushes a new value to the top of the stack
 * @param val value to be stored
 */
		public void push(T val) {
			size++;
			if (isEmpty()) {
				top = new Node<>(val, null);
			}
			else {
				Node<T> nTop = new Node<>(val, top);
				top = nTop;
			}
		}

/**
 * pops the top of the stack and sets the next element to be the top
 * @return returns the value of the top of the stack
 */
		//removes top if not empty
		public T pop() {
			T tmp;
			if (size == 0) {
				size = 0;
				return null;
			}
			else if (size == 1){
				tmp = top.data();
				top = null;
				size --;
				return tmp;
			}
				
			else {
				tmp = top.data();
				top = top.next;
				size --;
				return tmp;
			}
		}
/**
 * gets the value of the data stored (only used for testing)
 * @return the value of the data stored
 */
		public T get() {
			return top.data;
		}
	}
/**
 * class containing the array implementation of a stack and it's methods
 */
	class StackArray {
		double[] s;
		int topIndex;

/**
 * creates a new array of a given size
 * @param maxCap the size of the array
 */
		public StackArray(int maxCap) {
			s = new double[maxCap];
			topIndex = -1;
		}
/**
 * check if the stack is empty
 * @return if the stack is empty
 */
		public boolean isEmpty() {
			return topIndex == -1;
		}
/**
 * checks if the stack is full
 * @return if the stack is full
 */
		public boolean isFull() {
			return topIndex == (s.length - 1);
		}
/**
 * pushes a new value into the top of the stack
 * @param newElem element to be added to the top of the stack
 */
		public void push(double newElem) {
			if (!isFull()) {
				topIndex++;
				s[topIndex] = newElem;
			}
		}
/**
 * pops the top element of the stack making the next element the new top
 * @return returns the value of the element being poped
 */
		public Double pop() {
			if (!isEmpty()) {
				double tmp = s[topIndex];
				topIndex--;
				return tmp;
			}
			else {
				return null;
			}
		}
	}

/**
 * takes a prefix string expression and calculates the result
 * @param str string to be used for the calculation
 * @return the result
 */
	public Double listPrefixCalc(String str) {
		try {
			Stack<String> top = splitIntoLL(str);
			//this is the result
			if (top.size == 1) {
				return Double.parseDouble(top.pop());
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			return null;
		}
	}
/**
 * takes a string sends it to be split and pushes the numbers into a stack then uses the operator to calculate the result of the top two numbers in the stack
 * @param str string to be split and calculated
 * @return the final result
 */
	public Double arrayPrefixCalc(String str) {
		String[] strArray = splitIntoArray(str);
		StackArray stack;
		try {
			stack = new StackArray(strArray.length-1);
			for (int i = strArray.length-1; i >= 0; i--) {
				while (Character.isDigit(strArray[i].charAt(0)) && i > 0) {
					stack.push(Double.parseDouble(strArray[i]));
					i--;
				}

				double operand1 = stack.pop();
				double operand2 = stack.pop();

				switch (strArray[i]) {

					case "+" :

						stack.push(operand1 + operand2);
						break;

					case "-" :

						stack.push(operand1 - operand2);
						break;

					case "*" :

						stack.push(operand1 * operand2);
						break;

					case "/" :

						stack.push(operand1 / operand2);
						break;

					case "^" :

						stack.push(Math.pow(operand1, operand2));
						break;

					default:

						return null;

				}
			}
		}
		catch (Exception e) {
			return null;
		}
		if (stack.topIndex == 0){
			return stack.pop();
		}
		else {
			return null;
		}
	}

/**
 * takes a string to be split by blank space
 * @param str string to be split
 * @return the string array
 */
	public static String[] splitIntoArray(String str) {
		String[] strArray = str.split("\\s");
		return strArray;
	}
/**
 * splits a given string and stores numbers into a stack then calculates the result based on the operator in the string
 * @param str prefix string to be split and evaluated
 * @return the stack
 */
	public  Stack<String> splitIntoLL(String str) {
		String[] toLL = splitIntoArray(str);
		Stack<String> top = new Stack<>();

		for (int i = toLL.length - 1; i >= 0; i--) {
			if (Character.isDigit(toLL[i].charAt(0))) {
				top.push(toLL[i]);
			}
			//the operator isn't pushed to the stack
			else {
				calcLL(top, toLL[i]);
			}
		}
		return top;
	}
/**
 * recursive method that does one operation per recursion
 * @param ref reference to the stack
 * @param operator operator stored in a string
 */
	public void calcLL(Stack<String> ref, String operator) {
		if (ref.size > 0) {
			double operand2;
			double operand1;

			try {
				operand1 = Double.parseDouble(ref.pop());
				operand2 = Double.parseDouble(ref.pop());

				switch (operator) {

					case "+" :

						ref.push(Double.toString(operand1 + operand2));
						break;

					case "-" :

						ref.push(Double.toString(operand1 - operand2));
						break;

					case "*" :

						ref.push(Double.toString(operand1 * operand2));
						break;

					case "/" :

						ref.push(Double.toString(operand1 / operand2));
						break;

					case "^" :

						ref.push(Double.toString(Math.pow(operand1, operand2)));
						break;

					default:

						return;

				}
			}
			catch (Exception e) {
				return;
			}

		}
		return; 
	}
/*
 * main method used for testing
 */

//	public static void main(String[] args) {
//		//String prefix = "- / + 18 9 - 8 5 2";
//		String prefix = " ";
//
//		antunez6 arrPre = new antunez6();
//		System.out.println(arrPre.arrayPrefixCalc(prefix));
//
//
//		antunez6 llPre = new antunez6();
//		System.out.println(llPre.listPrefixCalc(prefix));
//	}

}
