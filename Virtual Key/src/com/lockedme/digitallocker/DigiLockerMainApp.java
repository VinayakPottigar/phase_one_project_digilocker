package com.lockedme.digitallocker;

import java.io.BufferedReader;
import java.io.File;
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
		System.out.println("6.My Profile");
	}
	
	public void createRootDir() {
			  String dir ="C:\\Root";
		      File directory = new File(dir);
		      System.out.println(directory.mkdir());
	}
	
	public void display(String path) {
		File directoryPath = new File(path);
	      //List of all files and directories
	      String contents[] = directoryPath.list();
	      System.out.println("List of files and directories in the specified directory:");
	      for(int i=0; i<contents.length; i++) {
	         System.out.println(contents[i]);
	      }
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
		
		File f;
		String filename=null;
		String finalpath=null;
		String completePath=null;
		String pathwithusername=null;
		String rootdir=null;
		String path=null;
		Customer customer=null;
		String firstName=null;
		String middleName=null;
		String lastName=null;
		String dateOfBirth=null;
		String gender=null;
		//String skip=null;
		long mobileNo=0;
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
		mainApp.createRootDir();
		
		do {
			System.out.println("-------------Main Menu----------------");
			mainApp.customerMenu();
			System.out.println("Enter Your Choice=");
			ch=sc.nextByte();
			switch(ch) {
				case 1 : 	
							
							System.out.println("\nEnter Your FirstName");
							firstName = sc.next();
							
							System.out.println("Enter Your MiddleName");
							middleName = sc.next();
							
							System.out.println("Enter Your LastName");
							lastName = sc.next();
							
							System.out.println("Enter Your Date of Birth");
							dateOfBirth = sc.next();
							
							System.out.println("Enter Your Gender");
							gender = sc.next();
							
							
							System.out.println("Enter Your Mobile Number");
							mobileNo =sc.nextLong();
							
							System.out.println("Enter Your Email Id");
							emailId = sc.next();
							
							System.out.println("Enter Your UserName");
							userName = sc.next();
							
							System.out.println("Enter Your Password");
							password = sc.next();
							customer= customerOperations.signup(firstName, middleName, lastName, dateOfBirth, gender, mobileNo, emailId, userName, password);
							
					     
				case 2 : 	
							System.out.println("\nYou can Login to the System with the username and Password");
							System.out.println("Enter Your UserName");
							userName = sc.next();
							
							System.out.println("Enter Your Password");
							password = sc.next();
							customer= customerOperations.login(userName,password);
							
							do {
									if(customer!=null) {
										System.out.println("\nLogin Successful\n"+"Welcome"+ customer.getFirstName() + " " + customer.getLastName());
																		
										
												mainApp.authorisedCustomerMenu();
												System.out.println("Enter your Choice( 1 to 6)");
												ch=sc.nextByte();
												
												switch(ch){
														case 1:	
																try {
																	System.out.println("Enter the file name to be created");
															  		filename=sc.next();
																	rootdir="C:\\root"+"\\"+customer.getUserName();
																	f= new File(rootdir);
																	System.out.println(f.mkdir());
																	finalpath=rootdir+"\\";
																	
																	//pathwithusername=rootdir.concat(customer.getUserName())+"\\";
																	//System.out.println(finalpath);
																	pathwithusername=finalpath.concat(filename);
																	//completePath= rootdir.concat(pathwithusername);
																	
																	f= new File(pathwithusername);
																	if(f.createNewFile()) {
																		System.out.println("New file Created successfully");
																	}
																}
																catch(Exception e) {
																		System.out.println("Exception"+e);
																}			
																
																
																break;
															   
														case 2: 
																break;
														case 3:
																break;
														case 4: 
															mainApp.display(rootdir);
																break;
														case 5:// delete an account
																
															   break;
														case 6:
																customerOperations.seeProfile(customer);
																break;
														
														default :
																System.out.println("Please enter a valid choice");
												
											}
											
																			
										
									}
									else {
										System.out.println("Please check your Username or Password");
									}
									
									System.out.println("Do you want to continue y/n");
									mainMenuChoice=sc.next();
							
								}while(mainMenuChoice.toLowerCase().equals("y"));
								break;				
						
				default:
						System.out.println("Enter a valid choice");
			
			}
			
			customer=null;
			System.out.println("Would you like to goTo main Menu ,Do you want to continue y/n");
			mainMenuChoice=sc.next();
			
		}while(mainMenuChoice.toLowerCase().equals("y"));
		sc.close();
		
		
		
		
		

	}// End of Main method

}
