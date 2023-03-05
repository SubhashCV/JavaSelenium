package day36_TestNG.pack2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {
	
	@Test
	void abc() {
		System.out.println("this is abc from Class1");
	}
	
	@BeforeTest
	void m() {
		System.out.println("this is Before test method..");
	}
	
	@BeforeSuite
	void bs() {
		System.out.println("This is before suite...");
	}
	
	@AfterSuite
	void as() {
		System.out.println("This is After Suite....");
	}
}
