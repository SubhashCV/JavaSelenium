package day26;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assn_alertPOPup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		//input[@name='proceed'][@title='Sign in']
		driver.findElement(By.xpath("//input[@name='proceed'][@title='Sign in']")).click();
		
		Thread.sleep(5000);
		Alert al =  driver.switchTo().alert();
		
		String text = al.getText();
		System.out.println(text);
		
		al.accept();
		
		if (text.contains("Please enter a")) {
			System.out.println("Test passed");
		}else {
			System.out.println("test failed");
		}
		
		driver.quit();
		
	}

}
