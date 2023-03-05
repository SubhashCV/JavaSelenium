package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Text;

public class Example_XPathAxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://demo.opencart.com/index.php?route=product/product&path=57&product_id=49");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		
		/*Getting the Text of an element using relative xpath
//		String text1 = driver.findElement(By.xpath("//label[@class='form-label']")).getText();  // Approach 1
		
		String text1 = driver.findElement(By.xpath("//*[@class='form-label']")).getText();  // Approach 2
		System.out.println(text1);
		
		*/
		
		
		/*
		driver.findElement(By.xpath("//a[text()='Cameras']")).click();	
		Thread.sleep(5000);
		*/
		
		/*
		WebElement ele2 =  driver.findElement(By.xpath("//a[text()='Samsung Galaxy Tab 10.1']"));
		System.out.println(ele2);
		ele2.click();
		*/
		
		
		/*
//		Locating Elements with static Visible Text (exact match)
//      Syntax:		//tagName[text()=’exact text’] or //*[text()=’exact text’]
		
		driver.findElement(By.xpath("//a[text()='Cameras']")).click();  //inner text is case sensitive
		Thread.sleep(5000);
		*/
		
		/*
		//Locating Elements when part of the visible text is static(partial match)
		//Syntax: 
			//tagName[contains(text(),’substring’)] 
			//tagName[contains(.,’substring’)] 
			//*[contains(text(),’substring’)]
		
		driver.findElement(By.xpath("//a[contains(text(),'Phones & PDAs')]")).click();  //Approach - 1
//		driver.findElement(By.xpath("//a[contains(text(),'PDAs')]")).click();   //Approach - 2
//		driver.findElement(By.xpath("//*[contains(text(),'PDAs')]")).click()l //Approach - 3
        */
		
		/*
		//Locating Elements when prefix of the inner text is static
		
		//Syntax : //tagName[starts-with(text(),’Prefix of Inner Text’)] 
		//*[starts-with(text(),’Prefix of Inner Text’’)]
		
		//driver.findElement(By.xpath("//a[starts-with(text(),'MP3')]")).click();  //Approach - 1
		driver.findElement(By.xpath("//*[starts-with(text(),'MP3')]")).click(); //Approach - 2
		*/
		
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();

	}

}
