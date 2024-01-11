package org.pom;

import org.base.TestNGBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fbloginpage extends TestNGBase {
	public fbloginpage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(id="loginbutton")
	private WebElement loginbtn;
	

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}
	


}
