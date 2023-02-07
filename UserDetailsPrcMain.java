package com.edubridge.Main;

import java.util.List;

import org.hibernate.Session;

import com.edubridge.Config.DBConfig;
import com.edubridge.Model.UserDetails;

public class UserDetailsPrcMain 
{
	public static void getDetails()
	{
		Session s=DBConfig.getSession();
		
		List<UserDetails> result=s.getNamedNativeQuery("getudetails").getResultList();
		
		for(UserDetails x:result)
		{
			System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
		}
	}
	
	public static void getDetailsByID(int userid)
	{
		Session s=DBConfig.getSession();
		List<UserDetails> result=s.getNamedNativeQuery("getdetailsbyid").setParameter("uid", userid).list();
		
		for(UserDetails x:result)
		{
			System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
		}
	}
	
	public static void main(String[] args) 
	{
		getDetailsByID(3);
	}
}
