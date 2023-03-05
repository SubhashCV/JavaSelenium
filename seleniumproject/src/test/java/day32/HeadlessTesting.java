package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {

		////////////// chrome Browser  ////////////////
		
		// Approach 1 --> Using Chrome Browser(Headless mode)
		/*
		ChromeOptions options= new ChromeOptions();
		options.setHeadless(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		*/
		
		/*
		// Approach 2   WebDriver Manager  5.1+
		ChromeOptions opt=new ChromeOptions();
		opt.setHeadless(true);
		WebDriver driver=WebDriverManager.chromedriver().capabilities(options).create();
		*/
		
		
//////////edge browser    /////////////
		
		EdgeOptions opt= new EdgeOptions();
		opt.setHeadless(true);
		
		WebDriver driver= new EdgeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		/*
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		*/
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		// validation
		
		String act_title = driver.getTitle();
		String exp_title = "OrangeHRM";
		
		if (act_title.equals(exp_title)) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test Failed");
		}

	}

}
