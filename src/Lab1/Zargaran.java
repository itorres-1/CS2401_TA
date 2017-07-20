package Lab1;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Zargaran {

    public static void main(String[] args){

        int[] f=readFromFile();

        boolean permut=isPermutation(f);

        if (permut==false){
            System.out.println("\nLet's try another file");
            readFromFile();
        }
        else{
            System.out.println("\n****the second Permutation Array****");
            int[] g=readFromFile();
            System.out.println("   <--- g elements");
            System.out.println("\n*******************************************");
            int[] compos=composition(f,g);
            printArray(compos);
            System.out.println("   <--- Composition Resaults");
            System.out.println("\n******************************************************");
            int[] inverse=inverse(f);
            System.out.println("   <--- Inverse Resaults");
            System.out.println("\n*******************************************************************");
            int k=0;
            System.out.println("Enter the pow: ");
            Scanner input=new Scanner(System.in);
            k=input.nextInt();
            pow(f,k);
        }
        System.out.println("   <--- Pow Resaults");
    }

       public static int[] readFromFile(){
           Scanner scnr= new Scanner(System.in);
           FileReader fr;
           BufferedReader reader;
           Boolean successfulFileRead=false;
           int[] newIntString=null;

           while(!successfulFileRead) {
               System.out.println("File Path:");
               try {
                   fr = new FileReader(scnr.nextLine());
                   reader = new BufferedReader(fr);

                   int k = Integer.parseInt(reader.readLine());
                   String[] intString = reader.readLine().split(" ");
                   newIntString=new int[intString.length];
                   for (int i=0;i<intString.length;i++){
                       newIntString[i]=Integer.parseInt(intString[i]);
                   }
                   successfulFileRead=true;
               }
               catch (FileNotFoundException e) {
                   System.out.println("File Not Found\n");
               } catch (IOException e) {
                   System.out.println("sth went wrong\n");
               }
           }
           printArray(newIntString);
           return newIntString;
       }

       public static Boolean isPermutation(int[] f){

           boolean yes=false;
           int frequency=0;
           for (int i=0; i<= f.length-1; i++){
               for (int j=i+1; j<= f.length-1; j++){
                   if (f[i]==f[j]){
                       frequency++;
                   }
               }
           }

           if (frequency==0){
               System.out.println("   <--- f elements");
               System.out.println("\n*********It is permutation*********");
               yes=true;
           } else {
               System.out.println("\n!!!It is NOT permutation!!!");
           }
           return yes;
       }

       public static int[] composition(int[] f,int[] g){
           int[] compos=new int[f.length];
           for (int i=0; i<=f.length-1; i++){
               compos[i]=f[g[i]];
           }
           return compos;
       }

       public static int[] inverse(int[] f){
           int[] invers=new int [f.length];
           for (int i=0; i<=f.length-1; i++){
               invers[i]=f[f[i]];
           }
           printArray(invers);
           return invers;
       }

       public static int[] pow(int[] f,int k){
           int[] poww=f.clone();
           for (int j=1; j<=k; j++){
               poww=composition(f,poww);
           }
           return poww;
       }

       public static void printArray(int[] f){
           for (int item:f){
               System.out.print(" "+item+" ");
           }
       }

    }


