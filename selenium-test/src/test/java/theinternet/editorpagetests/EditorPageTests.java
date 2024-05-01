package theinternet.editorpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.EditorPage;
import theinternet.pages.WelcomePageObject;

public class EditorPageTests extends TestUtilities {
	@Test
	public void defaultEditorTextValue() {
		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on WYSIWYG Editor link
		EditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();
		
		// Get WYSIWYG Editor default text
		String editorText = editorPage.getEditorText();
		Assert.assertTrue(editorText.equals("Your content goes here."),
				"Editor default text is not equal to expected text " + editorText );

		
	}

}