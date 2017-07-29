package Lab6;

import Lab1.Wiggs;
import Testers.LabInterfaces.Lab6Interface;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Wiggs6 implements Lab6Interface {
    /**
     * listPrefixCalc instantiates a Stack of type double. It pushes, pops, and executes operands through
     * switch statements. It Uses a try and catch block to catch if null pointers and non existant numbers.
     * @param str
     * @return
     */
    public Double listPrefixCalc(String str) {
        LLStack<Double> myStack = new LLStack<>();
        String[] sp;
        Double num1;
        Double num2;
        Double num3;
        boolean b;
        try {
            for (int i = str.length() - 1; i > 0; i--) {
                sp = str.split(" ");
                if (!isNumber(Double.parseDouble(sp[i]))) throw new IOException("Not a number");
                b = isOperand(sp[i]);
                if (b == true) {
                    switch (sp[i]) {
                        case "*":
                            if (myStack.pop() == null) throw new IOException("Pop is null");
                            num1 = myStack.pop();
                            if (myStack.pop() == null) throw new IOException("Pop is null");
                            num2 = myStack.pop();
                            num3 = (num1 * num2);
                            myStack.push(num3);
                            break;
                        case "/":
                            if (myStack.pop() == null) throw new IOException("Pop is null");
                            num1 = myStack.pop();
                            if (myStack.pop() == null) throw new IOException("Pop is null");
                            num2 = myStack.pop();
                            num3 = (num1 / num2);
                            myStack.push(num3);
                            break;
                        case "+":
                            if (myStack.pop() == null) throw new IOException("Pop is null");
                            num1 = myStack.pop();
                            if (myStack.pop() == null) throw new IOException("Pop is null");
                            num2 = myStack.pop();
                            num3 = (num1 + num2);
                            myStack.push(num3);
                            break;
                        case "-":
                            if (myStack.pop() == null) throw new IOException("Pop is null");
                            num1 = myStack.pop();
                            if (myStack.pop() == null) throw new IOException("Pop is null");
                            num2 = myStack.pop();
                            num3 = (num1 - num2);
                            myStack.push(num3);
                            break;
                    }
                } else {
                    myStack.push(Double.parseDouble(sp[i]));
                }
            }
            return myStack.pop();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * arrayPrefixCalc, much like listPrefixCalc, takes a String as a parameter and splits it into an array
     * of Strings with spaces. It instantiates a Stack with the length of the string - 1. Much like listPrefixCalc,
     * Switch statements are used to separate operators and operands along with exceptions to handle outlying information.
     * @param str
     * @return
     */
    public Double arrayPrefixCalc(String str) {
        arrayStack StackA = new arrayStack(str.length() - 1);
        Double charDoub = 0.0;
        Double num1;
        Double num2;
        Double num3;
        String[] sp;
        boolean b = false;
        try {
            for (int i = str.length() - 1; i > 0; i--) {
                sp = str.split(" ");
                if (!isNumber(Double.parseDouble(sp[i]))) throw new IOException("This is not a number");
                b = isOperand(sp[i]);
                if (b == true) {
                    switch (sp[i]) {
                        case "*":
                            if (StackA.popA() == null) throw new IOException("Pop is null");
                            num1 = StackA.popA();
                            if (StackA.popA() == null) throw new IOException("Pop is null");
                            num2 = StackA.popA();
                            num3 = (num1 * num2);
                            StackA.pushA(num3);
                            break;
                        case "/":
                            if (StackA.popA() == null) throw new IOException("Pop is null");
                            num1 = StackA.popA();
                            if (StackA.popA() == null) throw new IOException("Pop is null");
                            num2 = StackA.popA();
                            num3 = (num1 / num2);
                            StackA.pushA(num3);
                            break;
                        case "+":
                            if (StackA.popA() == null) throw new IOException("Pop is null");
                            num1 = StackA.popA();
                            if (StackA.popA() == null) throw new IOException("Pop is null");
                            num2 = StackA.popA();
                            num3 = (num1 + num2);
                            StackA.pushA(num3);
                            break;
                        case "-":
                            if (StackA.popA() == null) throw new IOException("Pop is null");
                            num1 = StackA.popA();
                            if (StackA.popA() == null) throw new IOException("Pop is null");
                            num2 = StackA.popA();
                            num3 = (num1 - num2);
                            StackA.pushA(num3);
                            break;
                    }
                } else {
                    StackA.pushA(Double.parseDouble(sp[i]));
                }

            }
            return StackA.popA();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Determines whether or not sp is a operand or not.
     * @param sp
     * @return
     */
    public boolean isOperand(String sp) {
        boolean b = false;
        if ((sp.equals("*")) || (sp.equals("/")) || (sp.equals("-")) || (sp.equals("+"))) {
            b = true;
        }
        return b;
    }

    /**
     * isNumber determines whether or not
     * @param n
     * @return
     */
    public boolean isNumber(Double n) {
        return ((n > 0) || (n < 0));
    }


    public static void main(String[] args) {
//        String str = "* + 5.0 4.0 + 3.0 5.0";
//        Double x = listPrefixCalc(str);
//        Double y = arrayPrefixCalc(str);
//        System.out.print(x + " " + y);
    }


    static class Node<E> {// Class of nodes to implement into Stack for array and stack for linked list
        E data;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.data = value;
            this.next = next;
        }
    }

    static class LLStack<E> { // Creates a Stack for linked list with generic type E
        Node<E> top;
        int size;

        public LLStack() {
            top = null;
            size = 0;
        }

        /**
         * Checks if list is empty
         * @return
         */
        public boolean isEmpty() {
            return top == null;
        }

        /**
         * push takes a newElement and puts it at the top of the stack
         * @param newElement
         */
        public void push(E newElement) {
            if (isEmpty()) {
                top = new Node<>(newElement, null);
                size++;
            } else {
                top.next = new Node<>(newElement, top);
                top = top.next;
                size++;
            }
        }

        /**
         * returns the value at the top of the stack and makes sure to point behind it.
         * @return
         */
        public E pop() {
            if (isEmpty()) {
                throw new NoSuchElementException("Element does not exist");
            } else {
                Node<E> tmp = top;
                top = null;
                size--;
                return tmp.data;
            }

        }
    }

    static class arrayStack { // Creates a stack for array
        int topIndex;
        Double[] A;

        public arrayStack(int maxCap) { //Constructor for arrayStack
            topIndex = -1;
            A = new Double[maxCap];
        }

        public boolean isEmptyA() {
            return topIndex == -1;
        } //Checks if Stack is empty

        /**
         * pushA inserts newElemetnat the top/head of the array
         * @param newElement
         */
        public void pushA(Double newElement) {
            try {
                Wiggs6 k = new Wiggs6();
                if (topIndex > A.length - 1) throw new IndexOutOfBoundsException("No more space");//no more space
                if (!k.isNumber(newElement)) throw new IOException("Not a number"); //if newElement isn't a number
                topIndex++; //Increment index and insert new element to the top;
                A[topIndex] = newElement;
            } catch (IndexOutOfBoundsException | IOException e) {
                return;
            }
        }

        /**
         * popA returns the element at the top of the array
         * @return
         */
        public Double popA() {
            try {
                if (isEmptyA()) {//can't pop something that isn't there
                    throw new NoSuchElementException("No element to be popped");
                } else {
                    Double tmp = A[topIndex];
                    topIndex--;
                    return tmp;
                }
            } catch (NoSuchElementException e) {
                return null;
            }
        }

    }
}

