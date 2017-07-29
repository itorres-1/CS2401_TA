package Lab6; /**
 * Author: Hao Moy
 * Date: 7/25/17.
 * Course: CS 2401 Elementary Data Structures
 */


import java.util.Queue;
import java.util.Stack; 

/**
 * An interface to ensure that the everyone in the class
 * adheres to the exact same method signature(s) thus ensuring
 * code compatibility with the TA's code.
 */
public class Moy6 { 

	class iNode { 
		public String value; 
		public iNode next;  

		public iNode(String i, iNode n) { 
			this.value = i; 
			this.next = n;
		}

	}
	/**
	 * A method that given a string containing any natural number N
	 * or the characters: +, -, *, /, ^, representing a prefix expression
	 * where operands and operations are separated by spaces, computes and
	 * returns the result using a list-based implementation.
	 * @param str the string representing the prefix expression.
	 * @return the result of the prefix expression, otherwise null
	 * if the expression cannot be computed.
	 */



	public Double listPrefixCalc(String str) {

		if (!stupidUser(str)) 
			return null; 

		Moy6 instance = new Moy6();
		Stack<String> s = new Stack<String>();
		int i=0;

		String[] b = str.split(" ");

		iNode head = null;
		for ( i=0; i<b.length; i++) { 
			head = new iNode(b[i], head); 
		}
		iNode temp = head; 
		while (temp != null) { 
			if(instance.isNumeric(temp.value)) {
				s.push(temp.value);
			}
			else {
				switch(temp.value) { 
				case "/": 
					s.push(instance.divisionCase(s));
					break;
				case "^": 
					s.push(instance.powerCase(s));
					break;
				case "+": 
					s.push(instance.addCase(s));
					break;
				case "*": 
					s.push(instance.proCase(s));
					break;
				case "-": 
					s.push(instance.subCase(s));
					break;
				} 
			}
			temp = temp.next; 
		} 	
		return Double.parseDouble(s.pop());

	}



	/**
	 * A method that given a string containing any natural number N
	 * or the characters: +, -, *, /, ^, representing a prefix expression
	 * where operands and operations are separated by spaces, computes and
	 * returns the result using a array-based implementation.
	 * @param str the string representing the prefix expression.
	 * @return the result of the prefix expression, otherwise null
	 * if the expression cannot be computed.
	 */
	public Double arrayPrefixCalc(String str){
		if (!stupidUser(str)) 
			return null; 
		
		Moy6 instance = new Moy6();
		Stack<String> s = new Stack<String>();
		char[] op = str.toCharArray();
		int counter = 1;
		int i=0;

		for ( i=op.length; i>0; i--) { 
			if (op[i-1]==' '){
				counter++;
			}
		}
		String[] b = str.split(" ");

		for( i=b.length-1; i>-1; i--) { 
			if (instance.isNumeric(b[i])){
				s.push(b[i]);
				continue;
			}
			switch(b[i]) { 
			case "/": 
				s.push(instance.divisionCase(s));
				break;
			case "^": 
				s.push(instance.powerCase(s));
				break;
			case "+": 
				s.push(instance.addCase(s));
				break;
			case "*": 
				s.push(instance.proCase(s));
				break;
			case "-": 
				s.push(instance.subCase(s));
				break;
			}

		}
		return  Double.parseDouble(s.pop());

	}
	 /*
	 * Method that computes DIVISION by parsing the first two Strings of a stack.
	 * @param s the stack containing at least two values to be computed.
	 * @return the result of operation.
	 */
	public String divisionCase(Stack<String> s) {
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(first/second);
	}
	
	 /*
	* Method that computes POWERS by parsing the first two Strings of a stack.
		 * @param s the stack containing at least two values to be computed.
		 * @return the result of operation.
		 */
	public String powerCase(Stack<String> s) { 
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(Math.pow(first, second));
	}

	 /*
		 * Method that computes ADDITION by parsing the first two Strings of a stack.
		 * @param s the stack containing at least two values to be computed.
		 * @return the result of operation.
		 */
	public String addCase(Stack<String> s) { 
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(first+second);
	}

	 /*
		 * Method that computes MULTIPLICATION by parsing the first two Strings of a stack.
		 * @param s the stack containing at least two values to be computed.
		 * @return the result of operation.
		 */
	public String proCase(Stack<String> s) { 
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(first*second);
	}

	 /*
		 * Method that computes SUBSTRACTION by parsing the first two Strings of a stack.
		 * @param s the stack containing at least two values to be computed.
		 * @return the result of operation.
		 */
	public String subCase(Stack<String> s) { 
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(first-second);
	}

	 /*
		 * Method that determines if a given string is numeric. 
		 * @param str the String that will try to be parsed. 
		 * @return If str is parsed, the method returns true, else the method returns false. 
		 */
	public boolean isNumeric(String str) {  
		try {  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}

	 /*
	 * Method that determines if a given string is manipulatable as a prefix operation. 
	 * @param a the String to be tested.
	 * @return If str is manipulatable, the method returns true, else the method returns false. 
	 */
	public boolean stupidUser(String a) { 
		Moy6 instance = new Moy6();
		int counterNum = 0; 
		int counterOp = 0;
		int i=0;
		String[] op = a.split(" ");
		
		if (a==null || instance.isNumeric(op[0]) ) 
			return false; 	
		if (!instance.isNumeric(op[op.length-1]) || !instance.isNumeric(op[op.length-2]))
			return false;
		for (i=0; i<op.length; i++) {
			if (op[i].length() > 1 && !instance.isNumeric(op[i])) 
				return false; 

			if (instance.isNumeric(op[i])) { 
				counterNum++;
				continue;
			}
			switch(op[i]) { 
			case "/": 
			case "^": 
			case "+": 			
			case "*": 			
			case "-": 
				counterOp++;
				break;
			}
		}
		if (counterOp+1 != counterNum) {
			System.out.println("passed");
			return false;
		}

		return true;
	}
}
