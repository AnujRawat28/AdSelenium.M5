package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Step 1: create object of all utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriver driver = null;
		
		//Step 2: Read all  the required Data
		/* Common Data */
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
		/* test data*/
		String LastName = eUtil.readDataFromExcel("Contacts", 1, 2);
				
		// Step 3: Launch the Browser -- Polymorphism -- Run Time -- Driver
				if (BROWSER.equalsIgnoreCase("Chrome")) 
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if (BROWSER.equalsIgnoreCase("Edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();

				}

				 else if (BROWSER.equalsIgnoreCase("Firefox"))
				{
					 WebDriverManager.firefoxdriver().setup();
					 driver = new FirefoxDriver();
				
				}
				
				else
				{
					System.out.println("invalid browser name");
				}
				
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step 4: Login to Application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);		
//		driver.findElement(By.id("submitButton")).click();
		
		// Step 4 commented on 16 October 2023
		
		LoginPage lp = new LoginPage(driver); // use of pom class
		lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
		
		
		//Step 5: navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 6: click on create contact look Up Image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 7: create contact with mandatory files
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		// Step 8:Save 		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();		
				
		//step 9: validation
		String containsHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (containsHeader.contains(LastName)) 
		 {
	    	System.out.println(containsHeader);
			System.out.println("pass");
		 }
		
		else 
		 {
		   System.out.println("fail");
		 }
				
				
		//Step 10: Mouse Over Action to the Sign-out
				
		WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));	 
		wUtil.mouseHoverAction(driver, data);

		//Step 11: Click on Sign-out button
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		System.out.println("aplication is logout");		
				
				
				
				
				
	}

}
