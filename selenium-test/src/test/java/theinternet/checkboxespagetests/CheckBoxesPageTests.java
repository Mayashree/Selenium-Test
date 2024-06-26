package theinternet.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.CheckBoxesPage;
import theinternet.pages.WelcomePage;


public class CheckBoxesPageTests extends TestUtilities{
	@Test
	public void selectingTwoCheckboxesTest() {
	
	/** open main page */
	WelcomePage welcomePage = new WelcomePage(driver, log);
	welcomePage.openPage();
	
	/** Click on the checkBox Link Text */
	welcomePage.clickCheckboxesLink();
	
	/** Click on all the checkBoxes */
	CheckBoxesPage checkBoxPage = new CheckBoxesPage(driver,log);
	checkBoxPage.selectAllCheckboxes();
	 
	/** Verify if the checkBoxes are checked */
	Assert.assertTrue(checkBoxPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
	
	}
}
