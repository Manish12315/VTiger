package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;


public class PomPractice {
	@FindBy(name="user_name")
	WebElement usernameTF;
    
	public PomPractice(WebDriver driver) {
		PageFactory.initElements(driver, null);
	}
	public static void main(String[] args) throws IOException {
		SeleniumUtility sutil=new SeleniumUtility();
		PropertiesUtility putil=new PropertiesUtility();
		WebDriver driver =new ChromeDriver();
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver,15);
		String URL=putil.getDataFromProperties("username");
		sutil.accessApplication(driver, URL);
		String UN=putil.getDataFromProperties("username");
		String PWD=putil.getDataFromProperties("password");
		WebElement usernameTF=driver.findElement(By.name("user_name"));
	}
}
