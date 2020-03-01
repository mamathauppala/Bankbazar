package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.SeMethods;

public class Homepage extends SeMethods {
	public Homepage ()
	{
		
			PageFactory.initElements(driver, this);
	}
		@CacheLookup
		@FindBy(linkText="INVESTMENTS")
		WebElement eleInvestments;
		@FindBy(linkText="Mutual Funds")
		WebElement eleMutualFunds;
		
		public MutualFunds  clickMutualFunds() throws InterruptedException 
		
		{
			Actions builder =new Actions(driver);
			builder.moveToElement(eleInvestments).pause(2000).perform();;
			click(eleMutualFunds);
			Thread.sleep(3000);
			
			
			return new MutualFunds();
		}
		
	}
	


