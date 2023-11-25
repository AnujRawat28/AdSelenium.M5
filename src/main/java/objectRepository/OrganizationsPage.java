package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage
{
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLoopUpImg;
	
	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	//utilization
	public WebElement getCreateOrgLoopUpImg() {
		return CreateOrgLoopUpImg;
	}
	

	//business Library
	/**
	 * This method will click on create org lok up image
	 */
	public void clickOnCreateOrgLookImg()
	{
		CreateOrgLoopUpImg.click();
	}
	
	
	
	
	
	
	
}
