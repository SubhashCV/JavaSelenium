package day27;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v107.dom.DOM.GetFrameOwnerResponse;

public class Assn_SwitchingWindow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		String parentWindowTitle = driver.getTitle();
		
		System.out.println("Parent window title : "+parentWindowTitle);
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input'][@type='text']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
		
		List<WebElement> links =driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));
		System.out.println("Total number of links are : "+links.size());
		
		for(WebElement link: links) {
			String text= link.getText();
			System.out.println(text);
			link.click();
		}
		
		// Capture Window IDs
		Set<String> windowIDs =driver.getWindowHandles();
		
		for(String winID :windowIDs) {
			String titl =driver.switchTo().window(winID).getTitle();
			System.out.println(titl);
		}
		
		
		
		/*
		
		//using normal for loop
//		for(int i=0;i<links.size();i++) {
//		   links.get(i).click();
//		}
		
		System.out.println();
		for(WebElement link : links) {
			System.out.println(link.getText());
			link.click();
		}
	
		//capture id's of browser windows
		Set<String> windowIDs =driver.getWindowHandles();
		
		System.out.println();
		System.out.println("Switching to each browser window and getting the titles........"); 
		for(String winid :windowIDs) {
		 String winTitle=	driver.switchTo().window(winid).getTitle();
		 System.out.println("Title of Webpage: "+winTitle);
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
