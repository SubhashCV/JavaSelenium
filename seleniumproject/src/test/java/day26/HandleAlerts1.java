package day26;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		/*
		// using implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		Thread.sleep(5000);
		Alert alrt =  driver.switchTo().alert();
		System.out.println(alrt.getText());
		
		
		Thread.sleep(3000);
		alrt.accept();
		*/
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Click for JS Alert')]")).click();
		
		Alert al = myWait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(4000);
		System.out.println(al.getText());
		
		al.accept();
		Thread.sleep(4000);
		
		
		System.out.println( driver.findElement(By.xpath("//p[@id='result']")).getText());
		driver.quit();
	}

}
