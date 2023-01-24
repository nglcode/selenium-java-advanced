package com.herokuapp.theinternet.fileuploadertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class FileUploaderTests extends TestUtilities {
	
	@Test
	public void imageUploadTest() {
		log.info("Starting imageUploadTest");
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploaderLink();
		
		String filename = "logo.png";
		fileUploaderPage.selectFile(filename);
		
		fileUploaderPage.pushUploadButton();
		
		String fileNames = fileUploaderPage.getUploadedFileNames();
		
		Assert.assertTrue(fileNames.contains(filename), "Our file " + filename + "is not one of the uploaded files - " + fileNames);
	}

}
