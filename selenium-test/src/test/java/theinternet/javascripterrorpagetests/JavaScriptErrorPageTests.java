package theinternet.javascripterrorpagetests;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.logging.LogEntry;
import theinternet.base.TestUtilities;
import theinternet.pages.JavaScriptErrorPage;
import theinternet.pages.WelcomePage;

public class JavaScriptErrorPageTests extends TestUtilities{
	@Test
	public void jsErrorTest() {
	
		SoftAssert softAssert = new SoftAssert();

		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();
		// Click JSErrorPage Link
		JavaScriptErrorPage jSErrorPage = welcomePage.jsErrorLink();
		softAssert.assertEquals(jSErrorPage.getCurrentUrl(),"https://the-internet.herokuapp.com/javascript_error");

		// Get logs
		List<LogEntry> logs = getBrowserLogs();

		// Verifying there are no JavaScript errors in console
		for (LogEntry logEntry : logs) {
			if (logEntry.getLevel().toString().equals("SEVERE")) {
				softAssert.fail("Severe error: " + logEntry.getMessage());
			}
		}
		softAssert.assertAll();
	}

}
