package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class TestCase1 {
	public WebDriver driver;

	@Test(dataProvider = "searchProvider")
	public void baseTestSetup(String userName, String Password, int count) throws IOException {

		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/test/resources/config/FileUtils.properties";
		File srcFile = new File(filePath);

		FileInputStream fis = new FileInputStream(srcFile);
		prop.load(fis);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("baseURL"));

		LoginPage lp = new LoginPage(driver);
		lp.getUserName(userName);
		lp.getPassword(Password);
		lp.clickSubmitBtn();
		
		String writeFile = System.getProperty("user.dir") + "/testData/TestDataFile.xlsx";
		File localFile = new File(writeFile);

		FileInputStream finput = new FileInputStream(localFile);
		XSSFWorkbook wb = new XSSFWorkbook(finput);

		XSSFSheet sheets = wb.getSheet("TestData");
		
		sheets.getRow(count).createCell(2).setCellValue("Test Sangita");
		
		FileOutputStream fos = new FileOutputStream(localFile);
		
		wb.write(fos);
		
		wb.close();

		driver.close();
	}

	@DataProvider(name = "searchProvider")
	public Object[][] getExcelData() throws Exception {
		Object[][] data = new Object[3][3];
		String filePath = System.getProperty("user.dir") + "/testData/TestDataFile.xlsx";
		File srcFile = new File(filePath);

		FileInputStream fis = new FileInputStream(srcFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheets = wb.getSheet("TestData");

		data[0][0] = sheets.getRow(1).getCell(0).getStringCellValue();

		data[0][1] = sheets.getRow(1).getCell(1).getStringCellValue();
		
		data[0][2] = 1;

		data[1][0] = sheets.getRow(2).getCell(0).getStringCellValue();

		data[1][1] = sheets.getRow(2).getCell(1).getStringCellValue();
		
		data[1][2] = 2;

		data[2][0] = sheets.getRow(3).getCell(0).getStringCellValue();

		data[2][1] = sheets.getRow(3).getCell(1).getStringCellValue();
		
		data[2][2] = 3;

		wb.close();

		return data;
	}
}