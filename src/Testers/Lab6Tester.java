package Testers;

import Lab5.Wiggs5;

import java.io.File;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Author: Isaac Torres
 * Date: 7/24/17.
 * Course:
 * Assignment:
 * Instructor:
 * T.A:
 */
public class Lab6Tester {

    public Double listPrefixCalc(String str) {
        String[] expression = str.split(" ");
        Stack<Double> stack = new Stack<>();
        for (int i = expression.length-1; i >=0; i--) {
            try{
                stack.push(Double.parseDouble(expression[i]));
            }
            //Was not a number, therefore operation or erroneous character
            catch (NumberFormatException e){
                if (expression[i].length() != 1) return null;
                //of appropriate length for operation, could
                //still be fault char
                char operation = expression[i].charAt(0);
                Double operand1;
                Double operand2;
                try{
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                }catch (EmptyStackException f){
                    return null;
                }
                switch (operation){
                    case '+':
                        stack.push(operand1+operand2);
                        break;
                    case '-':
                        stack.push(operand1-operand2);
                        break;
                    case '*':
                        stack.push(operand1*operand2);
                        break;
                    case '/':
                        stack.push(operand1/operand2);
                        break;
                    case '^':
                        stack.push(Math.pow(operand1,operand2));
                        break;
                }
            }
        }
        if (stack.size() != 1) return null;
        try {
            return stack.pop();
        }catch (EmptyStackException e){
            return null;
        }
    }

    public static void main(String[] args) {
        Lab6Tester tester = new Lab6Tester();
        Wiggs5 student = new Wiggs5();
        Double testerResult;
        Double studentResult;

        //File preparation
        String studentName = Util.getStudentName(student.getClass());
        int labNumber = Util.getLabNumber(student.getClass());
        File studentFile = Util.getFile(studentName,labNumber);

        try(PrintWriter pw = new PrintWriter(studentFile)) {

            //Heading
            Util.printAndWrite(Util.fileHeader(studentName,labNumber),pw );


            String inputString = "- 3 ^ 2 2";
            Util.printAndWrite(Util.titleString("("+inputString+")"), pw);
            Util.printAndWrite("Correct: "+(testerResult = tester.listPrefixCalc(inputString)), pw);
            try {
                Util.printAndWrite("Your result: "+null, pw);
                if (testerResult == -1.0) Util.printAndWrite("yeyyy", pw);
            }
            catch (Exception e){
                Util.printAndWrite("Your code crashed :(", pw);
            }



        }
        catch (Exception e){
            System.out.println("Something went wrong :(");
        }
    }
}
