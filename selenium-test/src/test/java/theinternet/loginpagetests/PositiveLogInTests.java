package theinternet.loginpagetests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.LogInPage;
import theinternet.pages.SecureAreaPage;
import theinternet.pages.WelcomePage;

public class PositiveLogInTests extends TestUtilities {
	@Test
	public void logInTest() {

		WelcomePage welcomePage = new WelcomePage(driver, log);
		/** Open main page */
		welcomePage.openPage();
		takeScreenshot("WelcomePage opened");

		/** Click on Form Authentication link */
		LogInPage logInPage = welcomePage.clickFormAuthenticationLink();
		takeScreenshot("LoginPage opened");

		// Add new cookie
		Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
		logInPage.setCookie(ck);

		/** Execute Login */
		SecureAreaPage securePage = logInPage.logIn("tomsmith", "SuperSecretPassword!");
		takeScreenshot("SecureAreaPage opened");

		// Get cookies
		String username = securePage.getCookie("username");
		log.info("Username cookie: " + username);
		String session = securePage.getCookie("rack.session");
		log.info("Session cookie: " + session);
		/**
		 * Verifications new URL
		 */
		String expectedUrl = securePage.getPageUrl();
		Assert.assertEquals(securePage.getCurrentUrl(), expectedUrl);

		/** Log out button is visible */
		Assert.assertTrue(securePage.isLogOutButtonVisible(), "logOutButton is not visible.");

		/** Successful log in message */
		String expectedSuccessMessage = securePage.expectedSuccessMessage();
		String actualSuccessMessage = securePage.getSuccessMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}

}
