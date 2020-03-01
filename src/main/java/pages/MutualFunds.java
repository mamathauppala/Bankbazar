package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.SeMethods;

public class MutualFunds extends SeMethods {
	
	public MutualFunds()
	{
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(linkText="Search for Mutual Funds")
	WebElement eleSearchMutualFunds;
   public Age clickonSearchMutualFunds() throws InterruptedException
   {
	   
	  click(eleSearchMutualFunds);
	  Thread.sleep(3000);
	  
	   return new Age();
   }
}
	

