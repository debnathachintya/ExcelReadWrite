package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passWord;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement submitBtn;
	
	public void getUserName(String strUserName) {
		userName.sendKeys(strUserName);
	}
	
	public void getPassword(String strPassWord) {
		passWord.sendKeys(strPassWord);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
}