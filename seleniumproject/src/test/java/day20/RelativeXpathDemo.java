package day20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpathDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://demo.opencart.com/");
		 
		
		driver.quit();
		

	}

}
