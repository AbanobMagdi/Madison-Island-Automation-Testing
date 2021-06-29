package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
	public HomePage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
	}
	// Fing all element will i need it !!!
	//Detect Account menu elements 
	@FindBy(css = "a.skip-link.skip-account")
	WebElement accountButtun;
	@FindBy(linkText = "Register")
	WebElement registerButton;
	@FindBy(linkText = "Log Out")
	WebElement logout;
	@FindBy(linkText = "My Wishlist")
	WebElement MyWishlist;
	@FindBy(linkText = "My Cart")
	WebElement MyCart;
	@FindBy(linkText = "Checkout ")
	WebElement Checkout;
	@FindBy(linkText = "Log In")
	WebElement login;
	/*********************************************************/
	@FindBy(css = "a.skip-link.skip-cart.no-count")
	WebElement cartlogo;
	/*********************************************************/
	//Detect woman elements
	@FindBy(xpath = "//*[@id=\"nav\"]/ol/li[1]/a")
	WebElement WomanList;
	@FindBy(linkText = "View All Women")
	WebElement ViewAllWomen;
	@FindBy(css = "li.level1.nav-1-1.first")
	WebElement WomanNewArrivals;
	@FindBy(css = "li.level1.nav-1-2")
	WebElement TopsandBlouses;
	@FindBy(css ="li.level1.nav-1-3")
	WebElement WomanPantsAndDenim;
	@FindBy(css ="li.level1.nav-1-4.last")
	WebElement DressesAndSkirts ;
	/*********************************************************/
	//Detect Men elements
	@FindBy(xpath = "//*[@id=\"nav\"]/ol/li[2]/a")
	WebElement MenList;
	@FindBy(linkText = "View All Men")
	WebElement ViewAllMen;
	@FindBy(css = "li.level1.nav-2-1.first")
	WebElement MenNewArrivals;
	@FindBy(css = "li.level1.nav-2-2")
	WebElement Shirts;
	@FindBy(css ="li.level1.nav-2-3")
	WebElement TeesKnitsAndPolos;
	@FindBy(css ="li.level1.nav-2-4")
	WebElement MenPantsAndDenim ;
	@FindBy(css ="li.level1.nav-2-5.last")
	WebElement Blazers ;
	/*********************************************************/
	//Detect Accessories elements
	@FindBy(xpath="//*[@id=\"nav\"]/ol/li[3]/a")
	WebElement AccessoriesList;
	@FindBy(linkText = "View All Accessories")
	WebElement ViewAllAccessories;
	@FindBy(css = "li.level1.nav-3-1.first")
	WebElement Eyewear;
	@FindBy(css = "li.level1.nav-3-2)")
	WebElement Jewelry;
	@FindBy(css = "li.level1.nav-3-3)")
	WebElement Shoes;
	@FindBy(css = "li.level1.nav-3-4.last)")
	WebElement BagsAndLuggage;
	/*********************************************************/
	//Detect Home & Decor elements
	@FindBy(xpath = "//*[@id=\"nav\"]/ol/li[4]/a")
	WebElement HomeAndDecor;
	@FindBy(linkText = "View All Home & Decor")
	WebElement ViewAllHomeAndDecor;
	@FindBy(css = "level1 nav-4-1.first")
	WebElement BooksAndMusic;
	@FindBy(css = "level1 nav-4-2")
	WebElement BedAndBath;
	@FindBy(css = "level1 nav-4-3")
	WebElement Electronics;
	@FindBy(css = "level1 nav-4-4.last")
	WebElement DecorativeAccents;
	/*********************************************************/
	//Detect Sale elements
	@FindBy(xpath = "//*[@id=\"nav\"]/ol/li[5]/a")
	WebElement Sale;
	@FindBy(linkText = "View All Sale")
	WebElement ViewAllSale;
	@FindBy(css = "level1 nav-5-1.first")
	WebElement women;
	@FindBy(css = "level1 nav-5-2")
	WebElement men;
	@FindBy(css = "level1 nav-5-3")
	WebElement accessories;
	@FindBy(css = "level1 nav-5-4.last")
	WebElement homeanddecor;
	/*********************************************************/
	@FindBy(xpath = "//*[@id=\"nav\"]/ol/li[6]/a")
	WebElement Vip;
	/*********************************************************/
	//function to open any page in web site : 
	public void OpenRegistrationPage()

	{
		clickButton(accountButtun);
		action.moveToElement(registerButton).click()
		.build().perform();
	}

	public void OpenVipPage() 
	{
		clickButton(Vip);
	}
	public void OpenWomenCategory(String category)
	{		action.moveToElement(WomanList).build().perform();
	if (ViewAllWomen.getText().equalsIgnoreCase(category)) 
	{
		action.moveToElement(ViewAllWomen).click()
		.build().perform();
	}
	else if (WomanNewArrivals.getText().equalsIgnoreCase(category)) 
	{
		action.moveToElement(WomanNewArrivals).click()
		.build().perform();
	}
	else if (TopsandBlouses.getText().equalsIgnoreCase(category)) 
	{
		action.moveToElement(TopsandBlouses).click()
		.build().perform();
	}
	else if (WomanPantsAndDenim.getText().equalsIgnoreCase(category)) 
	{
		action.moveToElement(WomanPantsAndDenim).click()
		.build().perform();
	}
	else if (DressesAndSkirts.getText().equalsIgnoreCase(category)) 
	{
		action.moveToElement(DressesAndSkirts).click()
		.build().perform();
	}
	}	
	public void OpenMenCategory(String category) {
		action.moveToElement(MenList).build().perform();
		if (ViewAllMen.getText().equalsIgnoreCase(category))
		{
			action.moveToElement(ViewAllMen).click()
			.build().perform();
		}
		else if (MenNewArrivals.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(MenNewArrivals).click()
			.build().perform();
		}
		else if (Shirts.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(Shirts).click()
			.build().perform();
		}
		else if (TeesKnitsAndPolos.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(TeesKnitsAndPolos).click()
			.build().perform();
		}
		else if (MenPantsAndDenim.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(MenPantsAndDenim).click()
			.build().perform();
		}
		else if (Blazers.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(Blazers).click()
			.build().perform();
		}	
	}
	public void OpenAccessoriesCategory(String category) {
		action.moveToElement(AccessoriesList).build().perform();
		if (ViewAllAccessories.getText().equalsIgnoreCase(category))
		{
			action.moveToElement(ViewAllAccessories).click()
			.build().perform();
		}
		else if (Eyewear.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(Eyewear).click()
			.build().perform();
		}
		else if (Jewelry.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(Jewelry).click()
			.build().perform();
		}
		else if (Shoes.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(Shoes).click()
			.build().perform();
		}
		else if (BagsAndLuggage.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(BagsAndLuggage).click()
			.build().perform();
		}	
	}
	public void OpenHomeAndDecorCategory(String category) {
		action.moveToElement(HomeAndDecor).build().perform();
		if (ViewAllHomeAndDecor.getText().equalsIgnoreCase(category))
		{
			action.moveToElement(ViewAllHomeAndDecor).click()
			.build().perform();
		}
		else if (BooksAndMusic.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(BooksAndMusic).click()
			.build().perform();
		}
		else if (BedAndBath.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(BedAndBath).click()
			.build().perform();
		}
		else if (Electronics.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(Electronics).click()
			.build().perform();
		}
		else if (DecorativeAccents.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(DecorativeAccents).click()
			.build().perform();
		}	
	}
	public void OpenSaleCategory(String category) {
		clickButton(Sale);
		if (ViewAllSale.getText().equalsIgnoreCase(category))
		{
			action.moveToElement(ViewAllSale).click()
			.build().perform();
		}
		else if (women.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(women).click()
			.build().perform();
		}
		else if (men.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(men).click()
			.build().perform();
		}
		else if (accessories.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(accessories).click()
			.build().perform();
		}
		else if (homeanddecor.getText().equalsIgnoreCase(category)) 
		{
			action.moveToElement(homeanddecor).click()
			.build().perform();
		}	
	}
	public void Logout()
	{
		clickButton(accountButtun);
		action.moveToElement(logout).click()
		.build().perform();
	}
	public void loginPage() {
		clickButton(accountButtun);
		action.moveToElement(login).click()
		.build().perform();
	}
	public void MyWishListFunction()
	{
		clickButton(accountButtun);
		action.moveToElement(MyWishlist).click()
		.build().perform();
	}
	public void MyCartFunction() {
		clickButton(accountButtun);
		action.moveToElement(MyCart).click()
		.build().perform();
	}
	public void CheckoutFunction() {
		clickButton(accountButtun);
		action.moveToElement(Checkout).click()
		.build().perform();
	}
}

