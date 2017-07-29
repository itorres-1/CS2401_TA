package Lab6;

import Testers.LabInterfaces.Lab6Interface;

// Lab 6
// CS2401 - Dr. Urenda - TA: Isaac Torres
// Date of last modification: 07/25/2017
public class Boatright6 implements Lab6Interface {
  static class DoubleNode { // Linked List class for doubles
    double data; // Double value
    DoubleNode next; // Link to next node in list

    /**
     * This constructor creates a node of a Linked List of doubles.
     * @param d Double value of node
     * @param n Link to next node
     */
    DoubleNode(double d, DoubleNode n) {
      data = d;
      next = n;
    }

    /**
     * This method sets the link from the current node to another.
     * @param n Node to be linked to
     */
    void setNext(DoubleNode n) {
      next = n;
    }
  }

  static class StackLL { // Stack class w/ Linked List implementation
    DoubleNode top; // Top node of stack
    int size; // # of nodes in stack (elements)

    /**
     * Default constructor for StackLL (null node w/ size of 0)
     */
    StackLL() {
      top = null;
      size = 0;
    }

    /**
     * This method pushes a double (node) into the stack.
     * @param a Double to be pushed into stack
     */
    void push(Double a) {
      DoubleNode nNode = new DoubleNode(a, null);

      if (top == null) {
        top = nNode;
      } else {
        nNode.setNext(top);
        top = nNode;
      }

      size++;
    }

    /**
     * This method returns and removes (pops the top element of the stack.
     * @return Double value of popped node
     */
    double pop() {
      if (isEmpty()) {
        System.out.println("Stack Underflow"); // Prints error if stack is empty
      }
      DoubleNode pNode = top; // Duplicates top for return value
      top = pNode.next; // Sets top to next node in list
      size--; // Decrements size tracker by 1
      return pNode.data;
    }

    /**
     * This method returns the value of the top element/node in the stack.
     * @return Double value of top node
     */
    double peek() {
      if (isEmpty()) {
        System.out.println("Empty Stack"); // Prints error if stack is empty
      }
      return top.data;
    }

    /**
     * This method checks if a stack is empty
     * @return True if stack is empty, else false
     */
    boolean isEmpty() {
      return top == null;
    }
  }

  static class StackA { // Stack class w/ array implementation
    private double[] data; // Array of doubles that makes up the stack
    private int size; // # of elements in the stack

    /**
     * This constructor creates a stack given a specific capacity
     * @param capacity Capacity of the stack (size of array)
     */
    StackA(int capacity) {
      data = new double[capacity];
    }

    /**
     * This method pushes a double value into the stack, and doubles capacity if necessary.
     * @param a Double to be pushed into stack
     */
    void push(Double a) {
      if (size >= data.length) { // If stack needs to exceed original capacity
        double[] temp = new double[data.length*2]; // Creates array twice the size of current
        System.arraycopy(data, 0, temp, 0, data.length); // Duplicates array
        data = temp; // Sets new array to data field
      }
      data[size++] = a; // Pushes new value into stack and increments size by 1
    }

    /**
     * This method returns and removes the top element in the stack.
     * @return Double value of popped element
     */
    double pop() {
      if (isEmpty()) {
        System.out.println("Stack Underflow."); // Prints error if stack is empty
      }
      return data[--size];
    }

    /**
     * This method returns the value of the top element in the stack
     * @return Double value of top element in stack
     */
    double peek() {
      if (isEmpty()) {
        System.out.println("Empty Stack."); // Prints error if stack is empty
      }
      return data[size-1];
    }

    /**
     * This method checks if a stack is empty
     * @return True if stack is empty, else false
     */
    boolean isEmpty() {
      return size == 0;
    }
  }

  /**
   * This method checks a string to see if it can be parsed into a double, and is non-negative.
   * @param str String to be checked
   * @return True if parsable & non-negative, else false
   */
  public static boolean isNumeric(String str) {
    double num;
    try {
      num = Double.parseDouble(str); // Attempts to parse to double
    } catch (NumberFormatException e) {
      return false; // Returns false if exception caught
    }
    if (num < 0.0) {
      return false; // Returns false if number is negative
    }
    return true;
  }

  @Override
  public Double listPrefixCalc(String str) {
    StackLL stk = new StackLL();
    String[] expression = str.split("\\s"); // Splits String into array of String by whitespace regex
    double num1, num2, test; // Declare variables for operands, and test-print values

    for (int i=expression.length-1; i>=0; i--) {  // Loops through expression from right to left
      if (isNumeric(expression[i])) { // Checks if element is non-negative number
        stk.push(Double.parseDouble(expression[i])); // Pushes number to stack

        // Prints values as pushed into stack
        test = stk.peek();
        System.out.println("Push to stack (LL): " + test);
      } else { // Conditional if element is not a non-negative number
        // Pops the operands from stack
        num1 = stk.pop();
        num2 = stk.pop();

        // Conditional for operators and invalid inputs(default case)
        switch (expression[i].charAt(0)) {
          case '+':
            stk.push(num1 + num2); // Adds operands and pushes new operand back to stack

            // Prints values as pushed into stack
            test = stk.peek();
            System.out.println("Push after addition (LL): " + test);
            break;
          case '-':
            stk.push(num1 - num2); // Subtracts operands and pushes new operand back to stack

            // Prints values as pushed into stack
            test = stk.peek();
            System.out.println("Push after subtraction (LL): " + test);
            break;
          case '*':
            stk.push(num1 * num2); // Multiplies operands and pushes new operand back to stack

            // Prints values as pushed into stack
            test = stk.peek();
            System.out.println("Push after multiplication (LL): " + test);
            break;
          case '/':
            stk.push(num1 / num2); // Divides operands and pushes new operand back to stack

            // Prints values as pushed into stack
            test = stk.peek();
            System.out.println("Push after division (LL): " + test);
            break;
          default:
            return null; // Returns null if elements is not a non-negative number or above operator
        }
      }
    }

    return stk.pop();
  }

  @Override
  public Double arrayPrefixCalc(String str) {
    // *****See above comments for algorithm implementation*****
    StackA aStack = new StackA(str.length());
    String[] expression = str.split("\\s");
    double num1, num2, test;

    for (int i=expression.length-1; i>=0; i--) {
      if (isNumeric(expression[i])) {
        aStack.push(Double.parseDouble(expression[i]));

        // Prints values as pushed into stack
        test = aStack.peek();
        System.out.println("Push to stack (Array): " + test);

      } else {
        num1 = aStack.pop();
        num2 = aStack.pop();
        switch (expression[i].charAt(0)) {
          case '+':
            aStack.push(num1 + num2);

            // Prints values as pushed into stack
            test = aStack.peek();
            System.out.println("Push after addition (Array): " + test);
            break;
          case '-':
            aStack.push(num1 - num2);

            // Prints values as pushed into stack
            test = aStack.peek();
            System.out.println("Push after subtraction (Array): " + test);
            break;
          case '*':
            aStack.push(num1 * num2);

            // Prints values as pushed into stack
            test = aStack.peek();
            System.out.println("Push after multiplication (Array): " + test);
            break;
          case '/':
            aStack.push(num1 / num2);

            // Prints values as pushed into stack
            test = aStack.peek();
            System.out.println("Push after addition (Array): " + test);
            break;
          default:
            return null;
        }
      }
    }

    return aStack.pop();
  }
}


