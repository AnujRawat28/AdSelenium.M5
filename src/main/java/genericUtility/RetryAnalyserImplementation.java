package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This is a Implementation class for IRetryAnalyser interface  of TestNG
 * @author anuj4
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	int count = 0;
	int retryCount = 3;
	
	public boolean retry(ITestResult result) 
	{
		while(count<retryCount) {
			count++;
			return true;//
		}
		return false;// stop the retry
		
	}

}
