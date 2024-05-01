package theinternet.dropdownpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.DropdownPage;
import theinternet.pages.WelcomePageObject;

public class DropDownTests extends TestUtilities {
	@Test
	public void testBothDropDown() {
		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on DropDown link
		DropdownPage dropdownPage = welcomePage.clickDropdownLink();

		DropdownPage dropDownPage = new DropdownPage(driver, log);
		int countOptions = dropDownPage.getOptionCount();
		for (int i = 1; i < countOptions; i++) {
			log.info("Starting option" + i + "Test");
			// Select Option 2
			dropdownPage.selectOption(i);

			// Verify Option 2 is selected
			String selectedOption = dropdownPage.getSelectedOption();
			Assert.assertTrue(selectedOption.equals("Option "+i),
					"Option "+ i +" is not selected. Instead selected - " + selectedOption);

		}

	}

}
