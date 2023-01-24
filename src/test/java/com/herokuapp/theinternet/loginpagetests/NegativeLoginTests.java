package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {


	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// enter username and password
		String errorMessage = loginPage.negativeLogIn(username, password);

		// Verification
		Assert.assertTrue(errorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + errorMessage);
	}



}
