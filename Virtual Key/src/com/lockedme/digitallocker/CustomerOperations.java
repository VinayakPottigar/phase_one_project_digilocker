package com.lockedme.digitallocker;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class CustomerOperations implements CustomerHandling,FileOperations {
	HashSet<Customer> setOfCustomers=new HashSet<Customer>();
	Scanner sc = new Scanner(System.in);
	TreeSet<String> ts= new TreeSet();
	
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
	
	public void addFile(Customer customer)throws Exception {
		String filename=null;
		String rootdir=null;
		File f=null;
		String finalpath=null;
		String pathwithusername=null;
		System.out.println("Enter the file name to be created");
  		filename=sc.next();
		rootdir="C:\\root"+"\\"+customer.getUserName();
		f= new File(rootdir);
		System.out.println(f.mkdir());
		finalpath=rootdir+"\\";											
		pathwithusername=finalpath.concat(filename);													
		f= new File(pathwithusername);
		if(f.createNewFile()) {
			System.out.println("New file Created successfully");
		}
		customer.setNumberOfFiles(filename);
	}
	
	
	public void deleteFile(String path,String filename) {
		File directoryPath = new File(path);
	    String contents[] = directoryPath.list();
	    path=path+"\\"+filename;
	    directoryPath=new File(path);
	    System.out.println("List of files and directories in the specified directory:");
	    for(int i=0; i<contents.length; i++) {
	    	  if(filename.equals(contents[i])) {
	    		   System.out.println(directoryPath.delete()); ;
	    		  System.out.println(contents[i]+"File deleted successfully");		    		  
	    	  }
	         System.out.println(contents[i]);
	    }
		
	}
	
	public void displayCustomerFiles(Customer customer) {		
		
		ts= customer.getNumberOfFiles();
		System.out.println("Total Number of files of (In Assemding Order) "+ customer.getFirstName()+ " "+ customer.getLastName()+"are="+ts.size());
		int i=0;
		for (var value : ts) {
			System.out.println(i+")"+value);
		}
          
		
	}
	
	public void searchFile(Customer customer, String fileName) {
		ts= customer.getNumberOfFiles();
		if(ts.contains(fileName)) {
			System.out.println(fileName+" is available");
		}
		else {
			System.out.println(fileName+" is not available");
		}
		
		
	}
	
	
	/*public void displayCustomerFiles(String path) {
		File directoryPath = new File(path);
	    //List of all files and directories
	    String contents[] = directoryPath.list();
	    System.out.println("List of files and directories in the specified directory:");
	    for(int i=0; i<contents.length; i++) {
	         System.out.println(contents[i]);
	    }
		
	}*/



	

	

}
