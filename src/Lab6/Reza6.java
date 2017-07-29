package Lab6;

import Testers.LabInterfaces.Lab6Interface;

/**
 * CS2401: Elementary Data Structures and Algorithms
 * Instructor: Julio Urenda
 * Teaching Assistant: Isaac Torres
 * Assignment: Lab 6
 * Modified and submitted by: Raul Reza
 * Last modification: 7/25/2017
 * Purpose: Takes a string with a prefix notation expression and computes it.
 */
public class Reza6 implements Lab6Interface {
    /**
     *Takes a string and computes the prefix notation contained in the string using the linked list method of Stacks.
     * @param str the string representing the prefix expression.
     * @return Double value of the computed prefix notation.
     */
    public Double listPrefixCalc(String str) {
        String[] string = str.split(" ");
        StackLL stack = new StackLL();

        try {
            for(int i = string.length - 1; i >= 0; i--){
                if(string[i].equals("+")){
                    Double OP1 = stack.pop();
                    Double OP2 = stack.pop();
                    Double Result = OP1 + OP2;
                    stack.push(Result);
                }
                else if(string[i].equals("-")){
                    Double OP1 = stack.pop();
                    Double OP2 = stack.pop();
                    Double Result = OP1 - OP2;
                    stack.push(Result);
                }
                else if(string[i].equals("*")){
                    Double OP1 = stack.pop();
                    Double OP2 = stack.pop();
                    Double Result = OP1 * OP2;
                    stack.push(Result);
                }
                else if(string[i].equals("/")){
                    Double OP1 = stack.pop();
                    Double OP2 = stack.pop();
                    Double Result = OP1 / OP2;
                    stack.push(Result);
                }
                else{
                    stack.push(Double.parseDouble(string[i]));
                }
            }
        } catch (StackException e){
            System.out.println(e.getMessage());
            return null;
        } catch (ArithmeticException a){
            System.out.println(a.getMessage());
            return null;
        } catch (NumberFormatException i){
            System.out.println("There is a character that cannot be read into the string.");
            return null;
        }
        return stack.pop();
    }

    /**
     *Takes a string and computes the prefix notation contained in the string using the array based method of Stacks.
     * @param str the string representing the prefix expression.
     * @return Double value of the computed prefix notation.
     */
    public Double arrayPrefixCalc(String str) {
        String[] string = str.split(" ");
        StackAB stack = new StackAB(string.length);
        try {
            for(int i = string.length - 1; i >= 0; i--){
                    if(string[i].equals("+")){
                        Double OP1 = stack.pop();
                        Double OP2 = stack.pop();
                        Double Result = OP1 + OP2;
                        stack.push(Result);
                    }
                    else if(string[i].equals("-")){
                        Double OP1 = stack.pop();
                        Double OP2 = stack.pop();
                        Double Result = OP1 - OP2;
                        stack.push(Result);
                    }
                    else if(string[i].equals("*")){
                        Double OP1 = stack.pop();
                        Double OP2 = stack.pop();
                        Double Result = OP1 * OP2;
                        stack.push(Result);
                    }
                    else if(string[i].equals("/")){
                        Double OP1 = stack.pop();
                        Double OP2 = stack.pop();
                        Double Result = OP1 / OP2;
                        stack.push(Result);
                    }
                    else{
                        stack.push(Double.parseDouble(string[i]));
                    }
                }
        }
        catch (StackException | ArithmeticException e){
            System.out.println(e.getMessage());
            return null;
        }
        catch (NumberFormatException e){
            System.out.println("There is a character that cannot be read into the string.");
            return null;
        }
        return stack.pop();
    }

    /**
     *Defines my DoubleNode class to use in the linked lists.
     */
    static class DoubleNode{
        public Double data;
        public DoubleNode next;

        /**
         * Constructor for the DoubleNode object.
         * @param data Double which is the data of the DoubleNode.
         * @param next DoubleNode which is the next node that is going to point.
         */
        public DoubleNode(Double data, DoubleNode next){
            this.data = data;
            this.next = next;
        }
    }

    /**
     *Defines my Linked List based Stack.
     */
    static class StackLL{
        private DoubleNode top;
        public StackLL(){
            top = null;
        }

        /**
         *Pushes a new element into the stack.
         * @param newElem Double which will be the value pushed into the stack.
         */
        public void push(Double newElem){
            DoubleNode nTop = new DoubleNode(newElem, top);
            top = nTop;
        }

        /**
         *Pops an element from the stack.
         * @return Double which will be the element being popped from the stack.
         */
        public Double pop(){
            if(top == null){
                throw new StackException("Stack is empty.");
            }
            Double tmp = top.data;
            top = top.next;
            return tmp;
        }
    }

    /**
     *Defines my Array based Stack.
     */
    static class StackAB{
        private Double[] s;
        private int topIndex;

        /**
         * Creates anarray of length maxCap.
         * @param maxCap integer which is the length of the array.
         */
        public StackAB(int maxCap){
            s = new Double[maxCap];
            topIndex = -1;
        }

        /**
         *Pushes a new element into the stack.
         * @param newElem Double which will be the element being pushed to the stack.
         */
        public void push(Double newElem){
            if(topIndex == s.length){
                throw new StackException("Stack is full.");
            }
            topIndex++;
            s[topIndex] = newElem;
        }

        /**
         *Pops an element from the stack.
         * @return Double which is the element being popped from the stack.
         */
        public Double pop(){
            if(topIndex == -1){
                throw new StackException("Stack is empty.");
            }
            Double tmp = s[topIndex];
            topIndex--;
            return tmp;
        }
    }

    /**
     *Exception for things that go wrong in the stack.
     */
    static class StackException extends RuntimeException{
        /**
         * Constructor for the StackException object.
         * @param message String that will receive the message of the exception.
         */
        public StackException(String message){
            super(message);
        }
    }
    /**
     * Main method was used for testing purposes.
     * @param args Arguments
     */
//    public static void main(String[] args) {
//        String str = "/ + 1 2 * 3 + 4 5";
//        Double array = arrayPrefixCalc(str);
//        Double list = listPrefixCalc(str);
//        System.out.println(array);
//        System.out.println(list);
//    }
}
