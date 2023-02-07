package com.edubridge.Main;

import java.util.List;

import org.hibernate.Session;

import com.edubridge.Config.DBConfig;
import com.edubridge.Model.UserDetails;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Test3 {

	public static void getUserDetailsByID(int userid)
	{
		Session s=DBConfig.getSession();
		CriteriaBuilder cb=s.getCriteriaBuilder();
		CriteriaQuery<UserDetails> query=cb.createQuery(UserDetails.class);
		Root<UserDetails> root=query.from(UserDetails.class);
		query.select(root).where(cb.equal(root.get("userID"),userid));
		List<UserDetails> result=s.createQuery(query).getResultList();
		
		for(UserDetails x:result)
		{
			System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
		}

	}
	public static void getUserDetailsByName(String usrname)
	{
		Session s=DBConfig.getSession();
		CriteriaBuilder cb=s.getCriteriaBuilder();
		CriteriaQuery<UserDetails> query=cb.createQuery(UserDetails.class);
		Root<UserDetails> root=query.from(UserDetails.class);
		query.select(root).where(cb.like(root.get("userName").as(String.class),usrname+"%"));
		List<UserDetails> result=s.createQuery(query).getResultList();
		
		for(UserDetails x:result)
		{
			System.out.println("User ID:"+x.getUserID()+" User Name:"+x.getUserName()+ " User Address:"+x.getAddress());
		}

	}
	/*  gt - greater than,lt - less tha, ge- greater than and equals , le -less than and equals , like , between */
	
	public static void main(String[] args) 
	{
		getUserDetailsByID(5);
		getUserDetailsByName("A");
	}

	
	
}
