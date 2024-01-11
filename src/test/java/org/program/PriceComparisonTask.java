package org.program;

import java.awt.AWTException;
import java.util.Scanner;

import org.base.TestNGBase;
import org.pom.Amazonlocator;
import org.pom.FlipkartLocator;
import org.pom.PageManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PriceComparisonTask extends TestNGBase {
	int AmazonPrice;
	int FlipkartPrice;
	Scanner scanner =new Scanner(System.in);
	PageManager pageManager;
	
	@Test(priority = 1,retryAnalyzer = Rerunclass.class)
	public void Amazon() {
		//scanner =new Scanner(System.in);
		pageManager =new PageManager();
		System.out.println("browser to launch=");
		String browser = scanner.nextLine();
		System.out.println("product name=");
		String product = scanner.nextLine();
		browserLaunch(browser);
		maximizeWindow();
		loadURL("https://www.amazon.in/");
	    Amazonlocator locator = pageManager.getAmazonLocator();
		//implicitWait();
		sendingValue(locator.getSearchbox(), product);
		clickButton(locator.getSearch());
		clickButton(locator.getIphone());
		switchWindow(1);
		String Price1 = gettingElementText(locator.getPrice());
		String Priceinamazon = Price1.replace(",", "");
		System.out.println("price of the phone in amazon="+Priceinamazon);
		AmazonPrice=Integer.parseInt(Priceinamazon);
		SoftAssert softassert=new SoftAssert();
		String expected="Apple iPhone 13 (128GB) - (Product) RED";
		String actual = gettingElementText(locator.getActualtext());
		softassert.assertEquals("expected","actual");
		quitBrowser();
	}
	
	@Test(priority = 2,retryAnalyzer = Rerunclass.class)
	public void flipkart() throws AWTException {
		System.out.println("browser to launch=");
		String browser = scanner.nextLine();
		System.out.println("product name=");
		String product = scanner.nextLine();
		browserLaunch(browser);
		maximizeWindow();
		loadURL("https://www.flipkart.com/");
		implicitWait(10);
		FlipkartLocator locator = pageManager.getFlipkartLocator();
		//clickButton(locator.getPopup());
		sendingValue(locator.getSearchbox(), product);
		pressKey();
		releaseKey();
		clickButton(locator.getIphone13());
		switchWindow(1);
		String priceinflipkart = gettingElementText(locator.getPhoneprice());
		String replace = priceinflipkart.replace(",", "");
		String price1 = replace.replace("₹", "");
		System.out.println("price in flipkart="+price1);
		SoftAssert softassert=new SoftAssert();
		boolean displayed = locator.getActualtext().isDisplayed();
		softassert.assertTrue(displayed);
		FlipkartPrice=Integer.parseInt(price1);
		quitBrowser();
	}
	
	@Test(priority = 3)
	public void pricecomparison() {
	     
		if(AmazonPrice<FlipkartPrice) {
			System.out.println("It is best to buy iphone 13 in Amazon");
		}else {
			System.out.println("The price of the phone is cheaper in flipkart");
		}
		
	}
	
}
	
	