package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.BaseClassForSuite;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

@Listeners(genericUtility.ListenerImplementation.class)

public class CreateContactTestBaseClass extends BaseClassForSuite
{
	@Test
	
	public void CreateNewContactTest() throws IOException, InterruptedException 
	{
		/* test data*/
		String LastName = eUtil.readDataFromExcel("Contacts", 1, 2);
						
		//Step 4: Navigate to Contacts Links
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();
						
		//Step 5: click on Contact look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		Assert.fail();
		
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
						
	}			
}
