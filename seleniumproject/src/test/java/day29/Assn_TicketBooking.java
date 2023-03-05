package day29;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public class Assn_TicketBooking {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		
		WebElement depCity= driver.findElement(By.xpath("//select[@name='fromPort']"));
		depCity.click();
		
		Select fromCity = new Select(depCity);
		List<WebElement> option = fromCity.getOptions();
		
		System.out.println(option.size());
		
		
		//selecting Departure city
//		for(WebElement opt :  option) {
//			System.out.println(opt.getText());
//		}
		for(WebElement opt :option) {
			if (opt.getText().equals("Portland")) {
				opt.click();
				break;
			}
		}
		
		//selecting destination city
		WebElement destCity= driver.findElement(By.xpath("//select[@name='toPort']"));
		destCity.click();
		
		Select destinCity= new Select(destCity);
		List<WebElement> dtOptions= destinCity.getOptions();
		System.out.println(dtOptions.size());
		
		System.out.println("Destination Cities");
//		for(int i=0;i<dtOptions.size();i++) {
//			System.out.println(dtOptions.get(i).getText());
//		}
		
		for(int i=0;i<dtOptions.size();i++) {
			if (dtOptions.get(i).getText().equals("London")) {
				dtOptions.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		int rows= driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		System.out.println("Number of rows : "+rows);
		
		// capture prices then store in array
		
		String pricesArr[] = new String[rows]; // Declaration of a string variable (rows are 5) // 0-4
		
		for(int r=1; r<=rows;r++) {
			String prices= driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			pricesArr[r-1]=prices; // adding prices to an array
			
		}
		
//		Printing the prices of flight ticket using normal for loop
//		for(int r=0;r<rows;r++) {
//			System.out.println("Prices of flights are : "+pricesArr[r]);
//		}
		
		System.out.println();
//		Sort prices then find lower value
		
//		Printing the prices of flight ticket
		for(String rate:pricesArr) {
			System.out.println(rate);
		}
		
		Arrays.sort(pricesArr);  // this will able to sort strings. so no need to convert to number
		
		//printing the sorted array
//		for(String pric : pricesArr) {
//			System.out.println("Sorted"+pric);
//		}
		
		String lowestPrice = pricesArr[0];
		System.out.println("Lower Price : "+ lowestPrice);
		
//8		Find record in table having lower price
		
		for(int r=1;r<=rows;r++)
		{
			String prices= driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			
			if (prices.equals(lowestPrice)) {
				driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[1]")).click();
				break;
			}
		}
		
//9 -  Fill the details then click on Purchase Filight button
		driver.findElement(By.id("inputName")).sendKeys("Duli Mahesh");
		driver.findElement(By.id("address")).sendKeys("Mudddanur");
		driver.findElement(By.id("city")).sendKeys("Mudda");
		driver.findElement(By.id("state")).sendKeys("AP");
		driver.findElement(By.id("zipCode")).sendKeys("500081");
		driver.findElement(By.id("creditCardNumber")).sendKeys("984802233845454545454");
		driver.findElement(By.id("creditCardMonth")).sendKeys("05");
		driver.findElement(By.id("creditCardYear")).sendKeys("1947");
		driver.findElement(By.id("nameOnCard")).sendKeys("Yakhoob singh");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
//10	Validation
		String msg= driver.findElement(By.xpath("//div//h1")).getText();
		
		if (msg.contains("Thank you for your purchase")) {
			System.out.println("Ticket booked successfully");
		}
		else {
			System.out.println("Failed!");
		}
		
		Thread.sleep(8000);
		driver.quit();
		 
	}

}
