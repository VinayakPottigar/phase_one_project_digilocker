package com.lockedme.digitallocker;

public interface FileOperations {
	public void addFile(Customer customer)throws Exception;
	public void deleteFile(String path,String filename);
	public void displayCustomerFiles(Customer customer);
	public void searchFile(Customer customer, String fileName);

}
