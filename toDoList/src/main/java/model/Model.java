package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.DAOItem;

import controller.Control;

import utilities.UtilHibernate;

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
 * Class holds the logic that changes the ArrayList.
 */
public class Model
{

	/**
	 * Default Constructor
	 */
	public Model()
	{

	}

	/**
	 * Adds string line to ArrayList
	 * 
	 * @param list
	 *            To-do ArrayList passed
	 * @param inputItem
	 *            To-do string added to ArrayList
	 * @return list Updated To-do ArrayList
	 */
	public void addItem(ArrayList<String> list, String inputItem)
	{

		try
		{
			Session session = utilities.UtilHibernate.getSessionFactory()
					.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("Transaction created");

			session.save(inputItem);

			System.out.println("session saved");
			transaction.commit();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			transaction.rollback();
		}

	}

	/**
	 * Delete item from To-do ArrayList
	 * 
	 * @param list
	 *            To-do ArrayList passed
	 * @param choice
	 *            User input for which item to delete from list
	 * @return list Updated ArrayList
	 */
	public ArrayList<String> deleteItem(ArrayList<String> list, int choice)
	{

		list.remove(choice - 1);

		return list;
	}

	public List<DAOItem> returnList()
	{
		List<DAOItem> list = null;
		// String hql = "select dao.Product"
		try
		{
			Session session = UtilHibernate.getSessionFactory().openSession();
			Query query = session.createQuery("from dao.DAOItem");

			list = query.getResultList();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	// Objects
	Control con;
	UtilHibernate hib;
	Transaction transaction = null;
}
