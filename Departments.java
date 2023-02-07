package com.edubridge.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Departments")
public class Departments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int DeptID;
	@Column
	private String DeptName;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "departments" ,fetch = FetchType.LAZY)
	List<Employees> employees;

	public int getDeptID() {
		return DeptID;
	}

	public void setDeptID(int deptID) {
		DeptID = deptID;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public Departments() {
		super();
	}

	public Departments(int deptID) {
		super();
		DeptID = deptID;
	}


	}
	
	
	


