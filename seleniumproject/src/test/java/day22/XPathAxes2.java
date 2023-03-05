package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxes2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		/*
//		Locating elements with Visible text in input elements
		//Syntax :
		//tagName[@value=’visibleText’]
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		String user_value= driver.findElement(By.xpath("//input[@placeholder='Username']")).getText();
		System.out.println(user_value);
		*/
		
		
		/*
		 //Locating Elements with Multiple Attributes
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@type='submit'][@name='action_submitForm'][@value='Try it for Free'][@id='Form_getForm_action_submitForm']")).click();  // Approach - 1
		driver.findElement(By.xpath("//*[@type='submit'][@name='action_submitForm']"));
		*/
		
		
		/*
//		Locating Elements with Dynamic Attribute values
		
		driver.get("https://demo.opencart.com/index.php?route=product/product&language=en-gb&product_id=42");
		driver.manage().window().maximize();
		Thread.sleep(5000);
//		String txt2 = driver.findElement(By.xpath("//a[contains(@href,'#tab-specification')]")).getText();
//		String txt2 = driver.findElement(By.xpath("//*[contains(@href,'specific')]")).getText();
		
	String txt2 = driver.findElement(By.xpath("//a[starts-with(@href,'#tab-sp')])")).getText();  // getting error
		System.out.println(txt2);
		*/
		
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
