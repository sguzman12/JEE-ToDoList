package controller;

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
 * Main class which calls the Control.start method to begin application.
 */
public class Main
{

	public static void main(String[] args)
	{
		Control con = new Control();
		con.start();

	}

}
