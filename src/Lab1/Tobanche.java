package Lab1;

/*
Author:Oscar Tobanche
Date 6/22/2017
Assignment: Lab #1
Course: CS2401_TobancheOscar_Lab1
Professor: Julio Cesar Urenda
TA: Isaac Torres
*/
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Tobanche {
	public static int[] ReadFile(String file) throws FileNotFoundException{
		FileReader f = new FileReader(file);
		Scanner scnr = new Scanner (f);
		int ctr = 0;
		while(scnr.hasNextInt()){
			ctr++;
			scnr.nextInt();
		}
		int[] array = new int[ctr];
		Scanner s1 = new Scanner(f);
		for(int i = 0; i < array.length; i++){
			array[i] = s1.nextInt();
			}
		int i = 0;
		int[] array2 = new int[array.length-1];
		
		for(int j = 0; j <= array.length-1; j++){
			array2[j] = array[j+1];
}
			System.out.println(array2);
			return array2;
	}
	public static boolean isPermutation (int arrayName[]){
		int temp;
		boolean permutation = true;
//sort the values of the array from small to big
	    for (int i = 0; i < arrayName.length-1; i++)
	    {
	        if(arrayName[i] > arrayName[i+1])
	        {
	            temp=arrayName[i];
	            arrayName[i]=arrayName[i+1];
	            arrayName[i+1]=temp;
	            i=-1;
	        }
	    }
//check if the value of the following number is the current number +1
	    for(int i = 0; i < arrayName.length-1; i++){
	    	if(arrayName[1] == arrayName[0]+1){
	    		permutation = true;
	    	}
	    	else{
	    		
	    		permutation = false;
	    		i = arrayName.length;
	    	}
	    }
	    if(permutation){
	    	System.out.println("The following is a permutation "+ permutation);
	    }
	    else
	    	System.out.println("The following array is not a permutation"+ permutation);
	    return permutation;
		
	}
	public static int[] composition(int f[],int g[]){
//temporal function to swap i and temp values
		int temp = 0;
		int[] a = new int[f.length];
		for(int i = 0; i < f.length-1; i++){
			temp = g[i];
			a[i] = f[temp];
			
		}
		System.out.println(a);
		return a;
	}
//
	public static int[] inverse(int a[]){
		int[] b = new int[a.length];
		int temp = 0;
		int j = 0;
		for(int i = 0; i < a.length-1;i++){
			temp = a[i];
			a[temp] = j;
			b[i] = a[j];
			
		}
		System.out.println(b);
		return b;
		
	}
	public static int[] pow(int f[], int k){
		int temp = 0;
		int[] a = new int[f.length];
		for(int j = 0; j<= k; j++ ){
			for(int i = 0; i < f.length-1; i++){
			
			temp = f[i];
			a[i] = f[temp];
			}
	}
		System.out.println(a);
		return a;
	}	

	
//	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scnr = new Scanner(System.in);
//		String path = "";
//		int n = 0;
//		String answer = "Yes";
//		//menu displayed in the console
//		while(answer.equals("Yes")||answer.equals("yes")){
//			//prints the available options to the user
//			System.out.println("Enter the number of the option you want to perform");
//			System.out.println("1.Check if the array is a permutation array");
//			System.out.println("2.Compute the composition of two arrays");
//			System.out.println("3.Compute the inverse of the array");
//			System.out.println("4.Compute the power k composition of the array");
//			n = scnr.nextInt();
//			//options body code
//			switch(n){
//				case 1:
//					//check permutation method call
//					System.out.println("Type the path");
//					path = scnr.next();
//
//					CheckPerm(ReadFile(path));
//					break;
//				case 2:
//					//composition method call
//					String path2 = "";
//					System.out.println("Type the path for first array");
//					path = scnr.next();
//					System.out.println("Type the path for second array");
//					path2 = scnr.next();
//					Composition(ReadFile(path), ReadFile(path2));
//					break;
//				case 3:
//					//inverse permutation method call
//					System.out.println("Type the path");
//					path = scnr.next();
//					Inverse(ReadFile(path));
//					break;
//				case 4:
//					//power k method call
//					int k =0;
//					System.out.println("Type the path");
//					path = scnr.next();
//					System.out.println("set the value of k");
//					k = scnr.nextInt();
//					Pow(ReadFile(path),k);
//					break;
//				default:
//					//default option in case the input is other than 1, 2, 3, 4
//					System.out.println("Invalid input, Try again with valid inputs. example[1,2,3,4]");
//
//					break;
//			}
//			// keeps asking until the user enters no
//			System.out.println("Do you want to continue? (yes/no)");
//			answer = scnr.next();
//
//
//		}
//
//	}

}
