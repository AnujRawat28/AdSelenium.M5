package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataUsingExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Name");
		Row rw = sh.createRow(0);
		Cell cl = rw.createCell(0);
		cl.setCellValue("Lipika");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Book2.xlsx");
		wb.write(fos);
	}

}
