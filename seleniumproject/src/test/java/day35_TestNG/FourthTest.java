package day35_TestNG;

import org.testng.annotations.Test;

public class FourthTest {
	  @Test(priority = 1)
	  public void openApp() {
		  System.out.println("test1 pass");
	  }
	  
	  @Test(priority = 2)
	  public void login() {
		  System.out.println("test2 pass");
	  }
	  
	  @Test(priority = 3)
	  public void logout() {
		  System.out.println("test3 pass");
	  }
}
