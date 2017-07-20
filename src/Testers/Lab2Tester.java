package Testers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Author: Isaac Tobanche
 * Date: 6/26/17.
 * Course:
 * Assignment:
 * Instructor:
 * T.A:
 */
public class Lab2Tester {
    //Computation Stores
    static int[][] correct;
    static int[][] studentResult;
    static Boolean correctBool;
    static Boolean studentBool;
    
    //TODO Student Points!
    static int numOfCorrectnessTests = 7;
    static int numOfRobustnessTests = 4;
    static double correctness = 0;
    static double robustness = 0;
    public static int[][] sum(int[][] A, int[][] B) {
        if (A.length != B.length || A[0].length != B[0].length ||
                A == null || B == null) return null;
        int[][] sum = newEmptyMatrixOfSize(A);
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                sum[i][j] = A[i][j]+B[i][j];
            }
        }
        return sum;
    }
    public static int[][] difference(int[][] A, int[][] B){
        if (A.length != B.length || A[0].length != B[0].length ||
                A == null || B == null) return null;
        int[][] difference = newEmptyMatrixOfSize(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                difference[i][j] = A[i][j]-B[i][j];
            }
        }
        return difference;
    }
    public static int[][] intMultiplication(int[][] A, int r){
        if (A == null) return null;
        int[][] result = newEmptyMatrixOfSize(A);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = A[i][j]*r;
            }
        }
        return result;
    }
    public static int[][] matrixProduct(int[][] A, int[][] B){
        if (A == null || B == null || A[0].length != B.length) return null;
        int[][] product = new int[A.length][B[0].length];
        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < product[0].length; j++) {
                for(int k = 0; k < A[i].length; ++k){
                    product[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return product;
    }
    public static int[][] transpose(int[][] A){
        try{
            int[][] aTranspose = new int[A[0].length][A.length];
            for (int i = 0; i < aTranspose.length; i++) {
                for (int j = 0; j < aTranspose[0].length; j++) {
                    aTranspose[i][j] = A[j][i];
                }
            }
            return aTranspose;
        }catch (Exception e) { return null;}
    }
    public static Boolean isSymmetric(int[][] A){
        return areEqual(A,transpose(A));
    }
    public static int[][] pow(int[][] A, int k){
        if (A.length != A[0].length) return null;
        try {
            int[][] product = A.clone();
            for (int i = 0; i < k-1; i++) {
                product = matrixProduct(A,product);
            }
            return product;
        } catch (Exception e) {return null;}
    }
    public static int[][] cloneMatrix(int[][] A){
        int[][] clone = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                clone[i][j] = A[i][j];
            }
        }
        return clone;
    }
    //Utility methods
    public static int[][] readFromFile(String str){
        while(true){
            try{
                BufferedReader br = new BufferedReader(new FileReader(str));
                int numberOfLines = 0;
                while (br.ready()){
                    br.readLine();
                    numberOfLines++;
                }
                br.close();
                br = new BufferedReader(new FileReader(str));
                int[][] data = new int[numberOfLines][];
                for (int i = 0; i < numberOfLines; i++) {
                    String[] rowString = br.readLine().split(" ");
                    int[] row = new int[rowString.length];
                    for (int j = 0; j < row.length; j++) {
                        row[j] = Integer.parseInt(rowString[j]);
                    }
                    data[i] = row;
                }
                br.close();
                return data;
            } catch (IOException e){return null;}
        }
    }
    public static int[][] newEmptyMatrixOfSize(int[][] A){
        return new int[A.length][A[0].length];
    }
    public static int[][] random3BoundMatrix(int m, int n){
        int[][] rMatrix = null;
        if (m > 0 && n > 0){
            Random random = new Random();
            rMatrix = new int[m][n];
            for (int i = 0; i < rMatrix.length; i++) {
                for (int j = 0; j < rMatrix[0].length; j++) {
                    rMatrix[i][j] = random.nextInt(3+1);
                }
            }
        }
        return rMatrix;
    }
    public static boolean areEqual(int[][] A, int[][] B){
        if (A == null && B == null) return true;
        if (A ==  null ^ B == null) return false;
        if (A.length != B.length || A[0].length != B[0].length) return false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }
    //Print Utilities
    public static void printSpace(int numOfSpaces){
        for (int i = 0; i < numOfSpaces; i++) {
            System.out.print(" ");
        }
    }
    public static void printRow(int[][] A, int i){
        if (i < A.length){
            for (int colNum = 0; colNum < A[i].length-1; colNum++) {
                System.out.print(A[i][colNum]+" ");
            }
            System.out.print(A[i][A[i].length-1]);
        }
    }
    public static void printMatrix(String title, int[][] A){
        if (A == null) System.out.println(title+" null\n");
        else {
            System.out.println(title);
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    System.out.print(A[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void printMatrices(String strOne, int[][] A, String strTwo, int[][] B){
        if (A != null && B != null){
            int maxRows = A.length > B.length ? A.length:B.length;
            int aRowLength = 2*A[0].length-1;
            int matrixSpacer = 3;
            int strSpacer = 0;

            //Calculate String spacing
            if (strOne.length() < aRowLength) strSpacer = aRowLength-strOne.length();
            else if (strOne.length() == aRowLength) strSpacer = matrixSpacer;
            else {
                strSpacer = 3;
                matrixSpacer = strSpacer+(strOne.length()-aRowLength);
            }

            //Print strings
            System.out.print(strOne);
            if (strOne.length() < aRowLength) printSpace(strSpacer+matrixSpacer);
            else if (strOne.length() == aRowLength) printSpace(matrixSpacer);
            else printSpace(strSpacer);
            System.out.print(strTwo);
            System.out.println();


            for (int i = 0; i < maxRows; ++i){
                if(i<A.length){
                    printRow(A,i);
                    printSpace(matrixSpacer);
                    printRow(B,i);
                    System.out.println();
                }
                else {
                    printSpace(aRowLength+matrixSpacer);
                    printRow(B,i);
                    System.out.println();
                }
            }
            System.out.println();
        }
        else {
            printMatrix(strOne,A);
            printMatrix(strTwo,B);
        }
    }

    public static void main(String[] args) {
        int[][] _2x3 = random3BoundMatrix(2,3);
        int[][] _3x3 = random3BoundMatrix(3,3);
        int[][] _3x2 = random3BoundMatrix(3,2);
        int[][] sym = {{1,2,3},
                       {2,3,2},
                       {3,2,1}};

        // Sum (Bad) 2x3 + 3x2
        Util.titleString("Sum (bad)  ");
        printMatrices("input 1:",cloneMatrix(_2x3),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = sum(cloneMatrix(_2x3),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.sum(cloneMatrix(_2x3),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :'C");
        }
        Util.printGradeSoFar(correctness,robustness);
        
        
        
        
        //Sum (Bad) 3x2 + 2x3  - 8.33 pts
        Util.titleString("Sum (bad) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_2x3));
        printMatrix("correct:",correct = sum(cloneMatrix(_3x2),cloneMatrix(_2x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.sum(cloneMatrix(_3x2),cloneMatrix(_2x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Sum (Bad) 3x2 + 3x3
        Util.titleString("Sum (bad) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_3x3));
        printMatrix("correct:",correct = sum(cloneMatrix(_3x2),cloneMatrix(_3x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.sum(cloneMatrix(_3x2),cloneMatrix(_3x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Sum (Bad) 3x3 + 3x2
        Util.titleString("Sum (bad) ");
        printMatrices("input 1:",cloneMatrix(_3x3),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = sum(cloneMatrix(_3x3),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.sum(cloneMatrix(_3x3),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Sum (Good) 2x3 + 2x3 - 4.76 pts
        Util.titleString("Sum (good) ");
        printMatrices("input 1:",cloneMatrix(_2x3),"input 2:",cloneMatrix(_2x3));
        printMatrix("correct:",correct = sum(cloneMatrix(_2x3),cloneMatrix(_2x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.sum(cloneMatrix(_2x3),cloneMatrix(_2x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Sum (Good) 3x2 + 3x2
        Util.titleString("Sum (good) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = sum(cloneMatrix(_3x2),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.sum(cloneMatrix(_3x2),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Sum (Good) 3x3 + 3x3
        Util.titleString("Sum (good) ");
        printMatrices("input 1:",cloneMatrix(_3x3),"input 2:",cloneMatrix(_3x3));
        printMatrix("correct:",correct = sum(cloneMatrix(_3x3),cloneMatrix(_3x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.sum(cloneMatrix(_3x3),cloneMatrix(_3x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Difference (Bad) 2x3 + 3x2 - 6.25
        Util.titleString("Difference (bad)  ");
        printMatrices("input 1:",cloneMatrix(_2x3),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = difference(cloneMatrix(_2x3),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.difference(cloneMatrix(_2x3),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :'C");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Difference (Bad) 3x2 + 2x3
        Util.titleString("Difference (bad) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_2x3));
        printMatrix("correct:",correct = difference(cloneMatrix(_3x2),cloneMatrix(_2x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.difference(cloneMatrix(_3x2),cloneMatrix(_2x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Difference (Bad) 3x2 + 3x3
        Util.titleString("Difference (bad) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_3x3));
        printMatrix("correct:",correct = difference(cloneMatrix(_3x2),cloneMatrix(_3x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.difference(cloneMatrix(_3x2),cloneMatrix(_3x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Difference (Bad) 3x3 + 3x2
        Util.titleString("Difference (bad) ");
        printMatrices("input 1:",cloneMatrix(_3x3),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = difference(cloneMatrix(_3x3),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.difference(cloneMatrix(_3x3),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Difference (Good) 2x3 + 2x3 -  4.76 pts
        Util.titleString("Difference (good) ");
        printMatrices("input 1:",cloneMatrix(_2x3),"input 2:",cloneMatrix(_2x3));
        printMatrix("correct:",correct = difference(cloneMatrix(_2x3),cloneMatrix(_2x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.difference(cloneMatrix(_2x3),cloneMatrix(_2x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Difference (Good) 3x2 + 3x2
        Util.titleString("Difference (good) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = difference(cloneMatrix(_3x2),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.difference(cloneMatrix(_3x2),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Difference (Good) 3x3 + 3x3
        Util.titleString("Difference (good) ");
        printMatrices("input 1:",cloneMatrix(_3x3),"input 2:",cloneMatrix(_3x3));
        printMatrix("correct:",correct = difference(cloneMatrix(_3x3),cloneMatrix(_3x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.difference(cloneMatrix(_3x3),cloneMatrix(_3x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);

        
        //TODO *************************** intMultiplication! - 14.29 pts
        Util.titleString("Integer Multiplication (good) ");
        printMatrix("input w/ r = 3: ", cloneMatrix(_3x3));
        printMatrix("correct:",correct = intMultiplication(cloneMatrix(_3x3),3));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.intMultiplication(cloneMatrix(_3x3),3));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);


        //Matrix Product (Bad) 3x2 + 3x3 - 8.33 pts
        Util.titleString("Matrix Product (bad) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_3x3));
        printMatrix("correct:",correct = matrixProduct(cloneMatrix(_3x2),cloneMatrix(_3x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.matrixProduct(cloneMatrix(_3x2),cloneMatrix(_3x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Matrix Product (Bad) 2x3 + 2x3
        Util.titleString("Matrix Product (bad) ");
        printMatrices("input 1:",cloneMatrix(_2x3),"input 2:",cloneMatrix(_2x3));
        printMatrix("correct:",correct = matrixProduct(cloneMatrix(_2x3),cloneMatrix(_2x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.matrixProduct(cloneMatrix(_2x3),cloneMatrix(_2x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Matrix Product (Bad) 3x2 + 3x2
        Util.titleString("Matrix Product (bad) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = matrixProduct(cloneMatrix(_3x2),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.matrixProduct(cloneMatrix(_3x2),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Matrix Product (Good) 2x3 + 3x2 -  3.57 pts
        Util.titleString("Matrix Product (good)  ");
        printMatrices("input 1:",cloneMatrix(_2x3),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = matrixProduct(cloneMatrix(_2x3),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.matrixProduct(cloneMatrix(_2x3),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :'C");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Matrix Product (Good) 3x2 + 2x3
        Util.titleString("Matrix Product (good) ");
        printMatrices("input 1:",cloneMatrix(_3x2),"input 2:",cloneMatrix(_2x3));
        printMatrix("correct:",correct = matrixProduct(cloneMatrix(_3x2),cloneMatrix(_2x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.matrixProduct(cloneMatrix(_3x2),cloneMatrix(_2x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Matrix Product (Good) 3x3 + 3x2
        Util.titleString("Matrix Product (good) ");
        printMatrices("input 1:",cloneMatrix(_3x3),"input 2:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = matrixProduct(cloneMatrix(_3x3),cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.matrixProduct(cloneMatrix(_3x3),cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Matrix Product (Good) 3x3 + 3x3
        Util.titleString("Matrix Product (good) ");
        printMatrices("input 1:",cloneMatrix(_3x3),"input 2:",cloneMatrix(_3x3));
        printMatrix("correct:",correct = matrixProduct(cloneMatrix(_3x3),cloneMatrix(_3x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.matrixProduct(cloneMatrix(_3x3),cloneMatrix(_3x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed ¯＼(º_o)/¯");
        }
        Util.printGradeSoFar(correctness,robustness);


        //TODO Transpose 3x2 - 4.76
        Util.titleString("Transpose ");
        printMatrix("input:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = transpose(cloneMatrix(_3x2)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.transpose(cloneMatrix(_3x2)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Transpose 2x3
        Util.titleString("Transpose ");
        printMatrix("input:",cloneMatrix(_2x3));
        printMatrix("correct:",correct = transpose(cloneMatrix(_2x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.transpose(cloneMatrix(_2x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Transpose 3x3
        Util.titleString("Transpose ");
        printMatrix("input:",cloneMatrix(_3x3));
        printMatrix("correct:",correct = transpose(cloneMatrix(_3x3)));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.transpose(cloneMatrix(_3x3)));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*3);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);


        //TODO Symmetric (Good) 3x2  3.57
        Util.titleString("Symmetric (bad) ");
        printMatrix("input:",cloneMatrix(_3x2));
        System.out.println("correct:"+(correctBool = isSymmetric(cloneMatrix(_3x2))));
        try {
            System.out.println("Your result:"+(studentBool = Lab2.Tobanche2.isSymmetric(cloneMatrix(_3x2))));
            if (studentBool == correctBool) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Symmetric (Good) 2x3
        Util.titleString("Symmetric (bad) ");
        printMatrix("input:",cloneMatrix(_2x3));
        System.out.println("correct:"+(correctBool = isSymmetric(cloneMatrix(_2x3))));
        try {
            System.out.println("Your result:"+(studentBool = Lab2.Tobanche2.isSymmetric(cloneMatrix(_2x3))));
            if (studentBool == correctBool) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Symmetric (Good) 3x3
        Util.titleString("Symmetric (bad) ");
        printMatrix("input:",cloneMatrix(_3x3));
        System.out.println("correct:"+(correctBool = isSymmetric(cloneMatrix(_3x3))));
        try {
            System.out.println("Your result:"+(studentBool = Lab2.Tobanche2.isSymmetric(cloneMatrix(_3x3))));
            if (studentBool == correctBool) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Symmetric (Good)
        Util.titleString("Symmetric (good) ");
        printMatrix("input:",cloneMatrix(sym));
        System.out.println("correct:"+(correctBool = isSymmetric(cloneMatrix(sym))));
        try {
            System.out.println("Your result:"+(studentBool = Lab2.Tobanche2.isSymmetric(cloneMatrix(sym))));
            if (studentBool == correctBool) {
                System.out.println("ヽ(^◇^*)/");
                correctness += 100/((double)numOfCorrectnessTests*4);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);


        //Power (Bad) 3x2 12.5
        Util.titleString("Power (bad) ");
        printMatrix("input w/k = 3:",cloneMatrix(_3x2));
        printMatrix("correct:",correct = pow(cloneMatrix(_3x2),3));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.pow(cloneMatrix(_3x2),3));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*2);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //Power (Bad) 2x3
        Util.titleString("Power (bad) ");
        printMatrix("input w/k = 3:",cloneMatrix(_2x3));
        printMatrix("correct:",correct = pow(cloneMatrix(_2x3),3));
        try {
            printMatrix("Your result:",studentResult = Lab2.Tobanche2.pow(cloneMatrix(_2x3),3));
            if (areEqual(studentResult,correct)) {
                System.out.println("ヽ(^◇^*)/");
                robustness += 100/((double)numOfRobustnessTests*2);
            }
            else {
                System.out.println("¯＼(º_o)/¯");
            }
        } catch (Exception e){
            System.out.println("Your code crashed :(");
        }
        Util.printGradeSoFar(correctness,robustness);
        //TODO Power (Good) 3x3 3.57
        for(int i = 1; i < 5; ++i){
            Util.titleString("Power (good) ");
            printMatrix("input w/ k = "+i+":",cloneMatrix(_3x3));
            printMatrix("correct:",correct = pow(cloneMatrix(_3x3),i));
            try {
                printMatrix("Your result:",studentResult = Lab2.Tobanche2.pow(cloneMatrix(_3x3),i));
                if (areEqual(studentResult,correct)) {
                    System.out.println("ヽ(^◇^*)/");
                    correctness += 100/((double)numOfCorrectnessTests*4);
                }
                else {
                    System.out.println("¯＼(º_o)/¯");
                }
            } catch (Exception e){
                System.out.println("Your code crashed :(");
            }
            Util.printGradeSoFar(correctness,robustness);
        }

        Util.titleString("Final Grade: ");
        Util.printGradeSoFar(correctness,robustness);
        System.out.println();
        if (correctness > 99.9) System.out.println("GOD MODE");
        else if (correctness > 95) System.out.println("BEAST MODE");
        else if (correctness > 90) System.out.println("＼（＾○＾）人（＾○＾）／");
        else if(correctness > 70) System.out.println("┌( ಠ‿ಠ)┘");
        else if (correctness > 50) System.out.println("(◕︵◕)");
        else System.out.println("(╯°□°）╯︵ ┻━┻");


        
        


    }
}
