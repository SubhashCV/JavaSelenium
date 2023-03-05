package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js=driver;

		/*
		// 1) scroll down the page by pixel
		js.executeScript("window.scrollBy(0,3000)", "");
		System.out.println(js.executeScript("return window.pageYOffset;")); //3000
		*/
		
		/*
		//2) scroll down the page till the element is present
		WebElement flag=driver.findElement(By.xpath("//img[@alt='Flag of India']"));
				
		js.executeScript("arguments[0].scrollIntoView();", flag);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		*/
		
		// 3) scroll till end of the page/ documnet
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		
		Thread.sleep(3000);
		

		// go back to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
	}

}
