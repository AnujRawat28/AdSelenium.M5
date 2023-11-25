package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1WithDDT 
{

	public static void main(String[] args) throws IOException 
	{
				FileInputStream fisP = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				
				Properties p = new Properties();
				p.load(fisP);
				String BROWSER = p.getProperty("browser");
				String URL = p.getProperty("url");
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");
				

				FileInputStream fisE = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fisE);
				String LastName = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
				
				WebDriver driver;
				
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
				
				System.out.println(LastName);
				System.out.println("working");
				
	}

}
