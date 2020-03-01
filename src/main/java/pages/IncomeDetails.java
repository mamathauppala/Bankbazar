package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.SeMethods;

public class IncomeDetails extends SeMethods {
	public IncomeDetails()
	{
		PageFactory.initElements(driver, this);
		
	}
	@CacheLookup
	@FindBy(xpath="//input[@name='netAnnualIncome']")
	WebElement eleInputIncome;
	@FindBy(linkText="Continue")
	WebElement eleclickContinue;
	
	public IncomeDetails enterIncome()
	{
		String salary="600000";
		type(eleInputIncome,salary);
		return this;
	}
	public BankDetails clickonContinue() throws InterruptedException
	{
		click(eleclickContinue);
		Thread.sleep(2000);
		return new BankDetails();
	}
	
	

}
