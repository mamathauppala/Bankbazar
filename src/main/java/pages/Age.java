package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.SeMethods;

public class Age extends SeMethods {
	public Age()
	{
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(xpath="//div[@class='rangeslider__handle']")
	WebElement eleAge;
	@FindBy(xpath="//div[contains(text(),'Your Birthday')]")
	WebElement actDoB;
	@FindBy(xpath="//a[text()='Continue']")
	WebElement eleContinue;
	
	
	
	public Age selectAge() throws InterruptedException
	{
		
		    int age = Integer.parseInt("28");
			Actions builder=new Actions(driver);
			builder.dragAndDropBy(eleAge,(age-18)*8, 0).perform();
			Thread.sleep(3000);
			return this;
	}
	public Age selectMonth() throws InterruptedException
	
	{
		
		String month = "Jun";
		driver.findElementByXPath("//a[contains(text(),'"+month+"')]").click();
		
		return this;
	}
	
	public Age selectDate()
	{
		String date="12";
		driver.findElementByXPath("//div[contains(text(),'"+date+"')]").click();
		return this;
	}
	public Age VerifyDateofBirth() 
	{
		String DoB=" 12 Jun 1990";
		String eDOB=actDoB.getText();
		String aEOB=eDOB.trim();
		System.out.println(aEOB);
		if(DoB.equals(aEOB))
		{
			System.out.println("DOB selected correctly");
		}
		else
		{
			System.out.println("DOB not selected correctly");
		}
		
		 return this;
	}
	public IncomeDetails clickonContinue() throws InterruptedException
	{
	click(eleContinue);
	Thread.sleep(3000);
		return new IncomeDetails();
	}
}
