package day23;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	
	/*get(url)
	getTitle()
	getCurrentURL()
	getPageSource()
	getWindowHandle()
	getwindowHandles()
	*/

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		System.out.println("Title of the page: "+driver.getTitle());
		
		System.out.println("Cureent URL of page :"+driver.getCurrentUrl());
		
		/*
		System.out.println("Page Source......");
		String ps = driver.getPageSource();
		System.out.println(ps);
		System.out.println(ps.contains("html"));
		*/
		
		System.out.println(driver.getWindowHandle());
		
		System.out.println();
		
		
		//a[text()='OrangeHRM, Inc']
		Thread.sleep(4000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowids =driver.getWindowHandles();
		for(String wind: windowids) {
			System.out.println(wind);
		}
		
		driver.quit();
		
	}

}
