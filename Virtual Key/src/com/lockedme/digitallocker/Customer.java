package com.lockedme.digitallocker;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private int mobileNo;
	private String emailId;
	private String userName;
	private String password;
	private static int totalNumberOfCustomers;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String middleName, String lastName, String dateOfBirth, String gender,
			int mobileNo, String emailId, String userName, String password) {
		totalNumberOfCustomers++;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getTotalNumberOfCustomers() {
		return totalNumberOfCustomers;
	}

	public static void setTotalNumberOfCustomers(int totalNumberOfCustomers) {
		Customer.totalNumberOfCustomers = totalNumberOfCustomers;
	}

	
	
	
	
	
	

}
