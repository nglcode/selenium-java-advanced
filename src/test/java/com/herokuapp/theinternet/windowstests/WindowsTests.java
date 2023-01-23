package com.herokuapp.theinternet.windowstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.WindowsPage;

public class WindowsTests extends TestUtilities {
	
	
	@Test
	public void newWindowTest() {
		log.info("Starting newWindowTest");
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		WindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();
		windowsPage.openNewWindow();
		
		NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();
		
		String pageSource = newWindowPage.getCurrentPageSource();
		Assert.assertTrue(pageSource.contains("New Window"), "New page source does not contains New Window");
	}

}
