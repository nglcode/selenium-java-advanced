package com.herokuapp.theinternet.base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {

		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver.set(new FirefoxDriver(firefoxOptions));
			break;
		case "chromeheadless":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver.set(new ChromeDriver());
			break;
		case "firefoxheadless":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			FirefoxOptions firefoxHeadlessOptions = new FirefoxOptions();
			firefoxHeadlessOptions.setBinary(new FirefoxBinary(pathToBinary));
			firefoxHeadlessOptions.setHeadless(true);
			driver.set(new FirefoxDriver(firefoxHeadlessOptions));
			break;
		case "phantomjs":
			System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
			driver.set(new PhantomJSDriver());
			break;
		case "htmlunit":
			driver.set(new HtmlUnitDriver());
			break;
		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}

	public WebDriver createChromeWithMobileEmulation(String deviceName) {
		log.info("Starting driver with " + deviceName + " emulation");
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", deviceName);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}

}
