package Lab6;

import Testers.LabInterfaces.Lab6Interface;

import javax.naming.OperationNotSupportedException;
import java.util.*;

/**
 * Name: Gabriel Vela
 * Class: CS2401 Elementary Data Structures
 * Date: July 24, 2017
 * Lab 6
 */

public class Vela6 implements Lab6Interface {

    /**
     * A static class to help implement the IntNode class, and help create the basis for a linked list.
     */
    static class IntNode {
        double data;
        IntNode next;


        IntNode(double data, IntNode next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * A static class that is code that was provided by Dr.Urenda to help provide the groundwork to help create a linked
     * implementation of a 'Stack' using the IntNode class.
     */
    static class StackLL {
        //A variable that is set to the 'top' of the linked list stack.
        private IntNode top;

        /**
         * Default constructor for a linked list stack, sets the top to 'null'.
         */
        public StackLL() {
            top = null;
        }

        /**
         * A method to check if the linked list stack is empty or not.
         *
         * @return a boolean value that will return true if the stack happens to be empty, otherwise it will return false.
         */
        public boolean isEmpty() {
            return top == null;
        }

        /**
         * A method that is similar to the peek method in a Stack. It gets the data of the top-most node in the linked
         * list implementation of a Stack.
         * @return the data of the top node in the stack.
         */
        public double getTop() {
            return top.data;
        }

        /**
         * Similar to the push feature in a stack, this method allows for a given double to be 'pushed' into a stack,
         * bascially creating a new node and placing it at the top of the provided stack.
         *
         * @param newElem takes in a double as an argument and places it at the top of the stack.
         */
        public void push(double newElem) {
            IntNode nTop = new IntNode(newElem, top);
            top = nTop;
        }

        /**
         * Similar to the 'pop' function in a stack, it allows for the Linked List Stack implementation of 'pop'. Basically,
         * takes the recent double that was pushed onto the stack and returns it, all while simultaneously reducing the
         * size of the Linked list stack by 1.
         *
         * @return the node's data of the recent double that was pushed onto the stack.
         */
        public double pop() {
            double tmp = top.data;
            top = top.next;
            return tmp;
        }


    }

    /**
     * A static class that is code that was provided by Dr. Urenda to help provide the groundwork to help create a 'Stack'
     * using arrays.
     */
    static class StackAl {
        private double[] Stack;
        private int topIndex;

        /**
         * A method that will create a stack using an Array of the given size that is provided by the integer in
         * the argument.
         *
         * @param maxCap an integer value that determines the length or size of the Stack.
         */
        public StackAl(int maxCap) {
            Stack = new double[maxCap];
            topIndex = -1;
        }

        /**
         * A method that checks if the Array stack implementation is empty, if it is, it will return true,
         * otherwise it returns true.
         * @return true if the array is empty, otherwise it will return false.
         */
        public Boolean isEmpty() {
            return topIndex == -1;
        }

        /**
         * Checks if the stack is full.
         * @return true if it is, false if it isn't.
         */
        public Boolean isFull() {
            try{
                return topIndex == (Stack.length - 1);
            }catch(NoSuchElementException e){
                return null;
            }
            //include exception
        }

        /**
         * Similar to the push in a stack, it will push a given double into the stack. Thus expanding the size of the stack by 1.
         * @param newElem the double that will be added to the array.
         */
        public void push(double newElem) {
            try {
                topIndex++;
                Stack[topIndex] = newElem;
            }catch(InputMismatchException e) {
            }
            //include exception
        }

        /**
         * Similar to the pop in a Stack, it will pop the last double that was pushed onto a stack.
         * @return the recently pushed double that was placed at the top of the stack.
         */
        public double pop() {
            double tmp = Stack[topIndex];
            topIndex--;
            return tmp;
        }

    }

    /**
     * A method to check a given string if it can be parsed as a double or not. If it can it will return true, if not,
     * then it will return false.
     *
     * @param str the string parameter that will be checked.
     * @return the boolean value. Either true or false.
     */
    public static Boolean isNumber(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * A method that uses a linked list and
     * will return the final double after evaluating a given string as a Prefix Notation.
     *
     * @param str the string representing the postfix expression.
     * @return a double value that will be the final result after evaluating the given string in prefix notation form.
     */
    @Override
    public Double listPrefixCalc(String str) {
        double finalDbl;

        int totalCount;

        String input[];

        double number;

        try {

            input = str.split("\\s+");
            totalCount = input.length;

            StackLL stack = new StackLL();

            if (str.length() >= 1) {
                for (int i = totalCount - 1; i >= 0; i--) {
                    if (input[i].equals("*")) {
                        finalDbl = stack.pop() * stack.pop();
                        stack.push(finalDbl);
                    } else if (input[i].equals("+")) {
                        finalDbl = stack.pop() + stack.pop();
                        stack.push(finalDbl);
                    } else if (input[i].equals("-")) {
                        finalDbl = stack.pop() - stack.pop();
                        stack.push(finalDbl);
                    } else if (input[i].equals("/")) {
                        finalDbl = stack.pop() / stack.pop();
                        stack.push(finalDbl);
                    } else if (input[i].equals("^")) {
                        finalDbl = Math.pow(stack.pop(), stack.pop());
                        stack.push(finalDbl);
                    } else if (isNumber(input[i])) {
                        number = Double.parseDouble(input[i]);
                        stack.push(number);
                    }
                }
                return stack.pop();
            } else {
                return null;
            }
        } catch (InputMismatchException e){
            return null;
        }
    }

    /**
     * A method that uses Arrays to implement a stack and
     * will return the final double after evaluating a given string as a Prefix Notation.
     *
     * @param str the string representing the postfix expression.
     * @return
     */
    @Override
    public Double arrayPrefixCalc(String str) {
        double finalDbl;

        int totalCount;

        String input[];

        double number;

        try {
            input = str.split("\\s+");
            totalCount = input.length;

            StackAl stack = new StackAl(totalCount);

            if (str.length() >= 1) {
                for (int i = input.length - 1; i >= 0; i--) {
                    if (input[i].equals("*")) {
                        finalDbl = stack.pop() * stack.pop();
                        stack.push(finalDbl);
                    } else if (input[i].equals("+")) {
                        finalDbl = stack.pop() + stack.pop();
                        stack.push(finalDbl);
                    } else if (input[i].equals("-")) {
                        finalDbl = stack.pop() - stack.pop();
                        stack.push(finalDbl);
                    } else if (input[i].equals("/")) {
                        finalDbl = stack.pop() / stack.pop();
                        stack.push(finalDbl);
                    } else if (input[i].equals("^")) {
                        finalDbl = Math.pow(stack.pop(), stack.pop());
                        stack.push(finalDbl);
                    } else if (isNumber(input[i])) {
                        number = Double.parseDouble(input[i]);
                        stack.push(number);
                    }

                /*(isNumber(trimmedInput[i])) {
                    number = Double.parseDouble(trimmedInput[i]);
                    stack.push(number);
                }
                else if(trimmedInput[i].equals("*")){
                    stack.push(stack.pop() * stack.pop());
                }*/
                }
                //finalDbl = stack.pop();
            /*switch(str.substring(0,str.length())){
                case "+": finalDbl = stack.pop() + stack.pop();
                    break;
                case "-": finalDbl = stack.pop() - stack.pop();
                    break;
                case "/": finalDbl = stack.pop() / stack.pop();
                    break;
                case "*": finalDbl = stack.pop() * stack.pop();
                    break;
                default: finalDbl = stack.pop();
                    break;
            }*/
                return stack.pop();
            } else {


                return null;
            }
        }catch(InputMismatchException e){
            return null;
        }
    }


    public static void main(String[] args) {
//        String str = "+ 4 * 3 2";
//        String rts = "+ 5 * 9 2";
//        Vela6 rip = new Vela6();
//
//        double t = rip.arrayPrefixCalc(str);
//        double r = rip.listPrefixCalc(rts);
//        System.out.println(t);
//
//        System.out.println(r);
    }
}
