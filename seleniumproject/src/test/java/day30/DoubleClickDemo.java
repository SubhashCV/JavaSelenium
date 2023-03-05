package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleClickDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		driver.switchTo().frame("iframeResult");
		WebElement f1= driver.findElement(By.xpath("//input[@id='field1']"));
		f1.clear(); //clearing the text from Field 1
		f1.sendKeys("Welcome");
		System.out.println("f1 value: "+f1.getAttribute("value"));
		
		WebElement f2= driver.findElement(By.id("field2"));
		
		WebElement btn= driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		act.doubleClick(btn).build().perform();
		
		//validation
		
		//String copiedText=f2.getText();  //here getText doesnt work
		String copiedText = f2.getAttribute("value");
		
		System.out.println("Copied Text is : "+ copiedText);
		
		//Approach 1
		/*
		if (copiedText.equals(f1.getAttribute("value"))) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		*/
		
		//Approach 2
		
		if (copiedText.equals("Welcome")) {
			System.out.println("test passed");
		}else {
			System.out.println("Test Failed");
		}
		
		
		
		Thread.sleep(10000);
		
		
		driver.quit();

	}

}
