package com.edubridge.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;

@NamedNativeQueries
(
		{
		@NamedNativeQuery(name="getudetails",query="call getUserDetails",resultClass = UserDetails.class),
		@NamedNativeQuery(name="getdetailsbyid",query="call getUserDetailsByID(:uid)",resultClass=UserDetails.class)
		}
)
@Entity
@Table(name="UserDetails")
public class UserDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userID;
	@Column
	String userName;
	String Address;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
}

/*
 Tables - Entity
 Columns - Attributes
 */
