package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContact 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// create object of all utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriver driver = null;
		
		//Step 1: Read all  the required Data
		/* Common Data */
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
		/* test data*/
		String LastName = eUtil.readDataFromExcel("Contacts", 1, 2);
				
		// Step 2: Launch the Browser -- Polymorphism -- Run Time -- Driver
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
				
				
				//Step 3: Login Page
				LoginPage lp = new LoginPage(driver);
				lp.LoginToApp(USERNAME, PASSWORD);
				
				//Step 4: Navigate to Contacts Links
				HomePage hp = new HomePage(driver);
				hp.clickOnContactsLnk();
				
				//Step 5: click on Contact look Up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				//Step 6: create new Contact
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.CreateNewContact(LastName);
				
				//Step 7:Validation
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contactheader = cip.getContactHeader();
				if (contactheader.contains(LastName)) 
				{
					System.out.println(contactheader);
					System.out.println("PASS");
					
				}
				else 
				{
					System.out.println("FAIL");
				}
				
				
				//Step 8 :Logout
				hp.logoutOfApp(driver);
				
				//Step 9: close the browser
				driver.quit();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}
}
