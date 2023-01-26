package com.herokuapp.theinternet.alertstests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class AlertsTests extends TestUtilities {
	
	@Test
	public void jsAlertTest() {
		log.info("Starting jsAlertTest");
		
		SoftAssert softAssert = new SoftAssert();
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		
		alertsPage.openJSAlert();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.acceptAlert();
		String result = alertsPage.getResultText();
		
		softAssert.assertTrue(alertMessage.equals("I am a JS Alert"), "Alert message is not the expected");
		softAssert.assertTrue(result.equals("You successfully clicked an alert"), "Result message is not the expected. Found: " + result);
		
		softAssert.assertAll();
	}
	
	@Test
	public void jsDismisstTest() {
		log.info("Starting jsDismisstTest");
		
		SoftAssert softAssert = new SoftAssert();
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		
		alertsPage.openJSConfirm();
		String alertMessage = alertsPage.getAlertText();
		alertsPage.dismissAlert();
		String result = alertsPage.getResultText();
		
		softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"), "Alert message is not the expected");
		softAssert.assertTrue(result.equals("You clicked: Cancel"), "Result message is not the expected. Found: " + result);
		
		softAssert.assertAll();
	}
	
	@Test
	public void jsPromptTest() {
		log.info("Starting jsPromptTest");
		
		SoftAssert softAssert = new SoftAssert();
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		
		alertsPage.openJSPrompt();
		String alertMessage = alertsPage.getAlertText() + "intentionalFail";
		String messageTest = "foobar";
		alertsPage.sendKeysToAlert(messageTest);
		String result = alertsPage.getResultText() + "intentionalFail";
		
		softAssert.assertTrue(alertMessage.equals("I am a JS prompt"), "Alert message is not the expected");
		softAssert.assertTrue(result.equals("You entered: " + messageTest), "Result message is not the expected. Found: " + result);
		
		softAssert.assertAll();
	}

}
