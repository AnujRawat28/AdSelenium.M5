package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * 
 * 
 * @author anuj4
 *
 */

public class ExcelFileUtility {

	/**
	 * this method will read data from property file for the key provided by caller
	 * @return 
	 * @throws IOException 
	 * 
	 */
	public String readDataFromExcel(String sheetname,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
	    FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    String value = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
		
	}
	
	/**
	 * This method will read multiple data from excel and helps to provide data to DataProvider
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException ,IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	     Sheet sh = wb.getSheet(sheetname);
	     int lastRow = sh.getLastRowNum();
	     int lastCell = sh.getRow(0).getLastCellNum();
	     Object[][] data = new Object[lastRow][lastCell];
	     
	     for(int i=0;i<lastRow;i++)
	     {
	    	 for(int j=0;j<lastCell;j++)
	    	 {
	    		 data[i][j] = sh.getRow(i+1).getCell(j).getRichStringCellValue();
	    	 }
	     }
	     return data;
	}
}
