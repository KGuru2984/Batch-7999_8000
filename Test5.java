package com.edubridge.Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edubridge.Config.DBConfig;
import com.edubridge.Model.UserDetails;

//SQL 
public class Test5 
{
public static void getUserDetails()
{
	Session s=DBConfig.getSession();
	Query q=s.createNativeQuery("select * from UserDetails").addEntity(UserDetails.class);
	List<UserDetails> result=q.getResultList();
	
	for(UserDetails x:result)
	{
		System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
	}
}

public static void getUserDetailsByID(int userid)
{
	Session s=DBConfig.getSession();
	Query q=s.createNativeQuery("select * from UserDetails where userid=?").addEntity(UserDetails.class);
	q.setParameter(1, userid);
	List<UserDetails> result=q.getResultList();
	
	for(UserDetails x:result)
	{
		System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
	}
}
public static void main(String[] args) 
{
	getUserDetailsByID(3);
}
}
