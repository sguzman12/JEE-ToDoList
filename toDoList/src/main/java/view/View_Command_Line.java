package view;

import java.util.ArrayList;
import java.util.Scanner;

//Author: Sigfredo Guzman
//Organization: CEN 4025


//Write a simple to-do-item application in Java. It should support the following features,
//Add a to-do item
//Delete a to-do item
//View the to-do items

//Make sure to structure your program in a modular way. In this case, that means you would 
//have a command-line application which uses a class that holds the to-do items internally 
//and provides public methods to add an item, delete an item, and provide the list of to-do items.


/*
 * Command line user interface
 */
public class View_Command_Line
{
	/*
	 * Default Constructor initializes scanner object.
	 */
	public View_Command_Line()
	{
		input = new Scanner(System.in);

	}

	/*
	 * Main menu prompt. Gives users options on what options they have. To keep from receiving an InputMismatch error
	 * the scanner will only save int values.
	 * @return promptUserMain Menu option choice 
	 */
	public int promptMain()
	{
		int promptUserMain = 0;

		try
		{

			System.out.println(
					"Please select an option: \n[1]Add an item to the to do list. \n[2]Delete a to do item. \n[3]View to do item list. "
							+ "\n[0]To close program.");

			while(!input.hasNextInt())
			{
				System.out.println("Invalid Input. Please select an option.");
				input.next();
			}
			return promptUserMain = input.nextInt();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();

			System.out.println("Invalid Input. Please select an option.");
			promptMain();
		}
		
		return promptUserMain;
	}

	/*
	 * Prompt add menu. Asks user for a String line on what they would like to add to the ArrayList.
	 * @return item String line of item to add to list.
	 */
	public String promptAdd()
	{
		String item = "";
				
		try
		{

			System.out.println(
					"\nWhat would you like to add to the to-do list?\n");
			
			input.nextLine();

			item = input.nextLine();
			
			return item;

		}
		catch(NullPointerException e)
		{
			System.out.println("Sorry, could you type that in again.");
			

		}
		catch(Exception ex)
		{
			System.out.println("Sorry, could you type that in again.");
			promptAdd();
		}
		return item;
	}

	/*
	 * Prompt user at delete menu. Displays list and prompts user for which item to delete from list.
	 */
	public int promptDelete()
	{
		int delete = 0;

		try
		{

			System.out.println(
					"\nWhich item would you like to take off the to-do list?\n");
			
			while(!input.hasNextInt())
			{
				System.out.println("Invalid Input. Please select which number to delete from list.");
				input.next();
			}
			
			delete = input.nextInt();
		}
		catch(NullPointerException ex)
		{
			System.out.println("Please enter an input.");
			ex.printStackTrace();
			promptDelete();
		}
		catch(NumberFormatException exxx)
		{
			System.out.println("Please re-enter an input.");
			exxx.printStackTrace();
			promptDelete();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Invalid Input. Please select an option.");
			promptDelete();
		}
		return delete;
	}

	/*
	 * Displays entire list to command line.
	 */
	public void viewList(ArrayList<String> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println((i + 1) + ") " + list.get(i));
		}
		System.out.println();
	}

	//Object
	Scanner input;
	

}
