package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleInnerFramesDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		//input[@name='mytext1']
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("hello");
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(4000);
		//frame 3
		WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frm3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("hello frame 3");
		
		Thread.sleep(4000);
		WebElement innerfrm= driver.findElement(By.xpath("//iframe[normalize-space()='Loading...']"));
		driver.switchTo().frame(innerfrm);
		driver.findElement(By.cssSelector("div.AB7Lab")).click();  // select first radio button in frame
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		
		//frame2
		WebElement frm2= driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frm2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("sending in frame 2");
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		
		
		
		//frame 4
		WebElement frm4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));		
		driver.switchTo().frame(frm4);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("sending frame 4");
		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		
		driver.quit();
		
		
		
		
		
		
		

	}

}
