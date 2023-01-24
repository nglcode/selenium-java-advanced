package com.herokuapp.theinternet.keypressestests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class KeyPressesTests extends TestUtilities {
	
	
	@Test
	public void pressKeyTest() {
		log.info("Starting pressKeyTest");
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();
		keyPressesPage.pressKey(Keys.ENTER);
		
		String result = keyPressesPage.getResultText();
		
		Assert.assertTrue(result.equals("You entered: ENTER"), "Result is not expected. Found: " + result);
		
	}
	
	@Test
	public void pressKeyWithActionsTest() {
		log.info("Starting pressKeyWithActionsTest");
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();
		keyPressesPage.pressKeyWithActions(Keys.SPACE);
		
		String result = keyPressesPage.getResultText();
		
		Assert.assertTrue(result.equals("You entered: SPACE"), "Result is not expected. Found: " + result);
		
	}

}
