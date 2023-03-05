package day36_TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {
	
	@BeforeClass
	void login() {
		System.out.println("Login....");
	}
	
	@Test(priority = 2)
  	void advSearch() {
	  System.out.println("Advanced Search....");
  	}
  
	
	@Test(priority = 1)
  	void search() {
	  System.out.println("Search...");
  	}
  
  	@AfterClass
  	void logout() {
	  System.out.println("Logout...");
  	}
  
}
