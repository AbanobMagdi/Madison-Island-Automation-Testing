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
	String firstname = fakedata.name().firstName();
	String lastname = fakedata.name().lastName();
	String email  =fakedata.internet().emailAddress();
	String password = fakedata.internet().password();
	
	@Test
	public void UserCanLoginSuccessfully()
	{
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
	
	
}
