package org.program;

import java.io.IOException;

import org.base.TestNGBase;
import org.openqa.selenium.WebElement;
import org.pom.AdactinResultLocator;
import org.pom.Adactinglocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Adacting extends TestNGBase {
	String path = "C:\\Users\\Balakrishnan G\\Documents\\Book1.xlsx";
	static Adactinglocator locator;
	String snap = null;

	@BeforeClass
	@Parameters({"browser","url"})
	public static void initsetup(String browser, String url) {

		browserLaunch(browser);
		maximizeWindow();
		loadURL(url);
		locator = new Adactinglocator();
	}

	@AfterClass(enabled =true)
	public static void exitconfig() {
		quitBrowser();
	}

	@AfterMethod
	public void aft() throws InterruptedException, IOException {
		String filePath = ("C:\\Users\\Balakrishnan G\\eclipse-workspace\\ProjectTestNG\\target\\" + snap + ".png");
		screenshot(filePath);

	}

	@Test
	@Parameters({"name","password"})
	public void tc1(String name, String password) throws IOException {

		String expected = "Welcome to Adactin Group of Hotels";
		sendingValue(locator.getUsername(), name);
		sendingValue(locator.getPassword(), password);
		clickButton(locator.getLoginbtn());
		AdactinResultLocator resultlocator = new AdactinResultLocator();
		String actual = gettingElementText(resultlocator.getResulttc1());
		Assert.assertEquals(expected, actual);
		snap = "tc1";
	}

	@Test
	@Parameters({"checkindate","checkoutdate"})
	public void tc2(String checkindate,String checkoutdate) throws IOException {

		dropdownSelect(locator.getLocation(), "value", "Melbourne");
		dropdownSelect(locator.getHotels(), "visibleText", "Hotel Sunshine");
		dropdownSelect(locator.getRoomType(), "index", "3");
		dropdownSelect(locator.getRoomNos(), "value", "2");

		WebElement checkin = locator.getCheckin();
		checkin.clear();
		sendingValue(checkin, checkindate);

		WebElement checkout = locator.getCheckout();
		checkout.clear();
		sendingValue(checkout, checkoutdate);
		dropdownSelect(locator.getAdult(), "value", "2");
		dropdownSelect(locator.getChild(), "index", "1");
		clickButton(locator.getSearchBtn());
		AdactinResultLocator resultlocator = new AdactinResultLocator();
		boolean displayed = resultlocator.getResulttc2().isDisplayed();
		Assert.assertTrue(displayed);
		snap = "tc2";

	}

	@Test
	public void tc3() {
		String expected1 = "Book A Hotel";
		clickButton(locator.getRadiobtn());
		clickButton(locator.getContinueBtn());
		AdactinResultLocator resultlocator = new AdactinResultLocator();
		String actual1 = gettingElementText(resultlocator.getResulttc3());
		Assert.assertEquals(expected1, actual1);
		snap = "tc3";
	}

	@Test
	public void tc4() throws IOException, InterruptedException {
		sendingValue(locator.getFirstname(), excelRead(path, "Sheet3", 0, 4));
		sendingValue(locator.getLastname(), excelRead(path, "Sheet3", 0, 5));
		sendingValue(locator.getAddress(), excelRead(path, "Sheet3", 0, 6));
		sendingValue(locator.getCard(), excelRead(path, "Sheet3", 0, 7));

		dropdownSelect(locator.getCardtype(), "value", "VISA");
		dropdownSelect(locator.getExpiryMonth(), "value", "10");
		dropdownSelect(locator.getExpiryYear(), "value", "2028");
		sendingValue(locator.getCvv(), excelRead(path, "Sheet3", 0, 8));
		clickButton(locator.getBooknowBtn());
		Thread.sleep(5000);
		clickButton(locator.getItinerary());

		String expected2 = "Booked Itinerary  ";
		AdactinResultLocator resultlocator = new AdactinResultLocator();
		String actual2 = gettingElementText(resultlocator.getResulttc4());
		Assert.assertNotEquals(expected2, actual2);
		snap = "tc4";
	}
	

	@Test
	public void tc5() throws IOException {
		sendingValue(locator.getSearchbox(), excelRead(path, "Sheet3", 0, 9));
		clickButton(locator.getGobtn());
		String attributeValue1 = getAttributeValue(locator.getPricepernight(), "value");
		System.out.println("price per night="+attributeValue1);
		String attributeValue2 = getAttributeValue(locator.getPrice(), "value");
		System.out.println("Total price="+attributeValue2);
		
		snap = "tc5";
	}

}
