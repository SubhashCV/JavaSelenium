package day36_TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;


public class HardAnnotations {

	//Hard Assertions we can directly access by using assert class
	/*
	@Test
	void test() {
		
		int x=10;
		int y=15;
		
		if (x==y) 
		{
			System.out.println("Passed");
		}else 
		{
			System.out.println("Failed");
		}
	}
	
	// even though the test is failed but the test result is passed
	*/
	
	@Test (priority = 2)
	void test2() {
		int x,y;
		x=10;
		y=10;
		
		Assert.assertEquals(x, y);
	}
	
	@Test(priority = 3)
	void test3() {
		int x=5;
		int y=7;
		Assert.assertEquals(x, y, "x and y are not equal");
	}
	
	@Test(priority = 4)
	void test4()
	{
		Assert.assertTrue(true);
	}
	
	
	@Test(priority = 5)
	void test5() {
		int a=10;
		int b=20;
		
		// Assert.assertEquals(actual, expected, description)
		Assert.assertEquals(a>b, true,"a is not greater than b");
	}
	
	@Test(priority = 6)
	void test6() {
		String s1="abc";
		String s2="abc1";
		
		//Assert.assertEquals(s1, s2," Strings are not eqaul"); //pass
		
		Assert.assertNotEquals(s1, s2,"Strings are equal");
	}
	
	
	@Test(priority = 7)
	void test7() {
		
		
		//we can use assertions with if-else conditions
		if (false) {
			Assert.assertTrue(true);
		}
		else {
			
			//Assert.assertTrue(false); //instead of comparing we can write below line
			Assert.fail();
		}
	}
	
}
