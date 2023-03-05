package day18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsDemo1 {

	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver.setup();
		WebDriver driver = new FirefoxDriver();
		
		/*
		// open app
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		driver.manage().window().maximize();
		
		Thread.sleep(8000);
		
		// Finding number of tabs in home screen
		List<WebElement> tabs =driver.findElements(By.className("menu-item"));
		System.out.println("Number of main tabs are " + tabs.size());
		
		driver.quit();
		*/
		/*------------------------------------------------*/
		driver.get("http://the-internet.herokuapp.com/"); 
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		List<WebElement> text_links =  driver.findElements(By.tagName("a"));
		System.out.println("Number of Text links are " + text_links.size());
		
		// link text or partial link text
		driver.findElement(By.linkText("JQuery UI Menus")).click();
//		driver.findElement(By.partialLinkText("JQuery")).click();
		Thread.sleep(5000);
		  
		driver.quit();	
	}
}