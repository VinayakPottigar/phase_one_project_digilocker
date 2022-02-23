package com.lockedme.digitallocker;

public class DigiLockerMainApp {

	public static void main(String[] args) {
		Company company= Company.getInstance();
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

}
