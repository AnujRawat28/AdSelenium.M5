package practice;

import org.testng.annotations.Test;

public class ReadDAtaFromCmdLine {

	@Test
	public void read()
	{
		String UN = System.getProperty("username");
		String PWD = System.getProperty("password");
		
		System.out.println(UN);
		System.out.println(PWD);
	}

}
