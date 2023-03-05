package day32;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException  {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    System.out.println("Total number of links: "+ links.size());
	    
	    int brokenlinks=0;
	    
	    for(WebElement onelink : links) 
	    {
	    	String hrefAtt= onelink.getAttribute("href");
	    	
	    	
	    	if (hrefAtt==null || hrefAtt.isEmpty()) {
				System.out.println("href attribute value is empty");
				continue;
			}
	    	
	    	//Checking link is broken or not
	    	//until we change the href string to url we cannot connect to server
			URL linkurl=new URL(hrefAtt); // convert String --> URL format
			
			// By using object 'linkurl' we send request to server
			
			//send request to server  1)open the connection 2) connect to server
			
			
			// 1)open the connection
			//URLConnection conn=linkurl.openConnection();  // after getting url connection type we cannot connect to server directly
			// so we need httpURLconnection
			
			
			HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection(); //send request to server - open , connect
			
			conn.connect();
			
			/*
			if(conn.getResponseCode()>=400) {
				System.out.println(onelink.getText()+""+" It is a broken link");
				brokenlinks++;
			}
			else {
				System.out.println(onelink.getText()+" "+"Not a broken link");
			}
			*/
			
			if (conn.getResponseCode()>400) {
				System.out.println(hrefAtt+ " "+ " ==> Broken link ");
				brokenlinks++;
			}
			else {
				System.out.println(hrefAtt+"  "+"  ==> Not Broken link");
			}	
	    }
		System.out.println("total number of broken links:"+brokenlinks);
	}

}
