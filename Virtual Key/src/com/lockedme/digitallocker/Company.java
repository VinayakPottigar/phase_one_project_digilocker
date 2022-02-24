package com.lockedme.digitallocker;

public class Company {
	private String companyName;
	private String address;
	private String establishmentYear;
	private String owner;
	private String intro;
	private long assests;
	private String websiteLink;
	//private long numberOfCustomers;
	
	private static Company company;

	private Company(String companyName, String address, String establishmentYear, String owner, String intro,
			long assests, String websiteLink) {
		this.companyName = companyName;
		this.address = address;
		this.establishmentYear = establishmentYear;
		this.owner = owner;
		this.intro = intro;
		this.assests = assests;
		this.websiteLink = websiteLink;
	}
	
	public static Company getInstance() {
		if(company==null) {
			company= new Company("Lockers Pvt. Ltd.","Plot No. 1, Rajiv Gandhi Infotech Park, Hinjewadi, Pune - 411057","1980","Mr. Pottigar Vinayak V.","Provides Cloud based services to keep the digital documents accessible anywhere",(long) 1500.00d,"www.LockedMe.com");
			
		}
		return company;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEstablishmentYear() {
		return establishmentYear;
	}

	public void setEstablishmentYear(String establishmentYear) {
		this.establishmentYear = establishmentYear;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public long getAssests() {
		return assests;
	}

	public void setAssests(long assests) {
		this.assests = assests;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public static Company getCompany() {
		return company;
	}

	public static void setCompany(Company company) {
		Company.company = company;
	}
	
	
}
