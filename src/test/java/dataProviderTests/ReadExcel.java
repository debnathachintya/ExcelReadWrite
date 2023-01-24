package dataProviderTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void readExcelFromFile() throws IOException {
		String filePath = System.getProperty("user.dir")+"/testData/TestDataFile.xlsx";
		File srcFile = new File(filePath);
		FileInputStream fis = new FileInputStream(srcFile);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheets = wb.getSheet("TestData");
		
		int rowLength=sheets.getLastRowNum() - sheets.getFirstRowNum();
		
		for(int i=0; i<rowLength+1; i++) {
			XSSFRow rows = sheets.getRow(i);
			for(int j=0; j<rows.getLastCellNum(); j++) {
				XSSFCell cell = rows.getCell(j);
				System.out.print(cell.getStringCellValue() + " || ");
			}
			System.out.println();
		}
		wb.close();
	}
	
	public static void main(String[] args) throws IOException {
		readExcelFromFile();
	}
}