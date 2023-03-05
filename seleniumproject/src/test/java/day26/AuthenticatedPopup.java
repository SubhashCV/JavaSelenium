package day26;

import java.awt.Frame;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//http://the-internet.herokuapp.com/basic_auth
		//http://admin:admin@the-internet.herokuapp.com/basic_auth
		
		driver.get("//http://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(3000);
		
		String actual_text = driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();
		
		String expt_text = "Congratulations";
		
		if (actual_text.contains(expt_text)) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("test failed");
		}
	}

}
