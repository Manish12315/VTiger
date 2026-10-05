package testCaseRepo;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.CreatingNewLeadPage;
import ObjectRepo.Homepage;
import ObjectRepo.LeadsPage;
import genericUtility.BaseClass;
@Listeners(genericUtility.ListenersImplementation.class)


public class TC_001  extends BaseClass{
	
	@Test(groups = {"Regression" ,"Smoke"},retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class)
	public void LE_001() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateNewLeadIcon();
		//Assert.fail();
		String firstName=eutil.getDataFromExcel("Leads",1,1);
		String lastName = eutil.getDataFromExcel("Leads",1,2);
		String company = eutil.getDataFromExcel("Leads",1,3);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(firstName, lastName, company);

	}
}
