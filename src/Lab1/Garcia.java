//Brian Garcia 
//CS 2401
//Elementary Data Structures Lab 1
//Urenda Julio


import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Garcia {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//Set boolean to restart program if wrong choice is made
		boolean run = true;
		while (run == true) {


//This is where I will Initialize the File Reader to the code
			int[] line = new int[20];
			int i = 0;
			int x = 0;


			int[] line1 = FileR(line);

			int ArrayL = 0;
			ArrayL = line[0];
			int[] Test = new int[ArrayL];
			x = 1;
			for (i = 0; i < ArrayL; i++) {
				Test[i] = line[x];
				x++;
			}
			boolean Valid1 = FileR1(line, Test);
			if (Valid1 == true) {
				System.out.println("File with these Contents Accepted");

			}
			if (Valid1 == false) {
				System.out.println("Please enter a valid File");
				line1 = FileR(line);
				ArrayL = 0;
				ArrayL = line[0];
				Test = new int[ArrayL];
				x = 1;
				for (i = 0; i < ArrayL; i++) {
					Test[i] = line[x];
					x++;
				}
			}


//Remember to keep all Labels the same so the code works completely without the reader for now

			System.out.println("");


// Initializing the starting variables to be used for the decision making

			System.out.println("Please choose the Lab Demo you are trying to access");
			System.out.println();
			System.out.println("1: Permutation checker");
			System.out.println("2: Composition creator");
			System.out.println("3: Inverse creator");
			System.out.println("4: Power creator");
			System.out.println("5: Exit program");
			System.out.println();

//Initializing the acctual option the user chooses
			int Choice = 0;
			Choice = scanner.nextInt();

			System.out.println("Thank you for choosing Option: " + Choice);
			System.out.println("");

//Switch cases to access the options and start the desired option 		

			switch (Choice) {

				//Case one is for The permutation checker
				//Unfinished
				case 1:
					boolean perm = false;
					boolean Perm = Permutation(ArrayL, Test);

					break;

				//Case two is for the Composition creator
				//Unfinished
				case 2:
					int[] line2 = new int[20];
					line2 = FileR2(line2);
					ArrayL = 0;
					ArrayL = line2[0];
					int[] Test2 = new int[ArrayL];
					x = 1;
					for (i = 0; i < Test2.length; i++) {
						Test2[i] = line2[x];
						x++;
					}
					boolean Valid2 = FileR3(line2, Test2);
					if (Valid2 == true) {
						System.out.println("File with these Contents Accepted");
//
					}
					if (Valid2 == false) {
						System.out.println("Please enter a valid File");
						line2 = FileR2(line2);
						ArrayL = 0;
						ArrayL = line2[0];
						Test2 = new int[Test.length];
						x = 0;
						for (i = 0; i < Test.length; i++) {
							Test2[i] = line2[x];
							x++;
						}
					}
					System.out.println("");
					int[] composition1 = Composition(Test, Test2);
					System.out.println("This is your new composition");
					for(i=0; i<composition1.length; i++) {
						System.out.print(composition1[i] + " ");
					}
					System.out.println("Test complete 2");
					break;


				//Case 3 is for the inverse Creator
				//finished
				case 3:
					Inverse(ArrayL, Test);


					break;


				//case 4 is for the Power Creator.
				//Unfinished
				case 4:
					int k = 0;
					x = 0;
					int[] copy = new int[ArrayL];
					i = 0;
					for (i = 0; i < Test.length; i++) {
						copy[i] = Test[i];
					}
					int[] power = Power(Test, copy, ArrayL, k, x, i);
					for (i = 0; i < power.length; i++) {
						System.out.print(power[i] + " ");
					}
					System.out.println("Test complete 4");
					break;


				//Case 5 is for exiting the program
				case 5:
					System.out.println("Thank you for using this program goodbye");
					run = false;
					break;


				//case made for a choice that is outside the desired range
				default:
					System.out.println("");
					System.out.println("Invalid option!!!!!");
					//Keep in mind the code will continue looping as long as the decision is not the number 5!!!!

			}


			//Methods for the main


		}
	}

	public static int[] Inverse(int ArrayL, int[] Test) {
		int[] Inverse = new int[ArrayL];
		int q = 0;
		int i = 0;
		int x = 0;


		for (i = ArrayL - 1; i >= 0; i--) {
			x = Test[i];
			Inverse[x] = Test[i];
			x++;
		}
		System.out.println("The inverse of your Array is: ");
		for (i = 0; i < ArrayL; i++) {
			System.out.print(Inverse[i] + " ");
		}

		System.out.println("");
		System.out.println("Test complete");
		return Inverse;
	}

	public static boolean Permutation(int ArrayL, int[] Test) {
		int i = 0;
		int x = 0;
		int Counter = 0;
		boolean Once = true;
		while (Once == true) {
			for (i = 0; i < ArrayL; i++) {
				//Counter = 0;
				for (x = 0; x < Test.length; x++) {
					if (Test[i] == Test[x]) {
						Counter++;
						System.out.println(Counter);


						if (Counter != ArrayL) {
							Once = false;
						}
					}
				}
			}
		}

		if (Counter == ArrayL) {
			Once = true;


		}


		if (Once == true) {
			System.out.print("Your array which is made up of: ");

			for (i = 0; i < ArrayL; i++) {
				System.out.print(Test[i] + " ");
			}
			System.out.println("");
			System.out.println("Is a valid permutation");
			System.out.println("");
		}

		if (Once == false) {
			System.out.print("Your array which is made up of: ");

			for (i = 0; i < ArrayL; i++) {
				System.out.print(Test[i] + " ");
			}
			System.out.println("");
			System.out.println("Is a not valid permutation");
			System.out.println("");


		}
		System.out.println("Test complete");
		return Once;

	}

	public static int[] FileR(int[] line) {
		int i = 0;
		try {
			System.out.print("Enter the file name with extension : ");

			Scanner input = new Scanner(System.in);

			File file = new File(input.nextLine());

			input = new Scanner(file);


			while (input.hasNextInt()) {


				line[i] = input.nextInt();

				System.out.print(line[i] + " ");
				i++;
			}

			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return line;

	}

	public static boolean FileR1(int[] line1, int[] Test) {
		int i = 0;
		boolean Valid = false;

		if (line1[0] == Test.length) {
			Valid = true;
		}
		return Valid;

	}

	public static int[] Power(int[] Test, int[] copy, int ArrayL, int k, int x, int i) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("To what power do you want to multiply your array");
		k = scanner.nextInt();

		int[] power = new int[ArrayL];
		int y = 0;
		int temp = 0;
		i = 0;
		for (y = 0; y < k - 1; y++) {
			for (i = 0; i < Test.length; i++) {
				power[i] = copy[Test[i]];
			}
		}

		return power;

	}

	public static int[] Composition(int[] Test, int[] Test2) {
		int i=0;
		int[] composition1 = new int[Test2.length];
		for (i = 0; i < Test2.length; i++) {
			composition1[i] = Test[Test2[i]];

		}
		return composition1;

	}

	public static int[] FileR2(int[] line2) {
		int i = 0;
		try {
			System.out.print("Please enter second path : ");

			Scanner input = new Scanner(System.in);

			File file = new File(input.nextLine());

			input = new Scanner(file);


			while (input.hasNextInt()) {


				line2[i] = input.nextInt();

				System.out.print(line2[i] + " ");
				i++;
			}

			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return line2;

	}

	public static boolean FileR3(int[] line2, int[] Test2) {
		int i = 0;
		boolean Valid = false;

		if (line2[0] == Test2.length) {
			Valid = true;
		}
		return Valid;

	}
}

