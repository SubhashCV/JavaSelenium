package day28;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assn_OrangehrmTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		int rows = driver.findElements(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div")).size();
		
		for(int r=1;r<=rows;r++) {
			String fname=driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div["+r+"]//div[@role='row']/div[3]/div")).getText();
			String lname=driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div["+r+"]//div[@role='row']/div[4]/div")).getText();
			
			System.out.println(fname+"\t "+lname);
		}
		
		
		/*
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click(); //PIM
		
		int totalrows=driver.findElements(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div")).size();
		
		for(int row=1;row<=totalrows;row++)
		{
			String firstname=driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div["+row+"]//div[@role='row']/div[3]/div")).getText();
			String lastname=driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div["+row+"]//div[@role='row']/div[4]/div")).getText();
			
			System.out.println(firstname+"\t"+lastname);
		}
		*/
		
		
	}

}
