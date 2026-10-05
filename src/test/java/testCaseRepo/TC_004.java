package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ObjectRepo.ContactsPage;
import ObjectRepo.CreatingNewContactPage;
import ObjectRepo.Homepage;
import genericUtility.BaseClass;

public class TC_004 extends BaseClass{
	@Test(groups = {"Regression"})
	public void CON_001() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.clickOnContactsMenu();
		ContactsPage lp=new ContactsPage(driver);
		lp.clickOnCreateNewContactIcon();
		String firstName=eutil.getDataFromExcel("contacts",1,1);
		String lastName = eutil.getDataFromExcel("contacts",1,2);
		String tittle = eutil.getDataFromExcel("contacts",1,3);
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createNewContact(firstName, lastName, tittle);
	}
}
	


