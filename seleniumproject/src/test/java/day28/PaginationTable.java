package day28;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal;
import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;

public class PaginationTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		//Login
		
		WebElement usernam = driver.findElement(By.xpath("//input[@name='username']"));
		usernam.clear();
		usernam.sendKeys("demo");
		
		WebElement pasword = driver.findElement(By.xpath("//input[@name='password']"));
		pasword.clear();
		pasword.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//closing a popup
		if (driver.findElement(By.xpath("//button[@type='button'][@class='btn-close']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@type='button'][@class='btn-close']")).click();
		}
		
		//getting error
		/*
		//a[@class='parent collapsed'][@href='#collapse-1']
		driver.findElement(By.xpath("//a[@class='parent collapsed'][@href='#collapse-1']")).click();
		System.out.println("fine1");
		Thread.sleep(20000);
		//ul[@id-='collapse-5'][@class='collapse show']//a[contains(text(),'Customers')]
		//driver.findElement(By.xpath("//ul[@class='collapse show']//a[contains(text(),'Customers')]")).click();
		driver.findElement(By.cssSelector("ul[id='collapse-5'] li[class='active'] a")).click();
		System.out.println("fine2");
		*/
		
		//Customers--->customers
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@class='collapse show']//a[contains(text(),'Customers')]")).click();
		
		
		
		//div[@class='col-sm-6 text-end']
		String pagesText= driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int page = Integer.parseInt(pagesText.substring(pagesText.indexOf("(")+1,pagesText.indexOf("Pages")-1));
		
		System.out.println("Nuber of pages : "+page);
		
		for(int p=1;p<=10;p++) {
			if (page>1) {
				//pagination button xpath
				Thread.sleep(10000);
//				WebElement activ_page=  driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()='+p+']"));
				WebElement activ_page=  driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]"));
				System.out.println("Active Page : "+activ_page.getText()); //printing the active page number
				activ_page.click(); //clicking active page
				Thread.sleep(2000);
			}
			
			int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println("Total Number of Rows in Active Page : "+ rows);
			
			for(int r=1;r<rows;r++) {
				String customer_name= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr//td[2]")).getText();
				String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr//td[3]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr//td[3]")).getText();
				
				System.out.println(customer_name+"      "+email+"          "+status);	
			}	
		}
		driver.quit();

	}

}
