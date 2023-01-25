package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePageObject {
	
	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By viewProfileLinkLocator = By.linkText("View profile");
//	Alternative:
//	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(), 'View profile')]");

	public HoversPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void openUserProfile(int userID) {
		List<WebElement> avatars = findAll(avatarLocator);
		WebElement specifiedAvatar = avatars.get(userID - 1);
		hoverOverElement(specifiedAvatar);
		specifiedAvatar.findElement(viewProfileLinkLocator).click();		
	}



}
