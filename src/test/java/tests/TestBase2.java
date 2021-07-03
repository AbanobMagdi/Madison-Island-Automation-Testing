package tests;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilties.Helper;


public class TestBase2 {
	public static String BaseURL = "http://magento-demo.lexiconn.com/";
	protected ThreadLocal<RemoteWebDriver> driver = null;
	@BeforeClass
	@Parameters(value = {"browser"})
	public void Setup(@Optional("chrome")String browser) throws MalformedURLException {
		driver =new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(BaseURL);
	}
	public WebDriver getDriver()
	{
		return driver.get();
	}
	@AfterClass
	public void stopDriver()
	{
		getDriver().quit();
		driver.remove();
	}
	// take screenshot when test case fail and add it in the Screenshot folder
		@AfterMethod
		public void screenshotOnFailure(ITestResult result) 
		{
			if (result.getStatus() == ITestResult.FAILURE)
			{
				System.out.println("Failed!");
				System.out.println("Taking Screenshot....");
				Helper.captureScreenshot(getDriver(), result.getName());
			}
		}
}
