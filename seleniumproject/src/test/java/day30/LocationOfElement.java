package day30;


import java.awt.event.WindowListener;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.netty.handler.codec.spdy.SpdySettingsFrame;

public class LocationOfElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		//img[@alt='company-branding']
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		System.out.println("Before maximizing window: "+logo.getLocation());
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		System.out.println("After maximizing window : "+logo.getLocation());
		Thread.sleep(5000);
		
		driver.manage().window().minimize();
		System.out.println("After minimizing window : "+logo.getLocation());
		Thread.sleep(5000);
		
		driver.manage().window().fullscreen();
		System.out.println("After Full Screen Window : "+logo.getLocation());
		Thread.sleep(5000);
		
		Point p = new Point(100,100);
		driver.manage().window().setPosition(p);
		System.out.println("After Setting Window to 100*100 "+logo.getLocation());
		Thread.sleep(5000);
		
		Point q = new Point(50, 50);
		driver.manage().window().setPosition(q);
		System.out.println("After setting window to 50*50 "+logo.getLocation());
		Thread.sleep(5000);
		

	}

}
