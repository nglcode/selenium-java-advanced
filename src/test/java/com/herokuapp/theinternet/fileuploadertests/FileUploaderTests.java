package com.herokuapp.theinternet.fileuploadertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class FileUploaderTests extends TestUtilities {
	
	@Test(dataProvider = "files")
	public void fileUploadTest(int number, String filename) {
		log.info("Starting fileUploadTest " + number + " for " + filename);
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploaderLink();
		
		fileUploaderPage.selectFile(filename);
		
		fileUploaderPage.pushUploadButton();
		
		String fileNames = fileUploaderPage.getUploadedFileNames();
		
		Assert.assertTrue(fileNames.contains(filename), "Our file " + filename + "is not one of the uploaded files - " + fileNames);
	}

}
