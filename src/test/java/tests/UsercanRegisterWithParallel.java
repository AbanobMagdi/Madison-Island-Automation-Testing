package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterPage;

public class UsercanRegisterWithParallel extends TestBase2{
	HomePage homeObject ; 
	RegisterPage registerObject;
	MyAccountPage myaccount;
	Faker fakedata = new Faker();
	String fname = fakedata.name().firstName();
	String lname = fakedata.name().lastName();
	String email = fakedata.internet().emailAddress();
	String password = fakedata.internet().password(6, 8);
	@Test(priority = 0)
	// using data facker library to genrate fake data to happy case senarios 
	public void UserCanRegisterSecussfully() throws IOException, ParseException, InterruptedException {
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		registerObject.userRegistration(fname, lname, email, password);
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		myaccount = new MyAccountPage(getDriver());
		Assert.assertTrue(myaccount.dashboard.getText().contains("MY DASHBOARD"));
		homeObject.Logout();
	}
	// using data facker library to genrate fake data to ignore case senarios
	@Test(priority = 1)
	public void UserregisterWithInvaildFname()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter blank into first name text box
		registerObject.userRegistration("", lname, email, password);
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.fnameVaildation.getText().contains("This is a required field."));
		getDriver().navigate().refresh();
	}
	@Test(priority = 2)
	public void UserregisterWithInvaildlname()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter blank into last name text box
		registerObject.userRegistration(fname, "", email, password);
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.lnameVaildation.getText().contains("This is a required field."));
		getDriver().navigate().refresh();
	}
	@Test(priority = 3)
	public void UserregisterWithBlankemail()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter blank into email text box
		registerObject.userRegistration(fname,lname, "", password);
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.Invaildemailvalidation.getText().contains("This is a required field."));
		getDriver().navigate().refresh();
	}
	@Test(priority = 4)
	public void UserregisterWithInvaildlemail()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter invaild schema in email text box
		registerObject.userRegistration(fname, lname, "Aabonmagdy", password);
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.Wrongemailvalidation.getText().contains("Required Fields"));
		getDriver().navigate().refresh();
	}
	@Test(priority = 5)
	public void UserregisterWithInvaildlpassword()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter invaild schema in email text box
		registerObject.userRegistration(fname, lname, email, "");
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.passwordVaildation.getText().contains("This is a required field"));
		getDriver().navigate().refresh();
	}
	@Test(priority = 5)
	public void UserregisterWithInvaildlpasswordLessThan6Digits()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter invaild schema in email text box
		registerObject.userRegistration(fname, lname, email, "123");
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.less6daigitpasswordVaildation.getText().contains("Please enter 6"));
		getDriver().navigate().refresh();
	}
	@Test(priority = 6)
	public void UserregisterWithInvaildlConfiremPassword()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter invaild schema in email text box
		registerObject.userRegistration(fname, lname, email, "");
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.confirmepasswordVaildation.getText().contains("This is a required field"));
		getDriver().navigate().refresh();
	}
	@Test(priority = 7)
	public void UserregisterWithUnMatchedConfiremPassword()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter invaild schema in email text box
		registerObject.userRegistrationWithunmatchedpassword(fname, lname, email, password);
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.matchpasswordvaildation.getText().contains("Please make sure your passwords match."));
		getDriver().navigate().refresh();
	}
	@Test(priority = 8)
	public void UserregisterWithEmailAlreayExistent()
	{
		homeObject = new HomePage(getDriver());
		homeObject.OpenRegistrationPage();
		registerObject = new RegisterPage(getDriver());
		//user enter EmailAlreayExistent text box
		registerObject.userRegistration(fname, lname,email, password);
		System.out.println("The Userr Data is : "+ fname + " " + lname + " " + email + " " + password);
		Assert.assertTrue(registerObject.repeatedemailvaildation.getText().contains("There is already an account with this email address"));
		getDriver().navigate().refresh();
	}
}
