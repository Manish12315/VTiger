package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ObjectRepo.Homepage;
import ObjectRepo.LoginPage;


public class BaseClass {

	public WebDriver driver;
	public SeleniumUtility sutil = new SeleniumUtility();
	public PropertiesUtility putil = new PropertiesUtility();
	public ExcelUtility eutil= new ExcelUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("DB Connection created");
	}
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void bcConfig(@Optional("chrome")String BROWSER) throws IOException {
		String browser = System.getProperty("browser");
		if(browser!=null) {
			BROWSER = browser;
		}
		if(BROWSER.equals("chrome"))
			 driver = new ChromeDriver();
		else if(BROWSER.equals("edge"))
			 driver = new EdgeDriver();
		else if(BROWSER.equals("firefox"))
			 driver = new FirefoxDriver();
		else if(BROWSER.equals("safari"))
			 driver = new SafariDriver();
		else
		 driver = new ChromeDriver();
		sDriver=driver;
	sutil.maximizeWindow(driver);
	sutil.implicitWait(driver, 15);
	String URL = putil.getDataFromProperties("url");
	sutil.accessApplication(driver, URL);
	System.out.println("Browser launched successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
	String UN = putil.getDataFromProperties("username");
	String PWD = putil.getDataFromProperties("password");
    LoginPage lp=new LoginPage(driver);
	lp.logintoapplication(UN, PWD);
	System.out.println("Login done Successfully");
	}
	
	@AfterMethod(alwaysRun = true)
public void amConfig(){
        Homepage hp = new Homepage(driver);
		hp.logoutOpeartion(driver);
		System.out.println("Logout done Successfully");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
 public void asConfig() {
	System.out.println("DB connection closed");	
	}
}
