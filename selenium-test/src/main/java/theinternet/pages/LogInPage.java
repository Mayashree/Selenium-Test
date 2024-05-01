package theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class LogInPage extends BasePageObject{

	private By usernameLocator = By.id("username");
	private By passwordLocator = By.id("password");
	private By logInButtonLocator = By.className("radius");
	private By errorMessageLocator = By.id("flash");
	
	public LogInPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	public SecureAreaPage logIn(String username, String password) {
		log.info("Executing Login with username ["+ username +"] and password ["+password+"]");
		type(username,usernameLocator);
		type(password,passwordLocator);
		click(logInButtonLocator);
		return new SecureAreaPage(driver,log);
	}
	public void negativeLogIn(String username, String password) {
		log.info("Executing Negative LogIn with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
	}

	/** Wait for error message to be visible on the page */
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, Duration.ofSeconds(5));
	}

	public String getErrorMessageText() {
		return find(errorMessageLocator).getText();
	}


}
