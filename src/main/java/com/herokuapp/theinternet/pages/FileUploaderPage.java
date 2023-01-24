package com.herokuapp.theinternet.pages;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {
	
	By choseFileFieldLocator = By.id("file-upload");
	By uploadButtonLocator = By.id("file-submit");
	By uploadedFilesLocator = By.id("uploaded-files");
	

	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void pushUploadButton() {
		log.info("Clicking on upload button");
		click(uploadButtonLocator);
	}
	
	public void selectFile(String filename) {
		log.info("Selecting " + filename + " file from Files folder");
		String resourcePath = new File("src/main/resources/files/" + filename).getAbsolutePath();
		log.info("Resource Path: " + resourcePath);
		type(resourcePath, choseFileFieldLocator);
		log.info("File selected");
	}

	public String getUploadedFileNames() {
		String names = getText(uploadedFilesLocator);
		log.info("Uploaded files: " + names);
		return names;
	}

}
