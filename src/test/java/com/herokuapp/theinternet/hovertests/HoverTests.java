package com.herokuapp.theinternet.hovertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HoverTests extends TestUtilities {

	@Test
	public void user2ProfileTest() {
		log.info("Starting user2ProfileTest");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		HoversPage hoversPage = welcomePage.clickHoversLink();
		
		hoversPage.openUserProfile(2);
		
		Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"), "URL of opened page is not the expected");
	}
}
