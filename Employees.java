package com.edubridge.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employees 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmployeeID;
	private String EmployeeName;
	private float EmployeeSalary;
	@ManyToOne(fetch = FetchType.LAZY)
	private Departments departments;

	public int getEmployeeID() {
		return EmployeeID;
	}



	


	public Employees(String employeeName, float employeeSalary, Departments departments) {
		super();
		EmployeeName = employeeName;
		EmployeeSalary = employeeSalary;
		this.departments = departments;
	}






	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public float getEmployeeSalary() {
		return EmployeeSalary;
	}

	public void setEmployeeSalary(float employeeSalary) {
		EmployeeSalary = employeeSalary;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public Employees() {
		super();
	}

	
	
	
}

