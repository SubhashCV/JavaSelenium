package day30;

import java.time.Duration;

import javax.crypto.Mac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		Actions act = new Actions(driver);
		
		WebElement desktop= driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		//a[normalize-space()='Mac (1)']
		
		act.moveToElement(desktop).moveToElement(mac).click().perform();
		
		Thread.sleep(5000);
		
		//driver.close();
		

		
	}

}
