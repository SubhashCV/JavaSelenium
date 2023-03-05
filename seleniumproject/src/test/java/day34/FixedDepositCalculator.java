package day34;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//button[@id='wzrk-cancel']"))).click
		
		String file= System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int rows= ExcelUtils.getRowCount(file, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			
			//getting data from excel sheet
			String princi= ExcelUtils.getCellData(file, "Sheet1", i, 0);
			String roi= ExcelUtils.getCellData(file, "Sheet1", i, 1);
			String per1= ExcelUtils.getCellData(file, "Sheet1", i, 2);
			String per2= ExcelUtils.getCellData(file, "Sheet1", i, 3);
			String freq= ExcelUtils.getCellData(file, "Sheet1", i, 4);
			String maturityVal = ExcelUtils.getCellData(file, "Sheet1", i, 5);
			
			//passing Data to site
			driver.findElement(By.id("principal")).sendKeys(princi);
			driver.findElement(By.id("interest")).sendKeys(roi);
			driver.findElement(By.id("tenure")).sendKeys(per1);
			
			//way 1
			WebElement tenurepriod= driver.findElement(By.id("tenurePeriod"));
			Select tenureDrpSelect= new Select(tenurepriod);
			tenureDrpSelect.selectByVisibleText(per2);
			
			//way 2
			Select freqDrp= new Select(driver.findElement(By.id("frequency")));
			freqDrp.selectByVisibleText(freq);
			
			JavascriptExecutor js= (JavascriptExecutor)driver; 
			
			WebElement calcbtn= driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]"));
			js.executeScript("arguments[0].click();", calcbtn);
			
			
			//span[@id='resp_matval']//strong
			String act_matValue =driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			//validation
			if(Double.parseDouble(maturityVal)==Double.parseDouble(act_matValue)) {
				System.out.println("Test Passed");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "pass");
				ExcelUtils.fillGreenColor(file, "Sheet1", i, 7);
			}else {
				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "fail");
				ExcelUtils.fillRedColor(file, "Sheet1", i, 7);
			}
			
			Thread.sleep(4000);
			
			WebElement clrbtn= driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]"));
			js.executeScript("arguments[0].click();", clrbtn);
			
			//clrbtn.click();
		}
		
	}

}
