package theinternet.sliderspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;
import theinternet.base.TestUtilities;
import theinternet.pages.SlidersPage;
import theinternet.pages.WelcomePage;

public class SlidersPageTests extends TestUtilities{
	@Test
	public void sliderTest() {
		log.info("Starting sliderTest");

		// Open HorizontalSliderPage
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Horizontal Sliders Link
		SlidersPage horizontalSliderPage = welcomePage.sliderLink();

		String value = "3.5";

		// Set slider value
		sleep(2000);
		horizontalSliderPage.setSliderTo(value);
		sleep(2000);

		// Verify slider value
		String sliderValue = horizontalSliderPage.getSliderValue();
		Assert.assertTrue(sliderValue.equals(value), "Range is not correct. It is: " + sliderValue);
	}

}
