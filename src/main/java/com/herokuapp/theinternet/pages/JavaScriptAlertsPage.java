package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject {
	
	private By jsAlertButtonLocator = By.xpath("//button[contains(text(), 'JS Alert')]");
	private By jsConfirmButtonLocator = By.xpath("//button[contains(text(), 'JS Confirm')]");
	private By jsPromptButtonLocator = By.xpath("//button[contains(text(), 'JS Prompt')]");
	private By resultTextLocator = By.id("result");


	public JavaScriptAlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openJSAlert() {
		log.info("Clicking on JS Alert button");
		click(jsAlertButtonLocator);
	}
	
	public void openJSConfirm() {
		log.info("Clicking on JS Confirm button");
		click(jsConfirmButtonLocator);
	}
	
	public void openJSPrompt() {
		log.info("Clicking on JS Prompt button");
		click(jsPromptButtonLocator);
	}
	
	public String getAlertText() {
		String alertText = switchToAlert().getText();
		log.info("Alert text: " + alertText);
		return alertText;
	}

	public void acceptAlert() {
		log.info("Switching to alert and pressing OK");
		switchToAlert().accept();
	}
	
	public void dismissAlert() {
		log.info("Switching to alert and pressing Cancel");
		switchToAlert().dismiss();
	}
	
	public void sendKeysToAlert(String text) {
		log.info("Sending keys to alert: " + text);
		switchToAlert().sendKeys(text);
		switchToAlert().accept();
	}

	public String getResultText() {
		String resultText = getText(resultTextLocator);
		log.info("Result text: " + resultText);
		return resultText;
	}

}
