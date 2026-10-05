package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(xpath="//img[@alt='Create Lead...']")
	private WebElement CreateNewLeadIcon;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateNewLeadIcon() {
		return CreateNewLeadIcon;
	}
	
	/**
	 * This is a business library to click on create new lead Icon
	 */
	public void clickOnCreateNewLeadIcon() {
		getCreateNewLeadIcon().click();
	
}

}