package testCaseRepo;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ObjectRepo.ContactsPage;
import ObjectRepo.CreatingNewContactPage;
import ObjectRepo.Homepage;
import genericUtility.BaseClass;

public class TC_005 extends BaseClass{
	@Test(groups = {"Regression" ,"Smoke"})
	public void CON_002() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateNewContactIcon();
		String lastName=eutil.getDataFromExcel("Contacts",4,1);
		String department = eutil.getDataFromExcel("Contacts",4,2);
		String email = eutil.getDataFromExcel("Contacts",4,3);
		String mobile = eutil.getDataFromExcel("Contacts",4,4);
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createNewContact(lastName, department, email, mobile);
		}

	}


