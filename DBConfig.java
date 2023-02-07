package com.edubridge.Config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.edubridge.Model.Departments;
import com.edubridge.Model.Employees;
import com.edubridge.Model.UserDetails;

public class DBConfig 
{
	private static SessionFactory factory=null;
	public static SessionFactory getFactory()
	{
		return factory;
	}
	
	public static void setFactory(SessionFactory factory)
	{
		DBConfig.factory=factory;
	}
	
	static
	{
		try
		{
			loadSessionFactory();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void loadSessionFactory()
	{
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		//conf.addAnnotatedClass(UserDetails.class);
		conf.addAnnotatedClass(Employees.class);
		conf.addAnnotatedClass(Departments.class);
		ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		setFactory(conf.buildSessionFactory(registry));
	}
	
	public static Session getSession()
	{
		return getFactory().openSession();
	}
}
