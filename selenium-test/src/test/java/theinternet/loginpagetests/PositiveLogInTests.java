package theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.LogInPage;
import theinternet.pages.SecureAreaPage;
import theinternet.pages.WelcomePage;

public class PositiveLogInTests extends TestUtilities{
	@Test
	public void logInTest() {
		log.info("Starting logIn test");
		WelcomePage welcomePage = new WelcomePage(driver,log);
			
		/** Open main page */
		welcomePage.openPage();
		log.info("Main page is opened.");

		/** Click on Form Authentication link */
		LogInPage logInPage = welcomePage.clickFormAuthenticationLink();

		/** Execute Login */
		SecureAreaPage securePage = logInPage.logIn("tomsmith", "SuperSecretPassword!");

		/** Verifications
		 new URL */
		String expectedUrl = securePage.getPageUrl();
		Assert.assertEquals(securePage.getCurrentUrl(), expectedUrl);

		/** Log out button is visible */
		Assert.assertTrue(securePage.isLogOutButtonVisible(),"logOutButton is not visible.");

		/** Successful log in message */
		String expectedSuccessMessage = securePage.expectedSuccessMessage();
		String actualSuccessMessage = securePage.getSuccessMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}

}
