package day36_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardvsSoftAssertions {
	
	//@Test
	void test_hardassertions()
	{
		System.out.println("testing...");
		System.out.println("testing...");
		
		//Assert.assertEquals(1, 1);
		Assert.assertEquals(1, 2); //IF THIS LINE IS TRUe THEN ONLY THE NEXT LINE EXECUTES OR ELSE next lines won't execute
		
		System.out.println("Hard Assertion completed");
		
	}
	
	@Test
	void test_SoftAssertion() {
		
		
		System.out.println("testing...");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);// it will fail
		
		// even though the assertion fails, still the next statements can be executed in soft assertions
		System.out.println(" Soft assertions completed");
		
		sa.assertEquals(1, 1);
		
		//in a test case if we wrote 10 steps or 10 assertions. all assertions should be passed then only the result of test will get passed
		
		sa.assertAll(); //until and unless we use this statement(at the end) soft assertion will not work
	}

}
