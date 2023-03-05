package day36_TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class DependentMethods {

	
	@Test(priority = 0)
	void openApp() {
		Assert.assertTrue(true);
		System.out.println("open App success");
	}
	
	@Test(priority = 1, dependsOnMethods = {"openApp"})
	void login() {
		Assert.assertTrue(false);
	}
	
	@Test(priority = 2,dependsOnMethods = {"login"})
	void search() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3,dependsOnMethods = {"login", "search"})
	void advSearch() {
		
	}
	
	@Test(priority = 4,dependsOnMethods = {"login"})
	void logout() {
		
	}
}
