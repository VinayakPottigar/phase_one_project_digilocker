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
							long mobileNo,String emailId,String userName,String password) {
		
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

	@Override
	public void seeProfile(Customer customer) {
		System.out.println("#########################################################################");
		System.out.println(customer.getFirstName()+" "+customer.getLastName()+"'s"+"   profile");
		System.out.println("#########################################################################");
		System.out.println("First Name= "+customer.getFirstName());
		System.out.println("Middle Name= "+customer.getMiddleName());
		System.out.println("Last Name= "+customer.getLastName());
		System.out.println("Date of Birth= " +customer.getDateOfBirth());
		System.out.println("Email ID= "+ customer.getEmailId());
		System.out.println("Gender= "+ customer.getGender());
		System.out.println("Mobile number= "+customer.getMobileNo());	
		
	}



	

	

}
