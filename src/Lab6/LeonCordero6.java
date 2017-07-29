package Lab6;

import Testers.LabInterfaces.Lab6Interface;

public class LeonCordero6 implements Lab6Interface {

    static class StackException extends RuntimeException {
        /**
         * Constructor for the stack exception.
         * @param message (String) message to print.
         */
        public StackException(String message) {
            super(message);
        }

        /**
         * Constructor for the stack exception without message.
         */
        public StackException() {
            super();
        }
    }
    static class DoubleNode{
        public Double data;
        public DoubleNode next;

        /**
         * This method allows the object to be populated as well as to point towards other nodes.
         * @param data (int - holds data of type int in the node)
         * @param next (intNode - pointer towards the next node)
         */
        public DoubleNode(Double data, DoubleNode next) {
            this.data = data;
            this.next = next;
        }
    }
    static class ArrayStack {
        private Double[] stack;
        private int high;

        /**
         * Default constructor for the stack. It takes in a value that serves as the length
         * of the stack. and creates an array that will act as a vertical stack.
         * @param capacity (int) the length of the stack.
         */
        public ArrayStack(int capacity) {
                stack = new Double[capacity];
                high = -1;
        }

        /**
         * push receives an element of type int to add to the stack. If the stack is full,
         * it throws an exception and doesn't add the element. Else, it adds the element
         * to the top of the stack.
         * @param newElem
         */
        public void push(Double newElem) {
            high++;
            stack[high] = newElem;
        }

        /**
         * pop stores the element at the top of the stack in a temporary variable and
         * "frees up" its storage space in the array, then returns the element stored in
         * the temporary variable.
         * @return (int) the number that was at the top of the stack.
         */
        public Double pop() {
            if(high == -1)
                return null;
            Double tmp = stack[high];
            high--;
            return tmp;
        }
    }
    static class LLStack {
        private DoubleNode top;

        /**
         * Constructor for the Linked-List Stack.
         */
        public LLStack() {
            top = null;
        }

        /**
         * push creates a new node in the Linked List and assigns it as the new top.
         * @param newElem (Double) The value that the new node is to hold.
         */
        public void push(Double newElem) {
            DoubleNode newTop = new DoubleNode(newElem, top);
            top = newTop;
        }

        /**
         * pop stores the value of the head node, makes the pointer of the head node to the next node so the head is
         * essentially lost, then returns the value that was contained in the previous head node.
         * @return
         */
        public Double pop() {
            if(top == null) {
                return null;
            }
            Double temp = top.data;
            top = top.next;
            return temp;
        }
    }

    /**
     * performOperation receives the String which holds the operation to conduct, then depending on what the value is,
     * it takes the firstOperand and secondOperand values it receives and subjects them to their respective operation.
     * In division, if the second operand (denominator) is 0, then it returns null, which throws an exception due to
     * division by 0.
     * @param operation (String) This string holds the value of the type of operation to conduct.
     * @param firstOperand (Double) The value of the first operand.
     * @param secondOperand (Double) The value of the second operand.
     * @return (Double) returns the result of the operation conducted.
     */
    private static Double performOperation(String operation, Double firstOperand, Double secondOperand) {
        Double result;
        if(operation.equals("+")) {
            result = firstOperand + secondOperand;
        }
        else if(operation.equals("-")) {
            result = firstOperand - secondOperand;
        }
        else if(operation.equals("*")) {
            result = firstOperand * secondOperand;
        }
        else if(operation.equals("/")) {
            if(secondOperand.equals(0)) {
                return null;
            }
            result = firstOperand / secondOperand;
        }
        else {
            result = Math.pow(firstOperand, secondOperand);
        }
        return result;
    }

    /**
     * This is the method that calculates expressions in the prefix notation using a Linked List (LL) implementation
     * of a stack.
     * It first reads a string, then for every space, places the values before the space in an individual index of a
     * String array. Then, it reads every element in the String array and depending on its value, it either pushes it
     * into the LinkedList as a node, or it pops the two previous LL nodes and then proceeds to use their data to
     * perform an operation. After it does an operation, it stores the results of the operation back in the LL as a node.
     * The process continues until there are no more indices to read in the String array, and returns the data of the
     * last node. Otherwise, if the value in the String array is not a number or a valid operation, the program throws
     * an exception and returns null.
     * @param str (String) This is the string to be read.
     * @return (Double) This is the result of the calculation.
     */
    public Double listPrefixCalc(String str){
        String[] values = str.split(" ");
        LLStack stack = new LLStack();

        try {
            for (int i = values.length - 1; i >= 0; i--) {
                if (values[i].equals("+") || values[i].equals("/") || values[i].equals("*") || values[i].equals("-") || values[i].equals("^")) {
                    Double firstOperand = stack.pop();
                    Double secondOperand = stack.pop();
                    if(firstOperand == null || secondOperand == null) {
                        throw new StackException();
                    }

                    Double result = performOperation(values[i], firstOperand, secondOperand);
                    if(result == null) {
                        throw new ArithmeticException("Division by 0.");
                    }

                    stack.push(result);
                } else {
                    stack.push(Double.valueOf(values[i]));
                }
            }
        } catch(StackException e) {
            System.out.println("Not in prefix notation.");
            return null;
        } catch(NumberFormatException n) {
            System.out.println("The string contains a character therefore the calculation could not be completed.");
            return null;
        } catch(ArithmeticException a) {
            System.out.println(a.getMessage());
            return null;
        }
        return stack.pop();
    }

    /**
     * Using the same logic as listPrefixCalc, arrayPrefixCalc computes an expression in prefix notation.
     * However, this method uses an array implementation of a stack. There is no need to safe-catch pushing a value onto
     * a full stack however, since the stack array created is based on the length of the String array and could never
     * have more elements than that.
     *
     * It first reads a string, then for every space, places the values before the space in an individual index of a
     * String array. Then, it reads the value at the indices of the String array and performs its respective operation.
     * If it is a number, it pushes the number on the stack. Else, if it is an operation, it pops two elements from the
     * stack, then calls on the method performOperation to perform its respective operation. It then pushes the result
     * on to the stack, if not null. If null, it throws a "Division by 0" and the method returns null. Else, if any
     * other character, it returns null because the expression is not in prefix notation.
     *
     * @param str (String) This is the string ot be read.
     * @return (Double) This is the result of the calculation.
     */
    public Double arrayPrefixCalc(String str){
        String[] values = str.split(" ");
        ArrayStack stack = new ArrayStack(values.length);

        try {
            for (int i = values.length - 1; i >= 0; i--) {
                if (values[i].equals("+") || values[i].equals("/") || values[i].equals("*") || values[i].equals("-") || values[i].equals("^")) {
                    Double firstOperand = stack.pop();
                    Double secondOperand = stack.pop();
                    if(firstOperand == null || secondOperand == null) {
                        throw new StackException();
                    }

                    Double result = performOperation(values[i], firstOperand, secondOperand);
                    if(result == null) {
                        throw new ArithmeticException();
                    }

                    stack.push(result);
                } else {
                    stack.push(Double.valueOf(values[i]));
                }
            }
        } catch(StackException e) {
            return null;
        } catch(NumberFormatException n) {
            return null;
        } catch(ArithmeticException a) {
            System.out.println(a.getMessage());
            return null;
        }
        return stack.pop();
    }
}
