package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		        //Step 1: open the document in java Readable format
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
				//Step 2: Create a Workbook
 				Workbook wb = WorkbookFactory.create(fis);
				
				//Step 3: Navigate to the sheet
				Sheet sh = wb.getSheet("Orgaizations");
				
				//Step 4: navigate to row
			    Row	gr=sh.getRow(4); 
			    
			    //Step 5: navigate to cell
			 	Cell cl = gr.getCell(2);
			 	
				//Step 6: get data from cells
				String value = cl.getStringCellValue();
				System.out.println(value);
				
	}

}
