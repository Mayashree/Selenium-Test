package theinternet.fileuploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.FileUploaderPage;
import theinternet.pages.WelcomePageObject;

public class FileUploadTests extends TestUtilities{

	@Test
	public void uploadFile() {
		log.info("Starting fileUpload");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on JavaScript Alerts link
		FileUploaderPage uploadFilePage = welcomePage.clickFileUploadLink();
		// Select file
		String fileName = "fruits.png";
		uploadFilePage.selectFile(fileName);

		// Push upload button
		uploadFilePage.pushUploadButton();

		// Get uploaded files
		String fileNames = uploadFilePage.getUploadedFilesNames();

		// Verify selected file uploaded
		Assert.assertTrue(fileNames.contains(fileName),
				"Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
		
		}

}
