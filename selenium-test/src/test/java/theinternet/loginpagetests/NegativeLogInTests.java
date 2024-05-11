package theinternet.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import theinternet.base.CsvDataProviders;
import theinternet.base.TestUtilities;
import theinternet.pages.LogInPage;
import theinternet.pages.WelcomePage;

public class NegativeLogInTests extends TestUtilities {
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInTest(Map<String, String> testData) {
		// Data
		//String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		//String description = testData.get("description");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		/** Click on Form Authentication link */
		LogInPage logInPage = welcomePage.clickFormAuthenticationLink();

		/** enter userName and password */
		logInPage.negativeLogIn(username, password);

		// Verification
		String actualErrorMessage = logInPage.getErrorMessageText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}

}
