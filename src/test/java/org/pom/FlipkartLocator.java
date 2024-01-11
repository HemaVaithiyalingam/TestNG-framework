package org.pom;

import org.base.TestNGBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class FlipkartLocator extends TestNGBase {
	public FlipkartLocator() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@role='button']")
	private WebElement popup;

	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")
	private WebElement searchbox;

	@FindAll({ @FindBy(xpath = "(//div[contains(text(),'Natural')])[1]"), @FindBy(className = "_4rR01T") })
	private WebElement iphone15;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addtocart;
	
	@FindAll({@FindBy(xpath="//span[text()='Place Order']"),@FindBy(xpath="//form[@method='post']")})
	private WebElement placeorder;
	
	//task
	@FindBy(xpath="//div[text()='APPLE iPhone 13 ((PRODUCT)RED, 512 GB)']")
	private WebElement iphone13;
	
	@FindBy(xpath ="(//div[text()='₹87,990'])[1]")
	private WebElement phoneprice;
	
	@FindBy(xpath="//span[text()='APPLE iPhone 13 ((PRODUCT)RED, 512 GB)']")
	private WebElement actualtext;
	
	public WebElement getActualtext() {
		return actualtext;
	}
	
	public WebElement getPhoneprice() {
		return phoneprice;
	}

	public WebElement getIphone13() {
		return iphone13;
	}
	

	public WebElement getPlaceorder() {
		return placeorder;
	}
	public WebElement getPopup() {
		return popup;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getIphone15() {
		return iphone15;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}

}
