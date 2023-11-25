package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of all generic methods related to webdriver action
 * 
 * @author anuj4
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method will wait implicitly 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	/**
	 * This method will wait for 10 seconds for element
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeLoad(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for 10 seconds for element to be clickable
	 * @param driver
	 * @param element
	 * 
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle drop-down by index
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	
	/**
	 * This method will handle drop-down by value
	 * @param element
	 * @param value
	 */
	
	public void handleDropDown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle drop-down by visible text
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(text);
		
	}
	
	/**
	 * This method will handle drop-down by visible text
	 * @param element
	 * @param driver
	 */
	
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will right click
	 * @param element
	 * @param driver
	 */
	
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will drag and drop
	 * @param driver
	 * @param srcEle
	 * @param targetEle
	 */
	
	public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement targetEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, targetEle).perform();
	}
	
	
	/**
	 * This method will click and hold
	 * @param element
	 * @param driver
	 */
	
	public void ClickAndHoldAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * This method will Scroll down for 500 unit
	 * @param element
	 * @param driver
	 */
	
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.ScrollBy(0,500)","");
	}
	
	/**
	 * This method will Scroll up for 500 unit
	 * @param element
	 * @param driver
	 */
	
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.ScrollBy(0,-500)","");
	}
	
	/**
	 * This method will Scroll right for 500 unit
	 * @param element
	 * @param driver
	 */
	
	public void scrollRightAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.ScrollBy(500,0)","");
	}
	
	/**
	 * This method will Scroll left for 500 unit
	 * @param element
	 * @param driver
	 */
	
	public void scrollLeftAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.ScrollBy(-500,0)","");
	}
	
	/**
	 * This method will  accept Alert PopUps
	 * @param element
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * This method will  dismiss Alert PopUps
	 * @param element
	 * @param driver
	 */
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	
	/**
	 * This method will  accept Alert PopUps
	 * @param element
	 * @param driver
	 */
	
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
		
	}
	
	/**
	 * This method will switch to frame on index 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver ,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to frame on index 
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver ,String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will switch to frame on index 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver ,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	/**
	 * This method will switch the window based on the partial window with title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver ,String partialWindowTitle)
	{
		//Step 1: Capture all the windows id
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		//Step 2: Navigate through each window ID
		for (String windowID : allWindowIDs)
		{
			//Step 3: Switch to each window and capture the title 
			String actTitle = driver.switchTo().window(windowID).getTitle();
			
			//Step 4 : Compare the actual title with expected partial window title 
			if (actTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This method will take  screen shot and store it in required folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShot\\"+screenShotName+".png");
		
		Files.copy(src, dst);//crct
		
		return dst.getAbsolutePath(); //complete path of screenshot - extent reports
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
