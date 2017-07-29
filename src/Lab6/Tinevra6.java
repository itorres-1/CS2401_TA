package Lab6;

import Testers.LabInterfaces.Lab6Interface;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Tinevra6 implements Lab6Interface {

    @Override
    public Double listPrefixCalc(String str) {
        double result = 0.0;
        try {
            linkedList prefix = new linkedList();
            result = prefix.linkprefixCal(str);
        }catch (Exception general){
            return null;
        }
            

        return result;
    }

    @Override
    public Double arrayPrefixCalc(String str) {
        double result = 0.0;
        try {
            stack prefix = new stack();
            result = prefix.arrPrefixCalc(str);
        }catch (Exception general){
            return  null;
        }

        return result;
    }

    /**
     * Node class to use linkedLists
     */
    static class Node {
         String value;
         Node next;

         Node(String value, Node next) {
             this.value = value;
             this.next = next;
         }
     }

    /**
     * class linkedList, computes prefix operations with a linkedList.
     */
    static class linkedList{

        public Node top ;
        public int size ;

        public linkedList() {
            top = null;
            size = 0;
        }

        /*  Function to get the size of the stack */
        public int getSize() {
            return size;
        }

        /*  push */
        public void push(String value) {
            Node nptr = new Node (value, null);
            if (top == null) {
                top = nptr;
            }
            else {
                nptr.next =top;
                top = nptr;
            }
            size++ ;
        }

        /*  Function to pop an element from the stack */
        public String pop() {
            if (top == null) {
                throw new NoSuchElementException("Underflow Exception");
            }
            Node ptr = top;
            top = ptr.next;
            size-- ;
            return ptr.value;
        }

        /*  Function to check the top element of the stack */
        public String peek()
        {
            if (top == null )
                throw new NoSuchElementException("Underflow Exception") ;
            return top.value;
        }

        /*  Function to display the status of the stack */
        public void display()
        {
            System.out.print("\nStack = ");
            if (size == 0)
            {
                System.out.print("Empty\n");
                return ;
            }
            Node ptr = top;
            while (ptr != null)
            {
                System.out.print(ptr.value+" ");
                ptr = ptr.next;
            }
            System.out.println();
        }

        public Double linkprefixCal(String prefix){
            linkedList stackOne = new linkedList();

            String[] splitStr = prefix.split("\\s+");
            for (int i = 0; i <splitStr.length ; i++) {
                stackOne.push(splitStr[i]);
            }
            linkedList stackTwo = new linkedList();
            boolean check = true;

            //checking for the operand
            for (int i = 0; i < splitStr.length; i++) {
                String info = stackOne.pop();
                check = true;
                try{

                    if (info.equals("+")) {
                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if(first<0.0 ||second<0.0)throw new IOException();
                        double add = first + second;
                        String result = Double.toString(add);
                        stackTwo.push(result);
                        check = false;
                    }

                    if (info.equals("-")) {
                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if(first<0.0 ||second<0.0)throw new IOException();

                        double subtraction = first - second;
                        String result = Double.toString(subtraction);
                        stackTwo.push(result);
                        check = false;
                    }

                   if (info.equals("*")) {
                       double first = Double.parseDouble(stackTwo.pop());
                       double second = Double.parseDouble(stackTwo.pop());
                       if (first < 0.0 || second < 0.0) throw new IOException();

                       double multi = first * second;
                       String result = Double.toString(multi);
                       stackTwo.push(result);
                       check = false;
                   }

                    if (info.equals("/")) {
                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if (first < 0.0 || second < 0.0) throw new IOException();

                        double division = first / second;
                        String result = Double.toString(division);
                        stackTwo.push(result);
                        check = false;
                    }

                    if (info.equals("^")) {
                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if (first < 0.0 || second < 0.0) throw new IOException();

                        double pow = powCal(first, second);


                        String result = Double.toString(pow);
                        stackTwo.push(result);
                        check = false;
                    }

                    //if no operation made push info
                    if (check == true) {
                        stackTwo.push(info);
                    }
                }catch (NullPointerException | NumberFormatException |  NoSuchElementException  | IOException e2 ) {
                    System.out.println("error");
                    return null;
                }
            }
            return Double.parseDouble(stackTwo.peek());
        }
    }

    /**
     * class Stack, computes prefix operations with an array.
     */
    static class stack{
        final int size = 10000;
        String[] array = new String[size];
        int top = -1;

        /**
         * push method will push an element at the end of the stack
         * @param info a string that will be pushed to the end of the stack
         */
        public void push(String info) {
            if (top == size - 1) {
                System.out.println("error");
                return;
            }
            top++;
            array[top] = info;
        }

        /**
         * pop method will pop the last element in a stack
         * @return the information of the last element in the Stack
         */
        public String pop() {
            if (top == -1) {
                return "";
            }
            String temp = array[top];
            top--;
            return temp;

        }

        /**
         * head  method will return the head of the stack
         * @return the information of the head
         */
        public String head() {
            if (top == 1) {
                return array[top];
            }
            if (top == -1) {
                return "";
            } else
                return array[top];
        }

        /**
         * print method, will print all the information of a stack
         */
        public void print() {
            for (int i = 0; i <= top; i++) {
                System.out.println(array[i]);
            }
        }

        /**
         * this method will compute prefix operations 
         * @param prefix a String with a prefix
         * @return a double which is the result of the prefix operation 
         */
        public Double arrPrefixCalc(String prefix) {
            stack stackOne = new stack();

            String[] splitStr = prefix.split("\\s+");

            //populating stack 1
            for (int i = 0; i < splitStr.length; i++) {
                stackOne.push(splitStr[i]);
            }

            stack stackTwo = new stack();
            boolean check = true;

            //checking for the operand
            for (int i = 0; i < splitStr.length; i++) {
                String info = stackOne.pop();
                check = true;
                try {
                    if (info.equals("+")) {
                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if (first < 0.0 || second < 0.0) throw new IOException();

                        double add = first + second;
                        String result = Double.toString(add);
                        stackTwo.push(result);
                        check = false;
                    }


                    if (info.equals("-")) {

                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if (first < 0.0 || second < 0.0) throw new IOException();

                        double subtraction = first - second;
                        String result = Double.toString(subtraction);
                        stackTwo.push(result);
                        check = false;
                    }

                    if (info.equals("*")) {
                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if (first < 0.0 || second < 0.0) throw new IOException();

                        double multi = first * second;
                        String result = Double.toString(multi);
                        stackTwo.push(result);
                        check = false;
                    }

                    if (info.equals("/")) {
                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if (first < 0.0 || second < 0.0) throw new IOException();

                        double division = first / second;
                        String result = Double.toString(division);
                        stackTwo.push(result);
                        check = false;
                    }

                    if (info.equals("^")) {
                        double first = Double.parseDouble(stackTwo.pop());
                        double second = Double.parseDouble(stackTwo.pop());
                        if (first < 0.0 || second < 0.0) throw new IOException();

                        double pow = powCal(first, second);


                        String result = Double.toString(pow);
                        stackTwo.push(result);
                        check = false;
                    }
                    //if no operation made push info
                    if (check == true) {
                        stackTwo.push(info);
                    }
                }catch (NullPointerException | NumberFormatException | IOException e2) {
                    System.out.println("error");
                    return null;
                }
            }
            return Double.parseDouble(stackTwo.head());
        }
    }

    /**
     * This method computes the power of two doubles
     * @param base A double for which the computation is the base
     * @param power a double for which the base is going to be power
     * @return a double of the result of the base with the power
     */
    public static double powCal(double base, double power) {
        if (power == 0) return 1;
        return base * powCal(base, --power);
    }
    

   /* public static void main(String[] args) {
        Tinevra6 samEsGay = new Tinevra6();
        String x = "+ 3 1";
        Double c = samEsGay.listPrefixCalc(x);
        System.out.println(c);
    }*/

}




