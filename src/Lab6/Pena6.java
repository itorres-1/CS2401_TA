package Lab6;

import Testers.LabInterfaces.Lab6Interface;

import java.util.Stack;

/**
 * Created by LoriPena on 7/20/17.
 * Lorianne Pena with code from Dr. Urenda and methods from Isaac Torres
 * CS 2401 Summer 2017
 * Lab 6
 */
public class Pena6 implements Lab6Interface {
    static class StackArray {
        private double[] array;
        private int topIndex;

        StackArray(int maxCap) {//constructor
            array = new double[maxCap];
            topIndex = -1;
        }

        /**
         * isEmpty method to check if the stack is empty
         *
         * @return topIndex==-1
         */
        public boolean isEmpty() {
            return topIndex == -1;
        }

        /**
         * isFull method to check if the stack is full
         *
         * @return topIndex == (array.length-1)
         */
        public boolean isFull() {
            return topIndex == (array.length - 1);
        }

        /**
         * push method to place a element on top of the stack
         *
         * @param newElement is the new top element
         */
        public void push(double newElement) {//need an exception
            try {
                topIndex++;
                array[topIndex] = newElement;

            } catch (StackOverflowError a) {
                System.out.println ("null");
            }
        }

        /**
         * method to take the top element out of the stack
         *
         * @return temp variable or null if the exception is caught
         */
        public Double pop() {//need an exception
            try {
                double temp = array[topIndex];
                topIndex--;
                return temp;

            } catch (ArrayIndexOutOfBoundsException a) {
                return null;
            }
        }
    }

    static class doubleNode {
        double data;
        doubleNode next;

        doubleNode(double n, doubleNode e) {//default constructor
            this.data = n;
            this.next = e;
        }
    }

    static class StackLinkedList {
        private doubleNode top;

        public StackLinkedList() {
            top = null;
        }

        /**
         * a method to check if the stack linked list is empty
         *
         * @return top == null
         */
        public boolean isEmpty() {//operations
            return top == null;
        }

        /**
         * getTop method is to "peek" at the top or head of the linked list
         *
         * @return top.data or the head
         */
        public double getTop() {
            return top.data;
        }

        /**
         * push method to place a new element at the top of the linked list
         *
         * @param newElement takes in the new element and places it in the linked list and is set to the new top
         */
        public void push(double newElement) {
            try {
                top = new doubleNode (newElement, top);

            } catch (StackOverflowError a) {
                System.out.println ("null");
            }
        }

        /**
         * pop method to help remove the top element(s) from the linked list
         *
         * @return temp variable or null of there is a exception to catch
         */
        public Double pop() {
            try {
                double temp = top.data;
                top = top.next;
                return temp;

            } catch (NullPointerException a) {
                // System.out.println ("The stack is empty, can't pop a value!");
                return null;
            }
        }
    }

    /**
     * prefixOperator is a method to execute the operations that are passed through the string
     *
     * @param operator  is the string being read
     * @param firstNum  is the first number to be checked in the stack
     * @param secondNum is the second number to be checked in the stack
     * @return the result of the operation that is passed in the string or returns null if a exception is caught
     */
    public Double prefixOperator(String operator, double firstNum, double secondNum) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
            case "^":
                result = Math.pow (firstNum, secondNum);
                break;
            default:
                //System.out.println ("Invalid Number Operation!");
                return null;
        }
        return result;
    }

    /**
     * A method that given a string containing any natural number N
     * or the characters: +, −, ∗, /, ∧, representing a prefix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a list-based implementation.
     *
     * @param str the string representing the prefix expression.
     * @return the result of the prefix expression, otherwise null
     * if the expression cannot be computed.
     */
    @Override
    public Double listPrefixCalc(String str) {
        double firstNum = 0;
        double secondNum = 0;
        StackLinkedList stackList = new StackLinkedList ( );
        String[] array = str.split (" ");

        for (int i = array.length - 1; i >= 0; i--) {

            if (array[i].equals ("+") || (array[i].equals ("-") || (array[i].equals ("*") || (array[i].equals ("/") || (array[i].equals ("^")))))) {
                if (stackList.isEmpty ( )) {
                    return null;
                }
                firstNum = stackList.pop ( );
                if (stackList.isEmpty ( )) {
                    return null;
                }
                secondNum = stackList.pop ( );
                double result = (prefixOperator (array[i], firstNum, secondNum));
                stackList.push (result);

            } else {
                try {
                    stackList.push (Double.parseDouble (String.valueOf (array[i])));
                } catch (NumberFormatException a) {
                    return null;
                }
            }
        }
        double lastElement = stackList.pop ( );
        if (!stackList.isEmpty ( )) {
            //System.out.println ("Not a correct expression: You have extra numbers or operators " );
            return null;
        }
        return lastElement;
    }

    /**
     * A method that given a string containing any natural number N
     * or the characters: +, −, ∗, /, ∧, representing a prefix expression
     * where operands and operations are separated by spaces, computes and
     * returns the result using a array-based implementation.
     *
     * @param str the string representing the prefix expression.
     * @return the result of the prefix expression, otherwise null
     * if the expression cannot be computed.
     */
    @Override
    public Double arrayPrefixCalc(String str) {
        double firstNum = 0;
        double secondNum = 0;
        StackArray newStack = new StackArray (str.length ( ));
        String[] array = str.split (" ");

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i].equals ("+") || (array[i].equals ("-") || (array[i].equals ("*") || (array[i].equals ("/") || (array[i].equals ("^")))))) {
                if (newStack.isEmpty ( )) {
                    return null;
                }
                firstNum = newStack.pop ( );
                if (newStack.isEmpty ( )) {
                    return null;
                }
                secondNum = newStack.pop ( );
                double result = (prefixOperator (array[i], firstNum, secondNum));
                newStack.push (result);

            } else {
                try {
                    newStack.push (Double.parseDouble (String.valueOf (array[i])));
                } catch (NumberFormatException a) {
                    return null;
                }
            }
        }
        double lastElement = newStack.pop ( );
        if (!newStack.isEmpty ( )) {
            //System.out.println ("Not a correct expression: You have extra numbers or operators " );
            return null;
        }
        return lastElement;
    }

    public static void main(String[] args) {
        Pena6 test = new Pena6 ( );
        String expression = "+ 4 * 3 2";
        System.out.println (test.arrayPrefixCalc (expression));
        System.out.println (test.listPrefixCalc (expression));
    }
}



