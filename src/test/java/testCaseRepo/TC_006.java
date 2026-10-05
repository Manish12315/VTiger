package testCaseRepo;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ObjectRepo.ContactsPage;
import ObjectRepo.CreatingNewContactPage;
import ObjectRepo.Homepage;
import genericUtility.BaseClass;

public class TC_006 extends BaseClass{
	@Test(groups = {"Smoke"})
	public void CON_003() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateNewContactIcon();
		String lastName=eutil.getDataFromExcel("Contacts", 7, 1);
		String title=eutil.getDataFromExcel("Contacts", 7, 2);
		String email=eutil.getDataFromExcel("Contacts", 7, 3);
		String mailingCity=eutil.getDataFromExcel("Contacts", 7, 4);
		String mailingState=eutil.getDataFromExcel("Contacts", 7, 5);
		String mailingCountry=eutil.getDataFromExcel("Contacts", 7, 6);
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(lastName, title, email, mailingCity, mailingState, mailingCountry);
		
	}

}


