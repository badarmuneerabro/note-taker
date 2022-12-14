package com.badar.muneer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name = "NOTES")
public class Note 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String title;
	
	@Column(length = 1500)
	private String content;
	Date addedDate;
	
	public Date getAddedDate() 
	{
		return addedDate;
	}
	public void setAddedDate(Date addedDate) 
	{
		this.addedDate = addedDate;
	}
	public int getId() 
	{
		return Id;
	}
	public void setId(int id) 
	{
		Id = id;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public String getContent() 
	{
		return content;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}
	
	

}
