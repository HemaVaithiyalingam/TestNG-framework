package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class TestNGBase {

	public static WebDriver driver;
	public static WebElement element;

	public static void browserLaunch(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
		}
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static void loadURL(String url) {
		driver.get(url);
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void navigateWebpage(String value) {
		if (value.equals("refresh")) {
			driver.navigate().refresh();
		} else if (value.equals("back")) {
			driver.navigate().back();
		} else if (value.equals("forward")) {
			driver.navigate().forward();

		}
	}

	public static WebElement findingWebElement(String locator, String value) {
		if (locator.equals("id")) {
			element = driver.findElement(By.id(value));
		} else if (locator.equals("name")) {
			element = driver.findElement(By.name(value));
		} else if (locator.equals("className")) {
			element = driver.findElement(By.className(value));
		} else if (locator.equals("xpath")) {
			element = driver.findElement(By.xpath(value));
		} else if (locator.equals("tag name")) {
			element = driver.findElement(By.tagName(value));

		}
		return element;
	}

	public static void sendingValue(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void clickButton(WebElement element) {
		element.click();
	}

	public static void clearMethod() {
		element.clear();
	}

	public static String gettingElementText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public static String getAttributeValue(WebElement element, String name) {
		String attributeValue = element.getAttribute(name);
		return attributeValue;
	}
	
	public static void screenshot(String path) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		Files.copy(source, new File(path));
	}
	
	public static void dropdownSelect(WebElement element,String selectBy, String value) {
		Select select=new Select(element);
		switch(selectBy) {
		case "value":
			select.selectByValue(value);
			break;
			
		case "visibleText":
			select.selectByVisibleText(value);
			break;
			
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
			
		}
		
	}
	
	public static void clickWebelementandHold(WebElement element) {
		Actions action=new Actions(driver);
		action.clickAndHold(element);
		
	}
	
	public static void pressKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);//keyEvent.VK_KEY
	}
	
	public static void releaseKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static void webdrivertWait(WebElement element, String condition) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		if(condition.equals("visibilityofelement")) {
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		else if(condition.equals("elementClickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	}
	
	public static void switchWindow(int windownum) {
		Set<String> allWindow = driver.getWindowHandles();
		List<String> list=new ArrayList<String>();
		list.addAll(allWindow);
		String windowId = list.get(windownum);
		driver.switchTo().window(windowId);
	}
	
	public static void executeJavascript(String javascript, WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript(javascript, element);
	}
		
	public static String excelRead(String fileLocation, String sheetName, int rowNum, int cellNum) throws IOException {
		File file = new File(fileLocation);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType cellType = cell.getCellType();
		String data = null;

		switch (cellType) {
		
		case STRING:
			String stringValue = cell.getStringCellValue();
			data = stringValue;
			break;

		case BOOLEAN:
			boolean booleanValue = cell.getBooleanCellValue();
			String booleancellvalue = Boolean.toString(booleanValue);
			data = booleancellvalue;
			break;

		case NUMERIC:
			double numericCellValue = cell.getNumericCellValue();
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yy");
				String format = dateformat.format(dateCellValue);
				data = format;
			} else {
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					data = Long.toString(round);
				} else {
					data = Double.toString(numericCellValue);
				}
			}
			break;
		}
		return data;
		
	}

}
