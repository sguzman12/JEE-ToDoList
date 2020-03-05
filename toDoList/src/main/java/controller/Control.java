package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOItem;
import model.Model;
import view.View_Command_Line;

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
 * Called from main and controls user responses as well as holds ArrayList of to-do items.
 */
public class Control extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Default constructor.
	 */
	public Control()
	{
		mod = new Model();
		itemList = new ArrayList<String>();
		view = new View_Command_Line();
	}

	/*
	 * Calls prompt method for user input and from there calls corresponding
	 * methods inside the model class that holds the business logic.
	 */
	public void start()
	{
		try
		{
			while(cont)
			{
				optionInput = 0;

				optionInput = promptInput();

				if(optionInput == 0) // Close app
				{
					System.exit(0);
				}
				else if(optionInput == 1) // Add item
				{
					String inputOpt = "";

					inputOpt = promptAddItem();
					
					mod.addItem(itemList, inputOpt);

				}
				else if(optionInput == 2) // Delete item
				{
					int inputDel = 0;

					inputDel = promptDeleteItem();

					itemList = mod.deleteItem(itemList, inputDel);

				}
				else // View list
				{
					viewList(itemList);
				}

			}
		}
		catch(Exception exxxx)
		{
			System.out.println("Please re-enter an input.");
			exxxx.printStackTrace();
			start();
		}
	}

	/*
	 * Prompts user at main menu for what option they would like, Add, Delete,
	 * or View items on list. Checks that input is in range of options and
	 * returns if correct otherwise prompts main menu.
	 * 
	 * @return prompt Input main menu prompt
	 */
	private int promptInput()
	{
		int prompt = 0;

		try
		{

			prompt = view.promptMain();

			if(optionInput >= 0 && optionInput <= 3)
			{
				return prompt;

			}
			else
			{
				System.out.println("Invalid Input. Please select an option.");
				promptInput();
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			promptInput();
		}

		return prompt;

	}

	/*
	 * Calls view class and prompts for string line
	 * 
	 * @return addItem New string entry for list.
	 */
	private String promptAddItem()
	{
		String addItem = "";

		addItem = view.promptAdd();

		return addItem;
	}

	/**
	 * Calls View method to display out list.
	 * @param list To-do arraylist
	 */
	private void viewList(ArrayList<String> list)
	{
		view.viewList(list);
	}

	/**
	 * Calls view class to prompt user for delete option. View list is called first. After 
	 * input is checked to make sure NoOutOfBoundsException is triggered.
	 * @return deleteInput User input for what to delete inside the list.
	 */
	private int promptDeleteItem()
	{
		int deleteInput = 0;

		viewList(itemList);
		deleteInput = view.promptDelete();

		if(deleteInput >= 1 && deleteInput <= itemList.size())
		{
			return deleteInput;
		}
		else
		{
			System.out.println("Incorrect input choice. Please select again.");
			promptDeleteItem();
		}

		return deleteInput;
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		// Preprocess request: load list of products for display in JSP.
       // ArrayList<DAOItem> items = new ArrayList<DAOItem>();
        
        	//	items = (ArrayList<DAOItem>) mod.returnList(); 
        
       
        request.setAttribute("itemList", "Test");
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

	// Objects
	private Model mod;
	private View_Command_Line view;

	// Varibales
	private boolean cont = true; // Condition statement for while loop.
	private int optionInput; // User option input in main screen.
	private ArrayList<String> itemList; // Holds to do list.
}
