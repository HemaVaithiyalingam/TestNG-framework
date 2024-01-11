package org.program;

import java.io.IOException;

import org.base.TestNGBase;
import org.openqa.selenium.interactions.Actions;
import org.pom.Taskpom;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTask extends TestNGBase {
	String path="C:\\Users\\Balakrishnan G\\Documents\\book2.xlsx";
	@BeforeClass
	public void initsetup() {
		browserLaunch("chrome");
		maximizeWindow();
		loadURL("https://demoqa.com/automation-practice-form");
		
	}

	@Test
	public void tc1() throws IOException {
		Taskpom locator=new Taskpom();
		sendingValue(locator.getFirstName(), excelRead(path, "Sheet1", 1, 1));
		sendingValue(locator.getLastName(), excelRead(path, "Sheet1", 1, 2));
		sendingValue(locator.getEmail(), excelRead(path, "Sheet1", 2, 1));
		clickButton(locator.getFemalebutton());
		sendingValue(locator.getPhnumber(), excelRead(path, "Sheet1", 3, 1) );
		
	}
}
