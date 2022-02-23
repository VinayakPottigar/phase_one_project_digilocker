package com.lockedme.digitallocker;

import java.util.HashSet;

public class CustomerOperations implements CustomerHandling {
	HashSet<Customer> setOfCustomers=new HashSet<Customer>();
	
	public void insertCustomer(Customer customer) {
		setOfCustomers.add(customer);
	}

	@Override
	public Customer login(String username, String password) {
		Customer cust=null;
		
		for(var obj : setOfCustomers) {
					
					if(obj.getUserName().equals(username) && obj.getPassword().equals(password)) {
						return obj;
					}
				}
				return cust;
		
		
	}
	
	@Override
	public Customer signup(String firstName,String middleName,String lastName,String dateOfBirth,String gender,
							int mobileNo,String emailId,String userName,String password) {
		
		Customer newCustomer= new Customer(firstName,middleName,lastName,dateOfBirth,gender,
			 mobileNo,emailId,userName,password);
		insertCustomer(newCustomer);
		return newCustomer;		
	}

	

	@Override
	public void deleteAccount(String username) {
		
		//Customer cust=null;
				
		for(var obj : setOfCustomers) {
							
			if(obj.getUserName().equals(username)) {
				setOfCustomers.remove(obj);				
			}
		}
						
		
		
	}

	@Override
	public void updateAccountProfile(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}



	

	

}
