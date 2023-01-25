package com.herokuapp.theinternet.draganddroptests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DragAndDropTests extends TestUtilities {
	
	@Test
	public void dragAToBTest() {
		log.info("Starting dragAToBTest");
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();
		
		dragAndDropPage.dragAtoB();
		
		sleep(3);
		
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnAText.equals("B"), "Column A header should be B");
		
		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnBText.equals("A"), "Column B header should be A");
		
	}

}
