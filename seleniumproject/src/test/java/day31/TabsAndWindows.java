package day31;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.opencart.com/");
		Thread.sleep(10000);
		
		//driver.switchTo().newWindow(WindowType.TAB);  // Opens a new TAB
		driver.switchTo().newWindow(WindowType.WINDOW); // Opens in another Window
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		

	}

}
