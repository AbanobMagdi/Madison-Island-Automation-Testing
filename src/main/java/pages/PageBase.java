package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver ; 
	public JavascriptExecutor jse ; 
	public Select select ; 
	public Actions action ; 
	// create constructor 
		public PageBase(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		// create function to click
		protected static void clickButton(WebElement button) 
		{
			button.click();
		}
		//create function to set the text to the element
		protected static void setTextElementText(WebElement textElement , String value) 
		{
			textElement.sendKeys(value);
		}
		public void scrollToBottom() 
		// using javascript to scrolling 
		{
			jse.executeScript("scrollBy(0,2500)"); 
		}
		//create clear function 
		public void clearText(WebElement element) 
		{
			element.clear();
		}
		
}
