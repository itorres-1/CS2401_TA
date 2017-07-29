package Lab6;

import Testers.LabInterfaces.Lab6Interface;

import java.util.ArrayList;
/**
 * Author: Ricardo Alvarez
 * Assignment: Lab 5
 * Instructor: Julio Urenda
 * T.A.: Isaac Torres
 * Date of Last Modification: July 25th, 2017
 * Purpose: Calculates a prefix expression using stacks made out of arrays or linked lists
 */

public class Alvarez6 implements Lab6Interface {

    static class ArrStack {
        ArrayList<String> content = new ArrayList<>();
        int length = 0;

        /**
         * Init constructor
         */
        public ArrStack () {
        }

        /**
         * Constructor of an array stack from a arrayList of strings
         * @param a arraylist of strings where values will be gathered
         */
        public ArrStack (ArrayList<String> a) {
            for (int i=0; i<a.size(); i++) {
                content.add(a.get(i));
            }
            length = content.size();
        }

        /**
         * add a new value to the stack
         * @param str value to be added
         */
        public void push(String str) {
            content.add(str);
            length++;
        }

        /**
         * get value of the top of stack and remove it from the stack
         * @return value of the top of stack
         */
        public String pop () {
            String a = content.get(content.size()-1);
            content.remove(content.size()-1);
            length--;
            return a;
        }
    }
    static class stackNode {
        String content;

        /**
         * init constructor
         */
        public stackNode() {

        }

        /**
         * Constructor which will set a string as value of the node
         * @param str value to be collected
         */
        public stackNode (String str) {
            content = str;
        }
    }
    static class stackLL {
        stackNode myNode = new stackNode();
        int length;
        stackLL tail = this;
        stackLL next;
        stackLL prev;

        /**
         * init constructor
         */
        public stackLL () {

        }

        /**
         * Constructor setting the value of the node to a string
         * @param str value to be collected
         */
        public stackLL (String str) {
            myNode = new stackNode(str);
        }

        /**
         * Constructor to create a linked list stack out of an arraylist of strings
         * @param a arraylist of strings from which values will be gathered
         */
        public stackLL (ArrayList<String> a) {
            myNode.content = a.get(0);
            stackLL iter = this;
            length = 1;
            for (int i=1; i<a.size(); i++) {
                iter.next = new stackLL(a.get(i));
                iter.next.prev = iter;
                iter = iter.next;
                this.length++;
            }
            tail = iter;
        }

        /**
         * Add a node to the top of the stack
         * @param str value of the node to be added
         */
        public void push(String str) {
            if (length > 0) {
                stackLL iter = tail;
                iter.next = new stackLL(str);
                iter.next.prev = iter;
                tail = tail.next;
                this.length++;
            }
            else {
                myNode.content = str;
            }
        }

        /**
         * Gather the top value of the stack and remove that node
         * @return Value of the top of the stack
         */
        public String pop() {
            String output = tail.myNode.content;
            tail = tail.prev;
            length--;
            return output;
        }
    }

    /**
     * Gathers the resulting prefix function from an arrayStack and computes the result
     * @param stack1 stack to be computed
     * @return result of prefix operation
     */
    public Double arrPrefHelper (ArrStack stack1) {
        String a = stack1.pop();
        Double operand1;
        Double operand2;
        Double result;
        if (a.compareTo("+")==0) {
            operand1 = arrPrefHelper(stack1);
            operand2 = arrPrefHelper(stack1);
            result = operand1 + operand2;
            return result;
        }
        else if (a.compareTo("-")==0) {
            operand1 = arrPrefHelper(stack1);
            operand2 = arrPrefHelper(stack1);
            result = operand1 - operand2;
            return result;
        }
        else if (a.compareTo("*")==0) {
            operand1 = arrPrefHelper(stack1);
            operand2 = arrPrefHelper(stack1);
            result = operand1 * operand2;
            return result;
        }
        else if (a.compareTo("/")==0) {
            operand1 = arrPrefHelper(stack1);
            operand2 = arrPrefHelper(stack1);
            result = operand1 / operand2;
            return result;
        }
        else if (a.compareTo("^")==0) {
            operand1 = arrPrefHelper(stack1);
            operand2 = arrPrefHelper(stack1);
            result= 1.0;
            for (int i=0; i<operand2; i++) {
                result = result*operand1;
            }
            return result;
        }
        else {
            return Double.parseDouble(a);
        }
    }

    /**
     * Gathers the resulting prefix function from an linkedListStack and computes the result
     * @param stack1 stack to be computed
     * @return result of prefix operation
     */
    public Double listPrefHelper (stackLL stack1) {
        String a = stack1.pop();
        Double operand1;
        Double operand2;
        Double result;
        if (a.compareTo("+")==0) {
            operand1 = listPrefHelper(stack1);
            operand2 = listPrefHelper(stack1);
            result = operand1 + operand2;
            return result;
        }
        else if (a.compareTo("-")==0) {
            operand1 = listPrefHelper(stack1);
            operand2 = listPrefHelper(stack1);
            result = operand1 - operand2;
            return result;
        }
        else if (a.compareTo("*")==0) {
            operand1 = listPrefHelper(stack1);
            operand2 = listPrefHelper(stack1);
            result = operand1 * operand2;
            return result;
        }
        else if (a.compareTo("/")==0) {
            operand1 = listPrefHelper(stack1);
            operand2 = listPrefHelper(stack1);
            result = operand1 / operand2;
            return result;
        }
        else if (a.compareTo("^")==0) {
            operand1 = listPrefHelper(stack1);
            operand2 = listPrefHelper(stack1);
            result= 1.0;
            for (int i=0; i<operand2; i++) {
                result = result*operand1;
            }
            return result;
        }
        else {
            return Double.parseDouble(a);
        }
    }
    /**
     * Calculates a prefix expression out of a string using a stack made out of arrays
     * @param str the string representing the postfix expression.
     * @return value of the prefix expression
     */
    public Double listPrefixCalc(String str){
        try {
            String[] auxArr = str.split(" ");
            ArrayList<String> auxAL = new ArrayList<>();
            for (int i=0; i<auxArr.length; i++){
                auxAL.add(0,auxArr[i]);
            }
            stackLL stack1 = new stackLL(auxAL);
            return listPrefHelper(stack1);
        }
        catch (Exception general) {
            System.out.println("Invalid Input");
            return null;
        }
    }
    /**
     * Calculates a prefix expression out of a string using a stack made out of a linked list
     * @param str the string representing the postfix expression.
     * @return value of the prefix expression
     */
    public Double arrayPrefixCalc(String str) {
        try {
            String[] auxArr = str.split(" ");
            ArrayList<String> auxAL = new ArrayList<>();
            for (int i=0; i<auxArr.length; i++){
                auxAL.add(0,auxArr[i]);
            }
            ArrStack stack1 = new ArrStack(auxAL);
            return arrPrefHelper(stack1);
        }
        catch (Exception general) {
            System.out.println("Invalid Input");
            return null;
        }
    }

    public static void main (String[] args) {
        Alvarez6 cCheck = new Alvarez6();
        Double a = cCheck.listPrefixCalc("- / + 18 9 - 8 5 2");
        System.out.println(a);
        Double b = cCheck.arrayPrefixCalc("^ 2 3");
        System.out.println(b);
    }
}
