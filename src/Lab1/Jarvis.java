package Lab1;

//package cs2401_assignment_1_jarvis;
import java.io.*;
import java.util.Scanner;

/**
 * This is assignment 1 for CS 2401
 * @author Brian Jarvis
 * @version 1.0
 * @since 6/21/2017
 */
		
public class Jarvis
{

//	public public static void main(String[] args) throws FileNotFoundException
//	{
//		//Print menu to screen and get user's input
//		int userMenuChoice = -1;
//
//		while(userMenuChoice != 5)
//		{
//			userMenuChoice = displayMenu();
//
//			switch (userMenuChoice)
//			{
//				case 1: //Permutation Check
//				{
//					System.out.println("You've chosen wisely: " + userMenuChoice + " Permutation Checker");
//					int [] userArrayOne = readFileReturnArray("");
//
//					//Check to see if the array is a permutation array
//					while(isPermutation(userArrayOne, "") == false)
//						{
//							userArrayOne = readFileReturnArray("");
//						}
//					break;
//				}
//				case 2: // Comnposition
//				{
//					System.out.println("You've chosen wisely: " + userMenuChoice + " Composition of two arrays");
//					//Get two arrays from the user
//					int [] userArrayOne = readFileReturnArray(" first");
//					int [] userArrayTwo = readFileReturnArray(" second");
//
//
//					//Check to see if both arrays are permutation arrays
//					while(isPermutation(userArrayOne, " first") == false)
//						{
//							userArrayOne = readFileReturnArray(" first");
//						}
//
//					while(isPermutation(userArrayTwo, " second") == false)
//						{
//							userArrayTwo = readFileReturnArray(" second");
//						}
//
//					int [] composedArrayB = new int [userArrayOne.length];
//
//					//If the two arrays are not of the same length, repeat
//					if(userArrayOne.length != userArrayTwo.length)
//					{
//						System.out.println("The two arrays are NOT of the same length so they cannot be composed - Returning to menu");
//						break;
//					}
//					else
//					{
//						//int [] composedArrayB = composedArray(userArrayOne, userArrayTwo);
//						composedArrayB = composedArray(userArrayOne, userArrayTwo);
//						printArray(composedArrayB, " composition of the first array with the second");
//					}
//
//					break;
//				}
//				case 3: //Inverse
//				{
//					System.out.println("You've chosen wisely: " + userMenuChoice + " Array Inverse");
//					int [] userArrayOne = readFileReturnArray("");
//
//					//Check to see if the array is a permutation array
//					while(isPermutation(userArrayOne, "") == false)
//						{
//							userArrayOne = readFileReturnArray("");
//
//						}
//
//					inverseOfArray(userArrayOne);
//
//					break;
//				}
//				case 4: //Power
//				{
//					System.out.println("You've chosen wisely: " + userMenuChoice + " Power");
//					int [] userArrayOne = readFileReturnArray("");
//
//					//Check to see if the array is a permutation array
//					while(isPermutation(userArrayOne, "") == false)
//						{
//							userArrayOne = readFileReturnArray("");
//
//						}
//
//					int [] powerArrayA = arrayPowered(userArrayOne);
//					printArray(powerArrayA, " power array");
//
//					break;
//				}
//			}
//
//		}
//	}
	

	public static int [] readFileReturnArray(String arrayNumber) throws FileNotFoundException
	{
		
		//****************************************************
		//  Get the file from the user and number of entries
		//****************************************************
		

		
		
		
		
		
		//calculate the actual number of values in the file
			int fileNumberOfValues = 0;
			int tempValueHolder = 0;
			Scanner scanner = new Scanner(System.in);
			String usersFilePath = "nothing";   
			File userFile = null;
			Scanner input = null;
			boolean done = false;

		//Open the file and make sure the file path leads to an appropriate file	
			while(!done)
			{
				try
				{
					System.out.print("Please enter the" + arrayNumber +  " file path: ");
					usersFilePath = scanner.next(); 
					userFile = new File(usersFilePath);
					input = new Scanner(userFile);
					
					// get rid of the first value in the file
					int statedArraySize = input.nextInt();
					
					//find the number of values in the second line
					while(input.hasNext())
						{
							tempValueHolder = input.nextInt();
							fileNumberOfValues++;						
						}
					
					done = true;
				}
				catch (Exception e)
				{
					System.out.println("Something was wrong with the file path or file data.");
					scanner.nextLine();
				}
			}

		//Close the file so you can reread it
		input.close();

		//****************************************************
		//  Create the Array and fill it by rereading the file
		//****************************************************		

		int [] arrayOfUserValues = new int[fileNumberOfValues];
		int counter = 0;

		//Reopen the file for rereading - no need to deal with exception we've already checked this file
		input = new Scanner(userFile);

		//Get rid of the first value in the file
		int trash = input.nextInt();

		System.out.print("The" + arrayNumber + " array contains these values: ");

		//add the values to the arry
		while(input.hasNext())
		{
			arrayOfUserValues[counter] = input.nextInt();
			System.out.print(arrayOfUserValues[counter]);
			counter++;
		}
		System.out.println();

		return arrayOfUserValues;
		
	}
	

	public static boolean isPermutation(int[] userArrayA)
	{		
		//check to see if the values are from 0 to n and are consecutive with no repeats or omissions
		
		for (int i = 0; i < userArrayA.length; i++)
		{
			int count = 0;
			
			for (int j = 0; j < userArrayA.length; j++)
			{
				if(userArrayA[j] == i)
				{
					count++;
					//System.out.println("count now equals " + count);
				}
			}
			
			if(count !=1)
			{

				return false;
				
			}
			else
			{
				count = 0;
				//System.out.println("i = " + i + " and it checks out");
			}
			
		}

		return true;
	}
	

	public static int[] composition(int[] arrayOne, int[] arrayTwo)
	{

		
		int [] composedArray = new int [arrayOne.length];
		
		for (int i = 0; i < arrayOne.length; i++)
			{                        
				composedArray[i] = arrayOne[arrayTwo[i]];
			}

		return composedArray;
	}
		

	public static int[] inverse(int[] userArrayOne)
	{
		int [] inverseArray = new int [userArrayOne.length];

		//find the value 0, store the index, assign that index as the value of 0 in inverseArray
		for (int i = 0; i < inverseArray.length; i++)
		{
			for (int j = 0; j < inverseArray.length; j++)
			{
				if(userArrayOne[j] == i)
				{
					inverseArray[i] = j;
				}
			}
		}
		return inverseArray;

	}
	

	public static int[] pow(int[] userArrayOne, int requestedPowerA)
	{

		
		int [] powerArray = new int[userArrayOne.length];
		
		if(requestedPowerA > 1)
          {
			for (int i = 0; i < requestedPowerA-1; i++)
				{
					if (i == 0)
						{
							powerArray = composition(userArrayOne, userArrayOne);
						}
					else
						{
						   powerArray = composition(powerArray, userArrayOne);
						}   
				}
		  }
		else
		  {
			System.out.println("The power must be greater than 1");	
	 	  }

			return powerArray;
	}
  
	

	public static void printArray(int [] arrayToBePrinted, String arrayName)
	{
		System.out.print("The" + arrayName + " is: " );
		for (int i = 0; i < arrayToBePrinted.length; i++)
			{
				System.out.print(arrayToBePrinted[i]);
			}		
		System.out.println("");
	}
	
	
	/**
	 * displayMenu displays a menu for the user to select from
	 * 
	 * @return Returns the integer that the user selected or exits the program is 5 is entered
	 */		
	public static int displayMenu()
	{
		//print menu to screen
		System.out.println("");
		System.out.println("****************************************************");
		System.out.println("What would you like to do?                         *");
		System.out.println("    1: Check if an array is a permutation array    *");
		System.out.println("    2: Find the composition of two arrays          *");
		System.out.println("    3: Find the inverse of an array                *");
		System.out.println("    4: Computer the power of an array              *");
		System.out.println("    5: Exit Program                                *");
		System.out.println("****************************************************");
		
		
		//ask user for their input and return their value to the screen

		Scanner scanner = new Scanner(System.in);
		int userSelection = 0;
		int totalNumberOfOptions = 5;
		boolean done = false;
		
		
		while(!done)
		{
			try
			{
				System.out.print("Your selection? ");
				userSelection = scanner.nextInt();
				
				if(userSelection == 5)
				{
					System.out.println("Goodbye! ------------------------------");
					System.exit(0);
				}

				if(userSelection < 1 || userSelection > totalNumberOfOptions)
				{
					done = false;
					System.out.println("That number was not one of the options - Please try again");
				}
				else
				{
					done = true;
					System.out.println("You've selected option: " + userSelection);
					return userSelection;
				}
				
			}
			catch (Exception e)
			{
				System.out.println("That value was not a number");
				scanner.nextLine();
			}
		}
		
		return -1;
	}
	
}
