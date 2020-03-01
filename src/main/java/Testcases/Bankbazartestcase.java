package Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Homepage;
import wdMethods.ProjectMethods;

public class Bankbazartestcase extends ProjectMethods {
	
	@BeforeClass(groups="common")
	public void setData() {
		testCaseName = "Bankbazartestcase";
		testCaseDescription ="Create a lead";
		category = "Smoke";
		author= "mamatha";
	
	}
	@Test
	
	public  void listMutualFunds() throws InterruptedException{
		
		Loadpage();
		new Homepage()
		.clickMutualFunds()
		.clickonSearchMutualFunds()
		.selectAge()
		.selectMonth()
		.selectDate()
		.VerifyDateofBirth()
		.clickonContinue()
		.enterIncome()
		.clickonContinue()
		.selectBank()
		.enterFirstname()
		.clickonViewMutualFunds()
		.listmutualFunds();
		
		
		
		
		
	}
	

}
