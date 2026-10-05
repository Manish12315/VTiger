package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.CreatingNewLeadPage;
import ObjectRepo.Homepage;
import ObjectRepo.LeadsPage;
import genericUtility.BaseClass;
@Listeners(genericUtility.ListenersImplementation.class)
public class TC_003 extends BaseClass{
	@Test(groups = {"Regression" ,"Smoke"})
	public void LE_003() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateNewLeadIcon();
		String LastName=eutil.getDataFromExcel("Leads", 7, 1);
		String company=eutil.getDataFromExcel("Leads", 7, 2);
		String mobile=eutil.getDataFromExcel("Leads", 7, 3);
		String email=eutil.getDataFromExcel("Leads", 7, 4);
		String city=eutil.getDataFromExcel("Leads", 7, 5);
		String state=eutil.getDataFromExcel("Leads", 7, 6);
		String country=eutil.getDataFromExcel("Leads", 7, 7);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(LastName, company, mobile, email, city,state,country);
	}
	@Test

	public void m1(){
		System.out.println("hello selenium");
	}
}