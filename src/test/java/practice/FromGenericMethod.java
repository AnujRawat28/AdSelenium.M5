package practice;

import java.io.IOException;
import java.util.Properties;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;

public class FromGenericMethod {

	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility pf = new PropertyFileUtility(); //PropertyFileUtility class in main/java
		String value = pf.readDataFromPropertyFile("browser"); // non method in PropertyFileUtility class
		System.out.println(value);
		
		String value1 = pf.readDataFromPropertyFile("url");// non method in PropertyFileUtility class
		System.out.println(value1);
		
		String value2 = pf.readDataFromPropertyFile("username");// non method in PropertyFileUtility class
		System.out.println(value2);
		
		String value3 = pf.readDataFromPropertyFile("password");// non method in PropertyFileUtility class
		System.out.println(value3);
		
		/**
		 *  non static methods for
		 * SYSTEM DATE
		 * RANDOM NUMBER
		 * ORGANIZATION NAME
		 */
	
		JavaUtility jUtil = new JavaUtility(); // JavaUtility class in main/java
		String date = jUtil.getSystemDateInFormate();// non method in JavaUtility class
		
		System.out.println(date);
		
		int ran = jUtil.getRandomNumber(); // non method in JavaUtility class
		System.out.println(ran);
		
		ExcelFileUtility eUtil = new ExcelFileUtility(); //  ExcelFileUtility class in main/java
		String orgname = eUtil.readDataFromExcel("Organization", 1, 2);
		String orgNameWithRandom = orgname+ran;
		System.out.println(orgname);
		System.out.println(orgNameWithRandom);
	}

}
