package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//1.declaring the webelement

public class LoginPage {
 @FindBy(name="user_name")
 private WebElement usernameTextfield;
  
 @FindBy(xpath="//input[@type='password']")
 private WebElement passwordTextField;
 
 @FindBy(id="submitButton")
 private WebElement loginButton;
 
 //2.intilizing the webelement
 
 public LoginPage(WebDriver driver) {
	 PageFactory.initElements(driver,this);
 }
 //getter method
 public WebElement getusernameTextField() {
	return usernameTextfield;
	 
 }
 public WebElement getpasswordTextfield() {
	return passwordTextField;
	 
 }
 public WebElement getloginButton() {
	 return loginButton;
 }
 //utilizing WeEelements
 /**
  * this is a business library to perform login to application
  * @param UN
  * @param PWD
  */
 public void logintoapplication (String UN,String PWD) {
	 getusernameTextField().sendKeys(UN);
	 getpasswordTextfield().sendKeys(PWD);
	 getloginButton().click();
	 
 }
}