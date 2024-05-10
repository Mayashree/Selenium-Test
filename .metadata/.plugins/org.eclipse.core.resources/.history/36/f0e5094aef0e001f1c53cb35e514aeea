package theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{
	private String pageUrl = "https://the-internet.herokuapp.com/secure";
	private String expectedSuccessMessage = "You logged into a secure area!";
	private By logOutButton = By.xpath("//a[@class='button secondary radius']");
	private By message  = By.id("flash");
	public SecureAreaPage(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}
	/** */
	public String expectedSuccessMessage() {
		return expectedSuccessMessage;
	}
	/** Verification if logout button is visible */
	public boolean isLogOutButtonVisible() {
		return find(logOutButton).isDisplayed();
	}
	/** Return text from success message */
	public String getSuccessMessage() {
		return find(message).getText();
	}
}
