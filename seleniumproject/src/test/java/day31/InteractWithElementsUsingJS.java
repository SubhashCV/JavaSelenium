package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithElementsUsingJS {

	public static void main(String[] args) throws InterruptedException {
		/*
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		*/
		ChromeDriver driver=new ChromeDriver();
		JavascriptExecutor js=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		
		Thread.sleep(10000);
		/*
		//fname
		WebElement inputbox=driver.findElement(By.xpath("//input[@name='RESULT_TextField-1']"));
		js.executeScript("arguments[0].setAttribute('value','john')", inputbox);
		*/
		
		/*
		// Radio Button
		WebElement male_Rd=driver.findElement(By.id("RESULT_RadioButton-7_0"));
		//male_Rd.click();  //ClickInterceptedException
		js.executeScript("arguments[0].click();",male_Rd);
		*/

		/*
		//Checkbox
		WebElement chkbox=driver.findElement(By.id("RESULT_CheckBox-8_0"));
		js.executeAsyncScript("argument[0].click", chkbox);
				
		//button
		WebElement button=driver.findElement(By.id("FSsubmit"));
		js.executeScript("argument[0].click()", button);
		*/
				
				
	}

}
