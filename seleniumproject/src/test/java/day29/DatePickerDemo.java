package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v107.dom.DOM.GetFrameOwnerResponse;

public class DatePickerDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0); //switch to frame
		
		//Approach 1
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("01/22/2023");
		
		//Approach 2
		String year="2021";
		String month="January";
		String date="25";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		
		while (true) {
			String mon= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if (year.equals(yr) && month.equals(mon) ) {
				break;
			}
			
			// driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //upcoming date(like travel)
			//span[@class='ui-icon ui-icon-circle-triangle-w']
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Past date
		}
		
		List<WebElement> dates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td")); // previous dates (like DOB and passbook statement)
		
		/*
		for(WebElement dt: dates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		*/
		
		
		
		for(int i=1;i<dates.size();i++) 
		{
			if(dates.get(i).getText().equals(date)) 
			{
				dates.get(i).click();
				break;
				
			}
		}
		Thread.sleep(5000);
		driver.quit();
		

	}

}
