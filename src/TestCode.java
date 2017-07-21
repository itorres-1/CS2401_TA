import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class TestCode{

    public static double todd(double a, int n){
        if (n==0) return 1;
        return (n<0)? todd(a,n+1)/a:a*todd(a,n-1);
    }
    public static void main(String[] args) {
        System.out.println(todd(2,-1));
    }
}
