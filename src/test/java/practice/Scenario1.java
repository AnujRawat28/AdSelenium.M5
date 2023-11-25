package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 
{

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
		//Step 5: Create a contact with mandatory Fields
		driver.findElement(By.xpath("//input[@type='text' and @name='lastname']")).sendKeys("Qspiders");
		
		//Step 7: click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 8: validation
		String containsHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (containsHeader.contains("Qspiders")) 
		{
			System.out.println(containsHeader);
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		
		Thread.sleep(2000);
		
		//Step 9: Mouse Over Action to the Signout
		WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));	 
		Actions act = new Actions(driver);		  
		act.moveToElement(data).perform();

		//Step 10: Click on signout button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		System.out.println("aplication is logout");
		
	}

}
