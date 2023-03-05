package day36_TestNG.pack1;

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
}
