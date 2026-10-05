package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class CreatingNewLeadPage {
@FindBy(name="firstname")
private WebElement firstnameTextfield;
@FindBy(name="lastname")
private WebElement lastnameTextfield;
@FindBy(name="company")
private WebElement companyTextfield;
@FindBy(name="designation")
private WebElement titleTextfield;
@FindBy(name="leadsource")
private WebElement leadSourceDropdown;
@FindBy(name="noofemployees")
private WebElement noofemployeesTextfield;
@FindBy(name="mobile")
private WebElement mobileTextfield;
@FindBy(name="email")
private WebElement emailTextfield;
@FindBy(name="city")
private WebElement cityTextfield;
@FindBy(name="state")
private WebElement stateTextfield;
@FindBy(name="country")
private WebElement countryTextfield;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveButton;

public CreatingNewLeadPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getFirstnameTextfield() {
	return firstnameTextfield;
}

public WebElement getLastnameTextfield() {
	return lastnameTextfield;
}

public WebElement getCompanyTextfield() {
	return companyTextfield;
}

public WebElement getTitleTextfield() {
	return titleTextfield;
}

public WebElement getLeadSourceDropdown() {
	return leadSourceDropdown;
}

public WebElement getNoofemployeesTextfield() {
	return noofemployeesTextfield;
}

public WebElement getMobileTextfield() {
	return mobileTextfield;
}

public WebElement getEmailTextfield() {
	return emailTextfield;
}

public WebElement getCityTextfield() {
	return cityTextfield;
}

public WebElement getStateTextfield() {
	return stateTextfield;
}

public WebElement getCountryTextfield() {
	return countryTextfield;
}

public WebElement getSaveButton() {
	return saveButton;
}
/**
 * This is a business library to create a new lead
 * @param firstName
 * @param lastName
 * @param company
 */
public void createNewLead(String firstName,String lastName,String company) {
	getFirstnameTextfield().sendKeys(firstName);
	getLastnameTextfield().sendKeys(lastName);
	getCompanyTextfield().sendKeys(company);
	getSaveButton().click();
}
/**
 * This is a business library to create a new lead
 * @param lastName
 * @param company
 * @param title
 * @param leadSource
 * @param noOfEmp
 */
public void createNewLead(String lastName,String company,String title,
		String leadSource,String noOfEmp) {
	getLastnameTextfield().sendKeys(lastName);
	getCompanyTextfield().sendKeys(company);
	getTitleTextfield().sendKeys(title);
	new SeleniumUtility().selectOptionByValue(getLeadSourceDropdown(), leadSource);
	getNoofemployeesTextfield().sendKeys(noOfEmp);
	getSaveButton().click();
}
/**
 * This is a business library to create a new lead
 * @param lastName
 * @param company
 * @param mobile
 * @param email
 * @param city
 * @param state
 * @param country
 */
public void createNewLead(String lastName,String company,String mobile,
		String email,String city,String state,String country) {
	getLastnameTextfield().sendKeys(lastName);
	getCompanyTextfield().sendKeys(company);
	getMobileTextfield().sendKeys(mobile);
	getEmailTextfield().sendKeys(email);
	getCityTextfield().sendKeys(city);
	getStateTextfield().sendKeys(state);
	getCountryTextfield().sendKeys(country);
	getSaveButton().click();
}
}
