/**
 * Author: Cesar Valenzuela
 * Date: 7/25/2017
 * Course: CS 2401
 * Assignment: Lab6
 * Instructor: Julio C. Urenda
 * T.A: Isaac Torres
 */
package Lab6;

import Testers.LabInterfaces.Lab6Interface;


public class Valenzuela6 implements Lab6Interface {
    /**
     * A method that given a string, calculates an expression in prefix notation.
     * It extracts the numbers within the string and places them in a stack
     * implemented by a Linked List.
     * It applies the corresponding operations to the operands from right to left
     * @param str string containing an expression in prefix notation.
     * @return a Double, that corresponds to the result of the overall expression.
     */
    @Override
    public Double listPrefixCalc(String str) {
        String[] tempArrayL = str.split("[ ]");
        stackLinkedList numStackList = new stackLinkedList();

        for (int i = 0; i < tempArrayL.length; i++) {
            if (tempArrayL[i].matches("[0-9]+")) {
                int tempNum = Integer.parseInt(tempArrayL[i]);
                numStackList.push(tempNum);
            }
        }

        for (int i = tempArrayL.length - 1; i >= 0; i--) {
            if (tempArrayL[i].matches("[+]")) {
                double a = numStackList.pop();
                double b = numStackList.pop();
                numStackList.push(b + a);
            } else if (tempArrayL[i].matches("[-]")) {
                double a = numStackList.pop();
                double b = numStackList.pop();
                numStackList.push(b - a);
            } else if (tempArrayL[i].matches("[*]")) {
                double a = numStackList.pop();
                double b = numStackList.pop();
                numStackList.push(b * a);
            } else if (tempArrayL[i].matches("[/]")) {
                double a = numStackList.pop();
                double b = numStackList.pop();
                numStackList.push(b / a);
            } else if (tempArrayL[i].matches("[\\^]")) {
                double a = numStackList.pop();
                double b = numStackList.pop();
                numStackList.push(Math.pow(b, a));
            }
        }
        return numStackList.pop();
    }

    /**
     * A method that given a string, calculates an expression in prefix notation.
     * It extracts the numbers within the string and places them in a stack
     * implemented by an Array.
     * It applies the corresponding operations to the operands from right to left.
     * @param str string containing an expression in prefix notation.
     * @return a Double, that corresponds to the result of the overall expression.
     */
    @Override
    public Double arrayPrefixCalc(String str) {
        String[] tempArray = str.split("[ ]");
        stackAB numStackArray = new stackAB(tempArray.length);

        //Adding numbers to the stack
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i].matches("[0-9]+")) {
                double tempNum = Double.parseDouble(tempArray[i]);
                numStackArray.push(tempNum);
            }

        }
        //Matching the operations and applying them
        for (int i = tempArray.length - 1; i >= 0; i--) {
            if (tempArray[i].matches("[+]")) {
                double a = numStackArray.pop();
                double b = numStackArray.pop();
                numStackArray.push(b + a);
            } else if (tempArray[i].matches("[-]")) {
                double a = numStackArray.pop();
                double b = numStackArray.pop();
                numStackArray.push(b - a);
            } else if (tempArray[i].matches("[*]")) {
                double a = numStackArray.pop();
                double b = numStackArray.pop();
                numStackArray.push(b * a);
            } else if (tempArray[i].matches("[/]")) {
                double a = numStackArray.pop();
                double b = numStackArray.pop();
                numStackArray.push(b / a);
            } else if (tempArray[i].matches("[\\^]")) {
                double a = numStackArray.pop();
                double b = numStackArray.pop();
                numStackArray.push(Math.pow(b, a));
            }
        }
        return numStackArray.pop();
    }

    static class doubleNode {
        double data;
        doubleNode next;

        public doubleNode(double myData, doubleNode myNext) {
            data = myData;
            next = myNext;
        }
    }

    static class stackLinkedList {
        private doubleNode top;
        int size;

        //constructor
        public stackLinkedList() {
            top = null;
            size = 0;
        }

        //operations
        public boolean isEmpty() {
            return top == null;
        }

        public double getTop() {
            return top.data;
        }

        public void push(double newElem) {
            doubleNode nTop = new doubleNode(newElem, top);
            top = nTop;
        }

        //include exception handling
        public double pop() {
            double tmp = top.data;
            top = top.next;
            return tmp;
        }
    }

    static class stackAB {
        private double[] stackArray;
        private int topIndex;

        //constructor
        public stackAB(int maxCap) {
            stackArray = new double[maxCap];
            topIndex = -1;
        }

        //operations
        public boolean isEmpty() {
            return topIndex == -1;
        }

        public boolean isFull() {
            return topIndex == (stackArray.length - 1);
        }

        //include an exception
        public void push(double newElem) {
            if (topIndex + 1 < stackArray.length - 1) {
                topIndex++;
                stackArray[topIndex] = newElem;
            } else {
                System.out.println("Not Enough Room");
            }
        }

        //include an exception
        public double pop() {
            double tmp = stackArray[topIndex];
            topIndex--;
            return tmp;
        }

    }
}
