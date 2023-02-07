package com.edubridge.Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edubridge.Config.DBConfig;
import com.edubridge.Model.Departments;
import com.edubridge.Model.Employees;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmpDeptMain {

	public static void addDepartments()
	{
		Session sess=DBConfig.getSession();
		Transaction tx=sess.beginTransaction();
		
		Departments dt1=new Departments();
		dt1.setDeptName("Sales & Marketing");
		Departments dt2=new Departments();
		dt2.setDeptName("Accounts");
		Departments dt3=new Departments();
		dt3.setDeptName("IT Support");
		
		sess.persist(dt1);
		sess.persist(dt2);
		sess.persist(dt3);
		
		tx.commit();
	}
	
	public static void addEmployees(String name,float salary,Departments d)
	{
		Session sess=DBConfig.getSession();
		Transaction tx=sess.beginTransaction();
		
		Departments d1=new Departments();
		d1.setDeptID(1);
		Departments d2=new Departments();
		d2.setDeptID(2);
		Departments d3=new Departments();
		d3.setDeptID(3);
		
//		Employees et1=new Employees("Sagar",34000.0f,d1);
//		Employees et2=new Employees("Sameer",54000.0f,d2);
//		Employees et3=new Employees("Piyush",84000.0f,d3);
//		Employees et4=new Employees("Kalyani",24000.0f,d1);
		Employees et5=new Employees(name,salary,d);
		
//		sess.persist(et1);
//		sess.persist(et2);
//		sess.persist(et3);
//		sess.persist(et4);
		sess.persist(et5);
		
		tx.commit();

	}
	
	public static void getDetails()
	{
		Session s=DBConfig.getSession();
		CriteriaQuery<Departments> query=s.getCriteriaBuilder().createQuery(Departments.class);
		Root<Departments> root=query.from(Departments.class);
		query.select(root);
		
		List<Departments> result=s.createQuery(query).getResultList();
		
		for(Departments dept:result)
		{
			System.out.println("Department ID:"+dept.getDeptID()+" Department Name :"+dept.getDeptName());
			
			for(Employees emp:dept.getEmployees())
			{
				System.out.println("Employee ID:"+emp.getEmployeeID()+"  Employee Name:"+emp.getEmployeeName()+" Employee Salary="+emp.getEmployeeSalary());
			}
			System.out.println("------------------***************-----------------------");
		}
	}
	
	public static void main(String[] args) 
	{
		Departments d1=new Departments();
		d1.setDeptID(1);
		
		
		String n="Sangam";
		float sal=67000.0f;
		Departments d4=new Departments();
		d4.setDeptID(3);
		//addDepartments();
		addEmployees(n,sal,d4);
		getDetails();
	}

}
