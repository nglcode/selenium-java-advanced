package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {
	
	private String pageUrl = "https://the-internet.herokuapp.com/secure";
	private By btnLogoutLocator = By.xpath("//a[@class='button secondary radius']");
	private By divMessage = By.id("flash");
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getPageUrl() {
		return pageUrl;
	}
	
	public boolean isLogOutButtonVisible() {
		return isVisible(btnLogoutLocator);
	}
	
	public String getSuccessMessageText() {
		return find(divMessage).getText();
	}
	
	
	
	
	

}
