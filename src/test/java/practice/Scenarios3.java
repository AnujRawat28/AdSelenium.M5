package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenarios3 {

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
				
				driver.findElement(By.xpath("//a[.='Organizations']")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				driver.findElement(By.xpath("//input[@type='text' and @name='accountname']")).sendKeys("Chemical Industry");
				driver.findElement(By.xpath("//select[@name='industry']")).click();
				driver.findElement(By.xpath("//option[@value='Chemicals']")).click();
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//step 5: validation
				//driver.findElement(By.xpath("")).click();
				
				
				Thread.sleep(5000);
				//Step 6: Mouse Over Action to the Signout
				WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));	 
				Actions act = new Actions(driver);		  
				act.moveToElement(data).perform();

				//Step 7: Click on signout button
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				driver.findElement(By.xpath("")).click();
	}

}
