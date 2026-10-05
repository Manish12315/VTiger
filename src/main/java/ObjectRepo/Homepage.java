package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class Homepage {
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Leads']")
	private WebElement LeadsMenu;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactsMenu;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement accountsIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutOption;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadsMenu() {
		return LeadsMenu;
	}

	public WebElement getContactsMenu() {
		return contactsMenu;
	}

	public WebElement getAccountsIcon() {
		return accountsIcon;
	}

	public WebElement getSignoutOption() {
		return signoutOption;
	}
	
	public void clickOnLeadsMenu() {
		getLeadsMenu().click();
	}
	public void clickOnContactsMenu() {
		getContactsMenu().click();
	}
	public void logoutOpeartion(WebDriver driver) {
		new SeleniumUtility().mouseHoveringAction(driver, getAccountsIcon());
		getSignoutOption().click();
	}

}