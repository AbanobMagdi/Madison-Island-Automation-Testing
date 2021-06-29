package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div.page-title")
	public WebElement dashboard;
	
	@FindBy(css = "a.skip-link.skip-account.skip-active")
	public WebElement myaccount;
	
	
}


