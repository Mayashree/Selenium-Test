package theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.LogInPage;
import theinternet.pages.WelcomePage;

public class NegativeLogInTests extends TestUtilities {
	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");
		LogInPage logInPage = new LogInPage(driver, log);
		WelcomePage welcomePage = new WelcomePage(driver, log);

		/** Open Main Page */
		welcomePage.openPage();

		/** Click on Form Authentication link */
		logInPage = welcomePage.clickFormAuthenticationLink();

		/** enter userName and password */
		logInPage.negativeLogIn(username, password);

		// Verification
		String actualErrorMessage = logInPage.getErrorMessageText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}

}
