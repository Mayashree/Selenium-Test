package theinternet.fileuploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import theinternet.base.TestUtilities;
import theinternet.pages.FileUploaderPage;
import theinternet.pages.WelcomePage;

public class FileUploadTests extends TestUtilities{

	@Test(dataProvider = "files")
	public void uploadFile(int no, String fileName) {
		log.info("Starting fileUpload test #"+ no + " for "+fileName);

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on JavaScript Alerts link
		FileUploaderPage uploadFilePage = welcomePage.clickFileUploadLink();
		
		// Select file
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
