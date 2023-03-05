package day27;

import java.awt.event.WindowListener;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		System.out.println("switched to child window");
		
		Thread.sleep(4000);
		
		//capture id's of browser windows
		Set<String> windowIDs =driver.getWindowHandles();
		
		//Approach1 - using List collection
		/*
		List <String> windowist = new ArrayList(windowIDs);   //converted Set --> List
		
		String parentWindow = windowist.get(0);
		String childWindow = windowist.get(1);
		
		//switch to parent window
		driver.switchTo().window(parentWindow);
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
				System.out.println("parent");
				
				Thread.sleep(6000);
		
		//switch to child window
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		System.out.println("switched to child window");
		
		Thread.sleep(6000);
		*/
		
		for(String winid :windowIDs) {
			String title = driver.switchTo().window(winid).getTitle();
			
			if (title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
			{
				driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
				System.out.println("clicked elements");
			}
		}
		
		
		//OrangeHRM
		
//		for(String windid :windowIDs)
//		{
//			String text=  driver.switchTo().window(windid).getTitle();
//			System.out.println("hello");
//			
//			Thread.sleep(8000);
//			if (text.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
//			{
//				System.out.println("eneterd in to close");
//				driver.close();
//			}
//		}
		
		for(String winid:windowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
			
			if( title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
			{
				driver.quit(); /// not working pls check 
			}
		}
		
		
		
		
		
		
	}

}
