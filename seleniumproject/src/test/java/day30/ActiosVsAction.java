package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActiosVsAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		Actions act= new Actions(driver);
		
		WebElement btn = driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
		
		//act.contextClick(btn).build().perform();
		
		Action myact=act.contextClick(btn).build();   // creating action and storing in a variable
		myact.perform();  // completing action
		
		//act.contextClick(btn).perform(); // right click
		
		
	}

}
