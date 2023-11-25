package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
/**
 * this method will return the current system date in specified formate 
 * @return 
 * 
 * 
 * 
 */
	
	public String getSystemDateInFormate()
	{
		Date d = new Date();
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String currentdate= data.format(d);
		return currentdate;
	}


	public  int getRandomNumber()
	{
		Random r = new Random();
		int value = r.nextInt(100);
		return value;
		
	
	}


}
