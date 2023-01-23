package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownPage extends BasePageObject {
	
	private By dropdownElement = By.id("dropdown");

	public DropDownPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void selectOption(int i) {
		selectOption(dropdownElement, "Option " + i);
	}

	public String getSelectedOption() {
		return getSelectedOption(dropdownElement);
		
	}

	
}
