package org.west;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.LibGlobal;
import pageFactory.SelectTrip;

public class WestJet extends LibGlobal {
	@BeforeClass
	public void browserLaunch() {
		getDriver();
		loadUrl("https://www.westjet.com/en-ca");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	@AfterClass
	public void quitBrowser() {
		quit();
	}
	@Test
	public void login() throws InterruptedException {
		
		SelectTrip selectTrip = new SelectTrip();

		selectTrip.loginClose();
				
	
	}
	

}
