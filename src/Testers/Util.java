package Testers;

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
    public static String headerString(Class C){
        String headerString = "\nStudent: ";
        String[] packageBreadcumbs = C.toString().split(" ");
        String tmpString = packageBreadcumbs[1].replace('.',' ');
        String[] packageAndClass = tmpString.split(" ") ;
        String lastNameLab = packageAndClass[1];

        headerString += lastNameLab.substring(0,lastNameLab.length()-1)+"\n";
        headerString += "Lab: "+lastNameLab.substring(lastNameLab.length()-1)+"\n";
        headerString += titleString("START");

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
    public static void printGradeSoFar(Double correctness, Double robustness){
        System.out.printf("Correctness = %.1f\n",correctness);
        System.out.printf("Robustness = %.0f\n",robustness);
    }
    public static void printAndWrite(String str, PrintWriter P){
        System.out.println(str);
        P.println(str);
    }
}
