package com.edubridge.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.edubridge.Config.DBConfig;
import com.edubridge.Model.UserDetails;

public class Test1 {
	
	public static void addRecord(UserDetails a)
	{
		Session s=DBConfig.getSession();
		Transaction tx=s.beginTransaction();
		s.persist(a);
		tx.commit();
	}
	
	public static void updateRecord(UserDetails a)
	{
		Session s=DBConfig.getSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(a);
		tx.commit();
	}
	
	public static void deleteRecord(UserDetails a)
	{
		Session s=DBConfig.getSession();
		Transaction tx=s.beginTransaction();
		s.delete(a);
		tx.commit();
	}

	public static void main(String[] args) 
	{
		UserDetails ud=new UserDetails();
		ud.setUserName("AddRecord");
		ud.setAddress("Mumbai");
		
		addRecord(ud);
		
		UserDetails ud1=new UserDetails();
		ud1.setUserID(2);
		ud1.setAddress("Mumbai");
		ud1.setUserName("XYZ");
		
		updateRecord(ud1);
		
		UserDetails ud2=new UserDetails();
		ud2.setUserID(4);
		deleteRecord(ud2);
				
		
//		Configuration cf=new Configuration().configure().addAnnotatedClass(UserDetails.class);
//		SessionFactory sf=cf.buildSessionFactory();
//		Session s=sf.openSession();
//		Transaction tx =s.beginTransaction();
//		//s.save(s);
//		s.persist(ud);
//		tx.commit();
		
	
	}

}

/*
save is depricated , persist
-- Session Interface will use Session factory interface
-- SessionFactory - Interface - will use a class called as Configuration
*/