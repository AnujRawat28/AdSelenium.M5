package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenarios5 {

	

	public static void main(String[] args) throws InterruptedException {
		// Step 1 : Launch the Browser
				WebDriverManager.edgedriver().setup();
				WebDriver driver = new EdgeDriver();
				
				// Step 2 : maximizing the Browser
				driver.manage().window().maximize();
				
				// Step 3 : wait of 10 seconds
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Step 4: Login to Application
				driver.get("http://localhost:8888");
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				// Step 5: Navigate to Contact
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//Step 6: Click on create a new contact
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				//Step 7: Create a contact with mandatory Fields
				driver.findElement(By.xpath("//input[@type='text' and @name='lastname']")).sendKeys("Anuj");
				
				//Step 8: Click on organiation
				driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
				
				// Step 9: switching window
				String mainWindow = driver.getWindowHandle();
				System.out.println(mainWindow);
				
				Set<String> allWindow = driver.getWindowHandles();
				System.out.println(allWindow);

				
				for (String id :allWindow ) 
				{
				   if (!mainWindow.equals(id)) 
				   {
					driver.switchTo().window(id);
					
					//driver.findElement(By.name("search_text")).sendKeys("Chemical Industry");
					//driver.findElement(By.name("search")).click();
					driver.findElement(By.linkText("Chemical Industry")).click();					
				   }	
				}
				
				// Step 10: switching to main windows
				driver.switchTo().window(mainWindow);
				System.out.println("back to main window");
				Thread.sleep(2000);
				//Step 11: click on save button
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				//step 12: validation
				String containsHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (containsHeader.contains("Anuj")) 
				 {
			    	System.out.println(containsHeader);
					System.out.println("pass");
				 }
				
				else 
				 {
				   System.out.println("fail");
				 }
				
			
				//Step 13: Mouse Over Action to the Signout
				WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));	 
				Actions act = new Actions(driver);		  
				act.moveToElement(data).perform();
				Thread.sleep(2000);
				//Step 14: Click on signout button
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				System.out.println("log out successully");


	}

}

