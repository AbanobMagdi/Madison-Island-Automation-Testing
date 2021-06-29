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
	
	public void UserCanLogin(String Email , String pass)
	{
		setTextElementText(email, Email);
		setTextElementText(password, pass);
		clickButton(loginbutton);
	}
}
