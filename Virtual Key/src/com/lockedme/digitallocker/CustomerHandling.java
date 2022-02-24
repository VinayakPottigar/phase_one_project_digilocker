package com.lockedme.digitallocker;

public interface CustomerHandling {
	Customer login(String username,String password);
	void logout();
	Customer signup(String firstName, String middleName, String lastName, String dateOfBirth, String gender,
			long mobileNo, String emailId, String userName, String password);
	void deleteAccount(String username);
	void updateAccountProfile(Customer customer);
	void seeProfile(Customer customer);
	
}
