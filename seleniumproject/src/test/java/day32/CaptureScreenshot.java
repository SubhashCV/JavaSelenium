package day32;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// Capture Full screen shot - selenium 3 & 4
		/*
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("D:\\Learning\\Selenium_new\\seleniumproject\\ScreenShots\\fullpage.png");
		
//		FileUtils.copyFile(src, trg);   //-------> not working
		FileHandler.copy(src, trg);
		*/
		
		
		// capture screen shot of a specific are from webpage -- selenium 4+
		/*
		WebElement featureproduct =driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src = featureproduct.getScreenshotAs(OutputType.FILE);
		File trg= new File("D:\\Learning\\Selenium_new\\seleniumproject\\ScreenShots\\featureProduct.png");
		FileHandler.copy(src, trg);
		*/
		
		WebElement gift = driver.findElement(By.xpath("//img[@alt='Picture of $25 Virtual Gift Card']"));
		
		File src = gift.getScreenshotAs(OutputType.FILE);
		File trg = new File("D:\\Learning\\Selenium_new\\seleniumproject\\ScreenShots\\gift.png");
		FileHandler.copy(src, trg);
		
		Thread.sleep(5000);
		driver.quit();
	}

}
