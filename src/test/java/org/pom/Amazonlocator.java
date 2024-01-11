package org.pom;

import org.base.TestNGBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonlocator extends TestNGBase {
	public Amazonlocator() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "field-keywords")
	private WebElement searchbox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement search;

	@FindBy(xpath = "//span[text()='iPhone 13 (128GB) - (Product) RED']")
	private WebElement iphone;

	@FindBy(xpath = "(//span[text()='50,999'])[5]")
	private WebElement price;

	@FindBy(xpath = "//span[text()='        Apple iPhone 13 (128GB) - (Product) RED       ']")
	private WebElement actualtext;

	public WebElement getActualtext() {
		return actualtext;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getIphone() {
		return iphone;
	}

}
