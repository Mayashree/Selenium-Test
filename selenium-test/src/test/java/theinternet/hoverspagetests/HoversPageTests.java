package theinternet.hoverspagetests;

import org.testng.Assert;

import theinternet.base.TestUtilities;
import theinternet.pages.HoversPage;
import theinternet.pages.WelcomePage;

public class HoversPageTests extends TestUtilities{
	public void user2ProfileTest() {
		log.info("Starting user2ProfileTest");

		// Open HoversPage
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		//Click on the Hovers Link Text
		HoversPage hoversPage =  welcomePage.hoversLink();

		// Open User 2 profile
		hoversPage.openUserProfile(2);

		// Verify correct user profile opened
		Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"),
				"Url of opened page is not expected User 1 page url");
	}

}
