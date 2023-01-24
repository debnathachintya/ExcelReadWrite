package dataProviderTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	public static void writeExcelFromFile() throws IOException {
		String filePath = System.getProperty("user.dir")+"/testData/TestDataFile.xlsx";
		File srcFile = new File(filePath);
		FileInputStream fis = new FileInputStream(srcFile);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheets = wb.getSheet("TestData");
		
		XSSFRow rows = sheets.createRow(1);
		XSSFCell cells = rows.createCell(5);
		cells.setCellValue("Test Passed");
		
		FileOutputStream fos = new FileOutputStream(srcFile);
		wb.write(fos);
		wb.close();
	}
	
	public static void main(String[] args) throws IOException {
		writeExcelFromFile();
	}
}
