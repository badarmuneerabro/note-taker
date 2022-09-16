package com.badar.muneer.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connect 
{
	private static SessionFactory factory;
	private static Connect connect;

	private Connect() 
	{
		connect = new Connect();
	}

	public static Connect getConnection() 
	{
		return (connect == null) ? connect = new Connect() : connect;
	}

	public static SessionFactory getFactory() 
	{
		return (factory == null) ? factory = new Configuration().configure().buildSessionFactory() : factory;
	}
}
