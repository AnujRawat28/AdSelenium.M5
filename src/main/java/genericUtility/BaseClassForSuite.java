package genericUtility;

/**
 * This class consist of basic configuration annotation of TestNG
 * @author anuj4
 *
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClassForSuite 
{
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriver driver = null;
	
	
	public static WebDriver sdriver; // for listeners
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() 
	{
		System.out.println("=== DB Connection Successful===");
	}
	//@Parameters("browser")
	//@BeforeTest(alwaysRun = true)
	@BeforeClass
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+"===Browser Launched");
		} 
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+"===Browser Launched");
		}

		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+"===Browser Launched");
		}
		
		else
		{
			System.out.println("==invalid browser name==");
		}
		
		
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		driver.get(URL);
		sdriver = driver;// used in listener class
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("=== Login Successful===");
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("=== Logout Successful===");
	}
	
	@AfterTest(alwaysRun = true)
	//@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("=== Browser Closed Successfully===");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("=== DB Closed Successfully===");
	}

	
	
	
}

