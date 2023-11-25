package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration
		@FindBy(linkText = "Organizations")
		private WebElement organizationLnk;
		
		@FindBy(linkText = "Contacts")
		private WebElement contactsLnk;
		
		@FindBy(linkText = "Products")
		private WebElement productLnk;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement administrationImg;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signoutLnk;
		
		//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getOrganizationLnk() {
			return organizationLnk;
		}

		public WebElement getContactsLnk() {
			return contactsLnk;
		}

		public WebElement getProductLnk() {
			return productLnk;
		}

		public WebElement getAdministrationImg() {
			return administrationImg;
		}

		public WebElement getSignoutLnk() {
			return signoutLnk;
		}
		
		
		//Business Library
		/**
		 * This method will click on organization link
		 */
		public void clickOnOrgLnk()
		{
			organizationLnk.click();
		}
		
		/**
		 * This method will click on contacts link
		 */
		public void clickOnContactsLnk()
		{
			contactsLnk.click();
		}
		
		/**
		 * This method will click on organization link
		 * @throws InterruptedException 
		 */
		public void logoutOfApp(WebDriver driver) throws InterruptedException
		{
			mouseHoverAction(driver, administrationImg);
			Thread.sleep(1000);
			signoutLnk.click();
			
		}

	
	
	
	
	
	
	
	
	
	
	

}