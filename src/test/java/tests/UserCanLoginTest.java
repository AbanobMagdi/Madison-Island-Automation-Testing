package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;

public class UserCanLoginTest extends TestBase{
	HomePage homeobject ;
	RegisterPage registerobject;
	LoginPage loginobject;
	MyAccountPage myaccount;
	Faker fakedata =new Faker();	
	@Test
	public void UserCanLoginSuccessfully()
	{
		String firstname = fakedata.name().firstName();
		String lastname = fakedata.name().lastName();
		String email  =fakedata.internet().emailAddress();
		String password = fakedata.internet().password();
		myaccount = new MyAccountPage(driver);
		registerobject = new RegisterPage(driver);
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject.userRegistration(firstname, lastname, email, password);
		System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
		homeobject.Logout();
		homeobject.loginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserCanLogin(email, password);
		try {
			Assert.assertTrue(myaccount.dashboard.getText().contains("MY DASHBOARD"));
		} catch (Exception e) {
			System.out.println(myaccount.dashboard.getText());
		}
		homeobject.Logout();
	}

	@Test()
	public void UserLoginWithInvaildEmail() {
		String firstname = fakedata.name().firstName();
		String lastname = fakedata.name().lastName();
		String email  =fakedata.internet().emailAddress();
		String password = fakedata.internet().password();
		registerobject = new RegisterPage(driver);
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject.userRegistration(firstname, lastname, email, password);
		System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
		homeobject.Logout();
		homeobject.loginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserCanLogin("Test@gamail.com", password);
		try {
			Assert.assertTrue(loginobject.InCorrectVaildation.getText().contains("Required Fields"));
		} catch (Exception e) {
			System.out.println(loginobject.InCorrectVaildation.getText());
		}
	}
	@Test()
	public void UserLoginWithInvaildPassword() {
		String firstname = fakedata.name().firstName();
		String lastname = fakedata.name().lastName();
		String email  =fakedata.internet().emailAddress();
		String password = fakedata.internet().password();
		registerobject = new RegisterPage(driver);
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject.userRegistration(firstname, lastname, email, password);
		System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
		homeobject.Logout();
		homeobject.loginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserCanLogin(email, "123456");
		try {
			Assert.assertTrue(loginobject.InCorrectVaildation.getText().contains("Required Fields"));
		} catch (Exception e) {
			System.out.println(loginobject.InCorrectVaildation.getText());
		}
	}
	@Test()
	public void UserLoginWithInvaildPasswordAndEmail() {
		String firstname = fakedata.name().firstName();
		String lastname = fakedata.name().lastName();
		String email  =fakedata.internet().emailAddress();
		String password = fakedata.internet().password();
		registerobject = new RegisterPage(driver);
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject.userRegistration(firstname, lastname, email, password);
		System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
		homeobject.Logout();
		homeobject.loginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserCanLogin("", "");
		try {
			Assert.assertTrue(loginobject.EmailVaildation.getText().contains("This is a required field."));
			Assert.assertTrue(loginobject.passwordVaildation.getText().contains("This is a required field."));
			
		} catch (Exception e) {
			System.out.println(loginobject.InCorrectVaildation.getText());
		}
	}
}
