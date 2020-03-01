package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.SeMethods;

public class PersonalDetails extends SeMethods {

	public PersonalDetails()
	{

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement elefirstName;
	@FindBy(linkText="View Mutual Funds")
	WebElement eleviewMutual;
	
	public PersonalDetails enterFirstname()
	{
		String Name="Mamatha";
		type(elefirstName,Name);
		return this;
	}
	public Schemes clickonViewMutualFunds() throws InterruptedException
	{
		click(eleviewMutual);
		Thread.sleep(3000);
		
		
		return new Schemes();
		
		
	}
	
}
