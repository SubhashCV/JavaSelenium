package day29;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithHiddenOptions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		  
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
		
		//Dropwdown
		
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]")).click();// opens the dropdown
		
		List<WebElement> options= driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		System.out.println(options.size());
		
		for(WebElement option :options) {
			System.out.println(option.getText());
		}
		
		//HR Manager
		for(WebElement option: options) {
			if (option.getText().equals("HR Manager")) {
				option.click();
				break;
				
			}
		}
		
		Thread.sleep(5000);

	}

}
