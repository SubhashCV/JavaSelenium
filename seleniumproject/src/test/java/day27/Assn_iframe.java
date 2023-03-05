package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assn_iframe {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.xpath("//body[@id='tinymce']//p")).clear();
		driver.findElement(By.xpath("//body[@id='tinymce']//p")).sendKeys("hello");
		
		Thread.sleep(6000);
		
		driver.close();
		
		
		//iframe[@id='mce_0_ifr']
	}

}
