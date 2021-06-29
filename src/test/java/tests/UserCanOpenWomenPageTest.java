package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class UserCanOpenWomenPageTest extends TestBase {
	HomePage homeObject ; 
	@Test
	public void OpenWomanPageTest()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenWomenCategory("new arrivals");
	}

}
