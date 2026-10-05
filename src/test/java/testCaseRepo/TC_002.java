package testCaseRepo;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ObjectRepo.CreatingNewLeadPage;
import ObjectRepo.Homepage;
import ObjectRepo.LeadsPage;
import genericUtility.BaseClass;

public class TC_002 extends BaseClass {
	@Test(groups = {"Smoke"})
	public void LE_001() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateNewLeadIcon();
		String LastName=eutil.getDataFromExcel("Leads", 4, 1);
		String company=eutil.getDataFromExcel("Leads", 4, 2);
		String title=eutil.getDataFromExcel("Leads", 4, 3);
		String leadSource=eutil.getDataFromExcel("Leads", 4, 4);
		String noOfEmp=eutil.getDataFromExcel("Leads", 4, 5);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(LastName, company, title, leadSource, noOfEmp);
	}

}

