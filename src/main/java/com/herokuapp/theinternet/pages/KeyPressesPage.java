package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {
	
	private By body = By.xpath("//body");
	private By resultTextLocator = By.id("result");

	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void pressKey(Keys pressedKey) {
		log.info("Pressing " + pressedKey.name());
		pressKey(body, pressedKey);
	}

	public String getResultText() {
		String result = getText(resultTextLocator);
		log.info("Result text: " + result);
		return result;
	}



}
