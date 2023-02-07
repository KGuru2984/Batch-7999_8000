package com.edubridge.Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edubridge.Config.DBConfig;
import com.edubridge.Model.UserDetails;

// HQL - Hibernate Query Language
public class Test4 
{
	public static void getUserDetails()
	{
		Session s=DBConfig.getSession();
		
		List<UserDetails> result=s.createQuery("from com.edubridge.Model.UserDetails").getResultList();
		
		for(UserDetails x:result)
		{
			System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
		}
	}
	
	public static void getUserDetailsByName(String usrname)
	{
Session s=DBConfig.getSession();
		
		Query query=s.createQuery("from com.edubridge.Model.UserDetails where userName like :unm");
		List<UserDetails> result=query.setParameter("unm", usrname+"%").getResultList();
		for(UserDetails x:result)
		{
			System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
		}
	}
	public static void main(String[] args) 
	{
		//getUserDetails();
		getUserDetailsByName("A");
	}
}
