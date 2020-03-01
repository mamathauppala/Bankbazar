package pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wdMethods.SeMethods;

public class BankDetails extends SeMethods {
	
	public BankDetails ()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public PersonalDetails selectBank() throws InterruptedException
	{
		String bank = "SBI";
		WebElement eleBank = driver.findElementByXPath("//span[text()='"+bank+"']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(eleBank));
		eleBank.click();
		Thread.sleep(2000);
		return new PersonalDetails();
	}

}
