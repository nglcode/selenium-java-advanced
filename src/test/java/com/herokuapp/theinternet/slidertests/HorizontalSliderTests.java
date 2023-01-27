package com.herokuapp.theinternet.slidertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HorizontalSliderTests extends TestUtilities {
	
	@Test
	public void sliderTest() {
		log.info("Starting sliderTest");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		HorizontalSliderPage horizontalSliderPage = welcomePage.clickHorizontalSliderLink();
		
		Double value = 3.5;
		
		horizontalSliderPage.setSliderTo(value);
		sleep(3);
		
		Double sliderValue = horizontalSliderPage.getSliderValue();
		Assert.assertTrue(sliderValue.equals(value), "Range is not correct.");
	}

}
