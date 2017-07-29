package Testers;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: Isaac Torres
 * Date: 7/3/17.
 * Course:
 * Assignment:
 * Instructor:
 * T.A:
 */
public class Util {

    /**
     * Private constructor to ensure non-instantiation
     */
    private Util(){}

    //Getters
    /**
     * A method that given a student object's class, will return a string of the student's last name.
     *
     * <p>To use this method, one must first create an instance of the student's class. Because the
     * students name their .java files (and therefore public class) using the "lastName#.java" convention, this
     * method is capable of extracting solely the last name as a string. Once the instance is created, say a Doe4
     * object, one calls this method and passes to it the parameter {@code Doe4.getClass()}.</p>
     *
     * @param student a class object obtained from an instance of student's public .java file
     * @return a string containing the student's last name
     */
    public static String getStudentName(Class student){
        String studentName = student.toString().split(" ")[1].replace('.',' ').split(" ")[1];
        return studentName.substring(0,studentName.length()-1);
    }

    /**
     * Like {@link Util#getLabNumber(Class)}, however this returns an int representing the lab number.
     *
     * <p>See description for {@link Util#getLabNumber(Class)}. This method functions in the exact same
     * way but returns an int representing the lab number instead.</p>
     *
     * @param student a class object obtained from an instance of student's public .java file
     * @return an int representing the lab number
     */
    public static int getLabNumber(Class student){
        String studentName = student.toString().split(" ")[1].replace('.',' ').split(" ")[1];
        return Integer.parseInt(studentName.substring(studentName.length()-1));
    }

    /**
     * A method that, given the student name and lab number, returns a new file handle located
     * at a folder specified by {@code relativePath} to be used by any write capable streams.
     *
     * <p>This method assumes that the folder specified by {@code relativePath} already exists,
     * if it does not, this method throws a {@code NullPointerException}.</p>
     *
     * @param studentName string representing the student name.
     * @param labNumber int representing the current lab number
     * @return a file to be used by any write capable stream.
     */
    public static File getFile(String studentName, int labNumber){
        String relativePath = System.getProperty("user.home")+"/IdeaProjects/CS2401_TA/Results/Lab"+labNumber+"/";
        return new File(relativePath+studentName+labNumber+".txt");
    }

    //String makers
    public static String fileHeader(String studentName, int labNumber){
        String headerString = "";
        headerString += "\nStudent: "+studentName;
        headerString += "\nLab: "+labNumber+"";
        return headerString;
    }
    public static String titleString(String str, char dividerChar){
        String printLine = "";
        int lineLength = 30;
        for (int i = 0; i < lineLength-str.length()/2; i++) {
            printLine += dividerChar;
        }
        printLine += " "+str+" ";
        for (int i = 0; i < lineLength-str.length()/2; i++) {
            printLine += dividerChar;
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

    //Equality Checkers
    public static boolean equalDoubles(Double a, Double b){
        if ((a == null) ^ (b == null)) return false;
        else if ((a == null) && (b == null)) return true;
        else {
            double precision = 0.00001;
            double difference = a-b;
            if (difference < precision && difference > -precision) return true;
            return false;
        }
    }
    public static boolean equalIntegers(Integer a, Integer b){
        if ((a == null) ^ (b == null)) return false;
        else if ((a == null) && (b == null)) return true;
        else return a == b;
    }
}
