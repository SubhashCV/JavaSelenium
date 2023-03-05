package day34;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assn_CDCalculator_DTT {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator/");
		driver.manage().window().maximize();
		
		WebElement inideposit = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement lenghtCD = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement intRate =driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		WebElement calbutton = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));  // 'Lets run the numbers' button
		
		System.out.println("user has identified all elements to calculate CD");
		
		//String path="C:\\SeleniumPractice\\caldata2.xlsx";   // giving path to file to start reading
		String file = System.getProperty("user.dir")+"\\testdata\\caldata2.xlsx";
		
	 	int rows= XlUtils.getRowCount(file, "Sheet1");
	 	
	 	System.out.println("Number of rows: "+rows);
	 	
	 	for(int i=0; i<=rows;i++) {
	 		// reading data from excel
	 		String indepo = XlUtils.getCellData(file, "Sheet1", i, 0);
	 		String intrestrATE=XlUtils.getCellData(file, "Sheet1", i, 1);
	 		String len= XlUtils.getCellData(file, "Sheet1", i, 2);
	 		String compoundingmonths =XlUtils.getCellData(file, "Sheet1", i, 3);
	 		String exptotal= XlUtils.getCellData(file, "Sheet1", i, 4);
	 		
	 		//passing data into application
	 		inideposit.sendKeys(indepo);
	 		lenghtCD.sendKeys(len);
	 		intRate.sendKeys(intrestrATE);
	 		
	 		WebElement compdrp =driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
	 		compdrp.click();
	 		
	 		List<WebElement> Options = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
	 		
	 		for(WebElement opt: Options) {
	 			if(opt.getText().equals(compoundingmonths)) {
	 				opt.click();
	 			}
	 		}
	 		
	 		JavascriptExecutor js=(JavascriptExecutor)driver;
	 		js.executeScript("arguments[0].click();", calbutton);
	 		//calbutton.click();    //click on button to calculate cd calculation based on xl cell data
	 	
	 		String acttotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
	 		
	 		System.out.println("Actual total is : "+acttotal);
	 		System.out.println("Expected total is : "+exptotal);
	 		
	 		if(exptotal.equals(acttotal)) 
	 		{
	 			XlUtils.setCellData(file, "Sheet1", i, 6, "pass");
	 		}
	 		else {
				XlUtils.setCellData(file, "Sheet1", i, 6, "fail");
			}
	 		
	 		System.out.println("Calculation has been completed");
	 		driver.close();
	 	}
	}

}
