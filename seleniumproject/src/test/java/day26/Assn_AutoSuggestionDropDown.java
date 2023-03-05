package day26;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.JoinRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assn_AutoSuggestionDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies(); //deletes all the cookies in your browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		
		//input[@id='sb_form_q' and @class='sb_form_q']
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='sb_form_q' and @class='sb_form_q']")).sendKeys("redbus");
		
		List<WebElement> list_ele = driver.findElements(By.xpath("//div[@class='sa_tm']//span"));
		
		System.out.println(list_ele.size());
		
		for(int i=0; i<list_ele.size();i++) {
			System.out.println(list_ele.get(i).getText());
		}
		
		for(int i = 0; i<list_ele.size();i++) {
			if (list_ele.get(i).getText().equals("redbus offers")) {
				list_ele.get(i).click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
