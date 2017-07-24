package Testers;

import Lab5.*;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Author: Isaac Torres
 * Date: 7/14/17.
 * Course:
 * Assignment:
 * Instructor:
 * T.A:
 */
public class Lab5Tester {
    static int[] unsortedArray = {9,0,8,1,7,2,6,3,5,4};
    public static ArrayList<Integer> makeArrayList(int[] A){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            arrayList.add(A[i]);
        }
        return arrayList;
    }
    public static Boolean isSorted(int[] A){
        if (A != null) {
            for (int i = 1; i < A.length; i++) {
                if (A[i-1] > A[i]) return false;
            }
            return true;
        }
        return null;
    }
    public static void main(String[] args) {
        int[] studentResult;
        int correctness = 0;
        Boolean isSorted;

        Wiggs5 student = new Wiggs5();

        int labNumber = 5;
        student = new Wiggs5();
        String relativePath = "/Users/igtorres/IdeaProjects/CS2401_TA/Results/Lab"+labNumber+"/";
        String studentName = student.getClass().toString().split(" ")[1].replace('.',' ').split(" ")[1];
        studentName = studentName.substring(0,studentName.length()-1);
        String fileName = relativePath+"Lab"+labNumber+"."+studentName+labNumber+".txt";
        try(PrintWriter w = new PrintWriter(fileName)) {

            //Heading and Input
            Util.printAndWrite(Util.fileHeader(studentName,labNumber),w );
            String s = "Input: " + makeArrayList(unsortedArray);
            Util.printAndWrite(s, w);
            
            //BubbleSort
            Util.printAndWrite(Util.titleString("rBubbleSort"), w);
            studentResult = unsortedArray.clone();
            try{
                student.rBubbleSort(studentResult);
                Util.printAndWrite("Output:" + makeArrayList(studentResult) + " ", w);
                isSorted = isSorted(studentResult);
                Util.printAndWrite("Sorted: "+isSorted,w );
                if (isSorted) {
                    Util.printAndWrite("+25 in correctness", w);
                    correctness += 16.6666666666;
                }
            }catch (Exception e){
                Util.printAndWrite("Your code crashed! :(",w );
            }

            //SelectionSort
            Util.printAndWrite(Util.titleString("rSelectionSort"), w);
            studentResult = unsortedArray.clone();
            try{
                student.rSelectionSort(studentResult);
                Util.printAndWrite("Output:" + makeArrayList(studentResult) + " ", w);
                isSorted = isSorted(studentResult);
                Util.printAndWrite("Sorted: "+isSorted,w );
                if (isSorted) {
                    Util.printAndWrite("+25 in correctness", w);
                    correctness += 16.6666666666;
                }
            }catch (Exception e){
                Util.printAndWrite("Your code crashed! :(",w );
            }

            //InsertionSort
            Util.printAndWrite(Util.titleString("rInsertionSort"), w);
            studentResult = unsortedArray.clone();
            try{
                student.rInsertionSort(studentResult);
                Util.printAndWrite("Output:" + makeArrayList(studentResult) + " ", w);
                isSorted = isSorted(studentResult);
                Util.printAndWrite("Sorted: "+isSorted,w );
                if (isSorted) {
                    Util.printAndWrite("+25 in correctness", w);
                    correctness += 16.6666666666;
                }
            }catch (Exception e){
                Util.printAndWrite("Your code crashed! :(",w );
            }

            //QuickSort
            Util.printAndWrite(Util.titleString("iQuickSort"), w);
            studentResult = unsortedArray.clone();
            try{
                student.iQuickSort(studentResult);
                Util.printAndWrite("Output:" + makeArrayList(studentResult) + " ", w);
                isSorted = isSorted(studentResult);
                Util.printAndWrite("Sorted: "+isSorted,w );
                if (isSorted) {
                    Util.printAndWrite("+25 in correctness", w);
                    correctness += 16.6666666666;
                }
            }catch (Exception e){
                Util.printAndWrite("Your code crashed! :(",w );
            }


            Util.printAndWrite(Util.titleString("Grade"),w );
            Util.printAndWrite("correctness: "+correctness,w );
        }
        catch (Exception e){
            System.out.println("Something went wrong :(");
        }
    }
}
