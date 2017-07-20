import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class TestCode{

    public static void createRandomIntFileOfSize(String str, int n){
        File arrayFile = new File(str+".txt");
        try(PrintWriter writer = new PrintWriter(arrayFile)){
            Random random = new Random();
            for (int i = 0; i < n-1; i++) {
                writer.print(random.nextInt(n)+" ");
            }
            writer.print(random.nextInt(n));
        }catch (Exception e){
            System.out.println("File error!");
        }
    }
    public static ArrayList<Integer> readFromFile(String str){
        try(BufferedReader reader = new BufferedReader(new FileReader(str+".txt"))){
            String[] intStrings = reader.readLine().split(" ");
            ArrayList<Integer> ints = new ArrayList<>();
            for (int i = 0; i < intStrings.length; i++) {
                ints.add(Integer.parseInt(intStrings[i]));
            }
            return ints;
        }catch (Exception e){
            return null;
        }
    }
    public static void main(String[] args) {


//        for (int i = 100; i <= 3200; i = i*2){
//            createRandomIntFileOfSize(""+i,i);
//        }
//
//        ArrayList<ArrayList<Integer>> allFileArrays = new ArrayList<>();
//        for (int i = 100; i <= 3200; i = i*2){
//            allFileArrays.add(readFromFile(""+i));
//        }
//
//        for (ArrayList<Integer> fileArray : allFileArrays) {
//            System.out.println(fileArray);
//        }



    }
}
