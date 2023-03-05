package day19;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorsDemo {

	public static void main(String[] args) throws InterruptedException {

//		https://demo.nopcommerce.com/
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		/*
		//css with tag and id
	  	driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
	  	*/
	  	
		/*
	  //css with id
	  	driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");
	  	*/
	  	Thread.sleep(5000);
	  	
	  	/*
	  	// css with tag and class
	  	driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook");
	  	*/
	  	
	  	/*
	  	// css with only class
	  	driver.findElement(By.cssSelector(".search-box-text")).sendKeys("MacBook");
	  	*/
	  	
	  	/*
	  	//css with tag and any attribute
	  	driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Macbook");
	  	*/
	  	
	  	/*
	  	// css wit only attribute
	  	driver.findElement(By.cssSelector("[name='q']")).sendKeys("Macbook);
	  	*/
	  	
	  	/*
	  	// css selector with tag, class and attribute
	  	driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("hello");
	  	*/
	  	
	  	
	    // css selector with only class and attribute
	  	driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("hyee");
	  	
	  	// in the class attribute - value, if there are any spaces. we don't need to consider those spaces
	  	
	  	
	  	 
	  	
	  	
//	  	driver.quit();
	}

}
