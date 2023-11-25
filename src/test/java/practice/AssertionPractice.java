package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice 
{
		@Test
	public void practice()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals(2, 1);
		System.out.println("Step 3");
	}
	
	@Test
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals("A", "B");
		
		System.out.println("Step 3");
		
		sa.assertEquals("x", "y");
		sa.assertAll();// failures logged // always use at last
	}

}
