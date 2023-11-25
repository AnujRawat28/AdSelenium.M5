package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility 
{
	//Declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDwn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilizations
	
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getTypeDropDwn() {
		return typeDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	
	/**
	 * 
	 */
	public void createNewOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	public void createNewOrganization(String ORGNAME, String INDUSTRYNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDwn, INDUSTRYNAME);
		SaveBtn.click();
	}
	
	
	
	
}
