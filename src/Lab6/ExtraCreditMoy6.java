package Lab6; /**
 * Author: Hao Moy
 * Date: 7/25/17.
 * Course: CS 2401 Elementary Data Structures
 */


import Lab6.Moy6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class ExtraCreditMoy6 {

	class iNode { 
		public String value; 
		public iNode next;  

		public iNode(String i, iNode n) { 
			this.value = i; 
			this.next = n;
		}

	}
	
	public Double listPostfixCalc(String[] b) {
		
		Moy6 instance = new Moy6();
		Stack<String> s = new Stack<String>();
		int i=0;

		iNode head = null;
		for ( i=b.length-1; i>-1; i--) { 
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
	
	public String[] variableReader(String str) { 
		Scanner scnr = new Scanner(System.in); 
		ExtraCreditMoy6 instance = new ExtraCreditMoy6();
		String[] b = str.split(" ");
		for (int i =0; i<b.length; i++) {
			switch(b[i]) { 
			case "/": 
			case "^": 
			case "+": 			
			case "*": 			
			case "-": 
				continue;
			}
			if(!instance.isNumeric(b[i])){
				System.out.println("Enter value of " + b[i]);
				b[i] = scnr.nextLine(); 
			}
		}
		
		return b;
	}
	

	public String divisionCase(Stack<String> s) {
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(first/second);
	}
	
	 
	public String powerCase(Stack<String> s) { 
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(Math.pow(first, second));
	}

	 
	public String addCase(Stack<String> s) { 
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(first+second);
	}

	 
	public String proCase(Stack<String> s) { 
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(first*second);
	}

	 
	public String subCase(Stack<String> s) { 
		double first = Double.parseDouble(s.pop());
		double second = Double.parseDouble(s.pop());
		return Double.toString(first-second);
	}

	 
	public boolean isNumeric(String str) {  
		try {  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
	
	
	public static void main(String[]args) { 
		ExtraCreditMoy6 instance = new ExtraCreditMoy6();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter Postfix Variable Operation: "); 
		String a = scnr.nextLine(); 
		
		System.out.println(instance.listPostfixCalc(instance.variableReader(a)));
	}
	
	
}
