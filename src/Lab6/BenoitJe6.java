package Lab6; /**
 * Author: Jean-Maxon Benoit
 * Assignment: Lab 6
 * Instructor: Julio Urenda
 * TA: Isaac Torres
 * Last Modified 7/25/2017.
 * Purpose: To use stacks to compute a prefix notation expression
 */

import Testers.LabInterfaces.Lab6Interface;

import java.util.*;

public class BenoitJe6 implements Lab6Interface {
    /**
     * A class that constructs a linked list implementation of a stack.
     */
    static class StackLL {
        /**
         * A class that constructs a node for a linked list.
         */
        static class IntNode {
            public String data;
            public IntNode next;

            public IntNode(String dataIn, IntNode nextIn) {
                data = dataIn;
                next = nextIn;
            }
        }

        private IntNode top;

        //Constructor, isEmpty, and push are from the notes.
        public StackLL() {
            top = null;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void push(String nElem) {
            IntNode nTop = new IntNode(nElem, top);
            top = nTop;
        }

        public String pop() {
            String tmp = top.data;

            if (!isEmpty() && top.next != null) {
                top = top.next;
            }

            return tmp;
        }
    }

    /**
     * A class that constructs an array implementation of a stack.
     */
    static class StackAL {
        private String[] stackData;
        private int topIndex;

        //Constructor, isEmpty, and isFull are from the notes
        public StackAL(int maxCap) {
            stackData = new String[maxCap];
            topIndex = -1;
        }

        public boolean isEmpty() {
            return topIndex == -1;
        }

        public boolean isFull() {
            return topIndex == (stackData.length - 1);
        }

        public void push(String newElem) {
            if (!isFull()) {
                topIndex++;
                stackData[topIndex] = newElem;
            }
        }

        public String pop() {
            String tmp = stackData[topIndex];

            if (!isEmpty()) {
                topIndex--;
            }

            return tmp;
        }
    }

    /**
     * Given a string representing a prefix expression, evaluates the expression
     * by using a linked list implementation of a stack and returns a
     * Double representing the solution.
     *
     * @param str the string representing the prefix expression.
     * @return the solution to the prefix expression.
     */
    public Double listPrefixCalc(String str) {
        StackLL stack = new StackLL();
        String[] strArray = str.split(" ");
        Double solution = 0.0;

        for (String string : strArray) {
            stack.push(string);
        }

        try {
            ArrayList<Double> operands = new ArrayList();
            for (int i = strArray.length - 1; i >= 0; i--) {
                //If the top of the stack is a digit then pop it and put it in an ArrayList<Double>
                //If it's not a digit, check if it is an operation
                //If it's an operation, pop the top node and perform the operation
                if (strArray[i].matches("\\d+")) { //checks for digits TODO explain this!
                    operands.add(Double.parseDouble(stack.pop()));

                } else if (strArray[i].equals("+")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += (operands.get(operands.size() - 1) + operands.get(operands.size() - 2));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                } else if (strArray[i].equals("-")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += (operands.get(operands.size() - 1) - operands.get(operands.size() - 2));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                } else if (strArray[i].equals("*")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += (operands.get(operands.size() - 1) * operands.get(operands.size() - 2));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                } else if (strArray[i].equals("/")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += (operands.get(operands.size() - 1) / operands.get(operands.size() - 2));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                } else if (strArray[i].equals("^")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += Math.pow((operands.get(operands.size() - 1)), (operands.get(operands.size() - 2)));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                }
                solution = operands.get(0);
            }
        } catch (Exception e) {
            return null;
        }

        System.out.println(solution);
        return solution;
    } //listPrefixCalc has the same solution as arrayPrefixCalc

    /**
     * Given a string representing a prefix expression, evaluates the expression
     * by using an array implementation of a stack and returns a
     * Double representing the solution.
     *
     * @param str the string representing the prefix expression.
     * @return the solution to the prefix expression.
     */
    public Double arrayPrefixCalc(String str) {
        StackAL stack = new StackAL(str.length());
        String[] strArray = str.split(" ");
        Double solution = 0.0;

        for (String string : strArray) {
            stack.push(string);
        }

        try {
            ArrayList<Double> operands = new ArrayList();
            for (int i = strArray.length - 1; i >= 0; i--) {
                //If the top of the stack is a digit then pop it and put it in an ArrayList<Double>
                //If it's not a digit, check if it is an operation
                //If it's an operation, pop the top node and perform the operation
                if (strArray[i].matches("\\d+")) { //checks for digits
                    operands.add(Double.parseDouble(stack.pop()));

                } else if (strArray[i].equals("+")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += (operands.get(operands.size() - 1) + operands.get(operands.size() - 2));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                } else if (strArray[i].equals("-")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += (operands.get(operands.size() - 1) - operands.get(operands.size() - 2));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                } else if (strArray[i].equals("*")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += (operands.get(operands.size() - 1) * operands.get(operands.size() - 2));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                } else if (strArray[i].equals("/")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += (operands.get(operands.size() - 1) / operands.get(operands.size() - 2));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                } else if (strArray[i].equals("^")) {
                    stack.pop();
                    Double tmpSolution = 0.0;
                    tmpSolution += Math.pow((operands.get(operands.size() - 1)), (operands.get(operands.size() - 2)));
                    operands.remove(operands.size() - 1);
                    operands.set(operands.size() - 1, tmpSolution);

                }
                solution = operands.get(0);
            }
        } catch (Exception e) {
            return null;
        }

        System.out.println(solution);
        return solution;
    }

}
