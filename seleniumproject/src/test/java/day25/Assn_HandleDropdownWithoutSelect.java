package day25;

import java.time.Duration;
import java.util.List;
import java.util.Locale.IsoCountryCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v106.page.Page.SetWebLifecycleStateState;
import org.openqa.selenium.support.ui.Select;

public class Assn_HandleDropdownWithoutSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//select[@id='country-list']")).click();
		List<WebElement> contryopt =driver.findElements(By.xpath("//select[@id='country-list']//option"));
		
		System.out.println(contryopt.size());
		System.out.println();
		System.out.println("Country list" );
		for(int i=0;i<contryopt.size();i++) {
			System.out.println(contryopt.get(i).getText());
		}
		
		for(WebElement opt:contryopt) 
		{
			if(opt.getText().equals("India")) {
				opt.click();
				break;
			}
		}
		System.out.println();
		//total number of elements in dropdown
		//System.out.println(conDrpSelct.size());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@id='state-list']")).click();
		
		List<WebElement> stateopt = driver.findElements(By.xpath("//select[@id='state-list']//option"));
		
		System.out.println(stateopt.size());
		
		System.out.println();
		/*
		for(int i=0;i<stateopt.size();i++) {
			System.out.println(stateopt.get(i).getText());
		}
		*/
		for(WebElement opt: stateopt)
		{
			System.out.println(opt.getText());
		}
		for(WebElement op:stateopt) {
			if(op.getText().equals("Andhra Pradesh")) {
				op.click();
				break;
			}
			
		}
		
		
	
		
		Thread.sleep(5000);
		driver.quit();
	}

}
