package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {
	
	private String pageUrl = "https://the-internet.herokuapp.com/";
	
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkboxesLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By jsAlertsLinkLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
	private By WYSIWYGEditorLinkLocator = By.linkText("WYSIWYG Editor");
	private By keyPressesLinkLocator = By.linkText("Key Presses");
	private By fileUploaderLinkLocator = By.linkText("File Upload");
	private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
	private By hoversLinkLocator = By.linkText("Hovers");
	private By horizontalSliderLinkLocator = By.linkText("Horizontal Slider");
	private By jsErrorLinkLocator = By.linkText("JavaScript onload event error");

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened.");
	}
	
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}
	
	public CheckboxesPage clickCheckboxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page");
		click(checkboxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}

	public DropDownPage clickDropdownLink() {
		log.info("Clicking Dropdown link on Welcome Page");
		click(dropdownLinkLocator);
		return new DropDownPage(driver, log);
	}

	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
		log.info("Clicking JS Alerts link on Welcome Page");
		click(jsAlertsLinkLocator);
		return new JavaScriptAlertsPage(driver, log);		
	}

	public WindowsPage clickMultipleWindowsLink() {
		log.info("Clicking Multiple Windows link on Welcome Page");
		click(multipleWindowsLinkLocator);
		return new WindowsPage(driver, log);
	}

	public EditorPage clickWYSIWYGEditorLink() {
		log.info("Clicking WYSIWYG Editor link on Welcome Page");
		click(WYSIWYGEditorLinkLocator);
		return new EditorPage(driver, log);
	}
	
	public KeyPressesPage clickKeyPressesLink() {
		log.info("Clicking Key Presses link on Welcome Page");
		click(keyPressesLinkLocator);
		return new KeyPressesPage(driver, log);
	}
	
	public FileUploaderPage clickFileUploaderLink() {
		log.info("Clicking File Uploader link on Welcome Page");
		click(fileUploaderLinkLocator);
		return new FileUploaderPage(driver, log);
	}

	public DragAndDropPage clickDragAndDropLink() {
		log.info("Clicking Drag and Drop link on Welcome Page");
		click(dragAndDropLinkLocator);
		return new DragAndDropPage(driver, log);
	}

	public HoversPage clickHoversLink() {
		log.info("Clicking Hovers link on Welcome Page");
		click(hoversLinkLocator);
		return new HoversPage(driver, log);
	}

	public HorizontalSliderPage clickHorizontalSliderLink() {
		log.info("Clicking Horizontal Slider link on Welcome Page");
		click(horizontalSliderLinkLocator);
		return new HorizontalSliderPage(driver, log);
	}

	public JSErrorPage clickJsErrorLink() {
		log.info("Clicking JS Error link on Welcome Page");
		click(jsErrorLinkLocator);
		return new JSErrorPage(driver, log);
	}


	
	

}
