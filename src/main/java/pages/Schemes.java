package pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.SeMethods;

public class Schemes extends SeMethods{
	public Schemes(){
		PageFactory.initElements(driver, this);		
	}

	//@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "js-offer-name") private
	List<WebElement> eleschemespage;

	public Schemes listmutualFunds(){
		for (WebElement eachScheme : eleschemespage) {
			System.out.println(eachScheme.getText());
			WebElement eleAmount = driver.findElementByXPath("//span[contains(text(),'"+eachScheme.getText()+"')]/following::span[@class='fui-rupee bb-rupee-xs']/..");
			System.out.println(eleAmount.getText());		
		}
		
		/*try {
			driver.findElementById("closeExitBlockerModal").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Pop up already closed");
		}*/
		return this;
	}
}




