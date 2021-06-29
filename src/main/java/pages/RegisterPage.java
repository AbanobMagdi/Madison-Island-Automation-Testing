package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "firstname")
	WebElement fname;
	
	@FindBy(id = "lastname")
	WebElement lname;
	
	@FindBy(id = "email_address")
	WebElement Email;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(id="confirmation")
	WebElement confirmation;
	
	@FindBy(xpath = "//*[@id=\"form-validate\"]/div[2]/button")
	WebElement RegButton;
	
	@FindBy(id = "advice-required-entry-firstname")
	public WebElement fnameVaildation;
	
	@FindBy(id = "advice-required-entry-lastname")
	public WebElement lnameVaildation;
	
	@FindBy(id = "advice-required-entry-email_address")
	public WebElement Invaildemailvalidation;
	
	@FindBy(css  ="p.required")
	public WebElement Wrongemailvalidation;
	
	@FindBy(id = "advice-required-entry-password")
	public WebElement passwordVaildation;
	
	@FindBy(id = "advice-validate-password-password")
	public WebElement less6daigitpasswordVaildation;
	
	@FindBy(id = "advice-required-entry-confirmation")
	public WebElement confirmepasswordVaildation;
	
	@FindBy(id = "advice-validate-cpassword-confirmation")
	public WebElement matchpasswordvaildation;
	
	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div/ul/li/ul/li/span")
	public WebElement repeatedemailvaildation;

	public void userRegistration(String firstName , String lastName , String email , String password) 
	{
		setTextElementText(fname, firstName);
		setTextElementText(lname, lastName);
		setTextElementText(Email, email);
		setTextElementText(Password, password);
		setTextElementText(confirmation, password);
		clickButton(RegButton);
	}
	public void userRegistrationWithunmatchedpassword(String firstName , String lastName , String email , String password) 
	{
		setTextElementText(fname, firstName);
		setTextElementText(lname, lastName);
		setTextElementText(Email, email);
		setTextElementText(Password, password);
		setTextElementText(confirmation, "aaaaaa");
		clickButton(RegButton);
	}
}
