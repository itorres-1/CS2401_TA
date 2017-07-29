package Lab6;/* Name: Eduardo A. Jimenez Todd         */
/* Assignment: Lab 6                     */
/* Instructor: Dr. Julio Cesar Urenda    */
/* T.A.: Isaac Torres                    */
/* Last Modification: 7/17/2017          */
/* Purpose: implement stacks to do       */
/*          prefix notation calculations */
import java.util.Scanner;

/**
 * This class shows 2 ways of computing prefix expressions. One using LinkedList and another using Arrays.
 * 
 * @author Eduardo Jimenez Todd
 *
 */
public class JimenezTodd6 {
	public static void main (String[] args){
		JimenezTodd6 jt = new JimenezTodd6();
		System.out.print(jt.listPostfixCalc("9 6 +"));
	}
	
	/**
     * A method that given a string containing any natural number N
     * or the characters: +,-,*,/,^, representing a prefix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a list-based implementation.
     * @param str the string representing the prefix expression.
     * @return the result of the prefix expression, otherwise null
     * if the expression cannot be computed.
     */
	 public Double listPrefixCalc(String str){
	    	String[] splits = str.split(" ");
	    	intNode head = null;
			//prepend string fragments
			for (String s:splits)
				head = new intNode(s, head);
			intNode temp = head;
			while (head.next!=null){
				if(temp==null||temp.next==null||temp.next.next==null)
					temp=head;
				if (isNumeric(temp.item) && isNumeric(temp.next.item)){
					try{
						switch (temp.next.next.item){
						case "+":						
							temp.item=""+(Double.parseDouble(temp.next.item) + Double.parseDouble(temp.item));
		    				temp.next=temp.next.next.next;
				   			break;
				   		case "-":
				   			temp.item=""+(Double.parseDouble(temp.next.item) - Double.parseDouble(temp.item));
		    				temp.next=temp.next.next.next;
				   			break;
				   		case "*":
				   			temp.item=""+(Double.parseDouble(temp.next.item) * Double.parseDouble(temp.item));
				   			temp.next=temp.next.next.next;
				   			break;
				   		case "/":
				   			temp.item=""+(Double.parseDouble(temp.next.item) / Double.parseDouble(temp.item));
		    				temp.next=temp.next.next.next;
				   			break;
				   		case "^":
				   			temp.item=""+power(Double.parseDouble(temp.next.item),Double.parseDouble(temp.item));
		    				temp.next=temp.next.next.next;
				   			break;
				   		default:
				   			if (!isNumeric(temp.next.next.item)) return null;
						}
					}
					catch (NullPointerException e) {return null;}
				}
				temp=temp.next;
			}
			return Double.parseDouble(head.item);
		}
	 
/**
* A method that given a string containing any natural number N, the 
* characters: +,-,*,/,^, or a variable, representing a postfix expression
* where operands and operations are separated by spaces, computes and
* returns the result using a list-based implementation.
* @param str the string representing the postfix expression.
* @return the result of the postfix expression, otherwise null
* if the expression cannot be computed.
*/
		 public Double listPostfixCalc(String str){
		    	String[] splits = str.split(" ");
		    	intNode head = null;
		    	//append string fragments
				for (String s:splits){
					if(head == null) head = new intNode(s, head);
					else{
						intNode temp = head;
						while(temp.next != null) temp = temp.next;
							temp.next = new intNode(s, null);
					}
				}
				intNode temp = head;
				while (head.next!=null){
					if(!isNumeric(temp.item)){
						Scanner scnr = new Scanner(System.in);
		   				System.out.print("Enter variable '"+temp.item+"' value: ");
		   				temp.item=scnr.next();
		   				scnr.close();
		   				temp=head;
					}
						
					if(temp==null||temp.next==null||temp.next.next==null)
						temp=head;
					if (isNumeric(temp.item) && isNumeric(temp.next.item)){
						try{
							switch (temp.next.next.item){
							case "+":						
								temp.item=""+(Double.parseDouble(temp.next.item) + Double.parseDouble(temp.item));
			    				temp.next=temp.next.next.next;
					   			break;
					   		case "-":
					   			temp.item=""+(Double.parseDouble(temp.next.item) - Double.parseDouble(temp.item));
			    				temp.next=temp.next.next.next;
					   			break;
					   		case "*":
					   			temp.item=""+(Double.parseDouble(temp.next.item) * Double.parseDouble(temp.item));
					   			temp.next=temp.next.next.next;
					   			break;
					   		case "/":
					   			temp.item=""+(Double.parseDouble(temp.next.item) / Double.parseDouble(temp.item));
			    				temp.next=temp.next.next.next;
					   			break;
					   		case "^":
					   			temp.item=""+power(Double.parseDouble(temp.next.item),Double.parseDouble(temp.item));
			    				temp.next=temp.next.next.next;
					   			break;
							}
						}
						catch (NullPointerException e) {return null;}
					}
					temp=temp.next;
				}
				return Double.parseDouble(head.item);
			}
    
    /**
     * A method that given a string containing any natural number N
     * or the characters: +,-,*,/,^, representing a prefix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a array-based implementation.
     * @param str the string representing the prefix expression.
     * @return the result of the prefix expression, otherwise null
     * if the expression cannot be computed.
     */
    public Double arrayPrefixCalc(String str){
    	char[] A = new char[str.length()];
    	Double[] stack = new Double[(str.length()+1)/2];
    	int top=-1;
    	for(int i=A.length-1;i>=0;i--){
    		A[i]=str.charAt(i);
    		switch (A[i]){
    		case ' ':
    			break;
    		case '+':
    			if (top<1 || A[i+1]!=' ')return null;
	   			stack[--top]=stack[++top]+stack[--top];
	   			stack[top+1]=null;
	   			break;
	   		case '-':
    			if (top<1 || A[i+1]!=' ')return null;
	   			stack[--top]=stack[++top]-stack[--top];
	   			stack[top+1]=null;
	   			break;
	   		case '*':
    			if (top<1 || A[i+1]!=' ')return null;
	   			stack[--top]=stack[++top]*stack[--top];
	   			stack[top+1]=null;
	   			break;
	   		case '/':
    			if (top<1 || A[i+1]!=' ')return null;
	   			stack[--top]=stack[++top]/stack[--top];
	   			stack[top+1]=null;
	   			break;
	   		case '^':
    			if (top<1 || A[i+1]!=' ')return null;
	   			stack[--top]=power(stack[++top],stack[--top]);
	   			stack[top+1]=null;
	   			break;
	   		default:
	   			if (!Character.isDigit(A[i]))return null;
	   			stack[++top]=0.0;
	   			Double n=1.0;
	   			while(Character.isDigit(A[i])){
	   				stack[top]+=((double)(A[i] - '0')*n);
	   				i--;
	   				try{A[i]=str.charAt(i);}
	   				catch(StringIndexOutOfBoundsException e){return null;}
	   				n*=10;
	   			}
	   			i++;
    		}
    	}
    	return stack[top];
    }
    /**
     * A method that computes the power of a number given the number and exponent
     * @param a Number
     * @param n Exponent
     * @return Power
     */
    public double power(double a,double n){
    	if(n==0)return 1;
    	return(n>0)?a*power(a,n-1):power(a,n+1)/a;
    }
    /**
     * A method that checks if a string is a numeric value
     * @param str Input String
     * @return true if numeric, false elsewhere
     */
    public static boolean isNumeric(String str){  
      try {double d = Double.parseDouble(str);}  
      catch(NumberFormatException e){return false;}  
      return true;  
    }
}
/**
 * A class that creates the nodes of a linkedList
 * @author Eduardo Jimenez Todd
 *
 */
class intNode{
	public String item; 
	public intNode next; 
	
	public intNode(String i, intNode n){ 
		this.item = i; 
		this.next = n; 
	}	
}
