package day17;

import org.openqa.selenium.By;

/*1) Launch browser
2) open url
	https://opensource-demo.orangehrmlive.com/
3) Provide username  - Admin
4) Provide password  - admin123
5) Click on Login button 
6) Verify the title of dashboard page   
	Exp title : OrangeHRM
7) close browser*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\z_work\\chromedriver_win32\\chromedriver.exe");
		
//		WebDriverManager.chromedriver().setup(); // from 4.6.0 the current line also not needed 

		// 1)Launch Browser
		//ChromeDriver driver = new ChromeDriver(); // approach - 1 -->> here the variable driver is able to create only chrome driver class object 
		WebDriver driver = new ChromeDriver();   // approach - 2 --> here creating driver with WebDriver, here we can create object for any class like edge, firefox, etc..
		
		driver.manage().window().maximize(); // chaining of method size (maximizes the window )
		// 2)open url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);
		
//		3) Provide username  - Admin
//		WebElement txtUsername = driver.findElement(By.name("username")); // whatever the value is returning, we should mention its return type, here it is returning webelement the varialble should be webelement type
//		txtUsername.sendKeys("Admin");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		
		
		
		//4) Provide password  - admin123
		driver.findElement(By.name("password")).sendKeys("admin12");
		
		//5) Click on Login button 
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		
//		6) Verify the title of dashboard page   
//		Exp title : OrangeHRM
		
		/*
		String act_title =  driver.getTitle();
		String exp_title =  "OrangeHRM";
//		String exp_title = "orange";   ---> checking with wrong data
		
		if (act_title.equals(exp_title)) {
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("failed");
		}
		*/
		
		Thread.sleep(10000);
		// Label Validation After Success Login
//		String actual_label = null; // whenever we create a variable atleast we should specify a null value
		String actual_label = "";
		try 
		{
			actual_label =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		}
		catch (Exception e) {
			
//			actual_label = "";
		}
		String exp_label = "Dashboard";
		if (actual_label.equals(exp_label)) {
			System.out.println("test passed");
		}
		else {
			System.out.println("test failed");
		}
		
//		7) close browser
//		driver.close();   --> getting exception 
		driver.quit();
		
		//** Everything in the page is a WebElement
		
		//** On the nulls we cannot apply string methods (like length(), equals(), getText())
		
		
		
	}

}
