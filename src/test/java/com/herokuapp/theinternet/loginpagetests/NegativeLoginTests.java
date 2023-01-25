package com.herokuapp.theinternet.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {


//	@Parameters({ "username", "password", "expectedMessage" })  // Parameters commented due to DataProvider implementation
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInTest(Map<String, String> testData) {
		
		//data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLogInTest " + no + " for " + description);
		
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
