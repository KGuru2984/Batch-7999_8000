package com.edubridge.Main;

import java.util.List;

import org.hibernate.Session;

import com.edubridge.Config.DBConfig;
import com.edubridge.Model.UserDetails;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Test2 {

	public static void getUserDetails()
	{
		Session s=DBConfig.getSession();
		CriteriaBuilder cb=s.getCriteriaBuilder();
		CriteriaQuery<UserDetails> query=cb.createQuery(UserDetails.class);
		Root<UserDetails> root=query.from(UserDetails.class);
		query.select(root);
		List<UserDetails> result=s.createQuery(query).getResultList();
		
		for(UserDetails x:result)
		{
			System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
		}
	}
	public static void main(String[] args) 
	{
		getUserDetails();

	}
	
	

}
