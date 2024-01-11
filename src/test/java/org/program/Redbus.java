package org.program;

import java.time.Duration;

import org.base.TestNGBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Redbus extends TestNGBase{
	
	@BeforeClass
	public void initsetup() {
		browserLaunch("chrome");
		maximizeWindow();
		loadURL("https://www.redbus.in/");
	}
	@Test(priority = 1)
	public void tc1() throws InterruptedException {
		implicitWait(5);
		sendingValue(findingWebElement("id", "src"), "Chennai");
		driver.findElement(By.xpath("(//div[@class='sc-bdVaJa bpEJck']/following-sibling::ul/child::li[@class='sc-iwsKbI jTMXri'])[1]")).click();
		
		WebElement destination = findingWebElement("xpath", "(//div[@class='sc-ifAKCX gLwVlD'])[2]");
		Actions actions=new Actions(driver);
		actions.sendKeys(destination, "bangalore").perform();
		clickButton(findingWebElement("xpath", "//div[@class='sc-bdVaJa fpFLOj']/following-sibling::ul/child::"
				+ "li[@class='sc-iwsKbI jTMXri cursorPointing']"));
		clickButton(findingWebElement("class", "dateText"));
		clickButton(findingWebElement("xpath", "//text[@class='dateText' and text()='26 Jan']"));
		
			

	}

}
