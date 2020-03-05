package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class DAOItem
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "chores")
	private String items;
	
	public DAOItem() 
	{
		
	}
	
	public DAOItem(String items) 
	{
		this.items = items;
	}
	
	public DAOItem(int id, String items) 
	{
		this.id = id;
		this.items = items;
	}

	public int getId()
	{
		return id;
	}

	public String getItems()
	{
		return items;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setItems(String items)
	{
		this.items = items;
	}
}
