package day25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDownwithSelectTag {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		WebElement drpCountryEle  =driver.findElement(By.xpath("//select[@id='country-list']"));
		Select drpCountry = new Select(drpCountryEle);
		
		/*
		//selecting an option from the dropdown
		drpCountry.selectByIndex(2);// Selects China
		Thread.sleep(5000);
		drpCountry.selectByValue("3");// Selects France
		Thread.sleep(5000);
		drpCountry.selectByVisibleText("India"); // Selects india
		Thread.sleep(5000);
		*/
		
		//find total number of options in the dropdown
		List<WebElement> options=drpCountry.getOptions();
		System.out.println("Total number of options: "+options.size());  //getting 6 why??????
		
		/*
		// print options in console window using normal for loop
		System.out.println();
		for(int i=0; i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		*/
		
		
		// print options in console window for each loop or enhanced loop
		for(WebElement op:options) {
			System.out.println(op.getText());
		}
		
		
		driver.quit();
	}

}
