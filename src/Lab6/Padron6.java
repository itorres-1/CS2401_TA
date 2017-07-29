package Lab6;

import Testers.LabInterfaces.Lab6Interface;

/**
 * Author Cesar Arturo Padron
 * 7/24/2017
 * Professor: Julio Cesar Urenda
 */

public class Padron6 implements Lab6Interface {
    static class doubleNode {
        public Double data;
        public doubleNode next;
        public doubleNode(Double myData, doubleNode myNext){
            data = myData;
            next = myNext;
        }
    }
    static class stackLL{
        private doubleNode top;
        public stackLL(){
            top=null;
        }
        public boolean isEmpty(){
            return top==null;
        }
        public Double getTop(){
            return top.data;
        }
        public void push(Double newElement){
            doubleNode newTop = new doubleNode(newElement,top);
            top = newTop;
        }
        public Double pop(){
            Double tmp = top.data;
            top = top.next;
            return tmp;
        }
    }
    static class stackAB{
        private double[] e;
        private int topIndex;
        public stackAB(int maxCap){
            e = new double[maxCap];
            topIndex = -1;
        }
        public boolean isEmpty(){
            return topIndex==-1;
        }
        public boolean isFull(){
            return topIndex==e.length-1;
        }
        public void push(double newElement){
            topIndex++;
            e[topIndex] = newElement;
        }
        public double pop(){
            double tmp = e[topIndex];
            topIndex--;
            return tmp;
        }
    }

    public static void main(String[] Args){
        String test = "/ ^ + 1 - 9 8 3 / 8 4";
    }

    public static double implementsEquations(String str, double num1, double num2){
        int tmp = -1;
        if(str.equals("+")){
            return num1+num2;
        }
        else if(str.equals("-")){
            return num1-num2;
        }
        else if(str.equals("*")){
            return num1*num2;
        }
        else if(str.equals("/")){
            return num1/num2;
        }
        else if(str.equals("^")){

            return Math.pow(num1,num2);
        }
        return tmp;
    }

    public static String[] stringToArray(String str){
        String[] temp = new String[0];
        temp = str.split(" ");
        return temp;
    }

    public static Double arrayStackCalcHelp(String str){
        String[] prefixEquation = stringToArray(str);

        stackAB array = new stackAB(prefixEquation.length);


        if (array.isEmpty() && !array.isFull()){
            for (int i = prefixEquation.length-1;i>=0;i--){
                if(!prefixEquation[i].equals("+")&&!prefixEquation[i].equals("-")&&!prefixEquation[i].equals("*")&&!prefixEquation[i].equals("/")&&!prefixEquation[i].equals("^")) {
                  array.push(Double.valueOf(prefixEquation[i]));
                }
                else {
                    double result = implementsEquations(prefixEquation[i],array.pop(),array.pop());
                    array.push(result);
                }
            }
        }
        return array.pop();
    }
    public static Double linkedListCalcHelp(String str){
        String[] prefixEquation = stringToArray(str);
        stackLL calcStack = new stackLL();
        if (calcStack.isEmpty()){
            for (int i = prefixEquation.length-1;i>=0;i--){
                if(!prefixEquation[i].equals("+")&&!prefixEquation[i].equals("-")&&!prefixEquation[i].equals("*")&&!prefixEquation[i].equals("/")&&!prefixEquation[i].equals("^")) {
                    calcStack.push(Double.valueOf(prefixEquation[i]));
                }
                else {
                    double result = implementsEquations(prefixEquation[i],calcStack.pop(),calcStack.pop());
                    calcStack.push(result);
                }
            }
        }
        return calcStack.pop();
    }

    public Double listPrefixCalc(String str) {
        Double result = linkedListCalcHelp(str);
        return result;
    }

    public Double arrayPrefixCalc(String str) {
        Double result = arrayStackCalcHelp(str);
        return result;
    }
}
