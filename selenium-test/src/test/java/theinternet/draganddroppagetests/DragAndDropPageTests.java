package theinternet.draganddroppagetests;

import org.testng.Assert;
import org.testng.annotations.Test;
import theinternet.base.TestUtilities;
import theinternet.pages.DragAndDropPage;
import theinternet.pages.WelcomePage;

public class DragAndDropPageTests extends TestUtilities {

	@Test
	public void dragAToBTest() {
		log.info("Starting dragAToBTest");

		// Open DragAndDropPage
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Drag and Drop Link Text on WelcomePage
		DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();

		// Drag box A and drop it on box B
		dragAndDropPage.dragAtoB();

		// Verify correct headers in correct boxes
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnBText.equals("A"), "Column A header should be B, but it is: " + columnBText);
	}

}
