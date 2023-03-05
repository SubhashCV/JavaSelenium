package day25;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ass_HandleDropDownUsingSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		WebElement contryDropEle =driver.findElement(By.xpath("//select[@id='country-list']"));
		contryDropEle.click();
		Select dropdownlist = new Select(contryDropEle);
		
		List<WebElement> option= dropdownlist.getOptions();
		System.out.println(option.size());
		
		System.out.println();
		for(WebElement op:option) {
			System.out.println(op.getText());
		}
		
		for(WebElement op :option) {
			if (op.getText().equals("India")) {
				op.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
		WebElement states = driver.findElement(By.xpath("//select[@id='state-list']"));
		states.click();
		Select  stateli= new Select(states);
		List<WebElement> stateOPt= stateli.getOptions();
		
		System.out.println();
		System.out.println(stateOPt.size());
		System.out.println();
		for(int i=0;i<stateOPt.size();i++) {
			System.out.println(stateOPt.get(i).getText());
		}
		
		/*
		System.out.println();
		for(WebElement op: stateOPt) {
			System.out.println(op.getText());
		}*/
		
		for(WebElement op: stateOPt) {
			if (op.getText().equals("Andhra Pradesh")) {
				op.click();
			}
		}
		Thread.sleep(6000);
		
		driver.quit();
	}

}
