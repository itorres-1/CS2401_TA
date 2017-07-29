package Lab6;

import Testers.LabInterfaces.Lab6Interface;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Andrea Fernanda Torres on 7/21/2017.
 * Cs 2401 Lab 6
 */
public class Torres6 implements Lab6Interface {

    //Custom Classes
    /**
     * This is the Stacks class that is implemented using arrays. The code for this has been modified from class given code
     *  to run more efficently and also to hold strings. This class has isEmpty(), isFull(), push(), pop(), peek() methods.
     */
    static class ArrayStacks {
        private String[] Stack;
        private int topIndex;

        public ArrayStacks(int maxCap){
            Stack=new String[maxCap];
            topIndex=-1;
        }
        public boolean isEmpty(){
            return topIndex==-1;
        }
        public boolean isFull(){
            return topIndex==(Stack.length-1);
        }
        public void push (String newElem){
            if (!isFull()) {
                topIndex++;
                Stack[topIndex] = newElem;
            }
        }
        public String pop(){
            if(!isEmpty()) {
                String tmp = Stack[topIndex];
                topIndex--;
                return tmp;
            }
            return null;
        }
        public String peek(){
            if (!isEmpty()){
                return  Stack[topIndex];
            }
            return null;
        }
    }

    /**
     * This is the Stack class using linked list most of the code was given in class, with a few modifications. This class
     * relies on the StringNode class. This has been modified to hold strings.
     */
    static class LinkedListStacks{
        private StringNode top;
        public LinkedListStacks(){
            top=null;
        }
        public boolean isEmpty(){
            return top==null;
        }
        public String getTop(){
            return top.data;
        }
        public void push(String newElem){
            StringNode nTop= new StringNode(newElem,top);
            top=nTop;
        }
        public String pop(){
            String tmp=top.data;
            top=top.next;
            return tmp;
        }
    }

    /**
     * This is the String Node class and is used by the LinkedListStacks class. The nodes hold a string and a pointer to the
     * next string( the string that would be under if visualizing as a stack of boxes.)
     */
    static class StringNode{
        String data;
        StringNode next;

        public StringNode(String d,StringNode nxt){
            data=d;
            next=nxt;
        }
    }

    /**
     * This method is used in deteriming if a substring is numeric. It is used in both the linked list implementation
     * andthe array stack implementation. This will take in the parameter str and will first determine if the length is
     * greater than 1 is it is it will check each individual element to see if it is a digit 0-9. This method is helpful
     * in catching faulty code such as: str=*123 ,str=100/ str=-11. Because the assignment specified that only
     * non-negative numbers should pass the case where str=-12 will result in saysing that the input is false.
     * @param str this is a subset of the orignal input string. we get this from using the split " " method.
     * @return returns a boolean value to tell weather a sub string is a number or not.
     */
    public static boolean isNumeric(String str){
        boolean ans;
        try{
            if(str.length()>1){
                for(int i=0;i<str.length();i++) {
                    ans = isNumeric(str.substring(i, i));
                    if (!ans) {
                        return false;
                    }
                }
            }else {
                double d = Double.valueOf(str);
            }
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    //Array

    /**
     * This method is used for grading purposes. This method passes a string str calls on aLprefixCalc and returns a Double.
     * This method
     * @param str the string representing the postfix expression.
     * @return solution for str assuming it is good code else returns null.
     */
    public Double arrayPrefixCalc(String str) {
        try {
            return aLprefixCalc(str);
        }catch (NullPointerException npe){
            return null;
        }
    }

    /**
     * This method is the arrayList Stack implementation of preFix notation. IT is called on by arrayPrefixCalc and it
     * calls on ArrayStacks class.
     * @param str is the string that we would like to find a solution for.
     * @return is the solution of str if is is good, else it returns null.
     */
    private  Double aLprefixCalc(String str){
        ArrayStacks numStack;
        try{
            String[] hold=str.split(" ");
            ArrayStacks raw=new ArrayStacks(hold.length);
            numStack=new ArrayStacks(hold.length);
            for(int i=0;i<hold.length;i++){
                raw.push(hold[i]);
            }
            while(!raw.isEmpty()){
                if(isNumeric(raw.peek())){
                    numStack.push(raw.pop());
                }else if(raw.peek().equals("+")){
                    double tmp1=Double.parseDouble(numStack.pop());
                    double tmp2=Double.parseDouble(numStack.pop());
                    numStack.push(String.valueOf(tmp1+tmp2));
                    raw.pop();

                }else if(raw.peek().equals("-")){
                    double tmp1=Double.parseDouble(numStack.pop());
                    double tmp2=Double.parseDouble(numStack.pop());
                    numStack.push(String.valueOf(tmp1-tmp2));
                    raw.pop();

                }else if(raw.peek().equals("*")){
                    double tmp1=Double.parseDouble(numStack.pop());
                    double tmp2=Double.parseDouble(numStack.pop());
                    numStack.push(String.valueOf(tmp1*tmp2));
                    raw.pop();

                }else if(raw.peek().equals("/")){
                    double tmp1=Double.parseDouble(numStack.pop());
                    double tmp2=Double.parseDouble(numStack.pop());
                    numStack.push(String.valueOf(tmp1/tmp2));
                    raw.pop();

                }else if(raw.peek().equals("^")){
                    double tmp1=Double.parseDouble(numStack.pop());
                    double tmp2=Double.parseDouble(numStack.pop());
                    double number=Math.pow(tmp1,tmp2);
                    numStack.push(String.valueOf(number));
                    raw.pop();
                }
            }
            //numStack.push("-99");

        }catch(NullPointerException npe){
            return null;
        }
        return Double.parseDouble(numStack.pop());
    }

    //LL
    /**
     * This method is used for grading purposes, it passes a parameter str class the method llprefixCala and returns
     * the soluton for str assuming it is a good string.
     * @param str the string representing the postfix expression.
     * @return the solution to str.
     */
    public Double listPrefixCalc(String str) {
        try {
            return llprefixCala(str);
        }catch (NullPointerException e){
            return null;
        }
    }
    /**
     * This is the linked list calculations method. This method is called on from the listPrefixCalc method or from
     * the main. It works by having one stack that holds the numbers and an array that holds all of the string separated
     * by " ". This method starts at the "end" of the string and moves from right to left.
     * @param str is the unchanged string that we wish to solve in preFix notation.
     * @return if str was good code then it is expected to return the solution to str, else it should return null.
     */
    private Double llprefixCala(String str){
        LinkedListStacks numStack= new LinkedListStacks();
        try{
            String[] raw= str.split(" ");
            for(int i=raw.length-1;i>=0;i--) {
                if (isNumeric(raw[i])) {
                    numStack.push(raw[i]);
                } else {
                    if (raw[i].equals("^")) {
                        double num = Double.parseDouble(numStack.pop());
                        double pow = Double.parseDouble(numStack.pop());
                        numStack.push(String.valueOf(Math.pow(num, pow)));
                    } else if (raw[i].equals("+")) {
                        double num = Double.parseDouble(numStack.pop());
                        double num2 = Double.parseDouble(numStack.pop());
                        numStack.push(String.valueOf(num + num2));
                    } else if (raw[i].equals("-")) {
                        double num = Double.parseDouble(numStack.pop());
                        double num2 = Double.parseDouble(numStack.pop());
                        numStack.push(String.valueOf(num - num2));
                    } else if (raw[i].equals("*")) {
                        double num = Double.parseDouble(numStack.pop());
                        double num2 = Double.parseDouble(numStack.pop());
                        numStack.push(String.valueOf(num * num2));
                    } else if (raw[i].equals("/")) {
                        double num = Double.parseDouble(numStack.pop());
                        double num2 = Double.parseDouble(numStack.pop());
                        numStack.push(String.valueOf(num / num2));
                    } else {
                        IOException e = new IOException();
                        throw e;
                    }
                }
            }
        }catch( IOException e){
           // System.out.println("Input error");
            Double x=null;
            return x;
        }
        return Double.parseDouble(numStack.getTop());

    }

    /**
     * Write a compiler program that allows variables in the postfix expressions; for each variable,
     * your program should ask the user for the value of this variable, and then compute the
     * value of the corresponding expression
     */
    public static Double extraCredit(String str){
        Scanner scan = new Scanner(System.in);
        if(str.matches(".*[a-zA-z].*")){
            for(int i=0;i<str.length();i++){
                if(!(isNumeric(str.substring(i,i)))&&((!(str.charAt(i)=='+')||(!(str.charAt(i)=='-'))||(!(str.charAt(i)=='/'))||(!(str.charAt(i)=='*'))||(!(str.charAt(i)=='^'))||(!(str.charAt(i)=='^'))))){
                    System.out.println(str.charAt(i));
                }
            }
        }
        String[] raw= str.split(" ");
        return 2.0;
    }

    public static void main(String args[]){
        String test= " ";
        Torres6 T= new Torres6();
        System.out.println(T.arrayPrefixCalc(test));
        System.out.println(T.listPrefixCalc(test));
        System.out.println(extraCredit("a b *"));
    }

}




