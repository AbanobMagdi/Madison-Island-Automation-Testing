package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "pass")
	WebElement password;
	@FindBy(id = "send2")
	WebElement loginbutton;
	@FindBy(id = "advice-required-entry-email")
	public WebElement EmailVaildation;
	@FindBy(id = "advice-required-entry-pass")
	public WebElement passwordVaildation;
	@FindBy(css="p.required")
	public WebElement InCorrectVaildation;
	
	
	
	public void UserCanLogin(String Email , String pass)
	{
		setTextElementText(email, Email);
		setTextElementText(password, pass);
		clickButton(loginbutton);
	}
}
