package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assn_DragAndDrop {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		WebElement bankele = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement banktrg = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		
		act.dragAndDrop(bankele, banktrg).perform();
		
		WebElement Amount1 = driver.findElement(By.xpath("//*[@id='fourth']//a"));
		WebElement debitAmount= driver.findElement(By.xpath("//ol[@id='amt7']//li"));
		act.dragAndDrop(Amount1, debitAmount).perform();
			
		WebElement Sale =driver.findElement(By.xpath("//li[@id='credit1']//a"));
	 	WebElement Credtrg = driver.findElement(By.xpath("//ol[@id='loan']//li"));
	 	act.dragAndDrop(Sale, Credtrg).perform();
	 	
	 	
	 	WebElement amt2 =driver.findElement(By.xpath("//*[@id='fourth']//a"));
	 	WebElement cramount =driver.findElement(By.xpath("//ol[@id='amt8']//li"));
	 	
	 	act.dragAndDrop(amt2, cramount).perform();
	 	
	 	//div[@id='equal']//a[normalize-space()='Perfect!']
	 	WebElement text =driver.findElement(By.xpath("//div[@id='equal']//a[normalize-space()='Perfect!']"));
	 	
	 	if (text.isDisplayed()) {
			System.out.println("perfect is Displayed!!");
		}else {
			System.out.println("Perfect is not displayed");
		}
	 	
	}

}
