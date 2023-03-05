package day26;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertWithInpurtBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		/*
		// using implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Thread.sleep(4000);
		Alert al= driver.switchTo().alert();
		
		System.out.println(al.getText());
		Thread.sleep(4000);
		al.sendKeys("Hi chenna");
		Thread.sleep(4000);
		
		al.accept();
		//al.dismiss();
		Thread.sleep(4000);
	    String act_text = driver.findElement(By.xpath("//p[@id='result']")).getText();
	    String exp_Text = "You entered: Hi chenna";
	    
	    if(act_text.equals(exp_Text)) {
	    	System.out.println("test passed");
	    }
	    else {
			System.out.println("test failed");
		}
		*/
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert al =myWait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(al.getText());
		al.sendKeys("Hello cvs");
		
		al.accept();
		//al.dismiss();
		
		String act_text=  driver.findElement(By.xpath("//p[@id='result']")).getText();
		String exp_text= "You entered: Hello cvs";
		if (act_text.contains(exp_text)) {
			System.out.println("test passed");
		}
		else {
			System.out.println("test failed");
		}
		
		
	
		
		driver.quit();
		
	}

}
