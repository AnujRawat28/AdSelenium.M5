package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFiles {

	public static void main(String[] args) throws IOException {

		//Step 1: open the document in java Readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: create an object properties class from java.util
		Properties p = new Properties();
		
		//Step 3: load the input stream into properties
		p.load(fis);
		
		//Step 4: provide the key to load the values (k,v)
		String value = p.getProperty("browser");
		System.out.println(value);
		
		String value1 = p.getProperty("url");
		System.out.println(value1);
		
		String value2 = p.getProperty("username");
		System.out.println(value2);
		
		String value3 = p.getProperty("password");
		System.out.println(value3);
	}

}
