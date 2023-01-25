package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage extends BasePageObject {
	
	private By rangeLocator = By.id("range");
	private By sliderLocator = By.tagName("input");

	public HorizontalSliderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void setSliderTo(Double value) {
		log.info("Moving slider to " + Double.toString(value));
		
		// Alternative 1 - not working as expected
//		int width = find(sliderLocator).getSize().getWidth();
//		int xOffSet = (int) (width * (value / 5));
//		Actions action = new Actions(driver);
//		action.dragAndDropBy(find(sliderLocator), 29, 0).build().perform();
		
		// Alternative 2
		int steps = (int) (value / 0.5);
		pressKey(sliderLocator, Keys.ENTER);
		for (int i = 0; i < steps; i++) {
			pressKey(sliderLocator, Keys.ARROW_RIGHT);
		}
		
	}

	public Double getSliderValue() {
		Double value = Double.parseDouble(find(rangeLocator).getText());
		log.info("Slider value is " + value);
		return value;
	}

}
