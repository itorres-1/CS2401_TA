package Lab6;

import Testers.LabInterfaces.Lab6Interface;

public class Sauers6 implements Lab6Interface {
	
	public Sauers6(){
		listPrefixCalc("+7+1x35");
		listPrefixCalc("x+12+3");
		listPrefixCalc("+x/+15345.dvsdvsd");
		listPrefixCalc("^37");
		arrayPrefixCalc("+7+1x35");
		arrayPrefixCalc("x-567");
		arrayPrefixCalc("+x/+12345.dvsdvsd");
	}
	
	/**
     * A method that given a string containing any natural number N
     * or the characters: +, −, ∗, /, ∧, representing a prefix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a list-based implementation.
     * @param str the string representing the prefix expression.
     * @return the result of the prefix expression, otherwise null
     * if the expression cannot be computed.
     */
	public Double listPrefixCalc(String str){
		String newStr = str.replaceAll(" ","");
		System.out.println(newStr);
		StackLL polishList = new StackLL();
		Double x = 0.0;
		Double y = 0.0;
		for (int i = newStr.length() - 1; i >= 0; i--) {
			String temp = Character.toString(newStr.charAt(i));
			try {
				Double temp2 = Double.parseDouble(Character.toString(newStr.charAt(i)));
				polishList.push(temp2);
			}catch(NumberFormatException e) {
				if (temp.equals("+") || temp.equals("-") || temp.equals("x") || temp.equals("/") || temp.equals("^")) {
					switch (Character.toString(newStr.charAt(i))){
						case "+":
							try{ 
								x = polishList.pop();
								y = polishList.pop();
								polishList.push(x+y);
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								System.out.println(" ");
								return null;
							}
						case "-":
							try{ 
								x = polishList.pop();
								y = polishList.pop();
								polishList.push(x-y);
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								System.out.println(" ");
								return null;
							}
						case "x":
						case "X":
							try{ 
								x = polishList.pop();
								y = polishList.pop();
								polishList.push(x*y);
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								System.out.println(" ");
								return null;
							}
						case "/":
							try {
								x = polishList.pop();
								y = polishList.pop();
								if (y == 0.0) {
									System.out.println("You can't divide by zero!");
									break;
								}polishList.push(x/y);
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								return null;
							}
						case "^":
							try {
								x = polishList.pop();
								y = polishList.pop();
								polishList.push(Math.pow(x,y));
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								return null;
							}
					}
				}else{
					System.out.println("Nice try - but '" + temp + "' isn't a valid entry for this. Discarded!");
				}
			}
		}Double returnVal = 0.0;
		try {
			returnVal = polishList.getTop();
		}catch(NumberFormatException e) {
			returnVal = null;
		}
		System.out.println("Final product: ");
		System.out.println(returnVal);
		System.out.println(" ");
		return returnVal;
	}
    
	
	/**
     * A method that given a string containing any natural number N
     * or the characters: +, −, ∗, /, ∧, representing a prefix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a array-based implementation.
     * @param str the string representing the prefix expression.
     * @return the result of the prefix expression, otherwise null
     * if the expression cannot be computed.
     */
    public Double arrayPrefixCalc(String str){
		String newStr = str.replaceAll(" ","");
		System.out.println(newStr);
		StackAB polishArray = new StackAB(newStr.length());
		Double x = 0.0;
		Double y = 0.0;
		for (int i = str.length() - 1; i >= 0; i--) {
			String temp = Character.toString(newStr.charAt(i));
			try {
				String temp2 = Double.toString(Double.parseDouble(temp));
				polishArray.push(temp2);
			}catch(NumberFormatException e) {
				if (temp.equals("+") || temp.equals("-") || temp.equals("x") || temp.equals("/") || temp.equals("^")) {
					switch (temp){
						case "+":
							try{
								x = Double.parseDouble(polishArray.pop());
								y = Double.parseDouble(polishArray.pop());
								polishArray.push(Double.toString(x+y));
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								System.out.println(" ");
								return null;
							}
						case "-":
							try{ 
								x = Double.parseDouble(polishArray.pop());
								y = Double.parseDouble(polishArray.pop());
								polishArray.push(Double.toString(x-y));
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								System.out.println(" ");
								return null;
							}
						case "x":
						case "X":
							try{
								x = Double.parseDouble(polishArray.pop());
								y = Double.parseDouble(polishArray.pop());
								polishArray.push(Double.toString(x*y));
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								System.out.println(" ");
								return null;
							}
						case "/":
							try{ 
								x = Double.parseDouble(polishArray.pop());
								y = Double.parseDouble(polishArray.pop());
								if (y == 0.0) {
									System.out.println("You can't divide by zero!");
									break;
								}polishArray.push(Double.toString(x/y));
								break;
							}catch (NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								System.out.println(" ");
								return null;
							}
						case "^":
							try{
								x = Double.parseDouble(polishArray.pop());
								y = Double.parseDouble(polishArray.pop());
								polishArray.push(Double.toString(Math.pow(x,y)));
								break;
							}catch(NullPointerException a) {
								System.out.println("Don't break me! Returning null...");
								System.out.println(" ");
								return null;
							}
					}
				}else{
					System.out.println("Nice try - but '" + temp + "' isn't a valid entry for this. Discarded!");
				}
			}
		}Double returnVal = 0.0;
		try {
			returnVal = Double.parseDouble(polishArray.pop());
		}catch(NumberFormatException e) {
			returnVal = null;
		}
		System.out.println("Final product: ");
		System.out.println(returnVal);
		System.out.println(" ");
		return returnVal;
	}
	
	/**
     * A method that given a string containing any natural number N
     * or the characters: +, −, ∗, /, ∧, representing a postfix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a list-based implementation.
     * @param str the string representing the postfix expression.
     * @return the result of the postfix expression, otherwise null
     * if the expression cannot be computed.
     */
    public Double listPostfixCalc(String str){
		String tempStr = new StringBuffer(str).reverse().toString();
		return listPrefixCalc(tempStr);
	}
	
    /**
     * A method that given a string containing any natural number N
     * or the characters: +, −, ∗, /, ∧, representing a postfix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a array-based implementation.
     * @param str the string representing the postfix expression.
     * @return the result of the postfix expression, otherwise null
     * if the expression cannot be computed.
     */
    public Double arrayPostfixCalc(String str){
		String tempStr2 = new StringBuffer(str).reverse().toString();
		return arrayPrefixCalc(tempStr2);
	}
	
	public static void main(String[] args) {
		Sauers6 temp = new Sauers6();
	}
	
	//Stack - array
	static class StackAB{
		public String[] stack;
		public int topIndex;
		
		public StackAB(int size) {
			stack = new String[size];
			topIndex = -1;
		}
		
		public void push(String newElement) {
			topIndex++;
			stack[topIndex] = newElement;
		}
		
		public String pop() {
			String temp = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return temp;
		}
	}
	
	//Stack - linked list 
	static class StackLL{
		private doubleNode top;
		
		public StackLL(){
			top = null;
		}
		
		public boolean isEmpty(){
			return top == null;
		}
		
		public Double getTop(){
			return top.data;
		}
		
		public void push(Double newElement) {
			doubleNode nTop = new doubleNode(newElement, top);
			top = nTop;
		}
		
		public Double pop() {
			Double temp = top.data;
			top = top.next;
			return temp;
		}
	}
	
	//Linked list class
	static class doubleNode{
		public Double data;
		public doubleNode next;
		
		public doubleNode(double myData, doubleNode myNext) {
			data = myData;
			next = myNext;
		}
	}
}