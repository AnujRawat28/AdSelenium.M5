package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice 
{
	@Test
	public void sample1()
	{
		System.out.println("HELLO");
	}

	@Test
	public void sample2()
	{
		Assert.fail();
		System.out.println("HELLO WORLD");
	}

	@Test
	public void sample3()
	{
		System.out.println("HELLO ANUJ");
	}

	@Test
	public void sample4()
	{
		System.out.println("ANUJ RAWAT");
	}

}
