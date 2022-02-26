package com.lockedme.digitallocker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		System.out.println("3.Exit");
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
		System.out.println("5.My Profile");
		System.out.println("6.exit");
	}
	
	public void createRootDir() {
			  String dir ="C:\\Root";
		      File directory = new File(dir);
		      directory.mkdir();
	}
	
	
	public boolean isValidMobileNumber(long s)
	{
		String number=Long.toString(s);
        // The given argument to compile() method
        // is regular expression. With the help of
        // regular expression we can validate mobile
        // number.
        // The number should be of 10 digits.
 
        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d{10}$");
 
        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression for which
        // object of Matcher class is created
        Matcher m = p.matcher(number);
 
        // Returning boolean value
        return (m.matches());
    }
	
	
	public  boolean isValidMailID(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
	
	public boolean nameValidation( String firstName ) {
	      return firstName.matches( "[A-Z][a-z]*" );
	   }
	
	public boolean userNameValidation(String userName) {
		return userName.matches("^[A-Za-z]\\w{5,29}$");
	}
	
			
	public static void main(String[] args) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setLenient(false);
		String repeatpassword=null;
		String ch1=null;
		//File f;
		byte flag=0;
		byte flag1=0;
		byte i=0;
		boolean underage=false;
		boolean validationResult=false;
		String filename=null;
		//String finalpath=null;
		//String completePath=null;
		//String pathwithusername=null;
		String rootdir=null;
		//String path=null;
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
			
			try {
					System.out.println("Enter Your Choice=");
					ch=sc.nextByte();
					switch(ch) {
						case 1 : 	
									do {
											System.out.println("\nEnter Your FirstName=");
											firstName = sc.next();
											validationResult=mainApp.nameValidation(firstName);
											if(!validationResult) {
												System.out.println("Please enter valid name with Firt Letter Capital");
											}
									}while(validationResult==false);
										
									do {
										
										System.out.println("Enter Your MiddleName=");
										middleName = sc.next();
										validationResult=mainApp.nameValidation(middleName);
										if(!validationResult) {
											System.out.println("Please enter valid name with Firt Letter Capital");
										}										
										
									}while(validationResult==false);
									
									do {
																	
										System.out.println("Enter Your LastName=");
										lastName = sc.next();
										validationResult=mainApp.nameValidation(lastName);
										if(!validationResult) {
											System.out.println("Please enter valid name with Firt Letter Capital");
										}
										
										
									}while(validationResult==false);
										
									
									
									do {
									
											try {
												ch=9;
												System.out.println("Enter Your Date of Birth in this format only \"dd/MM/yyyy\"=");
												dateOfBirth = sc.next();
												Date date= formatter.parse(dateOfBirth);
												
												//Converting obtained Date object to LocalDate object
											    Instant instant = date.toInstant();
											    ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
											    LocalDate givenDate = zone.toLocalDate();
											    //Calculating the difference between given date to current date.
											    Period period = Period.between(givenDate, LocalDate.now());
											   // System.out.print("Hello "+name+" your current age is: ");
											    if(period.getYears()<18) {
											    	underage=true;
											    	throw new UnderAgeException("Your age is bellow 18. You are not elligible to open an account");
											    	
											    }
											}catch (ParseException e) {
											    System.out.println("Enter the date in the specified Format");
											    ch=0;
											}
											catch(UnderAgeException e) {
												System.out.println(e);
											}
									}while(ch==0);
										
									
									if(!underage)
									{
										
										do {
												i=0;
												System.out.println("Select Your Gender=");
												System.out.println("1. Male");
												System.out.println("2. Female");
												System.out.println("3. other");
												
												try {
														System.out.println("Enter your choice=");
														ch = sc.nextByte();
														switch(ch){
															case 1: gender="Male";
																	break;
															case 2: gender="Female";
																	break;
															case 3: gender="Other";
																	break;
															default: i=1;
																	System.out.println("Enter a valid choice=");
														}	
												}
												catch(Exception e) {
													i=1;
													System.out.println("Enter only digit between given specified range");
													ch1=sc.next();
												}
																			
										}while(i==1);
										
										
										
										do {
												i=0;	
												System.out.println("Enter Your Mobile Number=");
												mobileNo =sc.nextLong();
												if(!mainApp.isValidMobileNumber(mobileNo)) {
														i=1;
														System.out.println("Enter a valide mobile number");
												}
												
											
										}while(i==1);
										
										do {
											 i=0;
											System.out.println("Enter Your Email Id=");
											emailId = sc.next();
											if(!mainApp.isValidMailID(emailId)) {
												i=1;
												System.out.println("Please enter a valid mail ID");
											}
											
										}while(i==1);
										
										
										
										
										do {
												i=1;
												
												do {
													System.out.println("User Name Selection Rules");
													System.out.println("1.The username consists of 6 to 30 characters inclusive. If the username\r\n"
															+ "consists of less than 6 or greater than 30 characters, then it is an invalid username.");
													System.out.println("2.The username can only contain alphanumeric characters and underscores (_).");
													System.out.println("3. Alphanumeric characters describe the character set consisting of lowercase characters [a – z]");
													System.out.println("uppercase characters [A – Z], and digits [0 – 9].");
													System.out.println("4. The first character of the username must be an alphabetic character, i.e., either lowercase character");
													System.out.print(" [a – z] or uppercase character [A – Z].\n");
													System.out.println("Enter Your UserName=");
													userName = sc.next();
													validationResult= mainApp.userNameValidation(userName);
													if(!validationResult) {
														System.out.println("Please enter the valid userName");
													}
													
												}while(validationResult==false);
												
												
												System.out.println("Enter Your Password=");
												password = sc.next();
												
												System.out.println("Reenter Your Password=");
												repeatpassword = sc.next();
												if(password.equals(repeatpassword)) {
													System.out.println("Please Recheck your password");
													i=0;
												}
										}while(i==1);
										
										
										
										customer= customerOperations.signup(firstName, middleName, lastName, dateOfBirth, gender, mobileNo, emailId, userName, password);
										flag1=1;
									}
									
							     
						case 2 : 	if(!underage)
									{
							
										flag1=1;
										System.out.println("\n*****You can Login to the System with the username and Password*****");
										System.out.println("Enter Your UserName=");
										userName = sc.next();
										
										System.out.println("Enter Your Password");
										password = sc.next();
										customer= customerOperations.login(userName,password);
										flag=0;
										
										
										do { 
												
											try {
												if(customer!=null) {
													System.out.println("\nLogin Successful\n"+"Welcome "+ customer.getFirstName() + " " + customer.getLastName());
																								
													mainApp.authorisedCustomerMenu();
													System.out.println("Enter your Choice( 1 to 6)");
													ch=sc.nextByte();
																
													switch(ch){
														case 1:	
																try {
																		customerOperations.addFile(customer);																	
																}
																catch(Exception e) {
																		System.out.println("Exception"+e);
																}															
																break;
																			   
														case 2: rootdir="C:\\root"+"\\"+customer.getUserName();
																System.out.println("Enter the file name to be deleted=");
																filename=sc.next();
																customerOperations.deleteFile(rootdir, filename);									  				
																  				
																break;
																		
														case 3:	System.out.println("Enter the file name to be Searched=");
														  		filename=sc.next();
																customerOperations.searchFile(customer,filename);
																break;
																		
														case 4: 																			
																customerOperations.displayCustomerFiles(customer);
																break;
																		
														case 5:
																customerOperations.seeProfile(customer);
																break;
																		
														case 6 : 
																System.out.println("Please enter a valid choice");
																
														default :
																System.out.println("Please enter a valid choice");
																
													}
															
																							
														
												}
												else {
													System.out.println("Please check your Username or Password");
													flag=1;
												}
													
												System.out.println("Do you want to continue y/n=");
												mainMenuChoice=sc.next();
											
											}catch(Exception e) {
												System.out.println("Enter only digit between given specified range");
												System.out.println("Enter only digit between given specified range");
												mainMenuChoice="y";
												flag=0;
												mainMenuChoice=sc.next();
											}
										
										}while(mainMenuChoice.toLowerCase().equals("y")&& flag==0);
									}//underage checking if condition ends here
										break;
										
						case 3 :flag=1;
								mainMenuChoice="y";
								break;
								
						default:
								System.out.println("Enter a valid choice");
					 
					}
					
					
			}
			catch(Exception e) {
				System.out.println("Enter only digit between given specified range");
				mainMenuChoice="y";
				flag=0;
				mainMenuChoice=sc.next();
				
			}
					
					if(flag==0) {
						customer=null;
						System.out.println("Would you like to goTo main Menu ,Do you want to continue y/n=");
						mainMenuChoice=sc.next();
						
					}
			
			
			
		}while(mainMenuChoice.toLowerCase().equals("y")&& flag==0);
		
		if(flag1==1) {
			System.out.println("You have been successfully logged out, please revisit, bye");
		}
		else {
			System.out.println("Please revisit, bye");
		}
		
		sc.close();		
		

	}// End of Main method

}
