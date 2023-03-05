package day28;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class StaticTableDemo {

	public static void main(String[] args) {
		
		//https://testautomationpractice.blogspot.com/
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// 1) Find total number of rows 
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr")).size();
		//int rows=driver.findElements(By.tagName("tr")).size(); //8   prefered only if you have one single table
		System.out.println("Number Of rows are : "+rows);
		//2) Find total number of columns
		
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Number of columns are : "+cols);
		
		
		
		//3) Read specific row & column data
		String text1 =driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]//td[3]")).getText();
		System.out.println(text1);
		
		String text2 =driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[3]")).getText();
		System.out.println(text2);
		
		/*
		//4) Read data from all the rows & columns
		for(int r=2;r<=rows;r++) {
			for(int c=1;c<=cols;c++) {
				//table[@name='BookTable']//tr//td
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		*/
		System.out.println();
		
		//5) Print book names whose author is Amit
	
		for(int r=2;r<=rows;r++) 
		{
			String author =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if (author.equals("Amod"))
			{
				String bookname =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				
				System.out.println(author+" - "+bookname);
			}	
		}
		
		System.out.println();
		//6)Find sum of prices for all the books
		/*
		int sum=0;
		driver.findElement(By.xpath("//table[@name='BookTable']//tr//td[4]"));
		for(int r=2;r<=rows;r++) {
		   String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
		   int price=Integer.parseInt(data);
		   sum=sum+price;
		 
		}
		System.out.println("Total price of books: "+sum);
		*/
		
		int sum=0;
		for(int r=2;r<=rows;r++) {
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			sum=sum+Integer.parseInt(price);
		}
		System.out.println("Total price of books: "+sum);
		
		
		
		
		driver.quit();
	}

}
