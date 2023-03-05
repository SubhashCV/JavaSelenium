package day25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDropDownwithoutSelectTag {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@type='button'][contains(@class,'multiselect')]")).click();
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
		
		// find total number of options
		System.out.println("Total number of options : "+ options.size());
		
		System.out.println();
		/*
		// print all options from dropdown
		// using normal for loop
		for(int i=0; i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		*/
		
		// print all options from dropdown
		// using (enhanced for loop/for each loop)
		for(WebElement op :options) {
			System.out.println(op.getText());
		}
		
		/*
		//select options from dropdown using normal for loop
		for(int i=0; i<options.size();i++) {
			String option = options.get(i).getText();
			if (option.equals("Java") || option.equals("Python")) {
				options.get(i).click();
			}
		}
		*/
		
		for(WebElement opt:options) {
			String text = opt.getText();
			if (text.equals("Java") || text.equals("Oracle")) {
				opt.click();
			}
		}
		
		Thread.sleep(10000);
		driver.quit();
	}

}
