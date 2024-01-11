package org.pom;

import org.base.TestNGBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Taskpom extends TestNGBase{
	public Taskpom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstName")
	private WebElement firstName;
	@FindBy(id="lastName")
	private WebElement lastName;
	@FindBy(id="userEmail")
	private WebElement email;
	@FindBy(xpath="(//label[@class='custom-control-label'])[2]")
	private WebElement femalebutton;
	@FindBy(id="userNumber")
	private WebElement phnumber;
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getFemalebutton() {
		return femalebutton;
	}
	public WebElement getPhnumber() {
		return phnumber;
	}
	
}
