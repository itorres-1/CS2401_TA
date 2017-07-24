import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class TestCode{

    public static void foo(int n){
        if (n>0){
            System.out.println(n);
            foo(n-1);
            System.out.println(n);
        }
    }
    public static void goo(int n){
        if (n > 0){
            goo(n-1);
            System.out.println(n);
            goo(n-1);;
        }
    }
    public static void main(String[] args) {
        System.out.println("foo(4):");
        foo(4);
        System.out.println("goo(4):");
        goo(4);
    }
}
