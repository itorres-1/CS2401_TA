package Lab6;

import Testers.LabInterfaces.Lab6Interface;

import java.util.ArrayList;


/**
 * The Class GuerecaBerumen6.
 * @author Jesus Guereca Berumen
 */
public class GuerecaBerumen6 implements Lab6Interface {
	
	/**
	 * The Class stackArr.
	 */
	static class stackArr{
		
		/** The array containing the elements of the stack */
		Double[] arr;
		
		/** The top. */
		int top = -1;
		
		/** The size. */
		int size;
		
		/**
		 * Instantiates a new stack array.
		 *
		 * @param size the size of the stack
		 */
		public stackArr(int size) {
			this.size = size;
			arr = new Double[size];
		}
		
		/**
		 * Push one element into the stack
		 *
		 * @param newElem the new element
		 */
		public void push(Double newElem) {
			if(top != size - 1)
				arr[++top] = newElem;
		}
		 
		/**
		 * Pop one element out of stack
		 *
		 * @return the double
		 */
		Double pop() {
			if(!isEmpty())
				return arr[top--];
			return null;
		}
		
		/**
		 * Checks if stack is empty.
		 *
		 * @return true, if is empty
		 */
		public boolean isEmpty() {
			return top == -1;
		}
	}
	
	/**
	 * The Class stackList.
	 */
	static class stackList{
		
		/** The list containing elements of the stack*/
		ArrayList<Double> list;
		
		/** Index for top element of stack
		 * -1 if empty */
		int top = -1;
		
		/**
		 * Instantiates a new stack list
		 */
		public stackList() {
			list = new ArrayList<Double>();
		}
		
		/**
		 * Push one element into the stack
		 *
		 * @param newElem the new Double to add to stack
		 */
		public void push(Double newElem) {
			list.add(newElem);
			top++;
		}
		
		/**
		 * Pop removes the top element of the stack
		 *
		 * @return the double removed from the stack
		 */
		public Double pop() {
			Double temp = list.get(top);
			list.remove(top--);
			return temp;
		}
		
		/**
		 * Checks if stack is empty.
		 *
		 * @return true, if is empty
		 */
		public boolean isEmpty() {
			return (list.size() > 0)?false:true;
		}
	}

	/**
	 * @see Lab6Interface#listPrefixCalc(java.lang.String)
	 */
	public Double listPrefixCalc(String str) {
		try {
			String[] split = str.split(" ");
			stackList stack = new stackList();
			for(int i = split.length - 1;i > -1;i--) { //for every element in split
				if(isInteger(split[i])) //if is an integer
					stack.push(Double.parseDouble(split[i])); //pushes it to stack
				else //if not an integer
					switch(split[i]) { //checks what operand it is
					case "+"://if plus adds the top two in stack and push
						stack.push(stack.pop() + stack.pop());
						break;
					case "-":
						stack.push(stack.pop() - stack.pop());
						break;
					case "*":
						stack.push(stack.pop() * stack.pop());
						break;
					case "/":
						stack.push(stack.pop() / stack.pop());
						break;
					case "^":
						stack.push(Math.pow(stack.pop(), stack.pop()));
						break;
					default://if none of the above
						return null;
					}
			}
			return stack.pop();
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}


	/**
	 * @see Lab6Interface#arrayPrefixCalc(java.lang.String)
	 */
	public Double arrayPrefixCalc(String str) {
		try {
			String[] split = str.split(" ");
			stackArr stack = new stackArr(split.length);
			for(int i = split.length - 1;i > -1;i--) { //for every element in split
				if(isInteger(split[i])) //if is an integer
					stack.push(Double.parseDouble(split[i])); //pushes it to stack
				else //if not an integer
					switch(split[i]) { //checks what operand it is
					case "+"://if plus adds the top two in stack and push
						stack.push(stack.pop() + stack.pop());
						break;
					case "-":
						stack.push(stack.pop() - stack.pop());
						break;
					case "*":
						stack.push(stack.pop() * stack.pop());
						break;
					case "/":
						stack.push(stack.pop() / stack.pop());
						break;
					case "^":
						stack.push(Math.pow(stack.pop(), stack.pop()));
						break;
					default://if none of the above
						return null;
					}
			}
			return stack.pop();
		}
		catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Checks if is integer.
	 *
	 * @param str the string
	 * @return the boolean
	 */
	public Boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(NumberFormatException e) {
			return false;
		} catch(Exception e ) {
			return null;
		}
	}
}
