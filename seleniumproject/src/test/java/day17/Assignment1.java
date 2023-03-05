package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		Thread.sleep(5000);
		driver.manage().window().maximize();
		WebElement mail= driver.findElement(By.id("Email"));
		mail.clear();
		mail.sendKeys("admin@yourstore.com");
		WebElement pass = driver.findElement(By.name("Password"));
		pass.clear();
		pass.sendKeys("admin");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		
		Thread.sleep(10000);
		String actual_titleString = driver.getTitle();
		String exp_title = "Dashboard / nopCommerce administration";
		
		if(actual_titleString.equals(exp_title)) {
			System.out.println("Test passed");
			System.out.println("Redirected to Dashboard");
		}
		else {
			System.out.println("Test Failed");
			System.out.println("Stuck at login page");
		}
		
		
		
		driver.quit();

	}

}
