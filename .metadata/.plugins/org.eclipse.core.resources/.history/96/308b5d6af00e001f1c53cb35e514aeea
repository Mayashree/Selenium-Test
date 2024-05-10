package theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {
	private String pageUrl = "https://the-internet.herokuapp.com/";
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checboxesLinkLocator = By.linkText("Checkboxes");
	private By dropDownLinkLocator = By.linkText("Dropdown");
	private By alertLinkLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowLinkLocator = By.linkText("Multiple Windows");
	private By WYSIWYGEditorLinkLocator = By.linkText("WYSIWYG Editor");
	private By KeyPressesLinkLocator = By.linkText("Key Presses");
	private By FileUploadLinkLocator = By.linkText("File Upload");
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open WelcomePage URL */
	public void openPage() {
		log.info("Opening Page:" + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened");
	}

	/** Open LoginPage by Clicking form Authentication Link Text */
	public LogInPage clickFormAuthenticationLink() {
		log.info("Clicking form Authetication Link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LogInPage(driver, log);
	}

	/** Open CheckBoxes Page by Clicking form CheckBoxes Link Text */

	public CheckBoxesPage clickCheckboxesLink() {
		log.info("Clicking Checkboxes Link on Welcome Page");
		click(checboxesLinkLocator);
		return new CheckBoxesPage(driver, log);
	}

	/** Open DropDown Page by Clicking form DropDown Link Text */
	public DropdownPage clickDropdownLink() {
		log.info("Clicking Dropdown Link on Welcome Page");
		click(dropDownLinkLocator);
		return new DropdownPage(driver, log);
	}

	/** Open Alert Page by Clicking form Alert Link Text */
	public AlertsPage alertLink() {
		log.info("Clicking Alert Link on Welcome Page");
		click(alertLinkLocator);
		return new AlertsPage(driver, log);
	}
	/** Open Multiple Window Page by Clicking form Multiple Window Link Text */
	public MultipleWindowPage clickMultipleWindowLink() {
		log.info("Clicking Multiple Window Link on Welcome Page");
		click(multipleWindowLinkLocator);
		return new MultipleWindowPage(driver, log);
	}
	/** Open WYSIWYG Editor Page by Clicking form WYSIWYG Editor Link Text */
	public EditorPage clickWYSIWYGEditorLink() {
		log.info("Clicking WYSIWYG Editor Link on Welcome Page");
		click(WYSIWYGEditorLinkLocator);
		return new EditorPage(driver, log);
	}
	
	/** Open Key Presses Page by Clicking form Key Presses Link Text */
	public KeyPressesPage clickKeyPressesLink() {
		log.info("Clicking Key Presses Link on Welcome Page");
		click(KeyPressesLinkLocator);
		return new KeyPressesPage(driver, log);
	}
	/** Open File Upload Page by Clicking form File Upload Link Text */
	public FileUploaderPage clickFileUploadLink() {
		log.info("Clicking File Upload Link on Welcome Page");
		click(FileUploadLinkLocator);
		return new FileUploaderPage(driver, log);
	}
	
	
}
