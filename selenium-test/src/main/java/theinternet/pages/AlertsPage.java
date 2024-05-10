package theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage{

	public AlertsPage(WebDriver driver, Logger log) {
		
		super(driver,log);
	}
	private By jsAlertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
	private By jsConfirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
	private By jsPromptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
	private By resultMessageLocator = By.id("result");

	
	/** Clicking on 'Click for JS Alert' button to open alert */
	public void openJSAlert() {
		log.info("Clicking on 'Click for JS Alert' button to open alert");
		click(jsAlertButtonLocator);

	}

	/** Clicking on 'Click for JS Confirm' button to open alert */
	public void openJSConfirm() {
		log.info("Clicking on 'Click for JS Confirm' button to open alert");
		click(jsConfirmButtonLocator);
	}

	/** Clicking on 'Click for JS Prompt' button to open alert */
	public void openJSPrompt() {
		log.info("Clicking on 'Click for JS Prompt' button to open alert");
		click(jsPromptButtonLocator);
	}

	/** Switch to alert and get it's message */
	public String getAlertText() {
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		log.info("Alert says: " + alertText);
		return alertText;
	}

	/** Switch to alert and press OK */
	public void acceptAlert() {
		log.info("Switching to alert and pressing OK");
		Alert alert = switchToAlert();
		alert.accept();
	}

	/** Switch to alert and press Cancel */
	public void dismissAlert() {
		log.info("Switching to alert and pressing Cancel");
		Alert alert = switchToAlert();
		alert.dismiss();
	}

	/** Type text into alert and press OK */
	public void typeTextIntoAlert(String text) {
		log.info("Typing text into alert and pressing OK");
		Alert alert = switchToAlert();
		alert.sendKeys(text);
		alert.accept();
	}

	/** Get result text */
	public String getResultText() {
		String result = find(resultMessageLocator).getText();
		log.info("Result text: " + result);
		return result;
	}

}
