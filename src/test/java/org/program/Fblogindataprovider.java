package org.program;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.base.TestNGBase;
import org.openqa.selenium.WebElement;
import org.pom.FlipkartLocator;
import org.pom.fbloginpage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Fblogindataprovider extends TestNGBase {
	
	@Test(dataProvider="logindata") //dataProviderClass =FlipkartLocator.class
	//incase of diff package=packagename.classname.class==org.pom.FlipkartLocator.class
	public void tc1(Object username,Object passWord) throws IOException {
		browserLaunch("chrome");
		maximizeWindow();
		loadURL("https://www.facebook.com/login/");
		fbloginpage loginpage=new fbloginpage();
		sendingValue(loginpage.getUserName(), (String)username);
		sendingValue(loginpage.getPassword(), passWord.toString());
		clickButton(loginpage.getLoginbtn());
		
	}
	
	@DataProvider(name="logindata")
	public Object[][] dataprovider() {
		Object[][] data=new Object[][] {
			{"hema","bala"},
			{"bala", "979056"},
			{"magizh","140820"}
		};
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}