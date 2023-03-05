package day26;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		WebElement text= driver.findElement(By.xpath("//input[@name='q'][@type='text']"));
		text.sendKeys("Selenium");
		
		Thread.sleep(4000);
		
	    List<WebElement> li =driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		System.out.println("Number of suggestions: "+li.size());
		
		for(int i=0;i<li.size(); i++) {
			String liText  = li.get(i).getText();
			if (liText.equals("selenium tutorial")) {
				li.get(i).click();
				break;
			}
		}
		
		Thread.sleep(10000);
		driver.quit();

	}

}
