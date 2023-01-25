package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {
	
	private By columnA = By.id("column-a");
	private By columnB = By.id("column-b");
	

	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void dragAtoB() {
		log.info("Drag and drop A box into B box");	
		performDragAndDrop(columnA, columnB);
	}

	public String getColumnAText() {
		log.info("Drag and drop A box into B box");
		String text = getText(columnA);
		log.info("Column A text: " + text);
		return text;
	}

	public String getColumnBText() {
		String text = getText(columnB);
		log.info("Column B text: " + text);
		return text;
	}
	
}
