package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		/*
		// to capture the text of the element by relative xpath using text() method.
		String productname = driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
		System.out.println(productname);
		*/
		
		// to capture the text of the element by relative xpath using text() method.
		String productname = driver.findElement(By.xpath("//a[normalize-space()='Mac Book']")).getText();
		System.out.println(productname);
		
		/*
		String prod = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")).getText();
		System.out.println(prod );
		*/
		
		
		
		
		
		
		driver.quit();
		
		

	}

}
