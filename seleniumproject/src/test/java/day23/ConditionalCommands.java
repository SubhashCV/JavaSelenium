package day23;

import java.io.ObjectInputFilter.Status;

import org.apache.commons.exec.LogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		/*isDisplayed()
		//WebElement  logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		//System.out.println("Display status of Logo: "+logo.isDisplayed());
		
		Boolean stat  =  driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println(stat);
		*/
		
		/* isEnabled()
		WebElement search_box = driver.findElement(By.xpath("//input[@id='small-searchterms']"));	
		System.out.println("Enable status: "+search_box.isEnabled());
		System.out.println("Display status: "+ search_box.isDisplayed());
		*/
		
		WebElement male_rdBtn = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rdBtn = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		//Before selection
		System.out.println("Before selection..............");
		System.out.println("Status of male button: "+male_rdBtn.isSelected());
		System.out.println("Status of female button: "+female_rdBtn.isSelected());
		
		System.out.println();
		Thread.sleep(2000);
		
		/*
		//isSelected();
		// After Selection of male radio button
		System.out.println("After selection of male radio button.......");
		male_rdBtn.click();
		System.out.println("Status of male button: "+male_rdBtn.isSelected());
		System.out.println("Status of female button: "+female_rdBtn.isSelected());
		System.out.println();
		*/
		
		
		// after selection of female radio button
		System.out.println("After selection of female radio button");
		female_rdBtn.click();
		System.out.println("Status of male button: "+male_rdBtn.isSelected());
		System.out.println("Status of female button: "+female_rdBtn.isSelected());
		
		driver.quit();
	}

}
