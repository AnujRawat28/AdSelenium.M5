package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consist of reusable methods related to property files 
 * @author anuj4
 *
 */
public class PropertyFileUtility {

	/**
	 * this method will read data from property file for the key provided by caller
	 * @return 
	 * @throws IOException 
	 * 
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\\\src\\\\test\\\\resources\\\\CommonData.properties");
	    Properties p = new Properties();
		p.load(fis);
		String value =  p.getProperty(key);
		return value;
		
	}
}
