package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		//Min Slider
		WebElement minSlide = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Default location of min slider :"+minSlide.getLocation());  //(59, 250)
		act.dragAndDropBy(minSlide, 159, 250).perform();
		System.out.println("location of min slider :"+minSlide.getLocation());
		
		//Max Slider
		WebElement maxSlide = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Default location of max slider :"+maxSlide.getLocation());  //(544, 250)
		
		//act.dragAndDropBy(maxSlide, 444, 250).perform(); //it wont work shoul give only -value in x-axis
		act.dragAndDropBy(maxSlide, -100, 250).build().perform();
		System.out.println("location of max slider :"+maxSlide.getLocation());
		
	}

}
