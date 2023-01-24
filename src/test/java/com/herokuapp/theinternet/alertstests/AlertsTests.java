package com.herokuapp.theinternet.alertstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class AlertsTests extends TestUtilities {
	
	@Test
	public void jsAlertTest() {
		log.info("Starting jsAlertTest");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		
		alertsPage.openJSAlert();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.acceptAlert();
		String result = alertsPage.getResultText();
		
		Assert.assertTrue(alertMessage.equals("I am a JS Alert"), "Alert message is not the expected");
		Assert.assertTrue(result.equals("You successfully clicked an alert"), "Result message is not the expected. Found: " + result);
	}
	
	@Test
	public void jsDismisstTest() {
		log.info("Starting jsDismisstTest");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		
		alertsPage.openJSConfirm();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.dismissAlert();
		String result = alertsPage.getResultText();
		
		Assert.assertTrue(alertMessage.equals("I am a JS Confirm"), "Alert message is not the expected");
		Assert.assertTrue(result.equals("You clicked: Cancel"), "Result message is not the expected. Found: " + result);
	}
	
	@Test
	public void jsPromptTest() {
		log.info("Starting jsPromptTest");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		
		alertsPage.openJSPrompt();
		String alertMessage = alertsPage.getAlertText();
		String messageTest = "foobar";
		alertsPage.sendKeysToAlert(messageTest);
		String result = alertsPage.getResultText();
		
		Assert.assertTrue(alertMessage.equals("I am a JS prompt"), "Alert message is not the expected");
		Assert.assertTrue(result.equals("You entered: " + messageTest), "Result message is not the expected. Found: " + result);
	}

}
