package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=product/product&language=en-gb&path=57&product_id=49");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='submit' and @id='button-cart']")).click();
		
		driver.quit();
		
	}

}
