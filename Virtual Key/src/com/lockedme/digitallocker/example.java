package com.lockedme.digitallocker;

import java.io.File;

public class example {
	public static void main(String args[]) {
		try {
				String dir ="C:\\sampledirectory";
		      File directory = new File(dir);
		      System.out.println(directory.mkdir());
			} catch(Exception e) {
			   e.printStackTrace();
			}
	}

}
