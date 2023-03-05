package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		Thread.sleep(5000);
		
		/*
		// Locating Elements when part of the visible text is static(Partial match)
		
		//Approach-1
		//String lap1 = driver.findElement(By.xpath("//p[contains(text(), 'Intel')]")).getText();
		//System.out.println(lap1);
		
		//Approach - 2
//		String lap1 = driver.findElement(By.xpath("//p[contains(., 'Powered by')]")).getText();
//		System.out.println(lap1);
		
		//Approach - 3
//		String lap1 = driver.findElement(By.xpath("//*[contains(text(),'Powered by')]")).getText();
//		System.out.println(lap1);
 */
				
		driver.quit();
		
	}
}
