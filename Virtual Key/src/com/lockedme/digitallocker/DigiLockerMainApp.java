package com.lockedme.digitallocker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DigiLockerMainApp {
	
	public static void printCompanyInfo(Company company) {
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
	
	public static void printDeveloperInfo() {
		BufferedReader br= null;	
		String strCurrentLine;
		System.out.println("================================This software is Developed by=======================================");
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\vinay\\Desktop\\Phase_one_project\\Virtual Key\\src\\com\\lockedme\\digitallocker\\DeveloperInformation"));
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
		
	}

	public static void main(String[] args) {
		
		Company company= Company.getInstance();
		printCompanyInfo(company);
		printDeveloperInfo();
		
		

	}

}
