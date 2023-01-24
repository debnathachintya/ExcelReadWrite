package dataProviderTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel2 {
	public static void writeExcelFromFile() throws IOException, InvalidFormatException {
		String filePath = System.getProperty("user.dir")+"/testData/TestDataFile.xlsx";
		File srcFile = new File(filePath);
		FileInputStream fis = new FileInputStream(srcFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheets = wb.getSheet("TestData");
		
		int rowLength = sheets.getLastRowNum() - sheets.getFirstRowNum();
		
		for(int i=1; i<rowLength+1;i++) {
			XSSFRow rows = sheets.getRow(i);
			XSSFCell cells = rows.createCell(2);
			cells.setCellValue("Test Passed");
		}
		FileOutputStream fos = new FileOutputStream(srcFile);
		wb.write(fos);
		wb.close();
	}
	
	public static void main(String[] args) throws IOException, InvalidFormatException {
		writeExcelFromFile();
	}
}