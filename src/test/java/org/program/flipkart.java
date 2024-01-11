package org.program;

import java.awt.AWTException;
import java.io.IOException;

import org.base.TestNGBase;
import org.openqa.selenium.By;
import org.pom.FlipkartLocator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class flipkart extends TestNGBase {
	String path="C:\\Users\\Balakrishnan G\\Documents\\Book1.xlsx";
	FlipkartLocator locator;
	@BeforeClass
	private void initSetup() {
		browserLaunch("chrome");
		maximizeWindow();
		loadURL("https://www.flipkart.com/");
		
		locator=new FlipkartLocator();
		locator.getPopup().click();
	}
	@Test(retryAnalyzer = Rerunclass.class)
	private void searchPhone() throws IOException, AWTException {
		
		sendingValue(locator.getSearchbox(), excelRead(path, "Sheet1", 1, 1));
		pressKey();
		releaseKey();
		Assert.assertTrue(false);
		clickButton(locator.getIphone15());
		switchWindow(1);
		clickButton(locator.getAddtocart());
		clickButton(locator.getPlaceorder());
	}

}
