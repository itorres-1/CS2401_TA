package Testers;

import java.io.File;
import java.io.PrintWriter;

/**
 * Author: Isaac Torres
 * Date: 7/3/17.
 * Course:
 * Assignment:
 * Instructor:
 * T.A:
 */
public class Util {
    //Getters
    public static String getStudentName(Class student){
        String studentName = student.toString().split(" ")[1].replace('.',' ').split(" ")[1];
        return studentName.substring(0,studentName.length()-1);
    }
    public static int getLabNumber(Class student){
        String studentName = student.toString().split(" ")[1].replace('.',' ').split(" ")[1];
        return Integer.parseInt(studentName.substring(studentName.length()-1));
    }
    public static File getFile(String studentName, int labNumber){
        String relativePath = "/Users/igtorres/IdeaProjects/CS2401_TA/Results/Lab"+labNumber+"/";
        return new File(relativePath+studentName+labNumber+".txt");
    }

    public static String fileHeader(String studentName, int labNumber){
        String headerString = "";
        headerString += "\nStudent: "+studentName;
        headerString += "\nLab: "+labNumber+"";
        return headerString;
    }
    public static String titleString(String str){
        String printLine = "";
        int lineLength = 30;
        for (int i = 0; i < lineLength-str.length()/2; i++) {
            printLine +='-';
        }
        printLine += " "+str+" ";
        for (int i = 0; i < lineLength-str.length()/2; i++) {
            printLine +='-';
        }
        return "\n"+printLine+"\n";
    }

    //Printing methods
    public static void printGradeSoFar(Double correctness, Double robustness){
        System.out.printf("Correctness = %.1f\n",correctness);
        System.out.printf("Robustness = %.0f\n",robustness);
    }
    public static void printAndWrite(String str, PrintWriter P){
        System.out.println(str);
        P.println(str);
    }

    //Matrices:
    public static void print1Dint(int[] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }

}
