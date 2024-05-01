package theinternet.multiplewindowpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.MultipleWindowPage;
import theinternet.pages.NewWindowPage;
import theinternet.pages.WelcomePageObject;

public class MultipleWindowstests extends TestUtilities {
	@Test
	public void newWindowTest() {
		log.info("Starting newWindowTest");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on MultipleWindows link
		MultipleWindowPage multipleWindowsPage = welcomePage.clickMultipleWindowLink();

		// Click 'Click Here' link to open new window
		multipleWindowsPage.openNewWindow();
		sleep(1000);

		// Find and switch to new window page
		NewWindowPage newWindowPage = multipleWindowsPage.switchToNewWindowPage();
		String pageSource = newWindowPage.getCurrentPageSource();

		// Verification that new page contains expected text in source
		Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
	
	}

}
