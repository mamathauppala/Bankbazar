package pages;


import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bankbazar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int age = Integer.parseInt("28");
		String month = "Mar";
		String date = "11";
		String salary="670000";
		String bank = "SBI";
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable - notifications");
		ChromeDriver driver=new ChromeDriver(op);
		driver.get("https://www.bankbazaar.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Actions builder =new Actions(driver);
		WebElement eleInvestments=driver.findElementByLinkText("INVESTMENTS");
		//WebElement eleMutualFunds=driver.findElementByLinkText("Mutual Funds");
		builder.moveToElement(eleInvestments).pause(2000).perform();;
		driver.findElementByLinkText("Mutual Funds").click();
		Thread.sleep(2000);
		driver.findElementByLinkText("Search for Mutual Funds").click();
		Thread.sleep(2000);
		WebElement current=driver.findElementByXPath("//div[@class='rangeslider__handle']");
		
			Actions builder1=new Actions(driver);
			builder1.dragAndDropBy(current,(age-18)*8, 0).perform();
			driver.findElementByXPath("//a[contains(text(),'"+month+"')]").click();
			driver.findElementByXPath("//div[contains(text(),'"+date+"')]").click();

			// Click Continue
			driver.findElementByLinkText("Continue").click();
			String DoB="11 Mar 1990";
			WebElement actDOB=driver.findElementByXPath("//div[contains(text(),'Your Birthday')]");
			String eDOB=actDOB.getText();	
			if(DoB.equals(eDOB))
			{
				System.out.println("DOB selected correctly");
			}
			else
			{
				System.out.println("DOB not selected correctly");
			}
			driver.findElementByLinkText("Continue").click();
			driver.findElementByName("netAnnualIncome").sendKeys(salary);
			driver.findElementByLinkText("Continue").click();
			Thread.sleep(2000);
			
			
			// Bank
			WebElement eleBank = driver.findElementByXPath("//span[text()='"+bank+"']");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(eleBank));
			
			// Select Bank
			eleBank.click();
			Thread.sleep(2000);

			// Enter First Name
			driver.findElementByName("firstName").sendKeys("TestLeaf");
			Thread.sleep(2000);
			
			// Click View Mutual Funds
			driver.findElementByLinkText("View Mutual Funds").click();
			Thread.sleep(8000);
			
			
			
			List<WebElement> allSchemes = driver.findElementsByClassName("js-offer-name");
			for (WebElement eachScheme : allSchemes) {
				System.out.println(eachScheme.getText());
				WebElement eleAmount = driver.findElementByXPath("//span[contains(text(),'"+eachScheme.getText()+"')]/following::span[@class='fui-rupee bb-rupee-xs']/..");
				System.out.println(eleAmount.getText());
			}
			
			Thread.sleep(5000);
			try {
				driver.findElementById("closeExitBlockerModal").click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Pop up already closed");
			}
		
			
			/*List<WebElement> pop=driver.findElements(By.xpath("//body[@class='offers-page class-mutual-fund  modal-open']"));
			int Value=pop.size();
			if (Value==0)
			{
				System.out.println("Pop up already closed");
			}
			else
			{
				driver.findElementById("closeExitBlockerModal").click();
			}*/
			
		
			
			
			
			
		
				
		

	

	}
}
