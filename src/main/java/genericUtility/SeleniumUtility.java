package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
/**
 * This is a utility class which has Functionality from selenium library
 * @version 26-09-09
 */
public class SeleniumUtility {
	
	/**
	 * This is generic method to access a web application
	 * @param driver
	 * @param url
	 */
public void accessApplication(WebDriver driver,String url) {
	driver.get(url);
}
/**
 * This is a generic method to maximize the window
 * @param driver
 */
public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * This is a generic method to refresh the Webpage
 * @param driver
 */
public void refreshWebpage(WebDriver driver) {
	driver.navigate().refresh();
}
/**
 * This is a generic method to close the browser
 * @param driver
 */
public void closeBrowser(WebDriver driver) {
	driver.quit();
}
/**
 * This is a generic method to provide a implicit wait
 * @param driver
 * @param maxTime
 */
public void implicitWait(WebDriver driver,int maxTime) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	
}
/////////***********Handling dropdown******//////


/**
 * This is a generic method to select an option in dropdown using value attribute
 * @param drodownEle
 * @param value
 */
public void selectOptionByValue(WebElement drodownEle,String value) {
	Select sel=new Select(drodownEle);
	sel.selectByValue(value);
}
/**
 * This is a generic method to select an option in dropdown using VisibleText 
 * @param drodownEle
 * @param value
 */
public void selectOptionByVisibleText(WebElement drodownEle,String VisibleText) {
	Select sel=new Select(drodownEle);
	sel.selectByValue(VisibleText);
}
/**
 * This is a generic method to select an option in dropdown using Index 
 * @param drodownEle
 * @param value
 */
public void selectOptionByIndex(WebElement drodownEle,String Index) {
	Select sel=new Select(drodownEle);
	sel.selectByValue(Index);
}

/////////******HAndling Mouse Actions*******///////

/**
 * This is a generic method to perform mouse hovering action
 * @param driver
 * @param element
 */
public void mouseHoveringAction(WebDriver driver,WebElement element) {
	new Actions(driver).moveToElement(element).perform();
}
/**
 * This is a generic method to perform rightClickAction
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver,WebElement element) {
	new Actions(driver).moveToElement(element).perform();
}
/**
 * This is a generic method to perform dragAndDropAction
 * @param driver
 * @param element
 */
public void dragAndDropAction(WebDriver driver,WebElement draggableEle,WebElement dropEle) {
	new Actions(driver).dragAndDrop(draggableEle,dropEle).perform();
}
////////******Handling Alert popup*******/////

/**
 * This is a generic method to accept alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * This is a generic method to cancel alert popup
 * @param driver
 */
public void cancelAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
////*****Handling Frames*****/////

/**
 * This is a generic method to switch a frame using frame index
 * @param driver
 * @param index
 */
public void switchToFrameUsingIndex(WebDriver driver,int index) {
	driver.switchTo().frame(index);
	
}
/**
 * This is a generic method to switch a frame using frame Element
 * @param driver
 * @param index
 */
public void switchToFrameUsingFrameElement(WebDriver driver,WebElement frameEle) {
	driver.switchTo().frame(frameEle);
	
}
/////****Take WebPage ScreenShot****///////

/**
 * This is a generic method to take Screenshot of a Webpage
 * @param driver
 * @param fileName
 * @return
 * @throws IOException
 */
public String takeWebPageScreenshot(WebDriver driver,String fileName) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(".\\Screenshots\\"+fileName+".png");
			Files.copy(src, dest);
	return dest.getAbsolutePath();
}
}
