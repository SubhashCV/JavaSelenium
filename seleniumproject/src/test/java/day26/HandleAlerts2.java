package day26;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		
		/*
		//Using implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		
		Thread.sleep(5000);
		
		Alert alert1 = driver.switchTo().alert();
		
		System.out.println(alert1.getText());
		
		alert1.accept(); // this will close the alert button using ok button
		//alert1.dismiss(); // this will close the alert button using close button
		
		String text2 = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(text2);
		*/
		
		//Using Explicit Wait
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Thread.sleep(6000);
		
		Alert alertWindow =myWait.until(ExpectedConditions.alertIsPresent());
		
		Thread.sleep(5000);
		System.out.println(alertWindow.getText());
		
		alertWindow.accept();
		//alertWindow.dismiss();
		
		//printing the result
		String res1 = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(res1);
		driver.quit();
		
	}

}
