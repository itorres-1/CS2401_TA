package Testers;

import Lab1.Padron;
import Lab1.Sauers;
import Lab1.Valenzuela;
import Lab5.Antunez5;
import Lab5.Sauers5;
import Lab6.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Scanner;
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
                        if (operand2 == 0) return null;
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

        //STUDENT
        Wiggs6 student = new Wiggs6();

        int[] lGood = {1,1,1};
        int[] aGood = {1,1,1};
        int[] lBad  = {1,1,1,1,1,1};
        int[] aBad  = {1,1,1,1,1,1};

        //Set up tester and result/score holders
        Lab6Tester tester = new Lab6Tester();
        Double tResult;
        Double sResult;
        int numOfCorrectnessTests = 6;
        int numOfRobustnessTests = 12;
        Double pointsPerCorrectnessTest = 100.0/numOfCorrectnessTests;
        Double pointsPerRobustnessTest = 100.0/numOfRobustnessTests;
        Double correctness = 0.0;
        Double robustness = 0.0;

        //File preparation
        String studentName = Util.getStudentName(student.getClass());
        int labNumber = Util.getLabNumber(student.getClass());
        File studentFile = Util.getFile(studentName,labNumber);

        //Begin Test
        try(PrintWriter pw = new PrintWriter(studentFile)) {
            char goodBad = '*';
            char inputChar = '_';
            char finalGrade = '$';

            //Heading
            Util.printAndWrite(Util.fileHeader(studentName,labNumber),pw );

            Util.printAndWrite(Util.titleString("Good Input",goodBad), pw);

            //Test 0: Good "- 3 ^ 2 2"
            String inputString = "- 3 ^ 2 2";
            int test = 0;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lGood[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        correctness += pointsPerCorrectnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aGood[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        correctness += pointsPerCorrectnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Correctness = "+correctness, pw);

            //Test 1: Good "/ + 1 10 2"
            inputString = "/ + 1 10 2";
            test = 1;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lGood[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        correctness += pointsPerCorrectnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aGood[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        correctness += pointsPerCorrectnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Correctness = "+correctness, pw);

            //Test 2: Good "/ ^ - + 2 3 10 250 100"
            inputString = "* / ^ - + 2 3 1 2 5 9";
            test = 2;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lGood[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        correctness += pointsPerCorrectnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aGood[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        correctness += pointsPerCorrectnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Correctness = "+correctness, pw);


            Util.printAndWrite(Util.titleString("Bad Input", goodBad), pw);





            //Test 0: Bad ""
            inputString = "";
            test = 0;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lBad[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aBad[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Robustness = "+robustness, pw);

            //Test 1: Bad "+ 1 1 1"
            inputString = "+ 1 1 1";
            test = 1;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lBad[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aBad[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Robustness = "+robustness, pw);

            //Test 2: Bad "/ 1"
            inputString = "/ 1";
            test = 2;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lBad[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aBad[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Robustness = "+robustness, pw);

            //Test 3: Bad "+ 1 A"
            inputString = "+ 1 A";
            test = 3;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lBad[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aBad[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Robustness = "+robustness, pw);

            //Test 4: Bad "1 1 1"
            inputString = "1 1 1";
            test = 4;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lBad[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aBad[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Robustness = "+robustness, pw);

            //Test 5: Bad "/ 1 0"
            inputString = "/ 1 0";
            test = 5;
            Util.printAndWrite(Util.titleString("\""+inputString+"\"",inputChar), pw);
            Util.printAndWrite("Correct: "+(tResult = tester.listPrefixCalc(inputString)), pw);
            if (lBad[test] == 1){
                try {
                    Util.printAndWrite("LStack: "+(sResult = student.listPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("LStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("LLStack infinite loop", pw);
            if (aBad[test] == 1){
                try {
                    Util.printAndWrite("AStack: "+(sResult = student.arrayPrefixCalc(inputString)), pw);
                    if (Util.equalDoubles(tResult,sResult)) {
                        robustness += pointsPerRobustnessTest;
                    }
                }
                catch (Exception e){
                    Util.printAndWrite("AStack crashed :(", pw);
                }
            }
            else Util.printAndWrite("AStack: infinite loop", pw);
            Util.printAndWrite("Robustness = "+robustness, pw);

            //Final Grade
            Util.printAndWrite(Util.titleString("Total Grade",finalGrade), pw);
            Util.printAndWrite("Correctness: "+correctness, pw);
            Util.printAndWrite("Robustness: "+robustness, pw);
        }
        catch (Exception e){
            System.out.println(":(");
        }
    }
}
