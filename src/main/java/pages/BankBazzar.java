package pages;

import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class BankBazzar {

	@Test
	public void login() throws InterruptedException, IOException {

		int age = Integer.parseInt("28");
		String month = "Mar";
		String date = "11";
		String salary="670000";
		String bank = "SBI";

		//Launch the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Load the URL
		driver.get("https://www.bankbazaar.com/");		

		//Maximize
		driver.manage().window().maximize();

		//Hover INVESTMENTS
		Actions builder  = new Actions(driver);
		WebElement eleInvestments = driver.findElementByLinkText("INVESTMENTS");
		builder.moveToElement(eleInvestments).click().perform();		

		//Click Mutual Funds
		driver.findElementByLinkText("Mutual Funds").click();
		Thread.sleep(3000);

		//Click on Search for Mutual Funds
		driver.findElementByLinkText("Search for Mutual Funds").click();

		// Sleep
		Thread.sleep(5000);

		// Choose the age
		WebElement slider = driver.findElementByXPath("//div[@class='rangeslider__handle']");
		builder.dragAndDropBy(slider,(age-18)*8, 0).perform(); // 8 pixels for every age

		// Select the month
		driver.findElementByXPath("//a[contains(text(),'"+month+"')]").click();

		// Select the month
		driver.findElementByXPath("//div[contains(text(),'"+date+"')]").click();

		// Click Continue
		driver.findElementByLinkText("Continue").click();

		// Enter Salary
		driver.findElementByName("netAnnualIncome").sendKeys(salary);

		// Click Continue
		driver.findElementByLinkText("Continue").click();

		// Bank
		WebElement eleBank = driver.findElementByXPath("//span[text()='"+bank+"']");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(eleBank));
		
		// Select Bank
		eleBank.click();

		// Enter First Name
		driver.findElementByName("firstName").sendKeys("TestLeaf");
		
		// Click View Mutual Funds
		driver.findElementByLinkText("View Mutual Funds").click();
		
		// Get all Schemes
		List<WebElement> allSchemes = driver.findElementsByClassName("js-offer-name");
		for (WebElement eachScheme : allSchemes) {
			System.out.println(eachScheme.getText());
			WebElement eleAmount = driver.findElementByXPath("//span[contains(text(),'"+eachScheme.getText()+"')]/following::span[@class='fui-rupee bb-rupee-xs']/..");
			System.out.println(eleAmount.getText());
		}
	
		
		
	}
}