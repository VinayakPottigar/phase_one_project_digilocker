package com.lockedme.digitallocker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DigiLockerMainApp {
		
	
	//This method prints the Company Information
	public void printCompanyInfo(Company company) {
		System.out.println("=================================Company Details====================================================");
		System.out.println("Name of the Company="+ company.getCompanyName());
		System.out.println("Address ="+company.getAddress());
		System.out.println("Establishment Year="+company.getEstablishmentYear());
		System.out.println("Owner="+company.getOwner());
		System.out.println("*****Introduction*****"+"\n"+company.getIntro());
		System.out.println("Assets ="+ company.getAssests()+"cr");
		System.out.println("Web Site="+ company.getWebsiteLink());
		System.out.println("====================================================================================================");
		
	}
	
	//This method prints the Developer information 
	public void printDeveloperInfo() {
		BufferedReader br= null;	
		String strCurrentLine;
		System.out.println("================================This software is Developed by=======================================");
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\vinay\\Desktop\\Phase_one_project\\Virtual Key\\resources\\DeveloperInformation"));
			while ((strCurrentLine = br.readLine()) != null) {
				System.out.println(strCurrentLine);				    
			}
							
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
				
			try {
				if (br != null)
				br.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}		
				
		}
		System.out.println("=====================================================================================================");
		
	}

	// This method prints the Welcome message
	public void welcomeScreen() {
		System.out.println("************************************************************************************************* ");
		System.out.println("                               Welcome to the LockedMe.com");
		System.out.println("*************************************************************************************************");
	}
	
	//This method prints the application name
	public void applicationName() {
		System.out.println("************************************************************************************************* ");
		System.out.println("                               Digital Locker Application");
		System.out.println("************************************************************************************************* ");
		
	}
	
	public void customerMenu(){
		System.out.println("Please enter your Choice");
		System.out.println("1.Sign up as a new Customer");
		System.out.println("2.Login");
		//System.out.println("3.Update the profile");
		//System.out.println("4.Delete an account");	
		
	}
	
	public void authorisedCustomerMenu() {
		System.out.println("Internal Menu");
		//System.out.println("1.Update the profile");
		System.out.println("1.Add a File");
		System.out.println("2.Delete a File");
		System.out.println("3.Search a File");
		System.out.println("4.Display files and Folders");
		System.out.println("5.Delete an account");
	}
	
	/*public void updateMenu() {
		System.out.println("Update Menu");
		System.out.println("Enter your choince");
		System.out.println("1.Update lastname");
		System.out.println("2.Update MobileNumber");
		System.out.println("3.Update emailID");
		System.out.println("4.Update Password");
		
	}*/
	
	public static void main(String[] args) {
		Customer customer=null;
		String firstName=null;
		String middleName=null;
		String lastName=null;
		String dateOfBirth=null;
		String gender=null;
		int mobileNo=0;
		String emailId=null;
		String userName=null;
		String password=null;
		DigiLockerMainApp mainApp = new DigiLockerMainApp();
		CustomerOperations customerOperations= new CustomerOperations();
		String mainMenuChoice=null;
		Scanner sc = new Scanner(System.in);
		
		byte ch;
		
		 
		
		Company company= Company.getInstance();
		mainApp.welcomeScreen();
		mainApp.applicationName();		
		mainApp.printCompanyInfo(company);
		mainApp.printDeveloperInfo();
		
		do {
			System.out.println("-------------Main Menu----------------");
			mainApp.customerMenu();
			System.out.println("Enter Your Choice=");
			ch=sc.nextByte();
			switch(ch) {
				case 1 : 	System.out.println("Enter Your FirstName");
							firstName = sc.nextLine();
							
							System.out.println("Enter Your MiddleName");
							middleName = sc.nextLine();
							
							System.out.println("Enter Your LastName");
							lastName = sc.nextLine();
							
							System.out.println("Enter Your Date of Birth");
							dateOfBirth = sc.nextLine();
							
							System.out.println("Enter Your Gender");
							gender = sc.nextLine();
							
							System.out.println("Enter Your Mobile Number");
							mobileNo = sc.nextInt();
							
							System.out.println("Enter Your Email Id");
							emailId = sc.nextLine();
							
							System.out.println("Enter Your UserName");
							userName = sc.nextLine();
							
							System.out.println("Enter Your Password");
							password = sc.nextLine();
							customer= customerOperations.signup(firstName, middleName, lastName, dateOfBirth, gender, mobileNo, emailId, userName, password);
							
					     
				case 2 : 	System.out.println("Enter Your UserName");
							userName = sc.nextLine();
							
							System.out.println("Enter Your Password");
							password = sc.nextLine();
							customer= customerOperations.login(userName,password);
							if(customer!=null) {
								System.out.println("Login Successful\n"+"Welcome"+ customer.getFirstName() + " " + customer.getLastName());
																
								do {
										mainApp.authorisedCustomerMenu();
										System.out.println("Enter your Choice");
										ch=sc.nextByte();
										switch(ch){
										case 1:
											   break;
											   
										case 2: 
												break;
										case 3:
												break;
										case 4:
												break;
										case 5:// delete an account
												
											   break;
										
										default :
												System.out.println("Please enter a valid choice");
										
									}
									
									System.out.println("Do you want to continue y/n");
									mainMenuChoice=sc.nextLine();
									
								}while(mainMenuChoice.toLowerCase().equals("y"));								
								
							}
							else {
								System.out.println("Please check your Username or Password");
							}
						break;				
						
				default:
						System.out.println("Enter a valid choice");
			
			}
			
			System.out.println("Do you want to continue y/n");
			mainMenuChoice=sc.nextLine();
			
		}while(mainMenuChoice.toLowerCase().equals("y"));
		
		
		
		
		

	}

}
