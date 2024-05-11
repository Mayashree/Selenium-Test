package theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SlidersPage extends BasePage{

	private By rangeLocator = By.id("range");
	private By sliderLocator = By.tagName("input");
	public SlidersPage(WebDriver driver,Logger log) {
		super(driver,log);
		
	}
	/** Move slider to specified value */
	public void setSliderTo(String value) {
		log.info("Moving slider to " + value);
		int steps = (int) (Double.parseDouble(value) / 0.5);

		// Perform steps
		pressKey(sliderLocator, Keys.ENTER);
		for (int i = 0; i < steps; i++) {
			pressKey(sliderLocator, Keys.ARROW_RIGHT);
		}
	}
	/** Getting slider value */
	public String getSliderValue() {
		String value = find(rangeLocator).getText();
		log.info("Slider value is " + value);
		return value;
	}

}
